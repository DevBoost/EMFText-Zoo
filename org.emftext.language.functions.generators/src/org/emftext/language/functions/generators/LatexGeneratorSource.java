package org.emftext.language.functions.generators;

import java.util.ArrayList;
import java.util.List;

import org.emftext.language.functions.Function;
import org.emftext.language.functions.FunctionSet;

import de.devboost.commenttemplate.CommentTemplate;
import de.devboost.commenttemplate.ReplacementRule;
import de.devboost.commenttemplate.VariableAntiQuotation;

@SuppressWarnings("unused")
@VariableAntiQuotation("#%s#")
@ReplacementRule(pattern="~~u",replacement="\\u")
public class LatexGeneratorSource {

	@CommentTemplate
	public String generateLatexMainFile(String filename) {
		/*\documentclass{article}
		~~usepackage{xspace}
		~~usepackage{longtable}
		~~usepackage{paralist}
		~~usepackage[pdfpagelayout=OneColumn,colorlinks,linkcolor=black,citecolor=black,urlcolor=black,plainpages=false,pdfpagelabels,bookmarksopen=false]{hyperref}
		\hypersetup{pdfpagemode=UseNone,colorlinks=true} 
		\newcommand{\inquotes}[1]{\glqq#1\grqq}
		
		\newcommand{\timeunit}[0]{Days}
		\newcommand{\tableheaderfunction}[0]{Function}
		\newcommand{\tableheadereffort}[0]{Costs in \timeunit}
		\newcommand{\tablefootertotaleffort}[0]{Total costs}
		
		\makeatletter
		\newcounter{subsubsubsection}[subsubsection]
		\setcounter{subsubsubsection}{1}
		\setcounter{secnumdepth}{4}
		\setcounter{tocdepth}{4}
		\renewcommand{\thesubsubsubsection}{\thesubsubsection.\@arabic\c@subsubsubsection}
		
		\makeatother
		
		\begin{document}
		
		\tableofcontents
		
		\clearpage
		
		\section{Functions}
		\input{«filename»_function_descriptions}
		
		\section{Costs}
		\input{«filename»_function_costs}
		
		\end{document}
		*/
		return null;
	}
	
	@CommentTemplate
	public String generateFunctionDescriptions(FunctionSet functionSet) {
		List<Function> rootFunctions = getRootFunctions(functionSet);
		String text = "";
		for (Function rootFunction : rootFunctions) {
			text = text + generateLatexForFunction(rootFunction, "sub");
		}
		/*%
		% Attention: This file is generated and will be overridden.
		%
		#text#
		*/
		return null;
	}

	@CommentTemplate
	public String generateFunctionCostTable(FunctionSet functionSet) {
		String totalCosts = Integer.toString(functionSet.getTotalCosts());
		String functionCosts = generateFunctionCosts(functionSet);
		/*%
		% Attention: This file is generated and will be overridden.
		%
		%\begin{table}
			%\centering
				\begin{longtable}{|p{9.15cm}|p{2.25cm}|}
					\hline
					\tableheaderfunction & 
					\tableheadereffort \\
					\hline
					\hline
					#functionCosts#
					\rowcolor[gray]{.85}\textbf{\tablefootertotaleffort} &
					\textbf{#totalCosts#} \\
					\hline
				\end{longtable}
			%\caption{Aufwandsabschätzung gegliedert nach Unterfunktionen.}
			%\label{tab:aufwand}
		%\end{table}
		*/
		return null;
	}
	
	@CommentTemplate
	public String generateFunctionCosts(FunctionSet functionSet) {
		String totalCosts = Integer.toString(functionSet.getTotalCosts());
		String readableName = functionSet.getReadableName();
		/**/
		if (functionSet.eContainer() != null) {
/*			\rowcolor[gray]{.9}
			\textbf{#readableName#} & \textbf{#totalCosts#} (Summe) \\
			\hline
*/
		}
		List<Function> rootFunctions = getFunctions(functionSet, false);
		for (Function rootFunction : rootFunctions) {
			String column = generateColumnForFunction(rootFunction, "\\xspace\\xspace");
/*			#column#
*/
		}
		for (FunctionSet subset : functionSet.getSubsets()) {
			String costs = generateFunctionCosts(subset);
/*			#costs#
*/
		}
/*		\hline
		*/
		return null;
	}
	
