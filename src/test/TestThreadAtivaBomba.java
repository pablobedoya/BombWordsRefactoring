package test;

import java.util.LinkedList;

import main.java.jogo.ThreadAtivaBomba;

import org.junit.Before;
import org.junit.Test;

public class TestThreadAtivaBomba {

	private ThreadAtivaBomba fixture;
	
	@Before
	public void setUp() {
		fixture = new ThreadAtivaBomba(1, 1, new LinkedList());
	}
	
	@Test(expected = Exception.class)
	public void testCriarEAtivarUmaBomba() throws Exception {
		fixture.criarEAtivarUmaBomba();
	}
	
	@Test
	public void testRun() {
		fixture.start();
	}
	
}
