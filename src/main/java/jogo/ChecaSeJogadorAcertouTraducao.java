package main.java.jogo;

import java.util.LinkedList;

public class ChecaSeJogadorAcertouTraducao 
{
	//classe sao chamada quando a InterfaceJogo precisa saber quais bombas desativar
	
	private UInterfaceBomba[] imagensBombas;
	
	public ChecaSeJogadorAcertouTraducao(UInterfaceBomba[] imagensBombs)
	{
		imagensBombas = imagensBombs;
	}
	
	public LinkedList<UInterfaceBomba> quaisBombasDevemSerDesativadas(String palpiteJogador)
	{
		/*checa se o palpite do jogador eh igual a alguma traducao de uma das imagensBombas
		  e retorna somente quais bombas devem ser desativadas(jogador acertou a traducao)*/
		
		LinkedList<UInterfaceBomba> bombasARemover = new LinkedList<UInterfaceBomba>();
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
