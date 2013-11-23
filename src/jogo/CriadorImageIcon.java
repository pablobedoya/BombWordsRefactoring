package jogo;

import javax.swing.ImageIcon;

public class CriadorImageIcon//cria ImageIcons para usar nas interfaces do jogo 
{
	protected static ImageIcon criarImageIcon(String endereco, String descricao) 
	{
		java.net.URL urlImagem = InterfaceJogo.class.getResource(endereco);
		if(urlImagem != null)
		{
			return new ImageIcon(InterfaceJogo.class.getResource(endereco), descricao);
		}
		
		else
		{
			System.out.println("imagem não encontrada:" + endereco);
			return null;
		}
	}

}
