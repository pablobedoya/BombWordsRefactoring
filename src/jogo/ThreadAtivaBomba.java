package jogo;

import java.util.LinkedList;
import java.util.Random;

public class ThreadAtivaBomba extends Thread
{
	private InterfaceJogo interfaceJogo;
	private int tempoAtivarBomba;
	private int tempoBombaExplodir;
	private LinkedList<InterfaceBomba> bombasExplodidasPeloJogador;
	
	public ThreadAtivaBomba(int tempoAtivar, int tempoExplodir, LinkedList<InterfaceBomba> bombasExplodidas)
	{
		this.interfaceJogo = InterfaceJogo.getInterfaceJogo();
		this.tempoAtivarBomba = tempoAtivar;
		tempoBombaExplodir = tempoExplodir;
		bombasExplodidasPeloJogador = bombasExplodidas;
	}
	
	public void criarEAtivarUmaBomba()
	{
		boolean umaBombaAtivada = false;
		Random geraNumAleatorio = new Random();
		int numPalavrasJogo = interfaceJogo.getNumPalavrasNoJogo();
		int numBomba = 0;
		boolean bombaJahAtiva;
		while(umaBombaAtivada == false)
		{
			numBomba = geraNumAleatorio.nextInt(20);
			bombaJahAtiva = interfaceJogo.getBomba(numBomba).ativarBomba(tempoBombaExplodir);
			if(bombaJahAtiva != true)
			{
				umaBombaAtivada = true;
			}
		}
		
		ThreadFazBombaExplodir explodeBomba = new ThreadFazBombaExplodir(interfaceJogo.getBomba(numBomba),
				numPalavrasJogo, interfaceJogo.getPalavrasETraducoesDoJogo(), tempoBombaExplodir, this.bombasExplodidasPeloJogador);
		explodeBomba.start();
	}
	
	public void run()
	{
		while(true)
		{
			try {
				Thread.sleep(tempoAtivarBomba);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.criarEAtivarUmaBomba();
		}
	}
	
	
	

}
