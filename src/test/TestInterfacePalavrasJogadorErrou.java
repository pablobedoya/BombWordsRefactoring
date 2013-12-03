package test;

import java.util.LinkedList;

import main.java.jogo.UInterfaceBomba;
import main.java.jogo.UInterfacePalavrasJogadorErrou;
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
		
		LinkedList<UInterfaceBomba> bombasExplodidas = new LinkedList<UInterfaceBomba>();
		UInterfacePalavrasJogadorErrou errouPalavra = new UInterfacePalavrasJogadorErrou(bombasExplodidas);
		assertNotNull(errouPalavra);
	}


	@Test
	public void testCriarTelaInterfacePalavrasJogadorErrou() {
		
		UInterfacePalavrasJogadorErrou jogadorErrou = new UInterfacePalavrasJogadorErrou(new LinkedList<UInterfaceBomba>());
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
		UInterfacePalavrasJogadorErrou palavraErrada = new UInterfacePalavrasJogadorErrou(new LinkedList<UInterfaceBomba>());
		palavraErrada.informarPalavrasErradasETraducao();
	}

	@Test
	public void testMain() {
		String[] args = new String[] {};
		UInterfacePalavrasJogadorErrou.main(args);
	}
}
