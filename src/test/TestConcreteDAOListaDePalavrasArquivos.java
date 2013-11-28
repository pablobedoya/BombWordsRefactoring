package test;

import static org.junit.Assert.*;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import main.java.dao.ConcreteDAOListaDePalavrasArquivos;

import org.junit.Before;
import org.junit.Test;

public class TestConcreteDAOListaDePalavrasArquivos {

	private ConcreteDAOListaDePalavrasArquivos lista = new ConcreteDAOListaDePalavrasArquivos();


	@Before
	public void setUp() throws Exception {
		
	}

	/*	@Test
	public void testCriarNovaListaPalavras() {
		String nomeLista = "arquivo";
		assertTrue(lista.criarNovaListaPalavras(nomeLista));
	}
	
	@Test
	public void testCriarNovaListaPalavrasJaexiste() {
		String nomeLista = "arquivo";
		assertFalse(lista.criarNovaListaPalavras(nomeLista));
	}

	@Test
	public void testRemoverListaPalavras() {
		String nomeLista = "arquivo";
		assertTrue(lista.removerListaPalavras(nomeLista));
	}

	@Test
	public void testLimparListaPalavras() {
		String nomeLista = "arquivo";
		assertFalse(lista.limparListaPalavras(nomeLista));
	}


	@Test
	public void testExtrairNomesDeTodasAsListasDePalavras() {
		
	}
*/
	@Test
	public void testListaDePalavrasJahExiste() {
		String nomeLista = "listaQualquer";
		assertTrue(lista.listaDePalavrasJahExiste(nomeLista));
	}

	@Test
	public void testMudarListaASerUsadaNoJogo() {
		String nomeLista = "arquivo";
		assertTrue(lista.mudarListaASerUsadaNoJogo(nomeLista));
	}
/*
	@Test
	public void testPegarNomeListaASerUsadaNoJogo() {
		
	}
*/
}
