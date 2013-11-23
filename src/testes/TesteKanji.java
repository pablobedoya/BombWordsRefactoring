package testes;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class TesteKanji 
{
	public static void main(String args[])
	{
		System.out.println("未");
		try
		{
			FileInputStream fileInput = new FileInputStream("textos/palavras.txt");
			Reader reader = new InputStreamReader(fileInput,"UTF-8");
			BufferedReader filtroLeitura = new BufferedReader(reader);
			String stringLida = filtroLeitura.readLine();
			int linhaLida = 0;
			while(stringLida != null)
			{
				System.out.println(stringLida);
				linhaLida = linhaLida + 1;
				System.out.println(linhaLida + 1);
				stringLida = filtroLeitura.readLine();
			}
			System.out.println("fim do arquivo");
			filtroLeitura.close();
			reader.close();
			fileInput.close();
		}
		catch(IOException exc)
		{
			System.err.println("erro na leitura do placar:" + exc);
		}
	}

}
