package test;

import java.util.LinkedList;

import main.java.jogo.Jogador;
import main.java.jogo.UInterfaceBomba;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * The class <code>JogadorTest</code> contains tests for the class <code>{@link Jogador}</code>.
 *
 * @generatedBy CodePro at 04/12/13 11:55
 * @author Josiel
 * @version $Revision: 1.0 $
 */
public class TestJogador {
	
	@Before
	public void setUp() throws Exception {
	
	}

	@After
	public void tearDown() throws Exception {
		
	}
	
	@Test
	public void testJogador(){
		String nom = "josiel";
		Jogador jogador = new Jogador(nom);
		assertNotNull(jogador);
		assertEquals("josiel", jogador.getNome());
		assertEquals(0, jogador.getPlacar());
		assertEquals(5, jogador.getPontosVida());
	}


	@Test
	public void testDecrementarPlacar() {
		Jogador jogador = new Jogador("pablo");
		int menos = 10;
		jogador.decrementarPlacar(menos);
	}

	
/*	@Test
	public void testDecrementarPontosVida() {
		
		Jogador jogador = new Jogador("josiel");
		jogador.decrementarPontosVida();
	}
*/

	@Test
	public void testGetNome() {
		
		Jogador jogador = new Jogador("josiel");
		String nomeJogadoe = jogador.getNome();
		assertEquals("josiel", nomeJogadoe);
	}


	@Test
	public void testGetPlacar () {
		Jogador fixture = new Jogador("josiel");
		int result = fixture.getPlacar();
		assertEquals(0, result);
	}

	@Test
	public void testGetPontosVida() {
		Jogador fixture = new Jogador("josiel");
		int result = fixture.getPontosVida();

		assertEquals(5, result);
	}

	/*			
	@Test
	public void testIncrementarPlacar() {
		Jogador fixture = new Jogador("josiel");
		int mais = 1;
		fixture.incrementarPlacar(mais);
	}

	
	@Test
	public void testJogar() {
		Jogador jogador = new Jogador("josiel");
		LinkedList<UInterfaceBomba> bombasQueOJogadorExplodiu = new LinkedList<UInterfaceBomba>();
		jogador.jogar(bombasQueOJogadorExplodiu);
	}

	*/
	@Test
	public void testSetNome() {
		Jogador fixture = new Jogador("josiel");
		String novo = "carlos";
		fixture.setNome(novo);
	}

	
	@Test
	public void testVerRanking() {
		Jogador jogador = new Jogador("ezequely");
		LinkedList<UInterfaceBomba> bombasQueOJogadorExplodiu = new LinkedList();
		jogador.verRanking(bombasQueOJogadorExplodiu);
	}
}