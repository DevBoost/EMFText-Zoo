package org.emftext.language.sumup.example.post;

import static org.junit.Assert.*;

import org.junit.Test;

public class PortoCalculationTest {

	@Test
	public void testCalculate() {
		// verschicke ein paeckchen
		PortoCalculation pc = new PortoCalculation();
		pc.setLaenge(30);
		pc.setBreite(30);
		pc.setHoehe(10);
		pc.setGewicht(1);
		pc.setSendungsAnzahl(1);
		
		pc.calculate();
		
		assertEquals("Unexpected price.", 3.9, pc.getEinzelPreis(), 0.0);
		assertEquals("Unexpected price.", 3.9, pc.getGesamtSumme(), 0.0);
	}
	
	// verschicke 20 x paket klein
	@Test
	public void testPaketKlein() {
		PortoCalculation pc = new PortoCalculation();
		pc.setLaenge(650);
		pc.setBreite(300);
		pc.setHoehe(100);
		pc.setGewicht(3000); // = 3kg
		pc.setSendungsAnzahl(20);
		
		pc.calculate();

		assertEquals("Unexpected price.", 5.9, pc.getEinzelPreis(), 0.0);
		assertEquals("Unexpected price.", 5.9 * 20, pc.getGesamtSumme(), 0.0);
	}
}
