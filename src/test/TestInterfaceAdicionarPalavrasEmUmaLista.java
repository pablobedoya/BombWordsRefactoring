package test;

import static org.junit.Assert.*;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.Box;

import main.java.jogo.UInterfaceAdicionarPalavrasEmUmaLista;
import main.java.jogo.UInterfaceListaPalavras;

import org.junit.Before;
import org.junit.Test;

public class TestInterfaceAdicionarPalavrasEmUmaLista {

	private UInterfaceAdicionarPalavrasEmUmaLista fixture;

	@Before
	public void setUp() {
		fixture = new UInterfaceAdicionarPalavrasEmUmaLista();
	}

	@Test
	public void testActionPerformed() throws Exception {
		ActionEvent arg0 = new ActionEvent(new Object(), 1, "");
		fixture.actionPerformed(arg0);
		assertNotNull(fixture);
	}

	@Test
	public void testCriarJanelaEditarLista() throws Exception {
		String nomeLista = "";
		UInterfaceListaPalavras interfaceMuda = new UInterfaceListaPalavras();
		assertNotNull(fixture);
	}

	@Test
	public void testDesfazerAdicaoPalavraNaLista() throws Exception {
		assertNotNull(fixture);
	}

	@Test
	public void testKeyPressed() throws Exception {
		assertTrue(true);
	}

	@Test
	public void testKeyReleased() throws Exception {
		assertTrue(true);
	}

}
