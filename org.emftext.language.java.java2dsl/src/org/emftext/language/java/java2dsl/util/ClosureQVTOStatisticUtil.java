package org.emftext.language.java.java2dsl.util;

import java.util.Arrays;

public class ClosureQVTOStatisticUtil extends AbstractStatisticUtil {

	private int countClosures = 0;
	private int countNewConstructorCall = 0;
	private int countMethodCalls = 0;
	private int countClasses = 0;
	
	
	
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



	@Override
	public void writeStatistic() {
		
		System.out.println("Klassen: "+countClasses);
		System.out.println("ConstructorCalls: "+countNewConstructorCall);
		System.out.println("MethodCalls: "+countMethodCalls);
		System.out.println("Closures: "+countClosures);

	}

	@Override
	public void init(){
		
		getRuleNames().put("Closures_Closure", Arrays.asList("setCountClosures"));
		getRuleNames().put("Instantiations_NewConstructorCall", Arrays.asList("setCountNewConstructorCall"));
		getRuleNames().put("References_MethodCall", Arrays.asList("setCountMethodCalls"));
		getRuleNames().put("Classifiers_Class", Arrays.asList("setCountClasses"));
		
	}
}
