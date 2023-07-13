package facade;


//todas as classe com exções devem extender a 'exception'
public class BibliotecaException extends Exception {
    public BibliotecaException(String message) {
        super(message);
    }

    public BibliotecaException(String message, Throwable e) {
        super(message, e);
    }

    
}
