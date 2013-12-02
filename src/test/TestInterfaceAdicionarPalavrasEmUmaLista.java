package test;

import static org.junit.Assert.*;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.Box;

import main.java.jogo.InterfaceAdicionarPalavrasEmUmaLista;
import main.java.jogo.InterfaceListaPalavras;

import org.junit.Before;
import org.junit.Test;

public class TestInterfaceAdicionarPalavrasEmUmaLista {

	private InterfaceAdicionarPalavrasEmUmaLista fixture;

	@Before
	public void setUp() {
		fixture = new InterfaceAdicionarPalavrasEmUmaLista();
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
		InterfaceListaPalavras interfaceMuda = new InterfaceListaPalavras();
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
