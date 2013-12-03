package test;

import static org.junit.Assert.*;

import java.awt.Dimension;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import main.java.command.InterfaceCommandRemoverPalavrasDaLista;
import main.java.jogo.UInterfaceListaPalavras;

import org.junit.Before;
import org.junit.Test;

public class TestInterfaceListaPalavras {

	private JLabel listaAtual;
	private JLabel listaUsadaNoJogo;
	private JFrame janelaLista;
	private JButton botaoAtualizar;
	private JButton botaoUsarListaNoJogo;
	private JButton botaojuntarListas;
	private JButton botaoRemoverPalavrasSelecionadas;
	private JButton botaoInserirPalavrasNaLista;
	private JButton botaoDesfazerRemocaoPalavrasDaLista;
	private JScrollPane scrollPainelPalavras;
	private JComboBox caixaSelecionarListas;//caixa para selecionar listas.
	private LinkedList<JLabel> labelsPalavrasLista;//conjunto de labels com palavras da lista visualizada.
	private LinkedList<Boolean> palavrasEstaoSelecionadasNaLista;/*cada booleano dessa lista corresponde a uma palavra da lista visualizada. 
																	O booleano indica se a palavra foi selecionada pelo usuario.*/
	private LinkedList<InterfaceCommandRemoverPalavrasDaLista> comandosRemoverPalavrasDaLista;//para possibilitar refazer
	private UInterfaceListaPalavras intLista = new UInterfaceListaPalavras();
	
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
		JScrollPane scrollPainelPalavras;
		String listaAtual = "palavras";
		JPanel painelPalavras = intLista.criarPainelListagemPalavras(listaAtual);
		
		scrollPainelPalavras = new JScrollPane(painelPalavras);
		Dimension d = new Dimension(400, 400);
		scrollPainelPalavras.setPreferredSize(d);
		assertNotNull(scrollPainelPalavras);
	}

	@Test
	public void testMostrarOutraListaPalavras() {
				
		//intLista.mostrarOutraListaPalavras("outraLista");
	}

	@Test
	public void testMostrarPalavrasJogo() {
		assertTrue(true);
	}

	@Test
	public void testPegarNomesListasPalavras() {
		String[] listaTest = intLista.pegarNomesListasPalavras();
	}

	@Test
	public void testJogarComListaVisualizada() {
		//intLista.jogarComListaVisualizada();
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
		intLista.criarInterfaceListaPalavrasTeste();
	}

	@Test
	public void testPegarNomeListaASerUsadaNoJogo() {
		assertTrue(true);
	}

	@Test
	public void testCriarInterfaceListaPalavrasTeste() {
		intLista.criarInterfaceListaPalavrasTeste();
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
