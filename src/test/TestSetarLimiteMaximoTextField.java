package test;

import static org.junit.Assert.*;

import java.util.Enumeration;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;

import main.java.jogo.SetarLimiteMaximoTextField;

import org.junit.Before;
import org.junit.Test;

public class TestSetarLimiteMaximoTextField {

	SetarLimiteMaximoTextField setar = new SetarLimiteMaximoTextField();
	AttributeSet a = null;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testInsertStringIntStringAttributeSet() throws Exception {
		setar.insertString(10, "Teste", a);
	}

	@Test
	public void testGetMaxChars() throws Exception {
		setar.insertString(10, "Teste", a);
		assertEquals(0, setar.getMaxChars());
	}

	@Test
	public void testSetMaxChars() throws Exception {
		setar.insertString(10, "Teste", a);
		setar.setMaxChars(20);
		assertEquals(20, setar.getMaxChars());
	}

}
