package org.emftext.language.java.java2dsl.util;

import java.util.Arrays;

public class If2ShortIfQVTOStatisticUtil extends AbstractStatisticUtil {

	private int if2shortIf = 0;
	private int countClasses = 0;
	
	public void setCountClasses(int countClasses) {
		this.countClasses += countClasses;
	}

	public void setIf2shortIf(int if2shortIf) {
		this.if2shortIf += if2shortIf;
	}    

	@Override
	public void writeStatistic() {
		
		System.out.println("Klassen: "+countClasses);
		System.out.println("If<->ShortIf: "+if2shortIf);

	}

	@Override
	public void init(){
		
		getRuleNames().put("Condition2CondExpr_Return", Arrays.asList("setIf2shortIf"));
		getRuleNames().put("Condition2CondExpr_LocVarStat", Arrays.asList("setIf2shortIf"));
		getRuleNames().put("CondExpr2Cond", Arrays.asList("setIf2shortIf"));
		getRuleNames().put("Classifiers_Class", Arrays.asList("setCountClasses"));
		
	}
}
