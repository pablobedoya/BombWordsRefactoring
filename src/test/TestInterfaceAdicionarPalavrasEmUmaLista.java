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
	public void testCriarJanelaEditarLista_1()
		throws Exception {
		UInterfaceAdicionarPalavrasEmUmaLista fixture = new UInterfaceAdicionarPalavrasEmUmaLista();
		fixture.criarJanelaEditarLista("", new UInterfaceListaPalavras());
		String nomeLista = "";
		UInterfaceListaPalavras interfaceMuda = new UInterfaceListaPalavras();

		fixture.criarJanelaEditarLista(nomeLista, interfaceMuda);

		// add additional test code here
	}

	@Test
	public void testDesfazerAdicaoPalavraNaLista_1()
		throws Exception {
		UInterfaceAdicionarPalavrasEmUmaLista fixture = new UInterfaceAdicionarPalavrasEmUmaLista();
		fixture.criarJanelaEditarLista("", new UInterfaceListaPalavras());

		fixture.desfazerAdicaoPalavraNaLista();

		// add additional test code here
	}

	@Test
	public void testKeyPressed_1()
		throws Exception {
		UInterfaceAdicionarPalavrasEmUmaLista fixture = new UInterfaceAdicionarPalavrasEmUmaLista();
		fixture.criarJanelaEditarLista("", new UInterfaceListaPalavras());
		KeyEvent e = new KeyEvent(Box.createGlue(), 1, 1L, 1, 1);

		fixture.keyPressed(e);

		// add additional test code here
	}

	@Test
	public void testKeyReleased_1()
		throws Exception {
		UInterfaceAdicionarPalavrasEmUmaLista fixture = new UInterfaceAdicionarPalavrasEmUmaLista();
		fixture.criarJanelaEditarLista("", new UInterfaceListaPalavras());
		KeyEvent arg0 = new KeyEvent(Box.createGlue(), 1, 1L, 1, 1);

		fixture.keyReleased(arg0);

		// add additional test code here
	}
	@Test
	public void testAdicionar(){
		
	}

}
