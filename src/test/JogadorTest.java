package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import main.java.jogo.InterfaceJogo;
import main.java.jogo.Jogador;

public class JogadorTest {

	public Jogador jogador;
	public InterfaceJogo interfaceJogo;

	@Before
	public void Setup() {
		jogador = new Jogador("josiel");
	}

	@Test
	public void testgetNome() {
		jogador.getNome();
		assertEquals("josiel", jogador.getNome());
	}

	@Test
	public void testgetPOntosVida() {
		jogador.getPontosVida();
	}

	@Test
	public void testSetNome() {
		jogador.setNome("Pablo");
		assertEquals("Pablo", jogador.getNome());
	}

	@Test
	public void testDecrementarPlacar() {
		jogador.decrementarPlacar(1);
		assertEquals(-1, jogador.getPlacar());
	}

	@After
	public void tearDown() {

		jogador = null;

	}

}
