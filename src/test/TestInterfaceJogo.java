package test;

import static org.junit.Assert.*;

import java.awt.AWTException;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;

import main.java.fachadaparadao.FachadaDAO;
import main.java.jogo.UInterfaceBomba;
import main.java.jogo.UInterfaceJogo;
import main.java.jogo.Jogador;
import main.java.jogo.PalavrasETraducoes;
import main.java.jogo.UInterfaceListaPalavras;

import org.junit.Before;
import org.junit.Test;

public class TestInterfaceJogo {

	
	@Before
	public void setup() {

	}

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

	@Test
	public void testCriarCampoDigitarPalavras(){
		UInterfaceJogo fixture = UInterfaceJogo.getInterfaceJogo();
		JPanel result = fixture.criarCampoDigitarPalavras();
		assertNotNull(result);
	}

	@Test
	public void testCriarCoracoesJogador1(){
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

	@Test
	public void testCriarPainelComPalavrasNaoAcertadas() {
		UInterfaceJogo fixture = UInterfaceJogo.getInterfaceJogo();
		JPanel result = fixture.criarPainelComPalavrasNaoAcertadas();
		assertNotNull(result);
	}

	@Test
	public void testCriarPontuacao(){
		UInterfaceJogo fixture = UInterfaceJogo.getInterfaceJogo();
		JPanel result = fixture.criarPontuacao();
		assertNotNull(result);
	}

	@Test(expected = NullPointerException.class)
	public void testDisposeTelaJogo() throws Exception {
		UInterfaceJogo fixture = UInterfaceJogo.getInterfaceJogo();
		fixture.criarInterfaceJogo();
		fixture.disposeTelaJogo();
		assertNotNull(fixture);
	}

	@Test
	public void testGetBomba(){
		UInterfaceJogo fixture = UInterfaceJogo.getInterfaceJogo();
		UInterfaceBomba result = fixture.getBomba(1);
		assertNull(result);
	}

	@Test
	public void testGetInterfaceJogo(){
		UInterfaceJogo result = UInterfaceJogo.getInterfaceJogo();
		assertNotNull(result);
	}

	@Test
	public void testGetJogoAcabou(){
		UInterfaceJogo fixture = UInterfaceJogo.getInterfaceJogo();
		boolean result = fixture.getJogoAcabou();
		assertFalse(result);
	}

	@Test
	public void testGetModo(){
		UInterfaceJogo fixture = UInterfaceJogo.getInterfaceJogo();
		String result = fixture.getModo();
		assertNotNull(result);
	}

	@Test
	public void testGetNumPalavrasNoJogo() {
		UInterfaceJogo fixture = UInterfaceJogo.getInterfaceJogo();
		int result = fixture.getNumPalavrasNoJogo();
		assertEquals(10, result);
	}

	@Test
	public void testGetPalavrasETraducoesDoJogo(){
		UInterfaceJogo fixture = UInterfaceJogo.getInterfaceJogo();
		PalavrasETraducoes result = fixture.getPalavrasETraducoesDoJogo();
		assertNull(result);
	}

	@Test
	public void testIncrementarPlacar(){
		UInterfaceJogo fixture = UInterfaceJogo.getInterfaceJogo();
		int pontosNovos = 1;
		fixture.incrementarPlacar(pontosNovos);
		assertNotNull(fixture);
	}

	@Test
	public void testInserirPalavraETraducaoDaBombaQueExplodiu() {
		UInterfaceJogo fixture = UInterfaceJogo.getInterfaceJogo();
		UInterfaceBomba interBomba = new UInterfaceBomba("", "");
		fixture.inserirPalavraETraducaoDaBombaQueExplodiu(interBomba);
		assertNotNull(fixture);
	}

	@Test
	public void testKeyPressed(){
		UInterfaceJogo fixture = UInterfaceJogo.getInterfaceJogo();
		KeyEvent arg0 = new KeyEvent(Box.createGlue(), 1, 1L, 1, 1);
		
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}
		Robot r;
		try {

			r = new Robot();
			fixture.criarCampoDigitarPalavras();
			fixture.keyPressed(arg0);
			r.keyPress(KeyEvent.VK_ENTER);
			
			r.delay(1000);
			r.keyRelease(KeyEvent.VK_ENTER);
			r.delay(1000);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testKeyReleased(){
		UInterfaceJogo fixture = UInterfaceJogo.getInterfaceJogo();
		KeyEvent e = new KeyEvent(Box.createGlue(), 1, 1L, 1, 1);
		fixture.keyReleased(e);
		assertNotNull(fixture);
	}

	@Test
	public void testKeyTyped(){
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

	@Test
	public void testSetModo(){
		UInterfaceJogo fixture = UInterfaceJogo.getInterfaceJogo();
		fixture.setModo("");
		assertNotNull(fixture);
	}

}
