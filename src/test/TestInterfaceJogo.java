package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.awt.event.KeyEvent;

import javax.swing.Box;
import javax.swing.JPanel;

import main.java.jogo.UInterfaceBomba;
import main.java.jogo.UInterfaceJogo;
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
		UInterfaceJogo fixture = UInterfaceJogo.getInterfaceJogo();
		JPanel result = fixture.criarCampoBombas();
		assertNotNull(result);
	}

	@Test(expected = NullPointerException.class)
	public void testCriarCampoDigitarPalavras() throws Exception {
		UInterfaceJogo fixture = UInterfaceJogo.getInterfaceJogo();
		JPanel result = fixture.criarCampoDigitarPalavras();
		assertNotNull(result);
	}

	@Test(expected = NullPointerException.class)
	public void testCriarCoracoesJogador1() throws Exception {
		UInterfaceJogo fixture = UInterfaceJogo.getInterfaceJogo();
		JPanel result = fixture.criarCoracoesJogador1();
		assertNotNull(result);
	}

	@Test(expected = NullPointerException.class)
	public void testCriarInterfaceJogo() throws Exception {
		UInterfaceJogo fixture = UInterfaceJogo.getInterfaceJogo();
		fixture.criarInterfaceJogo();
		assertNotNull(fixture);
	}

	@Test(expected = NullPointerException.class)
	public void testCriarPainelComPalavrasNaoAcertadas() throws Exception {
		UInterfaceJogo fixture = UInterfaceJogo.getInterfaceJogo();
		JPanel result = fixture.criarPainelComPalavrasNaoAcertadas();
		assertNotNull(result);
	}

	@Test(expected = NullPointerException.class)
	public void testCriarPontuacao() throws Exception {
		UInterfaceJogo fixture = UInterfaceJogo.getInterfaceJogo();
		JPanel result = fixture.criarPontuacao();
		assertNotNull(result);
	}

	@Test(expected = NullPointerException.class)
	public void testDisposeTelaJogo() throws Exception {
		UInterfaceJogo fixture = UInterfaceJogo.getInterfaceJogo();
		fixture.disposeTelaJogo();
		assertNotNull(fixture);
	}

	@Test(expected = NullPointerException.class)
	public void testGetBomba() throws Exception {
		UInterfaceJogo fixture = UInterfaceJogo.getInterfaceJogo();
		UInterfaceBomba result = fixture.getBomba(1);
		assertNotNull(result);
	}

	@Test(expected = NullPointerException.class)
	public void testGetInterfaceJogo() throws Exception {
		UInterfaceJogo result = UInterfaceJogo.getInterfaceJogo();
		assertNotNull(result);
	}

	@Test(expected = NullPointerException.class)
	public void testGetJogoAcabou() throws Exception {
		UInterfaceJogo fixture = UInterfaceJogo.getInterfaceJogo();
		boolean result = fixture.getJogoAcabou();
		assertTrue(result);
	}

	@Test(expected = NullPointerException.class)
	public void testGetModo() throws Exception {
		UInterfaceJogo fixture = UInterfaceJogo.getInterfaceJogo();
		String result = fixture.getModo();
		assertNotNull(result);
	}

	@Test(expected = NullPointerException.class)
	public void testGetNumPalavrasNoJogo() throws Exception {
		UInterfaceJogo fixture = UInterfaceJogo.getInterfaceJogo();
		int result = fixture.getNumPalavrasNoJogo();
		assertEquals(0, result);
	}

	@Test(expected = NullPointerException.class)
	public void testGetPalavrasETraducoesDoJogo() throws Exception {
		UInterfaceJogo fixture = UInterfaceJogo.getInterfaceJogo();
		PalavrasETraducoes result = fixture.getPalavrasETraducoesDoJogo();
		assertNotNull(result);
	}

	@Test(expected = NullPointerException.class)
	public void testIncrementarPlacar() throws Exception {
		UInterfaceJogo fixture = UInterfaceJogo.getInterfaceJogo();
		int pontosNovos = 1;
		fixture.incrementarPlacar(pontosNovos);
		assertNotNull(fixture);
	}

	@Test(expected = NullPointerException.class)
	public void testInserirPalavraETraducaoDaBombaQueExplodiu()
			throws Exception {
		UInterfaceJogo fixture = UInterfaceJogo.getInterfaceJogo();
		UInterfaceBomba interBomba = new UInterfaceBomba("", "");
		fixture.inserirPalavraETraducaoDaBombaQueExplodiu(interBomba);
		assertNotNull(fixture);
	}

	@Test(expected = NullPointerException.class)
	public void testKeyPressed() throws Exception {
		UInterfaceJogo fixture = UInterfaceJogo.getInterfaceJogo();
		KeyEvent e = new KeyEvent(Box.createGlue(), 1, 1L, 1, 1);
		fixture.keyPressed(e);
		assertNotNull(fixture);
	}

	@Test(expected = NullPointerException.class)
	public void testKeyReleased() throws Exception {
		UInterfaceJogo fixture = UInterfaceJogo.getInterfaceJogo();
		KeyEvent e = new KeyEvent(Box.createGlue(), 1, 1L, 1, 1);
		fixture.keyReleased(e);
		assertNotNull(fixture);
	}

	@Test(expected = NullPointerException.class)
	public void testKeyTyped() throws Exception {
		UInterfaceJogo fixture = UInterfaceJogo.getInterfaceJogo();
		KeyEvent e = new KeyEvent(Box.createGlue(), 1, 1L, 1, 1);
		fixture.keyTyped(e);
		assertNotNull(fixture);
	}

	@Test(expected = NullPointerException.class)
	public void testReduzirCoracao() throws Exception {
		UInterfaceJogo fixture = UInterfaceJogo.getInterfaceJogo();
		Jogador jogador = new Jogador("");
		fixture.reduzirCoracao(jogador);
		assertNotNull(fixture);
	}

	@Test(expected = NullPointerException.class)
	public void testSetModo() throws Exception {
		UInterfaceJogo fixture = UInterfaceJogo.getInterfaceJogo();
		fixture.setModo("");
		assertNotNull(fixture);
	}

}
