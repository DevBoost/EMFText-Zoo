/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.language.sparql.test;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.emftext.language.sparql.SparqlQueries;
import org.emftext.language.sparql.resource.sparql.mopp.RqResource;
import org.junit.Test;

public class SparqlTest extends AbstractSparqlTestCase {

	private static final String USERDIR=System.getProperty("user.dir") + File.separator;
	private static final String INPUT="input";
	private int parsed;
	private List<String> notParsed = new ArrayList<String>();
	private static List<String> log = new ArrayList<String>(); 
	
	@Override
	public String getTestInputFolder() {
		return USERDIR+INPUT+ File.separator;
	}
	@Override
	public void setUp() {
		parsed=0;
		notParsed=new ArrayList<String>();
	}
	
	private void testDirecory(File inputDir)throws Exception{		
		parseAllSubItems(inputDir);
		int files=parsed+notParsed.size();
		System.out.println("Dir: "+ inputDir.getAbsolutePath());
		System.out.println("Files: "+ files +"  successful: "+parsed+ "  with Errors: "+ notParsed.size()+"\n");
		if (!notParsed.isEmpty()) {
			for (String file : notParsed) {
				log("File " + file + " was not parsed.");
			}
		}
		assertEquals("Not all Files parseable:", files, parsed);
	}
	
	private void log(String string) {
		this.log.add(string);
	}
	
	private void parseAllSubItems(File folder)throws Exception{
		File[] allFiles = folder.listFiles();
		
		for (File next : allFiles) {
			if (next.isFile() && next.getName().endsWith(".rq") && !next.getName().contains("syn-bad")){
				//wrapFile(next);
				RqResource sRes = loadResourceWithoutAssert(URI.createFileURI(next.getCanonicalPath()));
				if(sRes != null && sRes.getErrors().size() == 0) parsed++;
				else {
					notParsed.add(next.getAbsolutePath());
					System.out.println("in dir "+folder.getPath()+"\n");
				}
			}else if(next.isDirectory()) parseAllSubItems(next);
		}
	}
	
	//funktioniert nicht richtig da arq.qparse die JavaVM einfach beendet bei einem Fehler
	//Dieser fehler lässt sich nicht abfangen
	public void wrapFile(File file) throws Exception{
		BufferedReader br;		
		br = new BufferedReader(new FileReader(file));			
		String content = "";
		String input = "";
		while((input = br.readLine()) != null) {
			content += input + "\n";
		}
		String[] args = {content} ; 
		
		
		PrintStream old_ps = System.out;
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		System.setOut(new PrintStream(bout));
		
		arq.qparse.main(args);
		
		System.setOut(old_ps);
		String b = bout.toString().replace(" ", "").replace("\r", "").replace("\n", "");
		String c = content.toString().replace(" ", "").replace("\n", "");
		if (!b.equals(c)) System.out.println("Syntax errors in File "+file.getAbsolutePath());
	}
	
	
	
