package dao;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.util.LinkedList;


import jogo.PalavrasETraducoes;

public class ConcreteDAOPalavrasDeListaArquivos implements DAOPalavrasDeLista
{
	@Override
	public PalavrasETraducoes extrairPalavrasETraducoes(String listaOndeEstaoOsDados) 
	{
		try 
		{
			String localArquivo = "textos/" + listaOndeEstaoOsDados + ".txt";
			FileInputStream leitor = new FileInputStream(localArquivo);
			Reader reader = new InputStreamReader(leitor, "UTF-8");
			BufferedReader buff = new BufferedReader(reader);
			String linhaDoArquivo = buff.readLine();
			
			int percorredorPalavras = 0;
			int percorredorTraducoes = 0;
			
			LinkedList<String> palavras = new LinkedList<String>();
			LinkedList<String> traducoes = new LinkedList<String>();
			
			while(linhaDoArquivo != null)
			{
				String[] linhaSplitada = linhaDoArquivo.split(";");
				palavras.add(percorredorPalavras, linhaSplitada[0]);
				percorredorPalavras = percorredorPalavras + 1;
				traducoes.add(percorredorTraducoes, linhaSplitada[1]);
				percorredorTraducoes = percorredorTraducoes + 1;
				linhaDoArquivo = buff.readLine();
			}
			
			buff.close();
			reader.close();
			leitor.close();
			PalavrasETraducoes palavrasETraducoesDesordenadas = new PalavrasETraducoes(palavras, traducoes);
			PalavrasETraducoes palavrasETraducoesOrdenadas = this.ordenarPalavrasETraducoes(palavrasETraducoesDesordenadas);
			
			return palavrasETraducoesOrdenadas;
		} 
		catch(FileNotFoundException e) 
		{
			System.out.println("lista nao encontrada:" + listaOndeEstaoOsDados);
			return null;
		}
		catch(IOException exc)
		{
			System.out.println("excecao IO");
			return null;
		}
	}
	
	private PalavrasETraducoes ordenarPalavrasETraducoes(PalavrasETraducoes listaDePalavrasETraducoes)
	{
		PalavrasETraducoes listaOrdenada;
		LinkedList<String> palavras = listaDePalavrasETraducoes.getPalavras();
		LinkedList<String> traducoes = listaDePalavrasETraducoes.getTraducoes();
		
		if(palavras.size() > 1)
		{
			int percorredorPalavras = 0;
			String auxiliarTroca;//auxiliar para trocas na ordenacao das palavras.
			while(percorredorPalavras < palavras.size())
			{
				for(int i = percorredorPalavras + 1; i < palavras.size(); i++)
				{
					//if abaixo compara duas palavras da lista de palavras pra ver se a da esquerda 
					//vem antes da palavra na direita
					if(palavras.get(i).compareTo(palavras.get(percorredorPalavras)) < 0)
					{
						auxiliarTroca = palavras.get(i);
						palavras.set(i, palavras.get(percorredorPalavras));
						palavras.set(percorredorPalavras, auxiliarTroca);
						
						auxiliarTroca = traducoes.get(i);
						traducoes.set(i, traducoes.get(percorredorPalavras));
						traducoes.set(percorredorPalavras, auxiliarTroca);
					}
				}
				percorredorPalavras = percorredorPalavras + 1;
			}
		}
		
		listaDePalavrasETraducoes.setPalavras(palavras);
		listaDePalavrasETraducoes.setTraducoes(traducoes);
		listaOrdenada = listaDePalavrasETraducoes;
		
		return listaOrdenada;
	}
	
	@Override
	public boolean adicionarNovaPalavraNaLista(String nomeLista,
			String palavraNova, String traducaoNova) 
	{
		
		PalavrasETraducoes listaPalavrasETraducoes = this.extrairPalavrasETraducoes(nomeLista);
		if(listaPalavrasETraducoes != null)
		{
			int quantasPalavrasNoArquivo = listaPalavrasETraducoes.getNumPalavrasNoJogo();
			LinkedList<String> palavras = new LinkedList<String>();
			LinkedList<String> traducoes = new LinkedList<String>();
			
			for(int i = 0; i < quantasPalavrasNoArquivo; i++)
			{
				palavras.add(listaPalavrasETraducoes.getPalavra(i));
				traducoes.add(listaPalavrasETraducoes.getTraducao(i));
			}
			
			String novaPalavra = palavraNova;
			String novaTraducao = traducaoNova;
			
			palavras.add(novaPalavra);
			traducoes.add(novaTraducao);
				
			//agora vamos adicionar nova palavra no txt
				
			try
			{
				String enderecoLista = "textos/" + nomeLista + ".txt";
				FileOutputStream escreve = new FileOutputStream(enderecoLista);
				OutputStreamWriter filtroEscreve = new OutputStreamWriter(escreve, "UTF8");
				for(int j = 0; j < palavras.size(); j++)
				{
					String linhaNova = palavras.get(j) + ";" + traducoes.get(j);
					filtroEscreve.write(linhaNova +"\r\n");
				}
					
				filtroEscreve.flush();
				filtroEscreve.close();
				escreve.close();
				return true;
			}
			catch(IOException e)
			{
				System.out.println("excecao IO ao tentar escrever no arquivo palavras.txt");
			}
		}
		
		return false;
	}
	
	@Override
	public void removerPalavraDaLista(String nomeDalista,
			String traducaoDaPalavraASerRemovida) 
	{
		PalavrasETraducoes listaDePalavrasETraducoes = this.extrairPalavrasETraducoes(nomeDalista);
		int quantasPalavrasNoArquivo = listaDePalavrasETraducoes.getNumPalavrasNoJogo();
		LinkedList<String> palavras = new LinkedList<String>();
		LinkedList<String> traducoes = new LinkedList<String>();
		
		for(int i = 0; i < quantasPalavrasNoArquivo; i++)
		{
			palavras.add(listaDePalavrasETraducoes.getPalavra(i));
			traducoes.add(listaDePalavrasETraducoes.getTraducao(i));
		}
		
		String traducaoPalavraRemovida = traducaoDaPalavraASerRemovida;
		if(traducaoPalavraRemovida.compareTo("") == 0)
		{
			System.out.println("traducao da palavra a ser removida nao informada");
		}
		else
		{
			//acharemos a palavra a ser removida
			int indiceParaRemocao = -1;
			
			for(int i = 0; i < traducoes.size(); i++)
			{
				String traducao = traducoes.get(i);
				if(traducao.compareTo(traducaoPalavraRemovida) == 0)
				{
					indiceParaRemocao = i;
				}
			}
			
			if(indiceParaRemocao == -1)
			{
				System.out.println("traducao nao encontrada");
			}
			else
			{
				traducoes.remove(indiceParaRemocao);
				palavras.remove(indiceParaRemocao);
				
				//agora vamos inserir o resto das palavras no txt
				
				try
				{
					String enderecoLista = "textos/" + nomeDalista + ".txt";
					FileOutputStream escreve = new FileOutputStream(enderecoLista);
					OutputStreamWriter filtroEscreve = new OutputStreamWriter(escreve, "UTF8"); 
					for(int j = 0; j < palavras.size(); j++)
					{
						String linhaNova = palavras.get(j) + ";" + traducoes.get(j);
						filtroEscreve.write(linhaNova +"\r\n");
					}
					
					filtroEscreve.flush();
					filtroEscreve.close();
					escreve.close();
					
				}
				catch(IOException e)
				{
					System.out.println("excecao IO ao tentar escrever no arquivo " + nomeDalista + ".txt");
				}
			}
		}
	}

}
