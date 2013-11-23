package jogo;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import fachadaparadao.FachadaDAO;

public class InterfaceEditarListasJogo implements ActionListener
{
	private JFrame janelaEditaListas;
	private JButton criarNovaLista;
	private JButton removerLista;
	private JButton limparLista;
	private JButton editarPalavrasDasListas;
	private JComboBox comboBoxListasDoJogo;
	
	public InterfaceEditarListasJogo()
	{
		
	}
	
	public void criarInterfaceEditarListasJogo()
	{
		janelaEditaListas = new JFrame("Editar listas de palavras do jogo");
		janelaEditaListas.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel painelUneTudo = new JPanel();
		painelUneTudo.setBackground(new Color(112, 146, 190));
		GridBagLayout layout = new GridBagLayout();
		painelUneTudo.setLayout(layout);
		
		JLabel labelLista = new JLabel("Lista:");
		labelLista.setFont(new Font("Serif", Font.BOLD, 20));
		labelLista.setForeground(new Color(255, 201, 14));
		JPanel uneListaAssociadaEComboBox = new JPanel();
		uneListaAssociadaEComboBox.setBackground(new Color(112, 146, 190));
		uneListaAssociadaEComboBox.add(labelLista);
		
		
		
		String [] nomesDasListas = FachadaDAO.getFachadaDAO().extrairNomesDeTodasAsListasDePalavras();
		comboBoxListasDoJogo = new JComboBox(nomesDasListas);
		comboBoxListasDoJogo.addActionListener(this);
		uneListaAssociadaEComboBox.add(comboBoxListasDoJogo);
		
		
		GridBagConstraints grid = new GridBagConstraints();
		grid.gridx = 0;
		grid.gridy = 0;
		grid.gridheight = 1;
		painelUneTudo.add(uneListaAssociadaEComboBox, grid);
		
		
		//criar botao criarLista
		criarNovaLista = new JButton("criar nova lista de palavras");
		criarNovaLista.addActionListener(this);
		grid.gridx = 0;
		grid.gridy = 1;
		grid.gridheight = 1;
		grid.insets = new Insets(20,0,0,0);//espaco entre botoes
		
		painelUneTudo.add(criarNovaLista, grid);
		
		//criar botao removerLista
		removerLista = new JButton("remover lista de palavras selecionada");
		removerLista.addActionListener(this);
		grid.gridx = 0;
		grid.gridy = 2;
		grid.gridheight = 1;
		grid.insets = new Insets(20,0,0,0);//espaco entre botoes
		painelUneTudo.add(removerLista, grid);
		
		
		//criar botao editarPalavras
		editarPalavrasDasListas = new JButton("adicionar/remover palavras em listas já criadas");
		editarPalavrasDasListas.addActionListener(this);
		editarPalavrasDasListas.setForeground(new Color(202, 0, 0));
		grid.gridx = 0;
		grid.gridy = 3;
		grid.gridheight = 1;
		grid.insets = new Insets(20,0,0,0);//espaco entre botoes
		painelUneTudo.add(editarPalavrasDasListas, grid);
		
		
		//criar botao limparLista
		limparLista = new JButton("limpar lista de palavras selecionada");
		limparLista.addActionListener(this);
		grid.gridx = 0;
		grid.gridy = 4;
		grid.gridheight = 1;
		grid.insets = new Insets(40,0,0,0);//espaco entre botoes
		painelUneTudo.add(limparLista, grid);
		
		janelaEditaListas.add(painelUneTudo);
		janelaEditaListas.pack();
		janelaEditaListas.setVisible(true);
		
	}
	
	
	
	public boolean criarNovaListaPalavras(String nomeLista)
	{
		return FachadaDAO.getFachadaDAO().criarNovaListaPalavras(nomeLista);
	}
	
	public boolean removerListaPalavras(String nomeLista)
	{
		return FachadaDAO.getFachadaDAO().removerListaPalavras(nomeLista);
	}
	
	public void limparListaPalavras(String nomeLista)
	{
		Object[] options = {"Limpar",
        "Não Limpar"};
		int escolha = JOptionPane.showOptionDialog(null,
				"Limpar a lista vai apagar todas as palavras inclusas na lista. Tem certeza?",
				"Limpar lista",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,     //nao usa icone
				options,  //titulos dos botoes
				options[0]); //default button title
		if(escolha == JOptionPane.YES_OPTION)
		{
			boolean limpouLista = FachadaDAO.getFachadaDAO().limparListaPalavras(nomeLista);
			if(limpouLista == true)
			{
				JOptionPane.showMessageDialog(null, "lista limpa:" + nomeLista);
			}
			else
			{
				
				JOptionPane.showMessageDialog(null, "não foi possível limpar essa lista:" + nomeLista);
			}
		}
		
	}
	
	
	
	
	
