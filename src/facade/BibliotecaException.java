package facade;


//todas as classe com ex��es devem extender a 'exception'
public class BibliotecaException extends Exception {
    public BibliotecaException(String message) {
        super(message);
    }

    public BibliotecaException(String message, Throwable e) {
        super(message, e);
    }

    
}
