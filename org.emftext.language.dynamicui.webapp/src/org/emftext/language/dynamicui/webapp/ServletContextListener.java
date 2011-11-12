package org.emftext.language.dynamicui.webapp;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

/**
 * The purpose of this ServletContextListener is to remove all objects from the
 * application that are not serializable.
 * 
 * TODO fix this class
 */
public class ServletContextListener implements javax.servlet.ServletContextListener {

	public void contextInitialized(ServletContextEvent event) {
	}
	
	public void contextDestroyed(ServletContextEvent event) {
		ServletContext servletContext = event.getServletContext();
		
		String key = DynamicuiApplication.class.getName();
		
		Object app = servletContext.getAttribute(key);
		if (app != null && app instanceof DynamicuiApplication) {
			DynamicuiApplication dynamicuiApplication = (DynamicuiApplication) app;
			dynamicuiApplication.removeTreeContent();
			servletContext.setAttribute(key, null);
		}
	}
}
