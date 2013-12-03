package main.java.jogo;

import javax.swing.ImageIcon;

public class CriadorImageIcon//cria ImageIcons para usar nas interfaces do jogo 
{
	public static ImageIcon criarImageIcon(String endereco, String descricao) 
	{
		java.net.URL urlImagem = UInterfaceJogo.class.getResource(endereco);
		if(urlImagem != null)
		{
			return new ImageIcon(UInterfaceJogo.class.getResource(endereco), descricao);
		}
		
		else
		{
			System.out.println("imagem nao encontrada:" + endereco);
			return null;
		}
	}
}
