/**
* Copyright (C) 2012  
* Jan Reimann (TU Dresden, Software Technology Group)
* Mirko Seifert (DevBoost GmbH)
* 
* This program is free software; you can redistribute it and/or
* modify it under the terms of the GNU General Public License
* as published by the Free Software Foundation; either version 2
* of the License, or (at your option) any later version.
* 
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
* 
* You should have received a copy of the GNU General Public License
* along with this program; if not, write to the Free Software
* Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
*/
package org.devboost.stanford.language.resource.txt.mopp;

import java.util.ArrayList;
import java.util.List;

import org.devboost.stanford.language.Document;
import org.devboost.stanford.language.Sentence;
import org.devboost.stanford.language.Word;
import org.eclipse.emf.ecore.EObject;

/**
 * A basic implementation of the ILocationMap interface. Instances store
 * information about element locations using four maps.
 * <p>
 * The set-methods can be called multiple times by the parser that may visit
 * multiple children from which it copies the localization information for the
 * parent element (i.e., the element for which set-method is called). It
 * implements the following behavior:
 * <p>
 * Line:   The lowest of all sources is used for target<br>
 * Column: The lowest of all sources is used for target<br>
 * Start:  The lowest of all sources is used for target<br>
 * End:    The highest of all sources is used for target<br>
 */
public class TxtLocationMap implements org.devboost.stanford.language.resource.txt.ITxtLocationMap {
	
	private TxtResource txtResource;
	
	/**
	 * A basic interface that can be implemented to select EObjects based of their
	 * location in a text resource.
	 */
	public interface ISelector {
		boolean accept(int startOffset, int endOffset);
	}
	
	protected java.util.Map<org.eclipse.emf.ecore.EObject, Integer> columnMap = new java.util.IdentityHashMap<org.eclipse.emf.ecore.EObject, Integer>();
	protected java.util.Map<org.eclipse.emf.ecore.EObject, Integer> lineMap = new java.util.IdentityHashMap<org.eclipse.emf.ecore.EObject, Integer>();
	protected java.util.Map<org.eclipse.emf.ecore.EObject, Integer> charStartMap = new java.util.IdentityHashMap<org.eclipse.emf.ecore.EObject, Integer>();
	protected java.util.Map<org.eclipse.emf.ecore.EObject, Integer> charEndMap = new java.util.IdentityHashMap<org.eclipse.emf.ecore.EObject, Integer>();
	
	public TxtLocationMap(TxtResource txtResource) {
		this.txtResource = txtResource;
	}

	public void setLine(org.eclipse.emf.ecore.EObject element, int line) {
		setMapValueToMin(lineMap, element, line);
	}
	
	public int getLine(org.eclipse.emf.ecore.EObject element) {
		return getMapValue(lineMap, element);
	}
	
	public void setColumn(org.eclipse.emf.ecore.EObject element, int column) {
		setMapValueToMin(columnMap, element, column);
	}
	
	public int getColumn(org.eclipse.emf.ecore.EObject element) {
		return getMapValue(columnMap, element);
	}
	
	public void setCharStart(org.eclipse.emf.ecore.EObject element, int charStart) {
		setMapValueToMin(charStartMap, element, charStart);
	}
	
	public int getCharStart(org.eclipse.emf.ecore.EObject element) {
		if(element instanceof Word){
			return ((Word) element).getBegin(); 
		} else if (element instanceof Sentence){
			return ((Sentence) element).getBegin();
		} else if (element instanceof Document){
			return ((Document) element).getBegin();
		}
		return getMapValue(charStartMap, element);
	}
	
	public void setCharEnd(org.eclipse.emf.ecore.EObject element, int charEnd) {
		setMapValueToMax(charEndMap, element, charEnd);
	}
	
	public int getCharEnd(org.eclipse.emf.ecore.EObject element) {
		if(element instanceof Word){
			return ((Word) element).getEnd(); 
		} else if (element instanceof Sentence){
			return ((Sentence) element).getEnd();
		} else if(element instanceof Document){
			return ((Document) element).getEnd();
		}
		return getMapValue(charEndMap, element);
	}
	
