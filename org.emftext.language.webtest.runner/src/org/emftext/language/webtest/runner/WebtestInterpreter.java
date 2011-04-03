package org.emftext.language.webtest.runner;

import java.io.IOException;

import junit.framework.Assert;

import org.emftext.language.webtest.AssertTitle;
import org.emftext.language.webtest.Input;
import org.emftext.language.webtest.Load;
import org.emftext.language.webtest.Submit;
import org.emftext.language.webtest.resource.webtest.util.AbstractWebtestInterpreter;

import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

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
	public Boolean interprete_org_emftext_language_webtest_Submit(Submit object, WebtestContext context) {
		String formName = object.getForm();
		HtmlForm form = (HtmlForm) context.getCurrentPage().getElementById(formName);
		HtmlInput submitButton = form.getInputByName(object.getButton());
		try {
			context.setCurrentPage((HtmlPage) submitButton.click());
		} catch (IOException e) {
			Assert.fail(e.getMessage());
		}
		return true;
	}

	@Override
	public Boolean interprete_org_emftext_language_webtest_Input(Input object, WebtestContext context) {
		String formName = object.getForm();
		HtmlForm form = (HtmlForm) context.getCurrentPage().getElementById(formName);
		HtmlInput field = form.getInputByName(object.getField());
		field.setValueAttribute(object.getValue());
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
