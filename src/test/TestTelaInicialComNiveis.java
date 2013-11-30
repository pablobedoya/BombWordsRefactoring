package test;

import static org.junit.Assert.*;
import main.java.jogo.TelaInicial;
import main.java.jogo.TelaInicialComNiveis;

import org.junit.Before;
import org.junit.Test;

public class TestTelaInicialComNiveis {

	TelaInicialComNiveis telaInicial;

	@Before
	public void setUp() throws Exception {
		telaInicial = new TelaInicialComNiveis();
	}

	@Test
	public void testGetNomeJogador() {
		try {
			telaInicial.getNomeJogador();
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testCriarTelaInicial() {
		try {
			telaInicial.criarTelaInicial();
		} catch (Exception e) {
			fail();
		}
		
	}

	@Test
	public void testActionPerformed() {
		
	}

	@Test
	public void testDefinirUmaNovaListaDePalavrasPrincipal() {
		try {
			telaInicial.definirUmaNovaListaDePalavrasPrincipal();
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testDefinirConfiguracoesDoJogo() {
		try {
			telaInicial.criarTelaInicial();
			telaInicial.definirConfiguracoesDoJogo();
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testItemStateChanged() {

	}

}
