package jogo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;
import java.util.NoSuchElementException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import command.CommandRemoverPalavrasDaLista;
import command.ConcreteCommandRemoverPalavrasDaLista;

import fachadaparadao.FachadaDAO;

public class InterfaceListaPalavras implements ActionListener, KeyListener, MouseListener
{
	private JLabel listaAtual;
	private JLabel listaUsadaNoJogo;
	private JFrame janelaLista;
	private JButton botaoAtualizar;
	private JButton botaoUsarListaNoJogo;
	private JButton botaojuntarListas;
	private JButton botaoRemoverPalavrasSelecionadas;
	private JButton botaoInserirPalavrasNaLista;
	private JButton botaoDesfazerRemocaoPalavrasDaLista;
	private JScrollPane scrollPainelPalavras;
	private JComboBox caixaSelecionarListas;//caixa para selecionar listas.
	private LinkedList<JLabel> labelsPalavrasLista;//conjunto de labels com palavras da lista visualizada.
	private LinkedList<Boolean> palavrasEstaoSelecionadasNaLista;/*cada booleano dessa lista corresponde a uma palavra da lista visualizada. 
																	O booleano indica se a palavra foi selecionada pelo usuario.*/
	private LinkedList<CommandRemoverPalavrasDaLista> comandosRemoverPalavrasDaLista;//para possibilitar refazer
	
	public InterfaceListaPalavras()
	{
		janelaLista = new JFrame();
		janelaLista.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janelaLista.setTitle("listagem de palavras e traduções");
		
		comandosRemoverPalavrasDaLista = new LinkedList<CommandRemoverPalavrasDaLista>();
		
	}
	
	public int ehLabelDaListaDePalavras(Object obj)/*ve se o obj faz parte da lista 
													labelsPalavrasLista. Retorna -1 se nÃ£o achar e o indice dele na lista
													caso ache*/ 
	{
		for(int i = 0; i < labelsPalavrasLista.size(); i++)
		{
			if(labelsPalavrasLista.get(i) == obj)
			{
				return i;
			}
		}
		return -1;
	}
	
	
	
	public JScrollPane criarScrollPaneListagemPalavras()
	{
		String listaAtual = this.listaAtual.getText();
		JPanel painelPalavras = this.criarPainelListagemPalavras(listaAtual);
		
		scrollPainelPalavras = new JScrollPane(painelPalavras);
		Dimension d = new Dimension(400, 400);
		scrollPainelPalavras.setPreferredSize(d);
		return scrollPainelPalavras;
	}
	
	public JPanel criarPainelListagemPalavras(String nomeListaAtual)
	{
		labelsPalavrasLista = new LinkedList<JLabel>();
		palavrasEstaoSelecionadasNaLista = new LinkedList<Boolean>();
		PalavrasETraducoes palavrasDaLista = FachadaDAO.getFachadaDAO().extrairPalavrasETraducoes(nomeListaAtual);
		for(int i = 0; i < palavrasDaLista.getNumPalavrasNoJogo(); i++)
		{
			JLabel labelPalavra = new JLabel();
			labelPalavra.setFont(new Font("Serif", Font.BOLD, 20));
			labelPalavra.setText(palavrasDaLista.getPalavra(i) + ";" + palavrasDaLista.getTraducao(i));
			labelPalavra.setBackground(new Color(112, 146, 190));
			labelPalavra.setForeground(new Color(139,242,248));
			labelPalavra.addMouseListener(this);
			labelsPalavrasLista.add(labelPalavra);
			palavrasEstaoSelecionadasNaLista.add(false);
		}
		//criar um painel que abriga todas as labels de palavras
		int numeroLabelsPalavras = labelsPalavrasLista.size();
		JPanel painelPalavras = new JPanel(new GridLayout(numeroLabelsPalavras, 1));
		
		
		for(int j = 0; j < numeroLabelsPalavras; j++)
		{
			painelPalavras.add(labelsPalavrasLista.get(j));
		}
		painelPalavras.setBackground(new Color(112, 146, 190));
		
		return painelPalavras;
	}
	
	
	
	
	
