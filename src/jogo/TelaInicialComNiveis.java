package jogo;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.LinkedList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import fachadaparadao.FachadaDAO;


public class TelaInicialComNiveis implements ActionListener, ItemListener
{
	//a tela inicial com opcões de escolher o estágio do curso de inglês e o nível difícil,médio ou fácil
	private String nomeJogador;
	JButton botaoJogar;
	JTextField textFieldNomeJogador;
	JFrame janelaInicial;
	LinkedList<String> nomesListasASeremUsadas; //indica quais listas serao usadas: estagio1,basico,estagio2...
	
	//os checkbox com os estagios do watford
	JCheckBox basico;
	JCheckBox intermediario;
	JCheckBox avancado;
	
	//os radiobuttons com os niveis de dificuldade
	JRadioButton facil;
	JRadioButton medio;
	JRadioButton dificil;
	JRadioButton intenso;
	
	
	public TelaInicialComNiveis()
	{
		nomeJogador = null;
		nomesListasASeremUsadas = new LinkedList<String>();
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
		grid.gridwidth = 2;
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
		grid.gridwidth = 2;
		painelUneTudo.add(painelJuntaTextFieldELabel, grid);
		
		//adicionar painel para selecionar o estÃ¡gio
		JPanel painelEstagios = this.criarPainelJCheckBoxEstagiosWatford();
		grid.gridheight = 5;
		grid.gridx = 0;
		grid.gridy = 3;
		grid.gridwidth = 1;
		painelUneTudo.add(painelEstagios, grid);
		
		//adicionar o painel para selecionar nivel de dificuldade
		JPanel painelNivel = criarPainelNivelDoJogo();
		grid.gridheight = 5;
		grid.gridx = 1;
		grid.gridy = 3;
		grid.gridwidth = 1;
		painelUneTudo.add(painelNivel, grid);
		
		//agora as regras e o botao comecar
		JLabel tituloRegras = new JLabel("Como jogar");
		tituloRegras.setFont(new Font("Serif", Font.BOLD, 25));
		tituloRegras.setForeground(new Color(255, 201, 14));
		
		JLabel regra0 = new JLabel("1 - Aparecerão algumas bombas na tela com palavras em cima delas");
		regra0.setFont(new Font("Serif", Font.BOLD, 23));
		regra0.setForeground(new Color(255, 201, 14));
		
		JLabel regra1 = new JLabel("2 - Digite a tradução para as palavras que aparecem em cima das bombas e aperte enter");
		regra1.setFont(new Font("Serif", Font.BOLD, 23));
		regra1.setForeground(new Color(255, 201, 14));
		
		JLabel regra2 = new JLabel("3 - Se você acertou a tradução, a bomba é desativada e você ganha 100 pontos");
		regra2.setFont(new Font("Serif", Font.BOLD, 23));
		regra2.setForeground(new Color(255, 201, 14));
		
		JLabel regra3 = new JLabel("4 - Se o contador de uma bomba chega no zero, você perde uma vida");
		regra3.setFont(new Font("Serif", Font.BOLD, 23));
		regra3.setForeground(new Color(255, 201, 14));
		
		JLabel regra4 = new JLabel("5 - Se você perder 5 vidas, é fim de jogo");
		regra4.setFont(new Font("Serif", Font.BOLD, 23));
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
		
		grid.gridheight = 5;
		grid.gridx = 0;
		grid.gridy = 8;
		grid.gridwidth = 2;

		painelUneTudo.add(regras, grid);
		
		//vamos adicionar o botao jogar
		botaoJogar = new JButton("jogar");
		botaoJogar.addActionListener(this);
		
		
		grid.gridheight = 1;
		grid.gridx = 0;
		grid.gridy = 13;
		grid.gridwidth = 2;
		painelUneTudo.add(botaoJogar, grid);
		
		janelaInicial.add(painelUneTudo);
		
		janelaInicial.setVisible(true);

	}
	
