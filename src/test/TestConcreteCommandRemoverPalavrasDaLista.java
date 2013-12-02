package test; 

import static org.junit.Assert.*;

import java.util.LinkedList;

import main.java.command.ConcreteCommandRemoverPalavrasDaLista;

import org.junit.Test;

public class TestConcreteCommandRemoverPalavrasDaLista {

	@Test
	public void testDesfazerRemocaoPalavrasDaLista()
		throws Exception {
		ConcreteCommandRemoverPalavrasDaLista fixture = new ConcreteCommandRemoverPalavrasDaLista(new LinkedList(), new LinkedList(), "");

		fixture.desfazerRemocaoPalavrasDaLista();
		
		assertNotNull(fixture);
	}

	@Test
	public void testRemoverPalavrasDaLista()
		throws Exception {
		ConcreteCommandRemoverPalavrasDaLista fixture = new ConcreteCommandRemoverPalavrasDaLista(new LinkedList(), new LinkedList(), "");

		fixture.removerPalavrasDaLista();
		
		assertNotNull(fixture);
	}
	
}
