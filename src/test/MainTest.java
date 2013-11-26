package test;


import java.util.LinkedList;

import main.java.fachadaparadao.FachadaDAO;
import main.java.jogo.InterfaceBomba;
import main.java.jogo.InterfaceJogo;
import main.java.jogo.Jogador;
import main.java.jogo.TelaInicial;
import main.java.jogo.ThreadAtivaBomba;


public class MainTest 
{
	
	
	public static void main(String args[])
	{
		TelaInicial telaInicial = new TelaInicial();
		telaInicial.criarTelaInicial();
		
		String nomeJogador = telaInicial.getNomeJogador();
		while(nomeJogador == null)
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			nomeJogador = telaInicial.getNomeJogador();
		}
		
		

		InterfaceJogo interfaceDoJogo = InterfaceJogo.getInterfaceJogo();
		interfaceDoJogo.criarInterfaceJogo();
		
		Jogador jogador = new Jogador(nomeJogador);
		
		
		//antes de iniciar a thread que ativa as bombas, 
		//pegarei as configuracoes do jogo num arquivo txt
		int tempoAteBombaNovaAparecer = 0;
		int tempoParaBombaExplodir = 0;
		
		String [] configuracoesDoJogo = FachadaDAO.getFachadaDAO().lerConfiguracoesJogo();
		tempoAteBombaNovaAparecer = Integer.valueOf(configuracoesDoJogo[0]) * 1000;
		tempoParaBombaExplodir = Integer.valueOf(configuracoesDoJogo[1]);
		
		LinkedList<InterfaceBomba> bombasQueOJogadorExplodiu = new LinkedList<InterfaceBomba>();
		ThreadAtivaBomba threadAtiva = new ThreadAtivaBomba(tempoAteBombaNovaAparecer, tempoParaBombaExplodir, bombasQueOJogadorExplodiu);
		threadAtiva.start();
		
		jogador.jogar(bombasQueOJogadorExplodiu);
	}
}
