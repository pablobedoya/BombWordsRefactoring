package testes;


import java.util.LinkedList;

import jogo.InterfaceBomba;
import jogo.InterfaceJogo;
import jogo.Jogador;
import jogo.TelaInicialComNiveis;
import jogo.ThreadAtivaBomba;
import fachadaparadao.FachadaDAO;

public class MainTestWatford
{
	public static void setarNomeListaASerUsadaNoJogo()
	{
		FachadaDAO.getFachadaDAO().mudarListaASerUsadaNoJogo("palavras");//a versão do atford só trabalha com a lista de palavras chamada "palavras";
	}
	public static void main(String args[])
	{
		setarNomeListaASerUsadaNoJogo();
	
		TelaInicialComNiveis telaInicial = new TelaInicialComNiveis();
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
		
		
		/*impede que essa thread daqui faca seu trabalho mais rapido que a thread que junta palavras.txt e as listas*/
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		InterfaceJogo.getInterfaceJogo().criarInterfaceJogo();
		
		
		Jogador jogador = new Jogador(nomeJogador);
		
		
		//antes de iniciar a thread que ativa as bombas, 
		//pegarei as configuracoes do jogo
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
