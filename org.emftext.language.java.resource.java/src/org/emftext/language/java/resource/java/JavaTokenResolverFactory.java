package org.emftext.language.java.resource.java;

import org.emftext.runtime.resource.TokenResolverFactory;
import org.emftext.runtime.resource.impl.BasicTokenResolverFactory;

import org.emftext.language.java.resource.java.analysis.*;

public class JavaTokenResolverFactory extends BasicTokenResolverFactory implements TokenResolverFactory{

	public JavaTokenResolverFactory(){
		super.registerTokenResolver("CHARACTER_LITERAL",new JavaCHARACTER_LITERALTokenResolver());
		super.registerTokenResolver("MULTIPLICATIVE_OPERATOR_LITERAL",new JavaMULTIPLICATIVE_OPERATOR_LITERALTokenResolver());
		super.registerTokenResolver("BOOLEAN_LITERAL",new JavaBOOLEAN_LITERALTokenResolver());
		super.registerTokenResolver("OCTAL_LITERAL",new JavaOCTAL_LITERALTokenResolver());
		super.registerTokenResolver("FLOATING_POINT_LITERAL",new JavaFLOATING_POINT_LITERALTokenResolver());
		super.registerTokenResolver("STRING_LITERAL",new JavaSTRING_LITERALTokenResolver());
		super.registerTokenResolver("ADDITIVE_OPERATOR_LITERAL",new JavaADDITIVE_OPERATOR_LITERALTokenResolver());
		super.registerTokenResolver("ML_COMMENT",new JavaML_COMMENTTokenResolver());
		super.registerTokenResolver("IDENTIFIER",new JavaIDENTIFIERTokenResolver());
		super.registerTokenResolver("DECIMAL_LITERAL",new JavaDECIMAL_LITERALTokenResolver());
		super.registerTokenResolver("HEX_LITERAL",new JavaHEX_LITERALTokenResolver());
		super.registerTokenResolver("SL_COMMENT",new JavaSL_COMMENTTokenResolver());
	}
}