	public void mostrarOutraListaPalavras(String outraLista)
	{
		//this.scrollPainelPalavras.removeAll();
		
		//vamos mudar o titulo primeiro
		String [] outraListaDividido = outraLista.split(".txt");
		String nomeOutraLista = outraListaDividido[0];
		
		this.listaAtual.setText(nomeOutraLista);
		
		//agora, ler as palavras da proxima lista
		this.mostrarPalavrasJogo(nomeOutraLista);
		janelaLista.pack();
	}
	
	
	public void mostrarPalavrasJogo(String nomeLista)
	{
		JPanel painelPalavras = this.criarPainelListagemPalavras(nomeLista);
		this.scrollPainelPalavras.setViewportView(painelPalavras);
	}
	
	public String [] pegarNomesListasPalavras()
	{
		return FachadaDAO.getFachadaDAO().extrairNomesDeTodasAsListasDePalavras();
	}
	
	
	
	//no mÃ©todo abaixo, a lista que estÃ¡ sendo visualizada serÃ¡ selecionada como a lista
	//para ser jogada no jogo
	public void jogarComListaVisualizada()
	{
		if(this.listaAtualEstahVazia() == true)
		{
			JOptionPane.showMessageDialog(null, "esta lista está vazia e portanto não pode ser usada no jogo");
		}
		else
		{
			String nomeListaAtual = this.listaAtual.getText();
			
				
			boolean mudouListaASerUsada = FachadaDAO.getFachadaDAO().mudarListaASerUsadaNoJogo(nomeListaAtual);
				
			if(mudouListaASerUsada == true)
			{
				//por fim, vamos mudar a label com a lista usada no jogo
				String novoTextoLabel = "lista usada no jogo: " + nomeListaAtual;
				this.listaUsadaNoJogo.setText(novoTextoLabel);
				janelaLista.pack();
			}
		}
		
		
	}
	
	public boolean listaAtualEstahVazia()
	{
		String nomeListaAtual = this.listaAtual.getText();
		
		PalavrasETraducoes palavrasDaLista = FachadaDAO.getFachadaDAO().extrairPalavrasETraducoes(nomeListaAtual);
		if(palavrasDaLista.getNumPalavrasNoJogo() > 0)
		{
			return false;
		}
		else
		{
			return true;
		}
		
	}
	
	public void removerPalavrasSelecionadas()
	{
		LinkedList<String> palavrasRemover = new LinkedList<String>();
		LinkedList<String> traducoesPalavrasRemover = new LinkedList<String>();
		//vamos achar as palavras selecionadas
		for(int i = 0; i < this.palavrasEstaoSelecionadasNaLista.size(); i++)
		{
			boolean palavraEstahSelecionada = this.palavrasEstaoSelecionadasNaLista.get(i);
			if(palavraEstahSelecionada == true)
			{
				JLabel labelPalavraRemover = this.labelsPalavrasLista.get(i);
				String removerDaLista = labelPalavraRemover.getText();
				//essa string tem palavra e traducao, mas pra remover uma palavra soh precisamos da traducÃ£o.
				String [] removerDaListaDividido = removerDaLista.split(";");
				
				String palavraRemover = removerDaListaDividido[0];
				String traducaoDaPalavraRemover = removerDaListaDividido[1];
				
				palavrasRemover.add(palavraRemover);
				traducoesPalavrasRemover.add(traducaoDaPalavraRemover);
			
			}
		}
		
		//vamos agora criar um comando para remover as palavras inseridas na lista palavrasRemover.
		String nomeListaRemoverPalavras = this.listaAtual.getText();
		CommandRemoverPalavrasDaLista comandoRemoverPalavras = 
				new ConcreteCommandRemoverPalavrasDaLista(palavrasRemover, traducoesPalavrasRemover, nomeListaRemoverPalavras);
		this.comandosRemoverPalavrasDaLista.add(comandoRemoverPalavras);
		comandoRemoverPalavras.removerPalavrasDaLista();
		
		//por fim, vamos atualizar a lista
		String listaAtual = this.listaAtual.getText();
		this.mostrarPalavrasJogo(listaAtual);
	}
	
