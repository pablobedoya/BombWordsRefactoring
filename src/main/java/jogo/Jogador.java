package main.java.jogo;


import java.util.LinkedList;

import main.java.fachadaparadao.FachadaDAO;


public class Jogador 
{
	private String nome;
	private int pontosVida;
	private int placar;
	private UInterfaceJogo interfaceJogo;
	
	public Jogador(String nom)
	{
		nome = nom;
		pontosVida = 5;
		placar = 0;
		interfaceJogo = UInterfaceJogo.getInterfaceJogo();
	}
	
	public String getNome()
	{
		return nome;
	}
	
	public int getPontosVida()
	{
		return pontosVida;
	}
	
	public int getPlacar()
	{
		return placar;
	}
	
	public void setNome(String novo)
	{
		this.nome = novo;
	}
	
	public void decrementarPontosVida()
	{
		pontosVida = pontosVida - 1;
		interfaceJogo.reduzirCoracao(this);
		interfaceJogo.setModo("nenhum");
	}
	
	
	public void incrementarPlacar(int mais)
	{
		this.placar = placar + mais;
		interfaceJogo.incrementarPlacar(placar);
		interfaceJogo.setModo("nenhum");
	}
	
	public void decrementarPlacar(int menos)
	{
		this.placar = placar - menos;
	}
	
	
	public void verRanking(LinkedList<UInterfaceBomba> bombasQueOJogadorExplodiu)
	{
		UInterfaceRanking janelaRanking = new UInterfaceRanking();
		String [] placarJogadores = FachadaDAO.getFachadaDAO().lerRanking();
		janelaRanking.criarJanelaRanking(placarJogadores);
		
		UInterfacePalavrasJogadorErrou erradas = new UInterfacePalavrasJogadorErrou(bombasQueOJogadorExplodiu);
		erradas.criarTelaInterfacePalavrasJogadorErrou();
	}
	
	
	public void jogar(LinkedList<UInterfaceBomba> bombasQueOJogadorExplodiu)
	{
		while(pontosVida > 0)
		{
			if(interfaceJogo.getModo().compareTo("desativarBomba") == 0)
			{
				this.incrementarPlacar(100);
			}
			
			if(interfaceJogo.getModo().compareTo("explodiu") == 0)
			{
				this.decrementarPontosVida();
			}
		}
		
		this.interfaceJogo.disposeTelaJogo();
		FachadaDAO.getFachadaDAO().inserirJogadorRanking(this.nome, this.placar);
		this.verRanking(bombasQueOJogadorExplodiu);
	}
}
