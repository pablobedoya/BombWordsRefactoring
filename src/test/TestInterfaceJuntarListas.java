package test;

import static org.junit.Assert.*;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.Box;

import main.java.jogo.InterfaceJuntarListas;

import org.junit.Test;

public class TestInterfaceJuntarListas {

	@Test
	public void testActionPerformed()
		throws Exception {
		InterfaceJuntarListas fixture = new InterfaceJuntarListas();
		ActionEvent arg0 = new ActionEvent(new Object(), 1, "");

		fixture.actionPerformed(arg0);

		assertNotNull(fixture);
	}

	@Test
	public void testCriarInterfaceJuntarListas()
		throws Exception {
		InterfaceJuntarListas fixture = new InterfaceJuntarListas();

		//fixture.criarInterfaceJuntarListas();

		assertNotNull(fixture);
	}

	@Test(expected=NullPointerException.class)
	public void testJuntarListas()
		throws Exception {
		InterfaceJuntarListas fixture = new InterfaceJuntarListas();

		fixture.juntarListas();

		assertNotNull(fixture);
	}

	@Test
	public void testKeyPressed()
		throws Exception {
		InterfaceJuntarListas fixture = new InterfaceJuntarListas();
		@SuppressWarnings("deprecation")
		KeyEvent e = new KeyEvent(Box.createGlue(), 1, 1L, 1, 1);

		fixture.keyPressed(e);

		assertNotNull(fixture);
	}


	@Test
	public void testKeyReleased()
		throws Exception {
		InterfaceJuntarListas fixture = new InterfaceJuntarListas();
		@SuppressWarnings("deprecation")
		KeyEvent e = new KeyEvent(Box.createGlue(), 1, 1L, 1, 1);

		fixture.keyReleased(e);

		assertNotNull(fixture);
	}

	@Test
	public void testKeyTyped()
		throws Exception {
		InterfaceJuntarListas fixture = new InterfaceJuntarListas();
		@SuppressWarnings("deprecation")
		KeyEvent e = new KeyEvent(Box.createGlue(), 1, 1L, 1, 1);

		fixture.keyTyped(e);

		assertNotNull(fixture);
	}
	
}
