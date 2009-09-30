package org.emftext.language.uml_class.resource.uml_class;

// A common interface for token styles. Text resources must
// return style information using object implementing this
// interface.
public interface IUml_classTokenStyle {
	
	// Returns the color of the token as array of length 3.
	public int[] getColorAsRGB();
	
	// Returns true if the token must be displayed in bold face.
	public boolean isBold();
	
	// Returns true if the token must be displayed in italic face.
	public boolean isItalic();
	
	// Returns true if the token must be displayed in strike through style.
	public boolean isStrikethrough();
	
	// Returns true if the token must be displayed underline.
	public boolean isUnderline();
}
