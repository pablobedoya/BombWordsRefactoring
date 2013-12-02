package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.awt.event.ActionEvent;

import main.java.jogo.InterfaceEditarListasJogo;

import org.junit.Test;

public class TestInterfaceEditarListasJogo {

	@Test
	public void testActionPerformed()
		throws Exception {
		InterfaceEditarListasJogo fixture = new InterfaceEditarListasJogo();
		ActionEvent arg0 = new ActionEvent(new Object(), 1, "");

		fixture.actionPerformed(arg0);
		
		assertNotNull(fixture);
	}

	@Test(expected=NullPointerException.class)
	public void testAdicionarNovaListaNaComboBox()
		throws Exception {
		InterfaceEditarListasJogo fixture = new InterfaceEditarListasJogo();
		String novaLista = "";

		fixture.adicionarNovaListaNaComboBox(novaLista);

		assertNotNull(fixture);
	}

	@Test
	public void testCriarInterfaceEditarListasJogo()
		throws Exception {
		InterfaceEditarListasJogo fixture = new InterfaceEditarListasJogo();

		fixture.criarInterfaceEditarListasJogo();

		assertNotNull(fixture);
	}

	@Test
	public void testCriarNovaListaPalavras()
		throws Exception {
		InterfaceEditarListasJogo fixture = new InterfaceEditarListasJogo();
		String nomeLista = "";

		boolean result = fixture.criarNovaListaPalavras(nomeLista);

		assertTrue(result);
	}

	@Test
	public void testLimparListaPalavras()
		throws Exception {
		InterfaceEditarListasJogo fixture = new InterfaceEditarListasJogo();
		String nomeLista = "";

		//fixture.limparListaPalavras(nomeLista);

		assertNotNull(fixture);
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


	@Test(expected=NullPointerException.class)
	public void testRemoverListaDaComboBox()
		throws Exception {
		InterfaceEditarListasJogo fixture = new InterfaceEditarListasJogo();
		String lista = "";

		fixture.removerListaDaComboBox(lista);

		assertNotNull(fixture);
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
