package org.featuremapper.models.feature.resource.feature;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.featuremapper.models.feature.FeatureModel;
import org.featuremapper.models.feature.Feature;
import org.featuremapper.models.feature.Group;
import org.featuremapper.models.feature.Constraint;
import org.featuremapper.models.feature.Attribute;
import org.featuremapper.models.feature.Annotation;
import java.util.List;
import java.util.Collection;
import java.util.ListIterator;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Map;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.reuseware.emftextedit.runtime.resource.*;
import org.reuseware.emftextedit.runtime.resource.impl.*;

public abstract class FeaturePrinterBase extends EMFTextPrinterImpl {

	protected TokenResolverFactory tokenResolverFactory = new FeatureTokenResolverFactory();
	protected EMFTextTreeAnalyser treeAnalyser = new FeatureTreeAnalyser();

	public FeaturePrinterBase(OutputStream o, TextResource resource) {

		super(o, resource);
	}

	protected static int matchCount(Map<java.lang.String, java.lang.Integer> featureCounter, Collection<java.lang.String> needed){
		int pos = 0;
		int neg = 0;

		for(String featureName:featureCounter.keySet()){
			if(needed.contains(featureName)){
				int value = featureCounter.get(featureName);
				if(value==0)
					neg+=1;
				else
					pos+=1;
			}
		}
		return neg>0?-neg:pos;
	}

	protected void doPrint(EObject element,PrintWriter out,String globaltab) {
		if (element == null||out == null) throw new NullPointerException("Nothing to write or to write on.");

		if(element instanceof FeatureModel){
			printFeatureModel((FeatureModel) element,globaltab,out);
			return;
		}
		if(element instanceof Feature){
			printFeature((Feature) element,globaltab,out);
			return;
		}
		if(element instanceof Group){
			printGroup((Group) element,globaltab,out);
			return;
		}
		if(element instanceof Constraint){
			printConstraint((Constraint) element,globaltab,out);
			return;
		}
		if(element instanceof Attribute){
			printAttribute((Attribute) element,globaltab,out);
			return;
		}
		if(element instanceof Annotation){
			printAnnotation((Annotation) element,globaltab,out);
			return;
		}

		resource.addWarning("The cs printer can not handle " + element.eClass().getName() + " elements", element);
	}

