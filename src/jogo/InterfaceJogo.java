package jogo;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import fachadaparadao.FachadaDAO;

public class InterfaceJogo implements KeyListener
{
	private static InterfaceJogo singletonInterfaceJogo;
	private JTextField campoPreencher;
	private JFrame telaJogo;
	private JLabel [] coracoesJogador;
	private  JLabel pontuacao;
	private InterfaceBomba [] imagensBombas;
	private String modoJogo;
	private int numPalavrasNoJogo;
	private PalavrasETraducoes palavrasETraducoesDoJogo;
	private JLabel[] labelsPalavrasNaoAcertadas;
	private JLabel[] labelsTraducoesPalavrasNaoAcertadas;
	private int quantasBombasJaExplodiram; //útil para alterar a tabela que mostra as palavras erradas por um jogador
	private volatile boolean jogoAcabou; //booleano alterado quando jframe é disposed()
	
	
	private  InterfaceJogo()
	{
		modoJogo = "nenhum";
		imagensBombas = new InterfaceBomba[20];
		String nomeListaTemPalavrasASeremUsadasNoJogo = FachadaDAO.getFachadaDAO().pegarNomeListaASerUsadaNoJogo();
		this.palavrasETraducoesDoJogo = FachadaDAO.getFachadaDAO().extrairPalavrasETraducoes(nomeListaTemPalavrasASeremUsadasNoJogo);
		numPalavrasNoJogo = this.palavrasETraducoesDoJogo.getNumPalavrasNoJogo();
		
		labelsPalavrasNaoAcertadas = new JLabel[5];
		labelsTraducoesPalavrasNaoAcertadas = new JLabel[5];
		for(int i = 0; i < 5; i++)
		{
			labelsPalavrasNaoAcertadas[i] = new JLabel("");
			labelsPalavrasNaoAcertadas[i].setFont(new Font("Serif", Font.BOLD, 18));
			labelsPalavrasNaoAcertadas[i].setForeground(Color.WHITE);
			labelsTraducoesPalavrasNaoAcertadas[i] = new JLabel("");
			labelsTraducoesPalavrasNaoAcertadas[i].setFont(new Font("Serif", Font.BOLD, 16));
			labelsTraducoesPalavrasNaoAcertadas[i].setForeground(Color.WHITE);
			
		}
		quantasBombasJaExplodiram = 0;
		
		this.jogoAcabou = false;
	}
	
	
	
	public static synchronized InterfaceJogo getInterfaceJogo()
	{
		if(singletonInterfaceJogo == null)
		{
			singletonInterfaceJogo = new InterfaceJogo();
		}
		return singletonInterfaceJogo;
	}
	
	
	public PalavrasETraducoes getPalavrasETraducoesDoJogo()
	{
		return palavrasETraducoesDoJogo;
	}
	
	public int getNumPalavrasNoJogo()
	{
		return this.numPalavrasNoJogo;
	}
	
	public synchronized void setModo(String novoModo)
	{
		modoJogo = novoModo;
	}
	
	public String getModo()
	{
		return modoJogo;
	}
	
	public synchronized InterfaceBomba getBomba(int numeroBomba)
	{
		return imagensBombas[numeroBomba];
	}
	
	public synchronized boolean getJogoAcabou() 
	{
		return jogoAcabou;
	}
	
	
	public void reduzirCoracao(Jogador jogador)
	{
		ImageIcon coracaoPerdido = CriadorImageIcon.criarImageIcon("imagens/heartbreak.png", 
												   "coracao perdido do jogador");
		int pontosVida = jogador.getPontosVida();
		
		this.coracoesJogador[pontosVida].setIcon(coracaoPerdido);
	}
	
