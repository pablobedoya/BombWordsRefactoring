package main.java.jogo;

import javax.swing.ImageIcon;

public class CriadorImageIcon//cria ImageIcons para usar nas interfaces do jogo 
{
	public static ImageIcon criarImageIcon(String endereco, String descricao) 
	{
		java.net.URL urlImagem = InterfaceJogo.class.getResource(endereco);
		if(urlImagem != null)
		{
			return new ImageIcon(InterfaceJogo.class.getResource(endereco), descricao);
		}
		
		else
		{
			System.out.println("imagem nao encontrada:" + endereco);
			return null;
		}
	}
}
