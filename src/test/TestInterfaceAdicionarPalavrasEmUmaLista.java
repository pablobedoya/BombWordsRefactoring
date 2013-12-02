package test;

import static org.junit.Assert.assertNotNull;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.Box;

import main.java.jogo.InterfaceAdicionarPalavrasEmUmaLista;
import main.java.jogo.InterfaceListaPalavras;

import org.junit.Test;

public class TestInterfaceAdicionarPalavrasEmUmaLista {

	@Test
	public void testActionPerformed()
		throws Exception {
		InterfaceAdicionarPalavrasEmUmaLista fixture = new InterfaceAdicionarPalavrasEmUmaLista();
		//fixture.criarJanelaEditarLista("", new InterfaceListaPalavras());
		ActionEvent arg0 = new ActionEvent(new Object(), 1, "");

		fixture.actionPerformed(arg0);

		assertNotNull(fixture);
	}

	@Test
	public void testCriarJanelaEditarLista()
		throws Exception {
		InterfaceAdicionarPalavrasEmUmaLista fixture = new InterfaceAdicionarPalavrasEmUmaLista();
		//fixture.criarJanelaEditarLista("", new InterfaceListaPalavras());
		String nomeLista = "";
		InterfaceListaPalavras interfaceMuda = new InterfaceListaPalavras();

		//fixture.criarJanelaEditarLista(nomeLista, interfaceMuda);

		assertNotNull(fixture);
	}
	
	@Test
	public void testDesfazerAdicaoPalavraNaLista()
		throws Exception {
		InterfaceAdicionarPalavrasEmUmaLista fixture = new InterfaceAdicionarPalavrasEmUmaLista();
		//fixture.criarJanelaEditarLista("", new InterfaceListaPalavras());

		//fixture.desfazerAdicaoPalavraNaLista();

		assertNotNull(fixture);
	}

	@Test
	public void testKeyPressed()
		throws Exception {
		InterfaceAdicionarPalavrasEmUmaLista fixture = new InterfaceAdicionarPalavrasEmUmaLista();
		//fixture.criarJanelaEditarLista("", new InterfaceListaPalavras());
		@SuppressWarnings("deprecation")
		KeyEvent e = new KeyEvent(Box.createGlue(), 1, 1L, 1, 1);

		fixture.keyPressed(e);

		assertNotNull(fixture);
	}

	@Test
	public void testKeyReleased()
		throws Exception {
		InterfaceAdicionarPalavrasEmUmaLista fixture = new InterfaceAdicionarPalavrasEmUmaLista();
		//fixture.criarJanelaEditarLista("", new InterfaceListaPalavras());
		@SuppressWarnings("deprecation")
		KeyEvent arg0 = new KeyEvent(Box.createGlue(), 1, 1L, 1, 1);

		fixture.keyReleased(arg0);

		assertNotNull(fixture);
	}
	
}
