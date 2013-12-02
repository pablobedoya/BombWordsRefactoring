package test; 

import static org.junit.Assert.assertEquals;
import main.java.command.ConcreteCommandAdicionarPalavraNaLista;

import org.junit.Test;

public class TestConcreteCommandAdicionarPalavraNaLista {

	@Test
	public void testAdicionarPalavraNaLista1()
		throws Exception {
		ConcreteCommandAdicionarPalavraNaLista fixture = new ConcreteCommandAdicionarPalavraNaLista("", "", "");

		boolean result = fixture.adicionarPalavraNaLista();

		assertEquals(false, result);
	}

	@Test(expected=NullPointerException.class)
	public void testDesfazerAdicionarPalavraNaLista()
		throws Exception {
		ConcreteCommandAdicionarPalavraNaLista fixture = new ConcreteCommandAdicionarPalavraNaLista("", "", "");

		fixture.desfazerAdicionarPalavraNaLista();
	}

	@Test
	public void testGetPalavraAdicionar()
		throws Exception {
		ConcreteCommandAdicionarPalavraNaLista fixture = new ConcreteCommandAdicionarPalavraNaLista("", "", "");

		String result = fixture.getPalavraAdicionar();

		assertEquals("", result);
	}
	
}
