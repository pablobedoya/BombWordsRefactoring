package test;

import static org.junit.Assert.*;

import java.awt.AWTException;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JButton;

import main.java.jogo.UInterfaceEditarListasJogo;

import org.junit.Before;
import org.junit.Test;

public class TestInterfaceEditarListasJogo {
	private UInterfaceEditarListasJogo fixture;

	@Before
	public void setUp() {
		fixture = new UInterfaceEditarListasJogo();
	}

	@Test
	public void testActionPerformed1() {
		ActionEvent arg0 = new ActionEvent(new Object(), 1, "");
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}
		Robot r;
		try {

			r = new Robot();
			fixture.criarInterfaceEditarListasJogo();
			fixture.actionPerformed(arg0);
			JButton criarNovaLista = fixture.getCriarNovaLista();
			Point p = criarNovaLista.getLocationOnScreen();
			r.mouseMove(p.x + criarNovaLista.getWidth() / 2,
					p.y + criarNovaLista.getHeight() / 2);
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
	public void testActionPerformed2() {
		ActionEvent arg0 = new ActionEvent(new Object(), 1, "");
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}
		Robot r;
		try {

			r = new Robot();
			fixture.criarInterfaceEditarListasJogo();
			fixture.actionPerformed(arg0);
			JButton editarPalavrasDasListas = fixture.getEditarPalavrasDasListas();
			Point p = editarPalavrasDasListas.getLocationOnScreen();
			r.mouseMove(p.x + editarPalavrasDasListas.getWidth() / 2,
					p.y + editarPalavrasDasListas.getHeight() / 2);
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
	public void testActionPerformed3() {
		ActionEvent arg0 = new ActionEvent(new Object(), 1, "");
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}
		Robot r;
		try {

			r = new Robot();
			fixture.criarInterfaceEditarListasJogo();
			fixture.actionPerformed(arg0);
			JButton limparLista = fixture.getLimparLista();
			Point p = limparLista.getLocationOnScreen();
			r.mouseMove(p.x + limparLista.getWidth() / 2,
					p.y + limparLista.getHeight() / 2);
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
	public void testActionPerformed4() {
		ActionEvent arg0 = new ActionEvent(new Object(), 1, "");
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}
		Robot r;
		try {

			r = new Robot();
			fixture.criarInterfaceEditarListasJogo();
			fixture.actionPerformed(arg0);
			JButton removerLista = fixture.getRemoverLista();
			Point p = removerLista.getLocationOnScreen();
			r.mouseMove(p.x + removerLista.getWidth() / 2,
					p.y + removerLista.getHeight() / 2);
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
	public void testAdicionarNovaListaNaComboBox() {
		fixture.criarInterfaceEditarListasJogo();
		fixture.adicionarNovaListaNaComboBox("");
	}
	
	@Test
	public void testCriarInterfaceEditarListasJogo() {
		fixture.criarInterfaceEditarListasJogo();
		assertNotNull(fixture);
	}
	
	@Test
	public void testCriarNovaListaPalavras() throws Exception {
		String nomeLista = "";
		fixture.criarInterfaceEditarListasJogo();
		boolean result = fixture.criarNovaListaPalavras(nomeLista);
		assertTrue(result);
	}
	
	@Test
	public void testLimparListaPalavras() {
		assertNotNull(fixture);
	}

	@Test
	public void testOrdenarPalavrasLista() throws Exception {
		String[] palavras = new String[] { "", "" };
		String[] result = fixture.ordenarPalavrasLista(palavras);
		assertNotNull(result);
		assertEquals(2, result.length);
		assertEquals("", result[0]);
		assertEquals("", result[1]);
	}
	
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testRemoverListaDaComboBox() {
		fixture.criarInterfaceEditarListasJogo();
		fixture.removerListaDaComboBox("");
	}

	@Test
	public void testRemoverListaPalavras() throws Exception {
		String nomeLista = "";
		fixture.criarInterfaceEditarListasJogo();
		boolean result = fixture.removerListaPalavras(nomeLista);
		assertFalse(result);
	}

}
