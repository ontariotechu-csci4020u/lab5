import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.*;

class ErrorListener extends BaseErrorListener {
    private String name;
    public ErrorListener(String name) {
        this.name = name;
    }
	@Override 
	public void syntaxError(
			Recognizer<?, ?> recognizer, 
			Object offendingSymbol, 
			int line, 
			int charPositionInLine, 
			String msg, 
			RecognitionException e) 
		throws ParseCancellationException { 
		throw new ParseCancellationException(
                "[" + this.name + "] failed."); 
	} 
}
