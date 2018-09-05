import java.io.*;
/** 
 * Classe que implementa uma consulta. Uma consulta tem o email de quem a consultou, a data
 * em que foi consultada e o imóvel consultado.
 */
public class Consulta implements Serializable
{
    private String email, data;
    private Imovel imovel;
    int contador;
    
    /**
     *  Cria uma instância de Consulta
     */
    public Consulta(String mail, String dat, Imovel i, int cont)
    {
        email = mail;
        data = dat;
        imovel = i.clone();
        contador = cont;
    }
    
    /**
     *  Define o email da consulta através do parâmetro
     */
    public void setEmailCon(String mail)
    {
        email = mail;
    }
    
    /**
     *  Define a data da consulta através do parâmetro.
     */
    public void setDataCon(String dataAtual)
    {
        data = dataAtual;
    }
    
    /**
     *  Define o contador da consulta através do parâmetro.
     */
    public void setContador(int cont)
    {
        contador = cont;
    }
    
    /**
     * Define o imóvel da consulta através do parâmetro. 
     */
    public void setImovelCon(Imovel i)
    {
        System.out.println("rua d i= " + i.getRua());
        imovel.setRua(i.getRua());
        System.out.println("rua do imovel= " + imovel.getRua());
        imovel.setEstado(i.getEstado());
        imovel.setPrecoPedido(i.getPrecoPedido());
        imovel.setPrecoMin(i.getPrecoMin());
    }
    
    /**
     *  Retorna o email da consulta
     */
    public String getEmailCon()
    {
        return email;
    }
    
    /**
     * Retorna a data da consulta 
     */
    public String getDataCon()
    {
        return data;
    }
    
    /**
     *  Retorna o imóvel da consulta
     */
    public Imovel getImovelCon()
    {
        return imovel;
    }
    
    /**
     *  Retorna o contador da consulta
     */
    public int getContador()
    {
        return contador;
    }
    
    /**
     * Adiciona uma consulta 
     */
    public void addConsulta(String mail, String dat, Imovel i, int cont)
    {
        email = mail;
        data = dat;
        setImovelCon(i);
        contador = cont;
    }
    
    /**
     *  Compara a igualdade entre dois objetos
     */
    public boolean equals(Object obj)
    {
        if(obj == this) return true;
        if(obj == null || obj.getClass() != this.getClass()) return false;
        Consulta c = (Consulta) obj;
        if(c.getEmailCon().equals(email) == false) return false;
        if(c.getDataCon().equals(data) == false) return false;
        if(c.getImovelCon().equals(imovel) ==  false) return false;
        if(c.getContador() == contador) return false;
        return true;
    }
    
    /**
     * Devolve uma representação no formato textual 
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Email : "); sb.append(email); sb.append("\n");
        sb.append("Data : "); sb.append(data); sb.append("\n");
        sb.append("Consultas: "); sb.append(contador); sb.append("\n");
        sb.append("Imovel : "); sb.append(imovel.toStringParaVendedor());
     
        return sb.toString();
    }
    
    /**
     * Incrementa o contador
     */
    public void incContador()
    {
        this.contador++;
    }
    
}
