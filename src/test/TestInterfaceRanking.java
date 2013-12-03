package test;

import static org.junit.Assert.*;

import java.awt.event.ActionEvent;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.java.jogo.UInterfaceRanking;

public class TestInterfaceRanking {

	UInterfaceRanking interfaceRanking;

	@Before
	public void setUp() throws Exception {
		interfaceRanking = new UInterfaceRanking();
	}

	@Test
	public void testInterfaceRanking() {
		assertNotNull(interfaceRanking);
	}
	
	@Test
	public void testActionPerformed1() {
		ActionEvent arg0 = new ActionEvent(new Object(), 1, "");
		interfaceRanking.actionPerformed(arg0);
	}
	
	@Test
	public void testActionPerformed2() {
		ActionEvent arg0 = new ActionEvent(new Object(), 0, "aaaaaaaaaa");
		interfaceRanking.actionPerformed(arg0);
	}

	@After
	public void tearDown() throws Exception {
		interfaceRanking = null;
	}
	
}
