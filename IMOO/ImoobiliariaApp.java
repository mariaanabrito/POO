import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.List;
import java.util.Iterator;
import java.util.Map;

/**
 * Classe que corresponde à interface da imobiliária. Nesta classe é possível executar todos
 * os métodos inseridos na class Imobiliaria.
 */
public class ImoobiliariaApp
{
    private ImoobiliariaApp() {};
    
    private static Imoobiliaria imoo;
    
    private static Menu menuprincipal, menu2, menu3, menu4, menu5, menu6, menu7, menu8, menu9, menu10, menu11;
    
    /**
     * Método que permite correr o programa.
     */
    public static void main(String[] args)
    {
        carregarMenus();
        imoo = initApp();
        
        do
        {
            menuprincipal.executarMenu();
            
            switch (menuprincipal.getOpcao())
            {
                case 1: inserirUtilizador();
                        break;
                case 2: iniciarSessao();
                        break;
                case 3:obterImoveis();
                        break;
                case 4: obterHabitaveis();
                        break;
                case 5: obterMapeamento();
                        break;
                case 6: venderImovel();
                        break;
                case 7: obterConsultas();
                        break;
                case 8: alterarEstado();
                        break;
                case 9: marcarFavorito();
                        break;
                case 10: obterFavoritos();
                         break;
                case 11: obterTopImoveis();
                         break;
                default: fecharSessao();
                         break;
            }
        }while(menuprincipal.getOpcao() != 0);
        try
        {
            imoo.log("imoo.txt", true);
            imoo.gravaObj("estado.imoo");
        }
        catch(IOException e)
        {
            System.out.println("Os dados não foram gravados!");
        }
   
            
        System.out.println("O programa foi encerrado!");
    }
    
    /**
     * Método que carrega os menus correspondentes às várias opções contidas na interface.
     */
    public static void carregarMenus()
    {
        String[] opsprincipais = {"Registar Utilizador",
                                  "Iniciar Sessão",
                                  "Consultar a lista de todos os imóveis de um certo tipo até um dado preço",
                                  "Consultar a lista de todos os imóveis habitáveis até um dado preço",
                                  "Obter um mapeamento entre todos os imóveis e os seus vendedores",
                                  "Colocar um imóvel à venda",
                                  "Visualizar a lista das 10 últimas consultas aos imóveis para venda",
                                  "Alterar o estado de um imóvel",
                                  "Marcar um imóvel como favorito",
                                  "Consultar a lista dos imóveis preferidos ordenados pelo seu preço",
                                  "Obter o top de imóveis",
                                  "Encerrar Sessão"};
        
        String[] ops2 = {"Registar Vendedor",
                         "Registar Comprador"};
                         
        String[] ops3 = {"Moradia",
                         "Apartamento",
                         "Terreno",
                         "Loja",
                         "Loja Habitável"};
                        
        String[] ops4 = {"Isolada",
                         "Geminada",
                         "Banda",
                         "Gaveto"};
                       
        String[] ops5 = {"Simples",
                         "Duplex",
                         "Triplex"};
                         
        String[] ops6 = {"Construção de Habitação",
                         "Construção de Armazéns"};
                         
        String[] ops7 = {"Tem garagem",
                         "Não tem garagem"};
                         
        String[] ops8 = {"Tem acesso à rede de esgotos",
                         "Não tem acesso à rede de esgotos"};
                         
        String[] ops9 = {"Tem WC",
                         "Não tem WC"};
 
        String[] ops10 = {"Vende-se",
                          "Vendido",
                          "Outro"};
                          
        String[] ops11 = {"Alimentação",
                          "Vestuário",
                          "Bem-estar e Saúde",
                          "Lazer",
                          "Outro"};
                                   
        menuprincipal = new Menu(opsprincipais);
        menu2 = new Menu(ops2);
        menu3 = new Menu(ops3);
        menu4 = new Menu(ops4);
        menu5 = new Menu(ops5);
        menu6 = new Menu(ops6);
        menu7 = new Menu(ops7);
        menu8 = new Menu(ops8);
        menu9 = new Menu(ops9);
        menu10 = new Menu(ops10);
        menu11 = new Menu(ops11);
    }
    
