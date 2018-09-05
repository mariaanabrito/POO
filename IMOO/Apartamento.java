import java.io.*;
/**
 *  Classe que implementa um apartamento. Esta classe contem o tipo, o número de quartos, se tem wc,
 *  o número da porta, o andar, a área total e se possui garagem.
 */
public class Apartamento extends Imovel implements Habitavel, ImovelComum, Serializable
{
    private int tipo, quartos, wc, porta, andar;
    private double areaTot;
    private boolean garagem;
    
    /**
     * Cria uma instância de Apartamento 
     */
    public Apartamento()
    {
        super();
        tipo = 0;
        quartos = 0;
        wc = 0;
        porta = 0;
        andar = 0;
        areaTot = 0.0;
        garagem = false;
    }
    
    /**
     *  Construtor por parâmetro
     */
    public Apartamento(String r, String es, String i, int pp, int pm, int c, int t, int q, int w, int p, int a, double aTot, boolean g)
    {
        super(r, es, i, pp, pm, c);
        tipo = t;
        quartos = q;
        wc = w;
        porta = p;
        andar = a;
        areaTot = aTot;
        garagem= g;
    }
    
    /**
     * Construtor por cópia 
     */
    public Apartamento(Apartamento ap)
    {
        super(ap);
        tipo = ap.getTipo();
        quartos = ap.getQuartos();
        wc = ap.getWC();
        porta = ap.getPorta();
        andar = ap.getAndar();
        areaTot = ap.getAreaTot();
        garagem = ap.getGaragem();
    }
    
    /**
     * Devolve o tipo de apartamento.
     */
    public int getTipo()
    {
        return tipo;
    }
    
    /**
     * Devolve o número do quarto
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
     * Devolve o andar
     */
    public int getAndar()
    {
        return andar;
    }
    
    /**
     * Devolve a área total
     */
    public double getAreaTot()
    {
        return areaTot;
    }
    
    /**
     * Devolve se tem garagem ou não
     */
    public boolean getGaragem()
    {
        return garagem;
    }
    /**
     * Define o tipo de negócio através do parâmetro
     */
    public void setTipo(int tipo)
    {
        this.tipo = tipo;
    }
    
    /**
     * Define o número de quartos através do parâmetro
     */
    public void setQuartos(int quartos)
    {
        this.quartos = quartos;
    }
    
    /**
     * Define o número de WCs
     */
    public void setWC(int wc)
    {
        this.wc = wc;
    }
    
    /**
     * Define o número da porta através do parâmetro
     */
    public void setPorta(int porta)
    {
        this.porta = porta;
    }
    
    /**
     * Define o número do andar através do parâmetro
     */
    public void setAndar(int andar)
    {
        this.andar = andar;
    }
    
    /**
     * Define a área total através do parâmetro
     */
    public void setAreaTot(double areaTot)
    {
        this.areaTot = areaTot;
    }
    
    /**
     * Define se tem garagem através do parâmetro
     */
    public void setGaragem(boolean garagem)
    {
        this.garagem = garagem;
    }
    
    /**
     * Compara a igualdade com outro  objetos
     */
    public boolean equals(Object o)
    {
        if (o == null) return false;
        if (o == this) return true;
        if (this.getClass() != o.getClass()) return false;
        Apartamento obj = (Apartamento) o;
        if (tipo != obj.getTipo()) return false;
        if (quartos != obj.getQuartos()) return false;
        if (wc != obj.getWC()) return false;
        if (porta != obj.getPorta()) return false;
        if (andar != obj.getAndar()) return false;
        if(areaTot != obj.getAreaTot()) return false;
        if (garagem != obj.getGaragem()) return false;
        if(super.equals(obj) == false) return false;
        return true;
    }
    
    /**
     * Devolve uma cópia desta instância
     */
    public Apartamento clone()
    {
        return new Apartamento(this);
    }
    
    /**
     * Devolve uma representação no formato textual
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Tipo de Apartamento: ");
        if (tipo == 1) sb.append("Simples");
        if (tipo == 2) sb.append("Duplex");
        else sb.append("Triplex");
        sb.append("\n");
        sb.append("Número de quartos: "); sb.append(quartos); sb.append("\n");
        sb.append("Números de WCs: "); sb.append(wc); sb.append("\n");
        sb.append("Número da Porta: "); sb.append(porta); sb.append("\n");
        sb.append("Andar: ");sb.append(andar); sb.append("\n");
        sb.append("Área Total: ");sb.append(areaTot); sb.append("\n");
        sb.append("Possui garagem: "); sb.append(garagem); sb.append("\n");
        
        return sb.toString();
    }
         
}
