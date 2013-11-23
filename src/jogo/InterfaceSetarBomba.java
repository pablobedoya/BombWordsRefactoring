package jogo;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fachadaparadao.FachadaDAO;

public class InterfaceSetarBomba implements ActionListener, KeyListener
{
	private int tempoParaSetarBomba;
	private int tempoParaBombaExplodir;
	private JTextField textfieldTempoSetarBomba;
	private JTextField textfieldTempoBombaExplodir;
	private JButton salvarAlteracoes;
	private JButton configuracaoDefault;
	
	public InterfaceSetarBomba()
	{
		String [] configuracoes = FachadaDAO.getFachadaDAO().lerConfiguracoesJogo(); 
			
		tempoParaSetarBomba = Integer.valueOf(configuracoes[0]);
		tempoParaBombaExplodir = Integer.valueOf(configuracoes[1]);
	}
	
	public int getTempoParaSetarBomba()
	{
		return tempoParaSetarBomba;
	}
	
	public void criarInterfaceSetarBomba()
	{
		JFrame janelaSetar = new JFrame("Configurações");
		janelaSetar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		textfieldTempoSetarBomba = new JTextField(String.valueOf(tempoParaSetarBomba), 5);
		JLabel labelTempoSetarBomba = new JLabel("Segundos até novas bombas aparecerem na tela:");
		labelTempoSetarBomba.setFont(new Font("Serif", Font.BOLD, 20));
		labelTempoSetarBomba.setForeground(new Color(255, 201, 14));
		JPanel unePalavraETextField = new JPanel();
		unePalavraETextField.setBackground(new Color(112, 146, 190));
		unePalavraETextField.add(labelTempoSetarBomba);
		unePalavraETextField.add(textfieldTempoSetarBomba);
		
		
		JPanel uneTudo = new JPanel();
		uneTudo.setBackground(new Color(112, 146, 190));
		GridBagLayout layout = new GridBagLayout();
		uneTudo.setLayout(layout);
		
		GridBagConstraints grid = new GridBagConstraints();
		
		grid.gridx = 0;
		grid.gridy = 0;
		grid.gridheight = 1;
		uneTudo.add(unePalavraETextField, grid);
		
		
		
		textfieldTempoBombaExplodir = new JTextField(String.valueOf(tempoParaBombaExplodir), 5);
		JLabel labelTempoBombaExplodir = new JLabel("Segundos até uma bomba explodir:");
		labelTempoBombaExplodir.setFont(new Font("Serif", Font.BOLD, 20));
		labelTempoBombaExplodir.setForeground(new Color(255, 201, 14));
		JPanel unePalavraETextField2 = new JPanel();
		unePalavraETextField2.setBackground(new Color(112, 146, 190));
		unePalavraETextField2.add(labelTempoBombaExplodir);
		unePalavraETextField2.add(textfieldTempoBombaExplodir);
		
		grid.gridx = 0;
		grid.gridy = 1;
		grid.gridheight = 1;
		uneTudo.add(unePalavraETextField2, grid);
		
		
		salvarAlteracoes = new JButton("salvar alterações");
		salvarAlteracoes.addActionListener(this);
		grid.gridx = 0;
		grid.gridy = 2;
		grid.gridheight = 1;
		uneTudo.add(salvarAlteracoes, grid);
		
		configuracaoDefault = new JButton("usar configuração default");
		configuracaoDefault.addActionListener(this);
		grid.gridx = 0;
		grid.gridy = 3;
		grid.gridheight = 1;
		uneTudo.add(configuracaoDefault, grid);
		
		//agora adicionarei os listeners aos campos e botao
		this.textfieldTempoBombaExplodir.addKeyListener(this);
		this.textfieldTempoSetarBomba.addKeyListener(this);
		this.salvarAlteracoes.addKeyListener(this);
		this.configuracaoDefault.addKeyListener(this);
		
		JLabel tempoMaximoBombaExplode = new JLabel("não insira um tempo maior que 20 segundos para bomba explodir");
		tempoMaximoBombaExplode.setFont(new Font("Serif", Font.BOLD, 15));
		tempoMaximoBombaExplode.setForeground(new Color(255, 201, 14));
		grid.gridx = 0;
		grid.gridy = 4;
		grid.gridheight = 1;
		uneTudo.add(tempoMaximoBombaExplode, grid);
		
		JLabel podeTransitarNoMenu = new JLabel("você também pode transitar por este menu usando setas e Enter do teclado");
		podeTransitarNoMenu.setFont(new Font("Serif", Font.BOLD, 15));
		podeTransitarNoMenu.setForeground(Color.white);
		grid.gridx = 0;
		grid.gridy = 5;
		grid.gridheight = 1;
		uneTudo.add(podeTransitarNoMenu, grid);
		
		janelaSetar.add(uneTudo);
		janelaSetar.pack();
		janelaSetar.setVisible(true);
	}
	
	
	private void setarNovasConfiguracoesNoDocumento()
	{
		FachadaDAO.getFachadaDAO().setarNovasConfiguracoesJogo(this.tempoParaSetarBomba, this.tempoParaBombaExplodir);
		
	}
	
