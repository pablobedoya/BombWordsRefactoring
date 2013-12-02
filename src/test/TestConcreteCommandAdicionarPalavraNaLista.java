package test; 

import static org.junit.Assert.*;
import main.java.command.ConcreteCommandAdicionarPalavraNaLista;

import org.junit.Test;

public class TestConcreteCommandAdicionarPalavraNaLista {

	@Test
	public void testAdicionarPalavraNaLista()
		throws Exception {
		ConcreteCommandAdicionarPalavraNaLista fixture = new ConcreteCommandAdicionarPalavraNaLista("", "", "");

		boolean result = fixture.adicionarPalavraNaLista();

		assertTrue(result);
	}

	@Test(expected=NullPointerException.class)
	public void testDesfazerAdicionarPalavraNaLista()
		throws Exception {
		ConcreteCommandAdicionarPalavraNaLista fixture = new ConcreteCommandAdicionarPalavraNaLista("", "", "");

		fixture.desfazerAdicionarPalavraNaLista();
		
		assertNotNull(fixture);
	}

	@Test
	public void testGetPalavraAdicionar()
		throws Exception {
		ConcreteCommandAdicionarPalavraNaLista fixture = new ConcreteCommandAdicionarPalavraNaLista("", "", "");

		String result = fixture.getPalavraAdicionar();

		assertEquals("", result);
	}
	
}