	@Test
	public void testHelloworld() throws Exception {
		String typename = "hellowolrd";
		String filename = typename + getFileExtension();
		
		wrapFile(new File(getTestInputFolder()+filename));
		
		SparqlQueries sQuer = assertParsesToSparqlQueries(typename);
		
		
	
	}
	
	
    /*
	@Test
	public void testAllFilesOfTestcasesDawg() throws Exception{
		testDirecory(new File(getTestInputFolder()+ "testcases-dawg/"));
	}
	*/
	@Test
	public void testSamples() throws Exception{
		testDirecory(new File(getTestInputFolder()+ "Samples"));
	}
	@Test
	public void testDAWG_algebra() throws Exception{
		testDirecory(new File(getTestInputFolder()+ "testcases-dawg/data-r2/algebra/"));
	}
	@Test
	public void testDAWG_ask() throws Exception{
		testDirecory(new File(getTestInputFolder()+ "testcases-dawg/data-r2/ask/"));
	}
	@Test
	public void testDAWG_basic() throws Exception{
		testDirecory(new File(getTestInputFolder()+ "testcases-dawg/data-r2/basic/"));
	}
	@Test
	public void testDAWG_bnode_coreference() throws Exception{
		testDirecory(new File(getTestInputFolder()+ "testcases-dawg/data-r2/bnode-coreference/"));
	}
	@Test
	public void testDAWG_boolean_effective_value() throws Exception{
		testDirecory(new File(getTestInputFolder()+ "testcases-dawg/data-r2/boolean-effective-value/"));
	}
	@Test
	public void testDAWG_bound() throws Exception{
		testDirecory(new File(getTestInputFolder()+ "testcases-dawg/data-r2/bound/"));
	}
	@Test
	public void testDAWG_cast() throws Exception{
		testDirecory(new File(getTestInputFolder()+ "testcases-dawg/data-r2/cast/"));
	}
	@Test
	public void testDAWG_construct() throws Exception{
		testDirecory(new File(getTestInputFolder()+ "testcases-dawg/data-r2/construct/"));
	}
	@Test
	public void testDAWG_dataset() throws Exception{
		testDirecory(new File(getTestInputFolder()+ "testcases-dawg/data-r2/dataset/"));
	}
	@Test
	public void testDAWG_distinct() throws Exception{
		testDirecory(new File(getTestInputFolder()+ "testcases-dawg/data-r2/distinct/"));
	}
	@Test
	public void testDAWG_expr_builtin() throws Exception{
		testDirecory(new File(getTestInputFolder()+ "testcases-dawg/data-r2/expr-builtin/"));
	}
	@Test
	public void testDAWG_expr_equals() throws Exception{
		testDirecory(new File(getTestInputFolder()+ "testcases-dawg/data-r2/ask/"));
	}
	@Test
	public void testDAWG_expr_ops() throws Exception{
		testDirecory(new File(getTestInputFolder()+ "testcases-dawg/data-r2/expr-ops/"));
	}
	@Test
	public void testDAWG_graph() throws Exception{
		testDirecory(new File(getTestInputFolder()+ "testcases-dawg/data-r2/graph/"));
	}
	@Test
	public void testDAWG_i18n() throws Exception{
		testDirecory(new File(getTestInputFolder()+ "testcases-dawg/data-r2/i18n/"));
	}
	@Test
	public void testDAWG_open_world() throws Exception{
		testDirecory(new File(getTestInputFolder()+ "testcases-dawg/data-r2/open-world/"));
	}
	@Test
	public void testDAWG_optional() throws Exception{
		testDirecory(new File(getTestInputFolder()+ "testcases-dawg/data-r2/optional/"));
	}
	@Test
	public void testDAWG_optional_filter() throws Exception{
		testDirecory(new File(getTestInputFolder()+ "testcases-dawg/data-r2/optional-filter/"));
	}
	@Test
	public void testDAWG_reduced() throws Exception{
		testDirecory(new File(getTestInputFolder()+ "testcases-dawg/data-r2/reduced/"));
	}
	@Test
	public void testDAWG_regex() throws Exception{
		testDirecory(new File(getTestInputFolder()+ "testcases-dawg/data-r2/regex/"));
	}
	@Test
	public void testDAWG_solution_seq() throws Exception{
		testDirecory(new File(getTestInputFolder()+ "testcases-dawg/data-r2/solution-seq/"));
	}
	@Test
	public void testDAWG_sort() throws Exception{
		testDirecory(new File(getTestInputFolder()+ "testcases-dawg/data-r2/sort/"));
	}
	@Test
	public void testDAWG_syntax_sparql1() throws Exception{
		testDirecory(new File(getTestInputFolder()+ "testcases-dawg/data-r2/syntax-sparql1/"));
	}
	@Test
	public void testDAWG_syntax_sparql2() throws Exception{
		testDirecory(new File(getTestInputFolder()+ "testcases-dawg/data-r2/syntax-sparql2/"));
	}
	@Test
	public void testDAWG_syntax_sparql3() throws Exception{
		testDirecory(new File(getTestInputFolder()+ "testcases-dawg/data-r2/syntax-sparql3/"));
	}
	@Test
	public void testDAWG_syntax_sparql4() throws Exception{
		testDirecory(new File(getTestInputFolder()+ "testcases-dawg/data-r2/syntax-sparql4/"));
	}
	@Test
	public void testDAWG_syntax_sparql5() throws Exception{
		testDirecory(new File(getTestInputFolder()+ "testcases-dawg/data-r2/syntax-sparql5/"));
	}
	@Test
	public void testDAWG_triple_match() throws Exception{
		testDirecory(new File(getTestInputFolder()+ "testcases-dawg/data-r2/triple-match/"));
	}
	@Test
	public void testDAWG_type_promotion() throws Exception{
		testDirecory(new File(getTestInputFolder()+ "testcases-dawg/data-r2/type-promotion/"));
	}
	
	public void test_meta_EmptyLog() {
		if (!log.isEmpty()) {
			System.out.println(log.size() + " file(s) could not be parsed:");
			for(String logEntry : log) {
				System.out.println("\t" + logEntry);
			}
		}
		
		
		assertTrue(this.log.isEmpty());
	}
	
}
