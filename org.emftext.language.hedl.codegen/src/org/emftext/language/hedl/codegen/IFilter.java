package org.emftext.language.hedl.codegen;

import org.emftext.language.hedl.Property;

public interface IFilter {

	public boolean accept(Property p);
}
