/*******************************************************************************
 * Copyright (C) 2012
 * The Stanford Natural Language Processing Group 
 * http://nlp.stanford.edu/
 * This Eclipse plugin matches the Stanford CoreNLP version 1.3.3
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
package edu.stanford.nlp.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.stanford.nlp.ling.HasTag;
import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.ling.Label;
import edu.stanford.nlp.ling.CoreAnnotations.IndexAnnotation;
import edu.stanford.nlp.stats.ClassicCounter;
import edu.stanford.nlp.stats.Counter;
import edu.stanford.nlp.util.CoreMap;
import edu.stanford.nlp.util.Filter;

/** Utilities for Dependency objects.
 *
 *  @author Christopher Manning
 */
public class Dependencies {

  private Dependencies() {} // only static methods


  public static class DependentPuncTagRejectFilter<G extends Label,D extends Label,N> implements Filter<Dependency<G, D, N>> {

    private Filter<String> tagRejectFilter;

    public DependentPuncTagRejectFilter(Filter<String> trf) {
      tagRejectFilter = trf;
    }

    public boolean accept(Dependency<G, D, N> d) {
      /*
      System.err.println("DRF: Checking " + d + ": hasTag?: " +
                         (d.dependent() instanceof HasTag) + "; value: " +
                         ((d.dependent() instanceof HasTag)? ((HasTag) d.dependent()).tag(): null));
      */
      if (d == null) {
        return false;
      }
      if ( ! (d.dependent() instanceof HasTag)) {
        return false;
      }
      String tag = ((HasTag) d.dependent()).tag();
      return tagRejectFilter.accept(tag);
    }

    private static final long serialVersionUID = -7732189363171164852L;

  } // end class DependentPuncTagRejectFilter


  public static class DependentPuncWordRejectFilter<G extends Label,D extends Label,N> implements Filter<Dependency<G, D, N>> {

    /**
     *
     */
    private static final long serialVersionUID = 1166489968248785287L;
    private final Filter<String> wordRejectFilter;

    /** @param wrf A filter that rejects punctuation words.
     */
    public DependentPuncWordRejectFilter(Filter<String> wrf) {
      // System.err.println("wrf is " + wrf);
      wordRejectFilter = wrf;
    }

    public boolean accept(Dependency<G, D, N> d) {
      /*
      System.err.println("DRF: Checking " + d + ": hasWord?: " +
                         (d.dependent() instanceof HasWord) + "; value: " +
                         ((d.dependent() instanceof HasWord)? ((HasWord) d.dependent()).word(): d.dependent().value()));
      */
      if (d == null) {
        return false;
      }
      String word = null;
      if (d.dependent() instanceof HasWord) {
        word = ((HasWord) d.dependent()).word();
      }
      if (word == null) {
        word = d.dependent().value();
      }
      // System.err.println("Dep: kid is " + ((MapLabel) d.dependent()).toString("value{map}"));
      return wordRejectFilter.accept(word);
    }

  } // end class DependentPuncWordRejectFilter


  // extra class guarantees correct lazy loading (Bloch p.194)
  private static class ComparatorHolder {

    private ComparatorHolder() {}

    private static class DependencyIdxComparator implements Comparator<Dependency> {

      public int compare(Dependency dep1, Dependency dep2) {
        CoreMap dep1lab = (CoreMap) dep1.dependent();
        CoreMap dep2lab = (CoreMap) dep2.dependent();
        Integer dep1idx = dep1lab.get(IndexAnnotation.class);
        Integer dep2idx = dep2lab.get(IndexAnnotation.class);
        return dep1idx - dep2idx;
      }

    }

    private static final Comparator<Dependency> dc = new DependencyIdxComparator();

  }
  
  public static Map<TreeGraphNode,List<TypedDependency>> govToDepMap(List<TypedDependency> deps) {
    Map<TreeGraphNode,List<TypedDependency>> govToDepMap = new HashMap<TreeGraphNode,List<TypedDependency>>();
    for (TypedDependency dep : deps) {
      TreeGraphNode gov = dep.gov();
      
      List<TypedDependency> depList = govToDepMap.get(gov);
      if (depList == null) {
        depList = new ArrayList<TypedDependency>();        
        govToDepMap.put(gov, depList);
      }
      depList.add(dep);
    }
    return govToDepMap;
  }
  
  private static Set<List<TypedDependency>> getGovMaxChains(Map<TreeGraphNode,List<TypedDependency>> govToDepMap, TreeGraphNode gov, int depth) {
    Set<List<TypedDependency>> depLists = new HashSet<List<TypedDependency>>();
    List<TypedDependency> children = govToDepMap.get(gov);
    
    if (depth > 0 && children != null) {
      for (TypedDependency child : children) {
        TreeGraphNode childNode = child.dep();
        if (childNode == null) continue;
        Set<List<TypedDependency>> childDepLists = getGovMaxChains(govToDepMap, childNode, depth-1);
        if (childDepLists.size() != 0) {
          for (List<TypedDependency> childDepList : childDepLists) {
            List<TypedDependency> depList = new ArrayList<TypedDependency>(childDepList.size() + 1);
            depList.add(child);
            depList.addAll(childDepList);
            depLists.add(depList);
          }
        } else {
          depLists.add(Arrays.asList(child));
        }
      }
    }
    return depLists;
  }
  
  public static Counter<List<TypedDependency>> getTypedDependencyChains(List<TypedDependency> deps, int maxLength) {
    Map<TreeGraphNode,List<TypedDependency>> govToDepMap = govToDepMap(deps);
    Counter<List<TypedDependency>> tdc = new ClassicCounter<List<TypedDependency>>();
    for (TreeGraphNode gov : govToDepMap.keySet()) {      
      Set<List<TypedDependency>> maxChains = getGovMaxChains(govToDepMap, gov, maxLength);
      for (List<TypedDependency> maxChain : maxChains) {
         for (int i = 1; i <= maxChain.size(); i++) {
           List<TypedDependency> chain = maxChain.subList(0, i); 
           tdc.incrementCount(chain);
         }
      }     
    }
    return tdc;
  }
  
  /** A Comparator for Dependencies based on their dependent annotation.
   *  It will only work if the Labels at the ends of Dependencies have
   *  an index().
   *
   *  @return A Comparator for Dependencies
   */
  public static Comparator<Dependency> dependencyIndexComparator() {
    return ComparatorHolder.dc;
  }

}
