package org.emftext.language.company.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.company.Company;
import org.emftext.language.company.Department;
import org.emftext.language.company.Employee;
import org.emftext.language.company.resource.company.mopp.CompanyResourceFactory;
import org.junit.BeforeClass;
import org.junit.Test;

public class OperationsTest {

	private static Company company;
	
	@BeforeClass
	public static void setUp(){
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("company", new CompanyResourceFactory());
		File example = new File("../org.emftext.language.company/example/example.company");
		assertTrue(example.exists());
		URI uri = URI.createFileURI(example.getAbsolutePath());
		assertNotNull(uri);
		ResourceSet rs = new ResourceSetImpl();
		Resource resource = rs.getResource(uri, true);
		assertNotNull(resource);
		List<EObject> contents = resource.getContents();
		assertNotNull(contents);
		assertTrue(contents.get(0) instanceof Company);
		company = (Company) contents.get(0);
	}
	
	@Test
	public void testCutSalaries(){
		List<Double> oldSalaries = getSalaries(company);
		company.cutSalary();
		List<Double> newSalaries = getSalaries(company);
		for (int i = 0; i < oldSalaries.size(); i++) {
			double oldSalary = oldSalaries.get(i);
			double newSalary = newSalaries.get(i);
			assertEquals(oldSalary / 2, newSalary, 0.0);
		}
	}

	private List<Double> getSalaries(Company company) {
		TreeIterator<EObject> allContents = company.eAllContents();
		List<Double> salaries = new ArrayList<Double>();
		while (allContents.hasNext()) {
			EObject eObject = (EObject) allContents.next();
			if(eObject instanceof Employee){
				Employee employee = (Employee) eObject;
				salaries.add(employee.getSalary());
			}
		}
		return salaries;
	}
	
	@Test
	public void testDepth(){
		List<Department> departments = company.getDepartments();
		for (Department department : departments) {
			int recursiveDepth = department.depth();
			int testDepth = getDepth(department);
			System.out.println("recursice depth: " + recursiveDepth + " test depth: " + testDepth);
			assertEquals(recursiveDepth, testDepth);
		}
	}
	
	private int getDepth(Department department){
		int depth = 1;
		TreeIterator<EObject> allContents = department.eAllContents();
		while (allContents.hasNext()) {
			EObject object = (EObject) allContents.next();
			if(object instanceof Department){
				depth++;
			}
		}
		return depth;
	}
}
