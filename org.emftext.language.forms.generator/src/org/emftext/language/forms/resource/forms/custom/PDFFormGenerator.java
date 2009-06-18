package org.emftext.language.forms.resource.forms.custom;

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
