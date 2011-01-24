
package org.emftext.language.sumup;
import org.eclipse.emf.ecore.*;
import java.util.*;
import org.emftext.language.sumup.*;
public class SumupSemanticsEvaluation {

	private List<Sheet> _place_SheetStack = new ArrayList<Sheet>();
	private List<Calculation> _place_CalculationStack = new ArrayList<Calculation>();
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
		UnresolvedType entry;
		Sheet sheet;
		{ // evaluate incomming arcs

			Sheet inToken = _in_SheetStack;
			Sheet __temp_1 = inToken;

			// .getEntries()
			List<VariableDeclaration> __temp_2 = __temp_1.getEntries();
			// .null()
			int __temp_3 = 0;
			
			null(__temp_2, __temp_3);
			entry = null;

			Sheet __temp_4 = inToken;

			sheet = __temp_4;

		}
		Sheet _out_SheetStack = org.emftext.language.sumup.SumupFactory.eINSTANCE.createSheet();
		Calculation _out_CalculationStack = org.emftext.language.sumup.SumupFactory.eINSTANCE.createCalculation();
		{ // evaluate outgoing arcs

			Sheet outToken = _out_SheetStack;
			Sheet __temp_5 = sheet;

			// .null()
			UnresolvedType __temp_6 = entry;

			
			null(__temp_5, __temp_6);
			Sheet __temp_7 = sheet;

			outToken = __temp_7;

			_out_SheetStack = outToken;
		}
		{ // evaluate outgoing arcs

			Calculation outToken = _out_CalculationStack;
			UnresolvedType __temp_8 = entry;

			outToken = __temp_8;

			_out_CalculationStack = outToken;
		}
		_place_CalculationStack.add(0, _out_CalculationStack);
		_place_SheetStack.add(0, _out_SheetStack);
	}

}