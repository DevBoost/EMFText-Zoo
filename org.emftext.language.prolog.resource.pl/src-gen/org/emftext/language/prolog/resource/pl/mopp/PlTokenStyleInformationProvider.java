/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.prolog.resource.pl.mopp;

public class PlTokenStyleInformationProvider {
	
	public static String TASK_ITEM_TOKEN_NAME = "TASK_ITEM";
	
	public org.emftext.language.prolog.resource.pl.IPlTokenStyle getDefaultTokenStyle(String tokenName) {
		if ("is".equals(tokenName)) {
			return new org.emftext.language.prolog.resource.pl.mopp.PlTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("QUOTED_39_39".equals(tokenName)) {
			return new org.emftext.language.prolog.resource.pl.mopp.PlTokenStyle(new int[] {0x2A, 0x00, 0xFF}, null, false, false, false, false);
		}
		if ("TASK_ITEM".equals(tokenName)) {
			return new org.emftext.language.prolog.resource.pl.mopp.PlTokenStyle(new int[] {0x7F, 0x9F, 0xBF}, null, true, false, false, false);
		}
		return null;
	}
	
}
