package org.emftext.language.java.java2dsl.util;

import java.util.Arrays;

public class ClosureQVTOStatisticUtil extends AbstractStatisticUtil {

	private int countNewConstructorCallClosures = 0;
	private int countNewConstructorCall = 0;
	
	private int countMethodCallsClosures = 0;
	private int countMethodCalls = 0;
	
	private int countClasses = 0;
	
	private int countAssignmentExpressionClosures = 0;
	private int countAssignmentExpression = 0;
	
	private int countLocalVariableClosures = 0;
	private int countLocalVariable = 0;
	
	private int countReturnClosures = 0;
	private int countReturn = 0;
	
	public void setCountNewConstructorCallClosures(
			int countNewConstructorCallClosures) {
		this.countNewConstructorCallClosures += countNewConstructorCallClosures;
	}

	public void setCountMethodCallsClosures(int countMethodCallsClosures) {
		this.countMethodCallsClosures += countMethodCallsClosures;
	}

	public void setCountAssignmentExpressionClosures(
			int countAssignmentExpressionClosures) {
		this.countAssignmentExpressionClosures += countAssignmentExpressionClosures;
	}

	public void setCountLocalVariableClosures(int countLocalVariableClosures) {
		this.countLocalVariableClosures += countLocalVariableClosures;
	}

	public void setCountReturnClosures(int countReturnClosures) {
		this.countReturnClosures += countReturnClosures;
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

	public void setCountAssignmentExpression(int countAssignmentExpression) {
		this.countAssignmentExpression += countAssignmentExpression;
	}

	public void setCountLocalVariable(int countLocalVariable) {
		this.countLocalVariable += countLocalVariable;
	}

	public void setCountReturn(int countReturn) {
		this.countReturn += countReturn;
	}
	
	@Override
	public void writeStatistic() {
		
		System.out.println("Klassen: "+countClasses);
		
		System.out.println("NewConstructorCall: "+countNewConstructorCall);
		System.out.println("NewConstructorCallClosures: "+countNewConstructorCallClosures);
		
		System.out.println("MethodCalls: "+countMethodCalls);
		System.out.println("MethodCallsClosures: "+countMethodCallsClosures);
		
		System.out.println("AssignmentExpression: "+countAssignmentExpression);
		System.out.println("AssignmentExpressionClosures: "+countAssignmentExpressionClosures);
		
		System.out.println("LocalVariable: "+countLocalVariable);
		System.out.println("LocalVariableClosures: "+countLocalVariableClosures);
		
		System.out.println("Return: "+countReturn);
		System.out.println("ReturnClosures: "+countReturnClosures);
	}


	@Override
	public void init(){
		
		getRuleNames().put("Count_Classifiers_Class", Arrays.asList("setCountClasses"));
		
		getRuleNames().put("Instantiations_NewConstructorCall", Arrays.asList("setCountNewConstructorCall"));
		getRuleNames().put("Closures_Closure_NewConstructorCall", Arrays.asList("setCountNewConstructorCallClosures"));
		
		getRuleNames().put("References_MethodCall", Arrays.asList("setCountMethodCalls"));
		getRuleNames().put("Closures_Closure_MethodCall", Arrays.asList("setCountMethodCallsClosures"));
		
		getRuleNames().put("Statements_Return", Arrays.asList("setCountReturn"));
		getRuleNames().put("Closures_Closure_Return", Arrays.asList("setCountReturnClosures"));
		
		getRuleNames().put("Variables_LocalVariable", Arrays.asList("setCountLocalVariable"));
		getRuleNames().put("Closures_Closure_LocalVariable", Arrays.asList("setCountLocalVariableClosures"));
		
		getRuleNames().put("Expressions_AssignmentExpression", Arrays.asList("setCountAssignmentExpression"));
		getRuleNames().put("Closures_Closure_AssignmentExpression", Arrays.asList("setCountAssignmentExpressionClosures"));
		
	}

}
