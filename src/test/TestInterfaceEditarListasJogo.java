package test;

import static org.junit.Assert.*;

import java.awt.event.ActionEvent;

import main.java.jogo.InterfaceEditarListasJogo;

import org.junit.Test;

public class TestInterfaceEditarListasJogo {

	@Test
	public void testCriarNovaListaPalavras()
		throws Exception {
		InterfaceEditarListasJogo fixture = new InterfaceEditarListasJogo();
		String nomeLista = "";

		boolean result = fixture.criarNovaListaPalavras(nomeLista);

		assertTrue(result);
	}

	@Test
	public void testOrdenarPalavrasLista()
		throws Exception {
		InterfaceEditarListasJogo fixture = new InterfaceEditarListasJogo();
		String[] palavras = new String[] {"", ""};

		String[] result = fixture.ordenarPalavrasLista(palavras);

		assertNotNull(result);
		assertEquals(2, result.length);
		assertEquals("", result[0]);
		assertEquals("", result[1]);
	}

	@Test
	public void testRemoverListaPalavras()
		throws Exception {
		InterfaceEditarListasJogo fixture = new InterfaceEditarListasJogo();
		String nomeLista = "";

		boolean result = fixture.removerListaPalavras(nomeLista);

		assertTrue(result);
	}

	
}
