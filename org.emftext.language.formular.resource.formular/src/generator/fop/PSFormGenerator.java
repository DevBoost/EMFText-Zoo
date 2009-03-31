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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.emftext.language.formular.resource.formular.custom.IGenerator;
import org.apache.fop.apps.FOPException;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.MimeConstants;


public class PSFormGenerator implements IGenerator {

	public String generate(Object argument) {
		FopFactory fopFactory = FopFactory.newInstance();
		IFile foFile = (IFile)argument;
		ByteArrayOutputStream outStream = new ByteArrayOutputStream(); 
		OutputStream bufferedOutStream = new BufferedOutputStream(outStream);
		try{
			Fop fop = fopFactory.newFop(MimeConstants.MIME_POSTSCRIPT,bufferedOutStream);
			TransformerFactory factory = TransformerFactory.newInstance();
			Transformer transformer = factory.newTransformer(); 
			
			StreamSource src = new StreamSource(foFile.getContents());
			Result res = new SAXResult(fop.getDefaultHandler());

			transformer.transform(src, res);
			
			bufferedOutStream.flush();
			bufferedOutStream.close();
			return new String(outStream.toByteArray());
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
