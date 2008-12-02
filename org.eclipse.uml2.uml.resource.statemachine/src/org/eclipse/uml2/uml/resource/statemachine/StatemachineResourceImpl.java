package org.eclipse.uml2.uml.resource.statemachine;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.reuseware.emftextedit.runtime.resource.*;
import org.reuseware.emftextedit.runtime.resource.impl.*;

public class StatemachineResourceImpl extends TextResourceImpl {
	public StatemachineResourceImpl(){
		super();
	}

	public StatemachineResourceImpl(URI uri){
		super(uri);
	}

	protected void doLoad(InputStream inputStream, Map<?,?> options) throws IOException {
		EMFTextParser p = new StatemachineParser(new CommonTokenStream(new StatemachineLexer(new ANTLRInputStream(inputStream))));
		p.setResource(this);
		p.setOptions(options);
		EObject root = p.parse();
		while (root != null) {
			getContents().add(root);
			root = null; //p.parse();
		}

		EMFTextTreeAnalyser a = new StatemachineTreeAnalyser();

		a.setOptions(options);
		a.analyse(this);
	}

	protected void doSave(OutputStream outputStream, Map<?,?> options) throws IOException {
		EMFTextPrinter p = new StatemachinePrinter(outputStream, this);
		for(EObject root : getContents()) {
			p.print(root);
		}
	}

	public String[] getTokenNames() {
		return new StatemachineParser(null).getTokenNames();
	}

	public Object getScanner() {
		return new StatemachineLexer();
	}

}
