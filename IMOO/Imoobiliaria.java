import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;
import java.util.Map;
import java.util.TreeMap;
import java.util.Date;
import java.util.Calendar;
import java.io.*;
import java.util.Collection;
import java.util.Iterator;

/**
 * Classe que contém todas as funcionalidades necessárias a manter um correto funcionamento de uma imobiliária.
 * Possui uma lista de compradores, uma lista de vendedores, um utilizador, um vendedor, um comprador, uma correspondência entre o ID do imóvel e a sua consulta
 * e, finalmente, o tipo de utilizador logado.
 */
public class Imoobiliaria implements Serializable
{
    private List<Comprador> comp;
    private List<Vendedor> vend;
    private Comprador c;
    private Vendedor v;
    private Utilizador u;
    private Map<String, Consulta> l;
    private int log;
    private int quantos;
    
    /**
     * Constrói uma instância de Imobiliaria
     */
    public Imoobiliaria()
    {
        this.comp = new ArrayList<Comprador>();
        this.vend = new ArrayList<Vendedor>();
        this.c = new Comprador();
        this.v = new Vendedor();
        this.u = new Utilizador();
        this.l = new TreeMap<String, Consulta>();
        this.log = 0;
        this.quantos = 0;
    }
    
    /**
     * Construtor por parâmetro
     */
    public Imoobiliaria(List<Comprador> comp, List<Vendedor> vend, Comprador c, Vendedor v, Utilizador u, Map<String, Consulta> l, int log, int quantos)
    {
        this.comp = comp;
        this.vend = vend;
        this.c = c;
        this.v = v;
        this.u = u;
        this.l = l;
        this.log = log;
        this.quantos = quantos;
    }
    
    /**
     * Construtor de cópia
     */
    public Imoobiliaria(Imoobiliaria imo)
    {
        this.comp = imo.getImoCompradores();
        this.vend = imo.getImoVendedores();
        this.c = imo.getComprador();
        this.v = imo.getVendedor();
        this.u = imo.getUtilizador();
        this.l = imo.getListaConsultas();
        this.log = imo.getLog();
        this.quantos = imo.getQuantos();
    }
    
    /**
     * Retorna o número total de imóveis no sistema
     */
    public int getQuantos()
    {
        return this.quantos;
    }
    
    /**
     * Retorna a lista de compradores
     */
    public List<Comprador> getImoCompradores()
    {
        return this.comp;
    }
    
    /**
     * Retorna a lista de vendedores
     */
    public List<Vendedor> getImoVendedores()
    {
        return this.vend;
    }
    
    /**
     * Retorna o comprador
     */
    public Comprador getComprador()
    {
        return this.c;
    }
    
    /**
     * Retorna o vendedor
     */
    public Vendedor getVendedor()
    {
        return this.v;
    }
    
    /**
     * Retorna o utilizador
     */
    public Utilizador getUtilizador()
    {
        return this.u;
    }
    
    /**
     * Retorna o mapeamento entre uma consulta e um contador
     */
    public Map<String, Consulta> getListaConsultas()
    {
        return this.l;
    }
    
    /**
     * Retorna o tipo de login.
     */
    public int getLog()
    {
        return this.log;
    }
    
    /**
     * Determina o número total de imóveis registados no sistema
     */
    public int calculaQuantos()
    {
        int i;
        this.quantos = 0;
        
        for(i = 0; i < vend.size(); i++)
        {
            Vendedor a = vend.get(i);
            
            for(Imovel im: a.getPortfolioVendedor())
            {
                this.quantos++;
            }
        }
        
        
        return this.quantos;
    }
    
