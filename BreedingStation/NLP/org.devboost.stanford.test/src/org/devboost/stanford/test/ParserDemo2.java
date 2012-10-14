package org.devboost.stanford.test;

import java.io.IOException;
import java.io.StringReader;
import java.util.*;

import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.ling.Word;
import edu.stanford.nlp.ling.Sentence;
import edu.stanford.nlp.process.DocumentPreprocessor;
import edu.stanford.nlp.process.Tokenizer;
import edu.stanford.nlp.trees.*;
import edu.stanford.nlp.parser.lexparser.LexicalizedParser;

class ParserDemo2 {

  /** Usage: ParserDemo2 [[grammar] textFile] */
  public static void main(String[] args) throws IOException {
    String grammar = args.length > 0 ? args[0] : "edu/stanford/nlp/models/lexparser/englishPCFG.ser.gz";
    String[] options = { "-maxLength", "80", "-retainTmpSubcategories" };
    LexicalizedParser lp = LexicalizedParser.loadModel(grammar, options);
    TreebankLanguagePack tlp = new PennTreebankLanguagePack();
    GrammaticalStructureFactory gsf = tlp.grammaticalStructureFactory();


    Iterable<List<? extends HasWord>> sentences;
    if (args.length > 1) {
      DocumentPreprocessor dp = new DocumentPreprocessor(args[1]);
      List<List<? extends HasWord>> tmp = 
        new ArrayList<List<? extends HasWord>>();
      for (List<HasWord> sentence : dp) {
        tmp.add(sentence);
      }
      sentences = tmp;
    } else {
      // Showing tokenization and parsing in code a couple of different ways.
      String[] sent = { "This", "is", "an", "easy", "sentence", "." };
      List<HasWord> sentence = new ArrayList<HasWord>();
      for (String word : sent) {
        sentence.add(new Word(word));
      }
      String sent2 = ("This is a slightly longer and more complex " +
                      "sentence requiring tokenization.");
      Tokenizer<? extends HasWord> toke = 
        tlp.getTokenizerFactory().getTokenizer(new StringReader(sent2));
      List<? extends HasWord> sentence2 = toke.tokenize();
      List<List<? extends HasWord>> tmp = 
        new ArrayList<List<? extends HasWord>>();
      tmp.add(sentence);
      tmp.add(sentence2);
      sentences = tmp;
    }

    for (List<? extends HasWord> sentence : sentences) {
      Tree parse = lp.apply(sentence);
      parse.pennPrint();
      System.out.println();
      System.out.println(parse.taggedYield());
      System.out.println();

      GrammaticalStructure gs = gsf.newGrammaticalStructure(parse);
      Collection tdl = gs.typedDependenciesCCprocessed(true);
      System.out.println(tdl);
      System.out.println();
    }

    String sent3 = "This is one last test!";
    lp.apply(sent3).pennPrint();
  }

}