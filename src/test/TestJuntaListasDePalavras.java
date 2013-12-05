package test;

import static org.junit.Assert.*;
import main.java.jogo.JuntaListasDePalavras;

import org.junit.Before;
import org.junit.Test;

public class TestJuntaListasDePalavras {

	private JuntaListasDePalavras junta;
	
	@Before
	public void setUp() throws Exception {
		junta = new JuntaListasDePalavras();
	}

	@Test
	public void testJuntarListas() {
		junta.juntarListas("avancado", "basico");
		assertNotNull("Sucesso", junta);
	}

}
