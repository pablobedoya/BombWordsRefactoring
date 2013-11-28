package test;

import static org.junit.Assert.*;
import main.java.jogo.JuntaListasDePalavras;

import org.junit.Before;
import org.junit.Test;

public class TestJuntaListasDePalavras {

	private JuntaListasDePalavras junta;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testJuntarListas() {
		assertNull("Sucesso", junta);
	}

}
