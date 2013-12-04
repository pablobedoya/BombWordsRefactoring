package test;

import static org.junit.Assert.*;

import java.awt.AWTException;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.Box;
import javax.swing.JButton;

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
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}
		Robot r;
		try {

			r = new Robot();
			fixture.criarJanelaEditarLista("", new UInterfaceListaPalavras());
			fixture.actionPerformed(arg0);
			JButton botaoSalvar = fixture.getSalvar();
			Point p = botaoSalvar.getLocationOnScreen();
			r.mouseMove(p.x + botaoSalvar.getWidth() / 2,
					p.y + botaoSalvar.getHeight() / 2);
			r.mousePress(InputEvent.BUTTON1_MASK);
			r.delay(1000);
			r.mouseRelease(InputEvent.BUTTON1_MASK);
			r.delay(1000);
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
	public void testCriarJanelaEditarLista() throws Exception {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}
		Robot r;
		try {

			r = new Robot();
			fixture.criarJanelaEditarLista("", new UInterfaceListaPalavras());
			JButton botaoSalvar = fixture.getSalvar();
			Point p = botaoSalvar.getLocationOnScreen();
			r.mouseMove(p.x + botaoSalvar.getWidth() / 2,
					p.y + botaoSalvar.getHeight() / 2);
			r.mousePress(InputEvent.BUTTON1_MASK);
			r.delay(1000);
			r.mouseRelease(InputEvent.BUTTON1_MASK);
			r.delay(1000);
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
	public void testDesfazerAdicaoPalavraNaLista() throws Exception {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}
		Robot r;
		try {

			r = new Robot();
			fixture.criarJanelaEditarLista("", new UInterfaceListaPalavras());
			JButton botaoDesfazer = fixture.getBotaoDesfazerAdicaoPalavra();
			Point p = botaoDesfazer.getLocationOnScreen();
			r.mouseMove(p.x + botaoDesfazer.getWidth() / 2,
					p.y + botaoDesfazer.getHeight() / 2);
			r.mousePress(InputEvent.BUTTON1_MASK);
			r.delay(1000);
			r.mouseRelease(InputEvent.BUTTON1_MASK);
			r.delay(1000);
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
	public void testKeyPressed() throws Exception {
		KeyEvent arg0 = new KeyEvent(Box.createGlue(), 1, 1L, 1, 1);

		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}
		Robot r;
		try {

			r = new Robot();
			fixture.criarJanelaEditarLista("", new UInterfaceListaPalavras());
			fixture.keyPressed(arg0);
			JButton botaoDesfazer = fixture.getBotaoDesfazerAdicaoPalavra();
			Point p = botaoDesfazer.getLocationOnScreen();
			r.mouseMove(p.x + botaoDesfazer.getWidth() / 2,
					p.y + botaoDesfazer.getHeight() / 2);
			r.mousePress(InputEvent.BUTTON1_MASK);
			r.delay(1000);
			r.mouseRelease(InputEvent.BUTTON1_MASK);
			r.delay(1000);
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
	public void testKeyReleased() throws Exception {
		KeyEvent arg0 = new KeyEvent(Box.createGlue(), 1, 1L, 1, 1);

		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}
		Robot r;
		try {

			r = new Robot();
			fixture.criarJanelaEditarLista("", new UInterfaceListaPalavras());
			fixture.keyReleased(arg0);
			JButton botaoDesfazer = fixture.getBotaoDesfazerAdicaoPalavra();
			Point p = botaoDesfazer.getLocationOnScreen();
			r.mouseMove(p.x + botaoDesfazer.getWidth() / 2,
					p.y + botaoDesfazer.getHeight() / 2);
			r.mousePress(InputEvent.BUTTON1_MASK);
			r.delay(1000);
			r.mouseRelease(InputEvent.BUTTON1_MASK);
			r.delay(1000);
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
	public void testKeyTyped()
		throws Exception {
		KeyEvent arg0 = new KeyEvent(Box.createGlue(), 1, 1L, 1, 1);

		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}
		Robot r;
		try {

			r = new Robot();
			fixture.criarJanelaEditarLista("", new UInterfaceListaPalavras());
			fixture.keyTyped(arg0);
			JButton botaoDesfazer = fixture.getBotaoDesfazerAdicaoPalavra();
			Point p = botaoDesfazer.getLocationOnScreen();
			r.mouseMove(p.x + botaoDesfazer.getWidth() / 2,
					p.y + botaoDesfazer.getHeight() / 2);
			r.mousePress(InputEvent.BUTTON1_MASK);
			r.delay(1000);
			r.mouseRelease(InputEvent.BUTTON1_MASK);
			r.delay(1000);
			r.keyPress(KeyEvent.VK_ENTER);
			r.delay(1000);
			r.keyRelease(KeyEvent.VK_ENTER);
			r.delay(1000);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
