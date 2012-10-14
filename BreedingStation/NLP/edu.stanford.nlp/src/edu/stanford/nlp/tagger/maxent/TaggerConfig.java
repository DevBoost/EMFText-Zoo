/*******************************************************************************
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
 ******************************************************************************/
package edu.stanford.nlp.tagger.maxent;

import edu.stanford.nlp.util.StringUtils;

import java.io.*;
import java.util.HashMap;
import java.util.Properties;

import edu.stanford.nlp.io.IOUtils;

/**
 * Reads and stores configuration information for a POS tagger.
 *
 * <i>Implementation note:</i> To add a new parameter: (1) define a default
 * String value, (2) add it to defaultValues hash, (3) add line to constructor,
 * (4) add getter method, (5) add to dump() method, (6) add to printGenProps()
 * method, (7) add to class javadoc of MaxentTagger.
 *
 *  @author William Morgan
 *  @author Anna Rafferty
 *  @author Michel Galley
 */
public class TaggerConfig extends Properties /* Inherits implementation of serializable! */ {

  private static final long serialVersionUID = -4136407850147157497L;

  public enum Mode {
    TRAIN, TEST, TAG, DUMP
  }

  private Mode mode = Mode.TAG;

  /* defaults. Note: no known property has a null value! Don't need to test. */
  public static final String
  SEARCH = "qn",
  TAG_SEPARATOR = "/",
  TOKENIZE = "true",
  DEBUG = "false",
  ITERATIONS = "100",
  ARCH = "",
  WORD_FUNCTION = "",
  RARE_WORD_THRESH = "5",
  MIN_FEATURE_THRESH = "5",
  CUR_WORD_MIN_FEATURE_THRESH = "2",
  RARE_WORD_MIN_FEATURE_THRESH = "10",
  VERY_COMMON_WORD_THRESH = "250",
  OCCURRING_TAGS_ONLY = "false",
  POSSIBLE_TAGS_ONLY = "false",
  SIGMA_SQUARED = String.valueOf(0.5),
  ENCODING = "UTF-8",
  LEARN_CLOSED_CLASS = "false",
  CLOSED_CLASS_THRESHOLD = "40",
  VERBOSE = "false",
  VERBOSE_RESULTS = "true",
  SGML = "false",
  INIT_FROM_TREES = "false",
  LANG = "",
  TOKENIZER_FACTORY = "",
  XML_INPUT = "",
  TREE_TRANSFORMER = "",
  TREE_NORMALIZER = "",
  TREE_RANGE = "",
  TAG_INSIDE = "",
  APPROXIMATE = "-1.0",
  TOKENIZER_OPTIONS = "",
  DEFAULT_REG_L1 = "1.0",
  OUTPUT_FILE = "",
  OUTPUT_FORMAT = "slashTags",
  OUTPUT_FORMAT_OPTIONS = "";

  public static final String
  ENCODING_PROPERTY = "encoding",
  TAG_SEPARATOR_PROPERTY = "tagSeparator";

