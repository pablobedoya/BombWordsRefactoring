package dao;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;

public class ConcreteDAORankingArquivos implements DAORanking
{
	@Override
	public void inserirJogadorRanking(String nomeJogador, int pontuacao) 
	{
		try
		{
			String [] configuracoes = this.lerConfiguracoesJogo();
			String [] ranking = lerRanking();
			if(ranking != null)
			{
				for(int i = 0; i < ranking.length; i++)
				{
					String[] separaRanking = ranking[i].split(";");
					int placarRanking = Integer.valueOf(separaRanking[1]);
					if(placarRanking < pontuacao)
					{
						ranking[i] = nomeJogador + ";" + pontuacao + ";" + configuracoes[0] + ";" + configuracoes[1];
						break;
					}		
				}
				
				//agora, vamos reescrever no ranking
				FileOutputStream escreve = new FileOutputStream("textos/highscore.txt");
				OutputStreamWriter filtroEscreve = new OutputStreamWriter(escreve, "UTF8");
				for(int j = 0; j < ranking.length; j++)
				{
					filtroEscreve.write(ranking[j] +"\r\n");
				}
				filtroEscreve.flush();
				filtroEscreve.close();
				escreve.close();	
				
			}
		}
		catch(IOException exc)
		{
			System.err.println("erro na escrita do placar:" + exc);
		}
		
	}
	
	public String[] lerConfiguracoesJogo() 
	{
		try
		{
			String [] configuracoes = new String[2];
			FileInputStream leitor = new FileInputStream("textos/configuracoes.txt");
			Reader reader = new InputStreamReader(leitor, "UTF-8");
			BufferedReader filtroLeitura = new BufferedReader(reader);
			String stringLida = filtroLeitura.readLine();
			int linhaLida = 0;
			while(stringLida != null)
			{
				String [] stringLidaSplit = stringLida.split(":");
				configuracoes[linhaLida] = stringLidaSplit[1];
				stringLida = filtroLeitura.readLine();
				linhaLida = linhaLida + 1;
			}
			
			filtroLeitura.close();
			reader.close();
			leitor.close();
			return configuracoes;
		
		}
		catch(IOException exc)
		{
			System.out.println("erro na leitura das configuracoes do jogo:" + exc);
			return null;
		}
	}

	@Override
	public String[] lerRanking() 
	{
		try
		{
			String [] ranking = new String [8];
			
			FileInputStream leitor = new FileInputStream("textos/highscore.txt");
			Reader reader = new InputStreamReader(leitor, "UTF-8");
			BufferedReader filtroLeitura = new BufferedReader(reader);
			String stringLida = filtroLeitura.readLine();
			int linhaLida = 0;
			while(stringLida != null)
			{
				ranking[linhaLida] = stringLida;
				stringLida = filtroLeitura.readLine();
				linhaLida = linhaLida + 1;
			}
			
			filtroLeitura.close();
			reader.close();
			leitor.close();
			return ranking;
		}
		catch(IOException exc)
		{
			System.err.println("erro na leitura do placar:" + exc);
			return null;
		}
	}

}
