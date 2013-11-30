package test;

import static org.junit.Assert.*;
import main.java.dao.ConcreteDAORankingArquivos;

import org.junit.Test;

public class TestConcreteDAORankingArquivos {
	
	ConcreteDAORankingArquivos c = new ConcreteDAORankingArquivos();
	
	@Test
	public void testLerConfiguracoesJogo() {
		assertNotEquals(c.lerConfiguracoesJogo(), null);
	}
	
	@Test
	public void testLerRanking() {
		assertNotEquals(c.lerRanking(), null);
	}
	
}