  private static final HashMap<String, String> defaultValues = new HashMap<String, String>();
  static {
    defaultValues.put("arch", ARCH);
    defaultValues.put("wordFunction", WORD_FUNCTION);
    defaultValues.put("closedClassTags", "");
    defaultValues.put("closedClassTagThreshold", CLOSED_CLASS_THRESHOLD);
    defaultValues.put("search", SEARCH);
    defaultValues.put(TAG_SEPARATOR_PROPERTY, TAG_SEPARATOR);
    defaultValues.put("tokenize", TOKENIZE);
    defaultValues.put("debug", DEBUG);
    defaultValues.put("iterations", ITERATIONS);
    defaultValues.put("rareWordThresh", RARE_WORD_THRESH);
    defaultValues.put("minFeatureThresh", MIN_FEATURE_THRESH);
    defaultValues.put("curWordMinFeatureThresh", CUR_WORD_MIN_FEATURE_THRESH);
    defaultValues.put("rareWordMinFeatureThresh", RARE_WORD_MIN_FEATURE_THRESH);
    defaultValues.put("veryCommonWordThresh", VERY_COMMON_WORD_THRESH);
    defaultValues.put("occurringTagsOnly", OCCURRING_TAGS_ONLY);
    defaultValues.put("possibleTagsOnly", POSSIBLE_TAGS_ONLY);
    defaultValues.put("sigmaSquared", SIGMA_SQUARED);
    defaultValues.put(ENCODING_PROPERTY, ENCODING);
    defaultValues.put("learnClosedClassTags", LEARN_CLOSED_CLASS);
    defaultValues.put("verbose", VERBOSE);
    defaultValues.put("verboseResults", VERBOSE_RESULTS);
    defaultValues.put("sgml", SGML);
    defaultValues.put("openClassTags", "");
    defaultValues.put("lang", LANG);
    defaultValues.put("tokenizerFactory", TOKENIZER_FACTORY);
    defaultValues.put("xmlInput", XML_INPUT);
    defaultValues.put("tagInside", TAG_INSIDE);
    defaultValues.put("sgml", SGML);
    defaultValues.put("approximate", APPROXIMATE);
    defaultValues.put("tokenizerOptions", TOKENIZER_OPTIONS);
    defaultValues.put("regL1", DEFAULT_REG_L1);
    defaultValues.put("outputFile", OUTPUT_FILE);
    defaultValues.put("outputFormat", OUTPUT_FORMAT);
    defaultValues.put("outputFormatOptions", OUTPUT_FORMAT_OPTIONS);
  }

  /**
   * This constructor is just for creating an instance with default values.
   * Used internally.
   */
  private TaggerConfig() {
    super();
    this.putAll(defaultValues);
  }

  /**
   * We force you to pass in a TaggerConfig rather than any other
   * superclass so that we know the arg error checking has already occurred
   */
  public TaggerConfig(TaggerConfig old) {
    super(old);
  }

  public TaggerConfig(String... args) {
    this(StringUtils.argsToProperties(args));
  }

