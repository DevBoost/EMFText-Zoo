package org.emftext.language.sumup.example.post;

public class PortoCalculation {

	private double sendungsAnzahl;
	
	private double laenge;
	
	private double breite;
	
	private double hoehe;
	
	private double gewicht;
	
	private double gesamtSumme;
	
	private double einzelPreis;
	
	private double kiloPreis;
	
	public double getSendungsAnzahl() {
		return this.sendungsAnzahl;
	}
	
	public void setSendungsAnzahl(double newValue) {
		this.sendungsAnzahl = newValue;
	}
	
	public double getLaenge() {
		return this.laenge;
	}
	
	public void setLaenge(double newValue) {
		this.laenge = newValue;
	}
	
	public double getBreite() {
		return this.breite;
	}
	
	public void setBreite(double newValue) {
		this.breite = newValue;
	}
	
	public double getHoehe() {
		return this.hoehe;
	}
	
	public void setHoehe(double newValue) {
		this.hoehe = newValue;
	}
	
	public double getGewicht() {
		return this.gewicht;
	}
	
	public void setGewicht(double newValue) {
		this.gewicht = newValue;
	}
	
	public double getGesamtSumme() {
		return this.gesamtSumme;
	}
	
	public double getEinzelPreis() {
		return this.einzelPreis;
	}
	
	public double getKiloPreis() {
		return this.kiloPreis;
	}
	
	public void calculate() {
		this.einzelPreis = 1.49 * 100 * 1
		
		
		
		
		
		;
		this.kiloPreis = 2 * 100 * 1
		
		
		
		
		
		;
		this.gesamtSumme = getSendungsAnzahl()
		
		 * getEinzelPreis()
		 
		 
		 + (getSendungsAnzahl()
		 
		  * getGewicht()
		  
		  
		 )
		 
		  * getKiloPreis()
		  
		  
		 
		;
	}
}
