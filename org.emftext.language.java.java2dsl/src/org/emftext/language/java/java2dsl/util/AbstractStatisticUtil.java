package org.emftext.language.java.java2dsl.util;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractStatisticUtil {

	private long startTime = 0;
	private long endTime = 0;
	
	private Map<String,List<String>> ruleNames = new HashMap<String,List<String>>();
	
	public AbstractStatisticUtil() {
		init();
	}

	public void setStartTime(long time){
		startTime = time;
	}
	
	public void writeEndTime(long time){
		
		endTime = Calendar.getInstance().getTimeInMillis();
		long seconds = (endTime-startTime)/1000;
		if(seconds <= 60){
			System.out.println("Gesamtdauer Transformationen: "+seconds+" Sekunden.");
		}
		else if (seconds <= 3600){
			long minutes = seconds/60;
			System.out.println("Gesamtdauer Transformationen: "+minutes+" Minuten.");
		}
		else{	
			long minutes = (seconds/60)/60;
			System.out.println("Gesamtdauer Transformationen: "+minutes+" Stunden.");
		}
	}
	
	public Map<String, List<String>> getRuleNames() {
		return ruleNames;
	}

	public abstract void writeStatistic();
	
	public abstract void init();
}
