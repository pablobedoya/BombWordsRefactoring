package dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;


public class ConcreteDAOListaDePalavrasArquivos implements DAOListaDePalavras
{
	@Override
	public boolean criarNovaListaPalavras(String nomeLista) 
	{
		try
		{
			//primeiro, vamos ver se a lista já existe
			boolean listaJahExiste = this.listaJahExiste(nomeLista);
			
			if(listaJahExiste == false)
			{
				String enderecoLista = "textos/" + nomeLista + ".txt";
				FileOutputStream escreve = new FileOutputStream(enderecoLista);
				OutputStreamWriter filtroEscreve = new OutputStreamWriter(escreve, "UTF8");
				filtroEscreve.flush();
				filtroEscreve.close();
				escreve.close();
				return true;
			}
			else
			{
				return false;
			}
			
		}
		catch(IOException e)
		{
			return false;
		}	
		
	}
	
	private boolean listaJahExiste(String nomeLista)//ve se uma lista com esse nome jah existe no jogo.
	{
		boolean listaExiste = false;
		String arquivoLista = nomeLista + ".txt";
		File pastaListas = new File("textos");
		String[] nomesListasPasta = pastaListas.list();
		String percorredorNomesListasPasta = "";
		for(int i = 0; i < nomesListasPasta.length; i++)
		{
			percorredorNomesListasPasta = nomesListasPasta[i];
			if(percorredorNomesListasPasta.compareTo(arquivoLista) == 0)
			{
				listaExiste = true;
				break;
			}
		}
		return listaExiste;
	}
	

	@Override
	public boolean removerListaPalavras(String nomeLista) 
	{
		//primeiro, vamos ver se a lista existe
		boolean listaJahExiste = this.listaJahExiste(nomeLista);
				
		if(listaJahExiste == false)
		{
			return false;
		}
		else
		{
			if(nomeLista.compareTo("palavras") == 0)
			{
				return false;
			}
			else
			{
				String nomeArquivoLista = "textos/" + nomeLista + ".txt";
				File arquivoLista = new File(nomeArquivoLista);
				arquivoLista.delete();
				return true;
			}
		}	
	}

	@Override
	public boolean limparListaPalavras(String nomeLista) 
	{
		//primeiro, vamos ver se a lista existe
		boolean listaJahExiste = this.listaDePalavrasJahExiste(nomeLista);
		
		if(listaJahExiste == false)
		{
			return false;
		}
		else
		{
			try
			{
				String nomeArquivoLista = "textos/" + nomeLista + ".txt";
				FileOutputStream escreve = new FileOutputStream(nomeArquivoLista);
				OutputStreamWriter filtroEscreve = new OutputStreamWriter(escreve, "UTF8");
				filtroEscreve.close();
				escreve.close();
				return true;
			}
			catch(IOException exc)
			{
				return false;
			}	
		}
			
	}
	
	@Override
	public String[] extrairNomesDeTodasAsListasDePalavras() 
	{
		File file = new File("textos");
		String[] nomesDasListas = file.list();
		String[] nomesListasSohPalavras = new String[nomesDasListas.length - 3];
		/* na pasta "textos",
			alem das listas de palavras que podem 
			ser usadas no jogo, há o placar e as configuracões. vamos remover os dois.*/
		int percorreNomesListasSohPalavras = 0;
		for(int i = 0; i < nomesDasListas.length; i++)
		{
			if(nomesDasListas[i].compareTo("configuracoes.txt") != 0 &&
					nomesDasListas[i].compareTo("highscore.txt") != 0 && nomesDasListas[i].compareTo("listaaserusadanojogo.txt") != 0)
			{
				nomesListasSohPalavras[percorreNomesListasSohPalavras] = nomesDasListas[i];
				percorreNomesListasSohPalavras = percorreNomesListasSohPalavras + 1;
			}
		}
		
		
		return nomesListasSohPalavras;
	}

	@Override
	public boolean listaDePalavrasJahExiste(String nomeLista)//v� se uma lista com esse nome já existe no jogo. 
	{
		boolean listaExiste = false;
		String arquivoLista = nomeLista + ".txt";
		File pastaListas = new File("textos");
		String[] nomesListasPasta = pastaListas.list();
		String percorredorNomesListasPasta = "";
		for(int i = 0; i < nomesListasPasta.length; i++)
		{
			percorredorNomesListasPasta = nomesListasPasta[i];
			if(percorredorNomesListasPasta.compareTo(arquivoLista) == 0)
			{
				listaExiste = true;
				break;
			}
		}
		return listaExiste;
	}
	
	@Override
	public boolean mudarListaASerUsadaNoJogo(String nomeListaAtual) 
	{
		try
		{
			String nomeArquivoListaJogo = "textos/listaaserusadanojogo.txt";
			FileOutputStream escreve = new FileOutputStream(nomeArquivoListaJogo);
			OutputStreamWriter filtroEscreve = new OutputStreamWriter(escreve, "UTF8");
			filtroEscreve.write(nomeListaAtual);
			filtroEscreve.close();
			escreve.close();
			return true;
		}
		catch(IOException exc)
		{
			System.out.println("erro I/O na funcionalidade jogar com lista visualizada:" + exc);
			return false;
		}
		
	}
	
	@Override
	public String pegarNomeListaASerUsadaNoJogo() 
	{
		try
		{
			FileInputStream leitor = new FileInputStream("textos/listaaserusadanojogo.txt");
			Reader reader = new InputStreamReader(leitor, "UTF-8");
			BufferedReader buff = new BufferedReader(reader);
			String listaASerUsadaNoJogo = buff.readLine();
			return listaASerUsadaNoJogo;
		}
		catch(FileNotFoundException e) 
		{
			System.out.println("lista a ser usada no jogo nao encontrada");
			return "palavras";
		}
		catch(IOException exc)
		{
			System.out.println("excecao IO ao tentar pegar lista a ser usada no jogo");
			return "palavras";
		}
	}
	
	

}
