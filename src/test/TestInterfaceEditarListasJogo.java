package test;

import static org.junit.Assert.*;

import main.java.jogo.InterfaceEditarListasJogo;

import org.junit.Before;
import org.junit.Test;

public class TestInterfaceEditarListasJogo {
	private InterfaceEditarListasJogo fixture;

	@Before
	public void setUp() {
		fixture = new InterfaceEditarListasJogo();
	}

	@Test
	public void testCriarNovaListaPalavras() throws Exception {
		String nomeLista = "";
		boolean result = fixture.criarNovaListaPalavras(nomeLista);
		assertTrue(result);
	}

	@Test
	public void testOrdenarPalavrasLista() throws Exception {
		String[] palavras = new String[] { "", "" };
		String[] result = fixture.ordenarPalavrasLista(palavras);
		assertNotNull(result);
		assertEquals(2, result.length);
		assertEquals("", result[0]);
		assertEquals("", result[1]);
	}

	@Test
	public void testRemoverListaPalavras() throws Exception {
		String nomeLista = "";
		boolean result = fixture.removerListaPalavras(nomeLista);
		assertNotNull(result);
	}

}