    /**
     * Método que inicializa a aplicação da imobiliária lendo os objetos contidos num ficheiro.
     */
    private static Imoobiliaria initApp()
    {
        try
        {
            imoo = Imoobiliaria.leObjeto("estado.imoo");
        }
        catch(IOException e)
        {
            imoo = new Imoobiliaria();
            System.out.println("ERRO DE LEITURA: Os dados não foram lidos!");
        }
        catch(ClassNotFoundException e)
        {
            imoo = new Imoobiliaria();
            System.out.println("ERRO DE FORMATO: Ficheiro com formato incorreto!");
        }
        catch(ClassCastException e)
        {
            imoo = new Imoobiliaria();
            System.out.println("ERRO DE FORMATO: Erro de formato!");
        }
        return imoo;
    }
    
    /**
     * Lê os campos necessários e adiciona um utilizador à imobiliária.
     * Apanha a exceção se esta tiver sido lançada e imprime a mensagem de erro.
     */
    private static void inserirUtilizador()
    {
        Utilizador u;
        Scanner s = new Scanner(System.in);
        
        menu2.executarMenu();
        
        if (menu2.getOpcao() != 0)
        {
            String email, nome, password, morada, dataNasc;
            
            System.out.print("Insira o nome: ");
            nome = s.nextLine();
            System.out.print("Insira a morada: ");
            morada = s.nextLine();
            System.out.print("Insira a data de nascimento (formato AAAA/MM/DD): ");
            dataNasc = s.nextLine();
            System.out.print("Insira o e-mail: ");
            email = s.nextLine();
            System.out.print("Insira a password: ");
            password = s.nextLine();
            switch(menu2.getOpcao())
            {
                case 1: TreeSet<Imovel> portfolio = new TreeSet<Imovel>();
                        TreeSet<Imovel> historico = new TreeSet<Imovel>();
                        TreeSet<Consulta> consultas = new TreeSet<Consulta>();
                        u = new Vendedor(email, nome, password, morada, dataNasc, portfolio, historico, consultas);
                        break;
                default: TreeSet<Imovel> favoritos = new TreeSet<Imovel>();
                         u = new Comprador(email, nome, password, morada, dataNasc, favoritos);
                         break;
            }
            
            try
            {
                imoo.registarUtilizador((Utilizador)u); 
            }
            catch(UtilizadorExistenteException e)
            {
                System.out.println(e.getMessage());
            }
        }
        else
        {
           System.out.println("A inserção de um novo utilizador foi cancelada.\n");
        }
        s.close();
    }
    
    /**
     * Lê os campos necessários e inicia sessão.
     * Apanha a exceção se esta tiver sido lançada e imprime a mensagem de erro.
     */
    private static void iniciarSessao()
    {
        /** Faltam try/catch de exceções */
        String email, password;
        Scanner s = new Scanner(System.in);
       
        System.out.println("Insira o e-mail: ");
        email = s.nextLine();
        System.out.println("Insira a password: ");
        password = s.nextLine();
 
        try
        {
            imoo.iniciaSessao(email, password);
        }
        catch(SemAutorizacaoException e)
        {
            System.out.println(e.getMessage());
        }
        
        s.close();
    }
    
    /**
     * Lê os campos necessários e obtém os imóveis de um determinado tipo e imprime-os no ecrã.
     */
    private static void obterImoveis()
    {
        String classe;
        int preco, logutilizador;
        List<Imovel> ls;
        Iterator<Imovel> it;
        Scanner s = new Scanner(System.in);
        
        System.out.println("Insira a classe: ");
        classe = s.nextLine();
        System.out.println("Insira o preço: ");
        preco = s.nextInt();
        
        ls = imoo.getImovel(classe, preco);
        it = ls.iterator();
        logutilizador = imoo.getLog();
        
        System.out.println("\nLista de todos os imóveis do tipo " + classe + " até " + preco + " euros:\n");
        while(it.hasNext())
        {
           if(logutilizador == 1 || logutilizador == 0)
           {
               Imovel i = (Imovel) it.next();
               System.out.println(i.toStringParaVendedor() + "\n");
           }
           else
           {
               Imovel i = (Imovel) it.next();
               System.out.println(i.toStringParaComprador() + "\n");
           }
        }

        s.close();
    }
    
