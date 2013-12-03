package test;

import java.util.LinkedList;

import main.java.jogo.PalavrasETraducoes;

import org.junit.*;

import static org.junit.Assert.*;


public class TestPalavrasETraducoes {
	
	@Before
	public void setUp() throws Exception {
		
	}


	@After
	public void tearDown() 	throws Exception {
		
	}

	
	@Test
	public void testPalavrasETraducoes() {
		LinkedList<String> palavrasDoJogo = new LinkedList<String>();
		LinkedList<String> traducoesDoJogo = new LinkedList<String>();

		PalavrasETraducoes result = new PalavrasETraducoes(palavrasDoJogo, traducoesDoJogo);
		assertNotNull(result);
		assertEquals(0, result.getNumPalavrasNoJogo());
	}



	@Test
	public void testGetNumPalavrasNoJogo() {
		PalavrasETraducoes fixture = new PalavrasETraducoes(new LinkedList(), new LinkedList());

		int result = fixture.getNumPalavrasNoJogo();

		assertEquals(0, result);
	}

	
	@Test
	public void testGetPalavra () {
		PalavrasETraducoes fixture = new PalavrasETraducoes(new LinkedList(), new LinkedList());
		int indice = 1;
		String result = fixture.getPalavra(indice);
		assertEquals(null, result);
	}

	
	@Test
	public void testGetPalavras () {
		PalavrasETraducoes fixture = new PalavrasETraducoes(new LinkedList(), new LinkedList());
		LinkedList<String> result = fixture.getPalavras();
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	@Test
	public void testGetTraducao () {
		PalavrasETraducoes fixture = new PalavrasETraducoes(new LinkedList(), new LinkedList());
		int indice = 1;
		String result = fixture.getTraducao(indice);
		assertEquals(null, result);
	}


	@Test
	public void testGetTraducao_2()
		throws Exception {
		PalavrasETraducoes fixture = new PalavrasETraducoes(new LinkedList(), new LinkedList());
		int indice = 19999;

		String result = fixture.getTraducao(indice);
		assertEquals(null, result);
	}

	@Test
	public void testGetTraducoes() {
		PalavrasETraducoes fixture = new PalavrasETraducoes(new LinkedList(), new LinkedList());
		LinkedList<String> result = fixture.getTraducoes();
		assertNotNull(result);
		assertEquals(0, result.size());
	}


	@Test
	public void testSetPalavras () {
		PalavrasETraducoes fixture = new PalavrasETraducoes(new LinkedList(), new LinkedList());
		LinkedList<String> palavras = new LinkedList();
		fixture.setPalavras(palavras);
	}

	@Test
	public void testSetTraducoes() {
		PalavrasETraducoes fixture = new PalavrasETraducoes(new LinkedList(), new LinkedList());
		LinkedList<String> traducoes = new LinkedList();
		fixture.setTraducoes(traducoes);
	}
}