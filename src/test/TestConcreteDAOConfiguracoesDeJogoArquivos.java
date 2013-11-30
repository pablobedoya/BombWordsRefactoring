package test;

import static org.junit.Assert.*;
import main.java.dao.ConcreteDAOConfiguracoesDeJogoArquivos;

import org.junit.Test;

public class TestConcreteDAOConfiguracoesDeJogoArquivos {

	
	ConcreteDAOConfiguracoesDeJogoArquivos c = new ConcreteDAOConfiguracoesDeJogoArquivos();
	
	@Test
	public void testLerConfiguracoesJogo() {
		assertNotEquals(c.lerConfiguracoesJogo(), null);
	}
	
}
