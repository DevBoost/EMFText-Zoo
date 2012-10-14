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
package edu.stanford.nlp.process.treebank;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edu.stanford.nlp.util.Pair;

/**
 * 
 * @author Spence Green
 *
 */
public class ConfigParser implements Iterable<Properties> {

  //The parameter names and delimiter
  private static final String DELIM = "=";

  public static final String paramName = "NAME";            //Name of the dataset
  public static final String paramPath = "PATH";            //Path to files in the dataset
  public static final String paramOutputPath = "OUTPUT_PATH"; // Where to output the results
  public static final String paramSplit = "SPLIT";          //A file listing filenames in a split
  public static final String paramEncode = "OUTPUT_ENCODING";      //Preferred output encoding [Buckwalter | UTF8]
  public static final String paramMapping = "MAPPING";      //Path to an LDC-format POS tag mapping file 
  public static final String paramDistrib = "DISTRIB";      //Add to distribution or not [true | false]
  public static final String paramType = "TYPE";            //Specify the Dataset type to use
  public static final String paramFlat = "FLAT";            //Output terminals only
  public static final String paramDT = "USEDET";            //Add a determiner to the Bies tag ("Stanfordization")
  public static final String paramTagDelim = "TAGDELIM";    //Delimiter for separating words and tags in tagger datasets
  public static final String paramFileExt = "FILEEXT";      //File extension for the treebank files
  public static final String paramLexMapper = "LEXMAPPER";  //Class name for the LexMapper to use
  public static final String paramLexMapOptions = "LEXOPTS";//Option string for the lexmapper (comma-separated)
  public static final String paramNoDashTags = "NODASHTAGS";//Remove ATB dash tags
  public static final String paramAddRoot = "ADDROOT";      //Add a node "ROOT" to every tree
  public static final String paramUnEscape = "UNESCAPE";    //Remove LDC/ATB special characters from flattened output
  public static final String paramPosMapper = "POSMAPPER";	//Class name for POS mapper to use
  public static final String paramPosMapOptions = "POSOPTS";//Options string for the posmapper (comma-separated)
  public static final String paramMaxLen = "MAXLEN";        //Max yield of the trees in the data set
  public static final String paramMorph = "MORPH";          //Add the pre-terminal morphological analysis to the leaf (using the delimiter)
  public static final String paramTransform = "TVISITOR";   //Apply a custom TreeVisitor to each tree in the dataset
  
  //Absolute parameters
  private static final Pattern matchName = Pattern.compile(paramName + DELIM);
  private static final Pattern matchSplit = Pattern.compile(paramSplit + DELIM);
  private static final Pattern matchDistrib = Pattern.compile(paramDistrib + DELIM);
  private static final Pattern matchType = Pattern.compile(paramType + DELIM);
  private static final Pattern matchFlat = Pattern.compile(paramFlat + DELIM);
  private static final Pattern matchDT = Pattern.compile(paramDT + DELIM);
  private static final Pattern matchTagDelim = Pattern.compile(paramTagDelim + DELIM);
  private static final Pattern matchFileExt = Pattern.compile(paramFileExt + DELIM);
  private static final Pattern matchLexMapper = Pattern.compile(paramLexMapper + DELIM);
  private static final Pattern matchNoDashTags = Pattern.compile(paramNoDashTags + DELIM);
  private static final Pattern matchAddRoot = Pattern.compile(paramAddRoot + DELIM);
  private static final Pattern matchUnEscape = Pattern.compile(paramUnEscape + DELIM);
  private static final Pattern matchLexMapOptions = Pattern.compile(paramLexMapOptions + DELIM);
  private static final Pattern matchPosMapper = Pattern.compile(paramPosMapper + DELIM);
  private static final Pattern matchPosMapOptions = Pattern.compile(paramPosMapOptions + DELIM);
  private static final Pattern matchMaxLen = Pattern.compile(paramMaxLen + DELIM);
  private static final Pattern matchMorph = Pattern.compile(paramMorph + DELIM);
  private static final Pattern matchTransform = Pattern.compile(paramTransform + DELIM);
  
  private static final Pattern matchEncode = Pattern.compile(paramEncode + DELIM);
  private static final Pattern matchEncodeArgs = Pattern.compile("Buckwalter|UTF8");

  private static final Pattern booleanArgs = Pattern.compile("true|false");

  //Pre-fix parameters
  public static final Pattern matchPath = Pattern.compile(paramPath);
  public static final Pattern matchOutputPath = Pattern.compile(paramOutputPath);
  public static final Pattern matchMapping = Pattern.compile(paramMapping);

  //Patterns for the parser
  private static final Pattern setDelim = Pattern.compile(";;");
  private static final Pattern skipLine = Pattern.compile("^#|^\\s*$");

  //Other members
  private final List<Properties> datasetList;
  private final Map<String,Pair<Pattern,Pattern>> patternsMap;
  private final String configFile;

