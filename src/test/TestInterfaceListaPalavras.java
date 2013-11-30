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
		fail("Not yet implemented");
	}

	@Test
	public void testCriarPainelListagemPalavras() {
		JPanel panel = new JPanel();
		assertNotEquals(panel, intLista.criarPainelListagemPalavras("novaLista11"));
	}

	@Test
	public void testMostrarOutraListaPalavras() {
		intLista.mostrarOutraListaPalavras("novaLista");
		assertNull(intLista);
	}

	@Test
	public void testMostrarPalavrasJogo() {
		fail("Not yet implemented");
	}

	@Test
	public void testPegarNomesListasPalavras() {
		fail("Not yet implemented");
	}

	@Test
	public void testJogarComListaVisualizada() {
		fail("Not yet implemented");
	}

	@Test
	public void testListaAtualEstahVazia() {
		assertTrue(intLista.listaAtualEstahVazia());
	}

	@Test
	public void testRemoverPalavrasSelecionadas() {
		fail("Not yet implemented");
	}

	@Test
	public void testDesfazerRemocaodePalavras() {
		fail("Not yet implemented");
	}

	@Test
	public void testCriarInterfaceListaPalavras() {
		fail("Not yet implemented");
	}

	@Test
	public void testPegarNomeListaASerUsadaNoJogo() {
		fail("Not yet implemented");
	}

	@Test
	public void testCriarInterfaceListaPalavrasTeste() {
		fail("Not yet implemented");
	}

	@Test
	public void testActionPerformed() {
		fail("Not yet implemented");
	}

	@Test
	public void testKeyPressed() {
		fail("Not yet implemented");
	}

	@Test
	public void testKeyReleased() {
		fail("Not yet implemented");
	}

	@Test
	public void testKeyTyped() {
		fail("Not yet implemented");
	}

	@Test
	public void testMouseClicked() {
		fail("Not yet implemented");
	}

	@Test
	public void testMouseEntered() {
		fail("Not yet implemented");
	}

	@Test
	public void testMouseExited() {
		fail("Not yet implemented");
	}

	@Test
	public void testMousePressed() {
		fail("Not yet implemented");
	}

	@Test
	public void testMouseReleased() {
		fail("Not yet implemented");
	}

}
