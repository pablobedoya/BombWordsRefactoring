package test;

import static org.junit.Assert.*;

import java.io.File;



import org.junit.Test;


import main.java.fachadaparadao.FachadaDAO;
import main.java.jogo.JuntaListasDePalavras;
import main.java.jogo.PalavrasETraducoes;
public class TesteJuntarListas {

	@Test
	public void testJuntarPalavrasComMyPersonalList2() 
	{
		
		JuntaListasDePalavras juntarListas = new JuntaListasDePalavras();
		//extraiPalavras é quem une as listas
		
		//primeiro,vamos ver se myPersonalList2 existe.
		File pastaListas = new File("textos");
		String[] nomesListasPasta = pastaListas.list();
		boolean achouLista = false;
		for(int i = 0; i < nomesListasPasta.length; i++)
		{
			if(nomesListasPasta[i].compareTo("myPersonalList2.txt") == 0)
			{
				achouLista = true;
				break;
			}
		}
		if(achouLista == false)
		{
			fail("lista myPersonalList2.txt não foi achada, então não tem nada pra juntar");
		}
		
		juntarListas.juntarListas("palavras", "myPersonalList2");
		PalavrasETraducoes palavrasDaListaPalavras = FachadaDAO.getFachadaDAO().extrairPalavrasETraducoes("palavras");
		PalavrasETraducoes palavrasDaListaMyPersonal = FachadaDAO.getFachadaDAO().extrairPalavrasETraducoes("myPersonalList2");
		boolean achouPalavra;
		for(int j = 0; j < palavrasDaListaMyPersonal.getNumPalavrasNoJogo(); j++)
		{
			String palavraInserida = palavrasDaListaMyPersonal.getPalavra(j);
			achouPalavra = false;
			for(int k = 0; k < palavrasDaListaPalavras.getNumPalavrasNoJogo(); k++)
			{
				String palavraLista = palavrasDaListaPalavras.getPalavra(k);
				if(palavraLista.compareTo(palavraInserida) == 0)
				{
					achouPalavra = true;
				}
			}
			if(achouPalavra == false)
			{
				fail("nao foi inserida a palavra na juncao:" + palavraInserida);
			}
		}
		
		
	}

}