	public void desfazerRemocaodePalavras()
	{
		try
		{
			CommandRemoverPalavrasDaLista comandoRemoverPalavra = this.comandosRemoverPalavrasDaLista.removeLast();
			comandoRemoverPalavra.desfazerRemocaoPalavrasDaLista();
			//por fim, vamos atualizar a lista
			String listaAtual = this.listaAtual.getText();
			this.mostrarPalavrasJogo(listaAtual);
		}
		catch(NoSuchElementException exc)
		{
			JOptionPane.showMessageDialog(null, "nenhuma palavra já foi removida da lista");
		}
	}
	
	public void criarInterfaceListaPalavras()
	{
		JLabel legendaListaAtual = new JLabel("Lista:");//só para o usuario ter nocÃ£o do que Ã© a label lista atual
		legendaListaAtual.setBackground(new Color(112, 146, 190));
		legendaListaAtual.setForeground(Color.WHITE);
		legendaListaAtual.setFont(new Font("Serif", Font.BOLD, 20));
		
		this.listaAtual = new JLabel("palavras");
		listaAtual.setBackground(new Color(112, 146, 190));
		listaAtual.setForeground(Color.ORANGE);
		listaAtual.setFont(new Font("Serif", Font.BOLD, 20));
		this.listaUsadaNoJogo = new JLabel("lista usada no jogo:" + pegarNomeListaASerUsadaNoJogo());
		listaUsadaNoJogo.setBackground(new Color(112, 146, 190));
		listaUsadaNoJogo.setForeground(Color.WHITE);
		listaUsadaNoJogo.setFont(new Font("Serif", Font.BOLD, 20));
		
		//adicionar uma legenda
		JLabel labelLegenda = new JLabel();
		labelLegenda.setFont(new Font("Serif", Font.BOLD, 20));
		labelLegenda.setText("<html><font color='white'>Formato:</font><font color = #8bf2f8>Palavra;Tradução</font></html>");
		
		JPanel painelTitulo = new JPanel();
		GridBagLayout layoutTitulo = new GridBagLayout();
		painelTitulo.setLayout(layoutTitulo);
		
		GridBagConstraints c = new GridBagConstraints();
		c.gridwidth =  3;// tres colunas
		c.gridheight = 1;
		c.gridx = 0;
		c.gridy = 0;//linha
		c.anchor = GridBagConstraints.WEST;
		painelTitulo.add(listaUsadaNoJogo, c);
		
		c.gridwidth =  1;// uma coluna
		c.gridheight = 1;
		c.gridx = 0;
		c.gridy = 1;//linha
		//c.anchor = GridBagConstraints.CENTER;
		painelTitulo.add(legendaListaAtual, c);
		
		
		c.gridwidth =  2;// duas colunas
		c.gridheight = 1;
		c.gridx = 1;
		c.gridy = 1;//linha
		//c.anchor = GridBagConstraints.CENTER;
		painelTitulo.add(listaAtual, c);
		
		c.gridwidth =  3;// tres colunas
		c.gridheight = 1;
		c.gridx = 0;
		c.gridy = 2;//linha
		c.anchor = GridBagConstraints.WEST;
		painelTitulo.add(labelLegenda, c);
		
		
		
		
		painelTitulo.setBackground(new Color(112, 146, 190));
		
		JPanel painelBotoes = new JPanel(new GridLayout(7,1));
		//criar os botoes pra ver as listas
		botaoAtualizar = new JButton("atualizar lista");
		botaoAtualizar.addActionListener(this);
		botaoAtualizar.addKeyListener(this);
		
		botaoUsarListaNoJogo = new JButton("usar lista no jogo");
		botaoUsarListaNoJogo.addActionListener(this);
		botaoUsarListaNoJogo.addKeyListener(this);
		botaojuntarListas = new JButton("juntar listas");
		botaojuntarListas.addActionListener(this);
		botaojuntarListas.addKeyListener(this);
		
		botaoRemoverPalavrasSelecionadas = new JButton("remover palavras selecionadas");
		botaoRemoverPalavrasSelecionadas.addActionListener(this);
		botaoRemoverPalavrasSelecionadas.addKeyListener(this);
		botaoInserirPalavrasNaLista = new JButton("inserir palavras nessa lista");
		botaoInserirPalavrasNaLista.addActionListener(this);
		botaoInserirPalavrasNaLista.addKeyListener(this);
		
		botaoDesfazerRemocaoPalavrasDaLista = new JButton("desfazer remoção de palavras");
		botaoDesfazerRemocaoPalavrasDaLista.addActionListener(this);
		botaoDesfazerRemocaoPalavrasDaLista.addKeyListener(this);
		
		
		
		String [] listaNomeListas = this.pegarNomesListasPalavras();
		if(listaNomeListas == null)
		{
			System.out.println("lista com nomes das listas de palavras está vazia");
			listaNomeListas = new String[1];
			listaNomeListas[0] = "";
		}
		caixaSelecionarListas = new JComboBox(listaNomeListas);
		
		//vamos deixar como selecionada na combo box a lista "palavras.txt"(lista de palavras do jogo)
		for(int i = 0; i < caixaSelecionarListas.getItemCount(); i++)
		{
			caixaSelecionarListas.setSelectedIndex(i);
			String nomeItemComboBox = (String)caixaSelecionarListas.getSelectedItem();
			if(nomeItemComboBox.compareTo("palavras.txt") == 0)
			{
				break;
			}
		}
		
		caixaSelecionarListas.addActionListener(this);
		
		painelBotoes.add(caixaSelecionarListas);
		painelBotoes.add(botaoAtualizar);
		painelBotoes.add(botaoUsarListaNoJogo);
		painelBotoes.add(botaojuntarListas);
		painelBotoes.add(botaoRemoverPalavrasSelecionadas);
		painelBotoes.add(botaoInserirPalavrasNaLista);
		painelBotoes.add(botaoDesfazerRemocaoPalavrasDaLista);
		painelBotoes.setBackground(new Color(112, 146, 190));
		
		
		JScrollPane painelLista = this.criarScrollPaneListagemPalavras();
		
		JPanel painelTudo = new JPanel();
		GridBagLayout layoutListaEBotao = new GridBagLayout();
		painelTudo.setLayout(layoutListaEBotao);
		GridBagConstraints k = new GridBagConstraints();
		
		k.gridwidth =  5;// cinco colunas
		k.gridheight = 1;
		k.gridx = 0;
		k.gridy = 0;//linha
		k.anchor = GridBagConstraints.WEST;
		painelTudo.add(painelTitulo, k);
		
		k.gridwidth =  5;// cinco colunas
		k.gridheight = 5;
		k.gridx = 0;
		k.gridy = 1;//linha
		k.anchor = GridBagConstraints.CENTER;
		painelTudo.add(painelLista, k);
		k.gridwidth =  1;// uma coluna
		k.gridheight = 1;
		k.gridx = 6;
		k.gridy = 1;//linha
		k.anchor = GridBagConstraints.CENTER;
		painelTudo.add(painelBotoes, k);
		painelTudo.setBackground(new Color(112, 146, 190));
		
		janelaLista.add(painelTudo);
		janelaLista.pack();
		botaoAtualizar.requestFocusInWindow();
		janelaLista.setVisible(true);
		
	}
	
