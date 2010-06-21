package org.emftext.language.test;

import java.util.LinkedHashSet;
import java.util.Set;

import org.emftext.access.EMFTextAccessPlugin;
import org.emftext.language.refactoring.rolemapping.resource.rolemapping.mopp.RolemappingMetaInformation;
import org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextMetaInformation;
import org.emftext.language.refactoring.specification.resource.mopp.RefspecMetaInformation;
import org.emftext.language.theater.resource.theater.mopp.TheaterMetaInformation;
import org.emftext.language.timedautomata.resource.ta.mopp.TaMetaInformation;
import org.emftext.test.bug1233.resource.bug1233.mopp.Bug1233MetaInformation;
import org.emftext.test.printing.resource.printing.mopp.PrintingMetaInformation;
import org.reuseware.coconut.compositionprogramsyntax.resource.cpsyntax.mopp.CpsyntaxMetaInformation;
import org.reuseware.coconut.compositionsystem.resource.csys.mopp.CsysMetaInformation;
import org.reuseware.coconut.fragment.resource.fragment.mopp.FragmentMetaInformation;
import org.reuseware.coconut.reuseextension.resource.rex.mopp.RexMetaInformation;
import org.reuseware.coconut.reuseextensionactivator.resource.rexactivator.mopp.Rex_activatorMetaInformation;

public class TestLanguageRegistry {

	public void registerAllLanguages() {
		for (Object metaInformation : getAllMetaInformations()) {
			EMFTextAccessPlugin.registerConcreteSyntax(metaInformation);
		}
	}

	public Set<Object> getAllMetaInformations() {
		Set<Object> metaInformations = new LinkedHashSet<Object>();
		metaInformations.addAll(getMetaInformationsForLanguageOnUpdateSite());
		metaInformations.addAll(getMetaInformationsForInternalLanguages());
		return metaInformations;
	}

	public Set<Object> getMetaInformationsForLanguageOnUpdateSite() {
		Set<Object> metaInformations = new LinkedHashSet<Object>();
		metaInformations.add(
				new org.emftext.language.abnf.resource.abnf.mopp.AbnfMetaInformation());
		metaInformations.add(
				new org.emftext.language.chess.resource.cg.mopp.CgMetaInformation());
		metaInformations.add(
				new org.emftext.language.conference.resource.conference.mopp.ConferenceMetaInformation());
		metaInformations.add(
				new org.emftext.language.customsandwich.resource.customsandwich.mopp.CustomsandwichMetaInformation());
		metaInformations.add(
				new org.emftext.language.customer.resource.customer.mopp.CustomerMetaInformation());
		metaInformations.add(
				new org.emftext.language.csv.resource.csv.mopp.CsvMetaInformation());
		metaInformations.add(
				new org.emftext.language.dot.resource.dot.mopp.DotMetaInformation());
		metaInformations.add(
				new org.emftext.language.ecore.resource.facade.mopp.FacadeEcoreMetaInformation());
		metaInformations.add(
				new org.emftext.language.ecore.resource.text.mopp.TextEcoreMetaInformation());
		metaInformations.add(
				new org.emftext.language.efactory.resource.efactory.mopp.EfactoryMetaInformation());
		metaInformations.add(
				new org.emftext.language.featherweightjava.resource.fj.mopp.FjMetaInformation());
		metaInformations.add(
				new org.emftext.language.feature.resource.feature.mopp.FeatureMetaInformation());
		metaInformations.add(
				new org.emftext.language.formular.resource.formular.mopp.FormularMetaInformation());
		metaInformations.add(
				new org.emftext.language.forms.resource.forms.mopp.FormsMetaInformation());
		metaInformations.add(
				new org.emftext.language.java.resource.java.mopp.JavaMetaInformation());
		metaInformations.add(
				new org.emftext.language.java.javabehavior4uml.resource.javabehavior.mopp.JavabehaviorMetaInformation());
		metaInformations.add(
				new org.emftext.language.java.properties.resource.propjava.mopp.PropjavaMetaInformation());
		metaInformations.add(
				new org.emftext.language.java.reusejava.resource.reusejava.mopp.ReusejavaMetaInformation());
		metaInformations.add(
				new org.emftext.language.java.treejava.resource.treejava.mopp.TreejavaMetaInformation());
		metaInformations.add(
				new org.emftext.language.java_properties.resource.properties.mopp.PropertiesMetaInformation());
		metaInformations.add(
				new org.emftext.language.regexp.resource.regexp_antlr.mopp.Regexp_antlrMetaInformation());
		metaInformations.add(
				new org.emftext.language.regexp.resource.regexp_sdf.mopp.Regexp_sdfMetaInformation());
		metaInformations.add(
				new org.emftext.language.java.jtemplates.resource.javatemplate.mopp.JavatemplateMetaInformation());
		metaInformations.add(
				new org.emftext.language.km3.resource.km3.mopp.Km3MetaInformation());
		metaInformations.add(
				new org.emftext.language.martinfowlerdsl.resource.martinfowlerdsl.mopp.MartinfowlerdslMetaInformation());
		metaInformations.add(
				new org.emftext.language.models.resource.model.mopp.ModelMetaInformation());
		metaInformations.add(
				new org.emftext.language.office.resource.office.mopp.OfficeMetaInformation());
		metaInformations.add(
				new org.emftext.language.owl.resource.owl.mopp.OwlMetaInformation());
		metaInformations.add(
				new org.emftext.language.petrinet.resource.petrinet.mopp.PetrinetMetaInformation());
		metaInformations.add(
				new org.emftext.language.pico.resource.pico.mopp.PicoMetaInformation());
		metaInformations.add(
				new org.emftext.language.plugin.resource.topf.mopp.TopfMetaInformation());
		metaInformations.add(
				new org.emftext.language.pl0.resource.pl0.mopp.Pl0MetaInformation());
		metaInformations.add(
				new org.emftext.language.pl0extended.resource.pl0extended.mopp.Pl0extendedMetaInformation());
		metaInformations.add(
				new org.emftext.language.quickuml.resource.quml.mopp.QumlMetaInformation());
		metaInformations.add(
				new org.emftext.language.rails.resource.rails.mopp.RailsMetaInformation());
		metaInformations.add(
				new org.emftext.language.simplec.resource.c.mopp.CMetaInformation());
		metaInformations.add(
				new org.emftext.language.sandwich.resource.sandwich.mopp.SandwichMetaInformation());
		metaInformations.add(
				new org.emftext.language.secprop.resource.text.secprop.mopp.TextSecpropMetaInformation());
		metaInformations.add(
				new org.emftext.language.simplegui.resource.simplegui.mopp.SimpleguiMetaInformation());
		metaInformations.add(
				new org.emftext.language.simplemath.resource.sm.mopp.SmMetaInformation());
		metaInformations.add(
				new org.emftext.language.statemachine.resource.statemachine.mopp.StatemachineMetaInformation());
		metaInformations.add(
				new org.emftext.language.sparql.resource.sparql.mopp.RqMetaInformation());
		metaInformations.add(
				new org.emftext.language.tbool.resource.tbool.mopp.TboolMetaInformation());
		metaInformations.add(
				new org.emftext.language.tcltk.resource.tcl.mopp.TclMetaInformation());
		metaInformations.add(
				new org.emftext.language.templateconcepts.call.resource.templatecall.mopp.TemplatecallMetaInformation());
		metaInformations.add(
				new org.emftext.language.textadventure.resource.tas.mopp.TasMetaInformation());
		metaInformations.add(new TheaterMetaInformation());
		metaInformations.add(
				new org.emftext.language.threevaluedlogic.resource.tvl.mopp.TvlMetaInformation());
		metaInformations.add(
				new org.emftext.language.usecaseinvariant.resource.ucinv.mopp.UcinvMetaInformation());
		metaInformations.add(
				new org.emftext.language.valueflow.resource.valueflow.mopp.TextValueflowMetaInformation());
		metaInformations.add(
				new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsMetaInformation());
		metaInformations.add(
				new org.emftext.language.forms.resource.forms.mopp.FormsMetaInformation());
		metaInformations.add(
				new org.emftext.language.java.ejava.resource.ejava.mopp.EjavaMetaInformation());
		
		//Reuseware languages
		metaInformations.add(new RexMetaInformation());
		metaInformations.add(new CsysMetaInformation());
		metaInformations.add(new CpsyntaxMetaInformation());
		metaInformations.add(new Rex_activatorMetaInformation());
		metaInformations.add(new FragmentMetaInformation());
		
		//Refactory languages
		metaInformations.add(new RolemappingMetaInformation());
		metaInformations.add(new RolestextMetaInformation());
		metaInformations.add(new RefspecMetaInformation());
		
		return metaInformations;
	}

