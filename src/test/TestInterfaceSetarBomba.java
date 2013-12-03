package test;

import static org.junit.Assert.*;

import java.awt.AWTException;

import main.java.jogo.UInterfaceSetarBomba;

import org.junit.Before;
import org.junit.Test;

public class TestInterfaceSetarBomba {

	UInterfaceSetarBomba interfaceSetarBomba;
	@Before
	public void setUp() throws Exception {
		interfaceSetarBomba = new UInterfaceSetarBomba();
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
