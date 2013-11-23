package fachadaparadao;

import jogo.PalavrasETraducoes;
import dao.ConcreteDAOConfiguracoesDeJogoArquivos;
import dao.ConcreteDAOListaDePalavrasArquivos;
import dao.ConcreteDAOPalavrasDeListaArquivos;
import dao.ConcreteDAORankingArquivos;
import dao.DAOConfiguracoesDeJogo;
import dao.DAOListaDePalavras;
import dao.DAOPalavrasDeLista;
import dao.DAORanking;

public class FachadaDAO 
{
	private static FachadaDAO singletonFachadaDAO;
	private DAOConfiguracoesDeJogo acessaConfiguracoesJogo;
	private DAOListaDePalavras acessaListasDePalavras;
	private DAOPalavrasDeLista acessaPalavrasDeLista;
	private DAORanking acessaRanking;
	
	
	private FachadaDAO()
	{
		this.acessaConfiguracoesJogo = new ConcreteDAOConfiguracoesDeJogoArquivos();
		this.acessaListasDePalavras = new ConcreteDAOListaDePalavrasArquivos();
		this.acessaPalavrasDeLista = new ConcreteDAOPalavrasDeListaArquivos();
		this.acessaRanking = new ConcreteDAORankingArquivos();
	}
	
	public synchronized static FachadaDAO getFachadaDAO()
	{
		if(singletonFachadaDAO == null)

		{
			singletonFachadaDAO = new FachadaDAO();
		}
		
		return singletonFachadaDAO;
	}
	
	public String [] lerConfiguracoesJogo()
	{
		return this.acessaConfiguracoesJogo.lerConfiguracoesJogo();
	}
	
	public void setarNovasConfiguracoesJogo(int tempoParaSetarBomba, int tempoParaBombaExplodir)
	{
		this.acessaConfiguracoesJogo.setarNovasConfiguracoesJogo(tempoParaSetarBomba, tempoParaBombaExplodir);
	}
	
	public boolean criarNovaListaPalavras(String nomeLista)
	{
		return this.acessaListasDePalavras.criarNovaListaPalavras(nomeLista);
	}
	
	public boolean removerListaPalavras(String nomeLista)
	{
		return this.acessaListasDePalavras.removerListaPalavras(nomeLista);
	}
	
	public boolean limparListaPalavras(String nomeLista)
	{
		return this.acessaListasDePalavras.limparListaPalavras(nomeLista);
	}
	
	public String [] extrairNomesDeTodasAsListasDePalavras()
	{
		return this.acessaListasDePalavras.extrairNomesDeTodasAsListasDePalavras();
	}
	
	public boolean listaDePalavrasJahExiste(String nomeLista)
	{
		return this.acessaListasDePalavras.listaDePalavrasJahExiste(nomeLista);
	}
	
	public boolean mudarListaASerUsadaNoJogo(String nomeLista)
	{
		return this.acessaListasDePalavras.mudarListaASerUsadaNoJogo(nomeLista);
	}
	
	public String pegarNomeListaASerUsadaNoJogo()
	{
		return this.acessaListasDePalavras.pegarNomeListaASerUsadaNoJogo();
	}
	
	public PalavrasETraducoes extrairPalavrasETraducoes(String listaOndeEstaoOsDados)
	{
		return this.acessaPalavrasDeLista.extrairPalavrasETraducoes(listaOndeEstaoOsDados);
	}
	
	public boolean adicionarNovaPalavraNaLista(String nomeLista, String palavraNova, String traducaoNova)
	{
		return this.acessaPalavrasDeLista.adicionarNovaPalavraNaLista(nomeLista, palavraNova, traducaoNova);
	}
	
	public void removerPalavraDaLista(String nomeDalista, String traducaoDaPalavraASerRemovida)
	{
		this.acessaPalavrasDeLista.removerPalavraDaLista(nomeDalista, traducaoDaPalavraASerRemovida);
	}
	
	public void inserirJogadorRanking(String nomeJogador, int pontuacao)
	{
		this.acessaRanking.inserirJogadorRanking(nomeJogador, pontuacao);
	}
	
	public String[] lerRanking()
	{
		return this.acessaRanking.lerRanking();
	}

	
	
	

}
