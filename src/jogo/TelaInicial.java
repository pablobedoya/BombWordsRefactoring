package jogo;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class TelaInicial implements ActionListener
{	
	private String nomeJogador;
	private JButton botaoJogar;
	private JButton botaoEditarListas;
	private JButton botaoConfiguracoes;
	private JTextField textFieldNomeJogador;
	private JFrame janelaInicial;
	private JButton definirQualListaSeraUsada;
	
	public TelaInicial()
	{
		nomeJogador = null;
	}
	
	public String getNomeJogador()
	{
		return nomeJogador;
	}
	
	public void criarTelaInicial()
	{
		janelaInicial = new JFrame();
		janelaInicial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janelaInicial.setTitle("Bomb Words");
		
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();  
		janelaInicial.setSize(d);  
		janelaInicial.setResizable(false);
		
		ImageIcon bomba = CriadorImageIcon.criarImageIcon("imagens/bomba10.gif", "uma bomba");
		JLabel labelBomba1 = new JLabel(bomba);
		JLabel labelBomba2 = new JLabel(bomba);
		JLabel tituloJogo = new JLabel("Bomb Words  ");
		tituloJogo.setFont(new Font("Serif", Font.BOLD, 50));
		tituloJogo.setForeground(new Color(255, 201, 14));
		
		JPanel uneTituloEBombas = new JPanel();
		
		uneTituloEBombas.setBackground(new Color(112, 146, 190));
		
		uneTituloEBombas.add(labelBomba1);
		uneTituloEBombas.add(tituloJogo);
		uneTituloEBombas.add(labelBomba2);
		
		
		//criacao do painel que une tudo
		JPanel painelUneTudo = new JPanel();
		painelUneTudo.setBackground(new Color(112, 146, 190));
		GridBagLayout layout = new GridBagLayout();
		painelUneTudo.setLayout(layout);
		GridBagConstraints grid = new GridBagConstraints();
		
		//adicao do titulo e bombas
		grid.gridx = 0;
		grid.gridy = 0;
		grid.gridheight = 2;
		grid.gridwidth = 3;
		painelUneTudo.add(uneTituloEBombas, grid);
		
		
		textFieldNomeJogador = new JTextField("", 20);
		JLabel labelJogador = new JLabel("Jogador:");
		labelJogador.setFont(new Font("Serif", Font.BOLD, 20));
		labelJogador.setForeground(new Color(255, 201, 14));
		
		JPanel painelJuntaTextFieldELabel = new JPanel();
		
		painelJuntaTextFieldELabel.setBackground(new Color(112, 146, 190));
		
		painelJuntaTextFieldELabel.add(labelJogador);
		painelJuntaTextFieldELabel.add(textFieldNomeJogador);
		
		
		grid.weightx = 1.0;
		grid.weighty = 1.0;
		grid.gridheight = 1;
		grid.gridx = 0;
		grid.gridy = 2;
		grid.gridwidth = 3;
		painelUneTudo.add(painelJuntaTextFieldELabel, grid);
		
		//agora o botao para definir a lista usada pelo jogo
		definirQualListaSeraUsada = new JButton("definir lista de palavras a ser usada no jogo");
		definirQualListaSeraUsada.addActionListener(this);
		grid.weightx = 1.0;
		grid.weighty = 1.0;
		grid.gridheight = 1;
		grid.gridx = 0;
		grid.gridy = 3;
		grid.gridwidth = 3;
		painelUneTudo.add(definirQualListaSeraUsada, grid);
		
		//agora as regras e o botao comecar
		JLabel tituloRegras = new JLabel("Como jogar");
		tituloRegras.setFont(new Font("Serif", Font.BOLD, 30));
		tituloRegras.setForeground(new Color(255, 201, 14));
		
		JLabel regra0 = new JLabel("1 - Aparecerão algumas bombas na tela com palavras em cima delas");
		regra0.setFont(new Font("Serif", Font.BOLD, 25));
		regra0.setForeground(new Color(255, 201, 14));
		
		JLabel regra1 = new JLabel("2 - Digite a tradução para as palavras que aparecem em cima das bombas e aperte enter");
		regra1.setFont(new Font("Serif", Font.BOLD, 25));
		regra1.setForeground(new Color(255, 201, 14));
		
		JLabel regra2 = new JLabel("3 - Se você acertou a tradução, a bomba é desativada e você ganha 100 pontos");
		regra2.setFont(new Font("Serif", Font.BOLD, 25));
		regra2.setForeground(new Color(255, 201, 14));
		
		JLabel regra3 = new JLabel("4 - Se o contador de uma bomba chega no zero, você perde uma vida");
		regra3.setFont(new Font("Serif", Font.BOLD, 25));
		regra3.setForeground(new Color(255, 201, 14));
		
		JLabel regra4 = new JLabel("5 - Se você perder 5 vidas, é fim de jogo");
		regra4.setFont(new Font("Serif", Font.BOLD, 25));
		regra4.setForeground(new Color(255, 201, 14));

		JPanel regras = new JPanel();
		regras.setBackground(new Color(112, 146, 190));
		
		GridBagLayout layoutRegras = new GridBagLayout();
		regras.setLayout(layoutRegras);
		GridBagConstraints gridRegras = new GridBagConstraints();
		
		gridRegras.gridwidth = 1;
		gridRegras.gridheight = 1;
		gridRegras.gridx = 0;
		gridRegras.gridy = 0;
		regras.add(tituloRegras, gridRegras);
		
		gridRegras.weightx = 1.0;
		gridRegras.weighty = 1.0;
		
		gridRegras.gridwidth = 1;
		gridRegras.gridheight = 1;
		gridRegras.gridx = 0;
		gridRegras.gridy = 1;
		regras.add(regra0, gridRegras);
		
		gridRegras.gridwidth = 1;
		gridRegras.gridheight = 1;
		gridRegras.gridx = 0;
		gridRegras.gridy = 2;
		regras.add(regra1, gridRegras);
		
		gridRegras.gridwidth = 1;
		gridRegras.gridheight = 1;
		gridRegras.gridx = 0;
		gridRegras.gridy = 3;
		regras.add(regra2, gridRegras);
		
		gridRegras.gridwidth = 1;
		gridRegras.gridheight = 1;
		gridRegras.gridx = 0;
		gridRegras.gridy = 4;
		regras.add(regra3, gridRegras);
		
		gridRegras.gridwidth = 1;
		gridRegras.gridheight = 1;
		gridRegras.gridx = 0;
		gridRegras.gridy = 5;
		regras.add(regra4, gridRegras);
		
		grid.gridwidth = 1;
		grid.gridheight = 5;
		grid.gridx = 0;
		grid.gridy = 4;
		grid.gridwidth = 3;

		painelUneTudo.add(regras, grid);
		
		//vamos adicionar os tres botoes na mesma linha
		botaoJogar = new JButton("jogar");
		botaoJogar.addActionListener(this);
		botaoEditarListas = new JButton("editar listas de palavras do jogo");
		botaoEditarListas.addActionListener(this);
		botaoConfiguracoes = new JButton("configurações");
		botaoConfiguracoes.addActionListener(this);
		
		
		grid.gridheight = 1;
		grid.gridx = 0;
		grid.gridy = 9;
		grid.gridwidth = 1;
		painelUneTudo.add(botaoEditarListas, grid);
		
		grid.gridheight = 1;
		grid.gridx = 1;
		grid.gridy = 9;
		grid.gridwidth = 1;
		painelUneTudo.add(botaoConfiguracoes, grid);
		
		grid.gridheight = 1;
		grid.gridx = 2;
		grid.gridy = 9;
		grid.gridwidth = 1;
		painelUneTudo.add(botaoJogar, grid);
		
		janelaInicial.add(painelUneTudo);
		
		janelaInicial.setVisible(true);

	}
	
	

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		if(arg0.getSource() == this.botaoJogar)
		{
			String novoNome = this.textFieldNomeJogador.getText();
			if(novoNome.compareTo("") == 0)
			{
				JOptionPane.showMessageDialog(null, "digite um nome para iniciar o jogo");
			}
			else
			{
				nomeJogador = novoNome;
				janelaInicial.dispose();
				
			}
		}
		else if(arg0.getSource() == this.botaoEditarListas)
		{
			InterfaceEditarListasJogo editorListas = new InterfaceEditarListasJogo();
			editorListas.criarInterfaceEditarListasJogo();
			
		}
		else if(arg0.getSource() == this.botaoConfiguracoes)
		{
			InterfaceSetarBomba configuracoes = new InterfaceSetarBomba();
			configuracoes.criarInterfaceSetarBomba();
		}
		else if(arg0.getSource() == this.definirQualListaSeraUsada)
		{
			InterfaceListaPalavras listaPalavras = new InterfaceListaPalavras();
			listaPalavras.criarInterfaceListaPalavras();
		}
		
	}

}
