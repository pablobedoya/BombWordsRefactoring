package jogo;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class SetarLimiteMaximoTextField extends PlainDocument
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int maxChars;

	 @Override
	  public void insertString(int offs, String str, AttributeSet a) throws BadLocationException 
      {
		 if(str != null && (getLength() + str.length() < maxChars))
		 {
	           super.insertString(offs, str, a);
		 }
      }
	 
	 public int getMaxChars()
	 {
		 return maxChars;
	 }
	 
	 public void setMaxChars(int newValue)
	 {
		 maxChars = newValue;
	 }
}
