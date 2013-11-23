package jogo;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class ThreadFazBombaExplodir extends Thread
{
	int contadorBomba;
	InterfaceBomba bomba;
	InterfaceJogo interfaceJogo;
	PalavrasETraducoes palavrasETraducoesDoJogo;
	private int quantasPalavrasNoJogo;
	LinkedList<InterfaceBomba> bombasExplodidasPeloJogador; 
	//lista de bombas que o jogador j· conseguiu explodir(ele n√£o acertou a traduc√£o a tempo)
	
	public ThreadFazBombaExplodir(InterfaceBomba bomb, int quantasPalavrasJogo,
			PalavrasETraducoes palavrasETraducoes, int tempoAteBombaExplodir, LinkedList<InterfaceBomba> bombasExplodidas)
	{
		bomba = bomb;
		contadorBomba = tempoAteBombaExplodir;
		interfaceJogo = InterfaceJogo.getInterfaceJogo();
		quantasPalavrasNoJogo = quantasPalavrasJogo;
		palavrasETraducoesDoJogo = palavrasETraducoes;
		bombasExplodidasPeloJogador = bombasExplodidas;
	}
	
	@SuppressWarnings("deprecation")
	public void run()
	{
		while(interfaceJogo.getJogoAcabou() == false)
		{
			try 
			{
				Thread.sleep(1000);
				if(bomba.getAtivada() == true)
				{
					if(contadorBomba > 1)
					{
						contadorBomba = contadorBomba - 1;
						String caminhoParaImagemBomba = "imagens/bomba" + contadorBomba + ".gif";
						ImageIcon novaBomba = CriadorImageIcon.criarImageIcon(caminhoParaImagemBomba, "bomba fica mais explosiva");
						JLabel labelBomba = bomba.getLabelBomba();
						labelBomba.setIcon(novaBomba);
					}
					else
					{
						contadorBomba = 0;
						bomba.setAtivada(false);
						ImageIcon novaBomba = CriadorImageIcon.criarImageIcon("imagens/bombaExplode.gif", "bomba explodiu");
						novaBomba.getImage().flush();
						JLabel labelBomba = bomba.getLabelBomba();
						labelBomba.setIcon(novaBomba);
						mudarModoParaExplodiu();
					}
				}
				else
				{
					this.desativarBomba();
					this.stop();
				}
			} 
			catch (InterruptedException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public void mudarModoParaExplodiu()
	{
		interfaceJogo.setModo("explodiu");
		//adicionar a bomba a lista de bombas que o usuario explodiu
		this.inserirNovaBombaExplodidaPeloJogador();
		
		//gerar nova palavra e traduc√£o para a nova Bomba.
		Random geraAleatorio = new Random();
		int numAleatorio = geraAleatorio.nextInt(quantasPalavrasNoJogo);
		String novaPalavra = this.palavrasETraducoesDoJogo.getPalavra(numAleatorio);
		String novaTraducao = this.palavrasETraducoesDoJogo.getTraducao(numAleatorio);
		
		this.bomba.setPalavra(novaPalavra);
		this.bomba.setTraducao(novaTraducao);
		
		try 
		{
			Thread.sleep(1000);
		} 
		catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.bomba.ocultarBomba();
		
		this.stop();
	}
	
	public void inserirNovaBombaExplodidaPeloJogador()
	{
		String nomeExplodida = this.bomba.getPalavra();
		String traducaoExplodida = this.bomba.getTraducao();
		InterfaceBomba bombaExplodida = new InterfaceBomba(nomeExplodida, traducaoExplodida);
		interfaceJogo.inserirPalavraETraducaoDaBombaQueExplodiu(bombaExplodida);
		this.bombasExplodidasPeloJogador.add(bombaExplodida);
	}
	
	
	@SuppressWarnings("deprecation")
	public void desativarBomba()
	{
		//gerar nova palavra e traduÁ„o para a nova Bomba.
		Random geraAleatorio = new Random();
		int numAleatorio = geraAleatorio.nextInt(quantasPalavrasNoJogo);
		String novaPalavra = this.palavrasETraducoesDoJogo.getPalavra(numAleatorio);
		String novaTraducao = this.palavrasETraducoesDoJogo.getTraducao(numAleatorio);
				
		this.bomba.setPalavra(novaPalavra);
		this.bomba.setTraducao(novaTraducao);
				
		this.bomba.ocultarBomba();
			
		try 
		{
			Thread.sleep(1000);
		} 
		catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.stop();
	}
	
	

}
