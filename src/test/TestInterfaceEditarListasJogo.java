package test;

import static org.junit.Assert.*;

import main.java.jogo.UInterfaceEditarListasJogo;

import org.junit.Before;
import org.junit.Test;

public class TestInterfaceEditarListasJogo {
	private UInterfaceEditarListasJogo fixture;

	@Before
	public void setUp() {
		fixture = new UInterfaceEditarListasJogo();
	}

	@Test(expected = NullPointerException.class)
	public void testActionPerformed() {
		fixture.actionPerformed(null);
		assertTrue(true);
	}
	
	@Test(expected = NullPointerException.class)
	public void testAdicionarNovaListaNaComboBox() {
		fixture.adicionarNovaListaNaComboBox("");
		assertNotNull(fixture);
	}
	
	@Test
	public void testCriarInterfaceEditarListasJogo() {
		fixture.criarInterfaceEditarListasJogo();
		assertNotNull(fixture);
	}
	
	@Test
	public void testCriarNovaListaPalavras() throws Exception {
		String nomeLista = "";
		boolean result = fixture.criarNovaListaPalavras(nomeLista);
		assertTrue(result);
	}
	
	@Test
	public void testLimparListaPalavras() {
		assertNotNull(fixture);
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
	
	@Test(expected = NullPointerException.class)
	public void testRemoverListaDaComboBox() {
		fixture.removerListaDaComboBox("");
		assertNotNull(fixture);
	}

	@Test
	public void testRemoverListaPalavras() throws Exception {
		String nomeLista = "";
		boolean result = fixture.removerListaPalavras(nomeLista);
		assertNotNull(result);
	}

}
