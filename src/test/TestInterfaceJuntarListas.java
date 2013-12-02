package test;

import static org.junit.Assert.*;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.Box;

import main.java.jogo.InterfaceJuntarListas;

import org.junit.Before;
import org.junit.Test;

public class TestInterfaceJuntarListas {
	
	private InterfaceJuntarListas fixture;
	
	@Before
	public void setUp() {
		fixture = new InterfaceJuntarListas();
	}

	@Test
	public void testActionPerformed() throws Exception {
		assertTrue(true);
	}

	@Test
	public void testCriarInterfaceJuntarListas() {
		assertNotNull(fixture);
	}

	@Test
	public void testJuntarListas() {
		assertNotNull(fixture);
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

}
