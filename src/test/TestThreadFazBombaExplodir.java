package test;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import main.java.jogo.PalavrasETraducoes;
import main.java.jogo.ThreadFazBombaExplodir;
import main.java.jogo.UInterfaceBomba;

public class TestThreadFazBombaExplodir {

	private ThreadFazBombaExplodir fixture;
	
	@Before
	public void setUp() {
		UInterfaceBomba bomb = new UInterfaceBomba("", "");
		int quantasPalavrasJogo = 1;
		PalavrasETraducoes palavrasETraducoes = new PalavrasETraducoes(new LinkedList(), new LinkedList());
		int tempoAteBombaExplodir = 1;
		LinkedList<UInterfaceBomba> bombasExplodidas = new LinkedList();
		
		fixture = new ThreadFazBombaExplodir(bomb, quantasPalavrasJogo, palavrasETraducoes, tempoAteBombaExplodir, bombasExplodidas);
	}
	
	@Test
	public void testDesativarBomba() {
		fixture.desativarBomba();
	}
	
	@Test
	public void testInserirNovaBombaExplodidaPeloJogador() {
		fixture.inserirNovaBombaExplodidaPeloJogador();
	}
	
	@Test
	public void testMudarModoParaExplodiu() {
		fixture.mudarModoParaExplodiu();
	}
	
	@Test
	public void testRun() {
		fixture.start();
	}
	
}
