package jogo;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class InterfaceBomba 
{
	private String palavra;
	private String traducao;
	private JLabel labelBomba;
	private JLabel labelPalavra;
	private JPanel uneBombaEPalavra;
	private boolean ativada;
	
	@SuppressWarnings("static-access")
	public InterfaceBomba(String palav, String tradu)
	{
		ativada = false;
		palavra = palav;
		traducao = tradu;
	    labelPalavra = new JLabel(palavra);
	    labelPalavra.setFont(new Font("Serif", Font.BOLD, 20));
	    labelPalavra.setForeground(new Color(255, 201, 14));
	    ImageIcon imagemBomba = CriadorImageIcon.criarImageIcon("imagens/bomba.png", "uma bomba");
		labelBomba = new JLabel(imagemBomba);
		
        uneBombaEPalavra = new JPanel();
		uneBombaEPalavra.setBackground(new Color(112, 146, 190));
		GridBagLayout layout = new GridBagLayout();
		uneBombaEPalavra .setLayout(layout);
		
		GridBagConstraints grid = new GridBagConstraints();

		uneBombaEPalavra.add(labelPalavra, grid);
		
		grid.gridy = grid.PAGE_END;
		uneBombaEPalavra.add(labelBomba, grid);
		
		this.ocultarBomba();
		
	}
	public JLabel getLabelBomba()
	{
		return this.labelBomba;
	}
	
	public synchronized void ocultarBomba()
	{
		ImageIcon bombaOculta = CriadorImageIcon.criarImageIcon("imagens/bombaOculta.png", "uma bomba oculta");
		this.labelBomba.setIcon(bombaOculta);
		this.labelPalavra.setText("");
	}
	
	public synchronized String getTraducao()
	{
		return traducao;
	}
	public synchronized void setTraducao(String nova)
	{
		this.traducao = nova;
	}
	
	
	public synchronized String getPalavra()
	{
		return palavra;
	}
	
	public synchronized void setPalavra(String nova)
	{
		this.palavra = nova;
	}
	
	public JPanel getUneBombaEPalavra()
	{
		return this.uneBombaEPalavra;
	}
	
	public synchronized boolean getAtivada()
	{
		return this.ativada;
	}
	
	public synchronized void setAtivada(boolean novo)
	{
		this.ativada = novo;
	}
	
	public synchronized boolean ativarBomba(int tempoParaBombaExplodir)
	{
		boolean bombaAtiva = this.getAtivada();
		if(bombaAtiva == false)
		{
			this.setAtivada(true);
			ImageIcon imagemBombaAtivada = CriadorImageIcon.criarImageIcon("imagens/bomba" + tempoParaBombaExplodir +".gif", "bomba ativada");
			this.labelBomba.setIcon(imagemBombaAtivada);
			this.labelPalavra.setText(getPalavra());
			labelPalavra.setForeground(new Color(255, 201, 14));
		}
		return bombaAtiva;
	}
	
	
	
}
