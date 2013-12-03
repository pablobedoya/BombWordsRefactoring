package test;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.Random;
import main.java.fachadaparadao.FachadaDAO;
import main.java.jogo.PalavrasETraducoes;

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
		String[] esperado = { "10", "20" };
		assertArrayEquals("Sucesso", esperado, FachadaDAO.getFachadaDAO()
				.lerConfiguracoesJogo());
	}

	@Test
	public void testSetarNovasConfiguracoesJogo() {
		String[] esperado = { "10", "20" };
		FachadaDAO.getFachadaDAO().setarNovasConfiguracoesJogo(10, 20);
		assertArrayEquals("Sucesso", esperado, FachadaDAO.getFachadaDAO()
				.lerConfiguracoesJogo());
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

	@Test
	public void testLimparListaPalavras() {
		FachadaDAO fixture = FachadaDAO.getFachadaDAO();
		String nomeLista = "listaasasblabla";

		boolean result = fixture.criarNovaListaPalavras(nomeLista);
		assertTrue(result);
	}

	@Test
	public void testExtrairNomesDeTodasAsListasDePalavras() {
		
		FachadaDAO fixture = FachadaDAO.getFachadaDAO();
		String[] result = fixture.extrairNomesDeTodasAsListasDePalavras();
		assertNotNull(result);
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
		assertEquals("pegarLista", FachadaDAO.getFachadaDAO().pegarNomeListaASerUsadaNoJogo());
	}

	@Test
	public void testExtrairPalavrasETraducoes() {
		FachadaDAO fachada = FachadaDAO.getFachadaDAO();
		String listaOndeEstaoOsDados = "sasasasasasa";
		PalavrasETraducoes palavrasETraducoes = fachada.extrairPalavrasETraducoes(listaOndeEstaoOsDados);

		assertNull(palavrasETraducoes);
	}
	
	@Test
	public void testAdicionarNovaPalavraNaLista() {
		FachadaDAO.getFachadaDAO().adicionarNovaPalavraNaLista("novaLista",
				"Vasco da Gama", "Maior do Mundo");
	}

	@Test
	public void testRemoverPalavraDaLista() {
		FachadaDAO.getFachadaDAO().removerPalavraDaLista("palavras",
				"Maior do Mundo");
	}

	@Test
	public void testInserirJogadorRanking() {
		FachadaDAO.getFachadaDAO().inserirJogadorRanking("Ezequely", 10);
		String[] esperado = { "phi;4300;5;9", "j;2300;10;20", "pi;800;10;20",
				"phi;600;5;5", "Phi;600;5;5", "Josiel;400;10;20",
				"pablo;400;10;20", "Ezequely;10;10;20" };
		assertArrayEquals("Sucesso", esperado, FachadaDAO.getFachadaDAO().lerRanking());
	}

	@Test
	public void testLerRanking() {
		FachadaDAO.getFachadaDAO().lerRanking();
	}

}
