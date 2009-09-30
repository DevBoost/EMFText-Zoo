package org.emftext.language.uml_class.resource.uml_class;

// An element that is expected at a given position in a resource
// stream.
public interface IUml_classExpectedElement {
	
	public void setPosition(int startIncludingHiddenTokens, int startExcludingHiddenTokens);
	public int getStartExcludingHiddenTokens();
	public int getStartIncludingHiddenTokens();
	public String getPrefix();
	public void setPrefix(String prefix);
	public String getScopeID();
	public boolean discardFollowingExpectations();
}