	public String pegarNomeListaASerUsadaNoJogo()
	{
		return FachadaDAO.getFachadaDAO().pegarNomeListaASerUsadaNoJogo();
	}
	
	public void criarInterfaceListaPalavrasTeste()//sï¿½ para testes
	{	this.listaAtual = new JLabel("palavras");
		JScrollPane painelPalavras = this.criarScrollPaneListagemPalavras();
		janelaLista.add(painelPalavras);
		janelaLista.pack();
		janelaLista.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		if(arg0.getSource() == this.botaoAtualizar)
		{
			
			String listaAtual = this.listaAtual.getText();
			this.mostrarPalavrasJogo(listaAtual);
		}
		else if(arg0.getSource() == this.botaoUsarListaNoJogo)
		{
			this.jogarComListaVisualizada();
		}
		else if(arg0.getSource() == this.botaojuntarListas)
		{
			InterfaceJuntarListas juntaListas = new InterfaceJuntarListas();
			juntaListas.criarInterfaceJuntarListas();
		}
		else if(arg0.getSource() == this.caixaSelecionarListas)
		{
			String outraLista = (String) caixaSelecionarListas.getSelectedItem();
			this.mostrarOutraListaPalavras(outraLista);
		}
		else if(arg0.getSource() == this.botaoRemoverPalavrasSelecionadas)
		{
			this.removerPalavrasSelecionadas();
		}
		else if(arg0.getSource() == this.botaoInserirPalavrasNaLista)
		{
			String nomeLista = this.listaAtual.getText() + ".txt";
			InterfaceAdicionarPalavrasEmUmaLista adiciona = new InterfaceAdicionarPalavrasEmUmaLista();
			adiciona.criarJanelaEditarLista(nomeLista, this);
		}
		else if(arg0.getSource() == this.botaoDesfazerRemocaoPalavrasDaLista)
		{
			this.desfazerRemocaodePalavras();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) 
	{
		int key = e.getKeyCode();
        if(key == 40)
        {
        	//se o usuï¿½rio apertar a tecla da seta para baixo no teclado
        	if(botaoAtualizar.isFocusOwner() == true)
        	{
        		this.botaoUsarListaNoJogo.requestFocus();
        	}
        	else if(botaoUsarListaNoJogo.isFocusOwner() == true)
        	{
        		this.botaojuntarListas.requestFocus();
        	}
        	else if(botaojuntarListas.isFocusOwner() == true)
        	{
        		this.botaoRemoverPalavrasSelecionadas.requestFocus();
        	}
        	else if(botaoRemoverPalavrasSelecionadas.isFocusOwner() == true)
        	{
        		this.botaoInserirPalavrasNaLista.requestFocus();
        	}
        	else if(botaoInserirPalavrasNaLista.isFocusOwner() == true)
        	{
        		this.botaoDesfazerRemocaoPalavrasDaLista.requestFocus();
        	}
        	else if(botaoDesfazerRemocaoPalavrasDaLista.isFocusOwner() == true)
        	{
        		this.botaoAtualizar.requestFocus();
        	}
        }
        else if(key == 38)
        {
        	//se o usuï¿½rio apertar a tecla da seta para cima no teclado
        	if(botaoAtualizar.isFocusOwner() == true)
        	{
        		this.botaoDesfazerRemocaoPalavrasDaLista.requestFocus();
        	}
        	else if(botaoUsarListaNoJogo.isFocusOwner() == true)
        	{
        		this.botaoAtualizar.requestFocus();
        	}
        	else if(botaojuntarListas.isFocusOwner() == true)
        	{
        		this.botaoUsarListaNoJogo.requestFocus();
        	}
        	else if(botaoRemoverPalavrasSelecionadas.isFocusOwner() == true)
        	{
        		this.botaojuntarListas.requestFocus();
        	}
        	else if(botaoInserirPalavrasNaLista.isFocusOwner() == true)
        	{
        		botaoRemoverPalavrasSelecionadas.requestFocus();
        	}
        	else if(botaoDesfazerRemocaoPalavrasDaLista.isFocusOwner() == true)
        	{
        		botaoInserirPalavrasNaLista.requestFocus();
        	}
        	
        	
        }
        else if(key == KeyEvent.VK_ENTER)
        {
        	if(botaoAtualizar.isFocusOwner() == true)
    		{
    			String listaAtual = this.listaAtual.getText();
    			this.mostrarPalavrasJogo(listaAtual);
    		}
    		
    		else if(botaoUsarListaNoJogo.isFocusOwner() == true)
    		{
    			this.jogarComListaVisualizada();
    		}
    		else if(botaojuntarListas.isFocusOwner() == true)
    		{
    			InterfaceJuntarListas juntaListas = new InterfaceJuntarListas();
    			juntaListas.criarInterfaceJuntarListas();
    		}
    		else if(botaoRemoverPalavrasSelecionadas.isFocusOwner() == true)
    		{
    			this.removerPalavrasSelecionadas();
    		}
    		else if(botaoInserirPalavrasNaLista.isFocusOwner() == true)
    		{
    			String nomeLista = this.listaAtual.getText() + ".txt";
    			InterfaceAdicionarPalavrasEmUmaLista adiciona = new InterfaceAdicionarPalavrasEmUmaLista();
    			adiciona.criarJanelaEditarLista(nomeLista, this);
    		}
    		else if(botaoDesfazerRemocaoPalavrasDaLista.isFocusOwner() == true)
    		{
    			this.desfazerRemocaodePalavras();
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

	@Override
	public void mouseClicked(MouseEvent e) 
	{
		Object objetoEvento = e.getSource();
		int indicePalavraSelecionada = this.ehLabelDaListaDePalavras(objetoEvento);
		if(indicePalavraSelecionada != -1)
		{
			JLabel labelPalavraSelecionada = this.labelsPalavrasLista.get(indicePalavraSelecionada); 
			boolean palavraEstavaSelecionada = palavrasEstaoSelecionadasNaLista.get(indicePalavraSelecionada);
			this.palavrasEstaoSelecionadasNaLista.set(indicePalavraSelecionada, !palavraEstavaSelecionada);
			boolean palavraEstahSelecionada = palavrasEstaoSelecionadasNaLista.get(indicePalavraSelecionada);
			if(palavraEstahSelecionada == true)
			{
				labelPalavraSelecionada.setForeground(Color.yellow);
			}
			else
			{
				labelPalavraSelecionada.setForeground(new Color(139,242,248));
			}
		}
		
	}



	@Override
	public void mouseEntered(MouseEvent e) 
	{
		Object objetoEvento = e.getSource();
		int indicePalavraSelecionada = this.ehLabelDaListaDePalavras(objetoEvento);
		if(indicePalavraSelecionada != -1)
		{
			JLabel labelPalavraSelecionada = this.labelsPalavrasLista.get(indicePalavraSelecionada); 
			
			boolean palavraEstahSelecionada = palavrasEstaoSelecionadasNaLista.get(indicePalavraSelecionada);
			if(palavraEstahSelecionada != true)
			{
				labelPalavraSelecionada.setForeground(Color.blue);
			}
		}
	}



	@Override
	public void mouseExited(MouseEvent e) 
	{
		Object objetoEvento = e.getSource();
		int indicePalavraSelecionada = this.ehLabelDaListaDePalavras(objetoEvento);
		if(indicePalavraSelecionada != -1)
		{
			JLabel labelPalavraSelecionada = this.labelsPalavrasLista.get(indicePalavraSelecionada); 
			
			boolean palavraEstahSelecionada = palavrasEstaoSelecionadasNaLista.get(indicePalavraSelecionada);
			if(palavraEstahSelecionada != true)
			{
				labelPalavraSelecionada.setForeground(new Color(139,242,248));
			}
		}
		
	}



	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