	private JPanel criarPainelJCheckBoxEstagiosWatford()
	{
		JPanel painelCheckBoxes = new JPanel();
		painelCheckBoxes.setBackground(new Color(112, 146, 190));
		GridBagLayout gridLayout = new GridBagLayout();
		painelCheckBoxes.setLayout(gridLayout);
		GridBagConstraints grid = new GridBagConstraints();
		
		JLabel titulo = new JLabel("O jogo deve ter palavras dos estágios:");
		titulo.setFont(new Font("Serif", Font.BOLD, 20));
		titulo.setForeground(new Color(255, 201, 14));
		JPanel painelTitulo = new JPanel();
		painelTitulo.add(titulo);
		painelTitulo.setBackground(new Color(112, 146, 190));
		painelTitulo.add(titulo);
		grid.gridx = 0;
		grid.gridy = 0;
		grid.gridheight = 1;
		grid.gridwidth = 2;
		grid.anchor = GridBagConstraints.WEST;
		painelCheckBoxes.add(painelTitulo, grid);
		
		
		LinkedList<JCheckBox> listaCheckBox = new LinkedList<JCheckBox>();
		basico = new JCheckBox("básico");
		intermediario = new JCheckBox("intermediário");
		avancado = new JCheckBox("avançado");
		
		
		listaCheckBox.add(basico);
		listaCheckBox.add(intermediario);
		listaCheckBox.add(avancado);
		
		
		for(int i = 0; i < 3; i++)
		{
			grid.gridx = 0;
			grid.gridy = i + 1; //a linha 0 jÃ¡ possui o titulo
			grid.gridwidth = 1;
			grid.gridheight = 1;
			
			JCheckBox check = listaCheckBox.get(i);
			check.setForeground(new Color(255, 201, 14));
			check.setBackground(new Color(112, 146, 190));
			check.setFont(new Font("Serif", Font.BOLD, 16));
			check.addItemListener(this); //o listener para checkbox
			painelCheckBoxes.add(check, grid);
		}
		
		
		return painelCheckBoxes;
	}
	
	
	private JPanel criarPainelNivelDoJogo()
	{
		facil = new JRadioButton("fácil (20 segundos para uma bomba explodir)");
		medio = new JRadioButton("médio (15 segundos para uma bomba explodir)");
		dificil = new JRadioButton("difícil (10 segundos para uma bomba explodir)");
		intenso = new JRadioButton("intenso (5 segundos para uma bomba explodir e muito mais bombas aparecem na tela)");
		
		facil.setForeground(new Color(255, 201, 14));
		facil.setBackground(new Color(112, 146, 190));
		facil.setFont(new Font("Serif", Font.BOLD, 17));
		medio.setForeground(new Color(255, 201, 14));
		medio.setBackground(new Color(112, 146, 190));
		medio.setFont(new Font("Serif", Font.BOLD, 17));
		dificil.setForeground(new Color(255, 201, 14));
		dificil.setBackground(new Color(112, 146, 190));
		dificil.setFont(new Font("Serif", Font.BOLD, 17));
		intenso.setForeground(new Color(255, 201, 14));
		intenso.setBackground(new Color(112, 146, 190));
		intenso.setFont(new Font("Serif", Font.BOLD, 17));
		
		ButtonGroup dificuldades = new ButtonGroup();
		dificuldades.add(facil);
		dificuldades.add(medio);
		dificuldades.add(dificil);
		dificuldades.add(intenso);
		
		
		facil.setSelected(true);
		facil.addActionListener(this);
		medio.addActionListener(this);
		dificil.addActionListener(this);
		intenso.addActionListener(this);
		
		
		//agora iremos realmente criar o painel
		
		JPanel painelNivelDificuldade = new JPanel();
		painelNivelDificuldade.setBackground(new Color(112, 146, 190));
		GridBagLayout gridLayout = new GridBagLayout();
		painelNivelDificuldade.setLayout(gridLayout);
		GridBagConstraints grid = new GridBagConstraints();
		
		
		JLabel titulo = new JLabel("Nível de dificuldade:");
		titulo.setFont(new Font("Serif", Font.BOLD, 20));
		titulo.setForeground(new Color(255, 201, 14));
		JPanel painelTitulo = new JPanel();
		painelTitulo.add(titulo);
		painelTitulo.setBackground(new Color(112, 146, 190));
		painelTitulo.add(titulo);
		grid.gridx = 0;
		grid.gridy = 0;
		grid.gridheight = 1;
		painelNivelDificuldade.add(painelTitulo, grid);
		
		grid.gridx = 0;
		grid.gridy = 1;
		grid.gridheight = 1;
		painelNivelDificuldade.add(facil, grid);
		
		grid.gridx = 0;
		grid.gridy = 2;
		grid.gridheight = 1;
		painelNivelDificuldade.add(medio, grid);
		
		grid.gridx = 0;
		grid.gridy = 3;
		grid.gridheight = 1;
		painelNivelDificuldade.add(dificil, grid);
		
		grid.gridx = 0;
		grid.gridy = 4;
		grid.gridheight = 1;
		painelNivelDificuldade.add(intenso, grid);
		
		return painelNivelDificuldade;
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
				definirUmaNovaListaDePalavrasPrincipal();
				definirConfiguracoesDoJogo();
				janelaInicial.dispose();
			}
		}
	}
	
	public void definirUmaNovaListaDePalavrasPrincipal()
	{
		//assim que o jogador clica jogar, a lista "palavras" que é a principal muda de acordo com o que foi selecionado nas Jcheckboxes
		
		//primeiro vamos limpar a lista "palavras" atual
		
		FachadaDAO.getFachadaDAO().limparListaPalavras("palavras");
		
		
		//agora vamos sair juntando as listas
		JuntaListasDePalavras juntaListas = new JuntaListasDePalavras();
		for(int i = 0; i < nomesListasASeremUsadas.size(); i++)
		{
			juntaListas.juntarListas("palavras", nomesListasASeremUsadas.get(i));
		}
	}
	
	public void definirConfiguracoesDoJogo()
	{
		//aqui serÃ¡ definido as configuracoes com base na dificuldade escolhida pelo jogador
		int tempoParaSetarBomba = 10;
		int tempoParaBombaExplodir = 20;
		
		if(facil.isSelected() == true)
		{
			tempoParaSetarBomba = 10;
			tempoParaBombaExplodir = 20;
		}
		else if(medio.isSelected() == true)
		{
			tempoParaSetarBomba = 10;
			tempoParaBombaExplodir = 15;
		}
		else if(dificil.isSelected() == true)
		{
			tempoParaSetarBomba = 10;
			tempoParaBombaExplodir = 10;
		}
		else if(intenso.isSelected() == true)
		{
			tempoParaSetarBomba = 5;
			tempoParaBombaExplodir = 5;
		}
		
		FachadaDAO.getFachadaDAO().setarNovasConfiguracoesJogo(tempoParaSetarBomba, tempoParaBombaExplodir);
	}


	@Override
	public void itemStateChanged(ItemEvent e) 
	{
		Object obj = e.getSource();
		if(obj == this.basico)
		{
			if(basico.isSelected() == true)
			{
				nomesListasASeremUsadas.add("basico");
			}
			else if(basico.isSelected() == false)
			{
				nomesListasASeremUsadas.remove("basico");
			}
		}
		else if(obj == this.intermediario)
		{
			if(intermediario.isSelected() == true)
			{
				nomesListasASeremUsadas.add("intermediario");
			}
			else if(intermediario.isSelected() == false)
			{
				nomesListasASeremUsadas.remove("intermediario");
			}
		}
		else if(obj == this.avancado)
		{
			if(avancado.isSelected() == true)
			{
				nomesListasASeremUsadas.add("avancado");
			}
			else if(avancado.isSelected() == false)
			{
				nomesListasASeremUsadas.remove("avancado");
			}
		}
	}
	
	
	

}
