package org.emftext.language.java.java2dsl.util;

import java.util.Arrays;

public class ClosureMediniStatisticUtil extends AbstractStatisticUtil {

	private int countClosures = 0;
	private int countNewConstructorCall = 0;
	private int countMethodCalls = 0;
	private int countClasses = 0;
	private int countAssignmentExpression = 0;
	private int countLocalVariable = 0;
	private int countReturn = 0;
	
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
		System.out.println("MethodCalls: "+countMethodCalls);
		System.out.println("Closures: "+countClosures);
		System.out.println("AssignmentExpression: "+countAssignmentExpression);
		System.out.println("LocalVariable: "+countLocalVariable);
		System.out.println("Return: "+countReturn);
	}

	@Override
	public void init(){
		
		getRuleNames().put("Closures_Closure", Arrays.asList("setCountClosures"));
		
		getRuleNames().put("Statements_StatementListContainer_NewConstructorCall", Arrays.asList("setCountNewConstructorCall"));
		getRuleNames().put("References_Reference_NewConstructorCall", Arrays.asList("setCountNewConstructorCall"));
		getRuleNames().put("References_Argumentable_NewConstructorCall", Arrays.asList("setCountNewConstructorCall"));
		
		getRuleNames().put("Statements_StatementListContainer_MethodCall", Arrays.asList("setCountMethodCalls"));
		getRuleNames().put("References_Reference_MethodCall", Arrays.asList("setCountMethodCalls"));
		getRuleNames().put("References_Argumentable_MethodCall", Arrays.asList("setCountMethodCalls"));
		
		getRuleNames().put("CompilationUnit_Class", Arrays.asList("setCountClasses"));
		getRuleNames().put("Members_Class", Arrays.asList("setCountClasses"));
		
		getRuleNames().put("LocalVariable_InitialValue_Closure", Arrays.asList("setCountLocalVariable"));
		getRuleNames().put("LocalVariable_InitialValue_Expression", Arrays.asList("setCountLocalVariable"));
		
		getRuleNames().put("AssignmentExpression_Value_Closure", Arrays.asList("setCountAssignmentExpression"));
		getRuleNames().put("AssignmentExpression_Value_Expression", Arrays.asList("setCountAssignmentExpression"));
		
		getRuleNames().put("Return_ReturnValue_Closure", Arrays.asList("setCountReturn"));
		getRuleNames().put("Return_ReturnValue_Expression", Arrays.asList("setCountReturn"));
	}



}