	private void salvarAlteracoes()
	{
		String novoTempoSetarBombas = this.textfieldTempoSetarBomba.getText();
		int novoTempoSetarBombasEmInt = Integer.parseInt(novoTempoSetarBombas);
		
		String novoTempoExplodirBombas = this.textfieldTempoBombaExplodir.getText();
		int novoTempoExplodirBombasEmInt = Integer.parseInt(novoTempoExplodirBombas);
		
		if(novoTempoSetarBombasEmInt < 0)
		{
			JOptionPane.showMessageDialog(null, "insira um tempo positivo para Segundos até inserir novas bombas");
		}
		else if(novoTempoExplodirBombasEmInt < 0 || novoTempoExplodirBombasEmInt > 20)
		{
			JOptionPane.showMessageDialog(null, "insira um tempo entre 0 e 20 para Segundos até uma bomba explodir");
		}
		else
		{
			//mudanca de configuracoes foram aceitas
			this.tempoParaSetarBomba = novoTempoSetarBombasEmInt;
			this.tempoParaBombaExplodir = novoTempoExplodirBombasEmInt;
			setarNovasConfiguracoesNoDocumento();
			JOptionPane.showMessageDialog(null, "configurações salvas");
		}
	}
	
	private void voltarAConfiguracaoDefault()
	{
		this.tempoParaBombaExplodir = 20;
		this.tempoParaSetarBomba = 10;
		this.textfieldTempoBombaExplodir.setText(String.valueOf(tempoParaBombaExplodir));
		this.textfieldTempoSetarBomba.setText(String.valueOf(tempoParaSetarBomba));
		setarNovasConfiguracoesNoDocumento();
		JOptionPane.showMessageDialog(null, "configurações salvas. Valores default são 20 e 10");
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		if(arg0.getSource() == this.salvarAlteracoes)
		{
			this.salvarAlteracoes();
		}
		else if(arg0.getSource() == this.configuracaoDefault)
		{
			this.voltarAConfiguracaoDefault();
		}
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) 
	{
		int key = e.getKeyCode();
        if(key == 40)
        {
        	//se o usuario apertar a tecla da seta para baixo no teclado
        	if(textfieldTempoSetarBomba.isFocusOwner() == true)
        	{
        		textfieldTempoBombaExplodir.requestFocus();
        	}
        	else if(textfieldTempoBombaExplodir.isFocusOwner() == true)
        	{
        		salvarAlteracoes.requestFocus();
        	}
        	else if(salvarAlteracoes.isFocusOwner() == true)
        	{
        		configuracaoDefault.requestFocus();
        	}
        	else if(configuracaoDefault.isFocusOwner() == true)
        	{
        		textfieldTempoSetarBomba.requestFocus();
        	}
        }
        else if(key == 38)
        {
        	//se o usuario apertar a tecla da seta para cima no teclado
        	if(textfieldTempoSetarBomba.isFocusOwner() == true)
        	{
        		configuracaoDefault.requestFocus();
        	}
        	else if(textfieldTempoBombaExplodir.isFocusOwner() == true)
        	{
        		textfieldTempoSetarBomba.requestFocus();
        	}
        	else if(salvarAlteracoes.isFocusOwner() == true)
        	{
        		textfieldTempoBombaExplodir.requestFocus();
        	}
        	else if(configuracaoDefault.isFocusOwner() == true)
        	{
        		salvarAlteracoes.requestFocus();
        	}
        }
        else if(key == KeyEvent.VK_ENTER)
        {
        	if(this.salvarAlteracoes.isFocusOwner() == true)
        	{
        		this.salvarAlteracoes();
        	}
        	else if(this.configuracaoDefault.isFocusOwner() == true)
        	{
        		this.voltarAConfiguracaoDefault();
        	}
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
	

}
