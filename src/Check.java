import org.antlr.v4.runtime.*;
import static java.lang.System.out;

public class Check {
    public static void file(String filename) throws Exception {
        CalcLexer lexer = new CalcLexer(
                CharStreams.fromFileName(filename));
        lexer.removeErrorListeners();
        lexer.addErrorListener(new ErrorListener("CalcLexer"));
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        CalcParser parser = new CalcParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(new ErrorListener("CalcParser"));

        try {
            parser.program();
            out.printf("\"%s\" is good.\n", filename);
        } catch(Exception e) {
            out.printf("\"%s\" is bad.\n%s\n", filename, e.getMessage());
        }
    }
}