    /**
     * Método que permite iniciar a sessão na imobiliária. Se não tiver autorização atira um exceção
     */
    public void iniciaSessao(String email, String password) throws SemAutorizacaoException
    {
        int i, r;
        r = 0;
        
        for(i = 0; i < vend.size(); i++)
        {
           Vendedor u = vend.get(i);
            
           if(u.getEmail().equals(email) == true)
           {
                if(u.getPassword().equals(password) == true)
                {
                    v = u;
                    log = 1;
                    r = 1;
                }
                else throw new SemAutorizacaoException("A password introduzida está incorreta!");
           }
        }
        for(i = 0; i < comp.size(); i++)
        {
            Comprador u = comp.get(i);
            
            if(u.getEmail().equals(email) == true)
            {
                if(u.getPassword().equals(password) == true)
                {
                    c = u;
                    log = 2;
                    r = 1;
                }
                else throw new SemAutorizacaoException("A password introduzida está incorreta!");
            }
        }
        if (r == 0)
        {
            throw new SemAutorizacaoException("O e-mail que introduziu está incorreto!");
        }
    }
    
    /**
     * Método que permite a um utilizador fechar sessão
     */
    public void fechaSessao()
    {
        if (v.getEmail().equals("notvalid") == false) v = new Vendedor(); 
        if (c.getEmail().equals("notvalid") == false) c = new Comprador(); 
        log = 0;
    }
   
    /**
     * Função que regista um utilizador na imobiliária, sendo ele comprador ou vendedor.
     * Atira uma exceção se o utilizador já existir.
     */
    public void registarUtilizador(Utilizador utilizador) throws UtilizadorExistenteException
    {
        if(utilizador instanceof Comprador)
        {
            if(this.comp.contains((Comprador) utilizador) == true)
                throw new UtilizadorExistenteException("Comprador já existe no sistema.");
            else 
            {
                try
                {
                    this.comp.add((Comprador) utilizador);
                }
                catch(NullPointerException e)
                {
                    throw new UtilizadorExistenteException("Erro desconhecido!");
                }
            }
        }
        if(utilizador instanceof Vendedor)
        {
            if(vend.contains((Vendedor) utilizador) == true)
                throw new UtilizadorExistenteException("Vendedor já existe na lista.");
            else 
            
            {
                try
                {
                    vend.add((Vendedor)utilizador);
                }
                catch(NullPointerException e)
                {
                    throw new UtilizadorExistenteException("Erro desconhecido");
                }
            }
        }
    }
    
    /**
     * Método que permite adicionar um imóvel à imobiliária.
     * Atira uma exceção se o imóvel já existir, ou se não tiver permissão para o adicionar. 
     */
    public void registaImovel(Imovel im) throws ImovelExisteException, SemAutorizacaoException
    {
        int i;
        Vendedor a;
        
        if(log == 2 || log == 0) 
            throw new SemAutorizacaoException("Permissão de registar um imóvel negada!");
            
        
            
        for(i = 0; i < vend.size(); i++)
        {
            a = vend.get(i);
            
            for(Imovel imovel: a.getPortfolioVendedor())
            {
                if(im.getId().equals(imovel.getId()) == true)
                    throw new ImovelExisteException("O imóvel que pretende inserir já existe no sistema!");
            }
            if(a.getEmail().equals(v.getEmail()) == true)
            {
                a.adicionaImovelPortfolio(im);
            }
        }
        
        this.quantos++;
    }
    
    /**
     * Método que modifica o estado de um imóvel.
     * Atira uma exceção se o estado a inserir for válido, ou se o utilizador não tiver autorização para modificar o estado.
     */
    public void setEstado(String idImovel, String estado) throws EstadoInvalidoException, SemAutorizacaoException, ImovelInexistenteException
    {
        int i, r = 0;
        
        if(estado.equals("Vende-se") == false && estado.equals("Vendido") == false)
            throw new EstadoInvalidoException("O estado que introduziu não é válido!");
        
        if(log == 2 || log == 0)
            throw new SemAutorizacaoException("Permissão de alterar o estado do imóvel negada!");
            
        if(estado.equals("Vende-se") == true) 
        {
            for(i = 0; i < vend.size(); i++)
            {
                Vendedor va = vend.get(i);
                
                for(Imovel im: va.getHistoricoVendedor())
                {
                    if(im.getId().equals(idImovel) == true)
                    {
                        im.setEstado(estado);
                        va.removeImovelHistorico(im);
                        va.adicionaImovelPortfolio(im);
                        r = 1;
                        break;
                    }
                }
            }
        }
        if(estado.equals("Vendido") == true)
        {
            for(i = 0; i < vend.size(); i++)
            {
                Vendedor va = vend.get(i);
                
                for(Imovel im: va.getPortfolioVendedor())
                {
                    im.setEstado(estado);
                    va.removeImovelPortfolio(im);
                    va.adicionaImovelHistorico(im);
                    r = 1;
                    break;
                }
            }
        }
        
        if(r == 0)
            throw new ImovelInexistenteException("O imóvel não existe!");
    }
    
