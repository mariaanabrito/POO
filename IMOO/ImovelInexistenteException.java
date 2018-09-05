
/**
 * Exception correspondente a tentar aceder a um imóvel inexistente.
 */
public class ImovelInexistenteException extends Exception
{
    public ImovelInexistenteException(String msg)
    {
        super(msg);
    }
}