	public void adicionarNovaListaNaComboBox(String novaLista)
	{
		String[] palavrasDaNovaComboBox = new String[comboBoxListasDoJogo.getItemCount() + 1];
		//esse arranjo contem as palavras atuais da combo box e terah  novaLista tambem 
		for(int i = 0; i < comboBoxListasDoJogo.getItemCount(); i++)
		{
			palavrasDaNovaComboBox[i] = (String) comboBoxListasDoJogo.getItemAt(i);
		}
		palavrasDaNovaComboBox[comboBoxListasDoJogo.getItemCount()] = novaLista;
		
		String[] palavrasOrdenadasDaNovaComboBox = ordenarPalavrasLista(palavrasDaNovaComboBox);
		comboBoxListasDoJogo.removeAllItems();
		
		for(int j = 0; j < palavrasOrdenadasDaNovaComboBox.length; j++)
		{
			comboBoxListasDoJogo.addItem(palavrasOrdenadasDaNovaComboBox[j]);
		}
	}
	
	public void removerListaDaComboBox(String lista)
	{
		String[] palavrasDaNovaComboBox = new String[comboBoxListasDoJogo.getItemCount() - 1];
		//esse arranjo contem as palavras atuais da combo box e nÃ£o terÃ¡ o nome em lista 
		int percorredorPalavrasDanovaComboBox = 0;
		
		for(int i = 0; i < comboBoxListasDoJogo.getItemCount(); i++)
		{
			String itemCombo = (String) comboBoxListasDoJogo.getItemAt(i);
			if(itemCombo.compareTo(lista) != 0)
			{
				palavrasDaNovaComboBox[percorredorPalavrasDanovaComboBox] =
						(String) comboBoxListasDoJogo.getItemAt(i);
				percorredorPalavrasDanovaComboBox = percorredorPalavrasDanovaComboBox + 1;
			}
		}
		
		String[] palavrasOrdenadasDaNovaComboBox = ordenarPalavrasLista(palavrasDaNovaComboBox);
		comboBoxListasDoJogo.removeAllItems();
		
		for(int j = 0; j < palavrasOrdenadasDaNovaComboBox.length; j++)
		{
			comboBoxListasDoJogo.addItem(palavrasOrdenadasDaNovaComboBox[j]);
		}
		
	}
	
	public String [] ordenarPalavrasLista(String [] palavras)
	{
		int percorredor = 0;
		String auxiliarTroca;//auxiliar para trocas na ordenacÃ£o das palavras.
		while(percorredor < palavras.length)
		{
			for(int i = percorredor + 1; i < palavras.length; i++)
			{
				//if abaixo compara duas palavras do arranjo pra ver se a da esquerda 
				//vem antes da palavra na direita
				if(palavras[i].compareTo(palavras[percorredor]) < 0)
				{
					auxiliarTroca = palavras[i];
					palavras[i] = palavras[percorredor];
					palavras[percorredor] = auxiliarTroca;
				}
			}
			percorredor = percorredor + 1;
		}
		return palavras;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		
		if(arg0.getSource() == this.criarNovaLista)
		{
			String nomeNovaLista = 
					JOptionPane.showInputDialog("Qual o nome da nova lista? Não precisa de .txt", "listaQualquer");
			if(nomeNovaLista != null)
			{
				if(nomeNovaLista.compareTo("") != 0)
				{
					boolean criouNovaListaPalavras = criarNovaListaPalavras(nomeNovaLista);
					
					if(criouNovaListaPalavras == true)
					{
						adicionarNovaListaNaComboBox(nomeNovaLista + ".txt");
						JOptionPane.showMessageDialog(null, "lista criada com sucesso:" + nomeNovaLista);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "lamento, mas a lista não pode ser criada:" + nomeNovaLista);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "digite um nome para a lista");
				}
			}
		}
		else if(arg0.getSource() == this.removerLista)
		{
			String nomeListaASerRemovida = (String) this.comboBoxListasDoJogo.getSelectedItem();
    		
			if(nomeListaASerRemovida != null)
			{
				
				String[] tiraTxt = nomeListaASerRemovida.split(".txt"); //tirar a extensao ".txt do nome da lista"
				boolean removeuLista = removerListaPalavras(tiraTxt[0]);
				if(removeuLista == true)
				{
					JOptionPane.showMessageDialog(null, "lista removida com sucesso:" + tiraTxt[0]);
					removerListaDaComboBox(nomeListaASerRemovida);
				}
				else
				{
					if(tiraTxt[0].compareTo("palavras") == 0)
					{
						JOptionPane.showMessageDialog(null, "você não pode deletar esta lista: palavras");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "lamento, mas a lista não existe:" + tiraTxt[0]);
					}
				}
			}
		}
		
		else if(arg0.getSource() == this.limparLista)
		{
			String nomeListaASerLimpa = (String) this.comboBoxListasDoJogo.getSelectedItem();
    		
			if(nomeListaASerLimpa != null)
			{
				
				String[] tiraTxt = nomeListaASerLimpa.split(".txt"); //tirar a extensao ".txt do nome da lista"
				limparListaPalavras(tiraTxt[0]);
			}
		}
		else if(arg0.getSource() == this.editarPalavrasDasListas)
		{
			InterfaceListaPalavras mudarPalavrasDasListas = new InterfaceListaPalavras();
			mudarPalavrasDasListas.criarInterfaceListaPalavras();
		}
	}
	

	
}
