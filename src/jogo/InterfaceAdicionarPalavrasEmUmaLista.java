package jogo;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.NoSuchElementException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


import command.CommandAdicionarPalavraNaLista;
import command.ConcreteCommandAdicionarPalavraNaLista;



public class InterfaceAdicionarPalavrasEmUmaLista implements ActionListener, KeyListener
{
	private JFrame janelaEditarLista;
	private JTextField textFieldPalavra;
	private JTextField textFieldTraducao;
	private JButton salvar;
	private JButton botaoDesfazerAdicaoPalavra;
	private String nomeListaASerEditada;
	private JLabel labelFeedBackPalavraRegistrada;//label que mostra um feedback se a palavra conseguiu ser registrada
	private InterfaceListaPalavras mudarPalavrasDasListas;
	
	private LinkedList<CommandAdicionarPalavraNaLista> comandosAdicionarPalavraNaLista;
	
	public InterfaceAdicionarPalavrasEmUmaLista()
	{
		comandosAdicionarPalavraNaLista = new LinkedList<CommandAdicionarPalavraNaLista>();
	}

	public void criarJanelaEditarLista(String nomeLista, InterfaceListaPalavras interfaceMuda)
	{
		mudarPalavrasDasListas = interfaceMuda;
		nomeListaASerEditada = nomeLista;
		
		janelaEditarLista = new JFrame("Inserir palavras em uma lista");
		janelaEditarLista.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		//setando limite maximo de um jtextfield
		textFieldPalavra = new JTextField("", 25);
		SetarLimiteMaximoTextField limiteMaximo = new SetarLimiteMaximoTextField();
		limiteMaximo.setMaxChars(26);
		textFieldPalavra.setDocument(limiteMaximo);
		
		JLabel labelPalavra = new JLabel("Palavra:");
		labelPalavra.setFont(new Font("Serif", Font.BOLD, 20));
		labelPalavra.setForeground(new Color(255, 201, 14));
		JPanel unePalavraETextField = new JPanel();
		unePalavraETextField.setBackground(new Color(112, 146, 190));
		unePalavraETextField.add(labelPalavra);
		unePalavraETextField.add(textFieldPalavra);
		
		textFieldTraducao = new JTextField("", 25);
		JLabel labelTraducao = new JLabel("Tradução:");
		labelTraducao.setFont(new Font("Serif", Font.BOLD, 20));
		labelTraducao.setForeground(new Color(255, 201, 14));
		JPanel uneTraducaoETextField = new JPanel();
		uneTraducaoETextField.setBackground(new Color(112, 146, 190));
		uneTraducaoETextField.add(labelTraducao);
		uneTraducaoETextField.add(textFieldTraducao);
		
		
		JLabel labelLista = new JLabel("Lista:");
		labelLista.setFont(new Font("Serif", Font.BOLD, 20));
		labelLista.setForeground(new Color(255, 201, 14));
		JLabel labelNomeLista = new JLabel(nomeLista);
		labelNomeLista.setFont(new Font("Serif", Font.BOLD, 20));
		labelNomeLista.setForeground(Color.WHITE);
		JPanel uneLabelENomeLista = new JPanel();
		uneLabelENomeLista.setBackground(new Color(112, 146, 190));
		uneLabelENomeLista.add(labelLista);
		uneLabelENomeLista.add(labelNomeLista);
		
		
		JPanel uneTudo = new JPanel();
		uneTudo.setBackground(new Color(112, 146, 190));
		GridBagLayout layout = new GridBagLayout();
		uneTudo.setLayout(layout);
		
		GridBagConstraints grid = new GridBagConstraints();
		
		grid.gridx = 0;
		grid.gridy = 0;
		grid.gridheight = 1;
		uneTudo.add(uneLabelENomeLista, grid);
		
		grid.gridx = 0;
		grid.gridy = 1;
		grid.gridheight = 1;
		
		uneTudo.add(unePalavraETextField, grid);
		
		grid.gridx = 0;
		grid.gridy = 2;
		grid.gridheight = 1;
		
		uneTudo.add(uneTraducaoETextField, grid);
		
		salvar = new JButton("salvar nova palavra");
		salvar.addActionListener(this);
		grid.gridx = 0;
		grid.gridy = 3;
		grid.gridheight = 1;
		uneTudo.add(salvar, grid);
		
		this.botaoDesfazerAdicaoPalavra = new JButton("desfazer adição de nova palavra");
		botaoDesfazerAdicaoPalavra.addActionListener(this);
		grid.gridx = 0;
		grid.gridy = 4;
		grid.gridheight = 1;
		uneTudo.add(botaoDesfazerAdicaoPalavra, grid);
		
		//o label com feedback caso a palavra seja salva
		labelFeedBackPalavraRegistrada = new JLabel("______________");
		labelFeedBackPalavraRegistrada.setFont(new Font("Serif", Font.BOLD, 20));
		labelFeedBackPalavraRegistrada.setForeground(Color.WHITE);
		grid.gridx = 0;
		grid.gridy = 5;
		grid.gridheight = 1;
		uneTudo.add(labelFeedBackPalavraRegistrada, grid);
		
		
		//um texto, desta vez alertando que o usuario pode usar setas
		JLabel labelInformativa1 = new JLabel("você pode transitar por este menu usando as setas do teclado");
		labelInformativa1.setFont(new Font("Serif", Font.BOLD, 18));
		labelInformativa1.setForeground(new Color(255, 201, 14));
		grid.gridx = 0;
		grid.gridy = 6;
		grid.gridheight = 1;
		uneTudo.add(labelInformativa1, grid);
		
		
		
		JLabel labelInformativa2 = new JLabel("caso você já informe uma palavra e uma tradução,");
		labelInformativa2.setFont(new Font("Serif", Font.BOLD, 18));
		labelInformativa2.setForeground(Color.WHITE);
		grid.gridx = 0;
		grid.gridy = 7;
		grid.gridheight = 1;
		uneTudo.add(labelInformativa2, grid);
		
		JLabel labelInformativa3 = new JLabel("basta clicar ENTER para salvar mais rapidamente");
		labelInformativa3.setFont(new Font("Serif", Font.BOLD, 18));
		labelInformativa3.setForeground(Color.WHITE);
		grid.gridx = 0;
		grid.gridy = 8;
		grid.gridheight = 1;
		uneTudo.add(labelInformativa3, grid);
		
		//adicionando listeners para os fields e botoes soh para o usuario transitar entre eles
	    textFieldPalavra.addKeyListener(this);
	    textFieldTraducao.addKeyListener(this);
		salvar.addKeyListener(this);
		
		
		janelaEditarLista.add(uneTudo);
		janelaEditarLista.pack();
		janelaEditarLista.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		if(arg0.getSource() == this.salvar)
		{
			this.adicionarPalavraNaLista();
			
		}
		else if(arg0.getSource() == this.botaoDesfazerAdicaoPalavra)
		{
			this.desfazerAdicaoPalavraNaLista();
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e)
	{
		int key = e.getKeyCode();
        if(key == 40)
        {
        	//se o usuario apertar a tecla da seta para baixo no teclado
        	if(textFieldPalavra.isFocusOwner() == true)
        	{
        		this.textFieldTraducao.requestFocus();
        	}
        	else if(textFieldTraducao.isFocusOwner() == true)
        	{
        		this.textFieldPalavra.requestFocus();
        	}
        }
        else if(key == 38)
        {
        	//se o usuario apertar a tecla da seta para cima no teclado
        	if(textFieldPalavra.isFocusOwner() == true)
        	{
        		this.textFieldTraducao.requestFocus();
        	}
        	else if(textFieldTraducao.isFocusOwner() == true)
        	{
        		this.textFieldPalavra.requestFocus();
        	}
        }
        else if(key == KeyEvent.VK_ENTER)
        {
        	this.adicionarPalavraNaLista();
        }
	}
	

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void desfazerAdicaoPalavraNaLista()
	{
		try
		{
			CommandAdicionarPalavraNaLista ultimoComandoAdicaoPalavra = this.comandosAdicionarPalavraNaLista.removeLast();
			ultimoComandoAdicaoPalavra.desfazerAdicionarPalavraNaLista();
			labelFeedBackPalavraRegistrada.setText("a palavra " + ultimoComandoAdicaoPalavra.getPalavraAdicionar() + " foi retirada com sucesso");
			
			//vamos agora atualizar a listagem de palavras do jogo.
			String[] listaSemExtensaoTxt = nomeListaASerEditada.split(".txt");
			mudarPalavrasDasListas.mostrarPalavrasJogo(listaSemExtensaoTxt[0]);
		}
		catch(NoSuchElementException exc)
		{
			JOptionPane.showMessageDialog(null, "nenhuma palavra nova já foi adicionada na lista");
		}
	}
	
	private void adicionarPalavraNaLista()
	{
		String[] listaSemExtensaoTxt = nomeListaASerEditada.split(".txt"); //tira extensao .txt do nome da lista
		
		String novaPalavra = this.textFieldPalavra.getText();
		String novaTraducao = this.textFieldTraducao.getText();
		
		if(novaPalavra.compareTo("") == 0 || novaTraducao.compareTo("") == 0)
		{
			JOptionPane.showMessageDialog(null, "precisa ser informado uma palavra e uma tradução");
		}
		else if(palavraTemLetrasRomanas(novaPalavra) == true && novaPalavra.length() > 25)
		{
			//palavras com caracteres romanos deveriam ter no maximo 25 caracteres
			JOptionPane.showMessageDialog(null, "para palavras com caracteres romanos, digite no maximo 25 caracteres");
		}
		else if(palavraTemLetrasRomanas(novaPalavra) == false && novaPalavra.length() > 11)
		{
			//palavras com caracteres nao romanos(exemplo: kanjis no japones) deveriam ter no maximo 11 caracteres
			JOptionPane.showMessageDialog(null, "para palavras com caracteres nao romanos, digite no maximo 11 caracteres");
		}
		else
		{
			CommandAdicionarPalavraNaLista comandoAdicionarPalavra = 
					new ConcreteCommandAdicionarPalavraNaLista(novaPalavra, novaTraducao, listaSemExtensaoTxt[0]);
	    	this.comandosAdicionarPalavraNaLista.add(comandoAdicionarPalavra);
			boolean conseguiuAdicionar = comandoAdicionarPalavra.adicionarPalavraNaLista();
			
			if(conseguiuAdicionar == true)
			{
				labelFeedBackPalavraRegistrada.setText("a palavra " + this.textFieldPalavra.getText() + " foi registrada com sucesso");
				mudarPalavrasDasListas.mostrarPalavrasJogo(listaSemExtensaoTxt[0]);
			}
		}
		
		this.textFieldPalavra.setText("");
		this.textFieldTraducao.setText("");
	}
	
	private boolean palavraTemLetrasRomanas(String palavra)
	{
		String[] letrasPossiveis = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n",
									"o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
		int percorredorPalavra = 0;
		while(percorredorPalavra < palavra.length())
		{
			String caractere = String.valueOf(palavra.charAt(percorredorPalavra));
			for(int j = 0; j < letrasPossiveis.length; j++)
			{
				if(caractere.compareTo(letrasPossiveis[j]) == 0)
				{
					return true;
				}
			}
			percorredorPalavra = percorredorPalavra + 1;
		}
		
		return false;
	}
}
