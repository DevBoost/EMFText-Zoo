package org.emftext.language.feature.resource.feature;

public abstract class FeaturePrinterBase extends org.emftext.runtime.resource.impl.AbstractEMFTextPrinter {
	
	protected org.emftext.runtime.resource.ITokenResolverFactory tokenResolverFactory = new FeatureTokenResolverFactory();
	
	public FeaturePrinterBase(java.io.OutputStream o, org.emftext.runtime.resource.ITextResource resource) {
		super(o, resource);
	}
	
	protected static int matchCount(java.util.Map<java.lang.String, java.lang.Integer> featureCounter, java.util.Collection<java.lang.String> needed){
		int pos = 0;
		int neg = 0;
		
		for(java.lang.String featureName:featureCounter.keySet()){
			if(needed.contains(featureName)){
				int value = featureCounter.get(featureName);
				if (value == 0) {
					neg += 1;
				} else {
					pos += 1;
				}
			}
		}
		return neg > 0 ? -neg : pos;
	}
	
	protected void doPrint(org.eclipse.emf.ecore.EObject element, java.io.PrintWriter out, java.lang.String globaltab) {
		if (element == null || out == null) throw new java.lang.NullPointerException("Nothing to write or to write on.");
		
		if (element instanceof org.featuremapper.models.feature.FeatureModel) {
			print_org_featuremapper_models_feature_FeatureModel((org.featuremapper.models.feature.FeatureModel) element, globaltab, out);
			return;
		}
		if (element instanceof org.featuremapper.models.feature.Constraint) {
			print_org_featuremapper_models_feature_Constraint((org.featuremapper.models.feature.Constraint) element, globaltab, out);
			return;
		}
		if (element instanceof org.featuremapper.models.feature.Feature) {
			print_org_featuremapper_models_feature_Feature((org.featuremapper.models.feature.Feature) element, globaltab, out);
			return;
		}
		if (element instanceof org.featuremapper.models.feature.Group) {
			print_org_featuremapper_models_feature_Group((org.featuremapper.models.feature.Group) element, globaltab, out);
			return;
		}
		if (element instanceof org.featuremapper.models.feature.Attribute) {
			print_org_featuremapper_models_feature_Attribute((org.featuremapper.models.feature.Attribute) element, globaltab, out);
			return;
		}
		
		resource.addWarning("The cs printer can not handle " + element.eClass().getName() + " elements", element);
	}
	
