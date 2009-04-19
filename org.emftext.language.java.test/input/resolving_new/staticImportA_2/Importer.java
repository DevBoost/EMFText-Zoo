package resolving_new.staticImportA_2;

import static resolving_new.staticImportA_2.Exporter.m;

public class Importer {
	
	public void useImportedMember() {
		// source:2:target
		m();
		
		int x =
		// source:1:target
		m;
	}
}
