package org.emftext.language.java.java2dsl.util;

import java.util.Arrays;

public class ClosureMediniStatisticUtil extends AbstractStatisticUtil {

	private int countClosures = 0;
	private int countNewConstructorCall = 0;
	private int countMethodCalls = 0;
	private int countClasses = 0;
	private int countInterface = 0;
	private int countEnumeration = 0;
	private int countAnnotation = 0;
	
	
	public void setCountClosures(int countClosures) {
		this.countClosures += countClosures;
	}



	public void setCountNewConstructorCall(int countNewConstructorCall) {
		this.countNewConstructorCall += countNewConstructorCall;
	}



	public void setCountMethodCalls(int countMethodCalls) {
		this.countMethodCalls += countMethodCalls;
	}



	public void setCountClasses(int countClasses) {
		this.countClasses += countClasses;
	}

	public void addEnumeration(int value){
		countEnumeration += value;
	}
	
	public void addInterface(int value){
		countInterface += value;
	}
	
	public void addAnnotation(int value){
		countAnnotation += value;
	}

	@Override
	public void writeStatistic() {
		
		System.out.println("Klassen: "+countClasses);
		System.out.println("Methoden: "+countNewConstructorCall);
		System.out.println("MethodCalls: "+countMethodCalls);
		System.out.println("Closures: "+countClosures);

	}

	@Override
	public void init(){
		
		getRuleNames().put("Closures_Closure", Arrays.asList("setCountClosures"));
		getRuleNames().put("Statements_StatementListContainer_NewConstructorCall", Arrays.asList("setCountNewConstructorCall"));
		getRuleNames().put("Statements_StatementListContainer_MethodCall", Arrays.asList("setCountMethodCalls"));
		getRuleNames().put("References_Reference_NewConstructorCall", Arrays.asList("setCountNewConstructorCall"));
		getRuleNames().put("References_Reference_MethodCall", Arrays.asList("setCountMethodCalls"));
		getRuleNames().put("CompilationUnit_Class", Arrays.asList("setCountClasses"));
		getRuleNames().put("Classifiers_Interface", Arrays.asList("addInterface"));
		getRuleNames().put("Classifiers_Enumeration", Arrays.asList("addEnumeration"));
		getRuleNames().put("Classifiers_Annotation", Arrays.asList("addAnnotation"));
		
	}

}