		public void printFeatureModel(FeatureModel element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(5);
			Object temp;
			temp = element.getConstraints();
			printCountingMap.put("constraints", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getRoot();
			printCountingMap.put("root", temp == null ? 0 : 1);
			temp = element.getName();
			printCountingMap.put("name", temp == null ? 0 : 1);
			temp = element.getChildren();
			printCountingMap.put("children", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getParent();
			printCountingMap.put("parent", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("FeatureModel");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printFeatureModel_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printFeatureModel_0(FeatureModel element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("constraints"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("root"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("name"));
			if (tempMatchCount > matches) {
				alt = 2;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("children"));
			if (tempMatchCount > matches) {
				alt = 3;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("parent"));
			if (tempMatchCount > matches) {
				alt = 4;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("root");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("root");
						if(count>0){
							Object o =element.getRoot();
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("root",count-1);
						}
					}
				break;
				case 2:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("name");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("name");
						if(count>0){
							Object o =element.getName();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("name"),element));
				
							printCountingMap.put("name",count-1);
						}
					}
				break;
				case 3:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("children");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("children");
						if(count>0){
							Object o =element.getChildren();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("children",count-1);
						}
					}
				break;
				case 4:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("parent");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("parent");
						if(count>0){
							Object o =element.getParent();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("parent")),element.eClass().getEStructuralFeature("parent"),element));
							printCountingMap.put("parent",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CsString):
					out.print("constraints");
					//////////////DEFINITION PART BEGINS (CsString):
					out.print(":");
					//////////////DEFINITION PART BEGINS (Containment):
					count = printCountingMap.get("constraints");
					if(count>0){
						Object o =element.getConstraints();
						o = ((List<Object>)o).get(((List<Object>)o).size()-count);
						doPrint((EObject)o,out,localtab);
						printCountingMap.put("constraints",count-1);
					}
			}
		}
		public void printFeature(Feature element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(8);
			Object temp;
			temp = element.getName();
			printCountingMap.put("name", temp == null ? 0 : 1);
			temp = element.getMinCardinality();
			printCountingMap.put("minCardinality", temp == null ? 0 : 1);
			temp = element.getMaxCardinality();
			printCountingMap.put("maxCardinality", temp == null ? 0 : 1);
			temp = element.getAttributes();
			printCountingMap.put("attributes", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getGroups();
			printCountingMap.put("groups", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getParentGroup();
			printCountingMap.put("parentGroup", temp == null ? 0 : 1);
			temp = element.getAnnotations();
			printCountingMap.put("annotations", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getConstraints();
			printCountingMap.put("constraints", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("Feature");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printFeature_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printFeature_0(Feature element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("name"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("minCardinality"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("maxCardinality"));
			if (tempMatchCount > matches) {
				alt = 2;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("attributes"));
			if (tempMatchCount > matches) {
				alt = 3;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("groups"));
			if (tempMatchCount > matches) {
				alt = 4;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("parentGroup"));
			if (tempMatchCount > matches) {
				alt = 5;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("annotations"));
			if (tempMatchCount > matches) {
				alt = 6;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("constraints"));
			if (tempMatchCount > matches) {
				alt = 7;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("minCardinality");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DefinedPlaceholder):
						count = printCountingMap.get("minCardinality");
						if(count>0){
							Object o =element.getMinCardinality();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("INTEGER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("minCardinality"),element));
				
							printCountingMap.put("minCardinality",count-1);
						}
					}
				break;
				case 2:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("maxCardinality");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DefinedPlaceholder):
						count = printCountingMap.get("maxCardinality");
						if(count>0){
							Object o =element.getMaxCardinality();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("INTEGER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("maxCardinality"),element));
				
							printCountingMap.put("maxCardinality",count-1);
						}
					}
				break;
				case 3:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("attributes");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("attributes");
						if(count>0){
							Object o =element.getAttributes();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("attributes",count-1);
						}
					}
				break;
				case 4:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("groups");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("groups");
						if(count>0){
							Object o =element.getGroups();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("groups",count-1);
						}
					}
				break;
				case 5:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("parentGroup");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("parentGroup");
						if(count>0){
							Object o =element.getParentGroup();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("parentGroup")),element.eClass().getEStructuralFeature("parentGroup"),element));
							printCountingMap.put("parentGroup",count-1);
						}
					}
				break;
				case 6:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("annotations");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("annotations");
						if(count>0){
							Object o =element.getAnnotations();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("annotations",count-1);
						}
					}
				break;
				case 7:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("constraints");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("constraints");
						if(count>0){
							Object o =element.getConstraints();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("constraints")),element.eClass().getEStructuralFeature("constraints"),element));
							printCountingMap.put("constraints",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CsString):
					out.print("name");
					//////////////DEFINITION PART BEGINS (CsString):
					out.print(":");
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("name");
					if(count>0){
						Object o =element.getName();
						TokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("name"),element));
				
						printCountingMap.put("name",count-1);
					}
			}
		}
		public void printGroup(Group element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(4);
			Object temp;
			temp = element.getMinCardinality();
			printCountingMap.put("minCardinality", temp == null ? 0 : 1);
			temp = element.getMaxCardinality();
			printCountingMap.put("maxCardinality", temp == null ? 0 : 1);
			temp = element.getParentFeature();
			printCountingMap.put("parentFeature", temp == null ? 0 : 1);
			temp = element.getChildFeatures();
			printCountingMap.put("childFeatures", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("Group");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printGroup_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printGroup_0(Group element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("minCardinality"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("maxCardinality"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("parentFeature"));
			if (tempMatchCount > matches) {
				alt = 2;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("childFeatures"));
			if (tempMatchCount > matches) {
				alt = 3;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("maxCardinality");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DefinedPlaceholder):
						count = printCountingMap.get("maxCardinality");
						if(count>0){
							Object o =element.getMaxCardinality();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("INTEGER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("maxCardinality"),element));
				
							printCountingMap.put("maxCardinality",count-1);
						}
					}
				break;
				case 2:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("parentFeature");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("parentFeature");
						if(count>0){
							Object o =element.getParentFeature();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("parentFeature")),element.eClass().getEStructuralFeature("parentFeature"),element));
							printCountingMap.put("parentFeature",count-1);
						}
					}
				break;
				case 3:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("childFeatures");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("childFeatures");
						if(count>0){
							Object o =element.getChildFeatures();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("childFeatures",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CsString):
					out.print("minCardinality");
					//////////////DEFINITION PART BEGINS (CsString):
					out.print(":");
					//////////////DEFINITION PART BEGINS (DefinedPlaceholder):
					count = printCountingMap.get("minCardinality");
					if(count>0){
						Object o =element.getMinCardinality();
						TokenResolver resolver = tokenResolverFactory.createTokenResolver("INTEGER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("minCardinality"),element));
				
						printCountingMap.put("minCardinality",count-1);
					}
			}
		}
		public void printConstraint(Constraint element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(3);
			Object temp;
			temp = element.getLanguage();
			printCountingMap.put("language", temp == null ? 0 : 1);
			temp = element.getExpression();
			printCountingMap.put("expression", temp == null ? 0 : 1);
			temp = element.getConstrainedFeatures();
			printCountingMap.put("constrainedFeatures", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("Constraint");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printConstraint_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printConstraint_0(Constraint element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("language"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("expression"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("constrainedFeatures"));
			if (tempMatchCount > matches) {
				alt = 2;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("expression");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("expression");
						if(count>0){
							Object o =element.getExpression();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("expression"),element));
				
							printCountingMap.put("expression",count-1);
						}
					}
				break;
				case 2:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("constrainedFeatures");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("constrainedFeatures");
						if(count>0){
							Object o =element.getConstrainedFeatures();
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("constrainedFeatures")),element.eClass().getEStructuralFeature("constrainedFeatures"),element));
							printCountingMap.put("constrainedFeatures",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CsString):
					out.print("language");
					//////////////DEFINITION PART BEGINS (CsString):
					out.print(":");
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("language");
					if(count>0){
						Object o =element.getLanguage();
						TokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("language"),element));
				
						printCountingMap.put("language",count-1);
					}
			}
		}
		public void printAttribute(Attribute element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(4);
			Object temp;
			temp = element.getFeature();
			printCountingMap.put("feature", temp == null ? 0 : 1);
			temp = element.getName();
			printCountingMap.put("name", temp == null ? 0 : 1);
			temp = element.getType();
			printCountingMap.put("type", temp == null ? 0 : 1);
			temp = element.getValue();
			printCountingMap.put("value", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("Attribute");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printAttribute_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printAttribute_0(Attribute element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("feature"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("name"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("type"));
			if (tempMatchCount > matches) {
				alt = 2;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("value"));
			if (tempMatchCount > matches) {
				alt = 3;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("name");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("name");
						if(count>0){
							Object o =element.getName();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("name"),element));
				
							printCountingMap.put("name",count-1);
						}
					}
				break;
				case 2:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("type");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("type");
						if(count>0){
							Object o =element.getType();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("type"),element));
				
							printCountingMap.put("type",count-1);
						}
					}
				break;
				case 3:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("value");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(":");
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("value");
						if(count>0){
							Object o =element.getValue();
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("value"),element));
				
							printCountingMap.put("value",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CsString):
					out.print("feature");
					//////////////DEFINITION PART BEGINS (CsString):
					out.print(":");
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("feature");
					if(count>0){
						Object o =element.getFeature();
						TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("feature")),element.eClass().getEStructuralFeature("feature"),element));
						printCountingMap.put("feature",count-1);
					}
			}
		}
		public void printAnnotation(Annotation element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(1);
			Object temp;
			temp = element.getFeature();
			printCountingMap.put("feature", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("Annotation");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printAnnotation_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printAnnotation_0(Annotation element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("feature");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(":");
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("feature");
			if(count>0){
				Object o =element.getFeature();
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("feature")),element.eClass().getEStructuralFeature("feature"),element));
				printCountingMap.put("feature",count-1);
			}
		}
		}
