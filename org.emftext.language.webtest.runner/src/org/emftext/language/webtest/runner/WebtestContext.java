package org.emftext.language.webtest.runner;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class WebtestContext {

    private WebClient webClient = new WebClient();
    
    private HtmlPage currentPage;

	public WebClient getWebClient() {
		return webClient;
	}

	public HtmlPage getCurrentPage() {
		return currentPage;
	}
    
    public void setCurrentPage(String url) throws Exception {
    	currentPage = webClient.getPage(url);
    }
}
