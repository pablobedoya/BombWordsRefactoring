package test;

import static org.junit.Assert.*;

import java.util.LinkedList;

import main.java.dao.ConcreteDAOPalavrasDeListaArquivos;
import main.java.jogo.PalavrasETraducoes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestConcreteDAOPalavrasDeListaArquivos {

	private ConcreteDAOPalavrasDeListaArquivos plv = new ConcreteDAOPalavrasDeListaArquivos();

	@Before
	public void setUp() throws Exception {
	}
/*	
	@Test
	public void testExtrairPalavrasETraducoes() {
		LinkedList<String> palavrasDoJogo = new LinkedList<String>();
		palavrasDoJogo.add("Table");
		LinkedList<String> traducoesDoJogo = new LinkedList<String>();
		traducoesDoJogo.add("mesa");
		PalavrasETraducoes resp = new PalavrasETraducoes(palavrasDoJogo, traducoesDoJogo);
		assertEquals(resp, plv.extrairPalavrasETraducoes("palavras"));
	}
*/
	@Test
	public void testAdicionarNovaPalavraNaLista() {
		assertTrue(plv.adicionarNovaPalavraNaLista("palavras", "Vasco da Gama", "Maior do Mundo"));
	}

	@Test
	public void testRemoverPalavraDaLista() {
		
	}

}
