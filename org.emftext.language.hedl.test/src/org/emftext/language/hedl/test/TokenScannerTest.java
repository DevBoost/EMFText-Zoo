package org.emftext.language.hedl.test;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.rules.IToken;
import org.emftext.language.hedl.resource.hedl.IHedlTokenStyle;
import org.emftext.language.hedl.resource.hedl.mopp.HedlTokenStyle;
import org.emftext.language.hedl.resource.hedl.ui.HedlTokenScanner;

public class TokenScannerTest extends TestCase {

	public void testTokenScanner() {
		List<IToken> scan = scan("// TODO test item");
		assertEquals(3, scan.size());
		
		scan = scan("/**\n * TODO item one \n * TODO item two \n*/");
		assertEquals(5, scan.size());

		scan = scan("/**\n * TODO item one \n * TODO item two \n * TODO item three \n*/");
		assertEquals(7, scan.size());
	}

	private List<IToken> scan(String text) {
		HedlTokenScanner scanner = new HedlTokenScanner(null, null) {
			@Override
			public IHedlTokenStyle getStaticTokenStyle() {
				int[] foreground = new int[] {0,0,0};
				int[] background = new int[] {0,0,0};
				return new HedlTokenStyle(foreground, background, false, false, false, false);
			}
		};
		
		IDocument document = new Document();
		document.set(text);
		scanner.setRange(document, 0, text.length());
		
		List<IToken> allTokens = new ArrayList<IToken>();
		IToken nextToken = scanner.nextToken();
		while (nextToken != null && !nextToken.isEOF()) {
			allTokens.add(nextToken);
			nextToken = scanner.nextToken();
		}
		return allTokens;
	}
}