  public ConfigParser(String filename) {
    configFile = filename;
    datasetList = new ArrayList<Properties>();

    //For Pair<Pattern,Pattern>, the first pattern matches the parameter name
    //while the second (optionally) accepts the parameter values
    patternsMap = new HashMap<String,Pair<Pattern,Pattern>>();
    patternsMap.put(paramName, new Pair<Pattern,Pattern>(matchName,null));
    patternsMap.put(paramType, new Pair<Pattern,Pattern>(matchType,null));
    patternsMap.put(paramPath, new Pair<Pattern,Pattern>(matchPath,null));
    patternsMap.put(paramOutputPath, new Pair<Pattern,Pattern>(matchOutputPath,null));
    patternsMap.put(paramSplit, new Pair<Pattern,Pattern>(matchSplit,null));
    patternsMap.put(paramTagDelim, new Pair<Pattern,Pattern>(matchTagDelim,null));
    patternsMap.put(paramFileExt, new Pair<Pattern,Pattern>(matchFileExt,null));
    patternsMap.put(paramEncode, new Pair<Pattern,Pattern>(matchEncode,matchEncodeArgs));
    patternsMap.put(paramMapping, new Pair<Pattern,Pattern>(matchMapping,null));
    patternsMap.put(paramDistrib, new Pair<Pattern,Pattern>(matchDistrib,booleanArgs));
    patternsMap.put(paramFlat, new Pair<Pattern,Pattern>(matchFlat,booleanArgs));
    patternsMap.put(paramDT, new Pair<Pattern,Pattern>(matchDT,booleanArgs));
    patternsMap.put(paramLexMapper, new Pair<Pattern,Pattern>(matchLexMapper,null));
    patternsMap.put(paramNoDashTags, new Pair<Pattern,Pattern>(matchNoDashTags,booleanArgs));
    patternsMap.put(paramAddRoot, new Pair<Pattern,Pattern>(matchAddRoot,booleanArgs));
    patternsMap.put(paramUnEscape, new Pair<Pattern,Pattern>(matchUnEscape,booleanArgs));
    patternsMap.put(paramLexMapOptions, new Pair<Pattern,Pattern>(matchLexMapOptions,null));
    patternsMap.put(paramPosMapper, new Pair<Pattern,Pattern>(matchPosMapper,null));
    patternsMap.put(paramPosMapOptions, new Pair<Pattern,Pattern>(matchPosMapOptions,null));
    patternsMap.put(paramMaxLen, new Pair<Pattern,Pattern>(matchMaxLen,null));
    patternsMap.put(paramMorph, new Pair<Pattern,Pattern>(matchMorph,null));
    patternsMap.put(paramTransform, new Pair<Pattern,Pattern>(matchTransform,null));
  }

  public Iterator<Properties> iterator() {
    Iterator<Properties> itr = Collections.unmodifiableList(datasetList).iterator();
    return itr;
  }

  public void parse() {
    int lineNum = 0;
    try {
      LineNumberReader reader = new LineNumberReader(new FileReader(configFile));
      Properties paramsForDataset = null;

      while(reader.ready()) {
        String line = reader.readLine();
        lineNum = reader.getLineNumber(); //For exception handling

        Matcher m = skipLine.matcher(line);
        if(m.lookingAt()) continue;

        m = setDelim.matcher(line);
        if(m.matches() && paramsForDataset != null) {
          datasetList.add(paramsForDataset);
          paramsForDataset = null;
          continue;
        } else if(paramsForDataset == null) {
          paramsForDataset = new Properties();
        }

        boolean matched = false;
        for(String param : patternsMap.keySet()) {
          Pair<Pattern,Pattern> paramTemplate = patternsMap.get(param);
          Matcher paramToken = paramTemplate.first.matcher(line);

          if(paramToken.lookingAt()) {
            matched = true;
            String[] tokens = line.split(DELIM);

            if(tokens.length != 2) {
              System.err.printf("%s: Skipping malformed parameter in %s (line %d)\n", this.getClass().getName(), configFile,reader.getLineNumber());
              break;
            }

            String actualParam = tokens[0].trim();
            String paramValue = tokens[1].trim();
            if(paramTemplate.second != null) {
              paramToken = paramTemplate.second.matcher(paramValue);
              if(paramToken.matches()) {
                paramsForDataset.setProperty(actualParam, paramValue);
              } else {
                System.err.printf("%s: Skipping illegal parameter value in %s (line %d)\n", this.getClass().getName(), configFile,reader.getLineNumber());
                break;
              }
            } else {
              paramsForDataset.setProperty(actualParam, paramValue);
            }
          }
        }
        if(!matched) {
          System.err.printf("%s: Unknown token in %s (line %d)\n", this.getClass().getName(), configFile, reader.getLineNumber());
          System.exit(-1);
        }
      }

      if(paramsForDataset != null) datasetList.add(paramsForDataset);

      reader.close();

    } catch (FileNotFoundException e) {
      System.err.printf("%s: Cannot open file %s\n", this.getClass().getName(),configFile);
    } catch (IOException e) {
      System.err.printf("%s: Error reading %s (line %d)\n", this.getClass().getName(),lineNum);
    }
  }

  @Override
  public String toString() {
    final int numDatasets = datasetList.size();
    StringBuilder sb = new StringBuilder(String.format("Loaded %d datasets: \n",numDatasets));

    int dataSetNum = 1;
    for(Properties sm : datasetList) {
      if(sm.containsKey(paramName))
        sb.append(String.format(" %d: %s\n",dataSetNum++, sm.getProperty(paramName)));
      else
        sb.append(String.format(" %d: %s\n",dataSetNum++,"UNKNOWN NAME"));
    }

    return sb.toString();
  }

  public static void main(String[] args) {
    ConfigParser cp = new ConfigParser("configurations/sample.conf");
    cp.parse();

    System.out.println(cp.toString());

    for(Properties sm : cp) {
      System.out.println("--------------------");
      for(String key : sm.stringPropertyNames())
        System.out.printf(" %s: %s\n",key,sm.get(key));
    }
  }

}
