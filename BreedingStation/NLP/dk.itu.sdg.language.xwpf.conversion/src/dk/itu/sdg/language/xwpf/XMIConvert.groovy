package dk.itu.sdg.language.xwpf

import org.eclipse.core.commands.AbstractHandler
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.commands.ExecutionException
import org.eclipse.jface.viewers.IStructuredSelection
import org.eclipse.ui.handlers.HandlerUtil
import org.eclipse.core.resources.IFile
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.ecore.EObject;


class XMIConvert extends AbstractConverter {

	@Override
	public void convert(DocX2Model converter, EObject modelDocument, IFile file) {
		converter.saveXMI(modelDocument, file)
	};
}
