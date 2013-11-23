package command;

import fachadaparadao.FachadaDAO;

public class ConcreteCommandAdicionarPalavraNaLista implements CommandAdicionarPalavraNaLista
{
	private String palavraAdicionar;
	private String traducaoPalavraAdicionar;
	private String nomeDaListaAdicionarPalavra;
	
	public ConcreteCommandAdicionarPalavraNaLista(String palavraAdd, String traducaoAdd, String nomeLista)
	{
		this.palavraAdicionar = palavraAdd;
		this.traducaoPalavraAdicionar = traducaoAdd;
		this.nomeDaListaAdicionarPalavra = nomeLista;
	}
	
	public String getPalavraAdicionar()
	{
		return this.palavraAdicionar;
	}
	
	public boolean adicionarPalavraNaLista()
	{
		boolean conseguiuAdicionarPalavraNaLista;
		conseguiuAdicionarPalavraNaLista = 
				FachadaDAO.getFachadaDAO().adicionarNovaPalavraNaLista(nomeDaListaAdicionarPalavra, palavraAdicionar, traducaoPalavraAdicionar);
		
		return conseguiuAdicionarPalavraNaLista;
	}
	
	public void desfazerAdicionarPalavraNaLista()
	{
		FachadaDAO.getFachadaDAO().removerPalavraDaLista(nomeDaListaAdicionarPalavra, traducaoPalavraAdicionar);
	}
	
	

}
