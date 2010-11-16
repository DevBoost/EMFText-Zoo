package org.emftext.language.egui.test;

import static junit.framework.Assert.fail;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.egui.Application;
import org.emftext.language.egui.EguiFactory;
import org.emftext.language.egui.EguiPackage;
import org.emftext.language.egui.actions.ActionsPackage;
import org.emftext.language.egui.commons.CommonsPackage;
import org.emftext.language.egui.resource.egui.mopp.EguiResourceFactory;
import org.emftext.language.egui.screenmodel.Screen;
import org.emftext.language.egui.screenmodel.ScreenmodelFactory;
import org.emftext.language.egui.screenmodel.ScreenmodelPackage;
import org.emftext.language.egui.statemodel.StatemodelFactory;
import org.emftext.language.egui.statemodel.StatemodelPackage;
import org.emftext.language.egui.widgets.Button;
import org.emftext.language.egui.widgets.Panel;
import org.emftext.language.egui.widgets.TextField;
import org.emftext.language.egui.widgets.WidgetsFactory;
import org.emftext.language.egui.widgets.WidgetsPackage;
import org.junit.Test;

public class PrintingTest {

	public PrintingTest(){
		registerFactories();
	}

	private void registerFactories() {
		EPackage.Registry.INSTANCE.put(EguiPackage.eNS_URI, EguiPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(StatemodelPackage.eNS_URI, StatemodelPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(CommonsPackage.eNS_URI, CommonsPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(ActionsPackage.eNS_URI, ActionsPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(ScreenmodelPackage.eNS_URI, ScreenmodelPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(WidgetsPackage.eNS_URI, WidgetsPackage.eINSTANCE);
		Map<String, Object> extensionToFactoryMap = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
		extensionToFactoryMap.put("egui", new EguiResourceFactory());
	}
	
	@Test
	public void testIndentationPrinting(){
		Application application = EguiFactory.eINSTANCE.createApplication();
		application.setName("TestApp");
		application.setStatemodel(StatemodelFactory.eINSTANCE.createStateModel());
		Screen screen = ScreenmodelFactory.eINSTANCE.createScreen();
		application.getScreens().add(screen);
		Button button = WidgetsFactory.eINSTANCE.createButton();
		button.setName("testButton");
		Panel panel = WidgetsFactory.eINSTANCE.createPanel();
		panel.setName("TestPanel");
		TextField textField1 = WidgetsFactory.eINSTANCE.createTextField();
		textField1.setName("testTextField1");
		TextField textField2 = WidgetsFactory.eINSTANCE.createTextField();
		textField2.setName("testTextField2");
		panel.getCompounds().add(textField1);
		panel.getCompounds().add(textField2);
		screen.getCompounds().add(button);
		screen.getCompounds().add(panel);
		ResourceSet rs = new ResourceSetImpl();
		URI uri = URI.createURI("testApp.egui");
		Resource importedResource = rs.createResource(uri);
		importedResource.getContents().add(application);
		OutputStream os = new ByteArrayOutputStream();
		try {
			importedResource.save(os, null);
			String printedEgui = os.toString();
			System.out.println(printedEgui);
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}
}
