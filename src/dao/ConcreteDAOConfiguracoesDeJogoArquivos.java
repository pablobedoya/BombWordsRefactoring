package dao;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;

public class ConcreteDAOConfiguracoesDeJogoArquivos  implements DAOConfiguracoesDeJogo
{
	@Override
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
	public void setarNovasConfiguracoesJogo(int tempoParaSetarBomba,
			int tempoParaBombaExplodir) 
	{
		try 
		{	
			FileOutputStream escreve = new FileOutputStream("textos/configuracoes.txt");
			OutputStreamWriter filtroEscreve = new OutputStreamWriter(escreve, "UTF8");
			
			filtroEscreve.write("segundos até inserir novas bombas:" + tempoParaSetarBomba + "\r\n");
			filtroEscreve.write("segundos até uma bomba explodir:" + tempoParaBombaExplodir + "\r\n");
			
			filtroEscreve.flush();
			filtroEscreve.close();
			escreve.close();
		} 
		catch (IOException e) 
		{
			System.out.println(e);
		}
		
	}

}