    /**
     * Lê os campos necessários e obtém os imóveis habitáveis imprimindo-os no ecrã.
     */
    private static void obterHabitaveis()
    {
        int preco, logutilizador;
        List<Habitavel> ls;
        Iterator it;
        Scanner s = new Scanner(System.in);
        
        System.out.println("\nInsira o preço: ");
        preco = s.nextInt();
        
        ls = imoo.getHabitaveis(preco);
        
        it = ls.iterator();
        logutilizador = imoo.getLog();
        
        System.out.println("\nLista de todos os imóveis habitáveis até " + preco + " euros:\n");
        while(it.hasNext())
        {
            if(logutilizador == 1 || logutilizador == 0)
            {
                Imovel i = (Imovel) it.next();
                System.out.println(i.toStringParaVendedor() + "\n");
            }
            else
            {
                Imovel i = (Imovel) it.next();
                System.out.println(i.toStringParaComprador() + "\n");
            }
        }
        
        s.close();
    }
    
    /**
     * Lê os campos necessários e coloca um imóvel à venda.
     * Apanha a exceção se esta tiver sido lançada e imprime a mensagem de erro.
     */
    private static void venderImovel()
    {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        Scanner s = new Scanner(System.in);
        String rua, id, estado, negocio;
        int precopedido, precominimo, consultas, tipo, quartos, wc, porta, andar, constr;
        double areaImp, areaTot, areaEnv, area, canal, kwh;
        boolean esgotos, wcs, garagem;
        Apartamento ap;
        Terreno ter;
        Moradia mor;
        LojaHabitavel lh;
        Loja lj;
        
        System.out.println("Insira a rua: ");
        rua = s.nextLine();
        System.out.println("Insira o preço pedido: ");
        precopedido = s.nextInt();
        System.out.println("Insira o preço mínimo: ");
        precominimo = s.nextInt();
        System.out.println("Insira o tipo do imóvel:\n");
        System.out.println("1 - Moradia");
        System.out.println("2 - Apartamento");
        System.out.println("3 - Terreno");
        System.out.println("4 - Loja");
        System.out.println("5 - Loja Habitável");
        tipo = s.nextInt();
        if (tipo == 1) 
        {    
            System.out.println("Insira o tipo da moradia: ");
            menu4.executarMenu();
            switch(menu4.getOpcao())
            {
                case 1: tipo = 1;
                case 2: tipo = 2;
                case 3: tipo = 3;
                default: tipo = 4;
            }
            System.out.println("Insira a área de implantação: ");
            areaImp = s.nextDouble();
            System.out.println("Insira a área total coberta: ");
            areaTot = s.nextDouble();
            System.out.println("Insira a área do terreno envolvente: ");
            areaEnv = s.nextDouble();
            System.out.println("Insira o número de quartos: ");
            quartos = s.nextInt();
            System.out.println("Insira o números de WCs: ");
            wc = s.nextInt();
            System.out.println("Insira o número da porta: ");
            porta = s.nextInt();
            sb.append(imoo.calculaQuantos());
            id = sb.toString();
            sb2.append("Vende-se");
            estado = sb2.toString();
            consultas = 0;
            mor = new Moradia(rua, estado, id, precopedido, precominimo, consultas, areaImp, areaTot, areaEnv, quartos, wc, porta, tipo); 
            try
            {
                 imoo.registaImovel((Imovel) mor);
                 System.out.println("\nO imóvel foi registado com sucesso!\n");
            }
            catch(SemAutorizacaoException e)
            {
                System.out.println(e.getMessage());
            }
            catch(ImovelExisteException e)
            {
                System.out.println(e.getMessage());
            }
        }
        else if (tipo == 2)
        {
            System.out.println("Indique o tipo de apartamento: ");
            menu5.executarMenu();
            switch(menu5.getOpcao())
            {
                case 1: tipo = 1;
                case 2: tipo = 2;
                default: tipo = 3;
            }
            menu5.setOpcao(0);
            System.out.println("Insira a área total: ");
            areaTot = s.nextDouble();
            System.out.println("Insira o número de quartos: ");
            quartos = s.nextInt();
            System.out.println("Insira o número de WCs: ");
            wc = s.nextInt();
            System.out.println("Insira o número da porta: ");
            porta = s.nextInt();
            System.out.println("Insira o andar: ");
            andar = s.nextInt();
            menu7.executarMenu();
            System.out.println("Indique se o apartamento tem garagem ou não: ");
            switch(menu7.getOpcao())
            {
                case 1: garagem = true;
                default: garagem = false;
            }
            menu7.setOpcao(0);
            sb.append(imoo.calculaQuantos());
            id = sb.toString();
            sb2.append("Vende-se");
            estado = sb2.toString();
            consultas = 0;
            ap = new Apartamento(rua, estado, id, precopedido, precominimo, consultas, tipo, quartos, wc, porta, andar, areaTot, garagem);
            try
            {
                imoo.registaImovel((Imovel) ap);
                System.out.println("\nO imóvel foi registado com sucesso!\n");
            }
            catch(SemAutorizacaoException e)
            {
                System.out.println(e.getMessage());
            }
            catch(ImovelExisteException e)
            {
                 System.out.println(e.getMessage());
            }
        }
        else if (tipo == 3)
        {
            System.out.println("Indique o tipo de construção do terreno: ");
            menu6.executarMenu();
            switch(menu6.getOpcao())
            {
               case 1: constr = 0;
               default: constr = 1;
            }
            menu6.setOpcao(0);
            System.out.println("Insira o diâmentro das canalizações (em milímetros): ");
            canal = s.nextDouble();
            System.out.println("Insira os kWh máximo suportados pela rede elétrica (se não estiver instalada, insira 0): ");
            kwh = s.nextDouble();
            System.out.println("Indique se o terreno possui acesso à rede de esgotos ou não: ");
            menu8.executarMenu();
            switch(menu8.getOpcao())
            {
               case 1: esgotos = true;
               default: esgotos = false;
            }
            menu8.setOpcao(0);
            sb.append(imoo.calculaQuantos());
            id = sb.toString();
            sb2.append("Vende-se");
            estado = sb2.toString();
            consultas = 0;
            ter = new Terreno(rua, estado, id, precopedido, precominimo, consultas, constr, canal, kwh, esgotos);
            try
            {
                imoo.registaImovel((Imovel) ter);
                System.out.println("\nO imóvel foi registado com sucesso!\n");
            }
            catch(SemAutorizacaoException e)
            {
                System.out.println(e.getMessage());
            }
            catch(ImovelExisteException e)
            {
                System.out.println(e.getMessage());
            }
        }
        else if(tipo == 4)
        {
            System.out.println("Insira o tipo de negócio viável na loja: ");
            menu11.executarMenu();
            switch(menu5.getOpcao())
            {
               case 1: negocio = "Alimentação";
               case 2: negocio = "Vestuário";
               case 3: negocio = "Bem-estar e Saúde";
               default: negocio = "Outro";
            }
            menu11.setOpcao(0);
            System.out.println("Insira a área: ");
            area = s.nextDouble();
            System.out.println("Indique se a loja possui WC ou não: ");
            menu9.executarMenu();
            switch(menu9.getOpcao())
            {
                case 1: wcs = true;
                default: wcs = false;
            }
            System.out.println("Insira o número da porta: ");
            porta = s.nextInt();
            sb.append(imoo.calculaQuantos());
            id = sb.toString();
            sb2.append("Vende-se");
            estado = sb2.toString();
            consultas = 0;
            lj = new Loja(rua, estado, id, precopedido, precominimo, consultas, negocio, area, wcs, porta);
            try
            {
                imoo.registaImovel((Imovel) lj);
                System.out.println("\nO imóvel foi registado com sucesso!\n");
            }
            catch(SemAutorizacaoException e)
            {
                System.out.println(e.getMessage());
            }
            catch(ImovelExisteException e)
            {
                System.out.println(e.getMessage());
            }
        }
        else
        {
           System.out.println("Insira o tipo de negócio viável na loja: ");
           menu11.executarMenu();
           switch(menu5.getOpcao())
           {
               case 1: negocio = "Alimentação";
               case 2: negocio = "Vestuário";
               case 3: negocio = "Bem-estar e Saúde";
               default: negocio = "Outro";
           }
           menu11.setOpcao(0);
           System.out.println("Indique o tipo de apartamento: ");
           menu5.executarMenu();
           switch(menu5.getOpcao())
           {
               case 1: tipo = 1;
               case 2: tipo = 2;
               default: tipo = 3;
           }
           menu5.setOpcao(0);
           System.out.println("Insira a área total: ");
           areaTot = s.nextDouble();
           System.out.println("Insira o número de quartos: ");
           quartos = s.nextInt();
           System.out.println("Insira o número de WCs: ");
           wc = s.nextInt();
           System.out.println("Insira o número da porta: ");
           porta = s.nextInt();
           System.out.println("Insira o andar: ");
           andar = s.nextInt();
           menu7.executarMenu();
           System.out.println("Indique se o apartamento tem garagem ou não: ");
           switch(menu7.getOpcao())
           {
               case 1: garagem = true;
               default: garagem = false;
           }
           menu7.setOpcao(0);
           sb.append(imoo.calculaQuantos());
           id = sb.toString();
           sb2.append("Vende-se");
           estado = sb2.toString();
           consultas = 0;
           lh = new LojaHabitavel(rua, estado, id, precopedido, precominimo, consultas, tipo, quartos, wc, porta, andar, areaTot, garagem, negocio);
           try
           {
                imoo.registaImovel((Imovel) lh);
                System.out.println("\nO imóvel foi registado com sucesso!\n");
           }
           catch(SemAutorizacaoException e)
           {
                System.out.println(e.getMessage());
           }
           catch(ImovelExisteException e)
           {
               System.out.println(e.getMessage());
           }
        }
        
        s.close();
    }
    
