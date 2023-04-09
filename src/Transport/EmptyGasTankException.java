package Transport;

public class EmptyGasTankException extends RuntimeException{
    public EmptyGasTankException(String message){super(message);}
    public void causeOfFailure(Transport object){
        System.out.println("В транспорте " + object + " нет топлива");
    }

}
