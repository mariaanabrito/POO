/**
 * Exception correspondente a tentar aceder a locais que não possui permissão.
 */
public class SemAutorizacaoException extends Exception
{
   public SemAutorizacaoException(String msg)
   {
       super(msg);
    }
}
