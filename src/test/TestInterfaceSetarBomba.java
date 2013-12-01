package test;

import static org.junit.Assert.*;

import java.awt.AWTException;

import main.java.jogo.InterfaceSetarBomba;

import org.junit.Before;
import org.junit.Test;

public class TestInterfaceSetarBomba {

	InterfaceSetarBomba interfaceSetarBomba;
	@Before
	public void setUp() throws Exception {
		interfaceSetarBomba = new InterfaceSetarBomba();
	}

	@Test
	public void testInterfaceSetarBomba() {
		interfaceSetarBomba.criarInterfaceSetarBomba();
	}

	@Test
	public void testGetTempoParaSetarBomba() {
		assertNotEquals(0, interfaceSetarBomba.getTempoParaSetarBomba());
	}

}
