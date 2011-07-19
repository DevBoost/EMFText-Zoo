package org.emftext.language.dbschema;

public class DBSchemaUtil {

	public Column findColumn(DBSchema schema, String tableName, String columnName) {
		
		for (Table table : schema.getTables()) {
			if (table.getName().equals(tableName)) {
				for (Column column : table.getColumns()) {
					if (column.getName().equals(columnName)) {
						return column;
					}
				}
			}
		}
		return null;
	}
}
