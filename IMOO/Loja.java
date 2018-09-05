import java.io.*;
/**
 * Class Loja armazena todos os dados referentes à mesma, sendo chamada por outras instâncias.
 * Esta classe contém o tipo de négocio, a área, se possui WC e o número da porta
 */
public class Loja extends Imovel implements ImovelComum, Serializable
{
    private String negocio;
    private double area;
    private boolean wc;         
    private int porta;

    /**
     *  Cria uma instância de Loja
     */
    public Loja()
    {
        super();
        negocio = "";
        area = 0.0;
        wc = false;
        porta = 0;
    }

     /**
     * Construtor por parâmetro 
     */
    public Loja(String r, String e, String i, int pp, int pm, int c, String n, double a, boolean w, int p)
    {
        super(r, e, i, pp, pm, c);
        negocio = n;
        area = a;
        wc = w;
        porta = p;
    }

    /**
     * Construtor por cópia 
     */
    public Loja(Loja l)
    {
        super(l);
        negocio = l.getNegocio();
        area = l.getArea();
        wc = l.getWc();
        porta = l.getPorta();
    }
    
    /**
     * Retorna o tipo de negócio. 
     */
    public String getNegocio()
    {
        return negocio;
    }
    
    /**
     * Retorna a área da loja 
     */
    public double getArea()
    {
        return area;
    }
    
    /**
     *  Retorna se tem WC ou não
     */
    public boolean getWc()
    {
       return wc;
    }
    
    /**
     * Retorna o número da porta 
     */
    public int getPorta()         
    {
        return porta;
    }
    
    /**
     * Define o tipo de negócio através do parâmetro 
     */
    public void setNegocio(String n)
    {
        negocio = n; 
    }
    
    /**
     *  Define a área da loja através do parâmetro
     */
    public void setArea(double a) 
    {
        area = a; 
    }
    
    /**
     * Define se a  loja tem WC ou não através do parâmetro.
     */
    public void setWc(boolean w)
    {
        wc = w;
    }
    
    /**
     *  Define o número da porta através do parâmetro.
     */
    public void setPorta(int p)
    {
        porta = p; 
    }

    /**
     *  Compara a igualdade com outro objeto
     */
    public boolean equals(Object o)
    {
        if (o == null) return false;
        if (o == this) return true;
        if (this.getClass() != o.getClass()) return false;
        Loja obj = (Loja) o;
        if (obj.getNegocio().equals(negocio) == false) return false;
        if (area != obj.getArea()) return false;
        if (wc != obj.getWc()) return false;
        if (porta != obj.getPorta()) return false;
        if (super.equals(obj) == false) return false;
        return true;
    }
    
    /**
     *  Devolve uma cópia desta instância
     */
    public Loja clone()
    {
        return new Loja(this);
    }
    
    /**
     *  Devolve uma representação no formato textual.
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()); 
        sb.append("Tipo de Negócio Viável: "); sb.append(negocio); sb.append("\n");
        sb.append("Área: "); sb.append(area); sb.append("\n");
        sb.append("Possui WC: "); sb.append(wc); sb.append("\n");
        sb.append("Número da Porta: "); sb.append(porta); sb.append("\n");
        
        return sb.toString();
    }
}