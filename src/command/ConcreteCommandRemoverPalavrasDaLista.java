package command;

import java.util.LinkedList;

import fachadaparadao.FachadaDAO;

public class ConcreteCommandRemoverPalavrasDaLista implements CommandRemoverPalavrasDaLista
{
	private LinkedList<String> palavrasRemover;
	private LinkedList<String> traducoesDasPalavrasRemover;
	private String nomeDaListaRemoverPalavra;
	
	public ConcreteCommandRemoverPalavrasDaLista(LinkedList<String> palavrasRemover, LinkedList<String> traducoesDasPalavrasRemover, String nomeDaListaRemoverPalavras)
	{
		this.palavrasRemover = palavrasRemover;
		this.traducoesDasPalavrasRemover = traducoesDasPalavrasRemover; 
		this.nomeDaListaRemoverPalavra = nomeDaListaRemoverPalavras;
	}
	
	public void removerPalavrasDaLista()
	{
		for(int i = 0; i < palavrasRemover.size(); i++)
		{
			String traducaoPalavraRemover = this.traducoesDasPalavrasRemover.get(i);
			FachadaDAO.getFachadaDAO().removerPalavraDaLista(this.nomeDaListaRemoverPalavra, traducaoPalavraRemover);
		}
	}
	
	public void desfazerRemocaoPalavrasDaLista()
	{
		for(int i = 0; i < palavrasRemover.size(); i++)
		{
			String palavraInserirNovamente = this.palavrasRemover.get(i);
			String traducaoPalavraInserirNovamente = this.traducoesDasPalavrasRemover.get(i);
			
			FachadaDAO.getFachadaDAO().adicionarNovaPalavraNaLista(nomeDaListaRemoverPalavra, palavraInserirNovamente, traducaoPalavraInserirNovamente);
		}
	}

}
