package org.emftext.language.egui.postprocessor.ocl;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.emftext.language.egui.resource.egui.IEguiOptionProvider;
import org.emftext.language.egui.resource.egui.IEguiOptions;
import org.emftext.language.egui.resource.egui.IEguiResourcePostProcessor;
import org.emftext.language.egui.resource.egui.IEguiResourcePostProcessorProvider;
import org.emftext.language.egui.resource.egui.mopp.EguiResource;
import org.emftext.language.egui.statemodel.StateModel;

import tudresden.ocl20.pivot.essentialocl.standardlibrary.OclBoolean;
import tudresden.ocl20.pivot.facade.Ocl2ForEclipseFacade;
import tudresden.ocl20.pivot.interpreter.IInterpretationResult;
import tudresden.ocl20.pivot.model.IModel;
import tudresden.ocl20.pivot.model.ModelAccessException;
import tudresden.ocl20.pivot.modelinstance.IModelInstance;
import tudresden.ocl20.pivot.modelinstancetype.exception.TypeNotFoundInModelException;
import tudresden.ocl20.pivot.modelinstancetype.types.IModelInstanceElement;
import tudresden.ocl20.pivot.parser.ParseException;
import tudresden.ocl20.pivot.pivotmodel.Constraint;

public class EGuiOclWfrPostProcessor implements IEguiOptionProvider,
		IEguiResourcePostProcessorProvider, IEguiResourcePostProcessor {

	/** Location of the EGui Metamodel. */
	protected final static String METAMODEL_LOCATION = "constraints/egui.text.ecore";

	/** Location of the OCL WFRs. */
	protected final static String WFR_FILE_LOCATION = "constraints/wfrs.ocl";

	/** The {@link IModel} used for WFR checks. */
	protected static IModel eguiMetaModel;

	/** The OCL WFRs to be checked. */
	protected static Set<Constraint> wfrs;

	/** Error messages for violated constraints. */
	protected static Map<String, String> messages = new java.util.HashMap<String, String>();

	static {
		messages.put("extactOneInitialState",
				"States should have exactly one initial state.");
		messages.put("atLeastOneEndState",
				"State Machines should have at least one finite state.");
	}

	/**
	 * <p>
	 * Returns the file object for a given path relative to the plug-in's
	 * directory.
	 * </p>
	 * 
	 * @param path
	 *            The path of the resource.
	 * @return The found {@link File} object.
	 * @throws IOException
	 * @throws Exception
	 *             Thrown, if the opening fails.
	 */
	protected static File getFile(String path) throws IOException {

		URL fileLocation;
		fileLocation = Activator.getContext().getBundle().getResource(path);
		fileLocation = FileLocator.resolve(fileLocation);

		File file;
		file = new File(fileLocation.getFile());

		file.exists();

		return file;
	}

	/**
	 * Static method used to initialize this post processor.
	 */
	protected static void init() {

		/* Load the model. */
		if (eguiMetaModel == null) {
			try {
				/* TODO Probably adapt this. */
				File modelFile = getFile(METAMODEL_LOCATION);
				eguiMetaModel = Ocl2ForEclipseFacade.getModel(modelFile,
						Ocl2ForEclipseFacade.ECORE_META_MODEL);
			}

			catch (ModelAccessException e) {
				// TODO Log error.
				e.printStackTrace();
			}

			catch (MalformedURLException e) {
				// TODO Log error.
				e.printStackTrace();
			}

			catch (IOException e) {
				// TODO Log error.
				e.printStackTrace();
			}
		}
		// no else.

		/* Parse the WFRs. */
		if (wfrs == null || wfrs.size() == 0) {
			try {
				File wfrFile = getFile(WFR_FILE_LOCATION);
				wfrs = new HashSet<Constraint>();
				wfrs.addAll(Ocl2ForEclipseFacade.parseConstraints(wfrFile,
						eguiMetaModel, true));
			}

			catch (IllegalArgumentException e) {
				// TODO Log error.
				e.printStackTrace();
			}

			catch (ParseException e) {
				// TODO Log error.
				e.printStackTrace();
			}

			catch (MalformedURLException e) {
				// TODO Log error.
				e.printStackTrace();
			}

			catch (IOException e) {
				// TODO Log error.
				e.printStackTrace();
			}
		}
		// no else.
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.emftext.language.egui.resource.egui.IEguiResourcePostProcessor#process
	 * (org.emftext.language.egui.resource.egui.mopp.EguiResource)
	 */
	public void process(EguiResource resource) {

		init();
		EObject root = resource.getContents().get(0);

		// TODO perform model modifications here
		if (eguiMetaModel != null && wfrs != null) {
			try {
				IModelInstance currentModelInstance = Ocl2ForEclipseFacade
						.getEmptyModelInstance(eguiMetaModel,
								Ocl2ForEclipseFacade.ECORE_MODEL_INSTANCE_TYPE);

				TreeIterator<EObject> contents = root.eAllContents();

				while (contents.hasNext()) {

					EObject element = contents.next();

					if (element instanceof StateModel) {
						IModelInstanceElement elementToBeChecked = currentModelInstance
								.addModelInstanceElement(element);

						List<IInterpretationResult> results = Ocl2ForEclipseFacade
								.interpretConstraints(wfrs,
										currentModelInstance,
										elementToBeChecked);

						for (IInterpretationResult result : results) {

							if (result.getResult() instanceof OclBoolean
									&& !((OclBoolean) result.getResult())
											.isTrue()) {

								String msg = result.getConstraint().getName();
								
								if (messages.containsKey(msg))
									msg = messages.get(msg);
								else
									msg = "Violation of WFR " + msg + ".";

								resource.addError(msg, element);
							}
							// no else.
						}
						// end for.
					}
					// no else.
				}
				// end while.
			}

			catch (IllegalArgumentException e) {
				// TODO Log error.
				e.printStackTrace();
			}

			catch (ModelAccessException e) {
				// TODO Log error.
				e.printStackTrace();
			}

			catch (TypeNotFoundInModelException e) {
				// TODO Log error.
				e.printStackTrace();
			}
		}
		// no else.
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.emftext.language.egui.resource.egui.IEguiResourcePostProcessorProvider
	 * #getResourcePostProcessor()
	 */
	public IEguiResourcePostProcessor getResourcePostProcessor() {
		return this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.emftext.language.egui.resource.egui.IEguiOptionProvider#getOptions()
	 */
	public Map<?, ?> getOptions() {
		return Collections.singletonMap(
				IEguiOptions.RESOURCE_POSTPROCESSOR_PROVIDER, this);
	}
}
