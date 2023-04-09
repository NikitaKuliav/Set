package Transport;

public interface Diagnosticable {
    void passDiagnostic() throws DiagnosticNotAllowedException;
}
