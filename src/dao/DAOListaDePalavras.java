package dao;

public interface DAOListaDePalavras
{
	public boolean criarNovaListaPalavras(String nomeLista);
	public boolean removerListaPalavras(String nomeLista);
	public boolean limparListaPalavras(String nomeLista);
	
	public String [] extrairNomesDeTodasAsListasDePalavras();
	public boolean listaDePalavrasJahExiste(String nomeLista);
	
	public boolean mudarListaASerUsadaNoJogo(String nomeLista);
	public String pegarNomeListaASerUsadaNoJogo();

}
