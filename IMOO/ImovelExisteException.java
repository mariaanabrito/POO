
/**
 * Exception correspondente a tentar adicionar um imóvel existente.
 */
public class ImovelExisteException extends Exception
{
    public ImovelExisteException(String msg)
    {
        super(msg);
    }
}