    /** 
     * Obtém o mapeamento de todos os imóveis e imprime-os no ecrã.
     */
    private static void obterMapeamento()
    {
        int logutilizador;
        Map<Imovel, Vendedor> map;
        
        map = imoo.getMapeamentoImoveis();
        
        logutilizador = imoo.getLog();
        
        if(logutilizador == 1 || logutilizador == 0)
        {
            for(Map.Entry<Imovel, Vendedor> e: map.entrySet())
            {
                System.out.println("\n-----\n");
                System.out.println("Imóvel: " + e.getKey().toStringParaVendedor());
                System.out.println("Vendedor: " + e.getValue().toString());
                System.out.println("\n-----\n");
            }
        }
        else
        {
            for(Map.Entry<Imovel, Vendedor> e: map.entrySet())
            {
                System.out.println("\n-----\n");
                System.out.println("Imóvel: " + e.getKey().toStringParaComprador());
                System.out.println("Vendedor: " + e.getValue().toString());
                System.out.println("\n-----\n");
            }
        }
        
    }
    
    /**
     * Lê os campos necessários e altera o estado de um imóvel.
     * Apanha a exceção se esta tiver sido lançada e imprime a mensagem de erro.
     */
    public static void alterarEstado()
    {
        Scanner s = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String estado, idImovel;
        
        System.out.println("\nInsira o ID do imóvel: ");
        idImovel = s.nextLine();
        System.out.println("\nInsira o novo estado do imóvel: ");
        menu10.executarMenu();
        
        switch(menu10.getOpcao())
        {
            case 1: sb.append("Vende-se");
                    estado = sb.toString();
                    System.out.println("estado: " + estado);
            default: sb.append("Vendido");
                    estado = sb.toString();
                    System.out.println("estado: " + estado);
        }
        
        try
        {
            imoo.setEstado(idImovel, estado);
        }
        catch(ImovelInexistenteException e)
        {
            System.out.println(e.getMessage());
        }
        catch(SemAutorizacaoException e)
        {
            System.out.println(e.getMessage());
        }
        catch(EstadoInvalidoException e)
        {
            System.out.println(e.getMessage());
        }
        
        System.out.println("\nO estado do imóvel foi alterado com sucesso!\n");
        s.close();
    }
    
