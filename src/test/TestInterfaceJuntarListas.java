package test;

import java.awt.AWTException;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.Box;
import javax.swing.JButton;

import main.java.jogo.UInterfaceJuntarListas;

import org.junit.Before;
import org.junit.Test;

public class TestInterfaceJuntarListas {

	private UInterfaceJuntarListas fixture;

	@Before
	public void setUp() {
		fixture = new UInterfaceJuntarListas();
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
			fixture.criarInterfaceJuntarListas();
			fixture.actionPerformed(arg0);
			JButton botaoSalvar = fixture.getJuntarListas();
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
	public void testCriarInterfaceJuntarListas() {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}
		Robot r;
		try {

			r = new Robot();
			fixture.criarInterfaceJuntarListas();
			JButton botaoSalvar = fixture.getJuntarListas();
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
	public void testJuntarListas() {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}
		Robot r;
		try {

			r = new Robot();
			fixture.criarInterfaceJuntarListas();
			JButton botaoSalvar = fixture.getJuntarListas();
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
	public void testKeyPressed() {
		KeyEvent arg0 = new KeyEvent(Box.createGlue(), 1, 1L, 1, 1);

		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}
		Robot r;
		try {

			r = new Robot();
			fixture.criarInterfaceJuntarListas();
			fixture.keyPressed(arg0);
			JButton botaoDesfazer = fixture.getJuntarListas();
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
	public void testKeyReleased() {
		KeyEvent arg0 = new KeyEvent(Box.createGlue(), 1, 1L, 1, 1);

		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}
		Robot r;
		try {

			r = new Robot();
			fixture.criarInterfaceJuntarListas();
			fixture.keyPressed(arg0);
			JButton botaoDesfazer = fixture.getJuntarListas();
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
	public void testKeyTyped() {
		KeyEvent arg0 = new KeyEvent(Box.createGlue(), 1, 1L, 1, 1);

		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}
		Robot r;
		try {

			r = new Robot();
			fixture.criarInterfaceJuntarListas();
			fixture.keyPressed(arg0);
			JButton botaoDesfazer = fixture.getJuntarListas();
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
