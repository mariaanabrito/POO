import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Set;
import java.util.TreeSet;
import java.util.List;

/**
 * Classe correspondente aos testes realizados.
 */
public class Testes
{
    private Imoobiliaria imo;
    private Vendedor v;
    private Terreno t;

    /**
     * Teste principal
     */
    @Test
    public void mainTest() {
        imo = new Imoobiliaria();
        try {
            imo.iniciaSessao("",null);
            fail();
        } catch(SemAutorizacaoException e) {
            
        } catch(Exception e) {
            fail();
        }
        assertTrue(imo.getLog() == 0);
        try {
            v = new Vendedor("antonio@gmail.com", "António Fernandes", "supervendedor", "Foz do Douro, Porto", "1965/06/07", new TreeSet<Imovel>(), new TreeSet<Imovel>(), new TreeSet<Consulta>()); 
            imo.registarUtilizador(v);
            assertTrue(imo.getImoVendedores().size() > 0);
            assertTrue(imo.getImoCompradores().size() == 0);
        } catch(Exception e) {
            fail();
        }
        
        String email = v.getEmail();
        String password = v.getPassword();
        
        try {
            imo.iniciaSessao(email, password);
            assertTrue(imo.getLog() == 1);
        } catch(Exception e) {
            fail();
        }
        
        t = new Terreno("Matosinhos", "Vende-se", "0", 1234, 1002, 0, 0, 12.2, 145.5, true);
        try {
            imo.registaImovel(t);
            assertTrue(v.getPortfolioVendedor().contains(t));
        } catch (Exception e) {
            fail();
        }
            
        int s = imo.getImovel("Terreno", Integer.MAX_VALUE).size();
        assertTrue(s>0);
        Set<String> ids = imo.getTopImoveis(0);
        assertTrue(ids.contains(t.getId()));
        assertTrue(imo.getMapeamentoImoveis().keySet().contains(t));
        try {
            assertTrue(imo.getConsultas().size()>0);
        } catch(Exception e) {
            fail();
        }
        
        imo.fechaSessao();
        Comprador c = new Comprador("carmo.123@gmail.com", "Carmo Miranda", "carmomiranda1976", "Aldoar", "1976/12/25", new TreeSet<Imovel>()); 
        try {
            imo.registarUtilizador(c);
        } catch(Exception e) {
            fail();
        }
        email = c.getEmail();
        password = c.getPassword();
        try {
            imo.iniciaSessao(email, password);
            imo.setFavorito(t.getId());
            assertTrue(imo.getFavoritos().contains(t));
        } catch(Exception e) {
            e.printStackTrace();
            fail();
        }
        try
        {
            imo.iniciaSessao(v.getEmail(), v.getPassword());
        }
        catch(Exception e)
        {
           fail();
        }
            Moradia mor = new Moradia("Avenida do Brasil", "Vende-se", "1", 195, 100, 0, 123.3, 190.0, 77.7, 3, 2, 45, 1); 
        try
        {
            imo.registaImovel(mor);
        }
        catch(Exception e)
        {
           fail();
        }
        List<Habitavel> lh = imo.getHabitaveis(200);
        assertTrue(lh.contains(mor));
        assertTrue(v.getPortfolioVendedor().size() == 2);
        try
        {
            imo.setEstado(mor.getId(), "Vendido");
            Set<String> set = imo.getTopImoveis(0);
            assertTrue(set.contains(mor.getId()));
        }
        catch(Exception e)
        {
           fail();
        }
        assertTrue(v.getHistoricoVendedor().size() > 0);
        assertFalse(v.getPortfolioVendedor().size() == 0);
        try {
            assertTrue(imo.getConsultas().size()>0);
            imo.fechaSessao();
        } catch(Exception e) {
            fail();
        }
        Vendedor f = new Vendedor("ernestina.goncalves@gmail.com", "Ernestina Gonçalves", "goncernestina", "Nevogilde", "1950/05/22", new TreeSet<Imovel>(), new TreeSet<Imovel>(), new TreeSet<Consulta>());
        try
        {
            imo.registarUtilizador(f);
        }
        catch(Exception e)
        {
            fail();
        }
        assertTrue(imo.getImoVendedores().size() == 2);
        assertFalse(imo.getImoCompradores().size() == 2);
        try
        {
            imo.iniciaSessao(f.getEmail(), f.getPassword());
        }
        catch(Exception e)
        {
            fail();
        }
        LojaHabitavel lojaH = new LojaHabitavel("Rua do Padrão", "Vende-se", "2", 12345, 12000, 0, 1, 3, 3, 5, 3, 300.4, true, "Vestuário");
        try
        {
            imo.registaImovel(lojaH);
            assertTrue(f.getPortfolioVendedor().size() == 1);
            assertTrue(imo.getImoVendedores().size() == 2);
            List<Consulta> cs = imo.getConsultas();
            assertTrue(cs.size() == 0);
            List<Imovel> li = imo.getImovel("LojaHabitavel", 333000);
            assertTrue(li.size() == 1);
            List<Consulta> cons = imo.getConsultas();
            assertTrue(cons.size() == 1);
        }
        catch(Exception e)
        {
            fail();
        }
        try{
            Set<String> top0 = imo.getTopImoveis(0);
            assertTrue(top0.contains(lojaH.getId()) == true);
        }
        catch(Exception e)
        {
            fail();
        }
        try
        {
            Set<String> top1 = imo.getTopImoveis(1);
            assertTrue(top1.contains(lojaH.getId()) == false);
            imo.fechaSessao();
        }
        catch(Exception e)
        {
            fail();
        }
    }
    
}
