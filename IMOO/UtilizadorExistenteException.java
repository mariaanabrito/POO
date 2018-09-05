/**
 * Exception correspondente a tentar adicionar um utilizador já existente.
 */
public class UtilizadorExistenteException extends Exception
{
    public UtilizadorExistenteException(String msg)
    {
        super(msg);
    }
}
