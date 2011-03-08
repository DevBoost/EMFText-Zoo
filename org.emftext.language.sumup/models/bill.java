package resource.org.emftext.language.sumup.models;

public class bill {

	private double apples;
	
	private double veal;
	
	private double sugar;
	
	private double sums;
	
	/**
	 * Returns output parameter 'Apples'.
	 */
	public double getApples() {
		return this.apples / (1
		);
	}
	
	/**
	 * Returns output parameter 'Veal'.
	 */
	public double getVeal() {
		return this.veal / (1
		);
	}
	
	/**
	 * Returns output parameter 'Sugar'.
	 */
	public double getSugar() {
		return this.sugar / (1
		);
	}
	
	/**
	 * Returns output parameter 'Sums'.
	 */
	public double getSums() {
		return this.sums / (1
		);
	}
	
	public void calculate() {
		this.apples = (((700 * 1
		)
		)
		 * ((2.99 * 1
		 )
		 )
		 )
		;
		this.veal = (((500 * 1
		)
		)
		 * ((3.99 * ((0.01 * 1
		 )
		 )
		 
		 )
		 )
		 )
		;
		this.sugar = ((1.49 * 1
		)
		)
		;
		this.sums = ((this.apples
		)
		 + (this.veal
		 )
		 )
		;
	}
}
