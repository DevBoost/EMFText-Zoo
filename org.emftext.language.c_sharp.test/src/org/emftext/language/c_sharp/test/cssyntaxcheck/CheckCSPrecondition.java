package org.emftext.language.c_sharp.test.cssyntaxcheck;

public class CheckCSPrecondition {

	public static boolean checkWindowsInstalled(){
		return true;
	}
	
	public static boolean checkDotNetInstalled(){
		if (checkWindowsInstalled()){
			//add check for .net
		}
		return true;
	}
	
	public static boolean checkAll(){
		return (checkWindowsInstalled() && checkWindowsInstalled());
	}
}