	public void incrementarPlacar(int pontosNovos)
	{
		pontuacao.setText(String.valueOf(pontosNovos));
	}
	
	
	public JPanel criarCoracoesJogador1()
	{
		ImageIcon coracaoCheio = CriadorImageIcon.criarImageIcon("imagens/heart.png", "ponto de vida cheio");
		
		//criando panels para as vidas dos jogadores
		JLabel labelCoracao1 = new JLabel(coracaoCheio);
		JLabel labelCoracao2 = new JLabel(coracaoCheio);
		JLabel labelCoracao3 = new JLabel(coracaoCheio);
		JLabel labelCoracao4 = new JLabel(coracaoCheio);
		JLabel labelCoracao5 = new JLabel(coracaoCheio);
		
		//adicionando as labels no array de JLabels
		coracoesJogador = new JLabel[5];
		coracoesJogador[0] = labelCoracao1;
		coracoesJogador[1] = labelCoracao2;
		coracoesJogador[2] = labelCoracao3;
		coracoesJogador[3] = labelCoracao4;
		coracoesJogador[4] = labelCoracao5;
		//Criar uma label para dizer que as vidas são do jogador
		JLabel vidas = new JLabel("Vidas:");
		vidas.setFont(new Font("Serif", Font.BOLD, 20));
		vidas.setForeground(new Color(255, 201, 14));
		
		//criando um container para abrigar os coracoes e a label vidas
		JPanel painelCoracoes = new JPanel();
		
		painelCoracoes.add(vidas);
		painelCoracoes.add(labelCoracao1);
		painelCoracoes.add(labelCoracao2);
		painelCoracoes.add(labelCoracao3);
		painelCoracoes.add(labelCoracao4);
		painelCoracoes.add(labelCoracao5);

		painelCoracoes.setBackground(new Color(112, 146, 190));
		
		return painelCoracoes;
	}
	
	public JPanel criarPontuacao()
	{
		JLabel frasePontuacao = new JLabel("Pontuação:");
		frasePontuacao.setFont(new Font("Serif", Font.BOLD, 20));
		frasePontuacao.setForeground(new Color(255, 201, 14));
		
		JPanel painelPontuacao = new JPanel();
		painelPontuacao.setBackground(new Color(112, 146, 190));
		painelPontuacao.add(frasePontuacao);
		
		pontuacao = new JLabel("0");
		
		pontuacao.setFont(new Font("Serif", Font.BOLD, 20));
		pontuacao.setForeground(new Color(255, 201, 14));
		painelPontuacao.add(pontuacao);
		
		return painelPontuacao;
	}

	
	//o metodo abaixo serve pro jogador adivinhar a palavra que vai desativar uma bomba.
	public JPanel criarCampoDigitarPalavras()
	{
		JPanel painelCampo = new JPanel();
		painelCampo.setBackground(new Color(112, 146, 190));
		campoPreencher = new JTextField(70);
		painelCampo.add(campoPreencher);
		campoPreencher.addKeyListener(this);
		return painelCampo;
	}
	
	public JPanel criarCampoBombas()
	{
		Random geraAleatorio = new Random();
		JPanel campoBombas = new JPanel(new GridLayout(5, 4));
		campoBombas.setBackground(new Color(255, 201, 14));
		
		for(int i = 0; i < 20; i++)
		{
			int numeroAleatorio = geraAleatorio.nextInt(numPalavrasNoJogo);
			String palavraBomba = this.palavrasETraducoesDoJogo.getPalavra(numeroAleatorio);
			String traducaoBomba = this.palavrasETraducoesDoJogo.getTraducao(numeroAleatorio);
			InterfaceBomba bomba = new InterfaceBomba(palavraBomba, traducaoBomba);
			this.imagensBombas[i] = bomba;
			campoBombas.add(bomba.getUneBombaEPalavra());
		}
		return campoBombas;
	}
	
