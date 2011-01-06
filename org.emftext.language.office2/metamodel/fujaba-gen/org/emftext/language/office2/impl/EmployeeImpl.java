/**
 * Copyright (c) 2006-2010
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Software Technology Group - TU Dresden, Germany
 *      - initial API and implementation
 */
package org.emftext.language.office2.impl;




/**
 * @generated
 **/
public class EmployeeImpl extends OfficeElement
{


   public void removeYou()
   {
      this.setCurrentlyIn (null);
      this.setWorksIn (null);
      this.getWorksWith().clear();
super.removeYou ();   }
}


