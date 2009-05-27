/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
package generator.fop;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.fop.apps.FOPException;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.emftext.language.formular.resource.formular.custom.IGenerator;


public class PDFFormGenerator implements IGenerator {

	public byte[] generate(Object argument) {
		FopFactory fopFactory = FopFactory.newInstance();
		IFile foFile = (IFile)argument;
		ByteArrayOutputStream outStream = new ByteArrayOutputStream(); 
		OutputStream bufferedOutStream = new BufferedOutputStream(outStream);
		try{
			Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, bufferedOutStream);
			TransformerFactory factory = TransformerFactory.newInstance();
			Transformer transformer = factory.newTransformer(); 
			
			StreamSource src = new StreamSource(foFile.getContents());
			Result res = new SAXResult(fop.getDefaultHandler());

			transformer.transform(src, res);
			
			bufferedOutStream.flush();
			bufferedOutStream.close();
			/*
			FileOutputStream ts = new FileOutputStream("test.pdf");
			ts.write(outStream.toByteArray());
			ts.close();
			*/
			return outStream.toByteArray();
		}
		catch(FOPException e){
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (CoreException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
		return null;
		
	}

}
