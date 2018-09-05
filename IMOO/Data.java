import java.io.*;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Classe que implementa uma data.
 */
public class Data implements Serializable
{
    String data;
    
    /**
     * Cria uma instância de data.
     */
    public Data()
    {
        data = "";
    }
    
    /**
     * Construtor de parâmetro
     */
    public Data(String dat)
    {
        data = dat;
    }
    
    /**
     * Construtor de cópia
     */
    public Data(Data d)
    {
        data = d.getData();
    }
    
    /**
     * Retorna a data
     */
    public String getData()
    {
        return this.data;
    }
    
    /**
     * Obtém a data atual.
     */
    public String getDataAtual()
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        
        String date = dateFormat.format(new Date());
        
        return date;
    }
    
    /**
     * Devolve uma cópia desta instância 
     */
    public Data clone()
    {
        return new Data(this);
    }
    
    /**
     * Compara a igualdade com outro objecto
     */
    public boolean equals(Object obj)
    {
        if(obj == this) return true;
        if(obj == null || obj.getClass() != this.getClass()) return false;
        Data d = (Data) obj;
        if(d.getData().equals(data) == false) return false;
        return true;
    }
    
    /**
     * Devolve uma representação no formato textual
     */
    public String toString()
    {
      return data;
    }
}
