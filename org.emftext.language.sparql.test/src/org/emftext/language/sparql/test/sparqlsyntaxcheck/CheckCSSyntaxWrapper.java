/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
package org.emftext.language.sparql.test.sparqlsyntaxcheck;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

import junit.framework.Assert;

public class CheckCSSyntaxWrapper {
	
	private final String CSSEXE="CSharpSyntaxCheck" + File.separator + "CheckCSSyntax.exe";
	private final String USERDIR=System.getProperty("user.dir") + File.separator;
	private final String INPUT=USERDIR+"input" + File.separator;
	private final String EXEPATH=USERDIR+CSSEXE;
	
	public CheckCSSyntaxWrapper(){		
		
	}	
	
	public void assertAllFilesInInputDirectoryAreValid() {
		LinkedList<String> args=new LinkedList<String>();
		args.add(INPUT);
		File inputDir = new File(INPUT);
		File[] allFiles = inputDir.listFiles(new FileFilter() {

			public boolean accept(File file) {
				return file.getName().endsWith(".csharp");
			}
			
		});
		for (File next : allFiles) {
			boolean success = checkFiles("", next.getName());
			Assert.assertTrue(INPUT + next.getName() + " should be parsable.", success);
		}
	}
	
	public boolean checkFiles(String folder, String filename){
		List<String> arg=new LinkedList<String>();
		arg.add(filename);
		return checkFiles(folder, arg);
	}
	
	//folder relative to input folder
	public boolean checkFiles(String folder, List<String> params){
		LinkedList<String> args=new LinkedList<String>();
		String completePath=INPUT + folder;
		
		for (String item : params) {
			args.add(completePath+item);
		}
		
		return runProcess(args);
	}
	
	public boolean checkInputFolderFiles(String name){
		List<String> arg=new LinkedList<String>();
		arg.add(name);
		return checkInputFolderFiles(arg);
	}
		
	public boolean checkInputFolderFiles(List<String> arg){
		return checkFiles("", arg);
	}
	
	private boolean runProcess(LinkedList<String> args){
		LinkedList<String> command=new LinkedList<String>();
		command.add(EXEPATH);
		command.addAll(args);
		
		try {
			Process checker=new ProcessBuilder(command).start();
			InputStreamReader is=new InputStreamReader(checker.getInputStream());
			InputStreamReader es=new InputStreamReader(checker.getErrorStream());
			
			BufferedReader brIs=new BufferedReader(is);
			BufferedReader brEs=new BufferedReader(es);
			
			String input;
			
			//readLine h�ngt sich auf vom InputStream
			//Problem noch nicht gel�st
			/*
			while((input=brIs.readLine())!=null){
				System.out.println(input);
			}
			*/
			
			while((input=brEs.readLine())!=null){
				System.out.println(input);
			}
			
			if(checker.waitFor()==0){
				return true;
			}
			checker.destroy();
			
		} catch (Exception e) {
			System.out.println("Exception");
			e.printStackTrace();
		}			
		return false;
	}
	
}