/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.dbschema.resource.dbschema.analysis;

import java.util.Map;

import org.eclipse.emf.ecore.EReference;
import org.emftext.language.dbschema.AttributeColumn;
import org.emftext.language.dbschema.Column;
import org.emftext.language.dbschema.DBSchema;
import org.emftext.language.dbschema.DBSchemaUtil;
import org.emftext.language.dbschema.ForeignKeyColumn;
import org.emftext.language.dbschema.Table;
import org.emftext.language.dbschema.resource.dbschema.IDbschemaReferenceResolveResult;
import org.emftext.language.dbschema.resource.dbschema.IDbschemaReferenceResolver;

public class ForeignKeyColumnReferencedColumnReferenceResolver implements IDbschemaReferenceResolver<ForeignKeyColumn, AttributeColumn> {
	
	public void resolve(String identifier, ForeignKeyColumn container, EReference reference, int position, boolean resolveFuzzy, final IDbschemaReferenceResolveResult<AttributeColumn> result) {
		// TODO
		String[] parts = identifier.split("\\.");
		String table = parts[0];
		String column = parts[1];
		DBSchema schema = (DBSchema) container.eContainer().eContainer();
		if (resolveFuzzy) {
			for (Table nextTable : schema.getTables()) {
				for (Column nextColumn : nextTable.getColumns()) {
					if (nextColumn instanceof AttributeColumn) {
						result.addMapping(deResolve(nextColumn), (AttributeColumn) nextColumn);
					}
				}
			}
		} else {
			Column foundColumn = new DBSchemaUtil().findColumn(schema, table, column);
			if (foundColumn != null) {
				if (foundColumn instanceof AttributeColumn) {
					result.addMapping(identifier, (AttributeColumn) foundColumn);
				}
			}
		}
	}
	
	public String deResolve(AttributeColumn element, ForeignKeyColumn container, EReference reference) {
		return deResolve(element);
	}

	private String deResolve(Column element) {
		Table table = (Table) element.eContainer();
		return table.getName() + "." + element.getName();
	}
	
	public void setOptions(Map<?,?> options) {
		// not needed
	}
}
