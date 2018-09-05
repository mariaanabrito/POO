import java.io.*;
/**
 * Abstract class Imovel - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Imovel implements Comparable<Imovel>, Serializable
{
   private String rua, estado, id;
   private int precoPedido, precoMin;
 
   public Imovel()
   {
       rua = "";
       estado = "";
       id = "";
       precoPedido = 0;
       precoMin = 0;
   }
   
   public Imovel(String r, String e, String i, int pedido, int minimo, int consulta)
   {
       rua = r;
       estado = e;
       id = i;
       precoPedido = pedido;
       precoMin = minimo;
   }
   
   public Imovel(Imovel i)
   {
       rua = i.getRua();
       estado = i.getEstado();
       id = i.getId();
       precoPedido = i.getPrecoPedido();
       precoMin = i.getPrecoMin();
   }
   
   public String getRua()
   {
       return rua;
   }
   
   public String getEstado()
   {
       return estado;
   }
   
   public String getId()
   {
       return id;
   }
   
   public int getPrecoPedido()
   {
       return precoPedido;
   }
   
   public int getPrecoMin()
   {
       return precoMin;
   }
   
   public void setRua(String r)
   {
       rua = r;
   }
   
   public void setEstado(String e)
   {
       estado = e;
   }
   
   public void setID(String i)
   {
       id = i;
   }
   
   public void setPrecoPedido(int pedido)
   {
       precoPedido = pedido;
   }
   
   public void setPrecoMin(int minimo)
   {
       precoMin = minimo;
   }

   public abstract Imovel clone();
   
   public String constroiID(int n)
   {
      StringBuilder sb = new StringBuilder(n);
       
      return sb.toString();
   }
    
   public boolean equals(Object obj)
   {
       if(obj == this) return true;
       if(obj == null || obj.getClass() != this.getClass()) return false;
       Imovel i = (Imovel) obj;
       if(i.getRua().equals(rua) == false) return false;
       if(i.getEstado().equals(estado) == false) return false;
       if (i.getId().equals(id) == false) return false;
       if(i.getPrecoPedido() != precoPedido) return false;
       if(i.getPrecoMin() != precoMin) return false;
       return true;
   }
   
   public String toStringParaComprador()
   {
       StringBuffer sb = new StringBuffer();
       sb.append("Rua: "); sb.append(rua + "\n");
       sb.append("Estado: "); sb.append(estado + "\n");
       sb.append("ID: "); sb.append(id + "\n");
       sb.append("Preço Pedido: "); sb.append(precoPedido + "\n");
       return sb.toString();
    }
   
   public String toStringParaVendedor()
   {
       StringBuffer sb = new StringBuffer();
       sb.append("Rua: "); sb.append(rua + "\n");
       sb.append("Estado: "); sb.append(estado + "\n");
       sb.append("ID: "); sb.append(id + "\n");
       sb.append("Preço Pedido: "); sb.append(precoPedido + "\n");
       sb.append("Preço Mínimo: "); sb.append(precoMin + "\n");
       return sb.toString();
    }
    
   public int compareTo(Imovel i)
   {
       return id.compareTo(i.getId());
   }
   
}
