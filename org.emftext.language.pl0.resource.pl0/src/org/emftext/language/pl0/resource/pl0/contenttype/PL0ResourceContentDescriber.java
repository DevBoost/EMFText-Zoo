package org.emftext.language.pl0.resource.pl0.contenttype;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.Collections;

import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.core.runtime.content.IContentDescriber;
import org.eclipse.core.runtime.content.IContentDescription;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.pl0.Program;
import org.emftext.language.pl0.resource.pl0.mopp.Pl0Resource;
import org.emftext.language.pl0.resource.pl0.util.Pl0StreamUtil;

public class PL0ResourceContentDescriber implements IContentDescriber {

	public PL0ResourceContentDescriber() {
		
	}

	public int describe(InputStream contents, IContentDescription description) throws IOException {
		try {
			Resource resource = new Pl0Resource();
			String content = Pl0StreamUtil.getContent(contents);
			ByteArrayInputStream stream = new ByteArrayInputStream(content.getBytes());
			// here a NPE is thrown but as far as I debugged 
			// I could see that the content could be parsed correctly
			resource.load(stream, Collections.EMPTY_MAP);
			if(resource.getContents().get(0) instanceof Program){
				return IContentDescriber.VALID;
			} else {
				return IContentDescriber.INVALID;
			}
		} catch (Exception e) {
			// do nothing
			System.out.println("error while loading");
		}
		return IContentDescriber.INDETERMINATE;
	}

	public QualifiedName[] getSupportedOptions() {
		// TODO Auto-generated method stub
		return null;
	}

}
