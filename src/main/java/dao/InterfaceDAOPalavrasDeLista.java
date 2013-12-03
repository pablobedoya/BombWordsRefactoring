package main.java.dao;

import main.java.jogo.PalavrasETraducoes;

public interface InterfaceDAOPalavrasDeLista 
{
	public PalavrasETraducoes extrairPalavrasETraducoes(String listaOndeEstaoOsDados);
	
	public boolean adicionarNovaPalavraNaLista(String nomeLista, String palavraNova, String traducaoNova);
	public void removerPalavraDaLista(String nomeDalista, String traducaoDaPalavraASerRemovida);

}
