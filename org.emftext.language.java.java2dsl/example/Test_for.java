/*******************************************************************************
 * Copyright (c) 2006-2011
 * Software Technology Group, Dresden University of Technology
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany
 *      - initial API and implementation
 ******************************************************************************/
package example.for2shortfor;

import java.util.Arrays;
import java.util.List;


public class Test {
	public void test () {
	List < String > strings = Arrays.asList ( "1" , "2" , "3" , "4" ) ;
	for ( String one : strings ) {
		System.out.println ( one ) ;
	}
}
}