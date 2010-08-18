package org.emftext.language.java.java2dsl.util;

import java.util.Arrays;

public class If2ShortIfQVTOStatisticUtil extends AbstractStatisticUtil {

	private int if2shortIf = 0;
	private int shortIf2if = 0;
	private int countClasses = 0;
	
	public void setCountClasses(int countClasses) {
		this.countClasses += countClasses;
	}

	public void setIf2shortIf(int if2shortIf) {
		this.if2shortIf += if2shortIf;
	}    

	public void setShortIf2if(int shortIf2if) {
		this.shortIf2if += shortIf2if;
	}
	
	@Override
	public void writeStatistic() {
		
		System.out.println("Klassen: "+countClasses);
		System.out.println("If->ShortIf: "+if2shortIf);
		System.out.println("If<-ShortIf: "+shortIf2if);

	}

	@Override
	public void init(){
		
		getRuleNames().put("expressions_ConditionalExpression", Arrays.asList("setIf2shortIf"));
		getRuleNames().put("CondExpr2Cond", Arrays.asList("setShortIf2if"));
		getRuleNames().put("Classifiers_Class", Arrays.asList("setCountClasses"));
		
	}


}
