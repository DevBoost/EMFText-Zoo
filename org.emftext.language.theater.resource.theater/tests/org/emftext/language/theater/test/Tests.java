package org.emftext.language.theater.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.theater.Actor;
import org.emftext.language.theater.Play;
import org.emftext.language.theater.Role;
import org.emftext.language.theater.Speech;
import org.junit.Test;

public class Tests extends TestParsing {
	
	@Test
	public void testAppearsIn() throws IOException {
		Resource actingResource = parserInputFile("tests/macbeth.theater");
		assertTrue("Resource is empty",actingResource != null);
		assertTrue("Resource has no root", actingResource.getContents().size() == 1 && 
				actingResource.getContents().get(0) instanceof Play);
		Play play = (Play) actingResource.getContents().get(0);
		EList<Actor> actors = play.getEnsemble().getActors();
		boolean visitedTomas = false;
		for (Actor actor : actors) {
			assertTrue("Actor has no appearances: " + actor.getName(), actor.getAppearsIn().size()>0);
			assertTrue("Actor has no role script: " + actor.getName(), actor.getPlays().get(0).getRoleScript().size()>0);
			if (actor.getName().equals("Thomas")) {
				EList<Speech> roleScript = actor.getPlays().get(0).getRoleScript();
				for (Speech speech : roleScript) {
				//	System.out.println(speech.getPlayedBy().getName() + ": " + speech.getText());
				}
				assertEquals("Role Scrips size is wrong.", 58, actor.getPlays().get(0).getRoleScript().size());
				visitedTomas  = true;
			}
		}
		assertTrue("Thomas was not visited", visitedTomas);
	}
	@Test
	public void testActOne() throws IOException {
		Resource actingResource = parserInputFile("tests/macbeth.theater");
		assertTrue("Resource is empty",actingResource != null);
		assertTrue("Resource has no root", actingResource.getContents().size() == 1 && 
				actingResource.getContents().get(0) instanceof Play);
		Play play = (Play) actingResource.getContents().get(0);
		
		for (Role role : play.getDeclaredRoles()) {
			if(role.getName().equals("Macb")) {
				System.out.println("=== Macbeth - Act 1 ===");
				EList<Speech> roleScript = role.getRoleScript();
				for (Speech speech : roleScript) {
					System.out.println(speech.getPlayedBy().get(0).getName() + ": '" + speech.getText()+"'\n");
				}
			} else if (role.getName().equals("1")) {
				System.out.println("=== Witch One - Act 1 ===");
				EList<Speech> roleScript = role.getRoleScript();
				for (Speech speech : roleScript) {
					System.out.println(speech.getPlayedBy().get(0).getName() + ": '" + speech.getText()+"'\n");
				}
			}
		}
	}

}
