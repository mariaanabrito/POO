import java.io.*;
/**
 * A classe LojaHabitavel implementa uma loja habitável que difere da loja apenas num sentido : é possível habitar a loja.
 */
public class LojaHabitavel extends Apartamento implements Habitavel, ImovelComum, Serializable
{
    private String negocio;
    
    /**
     * Cria uma instância LojaHabitavel
     */
    public LojaHabitavel()
    {
        super();
        negocio = "";
    }
    
    /**
     * Construtor por parâmetros
     */
    public LojaHabitavel(Apartamento p, String n)
    {
        super(p);
        negocio = n;
    }
    
    /**
     * Construtor por parâmetros
     */
    public LojaHabitavel(String r, String es, String i, int pp, int pm, int c, int p, int t, int q, int w, int a, double aTot, boolean g, String n)
    {
        super(r, es, i, pp, pm, c, t, q, w, p, a, aTot, g);
        negocio = n;
    }
    
    /**
     * Construtor de cópia
     */
    public LojaHabitavel(LojaHabitavel l)
    {
        super(l);
        negocio = l.getNegocio();
    }
    
    /**
     * Retorna o tipo de negócio
     */
    public String getNegocio()
    {
       return negocio;
    }
    
    /**
     * Define o tipo de negócio através do parâmetro
     */
    public void setNegocio(String n)     
    { 
        negocio = n; 
    }
    
    /**
     * Compara a igualdade entre objetos
     */
    public boolean equals(Object o)
    {
        if (o == null) return false;
        if (o == this) return true;
        if (this.getClass() != o.getClass()) return false;
        LojaHabitavel obj = (LojaHabitavel) o;
        return (super.equals(obj) && (obj.getNegocio().equals(negocio)));
    }
    
    /**
     * Devolve uma cópia desta instância
     */
    public LojaHabitavel clone()
    {
        return new LojaHabitavel(this);
    }
    
    /**
     * Devolve uma representação no formato textual
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Tipo de negócio: ").append(negocio); sb.append("\n");
      
        return sb.toString(); 
    }
}
