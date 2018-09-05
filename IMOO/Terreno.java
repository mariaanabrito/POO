import java.io.*;
/**
 * Classe que implementa um terreno em que se conhece se o terreno é próprio para construção, o diâmetro das canalizações(me milímetros), os kWh máximos suportados 
 * pela rede elétrica(se instalados) , e se existe o acesso à rede de esgotos. 
 */
public class Terreno extends Imovel implements ImovelComum, Serializable
{
    private int constr;
    private double canal, kwh;
    private boolean esgotos;
    
    /**
     * Cria uma instância de Terreno.
     */
    public Terreno()
    {
        super();
        constr = 0;
        canal = 0.0;
        kwh = 0.0;
        esgotos = false;
    }
    
    /**
     * Construtor por parâmetros 
     */
    public Terreno(String r, String es, String i, int pp, int pm, int c, int ctr, double cnl, double k, boolean e)
    {
        super(r, es, i, pp, pm, c);
        constr = ctr;
        canal = cnl;
        kwh = k;
        esgotos = e;
    }
    
    /**
     *  Construtor de cópia
     */
    public Terreno(Terreno terr)
    {
        super(terr);
        constr = terr.getConstr();
        canal = terr.getCanal();
        kwh = terr.getKWH();
        esgotos = terr.getEsgotos();
    }
    
    /**
     * Retorna se o terreno suporta construção para habitação ou armazéns
     */
    public int getConstr()
    {
        return constr;
    }
    
    /**
     * Retorna o diâmetro das canalizações 
     */
    public double getCanal()
    {
        return canal;
    }
    
    /**
     * Retorna kWh máximo suportado. 
     */
    public double getKWH()
    {
        return kwh;
    }
    
    /**
     *  Retorna se o terreno suporta acesso à rede de esgotos.
     */
    public boolean getEsgotos()
    {
        return esgotos;
    }
    
    /**
     *  Define se o terreno suporta construção através do parâmetro
     */
    public void setConstr(int ctr)
    {
        constr = ctr;
    }
    
    /**
     * Define o diâmetro da canalização através do parâmetro 
     */
    public void setCanal(double cnl)
    {
        canal = cnl;
    }
    
    /**
     *  Define kWh máximo através do parâmetro
     */
    public void setKWH(double kwh)
    {
        this.kwh = kwh;
    }
    
    /**
     *  Define se o terreno suporta canalização através do parâmetro
     */
    public void setEsgotos(boolean e)
    {
        esgotos = e;
    }
    
    /**
     *  Compara a igualdade com outro objeto
     */
    public boolean equals(Object o)
    {
        if (o == null) return false;
        if (o == this) return true;
        if (this.getClass() != o.getClass()) return false;
        Terreno obj = (Terreno) o;
        if (constr != obj.getConstr()) return false;
        if (canal != obj.getCanal()) return false;
        if (kwh != obj.getKWH()) return false;
        if (esgotos != obj.getEsgotos()) return false;
        if (super.equals(obj) == false) return false;
        return true;
    }
    
    /**
     *  Devolve uma cópia da instância
     */
    public Terreno clone()
    {
        return new Terreno(this);
    }
    
    /**
     * Devolve uma representação no formato textual 
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Tipo de Construção: ");
        if(constr == 1) sb.append("Habitação");
        else sb.append("Armazéns");
        sb.append("\n");
        sb.append("Canalizações: ");sb.append(canal); sb.append("\n");
        sb.append("KWH: ");sb.append(kwh); sb.append("\n");
        sb.append("Esgotos: ");sb.append(esgotos); sb.append("\n");
        return sb.toString();
    }
}