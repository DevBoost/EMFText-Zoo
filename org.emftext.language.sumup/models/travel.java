package resource.org.emftext.language.sumup.models;

public class travel {

	private double berlin_Dresden;
	
	private double dresden_Nürnberg;
	
	private double hin_und_zurück;
	
	private double verbrauch;
	
	private double spritverbrauch;
	
	/**
	 * Returns output parameter 'Berlin_Dresden'.
	 */
	public double getBerlin_Dresden() {
		return this.berlin_Dresden / (1
		);
	}
	
	/**
	 * Returns output parameter 'Dresden_Nürnberg'.
	 */
	public double getDresden_Nürnberg() {
		return this.dresden_Nürnberg / (1
		);
	}
	
	/**
	 * Returns output parameter 'Hin_und_zurück'.
	 */
	public double getHin_und_zurück() {
		return this.hin_und_zurück / (1
		);
	}
	
	/**
	 * Returns output parameter 'Verbrauch'.
	 */
	public double getVerbrauch() {
		return this.verbrauch / (1
		);
	}
	
	/**
	 * Returns output parameter 'Spritverbrauch'.
	 */
	public double getSpritverbrauch() {
		return this.spritverbrauch / (1
		);
	}
	
	public void calculate() {
		this.berlin_Dresden = (((100 * ((1000 * 1
		)
		)
		
		)
		)
		 + ((50 * ((1000 * 1
		 )
		 )
		 
		 )
		 )
		 )
		;
		this.dresden_Nürnberg = ((300 * ((1000 * 1
		)
		)
		
		)
		)
		;
		this.hin_und_zurück = (((2 * 1
		)
		)
		 * ((((this.berlin_Dresden
		 )
		  + (this.dresden_Nürnberg
		  )
		  )
		 )
		 )
		 )
		;
		this.verbrauch = ((0.075 * 1
		)
		)
		;
		this.spritverbrauch = ((this.hin_und_zurück
		)
		 * (this.verbrauch
		 )
		 )
		;
	}
}
