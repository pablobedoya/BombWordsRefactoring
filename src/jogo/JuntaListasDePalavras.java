package jogo;

import fachadaparadao.FachadaDAO;



public class JuntaListasDePalavras 
{
	public void juntarListas(String nomeLista1, String nomeLista2)//junta as palavras da lista 2 em lista1
	{
		
		PalavrasETraducoes lista2 = FachadaDAO.getFachadaDAO().extrairPalavrasETraducoes(nomeLista2);
		for(int j = 0; j < lista2.getNumPalavrasNoJogo(); j++)
		{
			String palavraLista2 = lista2.getPalavra(j);
			String traducaoLista2 = lista2.getTraducao(j);
			FachadaDAO.getFachadaDAO().adicionarNovaPalavraNaLista(nomeLista1, palavraLista2, traducaoLista2);
		}
	}

}
