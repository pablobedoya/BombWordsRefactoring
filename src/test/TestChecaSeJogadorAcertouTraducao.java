package test;

import java.util.LinkedList;
import main.java.jogo.ChecaSeJogadorAcertouTraducao;
import main.java.jogo.UInterfaceBomba;
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
			UInterfaceBomba[] imagensBombs = new UInterfaceBomba[] {};

			ChecaSeJogadorAcertouTraducao resultado = new ChecaSeJogadorAcertouTraducao(imagensBombs);
			
			assertNotNull(resultado);
		}

		
		@Test
		public void testQuaisBombasDevemSerDesativadas () {
			ChecaSeJogadorAcertouTraducao fixture = new ChecaSeJogadorAcertouTraducao(new UInterfaceBomba[] {});
			String palpiteJogador = " ";

			LinkedList<UInterfaceBomba> resultado = fixture.quaisBombasDevemSerDesativadas(palpiteJogador);

			assertEquals(null, resultado);
		}
}