    /**
     * Obtém os imóveis favoritos de um comprador imprimindo-os no ecrã.
     * Apanha a exceção se esta tiver sido lançada e imprime a mensagem de erro.
     */
    public static void obterFavoritos()
    {
        TreeSet<Imovel> favoritos = new TreeSet<Imovel>();
        
        try
        {
            favoritos = imoo.getFavoritos();
        }
        catch(SemAutorizacaoException e)
        {
            System.out.println(e.getMessage());
        }
        
        System.out.println("\nLista dos imóveis favoritos ordenados pelo preço:\n");
        
        for(Imovel i: favoritos)
            System.out.println(i.toStringParaComprador());
    }
    
    /**
     * Obtém as últimas dez consultas de um vendedor imprimindo-as no ecrã.
     * Apanha a exceção se esta tiver sido lançada e imprime a mensagem de erro.
     */
    public static void obterConsultas()
    {
        List<Consulta> consultas = null;
        int i;
        
        try
        {
            consultas = imoo.getConsultas();
        }
        catch(SemAutorizacaoException e)
        {
            System.out.println(e.getMessage());
        }
        
        System.out.println("\nÚltimas 10 consultas dos imóveis que estão para venda:\n");
        for(Consulta c: consultas)
        {
            System.out.println(c.toString());
        }
    }
    
