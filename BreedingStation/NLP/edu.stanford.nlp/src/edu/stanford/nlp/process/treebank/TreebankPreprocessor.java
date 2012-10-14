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

import java.util.HashMap;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

import edu.stanford.nlp.international.arabic.pipeline.ATBArabicDataset;
import edu.stanford.nlp.util.PropertiesUtils;
import edu.stanford.nlp.util.StringUtils;

/**
 * A data preparation pipeline for treebanks
 * <p>
 * A simple framework for preparing various kinds of treebank data. The original goal was to prepare the 
 * Penn Arabic Treebank (PATB) trees for parsing. This pipeline arose from the 
 * need to prepare various data sets in a uniform manner for the execution of experiments that require 
 * multiple tools. The design objectives are:
 * <ul>
 *  <li>Support multiple data input and output types
 *  <li>Allow parameterization of data sets via a plain text file
 *  <li>Support rapid, cheap lexical engineering
 *  <li>End result of processing: a folder with all data sets and a manifest of how the data was prepared
 * </ul>
 *<p>
 * These objectives are realized through three features:
 * <ul>
 *  <li>{@link ConfigParser} -- reads the plain text configuration file and creates configuration parameter objects for each data set
 *  <li>{@link Dataset} interface -- Generic interface for loading, processing, and writing datasets
 *  <li>{@link Mapper} interface -- Generic interface for applying transformations to strings (usually words and POS tags)
 * </ul>
 *<p>
 * The process for preparing arbitrary data set X is as follows:
 * <ol>
 *  <li>Add parameters to {@link ConfigParser} as necessary
 *  <li>Implement the {@link Dataset} interface for the new data set (or use one of the existing classes)
 *  <li>Implement {@link Mapper} classes as needed
 *  <li>Specify the data set parameters in a plain text file
 *  <li>Run {@link TreebankPreprocessor} using the plain text file as the argument
 * </ol>
 * 
 * @author Spence Green
 *
 */
public final class TreebankPreprocessor {

  private TreebankPreprocessor() {}

  private static String usage() {
    String cmdLineFormat = String.format("java %s [OPTIONS] config_file%n", TreebankPreprocessor.class.getName());
    StringBuilder sb = new StringBuilder(cmdLineFormat);

    //Add other parameters here
    sb.append("  -v         : Show verbose output\n");
    sb.append("  -d <name>  : Make a distributable package with the specified name\n");

    return sb.toString();
  }

  private static Dataset getDatasetClass(Properties dsParams) {
    Dataset ds = null;
    String dsType = dsParams.getProperty(ConfigParser.paramType);
    dsParams.remove(ConfigParser.paramType);
    
    try {
      if(dsType == null)
        ds = new ATBArabicDataset();
      else { 
        Class c = ClassLoader.getSystemClassLoader().loadClass(dsType);  
        ds = (Dataset) c.newInstance();
      } 
    } catch (ClassNotFoundException e) {
      System.err.printf("Dataset type %s does not exist\n", dsType);
    } catch (InstantiationException e) {
      System.err.printf("Unable to instantiate dataset type %s\n", dsType);
    } catch (IllegalAccessException e) {
      System.err.printf("Unable to access dataset type %s\n", dsType);
    }

    return ds;
  }

  private final static int MIN_ARGS = 1;

  //Command line options
  private static boolean VERBOSE = false;
  private static boolean MAKE_DISTRIB = false;
  private static String distribName = null;
  private static String configFile = null;
  private static String outputPath = null;

  public static final Map<String,Integer> optionArgDefs = new HashMap<String,Integer>();
  static {
    optionArgDefs.put("-d", 1);
    optionArgDefs.put("-v", 0);
    optionArgDefs.put("-p", 1);
  }

  private static boolean validateCommandLine(String[] args) {
    Map<String, String[]> argsMap = StringUtils.argsToMap(args,optionArgDefs);

    for(Map.Entry<String, String[]> opt : argsMap.entrySet()) {
      String key = opt.getKey();
      if(key == null) {
        continue;

      } else if(key.equals("-d")) {
        MAKE_DISTRIB = true;
        distribName = opt.getValue()[0];

      } else if(key.equals("-v")) {
        VERBOSE = true;

      } else if(key.equals("-p")) {
        outputPath = opt.getValue()[0];

      } else {
        return false;
      }
    }

    //Regular arguments
    String[] rest = argsMap.get(null);
    if(rest == null || rest.length != MIN_ARGS) {
      return false;
    } else {
      configFile = rest[0];
    }

    return true;
  }

  /**
   * Execute with no arguments for usage.
   */
  public static void main(String[] args) {

    if(!validateCommandLine(args)) {
      System.err.println(usage());
      System.exit(-1);
    }

    Date startTime = new Date();
    System.out.println("##################################");
    System.out.println("# Stanford Treebank Preprocessor #");
    System.out.println("##################################");
    System.out.printf("Start time: %s\n", startTime);
    System.out.printf("Configuration: %s\n\n", configFile);


    final ConfigParser cp = new ConfigParser(configFile);
    cp.parse();

    final DistributionPackage distrib = new DistributionPackage();

    for (Properties dsParams : cp) {
      String nameOfDataset = PropertiesUtils.hasProperty(dsParams, ConfigParser.paramName) ? dsParams.getProperty(ConfigParser.paramName) : "UN-NAMED";

      if (outputPath != null) {
        dsParams.setProperty(ConfigParser.paramOutputPath, outputPath);
      }

      Dataset ds = getDatasetClass(dsParams);
      if(ds == null) {
        System.out.printf("Unable to instantiate TYPE for dataset %s. Check the javadocs\n",nameOfDataset);
        continue;
      }

      boolean shouldDistribute = (dsParams.contains(ConfigParser.paramDistrib)) ? 
          Boolean.parseBoolean(dsParams.getProperty(ConfigParser.paramDistrib)) : false;
      dsParams.remove(ConfigParser.paramDistrib);
      
      boolean lacksRequiredOptions = !(ds.setOptions(dsParams));
      if(lacksRequiredOptions) {
        System.out.printf("Skipping dataset %s as it lacks required parameters. Check the javadocs\n", nameOfDataset);
        continue;
      }
      
      ds.build();
      
      if(shouldDistribute)
        distrib.addFiles(ds.getFilenames());
      
      if(VERBOSE)
        System.out.println(ds.toString() + "\n");
    }

    if(MAKE_DISTRIB)
      distrib.make(distribName);

    if(VERBOSE) {
      System.out.println("-->configuration details");
      System.out.println(cp.toString());

      if(MAKE_DISTRIB) {
        System.out.println("-->distribution package details");
        System.out.println(distrib.toString());
      }
    }

    Date stopTime = new Date();
    long elapsedTime = stopTime.getTime() - startTime.getTime();
    System.out.printf("Completed processing at %s\n",stopTime);
    System.out.printf("Elapsed time: %d seconds\n", (int) (elapsedTime / 1000F));
  }
}