	private int getMapValue(java.util.Map<org.eclipse.emf.ecore.EObject, Integer> map, org.eclipse.emf.ecore.EObject element) {
		if (!map.containsKey(element)) return -1;
		Integer value = map.get(element);
		return value == null ? -1 : value.intValue();
	}
	
	private void setMapValueToMin(java.util.Map<org.eclipse.emf.ecore.EObject, Integer> map, org.eclipse.emf.ecore.EObject element, int value) {
		// We need to synchronize the write access, because other threads may iterate over
		// the map concurrently.
		synchronized (this) {
			if (element == null || value < 0) return;
			if (map.containsKey(element) && map.get(element) < value) return;
			map.put(element, value);
		}
	}
	
	private void setMapValueToMax(java.util.Map<org.eclipse.emf.ecore.EObject, Integer> map, org.eclipse.emf.ecore.EObject element, int value) {
		// We need to synchronize the write access, because other threads may iterate over
		// the map concurrently.
		synchronized (this) {
			if (element == null || value < 0) return;
			if (map.containsKey(element) && map.get(element) > value) return;
			map.put(element, value);
		}
	}
	
	public java.util.List<org.eclipse.emf.ecore.EObject> getElementsAt(final int documentOffset) {
		if(txtResource != null){
			Document document = (Document) txtResource.getContents().get(0);
			List<Sentence> sentences = document.getSentences();
			for (Sentence sentence : sentences) {
				if(sentence.getBegin() <= documentOffset && documentOffset <= sentence.getEnd()){
					List<Word> words = sentence.getWords();
					for (Word word : words) {
						if(word.getBegin() <= documentOffset && documentOffset <= word.getEnd()){
							List<EObject> selectedWord = new ArrayList<EObject>();
							selectedWord.add(word);
							return selectedWord;
						}
					}
				}
			}
		}
		java.util.List<org.eclipse.emf.ecore.EObject> result = getElements(new ISelector() {
			public boolean accept(int start, int end) {
				return start <= documentOffset && end >= documentOffset;
			}
		});
		// sort elements according to containment hierarchy
		java.util.Collections.sort(result, new java.util.Comparator<org.eclipse.emf.ecore.EObject>() {
			public int compare(org.eclipse.emf.ecore.EObject objectA, org.eclipse.emf.ecore.EObject objectB) {
				if (org.eclipse.emf.ecore.util.EcoreUtil.isAncestor(objectA, objectB)) {
					return 1;
				} else {
					if (org.eclipse.emf.ecore.util.EcoreUtil.isAncestor(objectB, objectA)) {
						return -1;
					} else {
						return 0;
					}
				}
			}
		});
		return result;
	}
	
	public java.util.List<org.eclipse.emf.ecore.EObject> getElementsBetween(final int startOffset, final int endOffset) {
		java.util.List<org.eclipse.emf.ecore.EObject> result = getElements(new ISelector() {
			public boolean accept(int start, int end) {
				return start >= startOffset && end <= endOffset;
			}
		});
		return result;
	}
	
	private java.util.List<org.eclipse.emf.ecore.EObject> getElements(ISelector s) {
		// There might be more than one element at the given offset. Thus, we collect all
		// of them and sort them afterwards.
		java.util.List<org.eclipse.emf.ecore.EObject> result = new java.util.ArrayList<org.eclipse.emf.ecore.EObject>();
		
		// We need to synchronize the write access, because other threads may iterate over
		// the map concurrently.
		synchronized (this) {
			for (org.eclipse.emf.ecore.EObject next : charStartMap.keySet()) {
				Integer start = charStartMap.get(next);
				Integer end = charEndMap.get(next);
				if (start == null || end == null) {
					continue;
				}
				if (s.accept(start, end)) {
					result.add(next);
				}
			}
		}
		java.util.Collections.sort(result, new java.util.Comparator<org.eclipse.emf.ecore.EObject>() {
			public int compare(org.eclipse.emf.ecore.EObject objectA, org.eclipse.emf.ecore.EObject objectB) {
				int lengthA = getCharEnd(objectA) - getCharStart(objectA);
				int lengthB = getCharEnd(objectB) - getCharStart(objectB);
				return lengthA - lengthB;
			}
		});
		return result;
	}
}
