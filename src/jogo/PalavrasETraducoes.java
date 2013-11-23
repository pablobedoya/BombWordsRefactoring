package jogo;

import java.util.LinkedList;

public class PalavrasETraducoes 
{
	/*classe que armazena palavras e traduções a serem usadas no jogo*/
	//Transfer Object
	
	private LinkedList<String> palavras;
	private LinkedList<String> traducoes;
	

	public PalavrasETraducoes(LinkedList<String> palavrasDoJogo, LinkedList<String> traducoesDoJogo)
	{
		palavras = palavrasDoJogo;
		traducoes = traducoesDoJogo;
	}
	
	public LinkedList<String> getPalavras() {
		return palavras;
	}

	public void setPalavras(LinkedList<String> palavras) {
		this.palavras = palavras;
	}

	public LinkedList<String> getTraducoes() {
		return traducoes;
	}

	public void setTraducoes(LinkedList<String> traducoes) {
		this.traducoes = traducoes;
	}
	
	public String getPalavra(int indice)
	{
		if(indice < palavras.size())
		{
			return palavras.get(indice);
		}
		else
		{
			return null;
		}
	}
	
	public String getTraducao(int indice)
	{
		if(indice < traducoes.size())
		{
			return traducoes.get(indice);
		}
		else
		{
			return null;
		}
	}
	
	public int getNumPalavrasNoJogo()
	{	
		return this.palavras.size();
	}

}