    /**
     * Método que obtém o mapeamento entre todos os imóveis da imobiliária.
     */
    public Map<Imovel, Vendedor> getMapeamentoImoveis()
    {
        Map<Imovel, Vendedor> novo = new TreeMap<Imovel, Vendedor>(new ComparadorID());
        int i;
        
        for(i = 0; i < vend.size(); i++)
        {
            Vendedor va = vend.get(i);
            
            for(Imovel im: va.getPortfolioVendedor())
            {
                novo.put(im.clone(), va.clone());
            }
        }
        
        atualizaConsultasMapeamento(novo);
        
        return novo;
    }
    
    /**
     * Método que devolve uma lista com todos os imóveis habitáveis.
     */
    public List<Habitavel> getHabitaveis(int preco)
    {
        int i;
        List<Habitavel> ls = new ArrayList<Habitavel>();

        
        for(i = 0; i < vend.size(); i++)
        {
            Vendedor va = vend.get(i);
            
            for(Imovel im: va.getPortfolioVendedor())
            {
                if(im instanceof Habitavel)
                {
                    int p = im.getPrecoPedido();
                    if (p < preco)
                    {
                        ls.add((Habitavel)im.clone());
                    }
                }
            }
        }
        
        atualizaConsultasgetHabitaveis(ls);
        
        return ls;
    }
    
    /**
     * Método que obtém uma lista com todos os imóveis correspondentes a um determinado tipo(exemplo: moradia, terreno).
     */
    public List<Imovel> getImovel(String classe, int preco)
    {
        int i;
        List<Imovel> ls = new ArrayList<Imovel>();
        
        for(i = 0; i < vend.size(); i++)
        {
            Vendedor va = vend.get(i);
            
            for(Imovel im: va.getPortfolioVendedor())
            {
                if(im.getClass().getName().equals(classe) == true)
                {
                    if(im.getPrecoPedido() < preco)
                    {
                        ls.add(im.clone());
                    }
                }
            }
        }
        atualizaConsultasgetImovel(ls);

        return ls;
    }
    
    /**
     * Método que adiciona um imóvel aos seus imóveis favoritos.
     * Atira uma exceção se o imóvel não existe, ou se o utilizador não tiver permissão para o adicionar.
     */
    public void setFavorito(String idImovel) throws SemAutorizacaoException, ImovelInexistenteException
    {
      int i, j, r = 0;
      
      if(log == 0 || log == 1)
        throw new SemAutorizacaoException("Permissão para marcar o imóvel como favorito negada!");

      for(i = 0; i < vend.size(); i++)
      {
         Vendedor va = vend.get(i);
         
         for (Imovel im: va.getPortfolioVendedor())
         {
            if (im.getId().equals(idImovel) == true)
            {
                c.adicionaImovelFavorito(im);
                r = 1;
            }
         }
      }
      
      if (r == 0)
      {
          throw new ImovelInexistenteException("O imóvel não existe!");
      }
    }
   
