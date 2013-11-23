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

public class InterfaceJuntarListas implements ActionListener, KeyListener
{
	private JFrame telaJuntarListas;
	private JTextField textFieldLista1;
	private JTextField textFieldLista2;
	private JButton juntarListas;
	
	public InterfaceJuntarListas()
	{
		telaJuntarListas = new JFrame("juntar listas de palavras");
		telaJuntarListas.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		telaJuntarListas.setTitle("juntar duas listas");
	}
	
	public void criarInterfaceJuntarListas()
	{
		JPanel uneTudo = new JPanel();
		uneTudo.setBackground(new Color(112, 146, 190));
		GridBagLayout layout = new GridBagLayout();
		uneTudo.setLayout(layout);
		GridBagConstraints grid = new GridBagConstraints();
		
		
		//criar titulo
		JLabel titulo = new JLabel("Juntar listas");
		titulo.setFont(new Font("Serif", Font.BOLD, 20));
		titulo.setForeground(new Color(255, 201, 14));
		JPanel painelTitulo = new JPanel();
		painelTitulo.add(titulo);
		painelTitulo.setBackground(new Color(112, 146, 190));
		painelTitulo.add(titulo);
		
		grid.gridx = 0;
		grid.gridy = 0;
		grid.gridheight = 1;
		uneTudo.add(painelTitulo, grid);
		
		
		//criar a label e o textfield lista1
		textFieldLista1 = new JTextField("", 25);
		textFieldLista1.addKeyListener(this);
		JLabel labelLista1 = new JLabel("Lista1:");
		labelLista1.setFont(new Font("Serif", Font.BOLD, 20));
		labelLista1.setForeground(new Color(255, 201, 14));
		JPanel uneLista1ETextField = new JPanel();
		uneLista1ETextField.setBackground(new Color(112, 146, 190));
		uneLista1ETextField.add(labelLista1);
		uneLista1ETextField.add(textFieldLista1);
		
		grid.gridx = 0;
		grid.gridy = 1;
		grid.gridheight = 1;
		uneTudo.add(uneLista1ETextField, grid);
		
		
		//criar a label e o textfield lista2
		textFieldLista2 = new JTextField("", 25);
		textFieldLista2.addKeyListener(this);
		JLabel labelLista2 = new JLabel("Lista2:");
		labelLista2.setFont(new Font("Serif", Font.BOLD, 20));
		labelLista2.setForeground(new Color(255, 201, 14));
		JPanel uneLista2ETextField = new JPanel();
		uneLista2ETextField.setBackground(new Color(112, 146, 190));
		uneLista2ETextField.add(labelLista2);
		uneLista2ETextField.add(textFieldLista2);
		
		grid.gridx = 0;
		grid.gridy = 2;
		grid.gridheight = 1;
		uneTudo.add(uneLista2ETextField, grid);
		
		
		//agora o bot√£o para juntar listas
		juntarListas = new JButton("juntar listas");
		juntarListas.addKeyListener(this);
		juntarListas.addActionListener(this);
		grid.gridx = 0;
		grid.gridy = 3;
		grid.gridheight = 1;
		uneTudo.add(juntarListas, grid);
		
		//agora uma breve informacao sobre qual lista junta com qual
		JLabel informacao = new JLabel("obs: ao juntar as listas, a lista1 ter· suas palavras antigas + as palavras da lista2");
		informacao.setFont(new Font("Serif", Font.BOLD, 20));
		informacao.setForeground(new Color(255, 201, 14));
		JPanel painelInformacao = new JPanel();
		painelInformacao.setBackground(new Color(112, 146, 190));
		painelInformacao.add(informacao);
		
		grid.gridx = 0;
		grid.gridy = 4;
		grid.gridheight = 1;
		uneTudo.add(painelInformacao, grid);
		
		
		telaJuntarListas.add(uneTudo);
		telaJuntarListas.pack();
		telaJuntarListas.setVisible(true);
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		if(arg0.getSource() == juntarListas)
		{
			this.juntarListas();
		}
		
	}
	
	public void juntarListas()
	{
		String lista1 = textFieldLista1.getText();
		String lista2 = textFieldLista2.getText();
		
		if(lista1.compareTo("") == 0 || lista2.compareTo("") == 0)
		{
			JOptionPane.showMessageDialog(null, "informe duas listas");
		}
		else if(FachadaDAO.getFachadaDAO().listaDePalavrasJahExiste(lista1) == false)
		{
			JOptionPane.showMessageDialog(null, "a lista1 n„o existe");
		}
		else if(FachadaDAO.getFachadaDAO().listaDePalavrasJahExiste(lista2) == false)
		{
			JOptionPane.showMessageDialog(null, "a lista2 n„o existe");
		}
		else
		{
			JuntaListasDePalavras juntaListas = new JuntaListasDePalavras();
			juntaListas.juntarListas(lista1, lista2);
			JOptionPane.showMessageDialog(null, "as listas foram juntadas");
		}
	}
	
	
	

	@Override
	public void keyPressed(KeyEvent e) 
	{
		int key = e.getKeyCode();
        if(key == 40)
        {
        	//se o usuario apertar a tecla da seta para baixo no teclado
        	if(textFieldLista1.isFocusOwner() == true)
        	{
        		this.textFieldLista2.requestFocus();
        	}
        	else if(textFieldLista2.isFocusOwner() == true)
        	{
        		this.juntarListas.requestFocus();
        	}
        	else if(juntarListas.isFocusOwner() == true)
        	{
        		this.textFieldLista1.requestFocus();
        	}
        }
        else if(key == 38)
        {
        	//se o usuario apertar a tecla da seta para cima no teclado
        	if(textFieldLista1.isFocusOwner() == true)
        	{
        		this.juntarListas.requestFocus();
        	}
        	else if(textFieldLista2.isFocusOwner() == true)
        	{
        		this.textFieldLista1.requestFocus();
        	}
        	else if(juntarListas.isFocusOwner() == true)
        	{
        		this.textFieldLista2.requestFocus();
        	}
        }
        else if(key == KeyEvent.VK_ENTER)
        {
        	if(this.juntarListas.isFocusOwner() == true)
        	{
        		this.juntarListas();
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
}