	@CommentTemplate
	public String generateColumnForFunction(Function function, String prefix) {
		boolean hasChildren = !function.getChildren().isEmpty();
		String readableName = function.getReadableName();
		String totalCosts = Integer.toString(function.getTotalCosts());
		/*
		#prefix# */
		if (hasChildren) {
			/*\rowcolor[gray]{.95}\textbf{*/
		}
		/* #readableName# */
		if (hasChildren) {
			/*}*/
		}
		/*&*/
		if (hasChildren) {
			/*\textbf{*/
		}
		/*#totalCosts#*/
		if (hasChildren) {
			/*}*/
		}
		if (hasChildren) {
			/* ($\sum$)*/
		}
		/*\\
		\hline
		*/
		List<Function> validChildren = getValidChildFunctions(function);
		for (Function childFunction : validChildren) {
			String column = generateColumnForFunction(childFunction, "\\xspace\\xspace" + prefix);
			/*#column#*/
		}
		return null;
	}
	
	@CommentTemplate
	public String generateLatexForFunction(Function function, String prefix) {
		String section = prefix + "section";
		boolean addLineBreak = false;
		List<Function> relatedFunctions = function.getRelatedFunctions();
		String linksToRelatedFunctions = "";
		for (Function relatedFunction : relatedFunctions) {
			linksToRelatedFunctions = linksToRelatedFunctions + relatedFunction.getReadableName() + "~(\\ref{func:" + relatedFunction.getName().replace("_", ":") + "})";
			if (relatedFunctions.indexOf(relatedFunction) < relatedFunctions.size() - 1) {
				linksToRelatedFunctions = linksToRelatedFunctions + ", ";
			}
		}
		if ("subsubsubsection".equals(section)) {
			section = "paragraph";
			addLineBreak = true;
		}
		String readableName = function.getReadableName();
		String name = function.getName();
		String label = name.replace("_", ":").replace("ä", "ae").replace("ö", "oe").replace("ü", "ue").replace("Ä", "AE").replace("Ö", "OE").replace("Ü", "UE").replace("ß", "ss");
		/*
			\#section#{#readableName#}
			\label{func:#label#}
			
			*/
		if (addLineBreak) {
			/*\newline */
		}
		if (function.getChildren().isEmpty()) {
			String costs = Integer.toString(function.getCosts());
			/*\marginpar{\tiny{#costs#~\timeunit}}*/
		}
		String readableDescription = function.getReadableDescription();
		String description = readableDescription == null ? "" : readableDescription.replaceAll("'(.*)'", "\\\\inquotes{\\1}");
		/* #description# */
		
		if (!relatedFunctions.isEmpty()) {
			/*\vspace{0.2cm}\noindent{\footnotesize Verwandte Funktionen: #linksToRelatedFunctions#}*/
		}
			
		List<Function> validChildren = getValidChildFunctions(function);
		for (Function childFunction : validChildren) {
			String subText = generateLatexForFunction(childFunction, ("sub" + prefix));
			/*#subText#*/
		}
		return null;
	}

	private List<Function> getValidChildFunctions(Function function) {
		List<Function> validChildren = new ArrayList<Function>();
		for (Function child : function.getChildren()) {
			if (!child.isIgnored()) {
				validChildren.add(child);
			}
		}
		return validChildren;
	}

	public List<Function> getFunctions(FunctionSet functionSet, boolean addFunctionsFromSubset) {
		List<Function> list = getRootFunctions(functionSet);
		if (!addFunctionsFromSubset) {
			return list;
		}
		List<FunctionSet> subsets = functionSet.getSubsets();
		for (FunctionSet nextSubset : subsets) {
			list.addAll(getFunctions(nextSubset, addFunctionsFromSubset));
		}
		return list;
	}

	private List<Function> getRootFunctions(FunctionSet functionSet) {
		List<Function> rootFunctions = new ArrayList<Function>();
		for (Function function : functionSet.getFunctions()) {
			if (function.getParent() == null && !function.isIgnored()) {
				rootFunctions.add(function);
			}
		}
		return rootFunctions;
	}
	}
