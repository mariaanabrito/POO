import java.util.Set;
import java.util.TreeSet;
import java.util.List;
import java.util.ArrayList;
import java.io.*;

/**
  * Classe que representa um vendedor juntamente com o seu portfólio de imóveis à venda,
  * o histórico de imóveis vendidos e as consultas dos seus imóveis.
  */
public class Vendedor extends Utilizador implements UtilizadorComum, Serializable
{
    private Set<Imovel> portfolio;
    private Set<Imovel> historico;
    private Set<Consulta> consultas;
    
    /**
     * Cria um construtor de comprador.
     */
    public Vendedor()
    {
        super();
        portfolio = new TreeSet<Imovel>();
        historico = new TreeSet<Imovel>();
        consultas = new TreeSet<Consulta>();
    }
    
    /**
     * Construtor por parâmentro.
     */
    public Vendedor(String ml, String n, String p, String md, String d, TreeSet<Imovel> pf, TreeSet<Imovel> h, TreeSet<Consulta> c)
    {
        super(ml, n, p, md, d);
        setPortfolioVendedor(pf);
        setHistoricoVendedor(h);
        setConsultasVendedor(c);
    }
    
     /**
     * Construtor de cópia
     */
    public Vendedor(Vendedor v)
    {
        super(v);
        portfolio = v.getPortfolioVendedor();
        historico = v.getHistoricoVendedor();
        consultas = v.getConsultasVendedor();
    }
    
    /**
     * Devolve uma cópia desta instância 
     */
    public Vendedor clone()
    {
        return new Vendedor(this);
    }
    
    /**
     * Compara a igualdade com outro objecto
     */
    public boolean equals(Object o)
    {
        if (o == null) return false;
        if (o == this) return true;
        if (o.getClass() != this.getClass()) return false;
        Vendedor v = (Vendedor) o;
        if (super.equals(v) == false) return false;
        if (this.portfolio.equals(v.getPortfolioVendedor()) == false) return false;
        if (this.historico.equals(v.getHistoricoVendedor()) == false) return false;
        if(this.consultas.equals(v.getConsultasVendedor()) == false) return false;
        return true;
    }
    
    /**
     * Devolve uma representação no formato textual
     */
    public String toStringVend()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Portfólio do Vendedor:\n");
        for(Imovel i: this.portfolio)
        {
            sb.append(i.toStringParaVendedor());
        }
        sb.append("\n");
        sb.append("Histórico do Vendedor:\n");
        for(Imovel i: this.historico)
        {
            sb.append(i.toStringParaVendedor());
        }
        sb.append("\n");
        sb.append("Consultas do Vendedor:\n"); 
        for(Consulta i: this.consultas)
        {
            sb.append(i.toString());
        }
        sb.append("\n");
        return sb.toString();
    }
    
    /**
      * Retorna o portfólio do vendedor. 
      */
    public Set<Imovel> getPortfolioVendedor()
    {
        Set<Imovel> novo = new TreeSet<Imovel>();
        
        for(Imovel i: this.portfolio)
        {
            novo.add(i.clone());
        }
        
        return novo;
    }
    
    /**
      * Retorna o histórico do vendedor.
      */
    public Set<Imovel> getHistoricoVendedor()
    {
        Set<Imovel> novo = new TreeSet<Imovel>();
        
        for(Imovel i: this.historico)
        {
            novo.add(i.clone());
        }
        
        return novo;
    }
    
    /**
      * Retorna as consultas do vendedor. 
      */
    public Set<Consulta> getConsultasVendedor()
    {
        Set<Consulta> novo = new TreeSet<Consulta>();
        
        for(Consulta c : consultas)
            novo.add(c);
        return novo;
    }
    
    /**
      * Define o portfólio do vendedor através do parâmetro. 
      */
    public void setPortfolioVendedor(TreeSet<Imovel> is)
    {
        this.portfolio = new TreeSet<Imovel>();
        
        for(Imovel i: is)
        {
            this.portfolio.add(i.clone());
        }
    }
    
    /**
      * Define o histórico do vendedor através do parâmetro. 
      */
    public void setHistoricoVendedor(TreeSet<Imovel> is)
    {
        this.historico = new TreeSet<Imovel>();
        
        for(Imovel i: is)
        {
            this.historico.add(i.clone());
        }
    }
    
    /**
      * Define as consultas do vendedor através do parâmetro. 
      */
    public void setConsultasVendedor(TreeSet<Consulta> cs)
    {
        consultas = new TreeSet<Consulta>();
        for(Consulta c : consultas)
            consultas.add(c);
    }
    
    /**
      *  Adiciona o imóvel ao portfólio.
      */
    public void adicionaImovelPortfolio(Imovel i)
    {
        this.portfolio.add(i.clone());
    }
    
    /**
      *  Adiciona um imóvel ao histórico.
      */
    public void adicionaImovelHistorico(Imovel i)
    {
        this.historico.add(i.clone());
    }
    
    /**
      *  Remove um imóvel do portfólio.
      */
    public void removeImovelPortfolio(Imovel i)
    {
        this.portfolio.remove(i);
    }
    
    /**
      *  Remove um imóvel do histórico.
      */
    public void removeImovelHistorico(Imovel i)
    {
        this.historico.remove(i);
    }
    
    /**
      *  Verifica se existe um imóvel.
      */
    public boolean existeImovel(Imovel i)
    {
        for(Imovel im : portfolio)
            if(i.equals(im) == true) return true;
        return false;
    }
    
}
