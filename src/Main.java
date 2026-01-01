import AST.core.AstNode;
import AST.python.ProgramNode;
import AST.Template.HtmlDocumentNode;

//import Visitor.AstPrinterVisitor;
import Visitor.PythonAstBuilder;
import Visitor.TemplateAstBuilder;


import Grammer.*;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final String PY_FILE =
            "C:\\Users\\Abdullah\\Desktop\\complier\\src\\testparser.py";

    // اجعلها مجلد templates إن كان موجوداً:
    // "C:\\Users\\Abdullah\\Desktop\\complier\\src\\templates"
    private static final String TEMPLATE_DIR =
            "C:\\Users\\Abdullah\\Desktop\\complier\\templates";

    public static void main(String[] args) {
        try {
            // =========================
            // 1) PYTHON: Parse + AST
            // =========================
            ProgramNode pyAst = parsePythonFile(PY_FILE);
//            printAst("PYTHON AST", pyAst);
            System.out.println("\n==============================");
            System.out.println("PYTHON AST");
            System.out.println("==============================");

            // =========================
            // 3) TEMPLATE: لكل ملفات .html
            // =========================
            List<Path> htmlFiles = findHtmlFiles(Paths.get(TEMPLATE_DIR));
            if (htmlFiles.isEmpty()) {
                System.out.println("\nلا يوجد ملفات .html ضمن: " + TEMPLATE_DIR);
                return;
            }

            for (Path html : htmlFiles) {
                HtmlDocumentNode tplAst = parseTemplateFile(html.toString());
                printAst("TEMPLATE AST :: " + html.getFileName(), tplAst);

            }

        } catch (Exception e) {
            System.err.println("حدث خطأ أثناء التنفيذ:");
            e.printStackTrace();
        }
    }

    // =========================================================
    // Python Parsing
    // =========================================================
    private static ProgramNode parsePythonFile(String filePath) throws IOException {
        CharStream input = CharStreams.fromFileName(filePath);

        lexerpython lexer = new lexerpython(input);
        lexer.removeErrorListeners();
        lexer.addErrorListener(new VerboseErrorListener("PY-LEXER"));

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        parserpython parser = new parserpython(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(new VerboseErrorListener("PY-PARSER"));
        parser.setErrorHandler(new DefaultErrorStrategy());

        ParseTree tree = parser.program();

        PythonAstBuilder builder = new PythonAstBuilder();
        return (ProgramNode) builder.visit(tree);
    }

    // =========================================================
    // Template Parsing
    // =========================================================
    private static HtmlDocumentNode parseTemplateFile(String filePath) throws IOException {
        CharStream input = CharStreams.fromFileName(filePath);

        TemplateLexer lexer = new TemplateLexer(input);
        lexer.removeErrorListeners();
        lexer.addErrorListener(new VerboseErrorListener("TPL-LEXER"));

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        TemplateParser parser = new TemplateParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(new VerboseErrorListener("TPL-PARSER"));
        parser.setErrorHandler(new DefaultErrorStrategy());

        ParseTree tree = parser.htmlDocument();

        TemplateAstBuilder builder = new TemplateAstBuilder();
        return (HtmlDocumentNode) builder.visit(tree);
    }

    // =========================================================
    // AST Printing
    // =========================================================
    // =========================================================
// AST Printing (3 methods)
// =========================================================
    private static void printAst(String title, AstNode root) {
        System.out.println("\n==============================");
        System.out.println(title);
        System.out.println("==============================");

        if (root == null) {
            System.out.println("(AST is null)");
            return;
        }

        // -----------------------------------------------------
        // 1) AstPrinterVisitor (generic tree printer)
        // -----------------------------------------------------
//        System.out.println("\n---- AST via AstPrinterVisitor ----");
//        AstPrinterVisitor printer = new AstPrinterVisitor();
//        System.out.print(printer.print(root));

        // -----------------------------------------------------
        // 2) pretty() from AstNode
        // -----------------------------------------------------
        System.out.println("\n---- AST via pretty() ----");
        System.out.print(root.pretty());

        // -----------------------------------------------------
        // 3) toString() from each Node
        // -----------------------------------------------------
//        System.out.println("\n---- AST via toString() ----");
//        System.out.print(root.toString());
    }


    // =========================================================
    // Find all .html files recursively
    // =========================================================
    private static List<Path> findHtmlFiles(Path dir) throws IOException {
        List<Path> out = new ArrayList<>();
        if (!Files.exists(dir)) return out;

        Files.walk(dir)
                .filter(Files::isRegularFile)
                .filter(p -> p.toString().toLowerCase().endsWith(".html"))
                .forEach(out::add);

        return out;
    }

    // =========================================================
    // Error Listener
    // =========================================================
    private static class VerboseErrorListener extends BaseErrorListener {
        private final String phase;

        VerboseErrorListener(String phase) { this.phase = phase; }

        @Override
        public void syntaxError(Recognizer<?, ?> recognizer,
                                Object offendingSymbol,
                                int line,
                                int charPositionInLine,
                                String msg,
                                RecognitionException e) {

            String symbolText = "";
            if (offendingSymbol instanceof Token) {
                Token t = (Token) offendingSymbol;
                symbolText = " offending='" + t.getText() + "'";
            }

            System.err.println("[" + phase + " ERROR] line " + line + ":" + charPositionInLine +
                    symbolText + " msg=" + msg);
        }
    }
}