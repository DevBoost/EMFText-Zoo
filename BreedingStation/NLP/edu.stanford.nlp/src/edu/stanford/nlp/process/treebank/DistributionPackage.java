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

import java.io.*;
import java.util.List;
import java.util.ArrayList;

import edu.stanford.nlp.io.FileSystem;

/**
 * Adds data files to a tar'd / gzip'd distribution package. Data sets marked with the DISTRIB parameter
 * in {@link ConfigParser} are added to the archive.
 * 
 * @author Spence Green
 */
public class DistributionPackage {

  private final List<String> distFiles;
  private String lastCreatedDistribution = "UNKNOWN";

  public DistributionPackage() {
    distFiles = new ArrayList<String>();
  }

  /**
   * Adds a listing of files to the distribution archive
   * 
   * @param fileList List of full file paths
   */
  public void addFiles(List<String> fileList) {
    distFiles.addAll(fileList);
  }

  /**
   * Create the distribution and name the file according to the specified parameter.
   * 
   * @param distribName The name of distribution
   * @return True if the distribution is built. False otherwise.
   */
  public boolean make(String distribName) {
    boolean createdDir = (new File(distribName)).mkdir();
    if(createdDir) {

      String currentFile = "";
      try {

        for(String filename : distFiles) {
          currentFile = filename;
          File destFile = new File(filename);
          String relativePath = distribName + "/" + destFile.getName();
          destFile = new File(relativePath);
          FileSystem.copyFile(new File(filename),destFile);
        }

        String tarFileName = String.format("%s.tar", distribName);
        Runtime r = Runtime.getRuntime();
        Process p = r.exec(String.format("tar -cf %s %s/", tarFileName, distribName));

        if(p.waitFor() == 0) {

          File tarFile = new File(tarFileName);
          FileSystem.gzipFile(tarFile, new File(tarFileName + ".gz"));
          tarFile.delete();
          FileSystem.deleteDir(new File(distribName));

          lastCreatedDistribution = distribName;

          return true;

        } else {
          System.err.printf("%s: Unable to create tar file %s\n", this.getClass().getName(),tarFileName);
        }
      } catch (IOException e) {
        System.err.printf("%s: Unable to add file %s to distribution %s\n", this.getClass().getName(),currentFile,distribName);
      } catch (InterruptedException e) {
        System.err.printf("%s: tar did not return from building %s.tar\n", this.getClass().getName(),distribName);
      }
    } else {
      System.err.printf("%s: Unable to create temp directory %s\n", this.getClass().getName(), distribName);
    }

    return false;
  }

  @Override
  public String toString() {
    String header = String.format("Distributable package %s (%d files)\n", lastCreatedDistribution,distFiles.size());
    StringBuilder sb = new StringBuilder(header);
    sb.append("--------------------------------------------------------------------\n");

    for(String filename : distFiles)
      sb.append(String.format("  %s\n", filename));

    return sb.toString();
  }

}
