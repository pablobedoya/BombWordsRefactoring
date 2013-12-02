package test;

import java.util.LinkedList;

import main.java.jogo.InterfaceBomba;
import main.java.jogo.InterfacePalavrasJogadorErrou;
import org.junit.*;
import static org.junit.Assert.*;

public class TestInterfacePalavrasJogadorErrou {

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void testInterfacePalavrasJogadorErrou() {
		
		LinkedList<InterfaceBomba> bombasExplodidas = new LinkedList<InterfaceBomba>();
		InterfacePalavrasJogadorErrou errouPalavra = new InterfacePalavrasJogadorErrou(bombasExplodidas);
		assertNotNull(errouPalavra);
	}


	@Test
	public void testCriarTelaInterfacePalavrasJogadorErrou() {
		
		InterfacePalavrasJogadorErrou jogadorErrou = new InterfacePalavrasJogadorErrou(new LinkedList<InterfaceBomba>());
		jogadorErrou.criarTelaInterfacePalavrasJogadorErrou();
	}

	/*
	@Test
	public void testEscrever() throws Exception {
		InterfacePalavrasJogadorErrou fixture = new InterfacePalavrasJogadorErrou(new LinkedList<InterfaceBomba>());
		String aSerEscrita = "";
		fixture.escrever(aSerEscrita);
	}*/

	@Test
	public void testInformarPalavrasErradasETraducao() {
		InterfacePalavrasJogadorErrou palavraErrada = new InterfacePalavrasJogadorErrou(new LinkedList<InterfaceBomba>());
		palavraErrada.informarPalavrasErradasETraducao();
	}

	@Test
	public void testMain() {
		String[] args = new String[] {};
		InterfacePalavrasJogadorErrou.main(args);
	}
}
