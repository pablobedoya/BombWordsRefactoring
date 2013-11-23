package dao;

import jogo.PalavrasETraducoes;

public interface DAOPalavrasDeLista 
{
	public PalavrasETraducoes extrairPalavrasETraducoes(String listaOndeEstaoOsDados);
	
	public boolean adicionarNovaPalavraNaLista(String nomeLista, String palavraNova, String traducaoNova);
	public void removerPalavraDaLista(String nomeDalista, String traducaoDaPalavraASerRemovida);

}
