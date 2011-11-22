package org.emftext.language.functions.generators;

import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.BooleanExtensions;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.ComparableExtensions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IntegerExtensions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xtend2.lib.StringConcatenation;
import org.emftext.language.functions.Function;
import org.emftext.language.functions.FunctionSet;

@SuppressWarnings("all")
public class LatexGenerator {
  public String generateLatexMainFile(final String filename) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\\documentclass{article}");
    _builder.newLine();
    _builder.append("\\usepackage{xspace}");
    _builder.newLine();
    _builder.append("\\usepackage{longtable}");
    _builder.newLine();
    _builder.append("\\usepackage{paralist}");
    _builder.newLine();
    _builder.append("\\usepackage[pdfpagelayout=OneColumn,colorlinks,linkcolor=black,citecolor=black,urlcolor=black,plainpages=false,pdfpagelabels,bookmarksopen=false]{hyperref}");
    _builder.newLine();
    _builder.append("\\hypersetup{pdfpagemode=UseNone,colorlinks=true} ");
    _builder.newLine();
    _builder.append("\\newcommand{\\inquotes}[1]{\\glqq#1\\grqq}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\\newcommand{\\timeunit}[0]{Days}");
    _builder.newLine();
    _builder.append("\\newcommand{\\tableheaderfunction}[0]{Function}");
    _builder.newLine();
    _builder.append("\\newcommand{\\tableheadereffort}[0]{Costs in \\timeunit}");
    _builder.newLine();
    _builder.append("\\newcommand{\\tablefootertotaleffort}[0]{Total costs}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\\makeatletter");
    _builder.newLine();
    _builder.append("\\newcounter{subsubsubsection}[subsubsection]");
    _builder.newLine();
    _builder.append("\\setcounter{subsubsubsection}{1}");
    _builder.newLine();
    _builder.append("\\setcounter{secnumdepth}{4}");
    _builder.newLine();
    _builder.append("\\setcounter{tocdepth}{4}");
    _builder.newLine();
    _builder.append("\\renewcommand{\\thesubsubsubsection}{\\thesubsubsection.\\@arabic\\c@subsubsubsection}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\\makeatother");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\\begin{document}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\\tableofcontents");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\\clearpage");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\\section{Functions}");
    _builder.newLine();
    _builder.append("\\input{");
    _builder.append(filename, "");
    _builder.append("_function_descriptions}");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\\section{Costs}");
    _builder.newLine();
    _builder.append("\\input{");
    _builder.append(filename, "");
    _builder.append("_function_costs}");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\\end{document}");
    _builder.newLine();
    String _string = _builder.toString();
    return _string;
  }
  
  public String generateFunctionDescriptions(final FunctionSet functionSet) {
      EList<Function> _functions = functionSet.getFunctions();
      final Function1<Function,Boolean> _function = new Function1<Function,Boolean>() {
          public Boolean apply(final Function f) {
            boolean _operator_and = false;
            Function _parent = f.getParent();
            boolean _operator_equals = ObjectExtensions.operator_equals(_parent, null);
            if (!_operator_equals) {
              _operator_and = false;
            } else {
              boolean _isIgnored = f.isIgnored();
              boolean _operator_not = BooleanExtensions.operator_not(_isIgnored);
              _operator_and = BooleanExtensions.operator_and(_operator_equals, _operator_not);
            }
            return ((Boolean)_operator_and);
          }
        };
      Iterable<Function> _filter = IterableExtensions.<Function>filter(_functions, _function);
      Iterable<Function> rootFunctions = _filter;
      String content = "";
      for (final Function rootFunction : rootFunctions) {
        String _generateLatexForFunction = this.generateLatexForFunction(rootFunction, "sub");
        String _operator_plus = StringExtensions.operator_plus(content, _generateLatexForFunction);
        content = _operator_plus;
      }
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("%");
      _builder.newLine();
      _builder.append("% Attention: This file is generated and will be overridden.");
      _builder.newLine();
      _builder.append("%");
      _builder.newLine();
      _builder.append(content, "");
      _builder.newLineIfNotEmpty();
      String _string = _builder.toString();
      return _string;
  }
  
  public List<Function> getFunctions(final FunctionSet functionSet) {
      EList<Function> _functions = functionSet.getFunctions();
      final Function1<Function,Boolean> _function = new Function1<Function,Boolean>() {
          public Boolean apply(final Function f) {
            boolean _operator_and = false;
            Function _parent = f.getParent();
            boolean _operator_equals = ObjectExtensions.operator_equals(_parent, null);
            if (!_operator_equals) {
              _operator_and = false;
            } else {
              boolean _isIgnored = f.isIgnored();
              boolean _operator_not = BooleanExtensions.operator_not(_isIgnored);
              _operator_and = BooleanExtensions.operator_and(_operator_equals, _operator_not);
            }
            return ((Boolean)_operator_and);
          }
        };
      Iterable<Function> _filter = IterableExtensions.<Function>filter(_functions, _function);
      List<Function> _list = IterableExtensions.<Function>toList(_filter);
      List<Function> list = _list;
      EList<FunctionSet> _subsets = functionSet.getSubsets();
      EList<FunctionSet> subsets = _subsets;
      for (final FunctionSet nextSubset : subsets) {
        List<Function> _functions_1 = this.getFunctions(nextSubset);
        CollectionExtensions.<Function>addAll(list, _functions_1);
      }
      return list;
  }
  
  public String generateFunctionCosts(final FunctionSet functionSet) {
      List<Function> _functions = this.getFunctions(functionSet);
      List<Function> rootFunctions = _functions;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("%");
      _builder.newLine();
      _builder.append("% Attention: This file is generated and will be overridden.");
      _builder.newLine();
      _builder.append("%");
      _builder.newLine();
      _builder.append("%\\begin{table}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("%\\centering");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("\\begin{longtable}{|p{9.15cm}|p{2.25cm}|}");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("\\hline");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("\\tableheaderfunction & ");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("\\tableheadereffort \\\\");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("\\hline");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("\\hline");
      _builder.newLine();
      {
        for(final Function rootFunction : rootFunctions) {
          _builder.append("\t\t\t");
          String _generateColumnForFunction = this.generateColumnForFunction(rootFunction, "");
          _builder.append(_generateColumnForFunction, "			");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t\t\t");
      _builder.append("\\hline");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("\\textbf{\\tablefootertotaleffort} &");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("\\textbf{");
      int _talCosts = functionSet.getTotalCosts();
      _builder.append(_talCosts, "			");
      _builder.append("} \\\\");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t");
      _builder.append("\\hline");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("\\end{longtable}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("%\\caption{Aufwandsabsch\u00E4tzung gegliedert nach Unterfunktionen.}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("%\\label{tab:aufwand}");
      _builder.newLine();
      _builder.append("%\\end{table}");
      _builder.newLine();
      String _string = _builder.toString();
      return _string;
  }
  
  private String generateColumnForFunction(final Function function, final String prefix) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(prefix, "");
    _builder.append(" ");
    {
      EList<Function> _children = function.getChildren();
      boolean _isEmpty = _children.isEmpty();
      boolean _operator_not = BooleanExtensions.operator_not(_isEmpty);
      if (_operator_not) {
        _builder.append("\\textbf{");
      }
    }
    String _readableName = function.getReadableName();
    _builder.append(_readableName, "");
    {
      EList<Function> _children_1 = function.getChildren();
      boolean _isEmpty_1 = _children_1.isEmpty();
      boolean _operator_not_1 = BooleanExtensions.operator_not(_isEmpty_1);
      if (_operator_not_1) {
        _builder.append("}");
      }
    }
    _builder.append("&");
    _builder.newLineIfNotEmpty();
    {
      EList<Function> _children_2 = function.getChildren();
      boolean _isEmpty_2 = _children_2.isEmpty();
      boolean _operator_not_2 = BooleanExtensions.operator_not(_isEmpty_2);
      if (_operator_not_2) {
        _builder.append("\\textbf{");
      }
    }
    int _talCosts = function.getTotalCosts();
    _builder.append(_talCosts, "");
    {
      EList<Function> _children_3 = function.getChildren();
      boolean _isEmpty_3 = _children_3.isEmpty();
      boolean _operator_not_3 = BooleanExtensions.operator_not(_isEmpty_3);
      if (_operator_not_3) {
        _builder.append("}");
      }
    }
    _builder.append(" ");
    {
      EList<Function> _children_4 = function.getChildren();
      boolean _isEmpty_4 = _children_4.isEmpty();
      boolean _operator_not_4 = BooleanExtensions.operator_not(_isEmpty_4);
      if (_operator_not_4) {
        _builder.append("(Summe)");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.append("\\\\");
    _builder.newLine();
    _builder.append("\\hline");
    _builder.newLine();
    EList<Function> _children_5 = function.getChildren();
    final Function1<Function,Boolean> _function = new Function1<Function,Boolean>() {
        public Boolean apply(final Function f) {
          boolean _isIgnored = f.isIgnored();
          boolean _operator_not = BooleanExtensions.operator_not(_isIgnored);
          return ((Boolean)_operator_not);
        }
      };
    Iterable<Function> _filter = IterableExtensions.<Function>filter(_children_5, _function);
    Iterable<Function> validChildren = _filter;
    _builder.newLineIfNotEmpty();
    {
      for(final Function childFunction : validChildren) {
        String _operator_plus = StringExtensions.operator_plus("\\xspace\\xspace", prefix);
        String _generateColumnForFunction = this.generateColumnForFunction(childFunction, _operator_plus);
        _builder.append(_generateColumnForFunction, "");
        _builder.newLineIfNotEmpty();
      }
    }
    String _string = _builder.toString();
    return _string;
  }
  
  private String generateLatexForFunction(final Function function, final String prefix) {
      String _operator_plus = StringExtensions.operator_plus(prefix, "section");
      String section = _operator_plus;
      boolean addLineBreak = false;
      EList<Function> _relatedFunctions = function.getRelatedFunctions();
      EList<Function> relatedFunctions = _relatedFunctions;
      String linksToRelatedFunctions = "";
      for (final Function relatedFunction : relatedFunctions) {
        {
          String _readableName = relatedFunction.getReadableName();
          String _operator_plus_1 = StringExtensions.operator_plus(linksToRelatedFunctions, _readableName);
          String _operator_plus_2 = StringExtensions.operator_plus(_operator_plus_1, "~(\\ref{func:");
          String _name = relatedFunction.getName();
          String _replace = _name.replace("_", ":");
          String _operator_plus_3 = StringExtensions.operator_plus(_operator_plus_2, _replace);
          String _operator_plus_4 = StringExtensions.operator_plus(_operator_plus_3, "})");
          linksToRelatedFunctions = _operator_plus_4;
          int _indexOf = relatedFunctions.indexOf(relatedFunction);
          int _size = relatedFunctions.size();
          int _operator_minus = IntegerExtensions.operator_minus(((Integer)_size), ((Integer)1));
          boolean _operator_lessThan = ComparableExtensions.<Integer>operator_lessThan(((Integer)_indexOf), ((Integer)_operator_minus));
          if (_operator_lessThan) {
            String _operator_plus_5 = StringExtensions.operator_plus(linksToRelatedFunctions, ", ");
            linksToRelatedFunctions = _operator_plus_5;
          }
        }
      }
      boolean _equals = "subsubsubsection".equals(section);
      if (_equals) {
        {
          section = "paragraph";
          addLineBreak = true;
        }
      }
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\\");
      _builder.append(section, "");
      _builder.append("{");
      String _readableName_1 = function.getReadableName();
      _builder.append(_readableName_1, "");
      _builder.append("}");
      _builder.newLineIfNotEmpty();
      _builder.append("\\label{func:");
      String _name_1 = function.getName();
      String _replace_1 = _name_1.replace("_", ":");
      String _replace_2 = _replace_1.replace("\u00E4", "ae");
      String _replace_3 = _replace_2.replace("\u00F6", "oe");
      String _replace_4 = _replace_3.replace("\u00FC", "ue");
      _builder.append(_replace_4, "");
      _builder.append("}");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("% ");
      {
        if (addLineBreak) {
          _builder.append("\\newline");
        }
      }
      _builder.newLineIfNotEmpty();
      {
        EList<Function> _children = function.getChildren();
        boolean _isEmpty = _children.isEmpty();
        if (_isEmpty) {
          _builder.append("\\marginpar{\\tiny{");
          int _costs = function.getCosts();
          _builder.append(_costs, "");
          _builder.append("~\\timeunit}}");
        }
      }
      _builder.newLineIfNotEmpty();
      String _readableDescription = function.getReadableDescription();
      String _replaceAll = _readableDescription==null?(String)null:_readableDescription.replaceAll("\'(.*)\'", "\\\\inquotes{\\1}");
      _builder.append(_replaceAll, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      {
        boolean _isEmpty_1 = relatedFunctions.isEmpty();
        boolean _operator_not = BooleanExtensions.operator_not(_isEmpty_1);
        if (_operator_not) {
          _builder.append("\\vspace{0.2cm}\\noindent{\\footnotesize Verwandte Funktionen: ");
          _builder.append(linksToRelatedFunctions, "");
          _builder.append("}");
        }
      }
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      EList<Function> _children_1 = function.getChildren();
      final Function1<Function,Boolean> _function = new Function1<Function,Boolean>() {
          public Boolean apply(final Function f) {
            boolean _isIgnored = f.isIgnored();
            boolean _operator_not = BooleanExtensions.operator_not(_isIgnored);
            return ((Boolean)_operator_not);
          }
        };
      Iterable<Function> _filter = IterableExtensions.<Function>filter(_children_1, _function);
      Iterable<Function> validChildren = _filter;
      _builder.newLineIfNotEmpty();
      {
        for(final Function childFunction : validChildren) {
          String _operator_plus_6 = StringExtensions.operator_plus("sub", prefix);
          String _generateLatexForFunction = this.generateLatexForFunction(childFunction, _operator_plus_6);
          _builder.append(_generateLatexForFunction, "");
          _builder.newLineIfNotEmpty();
        }
      }
      String _string = _builder.toString();
      return _string;
  }
}
