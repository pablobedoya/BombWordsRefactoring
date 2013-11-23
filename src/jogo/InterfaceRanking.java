package jogo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InterfaceRanking implements ActionListener
{
	private JFrame janelaRanking;
	private JLabel [] posicaoRanking;
	private JLabel [] nomesRanking;
	private JLabel [] pontosRanking;
	private JLabel [] bombaExplodirRanking;
	private JLabel [] bombaColocarRanking;
	private JLabel Ranking;
	private JButton fecharJogo;
	
	
	public InterfaceRanking()
	{
		janelaRanking = new JFrame();
		janelaRanking.setTitle("Placar");
		janelaRanking.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		nomesRanking = new JLabel[8];
		pontosRanking = new JLabel[8];
		posicaoRanking = new JLabel[8];
		bombaExplodirRanking = new JLabel[8];
		bombaColocarRanking = new JLabel[8];
	}
	
	
	private String [] pegaPontosDoPlacar(String [] placar)
	{
		String [] placarPontos = new String[8];
		for(int i = 0; i < placar.length; i++)
		{
			String [] linhaRankingSeparada = placar[i].split(";");
			placarPontos[i] = linhaRankingSeparada[1];
		}
		return placarPontos;
	}
	
	private String [] pegaNomesDoPlacar(String [] placar)
	{
		String [] placarNomes = new String[8];
		for(int i = 0; i < placar.length; i++)
		{
			String [] linhaRankingSeparada = placar[i].split(";");
			placarNomes[i] = linhaRankingSeparada[0];
		}
		return placarNomes;
	}
	
	private String [] pegaBombaExplodeDoPlacar(String[] placar)
	{
		String [] placarBombaExplode = new String[8];
		for(int i = 0; i < placar.length; i++)
		{
			String [] linhaRankingSeparada = placar[i].split(";");
			placarBombaExplode[i] = linhaRankingSeparada[2];
		}
		return placarBombaExplode;
	}
	
	private String [] pegaBombaEhColocadaDoPlacar(String[] placar)
	{
		String [] placarBombaEhColocada = new String[8];
		for(int i = 0; i < placar.length; i++)
		{
			String [] linhaRankingSeparada = placar[i].split(";");
			placarBombaEhColocada[i] = linhaRankingSeparada[3];
		}
		return placarBombaEhColocada;
	}
	
	
	public void criarJanelaRanking(String [] placar)
	{
		String [] nomesPlacar = this.pegaNomesDoPlacar(placar);
		String [] pontosPlacar = this.pegaPontosDoPlacar(placar);
		String [] bombaExplodePlacar = this.pegaBombaExplodeDoPlacar(placar);
		String [] bombaEhColocadaPlacar = this.pegaBombaEhColocadaDoPlacar(placar);
		
		//primeiro, criarei as JLabels de rankings
		for(int i = 0; i < placar.length; i++)
		{
			int posicaoNoRanking = i + 1;
			String textoNomeRanking = nomesPlacar[i];
			String textoPosicaoRanking = "";
			if(posicaoNoRanking == 1)
			{
				textoPosicaoRanking = posicaoNoRanking + "st)";
			}
			else if(posicaoNoRanking == 2)
			{
				textoPosicaoRanking = posicaoNoRanking + "nd)";
			}
			else if(posicaoNoRanking == 3)
			{
				textoPosicaoRanking = posicaoNoRanking + "rd)";
			}
			else
			{
				textoPosicaoRanking = posicaoNoRanking + "th)";
			}
			posicaoRanking[i] = new JLabel(textoPosicaoRanking);
			posicaoRanking[i].setFont(new Font("Serif", Font.BOLD, 20));
			posicaoRanking[i].setForeground(Color.ORANGE);
			
			nomesRanking[i] = new JLabel(textoNomeRanking);
			nomesRanking[i].setFont(new Font("Serif", Font.BOLD, 20));
			nomesRanking[i].setForeground(Color.ORANGE);
			
			String textoPontosRanking = pontosPlacar[i];
			pontosRanking[i] = new JLabel(textoPontosRanking);
			pontosRanking[i].setFont(new Font("Serif", Font.BOLD, 20));
			pontosRanking[i].setForeground(Color.ORANGE);
			
			String textoBombaExplodeRanking = bombaExplodePlacar[i];
			bombaExplodirRanking[i] = new JLabel(textoBombaExplodeRanking);
			bombaExplodirRanking[i].setFont(new Font("Serif", Font.BOLD, 20));
			bombaExplodirRanking[i].setForeground(Color.ORANGE);
			
			String textoBombaEhColocadaRanking = bombaEhColocadaPlacar[i];
			bombaColocarRanking[i] = new JLabel(textoBombaEhColocadaRanking);
			bombaColocarRanking[i].setFont(new Font("Serif", Font.BOLD, 20));
			bombaColocarRanking[i].setForeground(Color.ORANGE);
			
		}
		//agora, criemos o JLabel do titulo
		this.Ranking = new JLabel("Ranking");
		Ranking.setFont(new Font("Serif", Font.BOLD, 30));
		Ranking.setForeground(Color.ORANGE);
		//agora, criemos o botao de voltar a jogar
		fecharJogo = new JButton("fechar jogo");
		fecharJogo.addActionListener(this);
		//agora, unir esses componentes
		JPanel painelRanking = new JPanel();
		
		GridBagLayout layoutRanking = new GridBagLayout();
		painelRanking.setLayout(layoutRanking);
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridwidth = 5;// tres colunas
		c.gridheight = 1;
		c.gridx = 0;
		c.gridy = 0;//linha
		painelRanking.add(Ranking, c);
		
		
		//criacao de indices
		
		JLabel posicao = new JLabel("posição");
		posicao.setFont(new Font("Serif", Font.BOLD, 18));
		posicao.setForeground(Color.ORANGE);
		c.gridwidth = 1;
		c.gridheight = 1;
		c.gridx = 0;
		c.gridy = 1;
		painelRanking.add(posicao,c);
		
		JLabel nome = new JLabel("nome");
		nome.setFont(new Font("Serif", Font.BOLD, 18));
		nome.setForeground(Color.ORANGE);
		c.gridwidth = 1;
		c.gridheight = 1;
		c.gridx = 1;
		c.gridy = 1;
		painelRanking.add(nome,c);
		
		JLabel pontuacao = new JLabel("pontuação");
		pontuacao.setFont(new Font("Serif", Font.BOLD, 18));
		pontuacao.setForeground(Color.ORANGE);
		c.gridwidth = 1;
		c.gridheight = 1;
		c.gridx = 2;
		c.gridy = 1;
		painelRanking.add(pontuacao,c);
		
		JLabel bombaExplode = new JLabel("segundos até uma bomba explodir");
		bombaExplode.setFont(new Font("Serif", Font.BOLD, 18));
		bombaExplode.setForeground(Color.ORANGE);
		c.gridwidth = 1;
		c.gridheight = 1;
		c.gridx = 4;
		c.gridy = 1;
		painelRanking.add(bombaExplode,c);
		
		JLabel bombaAdicionada = new JLabel("segundos até novas bombas aparecerem na tela");
		bombaAdicionada.setFont(new Font("Serif", Font.BOLD, 18));
		bombaAdicionada.setForeground(Color.ORANGE);
		c.weightx = 0.7;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.gridx = 3;
		c.gridy = 1;
		painelRanking.add(bombaAdicionada,c);
		
		
		for(int j = 0; j < nomesRanking.length; j++)
		{
			c.gridwidth = 1;// uma coluna
			c.gridheight = 1;
			c.gridx = 0;
			c.gridy = j + 2;//linha
			c.weightx = 0.5;
			c.weighty = 0.5;
			painelRanking.add(this.posicaoRanking[j], c);
			
			c.gridwidth = 1;// uma coluna
			c.gridheight = 1;
			c.gridx = 1;
			c.gridy = j + 2;//linha
			painelRanking.add(this.nomesRanking[j], c);
			
			c.gridwidth = 1;// uma coluna
			c.gridheight = 1;
			c.gridx = 2;
			c.gridy = j + 2;//linha
			painelRanking.add(this.pontosRanking[j], c);
			
			c.gridwidth = 1;// uma coluna
			c.gridheight = 1;
			c.gridx = 3;
			c.gridy = j + 2;//linha
			painelRanking.add(this.bombaExplodirRanking[j], c);
			
			c.gridwidth = 1;// uma coluna
			c.gridheight = 1;
			c.gridx = 4;
			c.gridy = j + 2;//linha
			painelRanking.add(this.bombaColocarRanking[j], c);
		}
		
		c.gridwidth = 5;// tres colunas
		c.gridheight = 1;
		c.gridx = 0;
		c.gridy = 10;//linha
		painelRanking.add(this.fecharJogo, c);
		painelRanking.setBackground(new Color(112, 146, 190));
		
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();  
		janelaRanking.setSize(d);  
		janelaRanking.setResizable(false);  
		janelaRanking.add(painelRanking);
		janelaRanking.setVisible(true);
		
	}


	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		if(arg0.getSource() == this.fecharJogo)
		{
			System.exit(0);
		}
	}

}
