package org.emftext.language.java.util.references;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.emftext.language.java.expressions.Expression;
import org.emftext.language.java.references.Argumentable;
import org.emftext.language.java.types.Type;
import org.emftext.language.java.util.expressions.ExpressionUtil;

public class ArgumentableUtil {
	
	public static EList<Type> getArgumentTypes(Argumentable _this) {
		EList<Type> resultList = new BasicEList<Type>();

		for(Expression exp : _this.getArguments()) {
			Type type = ExpressionUtil.getType(exp);
			resultList.add(type);
		}
		return resultList;
	}

}
