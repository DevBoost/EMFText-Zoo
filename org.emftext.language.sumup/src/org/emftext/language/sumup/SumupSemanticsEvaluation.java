
package org.emftext.language.sumup;
import org.eclipse.emf.ecore.*;
import java.util.*;
import org.emftext.language.sumup.*;
public class SumupSemanticsEvaluation {

	private List<Sheet> _place_SheetStack = new ArrayList<Sheet>();
	private List<VariableDeclaration> _place_CalculationStack = new ArrayList<VariableDeclaration>();
	private List<VariableDeclaration> _place_VariableStack = new ArrayList<VariableDeclaration>();

	public void intialisePlaces(EObject model) {
		// TODO implement place initialisation for places w/o incomming arcs.
	}

	public void evaluatePetriNet() {
		boolean petrinetWasUpdated = true;
		while(petrinetWasUpdated) {;
			petrinetWasUpdated = false;
			if(transition_initialiseCalculationStack_canFire()) {
				transition_initialiseCalculationStack_doFire();
				petrinetWasUpdated = true;
			}
		}
	}
	private boolean transition_initialiseCalculationStack_canFire() {
		if (_place_SheetStack.isEmpty() ) return false;
		return true;
	}

	private void transition_initialiseCalculationStack_doFire() {
		Sheet _in_SheetStack = _place_SheetStack.remove(0);
		VariableDeclaration entry;
		Sheet sheet;
		{ // evaluate incomming arcs

			Sheet inToken = _in_SheetStack;

			// entry initialization 
			Sheet __temp_1 = inToken;

			// .getEntries()
			List<VariableDeclaration> __temp_2 = __temp_1.getEntries();
			// .get()
			int __temp_3 = 0;
			VariableDeclaration __temp_4 = __temp_2.get(__temp_3);
			entry = __temp_4;

			// sheet initialization 
			Sheet __temp_5 = inToken;

			sheet = __temp_5;
		}
		Sheet _out_SheetStack;
		VariableDeclaration _out_CalculationStack;
		{ // evaluate outgoing arcs

			Sheet outToken;
			Sheet __temp_6 = sheet;

			// .getEntries()
			List<VariableDeclaration> __temp_7 = __temp_6.getEntries();
			// .remove()
			VariableDeclaration __temp_8 = entry;

			boolean __temp_9 = __temp_7.remove(__temp_8);

			// outToken initialization 
			Sheet __temp_10 = sheet;

			outToken = __temp_10;
			_out_SheetStack = outToken;
		}
		{ // evaluate outgoing arcs

			VariableDeclaration outToken;

			// outToken initialization 
			VariableDeclaration __temp_11 = entry;

			outToken = __temp_11;
			_out_CalculationStack = outToken;
		}
		_place_CalculationStack.add(0, _out_CalculationStack);
		_place_SheetStack.add(0, _out_SheetStack);
	}

}