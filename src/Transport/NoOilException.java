package Transport;

public class NoOilException extends RuntimeException{
    public NoOilException (String message){super(message);}
    public void causeOfFailure(Transport object){
        System.out.println("В транспорте " + object + " нет масла");
    }
}
