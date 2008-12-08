package org.emftext.language.java.resource.java;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.emftext.runtime.resource.*;
import org.emftext.runtime.resource.impl.*;

public class JavaResourceImpl extends TextResourceImpl {
	private EMFTextTreeAnalyser analyser;


	public JavaResourceImpl(){
		super();
	}

	public JavaResourceImpl(URI uri){
		super(uri);
	}

	protected void doLoad(InputStream inputStream, Map<?,?> options) throws IOException {
		java.util.Map<Object, Object> loadOptions = addDefaultLoadOptions(options);
		EMFTextParser p = new JavaParser(new CommonTokenStream(new JavaLexer(new ANTLRInputStream(inputStream))));
		p.setResource(this);
		p.setOptions(loadOptions);
		EObject root = p.parse();
		while (root != null) {
			getContents().add(root);
			root = null; //p.parse();
		}

		EMFTextTreeAnalyser analyser = getTreeAnalyser();

		analyser.setOptions(loadOptions);
		analyser.analyse(this);
	}

	protected void doSave(OutputStream outputStream, Map<?,?> options) throws IOException {
		EMFTextPrinter p = new JavaPrinter(outputStream, this);
		for(EObject root : getContents()) {
			p.print(root);
		}
	}

	public String[] getTokenNames() {
		return new JavaParser(null).getTokenNames();
	}

	public Object getScanner() {
		return new JavaLexer();
	}

	public EMFTextTreeAnalyser getTreeAnalyser() {
		if (analyser == null) {
			analyser = new JavaTreeAnalyser();
		}
		return analyser;
	}
}
