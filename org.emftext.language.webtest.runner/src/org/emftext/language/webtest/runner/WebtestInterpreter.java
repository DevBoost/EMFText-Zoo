package org.emftext.language.webtest.runner;

import junit.framework.Assert;

import org.emftext.language.webtest.AssertTitle;
import org.emftext.language.webtest.Load;
import org.emftext.language.webtest.resource.webtest.util.AbstractWebtestInterpreter;

public class WebtestInterpreter extends AbstractWebtestInterpreter<Boolean, WebtestContext> {

	@Override
	public Boolean interprete_org_emftext_language_webtest_Load(Load object, WebtestContext context) {
		try {
			context.setCurrentPage(object.getUrl());
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	public Boolean interprete_org_emftext_language_webtest_AssertTitle(AssertTitle object, WebtestContext context) {
		String actualTitle = context.getCurrentPage().getTitleText();
		Assert.assertEquals("Wrong title.", object.getExpected(), actualTitle);
		return true;
	}

	@Override
	public boolean continueInterpretation(Boolean result) {
		if (result == null) {
			Assert.fail("Stopping web test.");
			return false;
		}
		return result;
	}
}
