package resolving_new.staticImportB_2;

import static resolving_new.staticImportB_2.Exporter.CONSTANT1;

public class Importer {
	
	private Exporter
	// target:2
	CONSTANT2;
	
	public void useImportAndLocalField() {
		
		// source:2:target
		CONSTANT2 = 
		// source:1:target
		CONSTANT1;
	}
}
