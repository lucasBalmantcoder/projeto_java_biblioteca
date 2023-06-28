package teste;

public class Banco_Exception extends Exception{
    public Banco_Exception(String message){
        super(message);
    }
    
    public Banco_Exception(String message, Throwable e){
        super(message, e);

    }
}
