/*******************************************************************************
 * Copyright (c) 2006-2010 
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
package org .emftext .language .java .treejava .examples ; 


class PrintSimpleTree { 
	public static void main (String [] args ) { 
			House myHouse = new House ( "SweetHome" , new Room ( ) , new Room ( "Kitchen" , new Door ( ) , new Door ( ) ) , new Room ( ) , new Room ( new Door ( ) ) , new Room ( new Door ( ) , new Door ( ) ) ) ; 
		} 
} 

