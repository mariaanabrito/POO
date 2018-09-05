import java.util.Comparator;
/**
 *Comparador de preços entre dois imóveis.
 */
public class ComparadorPreco implements Comparator<Imovel>
{
    public int compare(Imovel i1, Imovel i2)
    {
        int p1 = i1.getPrecoPedido();
        int p2 = i2.getPrecoPedido();
        
        if(p1 == p2) return 0;
            else if(p1 > p2) return 1;
            
        return -1;
    }
}