  public TaggerConfig(Properties props) {
    super();
    if (props.getProperty("") != null) {
      throw new RuntimeException("unknown argument(s): \"" + props.getProperty("") + '\"');
    }

    if (props.getProperty("genprops") != null) {
      printGenProps(System.out);
      System.exit(0);
    }

    if (props.containsKey("trainFile")) {
      //Training mode
      mode = Mode.TRAIN;
      this.setProperty("file", props.getProperty("trainFile", "").trim());
    } else if (props.containsKey("testFile")) {
      //Testing mode
      mode = Mode.TEST;
      this.setProperty("file", props.getProperty("testFile", "").trim());
    } else if (props.containsKey("textFile")) {
      //Tagging mode
      mode = Mode.TAG;
      this.setProperty("file", props.getProperty("textFile", "").trim());
    } else if (props.containsKey("dump")) {
      mode = Mode.DUMP;
      this.setProperty("file", props.getProperty("dump").trim());
      props.setProperty("model", props.getProperty("dump").trim());
    } else {
      mode = Mode.TAG;
      this.setProperty("file", "stdin");
    }
    //for any mode other than train, we load a classifier, which means we load a config - model always needs to be specified
    //on command line/in props file
    //Get the path to the model (or the path where you'd like to save the model); this is necessary for training, testing, and tagging
    this.setProperty("model", props.getProperty("model", "").trim());
    if ( ! (mode == Mode.DUMP) && this.getProperty("model").equals("")) {
      throw new RuntimeException("'model' parameter must be specified");
    }

    /* Try and use the default properties from the model */
    //Properties modelProps = new Properties();
    TaggerConfig oldConfig = new TaggerConfig(); // loads default values in oldConfig
    if (mode != Mode.TRAIN) {
      try {
        System.err.println("Loading default properties from tagger " + getProperty("model"));
        DataInputStream in = new DataInputStream(IOUtils.getInputStreamFromURLOrClasspathOrFileSystem(getProperty("model")));
        oldConfig.putAll(TaggerConfig.readConfig(in)); // overwrites defaults with any serialized values.
        in.close();
      } catch (Exception e) {
        System.err.println("Error: No such trained tagger config file found.");
        e.printStackTrace();
      }
    }

    this.setProperty("search", props.getProperty("search", oldConfig.getProperty("search")).trim().toLowerCase());
    String srch = this.getProperty("search");
    if ( ! (srch.equals("cg") || srch.equals("iis") || srch.equals("owlqn") || srch.equals("qn"))) {
      throw new RuntimeException("'search' must be one of 'iis', 'cg', 'qn' or 'owlqn': " + srch);
    }

    this.setProperty("sigmaSquared", props.getProperty("sigmaSquared", oldConfig.getProperty("sigmaSquared")));

    this.setProperty(TAG_SEPARATOR_PROPERTY, props.getProperty(TAG_SEPARATOR_PROPERTY, oldConfig.getProperty(TAG_SEPARATOR_PROPERTY)));

    this.setProperty("iterations", props.getProperty("iterations", oldConfig.getProperty("iterations")));
    this.setProperty("rareWordThresh", props.getProperty("rareWordThresh", oldConfig.getProperty("rareWordThresh")));
    this.setProperty("minFeatureThresh", props.getProperty("minFeatureThresh", oldConfig.getProperty("minFeatureThresh")));
    this.setProperty("curWordMinFeatureThresh", props.getProperty("curWordMinFeatureThresh", oldConfig.getProperty("curWordMinFeatureThresh")));
    this.setProperty("rareWordMinFeatureThresh", props.getProperty("rareWordMinFeatureThresh", oldConfig.getProperty("rareWordMinFeatureThresh")));
    this.setProperty("veryCommonWordThresh", props.getProperty("veryCommonWordThresh", oldConfig.getProperty("veryCommonWordThresh")));
    this.setProperty("occurringTagsOnly", props.getProperty("occurringTagsOnly", oldConfig.getProperty("occurringTagsOnly")));
    this.setProperty("possibleTagsOnly", props.getProperty("possibleTagsOnly", oldConfig.getProperty("possibleTagsOnly")));

    this.setProperty("lang", props.getProperty("lang", oldConfig.getProperty("lang")));

    this.setProperty("openClassTags", props.getProperty("openClassTags", oldConfig.getProperty("openClassTags")).trim());
    this.setProperty("closedClassTags", props.getProperty("closedClassTags", oldConfig.getProperty("closedClassTags")).trim());

    this.setProperty("learnClosedClassTags", props.getProperty("learnClosedClassTags", oldConfig.getProperty("learnClosedClassTags")));

    this.setProperty("closedClassTagThreshold", props.getProperty("closedClassTagThreshold", oldConfig.getProperty("closedClassTagThreshold")));

    this.setProperty("arch", props.getProperty("arch", oldConfig.getProperty("arch")));
    if (mode == Mode.TRAIN && this.getProperty("arch").equals("")) {
      throw new IllegalArgumentException("No architecture specified; " +
                                         "set the -arch flag with " +
                                         "the features to be used");
    }

    this.setProperty("wordFunction", props.getProperty("wordFunction", oldConfig.getProperty("wordFunction")));

    this.setProperty("tokenize", props.getProperty("tokenize", oldConfig.getProperty("tokenize")));
    this.setProperty("tokenizerFactory", props.getProperty("tokenizerFactory", oldConfig.getProperty("tokenizerFactory")));

    this.setProperty("debugPrefix", props.getProperty("debugPrefix", oldConfig.getProperty("debugPrefix", "")));
    this.setProperty("debug", props.getProperty("debug", DEBUG));

    this.setProperty(ENCODING_PROPERTY, props.getProperty(ENCODING_PROPERTY, oldConfig.getProperty(ENCODING_PROPERTY)));
    this.setProperty("sgml", props.getProperty("sgml", oldConfig.getProperty("sgml")));
    this.setProperty("verbose", props.getProperty("verbose", oldConfig.getProperty("verbose")));
    this.setProperty("verboseResults", props.getProperty("verboseResults", oldConfig.getProperty("verboseResults")));

    this.setProperty("regL1", props.getProperty("regL1", oldConfig.getProperty("regL1")));

    //this is a property that is stored (not like the general properties)
    this.setProperty("xmlInput", props.getProperty("xmlInput", oldConfig.getProperty("xmlInput")).trim());

    this.setProperty("tagInside", props.getProperty("tagInside", oldConfig.getProperty("tagInside"))); //this isn't something we save from time to time
    this.setProperty("approximate", props.getProperty("approximate", oldConfig.getProperty("approximate"))); //this isn't something we save from time to time
    this.setProperty("tokenizerOptions", props.getProperty("tokenizerOptions", oldConfig.getProperty("tokenizerOptions"))); //this isn't something we save from time to time
    this.setProperty("outputFile", props.getProperty("outputFile", oldConfig.getProperty("outputFile")).trim()); //this isn't something we save from time to time
    this.setProperty("outputFormat", props.getProperty("outputFormat", oldConfig.getProperty("outputFormat")).trim()); //this isn't something we save from time to time
    this.setProperty("outputFormatOptions", props.getProperty("outputFormatOptions", oldConfig.getProperty("outputFormatOptions")).trim()); //this isn't something we save from time to time
  }


