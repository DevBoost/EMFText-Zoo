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
package org.devboost.stanford.language.custom;

import java.util.List;

import org.devboost.stanford.language.Word;
import org.devboost.stanford.language.impl.SentenceImpl;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;


public class SentenceCustom extends SentenceImpl {

	@Override
	public int getBegin() {
		List<Word> words = getWords();
		return words.get(0).getBegin();
	}

	@Override
	public int getEnd() {
		List<Word> words = getWords();
		return words.get(words.size() - 1).getEnd();
	}
	
	@Override
	public Word getWord(int begin, int end){
		List<Word> words = getWords();
		for (Word word : words) {
			if(word.getBegin() == begin && word.getEnd() == end){
				return word;
			}
		}
		return null;
	}
	
	public EList<Word> findWords(String wordText){
		EList<Word> foundWords = new BasicEList<Word>();
		List<Word> words = getWords();
		for (Word word : words) {
			if(word.getText().equals(wordText)){
				foundWords.add(word);
			}
		}
		return foundWords;
	}
	
}