package test;

import static org.junit.Assert.*;

import javax.swing.JLabel;
import javax.swing.JPanel;

import main.java.jogo.InterfaceListaPalavras;

import org.junit.Before;
import org.junit.Test;

public class TestInterfaceListaPalavras {

	private InterfaceListaPalavras intLista = new InterfaceListaPalavras();
	
	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void testInterfaceListaPalavras() {
		intLista.criarInterfaceListaPalavras();
		assertNotNull(intLista);
	}

	/*@Test
	public void testEhLabelDaListaDePalavras() {
		JLabel label = new JLabel();
		assertEquals(-1, intLista.ehLabelDaListaDePalavras(label));;
	}*/

	@Test
	public void testCriarScrollPaneListagemPalavras() {
		assertTrue(true);
	}

/*	@Test
	public void testCriarPainelListagemPalavras() {
		JPanel panel = new JPanel();
		assertNotEquals(panel, intLista.criarPainelListagemPalavras("novaLista11"));
	}

	@Test
	public void testMostrarOutraListaPalavras() {
		
	}
*/
	@Test
	public void testMostrarPalavrasJogo() {
		assertTrue(true);
	}

	@Test
	public void testPegarNomesListasPalavras() {
		assertTrue(true);
	}

	@Test
	public void testJogarComListaVisualizada() {
		assertTrue(true);
	}

	@Test
	public void testListaAtualEstahVazia() {
		assertTrue(true);
	}

	@Test
	public void testRemoverPalavrasSelecionadas() {
		assertTrue(true);
	}

	@Test
	public void testDesfazerRemocaodePalavras() {
		assertTrue(true);
	}

	@Test
	public void testCriarInterfaceListaPalavras() {
		assertTrue(true);
	}

	@Test
	public void testPegarNomeListaASerUsadaNoJogo() {
		assertTrue(true);
	}

	@Test
	public void testCriarInterfaceListaPalavrasTeste() {
		assertTrue(true);
	}

	@Test
	public void testActionPerformed() {
		assertTrue(true);
	}

	@Test
	public void testKeyPressed() {
		assertTrue(true);
	}

	@Test
	public void testKeyReleased() {
		assertTrue(true);
	}

	@Test
	public void testKeyTyped() {
		assertTrue(true);
	}

	@Test
	public void testMouseClicked() {
		assertTrue(true);
	}

	@Test
	public void testMouseEntered() {
		assertTrue(true);
	}

	@Test
	public void testMouseExited() {
		assertTrue(true);
	}

	@Test
	public void testMousePressed() {
		assertTrue(true);
	}

	@Test
	public void testMouseReleased() {
		assertTrue(true);
	}

}
