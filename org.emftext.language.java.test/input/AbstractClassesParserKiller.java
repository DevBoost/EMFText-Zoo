import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.window.IShellProvider;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.actions.RefreshAction;
import org.eclipse.ui.internal.ide.IDEWorkbenchMessages;
import org.eclipse.ui.internal.ide.StatusUtil;
import org.eclipse.ui.views.navigator.ResourceNavigator;

public class AbstractClassesParserKiller {

	protected void makeActions() {
		final IShellProvider provider = null;
		RefreshAction refreshAction = new RefreshAction(provider) {
			public void run() {
				WorkspaceJob job = new WorkspaceJob("refresh") {
					public IStatus runInWorkspace(IProgressMonitor monitor) {
						try {
							WorkspaceJob op = null;
							op.run(monitor);
							Shell shell = provider.getShell();
							if (shell != null && !shell.isDisposed()) {
								shell.getDisplay().asyncExec(new Runnable() {
									public void run() {
										ResourceNavigator navigator = null;
										TreeViewer viewer = navigator
												.getViewer();
										if (viewer != null
												&& viewer.getControl() != null
												&& !viewer.getControl()
														.isDisposed()) {
											viewer.refresh();

										}
									}
								});
								throw new InterruptedException(null);
							}
							throw new InvocationTargetException(null);
						} catch (InvocationTargetException e) {
							String msg = NLS
									.bind(
											IDEWorkbenchMessages.WorkspaceAction_logTitle,
											getClass().getName(), e
													.getTargetException());
							try {
								throw new CoreException(StatusUtil.newStatus(
										IStatus.ERROR, msg, e
												.getTargetException()));
							} catch (CoreException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
								
							}
						} 
						catch (InterruptedException e) {
							return Status.CANCEL_STATUS;
						}
						IStatus[] errorStatus = null;
						return errorStatus[0];
					}

				};
			}
		};
	}
}