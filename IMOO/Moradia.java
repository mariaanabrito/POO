import java.io.*;
/**
 * A classe Moradia implementa uma moradia com a área de implantação, a área coberta, a área envolvente,
 * o número de quartos, o número de wc, o número da porta e o tipo da moradia.
 */
public class Moradia extends Imovel implements Habitavel, ImovelComum, Serializable
{
    private double areaImp, areaCob, areaEnv;
    private int quartos, wc, porta, tipo;
    
    /**
     * Cria uma instância de Moradia
     */
    public Moradia()
    {
        super();
        areaImp = 0.0;
        areaCob = 0.0;
        areaEnv = 0.0;
        quartos = 0;
        wc = 0;
        porta = 0;
        tipo = 0;
    }
    
    /**
     * Construtor por parâmetros
     */
    public Moradia(String r, String es, String i, int pp, int pm, int c, double aImp, double aCob, double aEnv, int q, int w, int p, int t)
    {
        super(r, es, i, pp, pm, c);
        areaImp = aImp;
        areaCob = aCob;
        areaEnv = aEnv;
        quartos = q;
        wc = w;
        porta = p;
        tipo = t;
    }
    
    /**
     * Construtor de cópia
     */
    public Moradia(Moradia mor)
    {
        super(mor);
        areaImp = mor.getAreaImp();
        areaCob = mor.getAreaCob();
        areaEnv = mor.getAreaEnv();
        quartos = mor.getQuartos();
        wc = mor.getWC();
        porta = mor.getPorta();
        tipo = mor.getTipo();
    }
    
    /**
     * Devolve a área de implementação
     */
    public double getAreaImp()
    {
        return areaImp;
    }
    
    /**
     * Devolve a área coberta
     */
    public double getAreaCob()
    {
        return areaCob;
    }
    
    /**
     * Devolve a área envolvente
     */
    public double getAreaEnv()
    {
        return areaEnv;
    }
    
    /**
     * Devolve o número de quartos
     */
    public int getQuartos()
    {
        return quartos;
    }
    
    /**
     * Devolve o número de WCs
     */
    public int getWC()
    {
        return wc;
    }
    
    /**
     * Devolve o número da porta
     */
    public int getPorta()
    {
        return porta;
    }
    
    /**
     * Devolve o tipo da moradia
     */
    public int getTipo()
    {
        return tipo;
    }
    
    /**
     * Define a área de implementação da moradia através do parâmetro
     */
    public void setAreaImp(double areaImp)
    {
        this.areaImp = areaImp;
    }
    
    /**
     * Define a área coberta da moradia através do parâmetro
     */
    public void setAreaCob(double areaCob)
    {
        this.areaCob = areaCob;
    }
    
    /**
     * Define a área envolvente da moradia através do parâmetro
     */
    public void setAreaEnv(double areaEnv)
    {
        this.areaEnv = areaEnv;
    }
    
    /**
     * Define o número de quartos da moradia através do parâmetro
     */
    public void setQuartos(int quartos)
    {
        this.quartos = quartos;
    }
    
    /**
     * Define o número de wc da moradia através do parâmetro
     */
    public void setWC(int wc)
    {
        this.wc= wc;
    }
    
    /**
     * Define o número da porta da moradia através do parâmetro
     */
    public void setPorta(int porta)
    {
        this.porta = porta;
    }
    
    /**
     * Define o tipo da moradia através do parâmetro
     */
    public void setTipo(int tipo)
    {
        this.tipo = tipo;
    }
    
    /**
     * Compara a identidade entre objetos
     */
    public boolean equals(Object o)
    {
        if (o == null) return false;
        if (o == this) return true;
        if (this.getClass() != o.getClass()) return false;
        Moradia obj = (Moradia) o;
        if (areaImp != obj.getAreaImp()) return false;
        if (areaCob != obj.getAreaCob()) return false;
        if (areaEnv != obj.getAreaEnv()) return false;
        if (quartos != obj.getQuartos()) return false;
        if (wc != obj.getWC()) return false;
        if (porta != obj.getPorta()) return false;
        if (tipo != obj.getTipo()) return false;
        if (super.equals(obj) == false) return false;
        return true;
    }
    
    /**
     * Devolve uma cópia desta instância
     */
    public Moradia clone()
    {
        return new Moradia(this);
    }
    
    /**
     * Devolve uma representação em formato textual
     */
    public String toString()
    {
       StringBuilder sb = new StringBuilder();
       sb.append(super.toString());
       sb.append("Tipo da Moradia: ");
       if(tipo == 1) sb.append("Isolada");
       if(tipo == 2) sb.append("Geminada");
       if(tipo == 3)sb.append("Banda");
       else sb.append("Gaveto");
       sb.append("\n");
       sb.append("Área de Implantação: "); sb.append(areaImp); sb.append("\n");
       sb.append("Área Total Coberta: "); sb.append(areaCob); sb.append("\n");
       sb.append("Área do Terreno Envolvente: "); sb.append(areaEnv); sb.append("\n");
       sb.append("Número de quartos: "); sb.append(quartos); sb.append("\n");
       sb.append("Número de WCs: "); sb.append(wc); sb.append("\n");
       sb.append("Número da Porta: "); sb.append(porta); sb.append("\n");
       return sb.toString();
    }
}
