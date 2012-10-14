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

import org.devboost.stanford.language.Sentence;
import org.devboost.stanford.language.impl.DocumentImpl;


public class DocumentCustom extends DocumentImpl {
	
	public int getBegin() {
		List<Sentence> sentences = getSentences();
		return sentences.get(0).getBegin();
	}

	public int getEnd() {
		List<Sentence> sentences = getSentences();
		return sentences.get(sentences.size() - 1).getEnd();
	}
}