    /**
     * Método que obtém os imóveis favoritos do comprador.
     * Atira uma exceção se o utilizador não tiver permissão para os aceder.
     */
   public TreeSet<Imovel> getFavoritos() throws SemAutorizacaoException
   {
       Set<Imovel> favoritos = c.getFavoritosComprador();
       TreeSet<Imovel> copia = new TreeSet<Imovel>();
       
       if(log == 0 || log == 1)
            throw new SemAutorizacaoException("Permissão para marcar o imóvel como favorito negada!");
       
       TreeSet<Imovel> favoritosOrdem = new TreeSet<Imovel>(new ComparadorPreco());
       for(Imovel im : favoritos)
            favoritosOrdem.add(im.clone());
            
       for(Imovel im: favoritosOrdem)
            copia.add(im.clone());
            
       atualizaConsultasgetFavoritos(copia);
            
       return favoritosOrdem;
   }
   
   /**
    * Devolve uma representação no formato textual
    */
   public String toString()
   {
       Iterator <Map.Entry<String, Consulta>> it = l.entrySet().iterator();
       StringBuilder sb = new StringBuilder(">>>> Imoobiliaria <<<<\n");
       sb.append("Lista de Compradores:");
       sb.append("\n");
       for(Comprador cp: comp)
       {
           sb.append(cp.toString());
       }
       sb.append("Lista de Vendedores:");
       sb.append("\n");
       for(Vendedor vd: vend)
       {
           sb.append(vd.toString());
       }
       sb.append("Lista de Consultas:\n");
       while(it.hasNext())
       {
           Map.Entry<String, Consulta> cs = it.next();
           sb.append("\n------\n");
           sb.append("ID: \n");
           sb.append(cs.getKey().toString()); sb.append("\n");
           sb.append("Consulta: \n");
           sb.append(cs.getValue().toString()); sb.append("\n");
           sb.append("\n------\n");
       }
       sb.append("Log: "); sb.append(log + "\n");
       
       return sb.toString();
   }
   
   /**
    * Compara a igualdade entre dois objetos
    */
   public boolean equals(Object o)
   {
       if (this == o) return true;
       if (o == null) return false;
       if (this.getClass() != o.getClass()) return false;
       Imoobiliaria i = (Imoobiliaria) o;
       if (this.comp.equals(i.getImoCompradores()) == false) return false;
       if (this.vend.equals(i.getImoVendedores()) == false) return false;
       if (this.c.equals(i.getComprador()) == false) return false;
       if (this.v.equals(i.getVendedor()) == false) return false;
       if (this.u.equals(i.getUtilizador()) == false) return false;
       if (this.l.equals(i.getListaConsultas()) == false) return false;
       if (this.log == i.getLog() == false) return false;
       return true;
   }
  
   /**
    * Devolve uma cópia desta instância
    */
   public Imoobiliaria clone()
   {
       return new Imoobiliaria(this);
   }
   