	public Set<Object> getMetaInformationsForInternalLanguages() {
		Set<Object> metaInformations = new LinkedHashSet<Object>();
		metaInformations.add(
				new org.emftext.language.aterms.resource.aterms.mopp.AtermsMetaInformation());
		metaInformations.add(
				new org.emftext.language.b.resource.mch.mopp.MchMetaInformation());
		metaInformations.add(
				new org.emftext.language.bool.resource.bool.mopp.BoolMetaInformation());
		metaInformations.add(
				new org.emftext.language.c_sharp.resource.csharp.mopp.CsharpMetaInformation());
		metaInformations.add(
				new org.emftext.language.filesystem.resource.fs.mopp.FsMetaInformation());
		metaInformations.add(
				new org.emftext.language.xml.resource.xml.mopp.XmlMetaInformation());
		metaInformations.add(
				new org.emftext.language.parametercheck.resource.pcheck.mopp.PcheckMetaInformation());
		metaInformations.add(
				new org.emftext.test.cct1.resource.cct1.mopp.Cct1MetaInformation());
		metaInformations.add(
				new org.emftext.test.cct2.resource.cct2.mopp.Cct2MetaInformation());
		metaInformations.add(
				new org.emftext.test.cct3.resource.cct3.mopp.Cct3MetaInformation());
		metaInformations.add(
				new org.emftext.test.cct4.resource.cct4.mopp.Cct4MetaInformation());
		metaInformations.add(
				new org.emftext.test.escaping.resource.escaping.mopp.EscapingMetaInformation());
		metaInformations.add(
				new org.emftext.test.grammar_features.resource.grammar_features.mopp.Grammar_featuresMetaInformation());
		metaInformations.add(
				new org.emftext.test.bug933.resource.bug933.mopp.Bug933MetaInformation());
		metaInformations.add(
				new org.emftext.test.bug1154.resource.bug1154.mopp.Bug1154MetaInformation());
		metaInformations.add(new Bug1233MetaInformation());
		metaInformations.add(new PrintingMetaInformation());
		metaInformations.add(new TaMetaInformation());
		return metaInformations;
	}
}
