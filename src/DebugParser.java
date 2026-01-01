import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import Grammer.*;

public class DebugParser {
    public static void main(String[] args) throws Exception {
        String path = "C:\\Users\\Abdullah\\Desktop\\complier\\src\\testparser.py";

        CharStream input = CharStreams.fromFileName(path);
        lexerpython lexer = new lexerpython(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        tokens.fill(); // اجلب كل التوكنات

        // اطبع آخر 30 توكن للتأكد من DEDENT قبل EOF
        int start = Math.max(0, tokens.getTokens().size() - 30);
        for (int i = start; i < tokens.getTokens().size(); i++) {
            Token t = tokens.getTokens().get(i);
            String name = lexer.getVocabulary().getSymbolicName(t.getType());
            System.out.printf("%-10s line=%-3d col=%-3d text=%s%n",
                    name, t.getLine(), t.getCharPositionInLine(),
                    t.getText().replace("\n", "\\n"));
        }

        // جرّب parsing
        parserpython parser = new parserpython(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(new DiagnosticErrorListener());

        ParseTree tree = parser.program();
        System.out.println("Parsed OK");
        System.out.println("Input file = " + path);
        System.out.println("Working dir = " + System.getProperty("user.dir"));
        System.out.println(lexerpython.class.getProtectionDomain().getCodeSource().getLocation());
        System.out.println(parserpython.class.getProtectionDomain().getCodeSource().getLocation());

    }
}
