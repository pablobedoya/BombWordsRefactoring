package test;

import javax.swing.ImageIcon;

import main.java.jogo.CriadorImageIcon;

import org.junit.*;

import static org.junit.Assert.*;



public class TestCriadorImageIcon {


	@Before
	public void setUp() throws Exception {

	}


	@After
	public void tearDown() throws Exception {
		
	}
	
	
	@Test
	public void testCriarImageIcon() {
		String endereco = "";
		String descricao = "";

		ImageIcon image = CriadorImageIcon.criarImageIcon(endereco, descricao);
		
		assertNotNull(image);
		assertEquals("", image.toString());
		assertEquals(-1, image.getIconHeight());
		assertEquals(-1, image.getIconWidth());
		assertEquals("", image.getDescription());
		assertEquals(4, image.getImageLoadStatus());
		assertEquals(null, image.getImageObserver());
	}

	@Test
	public void testCriarImageIcon_2() {
		String endereco = "";
		String descricao = "";

		ImageIcon result = CriadorImageIcon.criarImageIcon(endereco, descricao);

		// add additional test code here
		assertNotNull(result);
		assertEquals("", result.toString());
		assertEquals(-1, result.getIconHeight());
		assertEquals(-1, result.getIconWidth());
		assertEquals("", result.getDescription());
		assertEquals(4, result.getImageLoadStatus());
		assertEquals(null, result.getImageObserver());
	}


}