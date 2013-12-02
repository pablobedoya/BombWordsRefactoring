package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.swing.JLabel;
import javax.swing.JPanel;

import main.java.jogo.InterfaceBomba;

import org.junit.Test;

public class TestInterfaceBomba {

	@Test
	public void testAtivarBomba()
		throws Exception {
		InterfaceBomba fixture = new InterfaceBomba("", "");
		fixture.setAtivada(true);
		int tempoParaBombaExplodir = 1;

		boolean result = fixture.ativarBomba(tempoParaBombaExplodir);

		assertEquals(true, result);
	}

	@Test
	public void testGetAtivada()
		throws Exception {
		InterfaceBomba fixture = new InterfaceBomba("", "");
		fixture.setAtivada(true);

		boolean result = fixture.getAtivada();

		assertEquals(true, result);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testGetLabelBomba()
		throws Exception {
		InterfaceBomba fixture = new InterfaceBomba("", "");
		fixture.setAtivada(true);

		JLabel result = fixture.getLabelBomba();

		assertNotNull(result);
		assertEquals(null, result.getText());
		assertEquals(null, result.getLabelFor());
		assertEquals("LabelUI", result.getUIClassID());
		assertEquals(0, result.getDisplayedMnemonic());
		assertEquals(-1, result.getDisplayedMnemonicIndex());
		assertEquals(0, result.getHorizontalAlignment());
		assertEquals(11, result.getHorizontalTextPosition());
		assertEquals(4, result.getIconTextGap());
		assertEquals(0, result.getVerticalAlignment());
		assertEquals(0, result.getVerticalTextPosition());
		assertEquals(false, result.isOpaque());
		assertEquals(null, result.getBorder());
		assertEquals(null, result.getToolTipText());
		assertEquals(0, result.getY());
		assertEquals(0, result.getX());
		assertEquals(0, result.getHeight());
		assertEquals(0, result.getWidth());
		assertEquals(null, result.getRootPane());
		assertEquals(null, result.getGraphics());
		assertEquals(0.0f, result.getAlignmentX(), 1.0f);
		assertEquals(0.5f, result.getAlignmentY(), 1.0f);
		assertEquals(false, result.isDoubleBuffered());
		assertEquals(false, result.isValidateRoot());
		assertEquals(false, result.requestFocusInWindow());
		assertEquals(false, result.getAutoscrolls());
		assertEquals(null, result.getComponentPopupMenu());
		assertEquals(0, result.getDebugGraphicsOptions());
		assertEquals(true, result.getInheritsPopupMenu());
		assertEquals(null, result.getInputVerifier());
		assertEquals(null, result.getNextFocusableComponent());
		assertEquals(null, result.getTopLevelAncestor());
		assertEquals(null, result.getTransferHandler());
		assertEquals(false, result.isManagingFocus());
		assertEquals(true, result.isOptimizedDrawingEnabled());
		assertEquals(false, result.isPaintingForPrint());
		assertEquals(false, result.isPaintingTile());
		assertEquals(true, result.isRequestFocusEnabled());
		assertEquals(false, result.requestDefaultFocus());
		assertEquals(true, result.getVerifyInputWhenFocusTarget());
		assertEquals(null, result.getLayout());
		assertEquals(0, result.countComponents());
		assertEquals(0, result.getComponentCount());
		assertEquals(null, result.getFocusTraversalPolicy());
		assertEquals(false, result.isFocusCycleRoot());
		assertEquals(false, result.isFocusTraversalPolicyProvider());
		assertEquals(false, result.isFocusTraversalPolicySet());
		assertEquals("javax.swing.JLabel[,0,0,0x0,invalid,alignmentX=0.0,alignmentY=0.0,border=,flags=8388608,maximumSize=,minimumSize=,preferredSize=,defaultIcon=uma bomba oculta,disabledIcon=,horizontalAlignment=CENTER,horizontalTextPosition=TRAILING,iconTextGap=4,labelFor=,text=,verticalAlignment=CENTER,verticalTextPosition=CENTER]", result.toString());
		assertEquals(false, result.isValid());
		assertEquals(null, result.getName());
		assertEquals(true, result.isVisible());
		assertEquals(false, result.hasFocus());
		assertEquals(false, result.isShowing());
		assertEquals(true, result.isEnabled());
		assertEquals(null, result.getPeer());
		assertEquals(true, result.isFocusable());
		assertEquals(true, result.isFontSet());
		assertEquals(false, result.isFocusOwner());
		assertEquals(false, result.isCursorSet());
		assertEquals(true, result.isBackgroundSet());
		assertEquals(true, result.isForegroundSet());
		assertEquals(null, result.getInputContext());
		assertEquals(null, result.getDropTarget());
		assertEquals(null, result.getFocusCycleRootAncestor());
		assertEquals(true, result.getFocusTraversalKeysEnabled());
		assertEquals(null, result.getGraphicsConfiguration());
		assertEquals(false, result.getIgnoreRepaint());
		assertEquals(null, result.getInputMethodRequests());
		assertEquals(null, result.getMousePosition());
		assertEquals(false, result.isDisplayable());
		assertEquals(true, result.isFocusTraversable());
		assertEquals(false, result.isLightweight());
		assertEquals(false, result.isMaximumSizeSet());
		assertEquals(false, result.isMinimumSizeSet());
		assertEquals(false, result.isPreferredSizeSet());
	}

	@Test
	public void testGetPalavra()
		throws Exception {
		InterfaceBomba fixture = new InterfaceBomba("", "");
		fixture.setAtivada(true);

		String result = fixture.getPalavra();

		assertEquals("", result);
	}

	@Test
	public void testGetTraducao()
		throws Exception {
		InterfaceBomba fixture = new InterfaceBomba("", "");
		fixture.setAtivada(true);

		String result = fixture.getTraducao();

		assertEquals("", result);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testGetUneBombaEPalavra()
		throws Exception {
		InterfaceBomba fixture = new InterfaceBomba("", "");
		fixture.setAtivada(true);

		JPanel result = fixture.getUneBombaEPalavra();

		assertNotNull(result);
		assertEquals("PanelUI", result.getUIClassID());
		assertEquals(true, result.isOpaque());
		assertEquals(null, result.getBorder());
		assertEquals(null, result.getToolTipText());
		assertEquals(0, result.getY());
		assertEquals(0, result.getX());
		assertEquals(0, result.getHeight());
		assertEquals(0, result.getWidth());
		assertEquals(null, result.getRootPane());
		assertEquals(null, result.getGraphics());
		assertEquals(0.5f, result.getAlignmentX(), 1.0f);
		assertEquals(0.5f, result.getAlignmentY(), 1.0f);
		assertEquals(true, result.isDoubleBuffered());
		assertEquals(false, result.isValidateRoot());
		assertEquals(false, result.requestFocusInWindow());
		assertEquals(false, result.getAutoscrolls());
		assertEquals(null, result.getComponentPopupMenu());
		assertEquals(0, result.getDebugGraphicsOptions());
		assertEquals(false, result.getInheritsPopupMenu());
		assertEquals(null, result.getInputVerifier());
		assertEquals(null, result.getNextFocusableComponent());
		assertEquals(null, result.getTopLevelAncestor());
		assertEquals(null, result.getTransferHandler());
		assertEquals(false, result.isManagingFocus());
		assertEquals(true, result.isOptimizedDrawingEnabled());
		assertEquals(false, result.isPaintingForPrint());
		assertEquals(false, result.isPaintingTile());
		assertEquals(true, result.isRequestFocusEnabled());
		assertEquals(false, result.requestDefaultFocus());
		assertEquals(true, result.getVerifyInputWhenFocusTarget());
		assertEquals(2, result.countComponents());
		assertEquals(2, result.getComponentCount());
		assertEquals(null, result.getFocusTraversalPolicy());
		assertEquals(false, result.isFocusCycleRoot());
		assertEquals(false, result.isFocusTraversalPolicyProvider());
		assertEquals(false, result.isFocusTraversalPolicySet());
		assertEquals("javax.swing.JPanel[,0,0,0x0,invalid,layout=java.awt.GridBagLayout,alignmentX=0.0,alignmentY=0.0,border=,flags=9,maximumSize=,minimumSize=,preferredSize=]", result.toString());
		assertEquals(null, result.getParent());
		assertEquals(false, result.isValid());
		assertEquals(null, result.getName());
		assertEquals(true, result.isVisible());
		assertEquals(false, result.hasFocus());
		assertEquals(false, result.isShowing());
		assertEquals(true, result.isEnabled());
		assertEquals(null, result.getPeer());
		assertEquals(true, result.isFocusable());
		assertEquals(true, result.isFontSet());
		assertEquals(false, result.isFocusOwner());
		assertEquals(false, result.isCursorSet());
		assertEquals(true, result.isBackgroundSet());
		assertEquals(true, result.isForegroundSet());
		assertEquals(null, result.getInputContext());
		assertEquals(null, result.getDropTarget());
		assertEquals(null, result.getFocusCycleRootAncestor());
		assertEquals(true, result.getFocusTraversalKeysEnabled());
		assertEquals(null, result.getGraphicsConfiguration());
		assertEquals(false, result.getIgnoreRepaint());
		assertEquals(null, result.getInputMethodRequests());
		assertEquals(null, result.getMousePosition());
		assertEquals(false, result.isDisplayable());
		assertEquals(true, result.isFocusTraversable());
		assertEquals(false, result.isLightweight());
		assertEquals(false, result.isMaximumSizeSet());
		assertEquals(false, result.isMinimumSizeSet());
		assertEquals(false, result.isPreferredSizeSet());
	}

	@Test
	public void testOcultarBomba()
		throws Exception {
		InterfaceBomba fixture = new InterfaceBomba("", "");
		fixture.setAtivada(true);

		fixture.ocultarBomba();

		assertNotNull(fixture);
	}

	@Test
	public void testSetAtivada()
		throws Exception {
		InterfaceBomba fixture = new InterfaceBomba("", "");
		fixture.setAtivada(true);
		boolean novo = true;

		fixture.setAtivada(novo);

		assertNotNull(fixture);
	}

	@Test
	public void testSetPalavra()
		throws Exception {
		InterfaceBomba fixture = new InterfaceBomba("", "");
		fixture.setAtivada(true);
		String nova = "";

		fixture.setPalavra(nova);

		assertNotNull(fixture);
	}

	@Test
	public void testSetTraducao()
		throws Exception {
		InterfaceBomba fixture = new InterfaceBomba("", "");
		fixture.setAtivada(true);
		String nova = "";

		fixture.setTraducao(nova);

		assertNotNull(fixture);
	}
	
}
