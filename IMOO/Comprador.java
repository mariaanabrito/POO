import java.io.*;
import java.util.Set;
import java.util.TreeSet;

/**
 *  Classe que representa um comprador e os seus imóveis favoritos.
 */
public class Comprador extends Utilizador implements UtilizadorComum, Serializable
{
   private Set<Imovel> favoritos;
   
   /**
   * Cria uma instância de comprador.
   */
   public Comprador()
   {
       super();
       favoritos = new TreeSet<Imovel>();
   }
   
   /**
    * Construtor por parâmetro.
   */
   public Comprador(String ml, String n, String p, String md, String d, TreeSet<Imovel> f)
   {
        super(ml, n, p, md, d);
        setFavoritosComprador(f);
   }
   
   /**
    * Construtor de cópia
   */
   public Comprador(Comprador c)
    {
        super(c);
        favoritos = c.getFavoritosComprador();
    }
    
    /**
     * Devolve uma cópia desta instância 
     */
    public Comprador clone()
    {
        return new Comprador(this);
    }
    
    /**
     * Compara a igualdade com outro objecto
     */
    public boolean equals(Object o)
    {
        if (o == null) return false;
        if (o == this) return true;
        if (o.getClass() != this.getClass()) return false;
        Comprador c = (Comprador) o;
        if (super.equals(c) == false) return false;
        if (this.favoritos.equals(c.getFavoritosComprador()) == false) return false;
        return true;
    }
    
    /**
     * Devolve uma representação no formato textual
     */
    public String toStringComp()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Lista dos Favoritos do Comprador:\n");
        for(Imovel i: this.favoritos)
        {
            sb.append(i.toStringParaComprador());
        }
        sb.append("\n");
        return sb.toString();
    }
    
    /**
     * Retorna os imóveis favoritos do comprador
     */
    public Set<Imovel> getFavoritosComprador()
    {
        Set<Imovel> novo = new TreeSet<Imovel>();
        
        for(Imovel i: this.favoritos)
        {
            novo.add(i.clone());
        }
        
        return novo;
    }
    
    /**
   * Define os imóveis favoritos do comprador através do parâmetro.
   */
    public void setFavoritosComprador(TreeSet<Imovel> is)
    {
        this.favoritos = new TreeSet<Imovel>();
        
        for(Imovel i: is)
        {
            this.favoritos.add(i.clone());
        }
    }
    
    /**
    * Adiciona um imóvel aos imóveis favoritos.
   */
    public void adicionaImovelFavorito(Imovel i)
    {
        this.favoritos.add(i.clone());
    }
}
