package test;

import java.util.LinkedList;
import main.java.jogo.ChecaSeJogadorAcertouTraducao;
import main.java.jogo.InterfaceBomba;
import org.junit.*;
import static org.junit.Assert.*;

	
public class TestChecaSeJogadorAcertouTraducao {


	@Before
	public void setUp() throws Exception {
		
	}


	@After
	public void tearDown() throws Exception {
		
	}
	
	
		@Test
		public void testChecaSeJogadorAcertouTraducao() {
			InterfaceBomba[] imagensBombs = new InterfaceBomba[] {};

			ChecaSeJogadorAcertouTraducao resultado = new ChecaSeJogadorAcertouTraducao(imagensBombs);
			
			assertNotNull(resultado);
		}

		
		@Test
		public void testQuaisBombasDevemSerDesativadas () {
			ChecaSeJogadorAcertouTraducao fixture = new ChecaSeJogadorAcertouTraducao(new InterfaceBomba[] {});
			String palpiteJogador = " ";

			LinkedList<InterfaceBomba> resultado = fixture.quaisBombasDevemSerDesativadas(palpiteJogador);

			assertEquals(null, resultado);
		}
}
