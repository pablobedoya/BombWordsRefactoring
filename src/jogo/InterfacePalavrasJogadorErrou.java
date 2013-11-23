package jogo;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.TextArea;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InterfacePalavrasJogadorErrou 
{
	private JFrame janelaJogadorErrou;
	private TextArea areaEscrita;
	private LinkedList<InterfaceBomba> bombasQueOJogadorExplodiu;
	
	public InterfacePalavrasJogadorErrou(LinkedList<InterfaceBomba> bombasExplodidas)
	{
		bombasQueOJogadorExplodiu = bombasExplodidas;
		
		janelaJogadorErrou = new JFrame("Palavras das bombas que explodiram");
		janelaJogadorErrou.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janelaJogadorErrou.setResizable(false);
	}
	
	public void criarTelaInterfacePalavrasJogadorErrou()
	{
		GridBagConstraints grid = new GridBagConstraints();
		JPanel painelUneTudo = new JPanel();
		painelUneTudo.setBorder(BorderFactory.createLineBorder(Color.RED, 10));
		painelUneTudo.setBackground(new Color(112, 146, 190));
		GridBagLayout layout = new GridBagLayout();
		painelUneTudo.setLayout(layout);
		
		JLabel titulo = new JLabel("Palavras das bombas que explodiram");
		titulo.setFont(new Font("Serif", Font.BOLD, 30));
		titulo.setForeground(Color.white);
		JPanel painelTitulo = new JPanel();
		painelTitulo.setBackground(new Color(112, 146, 190));
		painelTitulo.add(titulo);
		grid.gridx = 0;
		grid.gridy = 0;
		grid.gridheight = 1;
		painelUneTudo.add(painelTitulo, grid);
		
		
		int percorredorGridY = 1;
		for(int i = 0; i < bombasQueOJogadorExplodiu.size(); i++)
		{
			String palavraErrada = bombasQueOJogadorExplodiu.get(i).getPalavra();
			JLabel linhaPalavrasErradas = new JLabel("palavra : " + palavraErrada);
			linhaPalavrasErradas.setFont(new Font("Serif", Font.BOLD, 20));
			linhaPalavrasErradas.setForeground(new Color(255, 201, 14));
			JPanel painelLinha = new JPanel();
			painelLinha.setBackground(new Color(112, 146, 190));
			painelLinha.add(linhaPalavrasErradas);
			
			grid.gridx = 0;
			grid.gridy = percorredorGridY;
			grid.gridheight = 1;
			painelUneTudo.add(painelLinha, grid);
			
			percorredorGridY = percorredorGridY + 1;
			
			//falta colocar a traducao associada
			String traducao = bombasQueOJogadorExplodiu.get(i).getTraducao();
			JLabel linhaPalavrasErradas2 = new JLabel("tradução : " + traducao);
			linhaPalavrasErradas2.setFont(new Font("Serif", Font.BOLD, 20));
			linhaPalavrasErradas2.setForeground(Color.white);
			JPanel painelLinha2 = new JPanel();
			painelLinha2.setBackground(new Color(112, 146, 190));
			painelLinha2.add(linhaPalavrasErradas2);
			
			grid.gridx = 0;
			grid.gridy = percorredorGridY;
			grid.gridheight = 1;
			painelUneTudo.add(painelLinha2, grid);
			
			percorredorGridY = percorredorGridY + 1;
			
			//agora uma linha em branco
			JLabel linhaBranca = new JLabel("");
			JPanel painelBranco = new JPanel();
			painelBranco.setBackground(new Color(112, 146, 190));
			painelBranco.add(linhaBranca);
			grid.gridx = 0;
			grid.gridy = percorredorGridY;
			grid.gridheight = 1;
			painelUneTudo.add(painelBranco, grid);
			
			percorredorGridY = percorredorGridY + 1;
		}
		
		
		janelaJogadorErrou.add(painelUneTudo);
		//informarPalavrasErradasETraducao();
		
		
		janelaJogadorErrou.pack();
		janelaJogadorErrou.setVisible(true);
		
		
	}
	
	
	public void escrever(String aSerEscrita)
	{
		areaEscrita.append(aSerEscrita);
		areaEscrita.append("\n");
	}
	
	public void informarPalavrasErradasETraducao()
	{
		String linha = "";
		for(int i = 0; i < bombasQueOJogadorExplodiu.size(); i++)
		{
			InterfaceBomba bomba = bombasQueOJogadorExplodiu.get(i);
			linha = "palavra: " + bomba.getPalavra();
			this.escrever(linha);
			linha = "tradução: " + bomba.getTraducao();
			this.escrever(linha);
			this.escrever("");
		}
	}
	
	public static void main(String args[])
	{
		LinkedList<InterfaceBomba> bombas = new LinkedList<InterfaceBomba>();
		bombas.add(new InterfaceBomba("hi", "oi"));
		bombas.add(new InterfaceBomba("goodbye", "tchau"));
		bombas.add(new InterfaceBomba("excellent", "excelente"));
		bombas.add(new InterfaceBomba("that is a good question", "é uma boa pergunta"));
		bombas.add(new InterfaceBomba("music", "música"));
		
		InterfacePalavrasJogadorErrou inter = new InterfacePalavrasJogadorErrou(bombas);
		inter.criarTelaInterfacePalavrasJogadorErrou();
	}
	
}