  public String getModel() { return getProperty("model"); }

  public String getJarModel() { return getProperty("jarModel"); }

  public String getFile() { return getProperty("file"); }

  public String getOutputFile() { return getProperty("outputFile"); }

  public String getOutputFormat() { return getProperty("outputFormat"); }

  public String[] getOutputOptions() { return getProperty("outputFormatOptions").split("\\s*,\\s*"); }

  public boolean getOutputVerbosity() {
    return getOutputOptionsContains("verbose");
  }

  public boolean getOutputLemmas() {
    return getOutputOptionsContains("lemmatize");
  }

  public boolean getOutputOptionsContains(String sought) {
    String[] options = getOutputOptions();
    for (String option : options) {
      if (option.equals(sought)) {
        return true;
      }
    }
    return false;
  }

  public String getSearch() { return getProperty("search"); }

  public double getSigmaSquared() { return Double.parseDouble(getProperty("sigmaSquared")); }

  public int getIterations() { return Integer.parseInt(getProperty("iterations")); }

  public int getRareWordThresh() { return Integer.parseInt(getProperty("rareWordThresh")); }

  public int getMinFeatureThresh() { return Integer.parseInt(getProperty("minFeatureThresh")); }

  public int getCurWordMinFeatureThresh() { return Integer.parseInt(getProperty("curWordMinFeatureThresh")); }

  public int getRareWordMinFeatureThresh() { return Integer.parseInt(getProperty("rareWordMinFeatureThresh")); }

  public int getVeryCommonWordThresh() { return Integer.parseInt(getProperty("veryCommonWordThresh")); }

  public boolean occurringTagsOnly() { return Boolean.parseBoolean(getProperty("occurringTagsOnly")); }

  public boolean possibleTagsOnly() { return Boolean.parseBoolean(getProperty("possibleTagsOnly")); }

  public String getLang() { return getProperty("lang"); }

  public String[] getOpenClassTags() {
    return wsvStringToStringArray(getProperty("openClassTags"));
  }

  public String[] getClosedClassTags() {
    return wsvStringToStringArray(getProperty("closedClassTags"));
  }

  private static String[] wsvStringToStringArray(String str) {
    if (str == null || str.equals("")) {
      return StringUtils.EMPTY_STRING_ARRAY;
    } else {
      return str.split("\\s+");
    }
  }

  public boolean getLearnClosedClassTags() { return Boolean.parseBoolean(getProperty("learnClosedClassTags")); }

  public int getClosedTagThreshold() { return Integer.parseInt(getProperty("closedClassTagThreshold")); }

  public String getArch() { return getProperty("arch"); }

  public String getWordFunction() { return getProperty("wordFunction"); }

  public boolean getDebug() { return Boolean.parseBoolean(getProperty("debug")); }

  public String getDebugPrefix() { return getProperty("debugPrefix"); }

  public String getTokenizerFactory() { return getProperty("tokenizerFactory"); }

  public static String getDefaultTagSeparator() { return TAG_SEPARATOR; }

  public final String getTagSeparator() { return getProperty(TAG_SEPARATOR_PROPERTY); }

  public boolean getTokenize() { return Boolean.parseBoolean(getProperty("tokenize")); }

  public String getEncoding() { return getProperty(ENCODING_PROPERTY); }

