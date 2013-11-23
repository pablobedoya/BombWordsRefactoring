package jogo;

import java.util.LinkedList;

public class ChecaSeJogadorAcertouTraducao 
{
	//classe só é chamada quando a InterfaceJogo precisa saber quais bombas desativar
	
	private InterfaceBomba[] imagensBombas;
	
	public ChecaSeJogadorAcertouTraducao(InterfaceBomba[] imagensBombs)
	{
		imagensBombas = imagensBombs;
	}
	
	public LinkedList<InterfaceBomba> quaisBombasDevemSerDesativadas(String palpiteJogador)
	{
		/*checa se o palpite do jogador é igual a alguma tradução de uma das imagensBombas
		  e retorna somente quais bombas devem ser desativadas(jogador acertou a tradução)*/
		
		LinkedList<InterfaceBomba> bombasARemover = new LinkedList<InterfaceBomba>();
		palpiteJogador = palpiteJogador.toLowerCase();

		for(int i = 0; i < this.imagensBombas.length; i++)
		{
			boolean bombaAtivada = imagensBombas[i].getAtivada();
			String traducaoBomba = imagensBombas[i].getTraducao();
			traducaoBomba = traducaoBomba.toLowerCase();
			if(bombaAtivada == true && palpiteJogador.compareTo(traducaoBomba) == 0)
			{
				bombasARemover.add(imagensBombas[i]);
			}
		}
			
		if(bombasARemover.size() == 0)//sem bombas
		{
			return null;
		}
		else
		{
			return bombasARemover;
		}
		
	}

}
