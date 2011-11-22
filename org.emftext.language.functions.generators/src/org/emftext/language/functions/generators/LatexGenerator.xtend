package org.emftext.language.functions.generators

import org.emftext.language.functions.FunctionSet
import org.emftext.language.functions.Function

import java.util.List

class LatexGenerator {
	
	def public String generateLatexMainFile(String filename) {
		return '''
\documentclass{article}
\usepackage{xspace}
\usepackage{longtable}
\usepackage{paralist}
\usepackage[pdfpagelayout=OneColumn,colorlinks,linkcolor=black,citecolor=black,urlcolor=black,plainpages=false,pdfpagelabels,bookmarksopen=false]{hyperref}
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
\input{�filename�_function_descriptions}

\section{Costs}
\input{�filename�_function_costs}

\end{document}
		'''.toString()
	}
	
	def public String generateFunctionDescriptions(FunctionSet functionSet) {
		var rootFunctions = functionSet.getFunctions().filter(f | f.parent == null && !f.ignored)
		var content = "";
		for (rootFunction : rootFunctions) {
			content = content + generateLatexForFunction(rootFunction, "sub")
		}
		return '''
%
% Attention: This file is generated and will be overridden.
%
� content �
'''.toString()
	}
	
	def public List<Function> getFunctions(FunctionSet functionSet, boolean addFunctionsFromSubset) {
		var list = functionSet.getFunctions().filter(f | f.parent == null && !f.ignored).toList
		if (!addFunctionsFromSubset) {
			return list
		}
		var subsets = functionSet.subsets
		for (nextSubset : subsets) {
			list.addAll(getFunctions(nextSubset, addFunctionsFromSubset));
		}
		return list
	}
	
	def public String generateFunctionCostTable(FunctionSet functionSet) {
		return '''
%
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
			� generateFunctionCosts(functionSet) �
			\rowcolor[gray]{.85}\textbf{\tablefootertotaleffort} &
			\textbf{� functionSet.totalCosts �} \\
			\hline
		\end{longtable}
	%\caption{Aufwandsabsch�tzung gegliedert nach Unterfunktionen.}
	%\label{tab:aufwand}
%\end{table}
		'''.toString()
	}
	
	def public String generateFunctionCosts(FunctionSet functionSet) {
		return '''
			� IF functionSet.eContainer != null �
			\rowcolor[gray]{.9}
			\textbf{� functionSet.readableName �} & \textbf{� functionSet.totalCosts �} (Summe) \\
			\hline
			� ENDIF �
			� var rootFunctions = getFunctions(functionSet, false) �
			� FOR rootFunction : rootFunctions �
			� generateColumnForFunction(rootFunction, "\\xspace\\xspace") �
			� ENDFOR�
			� FOR subsets : functionSet.subsets �
			� generateFunctionCosts(subsets) �
			� ENDFOR�
			\hline
		'''.toString()
	}
	
	def private String generateColumnForFunction(Function function, String prefix) {
		return '''
			�prefix� � IF !function.children.empty �\rowcolor[gray]{.95}\textbf{�ENDIF�� function.readableName �� IF !function.children.empty �}�ENDIF�&
			� IF !function.children.empty �\textbf{�ENDIF�� function.totalCosts �� IF !function.children.empty �}�ENDIF� � IF !function.children.empty �(Summe)�ENDIF�
			\\
			\hline
			� var validChildren = function.children.filter(f | !f.ignored) �
			� FOR childFunction : validChildren �
			� generateColumnForFunction(childFunction, "\\xspace\\xspace" + prefix) �
			� ENDFOR�
		'''.toString()
	}
	
	def private String generateLatexForFunction(Function function, String prefix) {
		var section = prefix + "section";
		var addLineBreak = false;
		var relatedFunctions = function.relatedFunctions;
		var linksToRelatedFunctions = "";
		for (relatedFunction : relatedFunctions) {
			linksToRelatedFunctions = linksToRelatedFunctions + relatedFunction.readableName + "~(\\ref{func:" + relatedFunction.name.replace("_", ":") + "})";
			if (relatedFunctions.indexOf(relatedFunction) < relatedFunctions.size - 1) {
				linksToRelatedFunctions = linksToRelatedFunctions + ", ";
			}
		}
		if ("subsubsubsection".equals(section)) {
			section = "paragraph";
			addLineBreak = true;
		}
		return '''
			\� section �{� function.readableName �}
			\label{func:� function.name.replace("_", ":").replace("�", "ae").replace("�", "oe").replace("�", "ue") �}
			
			% � IF addLineBreak �\newline�ENDIF�
			� IF function.children.empty �\marginpar{\tiny{� function.costs �~\timeunit}}�ENDIF�
			� function.getReadableDescription()?.replaceAll("'(.*)'", "\\\\inquotes{\\1}") �
			
			� IF !relatedFunctions.empty �\vspace{0.2cm}\noindent{\footnotesize Verwandte Funktionen: � linksToRelatedFunctions �}�ENDIF�
			
			� var validChildren = function.children.filter(f | !f.ignored) �
			� FOR childFunction : validChildren �
			� generateLatexForFunction(childFunction, ("sub" + prefix)) �
			� ENDFOR�
			'''.toString();
	}
}