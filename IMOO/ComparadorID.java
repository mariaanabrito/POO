import java.util.Comparator;
/**
 * Comparador de id entre dois imóveis.
 */
public class ComparadorID implements Comparator<Imovel>
{
    public int compare(Imovel i1, Imovel i2)
    {
        String id1 = i1.getId();
        String id2 = i2.getId();
        
        return id1.compareTo(id2);
    }
}
