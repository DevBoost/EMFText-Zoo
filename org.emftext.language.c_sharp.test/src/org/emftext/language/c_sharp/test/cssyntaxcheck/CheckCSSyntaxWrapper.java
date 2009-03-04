package org.emftext.language.c_sharp.test.cssyntaxcheck;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class CheckCSSyntaxWrapper {
	
	private final String CSSEXE="CSharpSyntaxCheck" + File.separator + "CheckCSSyntax.exe";
	private final String USERDIR=System.getProperty("user.dir") + File.separator;
	private final String INPUT=USERDIR+"input" + File.separator;
	private final String EXEPATH=USERDIR+CSSEXE;
	
	public CheckCSSyntaxWrapper(){		
		
	}	
	
	public boolean checkDefaultInputDirectory(){
		LinkedList<String> args=new LinkedList<String>();
		args.add(INPUT);
		return runProcess(args);
	}
	
	public boolean checkFiles(String folder, String filename){
		List<String> arg=new LinkedList<String>();
		return checkFiles(folder, arg);
	}
	
	//folder relative to input folder
	public boolean checkFiles(String folder, List<String> params){
		LinkedList<String> args=new LinkedList<String>();
		String completePath=INPUT+folder+"\\";
		
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
			while((input=brIs.readLine())!=null){
				System.out.println(input);
			}
			
			while((input=brEs.readLine())!=null){
				System.out.println(input);
			}
			if(checker.waitFor()==0){
				return true;
			}		
			checker.destroy();
		} catch (Exception e) {
			e.printStackTrace();
		}			
		return false;
	}
	
}
