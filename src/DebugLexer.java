import org.antlr.v4.runtime.*;

import Grammer.*;

public class DebugLexer {
    public static void main(String[] args) throws Exception {

        // اقرأ ملف Python الذي فيه Flask
        CharStream input = CharStreams.fromFileName("C:\\Users\\Abdullah\\Desktop\\complier\\src\\testparser.py");

        lexerpython lexer = new lexerpython(input);

        Token t;
        while (true) {
            t = lexer.nextToken();
            String tokenName = lexer.getVocabulary().getSymbolicName(t.getType());
            System.out.printf("%-12s line=%-3d col=%-3d text=%s%n",
                    tokenName, t.getLine(), t.getCharPositionInLine(),
                    t.getText().replace("\n", "\\n"));
            if (t.getType() == Token.EOF) break;
        }
    }
}
