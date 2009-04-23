package org.emftext.language.java.javabehavior4uml.resource.javabehavior;

public class JavabehaviorTokenResolverFactory extends org.emftext.runtime.resource.impl.AbstractTokenResolverFactory implements org.emftext.runtime.resource.ITokenResolverFactory {
	
	public JavabehaviorTokenResolverFactory() {
		super.registerCollectInTokenResolver("comments", new org.emftext.language.java.resource.java.analysis.JavaCOLLECT_commentsTokenResolver());
		super.registerCollectInTokenResolver("comments", new org.emftext.language.java.resource.java.analysis.JavaCOLLECT_commentsTokenResolver());
		super.registerTokenResolver("BOOLEAN_LITERAL", new org.emftext.language.java.resource.java.analysis.JavaBOOLEAN_LITERALTokenResolver());
		super.registerTokenResolver("CHARACTER_LITERAL", new org.emftext.language.java.resource.java.analysis.JavaCHARACTER_LITERALTokenResolver());
		super.registerTokenResolver("STRING_LITERAL", new org.emftext.language.java.resource.java.analysis.JavaSTRING_LITERALTokenResolver());
		super.registerTokenResolver("IDENTIFIER", new org.emftext.language.java.resource.java.analysis.JavaIDENTIFIERTokenResolver());
		super.registerTokenResolver("HEX_FLOAT_LITERAL", new org.emftext.language.java.resource.java.analysis.JavaHEX_FLOAT_LITERALTokenResolver());
		super.registerTokenResolver("HEX_DOUBLE_LITERAL", new org.emftext.language.java.resource.java.analysis.JavaHEX_DOUBLE_LITERALTokenResolver());
		super.registerTokenResolver("HEX_LONG_LITERAL", new org.emftext.language.java.resource.java.analysis.JavaHEX_LONG_LITERALTokenResolver());
		super.registerTokenResolver("HEX_INTEGER_LITERAL", new org.emftext.language.java.resource.java.analysis.JavaHEX_INTEGER_LITERALTokenResolver());
		super.registerTokenResolver("DECIMAL_FLOAT_LITERAL", new org.emftext.language.java.resource.java.analysis.JavaDECIMAL_FLOAT_LITERALTokenResolver());
		super.registerTokenResolver("DECIMAL_DOUBLE_LITERAL", new org.emftext.language.java.resource.java.analysis.JavaDECIMAL_DOUBLE_LITERALTokenResolver());
		super.registerTokenResolver("DECIMAL_LONG_LITERAL", new org.emftext.language.java.resource.java.analysis.JavaDECIMAL_LONG_LITERALTokenResolver());
		super.registerTokenResolver("DECIMAL_INTEGER_LITERAL", new org.emftext.language.java.resource.java.analysis.JavaDECIMAL_INTEGER_LITERALTokenResolver());
		super.registerTokenResolver("OCTAL_LONG_LITERAL", new org.emftext.language.java.resource.java.analysis.JavaOCTAL_LONG_LITERALTokenResolver());
		super.registerTokenResolver("OCTAL_INTEGER_LITERAL", new org.emftext.language.java.resource.java.analysis.JavaOCTAL_INTEGER_LITERALTokenResolver());
	}
}