  public double getRegL1() { return Double.parseDouble(getProperty("regL1")); }

  public String[] getXMLInput() {
    return wsvStringToStringArray(getProperty("xmlInput"));
  }

  public boolean getVerbose() { return Boolean.parseBoolean(getProperty("verbose")); }

  public boolean getVerboseResults() { return Boolean.parseBoolean(getProperty("verboseResults")); }

  public boolean getSGML() { return Boolean.parseBoolean(getProperty("sgml")); }


  /** Return a regex of XML elements to tag inside of.  This may return an
   *  empty String, but never null.
   *
   * @return A regex of XML elements to tag inside of
   */
  public String getTagInside() {
    String str = getProperty("tagInside");
    if (str == null) {
      return "";
    }
    return str;
  }

  public String getTokenizerOptions() { return getProperty("tokenizerOptions"); }

  public boolean getTokenizerInvertible() {
    String tokenizerOptions = getTokenizerOptions();
    if (tokenizerOptions != null &&
        tokenizerOptions.matches("(^|.*,)invertible=true"))
      return true;
    return getOutputVerbosity() || getOutputLemmas();
  }

  /**
   * Returns a default score to be used for each tag that is incompatible with
   * the current word (e.g., the tag CC for the word "apple"). Using a default
   * score may slightly decrease performance for some languages (e.g., Chinese and
   * German), but allows the tagger to run considerably faster (since the computation
   * of the normalization term Z requires much less feature extraction). This approximation
   * does not decrease performance in English (on the WSJ). If this function returns
   * 0.0, the tagger will compute exact scores.
   *
   * @return default score
   */
  public double getDefaultScore() {
    String approx = getProperty("approximate");
    if ("false".equalsIgnoreCase(approx)) {
      return -1.0;
    } else if ("true".equalsIgnoreCase(approx)) {
      return 1.0;
    } else {
      return Double.parseDouble(approx);
    }
  }


  public void dump() { dump(new PrintWriter(System.err)); }

  public void dump(PrintStream stream) {
    PrintWriter pw = new PrintWriter(stream);
    dump(pw);
  }

  private void dump(PrintWriter pw) {
    pw.println("                   model = " + getProperty("model"));
    pw.println("                    arch = " + getProperty("arch"));
    pw.println("            wordFunction = " + getProperty("wordFunction"));
    if (mode == Mode.TRAIN) {
      pw.println("               trainFile = " + getProperty("file"));
    } else if (mode == Mode.TAG) {
      pw.println("                textFile = " + getProperty("file"));
    } else if (mode == Mode.TEST) {
      pw.println("                testFile = " + getProperty("file"));
    }

    pw.println("         closedClassTags = " + getProperty("closedClassTags"));
    pw.println(" closedClassTagThreshold = " + getProperty("closedClassTagThreshold"));
    pw.println(" curWordMinFeatureThresh = " + getProperty("curWordMinFeatureThresh"));
    pw.println("                   debug = " + getProperty("debug"));
    pw.println("             debugPrefix = " + getProperty("debugPrefix"));
    pw.println("            " + TAG_SEPARATOR_PROPERTY + " = " +
               getProperty(TAG_SEPARATOR_PROPERTY));
    pw.println("                " + ENCODING_PROPERTY + " = " +
               getProperty(ENCODING_PROPERTY));
    pw.println("              iterations = " + getProperty("iterations"));
    pw.println("                    lang = " + getProperty("lang"));
    pw.println("    learnClosedClassTags = " + getProperty("learnClosedClassTags"));
    pw.println("        minFeatureThresh = " + getProperty("minFeatureThresh"));
    pw.println("           openClassTags = " + getProperty("openClassTags"));
    pw.println("rareWordMinFeatureThresh = " + getProperty("rareWordMinFeatureThresh"));
    pw.println("          rareWordThresh = " + getProperty("rareWordThresh"));
    pw.println("                  search = " + getProperty("search"));
    pw.println("                    sgml = " + getProperty("sgml"));
    pw.println("            sigmaSquared = " + getProperty("sigmaSquared"));
    pw.println("                   regL1 = " + getProperty("regL1"));
    pw.println("               tagInside = " + getProperty("tagInside"));
    pw.println("                tokenize = " + getProperty("tokenize"));
    pw.println("        tokenizerFactory = " + getProperty("tokenizerFactory"));
    pw.println("        tokenizerOptions = " + getProperty("tokenizerOptions"));
    pw.println("                 verbose = " + getProperty("verbose"));
    pw.println("          verboseResults = " + getProperty("verboseResults"));
    pw.println("    veryCommonWordThresh = " + getProperty("veryCommonWordThresh"));
    pw.println("                xmlInput = " + getProperty("xmlInput"));
    pw.println("              outputFile = " + getProperty("outputFile"));
    pw.println("            outputFormat = " + getProperty("outputFormat"));
    pw.println("     outputFormatOptions = " + getProperty("outputFormatOptions"));
    pw.flush();
  }

