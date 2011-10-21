package org.emftext.language.hedl.types;

import org.emftext.language.hedl.HedlFactory;
import org.emftext.language.hedl.JavaType;

public class HedlBuiltinTypes {

	public final static JavaType STRING = HedlFactory.eINSTANCE.createJavaType();
	public final static JavaType LONGSTRING = HedlFactory.eINSTANCE.createJavaType();
	public final static JavaType INT = HedlFactory.eINSTANCE.createJavaType();
	public final static JavaType DATE = HedlFactory.eINSTANCE.createJavaType();
	public final static JavaType DOUBLE = HedlFactory.eINSTANCE.createJavaType();
	public final static JavaType BOOL = HedlFactory.eINSTANCE.createJavaType();

	public final static JavaType[] TYPES = new JavaType[] {
		STRING, INT, DATE, DOUBLE, LONGSTRING, BOOL
	};

	static {
		STRING.setName("String");
		STRING.setJavaClass(String.class);
		LONGSTRING.setName("LongString");
		LONGSTRING.setJavaClass(String.class);
		INT.setName("Int");
		INT.setJavaClass(int.class);
		BOOL.setName("Bool");
		BOOL.setJavaClass(boolean.class);
		DATE.setName("Date");
		DATE.setJavaClass(java.util.Date.class);
		DOUBLE.setName("Double");
		DOUBLE.setJavaClass(double.class);
	}
}
