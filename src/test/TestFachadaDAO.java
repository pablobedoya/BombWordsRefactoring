package test;

import static org.junit.Assert.*;

import java.util.Random;

import main.java.dao.ConcreteDAOPalavrasDeListaArquivos;
import main.java.dao.DAOListaDePalavras;
import main.java.fachadaparadao.FachadaDAO;

import org.junit.Before;
import org.junit.Test;

public class TestFachadaDAO {
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetFachadaDAO() {
		assertNotNull(FachadaDAO.getFachadaDAO());
	}

	@Test
	public void testLerConfiguracoesJogo() {
		
	}

	@Test
	public void testSetarNovasConfiguracoesJogo() {
		
	}

	@Test
	public void testCriarNovaListaPalavras() {
		Random r = new Random();
		String nome = "novaLista" + r.nextInt(100);
		System.out.println(nome);
		assertTrue(FachadaDAO.getFachadaDAO().criarNovaListaPalavras(nome));
	}

	@Test
	public void testRemoverListaPalavras() {
		assertFalse(FachadaDAO.getFachadaDAO().removerListaPalavras("naoExiste"));
	}
/*	
	@Test
	public void testLimparListaPalavras() {
		assertTrue(FachadaDAO.getFachadaDAO().limparListaPalavras("limparLista"));
	}
*/
	@Test
	public void testExtrairNomesDeTodasAsListasDePalavras() {

	}

	@Test
	public void testListaDePalavrasJahExiste() {
		assertFalse(FachadaDAO.getFachadaDAO().listaDePalavrasJahExiste("naoExiste"));
	}

	@Test
	public void testMudarListaASerUsadaNoJogo() {
		assertTrue(FachadaDAO.getFachadaDAO().mudarListaASerUsadaNoJogo("mudarLista"));
	}

	@Test
	public void testPegarNomeListaASerUsadaNoJogo() {
		FachadaDAO.getFachadaDAO().mudarListaASerUsadaNoJogo("pegarLista");
		assertEquals("pegarLista",FachadaDAO.getFachadaDAO().pegarNomeListaASerUsadaNoJogo());
	}

	@Test
	public void testExtrairPalavrasETraducoes() {
		
	}

	@Test
	public void testAdicionarNovaPalavraNaLista() {
		FachadaDAO.getFachadaDAO().adicionarNovaPalavraNaLista("novaLista", "Vasco da Gama", "Maior do Mundo");
	}

	@Test
	public void testRemoverPalavraDaLista() {
		
	}

	@Test
	public void testInserirJogadorRanking() {
		
	}

	@Test
	public void testLerRanking() {
		
	}

}
