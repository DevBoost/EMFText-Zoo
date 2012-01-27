/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.prolog.resource.pl.debug;

public class PlDebugVariable extends org.emftext.language.prolog.resource.pl.debug.PlDebugElement implements org.eclipse.debug.core.model.IVariable {
	
	private String name;
	private org.eclipse.debug.core.model.IValue value;
	private String referenceTypeName;
	
	public PlDebugVariable(org.eclipse.debug.core.model.IDebugTarget debugTarget, String name, org.eclipse.debug.core.model.IValue value, String referenceTypeName) {
		super(debugTarget);
		this.name = name;
		this.value = value;
		this.referenceTypeName = referenceTypeName;
	}
	
	public boolean supportsValueModification() {
		return false;
	}
	
	public void setValue(org.eclipse.debug.core.model.IValue value) throws org.eclipse.debug.core.DebugException {
		throw new org.eclipse.debug.core.DebugException(new org.eclipse.core.runtime.Status(org.eclipse.core.runtime.IStatus.ERROR, org.emftext.language.prolog.resource.pl.mopp.PlPlugin.PLUGIN_ID, "Can't set variable."));
	}
	
	public void setValue(String expression) throws org.eclipse.debug.core.DebugException {
		throw new org.eclipse.debug.core.DebugException(new org.eclipse.core.runtime.Status(org.eclipse.core.runtime.IStatus.ERROR, org.emftext.language.prolog.resource.pl.mopp.PlPlugin.PLUGIN_ID, "Can't set variable."));
	}
	
	public boolean verifyValue(org.eclipse.debug.core.model.IValue value) throws org.eclipse.debug.core.DebugException {
		throw new org.eclipse.debug.core.DebugException(new org.eclipse.core.runtime.Status(org.eclipse.core.runtime.IStatus.ERROR, org.emftext.language.prolog.resource.pl.mopp.PlPlugin.PLUGIN_ID, "Can't set variable."));
	}
	
	public boolean verifyValue(String expression) throws org.eclipse.debug.core.DebugException {
		throw new org.eclipse.debug.core.DebugException(new org.eclipse.core.runtime.Status(org.eclipse.core.runtime.IStatus.ERROR, org.emftext.language.prolog.resource.pl.mopp.PlPlugin.PLUGIN_ID, "Can't set variable."));
	}
	
	public org.eclipse.debug.core.model.IValue getValue() throws org.eclipse.debug.core.DebugException {
		return value;
	}
	
	public String getName() throws org.eclipse.debug.core.DebugException {
		return name;
	}
	
	public String getReferenceTypeName() throws org.eclipse.debug.core.DebugException {
		return referenceTypeName;
	}
	
	public boolean hasValueChanged() throws org.eclipse.debug.core.DebugException {
		return true;
	}
	
}
