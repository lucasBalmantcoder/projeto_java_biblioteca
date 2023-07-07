
///REPOSITORIO BASE
//com ela as outras exception só precisam chamar ela e mudar o conteudo
//da message
package repository;


public class RepositoryException extends Exception {
    
    public RepositoryException(String message) {

        super(message);

    }
    
}
