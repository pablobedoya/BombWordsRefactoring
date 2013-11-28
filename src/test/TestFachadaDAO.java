package test;

import static org.junit.Assert.*;
import main.java.fachadaparadao.FachadaDAO;

import org.junit.Before;
import org.junit.Test;

public class TestFachadaDAO {

	
	@Before
	public void setUp() throws Exception {
	}
/*
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
		assertTrue(FachadaDAO.getFachadaDAO().criarNovaListaPalavras("novaLista"));
	}
*/
	@Test
	public void testRemoverListaPalavras() {
		assertFalse(FachadaDAO.getFachadaDAO().removerListaPalavras("naoExiste"));
	}

	@Test
	public void testLimparListaPalavras() {
		assertTrue(FachadaDAO.getFachadaDAO().limparListaPalavras("novaLista"));
	}
/*
	@Test
	public void testExtrairNomesDeTodasAsListasDePalavras() {

	}

	@Test
	public void testListaDePalavrasJahExiste() {
		assertFalse(FachadaDAO.getFachadaDAO().listaDePalavrasJahExiste("novaLista"));
	}

	@Test
	public void testMudarListaASerUsadaNoJogo() {
		
	}

	@Test
	public void testPegarNomeListaASerUsadaNoJogo() {
		
	}

	@Test
	public void testExtrairPalavrasETraducoes() {
		
	}
*/
	@Test
	public void testAdicionarNovaPalavraNaLista() {
		FachadaDAO.getFachadaDAO().adicionarNovaPalavraNaLista("novaLista", "Vasco da Gama", "Maior do Mundo");
	}
/*
	@Test
	public void testRemoverPalavraDaLista() {
		
	}

	@Test
	public void testInserirJogadorRanking() {
		
	}

	@Test
	public void testLerRanking() {
		
	}
*/
}
