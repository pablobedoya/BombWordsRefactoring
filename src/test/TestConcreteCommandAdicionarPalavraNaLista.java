package test;

import static org.junit.Assert.*;
import main.java.command.ConcreteCommandAdicionarPalavraNaLista;

import org.junit.Before;
import org.junit.Test;

public class TestConcreteCommandAdicionarPalavraNaLista {

	private ConcreteCommandAdicionarPalavraNaLista fixture;

	@Before
	public void setUp() {
		fixture = new ConcreteCommandAdicionarPalavraNaLista("", "", "");
	}

	@Test(expected = Exception.class)
	public void testAdicionarPalavraNaLista() throws Exception {
		boolean result = fixture.adicionarPalavraNaLista();
		assertTrue(result);
	}

	@Test(expected = Exception.class)
	public void testDesfazerAdicionarPalavraNaLista() throws Exception {
		fixture.desfazerAdicionarPalavraNaLista();
		assertNotNull(fixture);
	}

	@Test
	public void testGetPalavraAdicionar() throws Exception {
		String result = fixture.getPalavraAdicionar();
		assertEquals("", result);
	}

}