	public synchronized void criarInterfaceJogo()
	{
		telaJogo = new JFrame();
		telaJogo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		telaJogo.setTitle("Bomb Words");
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();  
		telaJogo.setSize(d);  
		telaJogo.setResizable(false);  
		JPanel campoBombas = this.criarCampoBombas();
		JPanel campoCoracoes = this.criarCoracoesJogador1();
		JPanel campoPlacar = this.criarPontuacao();
		JPanel campoDigitar = this.criarCampoDigitarPalavras();
		JPanel campoPalavrasNaoAcertadas = this.criarPainelComPalavrasNaoAcertadas();
		//criando o panel que vai juntar tudo
		JPanel painelJogo = new JPanel();
		painelJogo.setBackground(new Color(112, 146, 190));
		painelJogo.setSize(1000, 1000);
		GridBagLayout layoutFundo = new GridBagLayout();
		painelJogo.setLayout(layoutFundo);
		GridBagConstraints g = new GridBagConstraints();
		
		g.gridwidth =  3;//tres colunas
		g.gridheight = 1;
		g.gridx = 0;
		g.gridy = 0;
		painelJogo.add(campoCoracoes, g);
		g.gridwidth =  3;
		g.gridheight = 1;
		g.gridx = 0;
		g.gridy = 1;//linha
		painelJogo.add(campoPlacar, g);
		g.gridwidth =  3;
		g.gridheight = 1;
		g.gridx = 0;
		g.gridy = 2;
		painelJogo.add(campoDigitar, g);
		
		
		g.gridwidth =  2;
		g.gridheight = 5;
		g.weightx = 0.8;//espaco extra
		g.weighty = 0.8;
		g.gridx = 0;
		g.gridy = 3;
		g.anchor = GridBagConstraints.SOUTH;
		painelJogo.add(campoBombas, g);
		
		g.gridwidth =  1;
		g.gridheight = 5;
		g.weightx = 0.8;//espaco extra
		g.weighty = 0.8;
		g.gridx = 2;
		g.gridy = 3;
		g.anchor = GridBagConstraints.EAST;
		painelJogo.add(campoPalavrasNaoAcertadas, g);
		
		telaJogo.add(painelJogo);
		telaJogo.setVisible(true);
		
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) 
	{
		 int key = e.getKeyCode();
         if (key == KeyEvent.VK_ENTER) 
         {
            String digitadaPeloUsuario = campoPreencher.getText();
            synchronized(this)
            {
            	
            }
            if(digitadaPeloUsuario != null)
            {
            	ChecaSeJogadorAcertouTraducao checaPalpiteJogador = new ChecaSeJogadorAcertouTraducao(imagensBombas);
            	 LinkedList<InterfaceBomba> bombasDesativar = 
            			 checaPalpiteJogador.quaisBombasDevemSerDesativadas(digitadaPeloUsuario);
                 if(bombasDesativar != null)
                 {
                	for(int i = 0; i < bombasDesativar.size(); i++)
                	{
                		bombasDesativar.get(i).setAtivada(false);
                	}
                	
                 	this.modoJogo = "desativarBomba";
                 }
                 campoPreencher.setText("");   
            }
         }
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	public JPanel criarPainelComPalavrasNaoAcertadas()
	{
		GridBagConstraints grid = new GridBagConstraints();
		JPanel painelComPalavrasNaoAcertadas = new JPanel();
		Dimension d = new Dimension(300,440);
		painelComPalavrasNaoAcertadas.setPreferredSize(d);

		TitledBorder titulo = BorderFactory.createTitledBorder("Palavras das bombas que explodiram");
		titulo.setTitleColor(Color.WHITE);

		painelComPalavrasNaoAcertadas.setBorder(titulo);
		
		
		painelComPalavrasNaoAcertadas.setBackground(new Color(112, 146, 190));
		GridBagLayout layout = new GridBagLayout();
		painelComPalavrasNaoAcertadas.setLayout(layout);
		
		int percorredorGridY = 0;
		for(int i = 0; i < 5; i++)
		{
			JPanel painelLinha = new JPanel();
			painelLinha.setBackground(new Color(112, 146, 190));
			painelLinha.add(this.labelsPalavrasNaoAcertadas[i]);
			
			grid.gridx = 0;
			grid.gridy = percorredorGridY;
			grid.gridheight = 1;
			painelComPalavrasNaoAcertadas.add(painelLinha, grid);
			
			percorredorGridY = percorredorGridY + 1;
			
			//falta colocar a traducao associada
			JPanel painelLinha2 = new JPanel();
			painelLinha2.setBackground(new Color(112, 146, 190));
			painelLinha2.add(this.labelsTraducoesPalavrasNaoAcertadas[i]);
			
			grid.gridx = 0;
			grid.gridy = percorredorGridY;
			grid.gridheight = 1;
			painelComPalavrasNaoAcertadas.add(painelLinha2, grid);
			
			percorredorGridY = percorredorGridY + 1;
			
			//agora uma linha em branco
			JLabel linhaBranca = new JLabel("");
			JPanel painelBranco = new JPanel();
			painelBranco.setBackground(new Color(112, 146, 190));
			painelBranco.add(linhaBranca);
			grid.gridx = 0;
			grid.gridy = percorredorGridY;
			grid.gridheight = 1;
			painelComPalavrasNaoAcertadas.add(painelBranco, grid);
			percorredorGridY = percorredorGridY + 1;
		}

		return painelComPalavrasNaoAcertadas;
	}
	
	public synchronized void inserirPalavraETraducaoDaBombaQueExplodiu(InterfaceBomba interBomba)
	{
		this.labelsPalavrasNaoAcertadas[quantasBombasJaExplodiram].setText("Palavra : " + interBomba.getPalavra());
		this.labelsTraducoesPalavrasNaoAcertadas[quantasBombasJaExplodiram].setText("Tradução : " + interBomba.getTraducao());
		quantasBombasJaExplodiram = quantasBombasJaExplodiram + 1;
	}
	
	public void disposeTelaJogo()
	{
		this.jogoAcabou = true;
		this.telaJogo.dispose();
	}
}
