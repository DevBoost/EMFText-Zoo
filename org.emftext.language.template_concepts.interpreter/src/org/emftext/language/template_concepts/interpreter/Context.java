/**
 * 
 */
package org.emftext.language.template_concepts.interpreter;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import org.eclipse.emf.ecore.EObject;
import org.emftext.language.template_concepts.interpreter.exceptions.InterpreterException;


/**
 * @author Marcel Boehme
 *
 */
public class Context {
	//Logger
	
	private Map<String,Vector<EObject>> varname2ValueMap;
	/**
	 * Copy context without alternating the original maps.
	 * Keeps the maps as there were at the time of creation
	 * @param name2importedModelMap
	 * @param varname2ValueStackMap
	 */
	public Context() {
		varname2ValueMap = new HashMap<String, Vector<EObject>>();
	}
	
	/**
	 * Puts a variable upon variable stack
	 * @param name
	 * @param o
	 */
	public void pushVariable(String name, EObject o){
		Vector<EObject> varStack = varname2ValueMap.get(name);
		if(varStack == null){
			varStack = new Vector<EObject>();
			varname2ValueMap.put(name, varStack);
		}
		varStack.add(o);
	}
	
	/**
	 * Sets a new value for the variable with the given <code>name</code>
	 * last pushed upon stack 
	 * @param name
	 * @param o
	 */
	public void setNewVariableValue(String name, EObject o){
		Vector<EObject> varStack = varname2ValueMap.get(name);
		if(varStack == null){
			System.err.println("No such variable on stack: "+name);
			return;
		}
		if(!varStack.isEmpty()){
			varStack.removeElement(varStack.lastElement());
		}
		varStack.add(o);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.mboehme.rouTEmplate.tracing.IContext#getVariableValue(java.lang.String)
	 */
	public EObject getVariableValue(String name) throws InterpreterException {
		Vector<EObject> varStack = varname2ValueMap.get(name);
		if(varStack == null){
			System.err.println("No such variable on stack: "+name);
			return null;
		}
		if(varStack.isEmpty()){
			throw new InterpreterException("BUG: varStack is empty. Should not happen");
		}
		return varStack.lastElement();
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.mboehme.rouTEmplate.tracing.IContext#getListOfVariables()
	 */
	public Set<String> getListOfVariables(){
		return varname2ValueMap.keySet();
	}
	
	/**
	 * Returns variable with given <code>name</code> and removes it from stack
	 * @param name
	 * @return
	 */
	public EObject pullVariable(String name){
		Vector<EObject> varStack = varname2ValueMap.get(name);
		if(varStack == null){
			return null;
		}
		if(varStack.isEmpty()) return null;
		EObject o = varStack.lastElement();
		//Delete whole var-Entry if there is just 
		//one variable left (which is deleted now anyway)
		if(varStack.size()>1){
			varStack.remove(o);
		} else {
			varname2ValueMap.remove(name);
		}
		return o;
	}
}