   /**
    * Método que escreve o objeto num ficheiro.
    * Atira uma exceção em casa de erro IO.
    */
   public void gravaObj(String fich) throws IOException { 
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fich)); 
        oos.writeObject(this); 
        oos.flush();
        oos.close();
    } 
   
    /**
    * Método que lê o objeto dum ficheiro.
    * Atira uma exceção em caso de erro IO.
    */
   public static Imoobiliaria leObjeto(String ficheiro) throws IOException, ClassNotFoundException
   {
       ObjectInputStream ins = new ObjectInputStream(new FileInputStream(ficheiro));
       
       Imoobiliaria imoo = (Imoobiliaria) ins.readObject();
       
       ins.close();
       return imoo;
   }
   
   /**
    * Método que escreve num ficheiro o estado da classe sempre que se terminou do programa.
    * Atira uma exceção em casa de erro IO.
    */
   public void log(String ficheiro, boolean ap) throws IOException
   {
       FileWriter fw = new FileWriter(ficheiro, ap);
       fw.write("\n----------- LOG - LOG - LOG - LOG - LOG ----------------\n");
       fw.write(this.toString());
       fw.write("\n----------- LOG - LOG - LOG - LOG - LOG ----------------\n");
       fw.flush();
       fw.close();
   } 
   
   /**
    * Método que atualiza as consultas com os imóveis consultados no método getImovel
    */
   private void atualizaConsultasgetImovel(List<Imovel> ls)
   {
       int i, r = 0;
       Data d = new Data();
       String dataAtual;
       Iterator <Map.Entry<String, Consulta>> it = l.entrySet().iterator();

       for(i = 0; i < ls.size(); i++)
       {
           Imovel im = ls.get(i);
           while(it.hasNext())
           {
               Map.Entry<String, Consulta> e = it.next();
               if(e.getKey().equals(im.getId()) == true)
               {
                   r = 1;
                   e.getValue().incContador();
                   dataAtual = d.getDataAtual();
                   e.getValue().setDataCon(dataAtual);
               }
           }
           if(r == 0)
           {
               dataAtual = d.getDataAtual();
               if(log == 1)
               {
                   l.put(im.getId(), new Consulta(v.getEmail(), dataAtual, im.clone(), 1));
               }
               if(log == 2)
               {
                   l.put(im.getId(), new Consulta(c.getEmail(), dataAtual, im.clone(), 1));
               }
               if(log == 0)
               {
                   l.put(im.getId(), new Consulta("notvalid", dataAtual, im.clone(), 1));
               }
           }
           r = 0;
       }
       
   }
   
   /**
    * Método que atualiza as consultas com os imóveis consultados no método getHabitaveis
    */
   private void atualizaConsultasgetHabitaveis(List<Habitavel> ls)
   {
       int i, r = 0;
       Data d = new Data();
       String dataAtual;
       Iterator <Map.Entry<String, Consulta>> it = l.entrySet().iterator();
       
       for(Habitavel h: ls)
       {
           Imovel im = (Imovel) h;
           while(it.hasNext())
           {
               Map.Entry<String, Consulta> e = it.next();
               if(e.getKey().equals(im.getId()) == true)
               {
                   r = 1;
                   e.getValue().incContador();
                   dataAtual = d.getDataAtual();
                   e.getValue().setDataCon(dataAtual);
               }
           }
           if(r == 0)
           {
                dataAtual = d.getDataAtual();
                if(log == 1)
                {
                    l.put(im.getId(), new Consulta(v.getEmail(), dataAtual, im.clone(), 1));
                }
                if(log == 2)
                {
                    l.put(im.getId(), new Consulta(c.getEmail(), dataAtual, im.clone(), 1));
                }
                if(log == 0)
                {
                    l.put(im.getId(), new Consulta("notvalid", dataAtual, im.clone(), 1));
                }
           }
               r = 0;
       }
   }
   
   /**
    * Método que atualiza as consultas com os imóveis consultados no método getFavoritos
    */
   private TreeSet<Imovel> atualizaConsultasgetFavoritos(TreeSet<Imovel> ls)
   {
       int i, r = 0;
       Data d = new Data();
       String dataAtual;
       Iterator <Map.Entry<String, Consulta>> it = l.entrySet().iterator();
       
       for(Imovel im: ls)
       {
           while(it.hasNext())
           {
               Map.Entry<String, Consulta> e = it.next();
               
               if(e.getKey().equals(im.getId()) == true)
               {
                   e.getValue().incContador();
                   dataAtual = d.getDataAtual();
                   e.getValue().setDataCon(dataAtual);
                   r = 1;
               }
           }
               
           if(r == 0)
           {
                dataAtual = d.getDataAtual();
                l.put(im.getId(), new Consulta(c.getEmail(), dataAtual, im.clone(), 1));
           }
           r = 0;
       }
       
       return ls;
   }
   
   /**
    * Método que atualiza as consultas com os imóveis consultados no método getConsultasMapeamento
    */
   private void atualizaConsultasMapeamento(Map<Imovel, Vendedor> ls)
   {
       int r = 0;
       Data d = new Data();
       String dataAtual;
       Iterator <Map.Entry<Imovel, Vendedor>> itls = ls.entrySet().iterator();
       Iterator <Map.Entry<String, Consulta>> itl = l.entrySet().iterator();
       
       while(itls.hasNext())
       {
           Map.Entry<Imovel, Vendedor> e = itls.next();
           
           while(itl.hasNext())
           {
               Map.Entry<String, Consulta> k = itl.next();
               
               if(e.getKey().getId().equals(k.getKey()) == true)
               {
                   k.getValue().incContador();
                   dataAtual = d.getDataAtual();
                   k.getValue().setDataCon(dataAtual);
                   r = 1;
               }
           }
           if (r == 0)
               {
                   dataAtual = d.getDataAtual();
                   if(log == 1)
                   {
                       l.put(e.getKey().getId(), new Consulta(v.getEmail(), dataAtual, e.getKey(), 1));
                   }
                   if(log == 2)
                   {
                       l.put(e.getKey().getId(), new Consulta(c.getEmail(), dataAtual, e.getKey(), 1));
                   }
                   if(log == 0)
                   {
                       l.put(e.getKey().getId(), new Consulta("notvalid", dataAtual, e.getKey(),1));
                   }
               }
       }
   }
   
   /**
    * Método que retorna se uma dada consulta existe numa lista de consultas
    */
   private boolean naoAparece(ArrayList<Consulta> lc, Consulta c)
   {
       for(Consulta cons: lc)
       {
           if(cons.equals(c) == true)
                return false;
       }
       return true;
   }
   
   /**
    * Método que obtém as últimas dez consultas dos imóveis que o vendedor tem para venda.
    * Atira uma exceção se o utilizador não tiver permissão para o fazer.
    */
   public List<Consulta> getConsultas() throws SemAutorizacaoException
   {
       int i, r, counter = 0;
       Collection<Consulta> cs;
       ArrayList<Consulta> novo = new ArrayList<>();
       ArrayList<Consulta> res = new ArrayList<>();
       ArrayList<Consulta> passado = new ArrayList<>();
       Consulta max = new Consulta("notvalid", "0000/00/00 00:00:00", new Moradia(), 0);
       Iterator it;
       
       if(log == 2 || log == 0)
            throw new SemAutorizacaoException("Permissão para obter as consultas foi negada!");
       
       cs = l.values();
       it = cs.iterator();
       
       while(it.hasNext())
       {
           Consulta novac = (Consulta)it.next();
           if(existeVendedordoImovel(novac.getImovelCon().getId(), v.getEmail())== true)
               novo.add(novac);
       }


       for(r = 0; r < 10 || r < novo.size(); r++)
       {
           if (r == novo.size()) break;
           for(i = 0; i < novo.size(); i++)
           {
               if(novo.get(i).getDataCon().compareTo(max.getDataCon()) > 0 && naoAparece(passado, novo.get(i)) == true)
               {
                   max = novo.get(i);
               }
           }
           passado.add(r, max);
           max = new Consulta("", "0000/00/00 00:00:00", new Moradia(), 0);

       }
       return passado;    
   }
   
   /**
    * Método que verifica se um dado vendedor possui um dado imóvel à venda
    */
   private boolean existeVendedordoImovel(String id, String mail)
   {
       for(Vendedor v: vend)
       {
           for(Imovel im: v.getPortfolioVendedor())
           {
               if(im.getId().equals(id) == true && v.getEmail().equals(mail) == true)
                 return true;
           }
       }
       return false;
   }
   
   /**
    * Método que obtém os imóveis com mais n consultas, sendo n um parâmetro passado pelo utilizador.
    */
   public Set<String> getTopImoveis(int n)
   {
       ArrayList<Consulta> consultas = new ArrayList<Consulta>();
       Set<String> res = new TreeSet<String>();
       int i, j, k, max;
       Iterator <Map.Entry<String, Consulta>> it = l.entrySet().iterator();

       i = 0;
       while (it.hasNext())
       {
           Map.Entry<String, Consulta> e = it.next();
           if(existeVendedordoImovel(e.getValue().getImovelCon().getId(), v.getEmail()) == true)
           {
               consultas.add(i, e.getValue());
               i++;
           }
       }

       for(j = 0; j < i; j++)
       {
           if(consultas.get(j).getContador() > n)
           {
               res.add(consultas.get(j).getImovelCon().getId());
           }
       }

       return res;
   }
}
