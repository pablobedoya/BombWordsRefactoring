package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.awt.event.KeyEvent;

import javax.swing.Box;
import javax.swing.JPanel;

import main.java.jogo.InterfaceBomba;
import main.java.jogo.InterfaceJogo;
import main.java.jogo.Jogador;
import main.java.jogo.PalavrasETraducoes;

import org.junit.Test;

public class TestInterfaceJogo {
/*
	@Test(expected = NullPointerException.class)
	public void testGetInterfaceJogo() {
		assertNotNull(InterfaceJogo.getInterfaceJogo());

	}

	@Test(expected = NullPointerException.class)
	public void testGetPalavrasETraducoesDoJogo() {
		assertNotNull(InterfaceJogo.getInterfaceJogo()
				.getPalavrasETraducoesDoJogo());
	}

	@Test(expected = NullPointerException.class)
	public void testGetNumPalavrasNoJogo() {
		assertEquals(0, InterfaceJogo.getInterfaceJogo().getNumPalavrasNoJogo());
	}
*/
	@Test(expected = NullPointerException.class)
	public void testCriarCampoBombas() throws Exception {
		InterfaceJogo fixture = InterfaceJogo.getInterfaceJogo();
		JPanel result = fixture.criarCampoBombas();
		assertNotNull(result);
	}

	@Test(expected = NullPointerException.class)
	public void testCriarCampoDigitarPalavras() throws Exception {
		InterfaceJogo fixture = InterfaceJogo.getInterfaceJogo();
		JPanel result = fixture.criarCampoDigitarPalavras();
		assertNotNull(result);
	}

	@Test(expected = NullPointerException.class)
	public void testCriarCoracoesJogador1() throws Exception {
		InterfaceJogo fixture = InterfaceJogo.getInterfaceJogo();
		JPanel result = fixture.criarCoracoesJogador1();
		assertNotNull(result);
	}

	@Test(expected = NullPointerException.class)
	public void testCriarInterfaceJogo() throws Exception {
		InterfaceJogo fixture = InterfaceJogo.getInterfaceJogo();
		fixture.criarInterfaceJogo();
		assertNotNull(fixture);
	}

	@Test(expected = NullPointerException.class)
	public void testCriarPainelComPalavrasNaoAcertadas() throws Exception {
		InterfaceJogo fixture = InterfaceJogo.getInterfaceJogo();
		JPanel result = fixture.criarPainelComPalavrasNaoAcertadas();
		assertNotNull(result);
	}

	@Test(expected = NullPointerException.class)
	public void testCriarPontuacao() throws Exception {
		InterfaceJogo fixture = InterfaceJogo.getInterfaceJogo();
		JPanel result = fixture.criarPontuacao();
		assertNotNull(result);
	}

	@Test(expected = NullPointerException.class)
	public void testDisposeTelaJogo() throws Exception {
		InterfaceJogo fixture = InterfaceJogo.getInterfaceJogo();
		fixture.disposeTelaJogo();
		assertNotNull(fixture);
	}

	@Test(expected = NullPointerException.class)
	public void testGetBomba() throws Exception {
		InterfaceJogo fixture = InterfaceJogo.getInterfaceJogo();
		InterfaceBomba result = fixture.getBomba(1);
		assertNotNull(result);
	}

	@Test(expected = NullPointerException.class)
	public void testGetInterfaceJogo() throws Exception {
		InterfaceJogo result = InterfaceJogo.getInterfaceJogo();
		assertNotNull(result);
	}

	@Test(expected = NullPointerException.class)
	public void testGetJogoAcabou() throws Exception {
		InterfaceJogo fixture = InterfaceJogo.getInterfaceJogo();
		boolean result = fixture.getJogoAcabou();
		assertTrue(result);
	}

	@Test(expected = NullPointerException.class)
	public void testGetModo() throws Exception {
		InterfaceJogo fixture = InterfaceJogo.getInterfaceJogo();
		String result = fixture.getModo();
		assertNotNull(result);
	}

	@Test(expected = NullPointerException.class)
	public void testGetNumPalavrasNoJogo() throws Exception {
		InterfaceJogo fixture = InterfaceJogo.getInterfaceJogo();
		int result = fixture.getNumPalavrasNoJogo();
		assertEquals(0, result);
	}

	@Test(expected = NullPointerException.class)
	public void testGetPalavrasETraducoesDoJogo() throws Exception {
		InterfaceJogo fixture = InterfaceJogo.getInterfaceJogo();
		PalavrasETraducoes result = fixture.getPalavrasETraducoesDoJogo();
		assertNotNull(result);
	}

	@Test(expected = NullPointerException.class)
	public void testIncrementarPlacar() throws Exception {
		InterfaceJogo fixture = InterfaceJogo.getInterfaceJogo();
		int pontosNovos = 1;
		fixture.incrementarPlacar(pontosNovos);
		assertNotNull(fixture);
	}

	@Test(expected = NullPointerException.class)
	public void testInserirPalavraETraducaoDaBombaQueExplodiu()
			throws Exception {
		InterfaceJogo fixture = InterfaceJogo.getInterfaceJogo();
		InterfaceBomba interBomba = new InterfaceBomba("", "");
		fixture.inserirPalavraETraducaoDaBombaQueExplodiu(interBomba);
		assertNotNull(fixture);
	}

	@Test(expected = NullPointerException.class)
	public void testKeyPressed() throws Exception {
		InterfaceJogo fixture = InterfaceJogo.getInterfaceJogo();
		KeyEvent e = new KeyEvent(Box.createGlue(), 1, 1L, 1, 1);
		fixture.keyPressed(e);
		assertNotNull(fixture);
	}

	@Test(expected = NullPointerException.class)
	public void testKeyReleased() throws Exception {
		InterfaceJogo fixture = InterfaceJogo.getInterfaceJogo();
		KeyEvent e = new KeyEvent(Box.createGlue(), 1, 1L, 1, 1);
		fixture.keyReleased(e);
		assertNotNull(fixture);
	}

	@Test(expected = NullPointerException.class)
	public void testKeyTyped() throws Exception {
		InterfaceJogo fixture = InterfaceJogo.getInterfaceJogo();
		KeyEvent e = new KeyEvent(Box.createGlue(), 1, 1L, 1, 1);
		fixture.keyTyped(e);
		assertNotNull(fixture);
	}

	@Test(expected = NullPointerException.class)
	public void testReduzirCoracao() throws Exception {
		InterfaceJogo fixture = InterfaceJogo.getInterfaceJogo();
		Jogador jogador = new Jogador("");
		fixture.reduzirCoracao(jogador);
		assertNotNull(fixture);
	}

	@Test(expected = NullPointerException.class)
	public void testSetModo() throws Exception {
		InterfaceJogo fixture = InterfaceJogo.getInterfaceJogo();
		fixture.setModo("");
		assertNotNull(fixture);
	}

}