    /**
     * Lê um número e imprime os ids dos imóveis com consultas superiores a esse número.
     */
    public static void obterTopImoveis()
    {
        Scanner s = new Scanner(System.in);
        int n, logutilizador;
        Set<String> topImoveis;
        
        logutilizador = imoo.getLog();
        
        if(logutilizador == 1)
        {
            System.out.println("\nInsira o número mínimo de consultas (não inclusive):");
            n = s.nextInt();
        
            topImoveis = imoo.getTopImoveis(n);
        
            System.out.println("\nTop " + n + " de imóveis mais consultados\n");
            for(String g : topImoveis)
            {
                System.out.println("ID: " + g + "\n");
            }
        }
        else System.out.println("\nPermissão para obter o top de imóveis negada!\n");
    }
    
    /**
     * Encerra a sessão
     */
    public static void fecharSessao()
    {
        System.out.println("\nA encerrar sessão...\n");
        imoo.fechaSessao();
    }
    
    /**
     * Lê os campos necessários para identificar um imóvel e marca esse imóvel como favorito.
     * Apanha a exceção se esta tiver sido lançada e imprime a mensagem de erro.
     */
    public static void marcarFavorito()
    {
        Scanner s = new Scanner(System.in);
        String imovel;
        
        System.out.println("\nInsira o ID do imóvel:");
        imovel = s.nextLine();
        
        try
        {
            imoo.setFavorito(imovel);
            System.out.println("\n O imóvel foi marcado como favorito com sucesso!\n");
        }
        catch(SemAutorizacaoException e)
        {
            System.out.println(e.getMessage());
        }
        catch(ImovelInexistenteException e)
        {
            System.out.println(e.getMessage());
        }
        
        s.close();
    }
   
}
