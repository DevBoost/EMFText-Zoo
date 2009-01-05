package org.emftext.language.c_sharp.resource.cs;

public class CsTokenResolverFactory extends org.emftext.runtime.resource.impl.BasicTokenResolverFactory implements org.emftext.runtime.resource.ITokenResolverFactory {

	public CsTokenResolverFactory(){
		super.registerTokenResolver("TEXT", new org.emftext.language.c_sharp.resource.cs.analysis.CsTEXTTokenResolver());
	}
}
