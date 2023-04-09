package Transport;

import java.io.PrintStream;

public class DiagnosticNotAllowedException extends Exception{

    public DiagnosticNotAllowedException (String message){super(message);}
    public DiagnosticNotAllowedException()
    {
    }

    @Override
    public void printStackTrace(PrintStream s) {
        super.printStackTrace(s);
    }
}
