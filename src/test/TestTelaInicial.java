package test;

import static org.junit.Assert.*;
import main.java.jogo.TelaInicial;

import org.junit.Before;
import org.junit.Test;

public class TestTelaInicial {
	
	TelaInicial tela = new TelaInicial();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testTelaInicial() {
		tela.criarTelaInicial();
		assertNotNull(tela);
	}

	@Test
	public void testGetNomeJogador() {
		assertNull(tela.getNomeJogador());
	}

	@Test
	public void testCriarTelaInicial() {
		tela.criarTelaInicial();
		assertNotNull(tela);
	}
/*
	@Test
	public void testActionPerformed() {
		
	}
*/
}
