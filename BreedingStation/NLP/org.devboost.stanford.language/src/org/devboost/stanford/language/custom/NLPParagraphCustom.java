package org.devboost.stanford.language.custom;

import java.util.List;

import org.devboost.stanford.language.Sentence;
import org.devboost.stanford.language.impl.NLPParagraphImpl;


public class NLPParagraphCustom extends NLPParagraphImpl {
	
	public int getBegin() {
		List<Sentence> sentences = getSentences();
		return sentences.get(0).getBegin();
	}

	public int getEnd() {
		List<Sentence> sentences = getSentences();
		return sentences.get(sentences.size() - 1).getEnd();
	}
}