  @Override
  public String toString() {
    StringWriter sw = new StringWriter(200);
    PrintWriter pw = new PrintWriter(sw);
    dump(pw);
    return sw.toString();
  }

  /**
   * This returns the sentence delimiter used when tokenizing text
   * using the tokenizer requested in this config.  In general, it is
   * assumed the tokenizer doesn't need a sentence delimiter.... if you
   * use the whitespace tokenizer, though, a newline breaks sentences.
   *
   * @return A null String unless tokenize is false and then the String
   */
  public String getSentenceDelimiter() {
    if (!getTokenize())
      return "\n";
    return null;
  }

  /**
   * Returns whether or not we should use stdin for reading when
   * tagging data.  For now, this returns true iff the filename given
   * was "stdin".
   * (TODO: kind of ugly)
   */
  public boolean useStdin() {
    return getFile().trim().equalsIgnoreCase("stdin");
  }

  /**
   * Prints out the automatically generated props file - in its own
   * method to make code above easier to read
   */
  private static void printGenProps(PrintStream out) {
    out.println("## Sample properties file for maxent tagger. This file is used for three main");
    out.println("## operations: training, testing, and tagging. It may also be used to convert");
    out.println("## an old multifile tagger to a single file tagger or to dump the contents of");
    out.println("## a model.");
    out.println("## To train or test a model, or to tag something, run:");
    out.println("##   java edu.stanford.nlp.tagger.maxent.MaxentTagger -prop <properties file>");
    out.println("## Arguments can be overridden on the commandline, e.g.:");
    out.println("##   java ....MaxentTagger -prop <properties file> -testFile /other/file ");
    out.println();

    out.println("# Model file name (created at train time; used at tag and test time)");
    out.println("# (you can leave this blank and specify it on the commandline with -model)");
    out.println("# model = ");
    out.println();

    out.println("# Path to file to be operated on (trained from, tested against, or tagged)");
    out.println("# Specify -textFile <filename> to tag text in the given file, -trainFile <filename> to");
    out.println("# to train a model using data in the given file, or -testFile <filename> to test your");
    out.println("# model using data in the given file.  Alternatively, you may specify");
    out.println("# -dump <filename> to dump the parameters stored in a model or ");
    out.println("# -convertToSingleFile <filename> to save an old, multi-file model (specified as -model)");
    out.println("# to the new single file format.  The new model will be saved in the file filename.");
    out.println("# If you choose to convert an old file, you must specify ");
    out.println("# the correct 'arch' parameter used to create the original model.");
    out.println("# trainFile = ");
    out.println();

    out.println("# Path to outputFile to write tagged output to.");
    out.println("# If empty, stdout is used.");
    out.println("# outputFile = " + OUTPUT_FILE);
    out.println();

    out.println("# Output format. One of: slashTags (default), xml, or tsv");
    out.println("# outputFormat = " + OUTPUT_FORMAT);
    out.println();

    out.println("# Output format options. Comma separated list, but");
    out.println("# currently \"lemmatize\" is the only supported option.");
    out.println("# outputFormatOptions = " + OUTPUT_FORMAT_OPTIONS);
    out.println();

    out.println("# Tag separator character that separates word and pos tags");
    out.println("# (for both training and test data) and used for");
    out.println("# separating words and tags in slashTags format output.");
    out.println("# tagSeparator = " + TAG_SEPARATOR);
    out.println();

    out.println("# Encoding format in which files are stored.  If left blank, UTF-8 is assumed.");
    out.println("# encoding = " + ENCODING);
    out.println();

    out.println("# A couple flags for controlling the amount of output:");
    out.println("# - print extra debugging information:");
    out.println("# verbose = " + VERBOSE);
    out.println("# - print intermediate results:");
    out.println("# verboseResults = " + VERBOSE_RESULTS);

    out.println("######### parameters for tag and test operations #########");
    out.println();

    out.println("# Class to use for tokenization. Default blank value means Penn Treebank");
    out.println("# tokenization.  If you'd like to just assume that tokenization has been done,");
    out.println("# and the input is whitespace-tokenized, use");
    out.println("# edu.stanford.nlp.process.WhitespaceTokenizer or set tokenize to false.");
    out.println("# tokenizerFactory = ");
    out.println();

    out.println("# Options to the tokenizer.  A comma separated list.");
    out.println("# This depends on what the tokenizer supports.");
    out.println("# For PTBTokenizer, you might try options like americanize=false");
    out.println("# or asciiQuotes (for German!).");
    out.println("# tokenizerOptions = ");
    out.println();
    out.println("# Whether to tokenize text for tag and test operations. Default is true.");
    out.println("# If false, your text must already be whitespace tokenized.");
    out.println("# tokenize = " + TOKENIZE);
    out.println();

    out.println("# Write debugging information (words, top words, unknown words). Useful for");
    out.println("# error analysis. Default is false.");
    out.println("# debug = "+ DEBUG);
    out.println();

    out.println("# Prefix for debugging output (if debug == true). Default is to use the");
    out.println("# filename from 'file'");
    out.println("# debugPrefix = ");
    out.println();

    out.println("######### parameters for training  #########");
    out.println();

    out.println("# model architecture: This is one or more comma separated strings, which");
    out.println("# specify which extractors to use. Some of them take one or more integer");
    out.println("# or string ");
    out.println("# (file path) arguments in parentheses, written as m, n, and s below:");
    out.println("# 'left3words', 'left5words', 'bidirectional', 'bidirectional5words',");
    out.println("# 'generic', 'sighan2005', 'german', 'words(m,n)', 'wordshapes(m,n)',");
    out.println("# 'biwords(m,n)', 'lowercasewords(m,n)', 'vbn(n)', distsimconjunction(s,m,n)',");
    out.println("# 'naacl2003unknowns', 'naacl2003conjunctions', 'distsim(s,m,n)',");
    out.println("# 'suffix(n)', 'prefix(n)', 'prefixsuffix(n)', 'capitalizationsuffix(n)',");
    out.println("# 'wordshapes(m,n)', 'unicodeshapes(m,n)', 'unicodeshapeconjunction(m,n)',");
    out.println("# 'lctagfeatures', 'order(k)', 'chinesedictionaryfeatures(s)'.");
    out.println("# These keywords determines the features extracted.  'generic' is language independent.");
    out.println("# distsim: Distributional similarity classes can be an added source of information");
    out.println("# about your words. An English distsim file is included, or you can use your own.");
    out.println("# arch = ");
    out.println();
    out.println("# 'wordFunction'.  A function applied to the text before training or tagging.");
    out.println("# For example, edu.stanford.nlp.util.LowercaseFunction");
    out.println("# This function turns all the words into lowercase");
    out.println("# The function must implement edu.stanford.nlp.util.Function<String, String>");
    out.println("# Blank means no preprocessing function");
    out.println("# wordFunction = ");
    out.println();


    out.println("# 'language'.  This is really the tag set which is used for the");
    out.println("# list of open-class tags, and perhaps deterministic  tag");
    out.println("# expansion). Currently we have 'english', 'arabic', 'german', 'chinese'");
    out.println("# or 'polish' predefined. For your own language, you can specify ");
    out.println("# the same information via openClassTags or closedClassTags below");
    out.println("# (only ONE of these three options may be specified). ");
    out.println("# 'english' means UPenn English treebank tags. 'german' is STTS");
    out.println("# 'chinese' is CTB, and Arabic is an expanded Bies mapping from the ATB");
    out.println("# 'polish' means some tags that some guy on the internet once used. ");
    out.println("# See the TTags class for more information.");
    out.println("# lang = ");
    out.println();

    out.println("# a space-delimited list of open-class parts of speech");
    out.println("# alternatively, you can specify language above to use a pre-defined list or specify the closed class tags (below)");
    out.println("# openClassTags = ");
    out.println();

    out.println("# a space-delimited list of closed-class parts of speech");
    out.println("# alternatively, you can specify language above to use a pre-defined list or specify the open class tags (above)");
    out.println("# closedClassTags = ");
    out.println();

    out.println("# A boolean indicating whether you would like the trained model to set POS tags as closed");
    out.println("# based on their frequency in training; default is false.  The frequency threshold can be set below. ");
    out.println("# This option is ignored if any of {openClassTags, closedClassTags, lang} are specified.");
    out.println("# learnClosedClassTags = ");
    out.println();

    out.println("# Used only if learnClosedClassTags=true.  Tags that have fewer tokens than this threshold are");
    out.println("# considered closed in the trained model.");
    out.println("# closedClassTagThreshold = ");
    out.println();

    out.println("# search method for optimization. Normally use the default 'qn'. choices: 'qn' (quasi-Newton),");
    out.println("# 'cg' (conjugate gradient, 'owlqn' (L1 regularization) or 'iis' (improved iterative scaling)");
    out.println("# search = " + SEARCH);
    out.println();

    out.println("# for conjugate gradient or quasi-Newton search, sigma-squared smoothing/regularization");
    out.println("# parameter. if left blank, the default is 0.5, which is usually okay");
    out.println("# sigmaSquared = " + SIGMA_SQUARED);
    out.println();

    out.println("# for OWLQN search, regularization");
    out.println("# parameter. if left blank, the default is 1.0, which is usually okay");
    out.println("# regL1 = " + DEFAULT_REG_L1);
    out.println();

    out.println("# For improved iterative scaling, the number of iterations, otherwise ignored");
    out.println("# iterations = " + ITERATIONS);
    out.println();

    out.println("# rare word threshold. words that occur less than this number of");
    out.println("# times are considered rare words.");
    out.println("# rareWordThresh = " + RARE_WORD_THRESH);
    out.println();

    out.println("# minimum feature threshold. features whose history appears less");
    out.println("# than this number of times are ignored.");
    out.println("# minFeatureThresh = " + MIN_FEATURE_THRESH);
    out.println();

    out.println("# current word feature threshold. words that occur more than this");
    out.println("# number of times will generate features with all of their occurring");
    out.println("# tags.");
    out.println("# curWordMinFeatureThresh = " + CUR_WORD_MIN_FEATURE_THRESH);
    out.println();

    out.println("# rare word minimum feature threshold. features of rare words whose histories");
    out.println("# appear less than this times will be ignored.");
    out.println("# rareWordMinFeatureThresh = " + RARE_WORD_MIN_FEATURE_THRESH);
    out.println();

    out.println("# very common word threshold. words that occur more than this number of");
    out.println("# times will form an equivalence class by themselves. ignored unless");
    out.println("# you are using equivalence classes.");
    out.println("# veryCommonWordThresh = " + VERY_COMMON_WORD_THRESH);
    out.println();

    out.println("# sgml = ");
    out.println("# tagInside = ");
  }

  public Mode getMode() {
    return mode;
  }


  /** Serialize the TaggerConfig.
   *
   * @param os Where to write this TaggerConfig
   * @throws IOException If any IO problems
   */
  public void saveConfig(OutputStream os) throws IOException {
    ObjectOutputStream out = new ObjectOutputStream(os);
    out.writeObject(this);
  }


  /** Read in a TaggerConfig.
   *
   * @param stream Where to read from
   * @return The TaggerConfig
   * @throws IOException Misc IOError
   * @throws ClassNotFoundException Class error
   */
  public static TaggerConfig readConfig(DataInputStream stream)
    throws IOException, ClassNotFoundException
  {
    ObjectInputStream in = new ObjectInputStream(stream);
    return (TaggerConfig) in.readObject();
  }


}
