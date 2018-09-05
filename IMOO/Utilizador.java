import java.io.*;
import java.util.List;
import java.util.ArrayList;

/**
 * Classe que representa um utilizador da Imobiliária, juntamente com os campos que o
 * identificam.
 */
public class Utilizador implements Serializable
{
    private String email, nome, pass, morada, dataNasc;
    
    /**
     * Cria uma instância de Utilizador
     */
    public Utilizador()
    {
        email = "notvalid";
        nome = "";
        pass = "";
        morada = "";
        dataNasc = "";
    }
    
    /**
     * Construtor por parametro
     * @param ml email
     * @param n nome
     * @param p password
     * @param md morada
     * @param d data de nascimento
     */
    public Utilizador(String ml, String n, String p, String md, String d)
    {
        email = ml;
        nome = n;
        pass = p;
        morada = md;
        dataNasc = d;
    }
    
    /**
     * Construtor por cópia.
     */
    public Utilizador(Utilizador u)
    {
        email = u.getEmail();
        nome = u.getNome();
        pass = u.getPassword();
        morada = u.getMorada();
        dataNasc = u.getData();
    }
    
    /**
     * Retorna o email do utilizador. 
     */
    public String getEmail()
    {
        return email;
    }
    
    /**
     * Retorna o nome do utilizador.
     */
    public String getNome()
    {
        return nome;
    }
    
    /**
     *  Retorna a password do utilizador.
     */
    public String getPassword()
    {
        return pass;
    }
    
    /**
     * Retorna a morada do utilizador.
     */
    public String getMorada()
    {
        return morada;
    }
    
    /**
     *  Retorna a data de nascimento do utilizador.
     */
    public String getData()
    {
        return dataNasc;
    }
    
    /**
     * Define o parâmetro como o email do utilzador.
     */
    public void setEmail(String ml)
    {
        email = ml;
    }
    
    /**
     * Define o parâmetro como o nome do utilzador.
     */
    public void setNome(String n)
    {
        nome = n;
    }
    
    /**
     * Define o parâmetro como a password do utilzador.
     */ 
    public void setPass(String p)
    {
        pass = p;
    }
    
    /**
     * Define o parâmetro como a morada do utilzador.
     */
    public void setMorada(String md)
    {
        morada = md;
    }
    
    /**
     * Define o parâmetro como a data do utilzador.
     */ 
    public void setData(String d)
    {
        dataNasc = d;
    }
    
    /**
     * Compara a igualdade com outro objecto
     */
    public boolean equals(Object o)
    {
        if(o == null) return false;
        if(o == this) return true;
        if(this.getClass() != o.getClass()) return false;
        Utilizador obj = (Utilizador) o;
        if(obj.getEmail().equals(email) == false) return false;
        if(obj.getNome().equals(nome) == false) return false;
        if(obj.getPassword().equals(pass) == false) return false;
        if(obj.getMorada().equals(morada) == false) return false;
        if(obj.getData().equals(dataNasc) == false) return false;
        return true;
    }
    
    /**
     * Devolve uma cópia desta instância 
     */
    public Utilizador clone()
    {
        return new Utilizador(this);
    }
    
    /**
     * Devolve uma representação no formato textual 
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("E-mail: " + email); sb.append("\n");
        sb.append("Nome: " + nome); sb.append("\n");
        sb.append("Password: " + pass); sb.append("\n");
        sb.append("Morada: " + morada); sb.append("\n");
        sb.append("Data de Nascimento: " + dataNasc); sb.append("\n");
        return sb.toString();
    }
}
