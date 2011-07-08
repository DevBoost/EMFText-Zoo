/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.company.resource.company.mopp;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.company.Company;
import org.emftext.language.company.Department;
import org.emftext.language.company.Employee;
import org.emftext.language.dot.AList;
import org.emftext.language.dot.Attribute;
import org.emftext.language.dot.AttributeList;
import org.emftext.language.dot.DotFactory;
import org.emftext.language.dot.EdgeStatement;
import org.emftext.language.dot.Graph;
import org.emftext.language.dot.NodeID;
import org.emftext.language.dot.NodeStatement;
import org.emftext.language.dot.StatementList;
import org.emftext.language.dot.Target;

public class CompanyBuilder implements
		org.emftext.language.company.resource.company.ICompanyBuilder {

	private DotFactory dotFactory;

	
	public boolean isBuildingNeeded(org.eclipse.emf.common.util.URI uri) {
		// change this to return true to enable building of all resources
		return true;
	}

	public org.eclipse.core.runtime.IStatus build(
			org.emftext.language.company.resource.company.mopp.CompanyResource resource,
			org.eclipse.core.runtime.IProgressMonitor monitor) {
		if (resource.getErrors().size() == 0) {
			URI uri = resource.getURI().appendFileExtension("dot");
			Resource dotResource = resource.getResourceSet()
					.createResource(uri);
			Company c = (Company) resource.getContents().get(0);

			dotFactory = DotFactory.eINSTANCE;
			Graph graph = dotFactory.createGraph();
			graph.setType("digraph");
			graph.setId(c.getName());
			dotResource.getContents().add(graph);

			StatementList current = dotFactory.createStatementList();
			graph.setStatements(current);

			String nodeName = c.getName();
			current = createShapedNodeWithName(current, nodeName);

			EList<Department> departments = c.getDepartments();
			for (Department department : departments) {
				current = createNodesForDepartment(current, department);
			}

			for (Department subDepartment : c.getDepartments()) {
				current = createEdgesForDepartment(current, subDepartment);
			}

			try {
				dotResource.save(Collections.EMPTY_MAP);
			} catch (IOException e) {
				System.err.println(e);
				e.printStackTrace();
			}

		}
		return org.eclipse.core.runtime.Status.OK_STATUS;

	}

	private StatementList createNodesForDepartment(StatementList current,
			Department department) {
		current = createShapedNodeWithName(current, department.getName());
		EList<Employee> employees = department.getEmployees();
		for (Employee employee : employees) {
			current = createShapedNodeWithName(current, employee.getName());
		}
		EList<Department> subDepartments = department.getSubDepartments();
		for (Department subDepartment : subDepartments) {
			current = createNodesForDepartment(current, subDepartment);
		}

		return current;
	}

	private StatementList createEdgesForDepartment(StatementList current,
			Department department) {
		String sourceName = department.getName();
		for (Department subDepartment : department.getSubDepartments()) {
			String targetName = subDepartment.getName();
			current = createEdgeStatement(current, sourceName, targetName);
		}
		for (Employee e : department.getEmployees()) {
			String targetName = e.getName();
			current = createEdgeStatement(current, sourceName, targetName);
		}
		for (Department subDepartment : department.getSubDepartments()) {
			current = createEdgesForDepartment(current, subDepartment);
		}
		return current;
	}

	private StatementList createEdgeStatement(StatementList current,
			String sourceName, String targetName) {
		System.out.println("CompanyBuilder.createEdgeStatement() " + sourceName
				+ " ->  " + targetName);
		EdgeStatement edge = dotFactory.createEdgeStatement();
		NodeID source = dotFactory.createNodeID();
		source.setId(sourceName);
		edge.setSource(source);
		Target t = dotFactory.createTarget();
		NodeID target = dotFactory.createNodeID();
		target.setId(targetName);

		t.setTarget(target);
		t.setOperation("->");
		edge.setTarget(t);
		current.setStatement(edge);
		StatementList sl = dotFactory.createStatementList();
		current.setTail(sl);
		return sl;
	}

	private StatementList createShapedNodeWithName(StatementList statements,
			String nodeName) {
		System.out.println("CompanyBuilder.createShapedNodeWithName()"
				+ nodeName);
		NodeStatement newNode = dotFactory.createNodeStatement();
		NodeID nodeId = dotFactory.createNodeID();
		nodeId.setId(nodeName);

		AttributeList al = dotFactory.createAttributeList();
		AList aList = dotFactory.createAList();
		al.setList(aList);

		Attribute attribute = dotFactory.createAttribute();
		aList.setAttribute(attribute);
		attribute.setKey("shape");

		newNode.setAttributes(al);
		newNode.setNode_id(nodeId);
	
		statements.setStatement(newNode);
		StatementList sl = dotFactory.createStatementList();
		statements.setTail(sl);
		return sl;
	}

}