	public void print_org_featuremapper_models_feature_FeatureModel(org.featuremapper.models.feature.FeatureModel element, java.lang.String outertab, java.io.PrintWriter out) {
		java.lang.String localtab = outertab;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(5);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.FEATURE_MODEL__CONSTRAINTS));
		printCountingMap.put("constraints", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.FEATURE_MODEL__ROOT));
		printCountingMap.put("root", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.FEATURE_MODEL__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.FEATURE_MODEL__CHILDREN));
		printCountingMap.put("children", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.FEATURE_MODEL__PARENT));
		printCountingMap.put("parent", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = null;
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("FeatureModel");
		out.print(" ");
		//////////////DEFINITION PART BEGINS (PlaceholderInQuotes):
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.FEATURE_MODEL__NAME));
			org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
			resolver.setOptions(getOptions());
			out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.FEATURE_MODEL__NAME), element));
			out.print(" ");
			printCountingMap.put("name",count-1);
		}
		//////////////DEFINITION PART BEGINS (CompoundDefinition):
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
		print_org_featuremapper_models_feature_FeatureModel_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		//////////////DEFINITION PART BEGINS (Containment):
		count = printCountingMap.get("root");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.FEATURE_MODEL__ROOT));
			doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			printCountingMap.put("root",count-1);
		}
	}
	public void print_org_featuremapper_models_feature_FeatureModel_0_0(org.featuremapper.models.feature.FeatureModel element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		java.lang.String localtab = outertab;
		int count;
		//////////////DEFINITION PART BEGINS (Containment):
		count = printCountingMap.get("constraints");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.FEATURE_MODEL__CONSTRAINTS));
			o = ((java.util.List<?>)o).get(((java.util.List<?>)o).size() - count);
			doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			printCountingMap.put("constraints",count-1);
		}
		//////////////DEFINITION PART BEGINS (CsString):
		out.print(";");
		out.print(" ");
	}
	public void print_org_featuremapper_models_feature_FeatureModel_0(org.featuremapper.models.feature.FeatureModel element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		java.lang.String localtab = outertab;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = null;
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("{");
		out.print(" ");
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("constraints");
		out.print(" ");
		//////////////DEFINITION PART BEGINS (CompoundDefinition):
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
		print_org_featuremapper_models_feature_FeatureModel_0_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("}");
		out.print(" ");
	}
	
	public void print_org_featuremapper_models_feature_Constraint(org.featuremapper.models.feature.Constraint element, java.lang.String outertab, java.io.PrintWriter out) {
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(2);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.CONSTRAINT__LANGUAGE));
		printCountingMap.put("language", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.CONSTRAINT__EXPRESSION));
		printCountingMap.put("expression", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("Constraint");
		out.print(" ");
		//////////////DEFINITION PART BEGINS (PlaceholderUsingDefaultToken):
		count = printCountingMap.get("language");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.CONSTRAINT__LANGUAGE));
			org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
			resolver.setOptions(getOptions());
			out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.CONSTRAINT__LANGUAGE), element));
			out.print(" ");
			printCountingMap.put("language",count-1);
		}
		//////////////DEFINITION PART BEGINS (CsString):
		out.print(":");
		out.print(" ");
		//////////////DEFINITION PART BEGINS (PlaceholderInQuotes):
		count = printCountingMap.get("expression");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.CONSTRAINT__EXPRESSION));
			org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
			resolver.setOptions(getOptions());
			out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.CONSTRAINT__EXPRESSION), element));
			out.print(" ");
			printCountingMap.put("expression",count-1);
		}
	}
	
	public void print_org_featuremapper_models_feature_Feature(org.featuremapper.models.feature.Feature element, java.lang.String outertab, java.io.PrintWriter out) {
		java.lang.String localtab = outertab;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(6);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.FEATURE__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.FEATURE__MIN_CARDINALITY));
		printCountingMap.put("minCardinality", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.FEATURE__MAX_CARDINALITY));
		printCountingMap.put("maxCardinality", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.FEATURE__ATTRIBUTES));
		printCountingMap.put("attributes", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.FEATURE__GROUPS));
		printCountingMap.put("groups", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.FEATURE__PARENT_GROUP));
		printCountingMap.put("parentGroup", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = null;
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("Feature");
		out.print(" ");
		//////////////DEFINITION PART BEGINS (PlaceholderInQuotes):
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.FEATURE__NAME));
			org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
			resolver.setOptions(getOptions());
			out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.FEATURE__NAME), element));
			out.print(" ");
			printCountingMap.put("name",count-1);
		}
		//////////////DEFINITION PART BEGINS (CompoundDefinition):
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
		print_org_featuremapper_models_feature_Feature_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		//////////////DEFINITION PART BEGINS (CompoundDefinition):
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
		print_org_featuremapper_models_feature_Feature_1(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		//////////////DEFINITION PART BEGINS (CompoundDefinition):
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
		print_org_featuremapper_models_feature_Feature_2(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
	}
	public void print_org_featuremapper_models_feature_Feature_1(org.featuremapper.models.feature.Feature element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		java.lang.String localtab = outertab;
		int count;
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("[");
		out.print(" ");
		//////////////DEFINITION PART BEGINS (Containment):
		count = printCountingMap.get("attributes");
		if (count > 0) {
			java.util.ListIterator<?> it  = ((java.util.List<?>) element.eGet(element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.FEATURE__ATTRIBUTES))).listIterator(((java.util.List<?>)element.eGet(element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.FEATURE__ATTRIBUTES))).size()-count);
			while(it.hasNext()){
				java.lang.Object o = it.next();
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("attributes",0);
		}
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("]");
		out.print(" ");
	}
	public void print_org_featuremapper_models_feature_Feature_2(org.featuremapper.models.feature.Feature element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		java.lang.String localtab = outertab;
		int count;
		//////////////DEFINITION PART BEGINS (Containment):
		count = printCountingMap.get("groups");
		if (count > 0) {
			java.util.ListIterator<?> it  = ((java.util.List<?>) element.eGet(element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.FEATURE__GROUPS))).listIterator(((java.util.List<?>)element.eGet(element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.FEATURE__GROUPS))).size()-count);
			while(it.hasNext()){
				java.lang.Object o = it.next();
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("groups",0);
		}
	}
	public void print_org_featuremapper_models_feature_Feature_0(org.featuremapper.models.feature.Feature element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		int count;
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("(");
		out.print(" ");
		//////////////DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken):
		count = printCountingMap.get("minCardinality");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.FEATURE__MIN_CARDINALITY));
			org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("INTEGER");
			resolver.setOptions(getOptions());
			out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.FEATURE__MIN_CARDINALITY), element));
			out.print(" ");
			printCountingMap.put("minCardinality",count-1);
		}
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("..");
		out.print(" ");
		//////////////DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken):
		count = printCountingMap.get("maxCardinality");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.FEATURE__MAX_CARDINALITY));
			org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("INTEGER");
			resolver.setOptions(getOptions());
			out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.FEATURE__MAX_CARDINALITY), element));
			out.print(" ");
			printCountingMap.put("maxCardinality",count-1);
		}
		//////////////DEFINITION PART BEGINS (CsString):
		out.print(")");
		out.print(" ");
	}
	
	public void print_org_featuremapper_models_feature_Group(org.featuremapper.models.feature.Group element, java.lang.String outertab, java.io.PrintWriter out) {
		java.lang.String localtab = outertab;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(4);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.GROUP__MIN_CARDINALITY));
		printCountingMap.put("minCardinality", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.GROUP__MAX_CARDINALITY));
		printCountingMap.put("maxCardinality", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.GROUP__PARENT_FEATURE));
		printCountingMap.put("parentFeature", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.GROUP__CHILD_FEATURES));
		printCountingMap.put("childFeatures", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = null;
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("Group");
		out.print(" ");
		//////////////DEFINITION PART BEGINS (CompoundDefinition):
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
		print_org_featuremapper_models_feature_Group_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		//////////////DEFINITION PART BEGINS (CompoundDefinition):
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
		print_org_featuremapper_models_feature_Group_1(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
	}
	public void print_org_featuremapper_models_feature_Group_1(org.featuremapper.models.feature.Group element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		java.lang.String localtab = outertab;
		int count;
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("{");
		out.print(" ");
		//////////////DEFINITION PART BEGINS (Containment):
		count = printCountingMap.get("childFeatures");
		if (count > 0) {
			java.util.ListIterator<?> it  = ((java.util.List<?>) element.eGet(element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.GROUP__CHILD_FEATURES))).listIterator(((java.util.List<?>)element.eGet(element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.GROUP__CHILD_FEATURES))).size()-count);
			while(it.hasNext()){
				java.lang.Object o = it.next();
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("childFeatures",0);
		}
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("}");
		out.print(" ");
	}
	public void print_org_featuremapper_models_feature_Group_0(org.featuremapper.models.feature.Group element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		int count;
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("(");
		out.print(" ");
		//////////////DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken):
		count = printCountingMap.get("minCardinality");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.GROUP__MIN_CARDINALITY));
			org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("INTEGER");
			resolver.setOptions(getOptions());
			out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.GROUP__MIN_CARDINALITY), element));
			out.print(" ");
			printCountingMap.put("minCardinality",count-1);
		}
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("..");
		out.print(" ");
		//////////////DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken):
		count = printCountingMap.get("maxCardinality");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.GROUP__MAX_CARDINALITY));
			org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("INTEGER");
			resolver.setOptions(getOptions());
			out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.GROUP__MAX_CARDINALITY), element));
			out.print(" ");
			printCountingMap.put("maxCardinality",count-1);
		}
		//////////////DEFINITION PART BEGINS (CsString):
		out.print(")");
		out.print(" ");
	}
	
	public void print_org_featuremapper_models_feature_Attribute(org.featuremapper.models.feature.Attribute element, java.lang.String outertab, java.io.PrintWriter out) {
		java.lang.String localtab = outertab;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(4);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.ATTRIBUTE__FEATURE));
		printCountingMap.put("feature", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.ATTRIBUTE__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.ATTRIBUTE__TYPE));
		printCountingMap.put("type", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.ATTRIBUTE__VALUE));
		printCountingMap.put("value", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		//////////////DEFINITION PART BEGINS (PlaceholderUsingDefaultToken):
		count = printCountingMap.get("type");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.ATTRIBUTE__TYPE));
			org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
			resolver.setOptions(getOptions());
			out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.ATTRIBUTE__TYPE), element));
			out.print(" ");
			printCountingMap.put("type",count-1);
		}
		//////////////DEFINITION PART BEGINS (PlaceholderUsingDefaultToken):
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.ATTRIBUTE__NAME));
			org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
			resolver.setOptions(getOptions());
			out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.ATTRIBUTE__NAME), element));
			printCountingMap.put("name",count-1);
		}
		//////////////DEFINITION PART BEGINS (WhiteSpaces):
		out.print(" ");
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("=");
		out.print(" ");
		//////////////DEFINITION PART BEGINS (PlaceholderInQuotes):
		count = printCountingMap.get("value");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.ATTRIBUTE__VALUE));
			org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
			resolver.setOptions(getOptions());
			out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.featuremapper.models.feature.FeaturePackage.ATTRIBUTE__VALUE), element));
			out.print(" ");
			printCountingMap.put("value",count-1);
		}
		//////////////DEFINITION PART BEGINS (LineBreak):
		localtab += "		";
		out.println();
		out.print(localtab);
	}
	
}
