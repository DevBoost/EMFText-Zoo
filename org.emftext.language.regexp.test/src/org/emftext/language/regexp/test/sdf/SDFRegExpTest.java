/*******************************************************************************
 * Copyright (c) 2006-2011
 * Software Technology Group, Dresden University of Technology
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.language.regexp.test.sdf;

import org.emftext.language.regexp.resource.regexp_sdf.mopp.Regexp_sdfMetaInformation;
import org.emftext.language.regexp.test.AbstractTestCase;

public class SDFRegExpTest extends AbstractTestCase {

	public void testSimpleExpressions() {
		parse("[abc]");
		parse("[a-z]");
		parse("[a-z0-9]");
		parse("[a-z]*");
		parse("[\\ \\t\\12\\r\\n]");
		parse("[btnfr\\\"\\'\\\\]");
		parse("~[\\\"\\\\\\n\\r]");
		parse("~([a-z]*)");
		parse("\"keyword\"");
		parse("\"keyword\"|\"anotherKeyword\"");
	}

	private void parse(String nextRegexp) {
		super.parse(nextRegexp, new Regexp_sdfMetaInformation().getSyntaxName());
	}
}
