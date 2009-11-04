package org.emftext.language.test;

import org.emftext.access.EMFTextAccessPlugin;

public class TestLanguageRegistry {

	public void registerAllLanguages() {
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.aterms.resource.aterms.mopp.AtermsMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.b.resource.mch.mopp.MchMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.bool.resource.bool.mopp.BoolMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.c_sharp.resource.csharp.mopp.CsharpMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.chess.resource.cg.mopp.CgMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.conference.resource.conference.mopp.ConferenceMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.custom_sandwich.resource.custom_sandwich.mopp.Custom_sandwichMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.customer.resource.customer.mopp.CustomerMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.csv.resource.csv.mopp.CsvMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.dot.resource.dot.mopp.DotMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.ecore.resource.facade.mopp.FacadeEcoreMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.ecore.resource.text.mopp.TextEcoreMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.featherweight_java.resource.fj.mopp.FjMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.filesystem.resource.fs.mopp.FsMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.xml.resource.xml.mopp.XmlMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.feature.resource.feature.mopp.FeatureMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.formular.resource.formular.mopp.FormularMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.forms.resource.forms.mopp.FormsMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.java.resource.java.mopp.JavaMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.java.javabehavior4uml.resource.javabehavior.mopp.JavabehaviorMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.java.properties.resource.propjava.mopp.PropjavaMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.java.reusejava.resource.reusejava.mopp.ReusejavaMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.java.treejava.resource.treejava.mopp.TreejavaMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.regexp.resource.regexp.mopp.RegexpMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.java_templates.resource.java_template.mopp.Java_templateMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.km3.resource.km3.mopp.Km3MetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.martinfowlerdsl.resource.martinfowlerdsl.mopp.MartinfowlerdslMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.models.resource.model.mopp.ModelMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.office.resource.office.mopp.OfficeMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.owl.resource.owl.mopp.OwlMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.parametercheck.resource.pcheck.mopp.PcheckMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.petrinet.resource.petrinet.mopp.PetrinetMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.pico.resource.pico.mopp.PicoMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.plugin.resource.topf.mopp.TopfMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.quickuml.resource.quml.mopp.QumlMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.rails.resource.rails.mopp.RailsMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.simple_c.resource.c.mopp.CMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.sandwich.resource.sandwich.mopp.SandwichMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.sparql.resource.sparql.mopp.SparqlMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.simple_gui.resource.simplegui.mopp.SimpleguiMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.simple_math.resource.sm.mopp.SmMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.statemachine.resource.statemachine.mopp.StatemachineMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.tbool.resource.tbool.mopp.TboolMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.template_concepts.call.resource.template_call.mopp.Template_callMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.textadventure.resource.tas.mopp.TasMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.threevaluedlogic.resource.tvl.mopp.TvlMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.usecaseinvariant.resource.ucinv.mopp.UcinvMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.valueflow.resource.valueflow.mopp.TextValueflowMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.forms.resource.forms.mopp.FormsMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.java.ejava.resource.ejava.mopp.EjavaMetaInformation());
	}
}
