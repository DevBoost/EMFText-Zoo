package org.devboost.stanford.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.StringReader;
import java.util.Collection;
import java.util.List;
import java.util.zip.GZIPInputStream;

import org.devboost.stanford.models.DummyClass;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.ling.Label;
import edu.stanford.nlp.ling.Sentence;
import edu.stanford.nlp.objectbank.TokenizerFactory;
import edu.stanford.nlp.parser.lexparser.LexicalizedParser;
import edu.stanford.nlp.process.CoreLabelTokenFactory;
import edu.stanford.nlp.process.DocumentPreprocessor;
import edu.stanford.nlp.process.PTBTokenizer;
import edu.stanford.nlp.trees.GrammaticalStructure;
import edu.stanford.nlp.trees.GrammaticalStructureFactory;
import edu.stanford.nlp.trees.PennTreebankLanguagePack;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TreePrint;
import edu.stanford.nlp.trees.TreebankLanguagePack;
import edu.stanford.nlp.trees.TypedDependency;

class ParserDemo {

	public static void main(String[] args) {
		try {
			InputStream resource = DummyClass.class.getResourceAsStream("englishPCFG.ser.gz");
			ObjectInputStream ois;
			ois = new ObjectInputStream(new GZIPInputStream(resource));
			LexicalizedParser lp = LexicalizedParser.loadModel(ois);

			if (args.length > 0) {
				demoDP(lp, args[0]);
			} else {
				demoAPI(lp);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void demoDP(LexicalizedParser lp, String filename) {
		// This option shows loading and sentence-segment and tokenizing
		// a file using DocumentPreprocessor
		TreebankLanguagePack tlp = new PennTreebankLanguagePack();
		GrammaticalStructureFactory gsf = tlp.grammaticalStructureFactory();
		// You could also create a tokenier here (as below) and pass it
		// to DocumentPreprocessor
		for (List<HasWord> sentence : new DocumentPreprocessor(filename)) {
			Tree parse = lp.apply(sentence);

			printTree(parse);
			      parse.pennPrint();
			System.out.println();

			GrammaticalStructure gs = gsf.newGrammaticalStructure(parse);
			Collection tdl = gs.typedDependenciesCCprocessed(true);
			System.out.println(tdl);
			List<TypedDependency> typedDependenciesCCprocessed = gs.typedDependenciesCCprocessed();
			System.out.println(typedDependenciesCCprocessed);
			Collection<TypedDependency> allTypedDependencies = gs.allTypedDependencies();
			System.out.println(allTypedDependencies);
			Collection<TypedDependency> typedDependencies = gs.typedDependencies();
			System.out.println(typedDependencies);
			List<TypedDependency> typedDependencies2 = gs.typedDependencies(true);
			System.out.println(typedDependencies2);
			Collection<TypedDependency> typedDependenciesCollapsed = gs.typedDependenciesCollapsed();
			System.out.println(typedDependenciesCollapsed);
			List<TypedDependency> typedDependenciesCollapsed2 = gs.typedDependenciesCollapsed(true);
			System.out.println(typedDependenciesCollapsed2);
			Collection<TypedDependency> typedDependenciesCollapsedTree = gs.typedDependenciesCollapsedTree();
			System.out.println(typedDependenciesCollapsedTree);
			System.out.println();
		}
	}

	/**
	 * @param parse
	 */
	private static void printTree(Tree tree) {
		printTree(tree, 0);
	}
	private static void printTree(Tree tree, int indent) {
		//System.out.println(tree.getClass().getSimpleName() + ": " + tree.nodeString() + " --> " + tree.value() + ";");
		Label label = tree.label();
		//System.out.println(label.getClass());
		if (label instanceof CoreLabel) {
			CoreLabel coreLabel = (CoreLabel) label;
			int beginPosition = coreLabel.beginPosition();
			int endPosition = coreLabel.endPosition();
			String category = coreLabel.category();
			String originalText = coreLabel.word();//originalText();
			System.out.println(getSpaces(indent) + "At " + beginPosition + ":" + endPosition + " " + originalText + " [" + category + "]");
		}

		List<Tree> children = tree.getChildrenAsList();
		for (Tree child : children) {
			printTree(child, indent + 1);
		}
	}

	/**
	 * @param indent
	 * @return
	 */
	private static String getSpaces(int indent) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < indent; i++) {
			sb.append(" ");
		}
		return sb.toString();
	}

	public static void demoAPI(LexicalizedParser lp) {
		// This option shows parsing a list of correctly tokenized words
		String[] sent = { "This", "is", "an", "easy", "sentence", "." };
		List<CoreLabel> rawWords = Sentence.toCoreLabelList(sent);
		Tree parse = lp.apply(rawWords);
		parse.pennPrint();
		System.out.println();


		// This option shows loading and using an explicit tokenizer
		String sent2 = "This is another sentence.";
		TokenizerFactory<CoreLabel> tokenizerFactory = 
				PTBTokenizer.factory(new CoreLabelTokenFactory(), "");
		List<CoreLabel> rawWords2 = 
				tokenizerFactory.getTokenizer(new StringReader(sent2)).tokenize();
		parse = lp.apply(rawWords2);

		TreebankLanguagePack tlp = new PennTreebankLanguagePack();
		GrammaticalStructureFactory gsf = tlp.grammaticalStructureFactory();
		GrammaticalStructure gs = gsf.newGrammaticalStructure(parse);
		List<TypedDependency> tdl = gs.typedDependenciesCCprocessed();
		System.out.println(tdl);
		System.out.println();

		TreePrint tp = new TreePrint("penn,typedDependenciesCollapsed");
		tp.printTree(parse);
	}

	private ParserDemo() {} // static methods only

}
