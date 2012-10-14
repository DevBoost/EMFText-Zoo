/**
* Copyright (C) 2012  
* Jan Reimann (TU Dresden, Software Technology Group)
* Mirko Seifert (DevBoost GmbH)
* 
* This program is free software; you can redistribute it and/or
* modify it under the terms of the GNU General Public License
* as published by the Free Software Foundation; either version 2
* of the License, or (at your option) any later version.
* 
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
* 
* You should have received a copy of the GNU General Public License
* along with this program; if not, write to the Free Software
* Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
*/
package org.devboost.stanford.language.resource.txt.mopp;

public class TxtResource extends org.eclipse.emf.ecore.resource.impl.ResourceImpl implements org.devboost.stanford.language.resource.txt.ITxtTextResource {
	
	public class ElementBasedTextDiagnostic implements org.devboost.stanford.language.resource.txt.ITxtTextDiagnostic {
		
		private final org.devboost.stanford.language.resource.txt.ITxtLocationMap locationMap;
		private final org.eclipse.emf.common.util.URI uri;
		private final org.eclipse.emf.ecore.EObject element;
		private final org.devboost.stanford.language.resource.txt.ITxtProblem problem;
		
		public ElementBasedTextDiagnostic(org.devboost.stanford.language.resource.txt.ITxtLocationMap locationMap, org.eclipse.emf.common.util.URI uri, org.devboost.stanford.language.resource.txt.ITxtProblem problem, org.eclipse.emf.ecore.EObject element) {
			super();
			this.uri = uri;
			this.locationMap = locationMap;
			this.element = element;
			this.problem = problem;
		}
		
		public String getMessage() {
			return problem.getMessage();
		}
		
		public org.devboost.stanford.language.resource.txt.ITxtProblem getProblem() {
			return problem;
		}
		
		public String getLocation() {
			return uri.toString();
		}
		
		public int getCharStart() {
			return Math.max(0, locationMap.getCharStart(element));
		}
		
		public int getCharEnd() {
			return Math.max(0, locationMap.getCharEnd(element));
		}
		
		public int getColumn() {
			return Math.max(0, locationMap.getColumn(element));
		}
		
		public int getLine() {
			return Math.max(0, locationMap.getLine(element));
		}
		
		public org.eclipse.emf.ecore.EObject getElement() {
			return element;
		}
		
		public boolean wasCausedBy(org.eclipse.emf.ecore.EObject element) {
			if (this.element == null) {
				return false;
			}
			return this.element.equals(element);
		}
		
		public String toString() {
			return getMessage() + " at " + getLocation() + " line " + getLine() + ", column " + getColumn();
		}
	}
	
	public class PositionBasedTextDiagnostic implements org.devboost.stanford.language.resource.txt.ITxtTextDiagnostic {
		
		private final org.eclipse.emf.common.util.URI uri;
		
		private int column;
		private int line;
		private int charStart;
		private int charEnd;
		private org.devboost.stanford.language.resource.txt.ITxtProblem problem;
		
		public PositionBasedTextDiagnostic(org.eclipse.emf.common.util.URI uri, org.devboost.stanford.language.resource.txt.ITxtProblem problem, int column, int line, int charStart, int charEnd) {
			
			super();
			this.uri = uri;
			this.column = column;
			this.line = line;
			this.charStart = charStart;
			this.charEnd = charEnd;
			this.problem = problem;
		}
		
		public org.devboost.stanford.language.resource.txt.ITxtProblem getProblem() {
			return problem;
		}
		
		public int getCharStart() {
			return charStart;
		}
		
		public int getCharEnd() {
			return charEnd;
		}
		
		public int getColumn() {
			return column;
		}
		
		public int getLine() {
			return line;
		}
		
		public String getLocation() {
			return uri.toString();
		}
		
		public String getMessage() {
			return problem.getMessage();
		}
		
		public boolean wasCausedBy(org.eclipse.emf.ecore.EObject element) {
			return false;
		}
		
		public String toString() {
			return getMessage() + " at " + getLocation() + " line " + getLine() + ", column " + getColumn();
		}
	}
	
	private org.devboost.stanford.language.resource.txt.ITxtReferenceResolverSwitch resolverSwitch;
	private org.devboost.stanford.language.resource.txt.ITxtLocationMap locationMap;
	private int proxyCounter = 0;
	private org.devboost.stanford.language.resource.txt.ITxtTextParser parser;
	private org.devboost.stanford.language.resource.txt.util.TxtLayoutUtil layoutUtil = new org.devboost.stanford.language.resource.txt.util.TxtLayoutUtil();
	private org.devboost.stanford.language.resource.txt.mopp.TxtMarkerHelper markerHelper;
	private java.util.Map<String, org.devboost.stanford.language.resource.txt.ITxtContextDependentURIFragment<? extends org.eclipse.emf.ecore.EObject>> internalURIFragmentMap = new java.util.LinkedHashMap<String, org.devboost.stanford.language.resource.txt.ITxtContextDependentURIFragment<? extends org.eclipse.emf.ecore.EObject>>();
	private java.util.Map<String, org.devboost.stanford.language.resource.txt.ITxtQuickFix> quickFixMap = new java.util.LinkedHashMap<String, org.devboost.stanford.language.resource.txt.ITxtQuickFix>();
	private java.util.Map<?, ?> loadOptions;
	
	/**
	 * If a post-processor is currently running, this field holds a reference to it.
	 * This reference is used to terminate post-processing if needed.
	 */
	private org.devboost.stanford.language.resource.txt.ITxtResourcePostProcessor runningPostProcessor;
	
	/**
	 * A flag (and lock) to indicate whether reloading of the resource shall be
	 * cancelled.
	 */
	private Boolean terminateReload = false;
	private Object terminateReloadLock = new Object();
	private Object loadingLock = new Object();
	private boolean delayNotifications = false;
	private java.util.List<org.eclipse.emf.common.notify.Notification> delayedNotifications = new java.util.ArrayList<org.eclipse.emf.common.notify.Notification>();
	private java.io.InputStream latestReloadInputStream = null;
	private java.util.Map<?, ?> latestReloadOptions = null;
	private org.devboost.stanford.language.resource.txt.util.TxtInterruptibleEcoreResolver interruptibleResolver;
	
	protected org.devboost.stanford.language.resource.txt.mopp.TxtMetaInformation metaInformation = new org.devboost.stanford.language.resource.txt.mopp.TxtMetaInformation();
	
	public TxtResource() {
		super();
		resetLocationMap();
	}
	
	public TxtResource(org.eclipse.emf.common.util.URI uri) {
		super(uri);
		resetLocationMap();
	}
	
	protected void doLoad(java.io.InputStream inputStream, java.util.Map<?,?> options) throws java.io.IOException {
		synchronized (loadingLock) {
			if (processTerminationRequested()) {
				return;
			}
			this.loadOptions = options;
			delayNotifications = true;
			resetLocationMap();
			String encoding = getEncoding(options);
			java.io.InputStream actualInputStream = inputStream;
			Object inputStreamPreProcessorProvider = null;
			if (options != null) {
				inputStreamPreProcessorProvider = options.get(org.devboost.stanford.language.resource.txt.ITxtOptions.INPUT_STREAM_PREPROCESSOR_PROVIDER);
			}
			if (inputStreamPreProcessorProvider != null) {
				if (inputStreamPreProcessorProvider instanceof org.devboost.stanford.language.resource.txt.ITxtInputStreamProcessorProvider) {
					org.devboost.stanford.language.resource.txt.ITxtInputStreamProcessorProvider provider = (org.devboost.stanford.language.resource.txt.ITxtInputStreamProcessorProvider) inputStreamPreProcessorProvider;
					org.devboost.stanford.language.resource.txt.mopp.TxtInputStreamProcessor processor = provider.getInputStreamProcessor(inputStream);
					actualInputStream = processor;
				}
			}
			
			parser = getMetaInformation().createParser(actualInputStream, encoding);
			parser.setOptions(options);
			org.devboost.stanford.language.resource.txt.ITxtReferenceResolverSwitch referenceResolverSwitch = getReferenceResolverSwitch();
			referenceResolverSwitch.setOptions(options);
			org.devboost.stanford.language.resource.txt.ITxtParseResult result = parser.parse();
			// dispose parser, we don't need it anymore
			parser = null;
			
			if (processTerminationRequested()) {
				// do nothing if reload was already restarted
				return;
			}
			
			clearState();
			getContentsInternal().clear();
			org.eclipse.emf.ecore.EObject root = null;
			if (result != null) {
				root = result.getRoot();
				if (root != null) {
					if (isLayoutInformationRecordingEnabled()) {
						layoutUtil.transferAllLayoutInformationToModel(root);
					}
					if (processTerminationRequested()) {
						// the next reload will add new content
						return;
					}
					getContentsInternal().add(root);
				}
				java.util.Collection<org.devboost.stanford.language.resource.txt.ITxtCommand<org.devboost.stanford.language.resource.txt.ITxtTextResource>> commands = result.getPostParseCommands();
				if (commands != null) {
					for (org.devboost.stanford.language.resource.txt.ITxtCommand<org.devboost.stanford.language.resource.txt.ITxtTextResource>  command : commands) {
						command.execute(this);
					}
				}
			}
			getReferenceResolverSwitch().setOptions(options);
			if (getErrors().isEmpty()) {
				if (!runPostProcessors(options)) {
					return;
				}
				if (root != null) {
					runValidators(root);
				}
			}
			notifyDelayed();
		}
	}
	
	protected boolean processTerminationRequested() {
		if (terminateReload) {
			delayNotifications = false;
			delayedNotifications.clear();
			return true;
		}
		return false;
	}
	protected void notifyDelayed() {
		delayNotifications = false;
		for (org.eclipse.emf.common.notify.Notification delayedNotification : delayedNotifications) {
			super.eNotify(delayedNotification);
		}
		delayedNotifications.clear();
	}
	public void eNotify(org.eclipse.emf.common.notify.Notification notification) {
		if (delayNotifications) {
			delayedNotifications.add(notification);
		} else {
			super.eNotify(notification);
		}
	}
	/**
	 * Reloads the contents of this resource from the given stream.
	 */
	public void reload(java.io.InputStream inputStream, java.util.Map<?,?> options) throws java.io.IOException {
		synchronized (terminateReloadLock) {
			latestReloadInputStream = inputStream;
			latestReloadOptions = options;
			if (terminateReload == true) {
				// //reload already requested
			}
			terminateReload = true;
		}
		cancelReload();
		synchronized (loadingLock) {
			synchronized (terminateReloadLock) {
				terminateReload = false;
			}
			isLoaded = false;
			java.util.Map<Object, Object> loadOptions = addDefaultLoadOptions(latestReloadOptions);
			try {
				doLoad(latestReloadInputStream, loadOptions);
			} catch (org.devboost.stanford.language.resource.txt.mopp.TxtTerminateParsingException tpe) {
				// do nothing - the resource is left unchanged if this exception is thrown
			}
			resolveAfterParsing();
			isLoaded = true;
		}
	}
	
	/**
	 * Cancels reloading this resource. The running parser and post processors are
	 * terminated.
	 */
	protected void cancelReload() {
		// Cancel parser
		org.devboost.stanford.language.resource.txt.ITxtTextParser parserCopy = parser;
		if (parserCopy != null) {
			parserCopy.terminate();
		}
		// Cancel post processor(s)
		org.devboost.stanford.language.resource.txt.ITxtResourcePostProcessor runningPostProcessorCopy = runningPostProcessor;
		if (runningPostProcessorCopy != null) {
			runningPostProcessorCopy.terminate();
		}
		// Cancel reference resolving
		org.devboost.stanford.language.resource.txt.util.TxtInterruptibleEcoreResolver interruptibleResolverCopy = interruptibleResolver;
		if (interruptibleResolverCopy != null) {
			interruptibleResolverCopy.terminate();
		}
	}
	
	protected void doSave(java.io.OutputStream outputStream, java.util.Map<?,?> options) throws java.io.IOException {
		org.devboost.stanford.language.resource.txt.ITxtTextPrinter printer = getMetaInformation().createPrinter(outputStream, this);
		org.devboost.stanford.language.resource.txt.ITxtReferenceResolverSwitch referenceResolverSwitch = getReferenceResolverSwitch();
		printer.setEncoding(getEncoding(options));
		referenceResolverSwitch.setOptions(options);
		for (org.eclipse.emf.ecore.EObject root : getContentsInternal()) {
			if (isLayoutInformationRecordingEnabled()) {
				layoutUtil.transferAllLayoutInformationFromModel(root);
			}
			printer.print(root);
			if (isLayoutInformationRecordingEnabled()) {
				layoutUtil.transferAllLayoutInformationToModel(root);
			}
		}
	}
	
	protected String getSyntaxName() {
		return "txt";
	}
	
	public String getEncoding(java.util.Map<?, ?> options) {
		String encoding = null;
		if (new org.devboost.stanford.language.resource.txt.util.TxtRuntimeUtil().isEclipsePlatformAvailable()) {
			encoding = new org.devboost.stanford.language.resource.txt.util.TxtEclipseProxy().getPlatformResourceEncoding(uri);
		}
		if (options != null) {
			Object encodingOption = options.get(org.devboost.stanford.language.resource.txt.ITxtOptions.OPTION_ENCODING);
			if (encodingOption != null) {
				encoding = encodingOption.toString();
			}
		}
		return encoding;
	}
	
	public org.devboost.stanford.language.resource.txt.ITxtReferenceResolverSwitch getReferenceResolverSwitch() {
		if (resolverSwitch == null) {
			resolverSwitch = new org.devboost.stanford.language.resource.txt.mopp.TxtReferenceResolverSwitch();
		}
		return resolverSwitch;
	}
	
	public org.devboost.stanford.language.resource.txt.mopp.TxtMetaInformation getMetaInformation() {
		return new org.devboost.stanford.language.resource.txt.mopp.TxtMetaInformation();
	}
	
	/**
	 * Clears the location map by replacing it with a new instance.
	 */
	protected void resetLocationMap() {
		if (isLocationMapEnabled()) {
			locationMap = new org.devboost.stanford.language.resource.txt.mopp.TxtLocationMap(this);
		} else {
			locationMap = new org.devboost.stanford.language.resource.txt.mopp.TxtDevNullLocationMap();
		}
	}
	
	public void addURIFragment(String internalURIFragment, org.devboost.stanford.language.resource.txt.ITxtContextDependentURIFragment<? extends org.eclipse.emf.ecore.EObject> uriFragment) {
		internalURIFragmentMap.put(internalURIFragment, uriFragment);
	}
	
	public <ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject> void registerContextDependentProxy(org.devboost.stanford.language.resource.txt.ITxtContextDependentURIFragmentFactory<ContainerType, ReferenceType> factory, ContainerType container, org.eclipse.emf.ecore.EReference reference, String id, org.eclipse.emf.ecore.EObject proxyElement, int position) {
		org.eclipse.emf.ecore.InternalEObject proxy = (org.eclipse.emf.ecore.InternalEObject) proxyElement;
		String internalURIFragment = org.devboost.stanford.language.resource.txt.ITxtContextDependentURIFragment.INTERNAL_URI_FRAGMENT_PREFIX + (proxyCounter++) + "_" + id;
		org.devboost.stanford.language.resource.txt.ITxtContextDependentURIFragment<?> uriFragment = factory.create(id, container, reference, position, proxy);
		proxy.eSetProxyURI(getURI().appendFragment(internalURIFragment));
		addURIFragment(internalURIFragment, uriFragment);
	}
	
	public org.eclipse.emf.ecore.EObject getEObject(String id) {
		if (internalURIFragmentMap.containsKey(id)) {
			org.devboost.stanford.language.resource.txt.ITxtContextDependentURIFragment<? extends org.eclipse.emf.ecore.EObject> uriFragment = internalURIFragmentMap.get(id);
			boolean wasResolvedBefore = uriFragment.isResolved();
			org.devboost.stanford.language.resource.txt.ITxtReferenceResolveResult<? extends org.eclipse.emf.ecore.EObject> result = null;
			// catch and report all Exceptions that occur during proxy resolving
			try {
				result = uriFragment.resolve();
			} catch (Exception e) {
				String message = "An expection occured while resolving the proxy for: "+ id + ". (" + e.toString() + ")";
				addProblem(new org.devboost.stanford.language.resource.txt.mopp.TxtProblem(message, org.devboost.stanford.language.resource.txt.TxtEProblemType.UNRESOLVED_REFERENCE, org.devboost.stanford.language.resource.txt.TxtEProblemSeverity.ERROR), uriFragment.getProxy());
				new org.devboost.stanford.language.resource.txt.util.TxtRuntimeUtil().logError(message, e);
			}
			if (result == null) {
				// the resolving did call itself
				return null;
			}
			if (!wasResolvedBefore && !result.wasResolved()) {
				attachResolveError(result, uriFragment.getProxy());
				return null;
			} else if (!result.wasResolved()) {
				return null;
			} else {
				org.eclipse.emf.ecore.EObject proxy = uriFragment.getProxy();
				// remove an error that might have been added by an earlier attempt
				removeDiagnostics(proxy, getErrors());
				// remove old warnings and attach new
				removeDiagnostics(proxy, getWarnings());
				attachResolveWarnings(result, proxy);
				org.devboost.stanford.language.resource.txt.ITxtReferenceMapping<? extends org.eclipse.emf.ecore.EObject> mapping = result.getMappings().iterator().next();
				org.eclipse.emf.ecore.EObject resultElement = getResultElement(uriFragment, mapping, proxy, result.getErrorMessage());
				org.eclipse.emf.ecore.EObject container = uriFragment.getContainer();
				replaceProxyInLayoutAdapters(container, proxy, resultElement);
				return resultElement;
			}
		} else {
			return super.getEObject(id);
		}
	}
	
	protected void replaceProxyInLayoutAdapters(org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EObject proxy, org.eclipse.emf.ecore.EObject target) {
		for (org.eclipse.emf.common.notify.Adapter adapter : container.eAdapters()) {
			if (adapter instanceof org.devboost.stanford.language.resource.txt.mopp.TxtLayoutInformationAdapter) {
				org.devboost.stanford.language.resource.txt.mopp.TxtLayoutInformationAdapter layoutInformationAdapter = (org.devboost.stanford.language.resource.txt.mopp.TxtLayoutInformationAdapter) adapter;
				layoutInformationAdapter.replaceProxy(proxy, target);
			}
		}
	}
	
	protected org.eclipse.emf.ecore.EObject getResultElement(org.devboost.stanford.language.resource.txt.ITxtContextDependentURIFragment<? extends org.eclipse.emf.ecore.EObject> uriFragment, org.devboost.stanford.language.resource.txt.ITxtReferenceMapping<? extends org.eclipse.emf.ecore.EObject> mapping, org.eclipse.emf.ecore.EObject proxy, final String errorMessage) {
		if (mapping instanceof org.devboost.stanford.language.resource.txt.ITxtURIMapping<?>) {
			org.eclipse.emf.common.util.URI uri = ((org.devboost.stanford.language.resource.txt.ITxtURIMapping<? extends org.eclipse.emf.ecore.EObject>)mapping).getTargetIdentifier();
			if (uri != null) {
				org.eclipse.emf.ecore.EObject result = null;
				try {
					result = this.getResourceSet().getEObject(uri, true);
				} catch (Exception e) {
					// we can catch exceptions here, because EMF will try to resolve again and handle
					// the exception
				}
				if (result == null || result.eIsProxy()) {
					// unable to resolve: attach error
					if (errorMessage == null) {
						assert(false);
					} else {
						addProblem(new org.devboost.stanford.language.resource.txt.mopp.TxtProblem(errorMessage, org.devboost.stanford.language.resource.txt.TxtEProblemType.UNRESOLVED_REFERENCE, org.devboost.stanford.language.resource.txt.TxtEProblemSeverity.ERROR), proxy);
					}
				}
				return result;
			}
			return null;
		} else if (mapping instanceof org.devboost.stanford.language.resource.txt.ITxtElementMapping<?>) {
			org.eclipse.emf.ecore.EObject element = ((org.devboost.stanford.language.resource.txt.ITxtElementMapping<? extends org.eclipse.emf.ecore.EObject>)mapping).getTargetElement();
			org.eclipse.emf.ecore.EReference reference = uriFragment.getReference();
			org.eclipse.emf.ecore.EReference oppositeReference = uriFragment.getReference().getEOpposite();
			if (!uriFragment.getReference().isContainment() && oppositeReference != null) {
				if (reference.isMany()) {
					org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList.ManyInverse<org.eclipse.emf.ecore.EObject> list = org.devboost.stanford.language.resource.txt.util.TxtCastUtil.cast(element.eGet(oppositeReference, false));										// avoids duplicate entries in the reference caused by adding to the
					// oppositeReference
					list.basicAdd(uriFragment.getContainer(),null);
				} else {
					uriFragment.getContainer().eSet(uriFragment.getReference(), element);
				}
			}
			return element;
		} else {
			assert(false);
			return null;
		}
	}
	
	protected void removeDiagnostics(org.eclipse.emf.ecore.EObject cause, java.util.List<org.eclipse.emf.ecore.resource.Resource.Diagnostic> diagnostics) {
		// remove all errors/warnings from this resource
		for (org.eclipse.emf.ecore.resource.Resource.Diagnostic errorCand : new org.eclipse.emf.common.util.BasicEList<org.eclipse.emf.ecore.resource.Resource.Diagnostic>(diagnostics)) {
			if (errorCand instanceof org.devboost.stanford.language.resource.txt.ITxtTextDiagnostic) {
				if (((org.devboost.stanford.language.resource.txt.ITxtTextDiagnostic) errorCand).wasCausedBy(cause)) {
					diagnostics.remove(errorCand);
					unmark(cause);
				}
			}
		}
	}
	
	protected void attachResolveError(org.devboost.stanford.language.resource.txt.ITxtReferenceResolveResult<?> result, org.eclipse.emf.ecore.EObject proxy) {
		// attach errors to this resource
		assert result != null;
		final String errorMessage = result.getErrorMessage();
		if (errorMessage == null) {
			assert(false);
		} else {
			addProblem(new org.devboost.stanford.language.resource.txt.mopp.TxtProblem(errorMessage, org.devboost.stanford.language.resource.txt.TxtEProblemType.UNRESOLVED_REFERENCE, org.devboost.stanford.language.resource.txt.TxtEProblemSeverity.ERROR, result.getQuickFixes()), proxy);
		}
	}
	
	protected void attachResolveWarnings(org.devboost.stanford.language.resource.txt.ITxtReferenceResolveResult<? extends org.eclipse.emf.ecore.EObject> result, org.eclipse.emf.ecore.EObject proxy) {
		assert result != null;
		assert result.wasResolved();
		if (result.wasResolved()) {
			for (org.devboost.stanford.language.resource.txt.ITxtReferenceMapping<? extends org.eclipse.emf.ecore.EObject> mapping : result.getMappings()) {
				final String warningMessage = mapping.getWarning();
				if (warningMessage == null) {
					continue;
				}
				addProblem(new org.devboost.stanford.language.resource.txt.mopp.TxtProblem(warningMessage, org.devboost.stanford.language.resource.txt.TxtEProblemType.UNRESOLVED_REFERENCE, org.devboost.stanford.language.resource.txt.TxtEProblemSeverity.WARNING), proxy);
			}
		}
	}
	
	/**
	 * Extends the super implementation by clearing all information about element
	 * positions.
	 */
	protected void doUnload() {
		super.doUnload();
		clearState();
		loadOptions = null;
	}
	
	/**
	 * Runs all post processors to process this resource.
	 */
	protected boolean runPostProcessors(java.util.Map<?, ?> loadOptions) {
		unmark(org.devboost.stanford.language.resource.txt.TxtEProblemType.ANALYSIS_PROBLEM);
		if (processTerminationRequested()) {
			return false;
		}
		// first, run the generated post processor
		runPostProcessor(new org.devboost.stanford.language.resource.txt.mopp.TxtResourcePostProcessor());
		if (loadOptions == null) {
			return true;
		}
		// then, run post processors that are registered via the load options extension
		// point
		Object resourcePostProcessorProvider = loadOptions.get(org.devboost.stanford.language.resource.txt.ITxtOptions.RESOURCE_POSTPROCESSOR_PROVIDER);
		if (resourcePostProcessorProvider != null) {
			if (resourcePostProcessorProvider instanceof org.devboost.stanford.language.resource.txt.ITxtResourcePostProcessorProvider) {
				runPostProcessor(((org.devboost.stanford.language.resource.txt.ITxtResourcePostProcessorProvider) resourcePostProcessorProvider).getResourcePostProcessor());
			} else if (resourcePostProcessorProvider instanceof java.util.Collection<?>) {
				java.util.Collection<?> resourcePostProcessorProviderCollection = (java.util.Collection<?>) resourcePostProcessorProvider;
				for (Object processorProvider : resourcePostProcessorProviderCollection) {
					if (processTerminationRequested()) {
						return false;
					}
					if (processorProvider instanceof org.devboost.stanford.language.resource.txt.ITxtResourcePostProcessorProvider) {
						org.devboost.stanford.language.resource.txt.ITxtResourcePostProcessorProvider csProcessorProvider = (org.devboost.stanford.language.resource.txt.ITxtResourcePostProcessorProvider) processorProvider;
						org.devboost.stanford.language.resource.txt.ITxtResourcePostProcessor postProcessor = csProcessorProvider.getResourcePostProcessor();
						runPostProcessor(postProcessor);
					}
				}
			}
		}
		return true;
	}
	
	/**
	 * Runs the given post processor to process this resource.
	 */
	protected void runPostProcessor(org.devboost.stanford.language.resource.txt.ITxtResourcePostProcessor postProcessor) {
		try {
			this.runningPostProcessor = postProcessor;
			postProcessor.process(this);
		} catch (Exception e) {
			new org.devboost.stanford.language.resource.txt.util.TxtRuntimeUtil().logError("Exception while running a post-processor.", e);
		}
		this.runningPostProcessor = null;
	}
	
	public void load(java.util.Map<?, ?> options) throws java.io.IOException {
		java.util.Map<Object, Object> loadOptions = addDefaultLoadOptions(options);
		super.load(loadOptions);
		resolveAfterParsing();
	}
	
	protected void resolveAfterParsing() {
		interruptibleResolver = new org.devboost.stanford.language.resource.txt.util.TxtInterruptibleEcoreResolver();
		interruptibleResolver.resolveAll(this);
		interruptibleResolver = null;
	}
	
	public void setURI(org.eclipse.emf.common.util.URI uri) {
		// because of the context dependent proxy resolving it is essential to resolve all
		// proxies before the URI is changed which can cause loss of object identities
		org.eclipse.emf.ecore.util.EcoreUtil.resolveAll(this);
		super.setURI(uri);
	}
	
	/**
	 * Returns the location map that contains information about the position of the
	 * contents of this resource in the original textual representation.
	 */
	public org.devboost.stanford.language.resource.txt.ITxtLocationMap getLocationMap() {
		return locationMap;
	}
	
	public void addProblem(org.devboost.stanford.language.resource.txt.ITxtProblem problem, org.eclipse.emf.ecore.EObject element) {
		ElementBasedTextDiagnostic diagnostic = new ElementBasedTextDiagnostic(locationMap, getURI(), problem, element);
		getDiagnostics(problem.getSeverity()).add(diagnostic);
		mark(diagnostic);
		addQuickFixesToQuickFixMap(problem);
	}
	
	public void addProblem(org.devboost.stanford.language.resource.txt.ITxtProblem problem, int column, int line, int charStart, int charEnd) {
		PositionBasedTextDiagnostic diagnostic = new PositionBasedTextDiagnostic(getURI(), problem, column, line, charStart, charEnd);
		getDiagnostics(problem.getSeverity()).add(diagnostic);
		mark(diagnostic);
		addQuickFixesToQuickFixMap(problem);
	}
	
	protected void addQuickFixesToQuickFixMap(org.devboost.stanford.language.resource.txt.ITxtProblem problem) {
		java.util.Collection<org.devboost.stanford.language.resource.txt.ITxtQuickFix> quickFixes = problem.getQuickFixes();
		if (quickFixes != null) {
			for (org.devboost.stanford.language.resource.txt.ITxtQuickFix quickFix : quickFixes) {
				if (quickFix != null) {
					quickFixMap.put(quickFix.getContextAsString(), quickFix);
				}
			}
		}
	}
	
	@Deprecated	
	public void addError(String message, org.eclipse.emf.ecore.EObject cause) {
		addError(message, org.devboost.stanford.language.resource.txt.TxtEProblemType.UNKNOWN, cause);
	}
	
	public void addError(String message, org.devboost.stanford.language.resource.txt.TxtEProblemType type, org.eclipse.emf.ecore.EObject cause) {
		addProblem(new org.devboost.stanford.language.resource.txt.mopp.TxtProblem(message, type, org.devboost.stanford.language.resource.txt.TxtEProblemSeverity.ERROR), cause);
	}
	
	@Deprecated	
	public void addWarning(String message, org.eclipse.emf.ecore.EObject cause) {
		addWarning(message, org.devboost.stanford.language.resource.txt.TxtEProblemType.UNKNOWN, cause);
	}
	
	public void addWarning(String message, org.devboost.stanford.language.resource.txt.TxtEProblemType type, org.eclipse.emf.ecore.EObject cause) {
		addProblem(new org.devboost.stanford.language.resource.txt.mopp.TxtProblem(message, type, org.devboost.stanford.language.resource.txt.TxtEProblemSeverity.WARNING), cause);
	}
	
	protected java.util.List<org.eclipse.emf.ecore.resource.Resource.Diagnostic> getDiagnostics(org.devboost.stanford.language.resource.txt.TxtEProblemSeverity severity) {
		if (severity == org.devboost.stanford.language.resource.txt.TxtEProblemSeverity.ERROR) {
			return getErrors();
		} else {
			return getWarnings();
		}
	}
	
	protected java.util.Map<Object, Object> addDefaultLoadOptions(java.util.Map<?, ?> loadOptions) {
		java.util.Map<Object, Object> loadOptionsCopy = org.devboost.stanford.language.resource.txt.util.TxtMapUtil.copySafelyToObjectToObjectMap(loadOptions);
		// first add static option provider
		loadOptionsCopy.putAll(new org.devboost.stanford.language.resource.txt.mopp.TxtOptionProvider().getOptions());
		
		// second, add dynamic option providers that are registered via extension
		if (new org.devboost.stanford.language.resource.txt.util.TxtRuntimeUtil().isEclipsePlatformAvailable()) {
			new org.devboost.stanford.language.resource.txt.util.TxtEclipseProxy().getDefaultLoadOptionProviderExtensions(loadOptionsCopy);
		}
		return loadOptionsCopy;
	}
	
	/**
	 * Extends the super implementation by clearing all information about element
	 * positions.
	 */
	protected void clearState() {
		// clear concrete syntax information
		resetLocationMap();
		internalURIFragmentMap.clear();
		getErrors().clear();
		getWarnings().clear();
		unmark(org.devboost.stanford.language.resource.txt.TxtEProblemType.UNKNOWN);
		unmark(org.devboost.stanford.language.resource.txt.TxtEProblemType.SYNTAX_ERROR);
		unmark(org.devboost.stanford.language.resource.txt.TxtEProblemType.UNRESOLVED_REFERENCE);
		proxyCounter = 0;
		resolverSwitch = null;
	}
	
	/**
	 * Returns a copy of the contents of this resource wrapped in a list that
	 * propagates changes to the original resource list. Wrapping is required to make
	 * sure that clients which obtain a reference to the list of contents do not
	 * interfere when changing the list.
	 */
	public org.eclipse.emf.common.util.EList<org.eclipse.emf.ecore.EObject> getContents() {
		if (terminateReload) {
			// the contents' state is currently unclear
			return new org.eclipse.emf.common.util.BasicEList<org.eclipse.emf.ecore.EObject>();
		}
		return new org.devboost.stanford.language.resource.txt.util.TxtCopiedEObjectInternalEList((org.eclipse.emf.ecore.util.InternalEList<org.eclipse.emf.ecore.EObject>) super.getContents());
	}
	
	/**
	 * Returns the raw contents of this resource. In contrast to getContents(), this
	 * methods does not return a copy of the content list, but the original list.
	 */
	public org.eclipse.emf.common.util.EList<org.eclipse.emf.ecore.EObject> getContentsInternal() {
		if (terminateReload) {
			// the contents' state is currently unclear
			return new org.eclipse.emf.common.util.BasicEList<org.eclipse.emf.ecore.EObject>();
		}
		return super.getContents();
	}
	
	/**
	 * Returns all warnings that are associated with this resource.
	 */
	public org.eclipse.emf.common.util.EList<org.eclipse.emf.ecore.resource.Resource.Diagnostic> getWarnings() {
		if (terminateReload) {
			// the contents' state is currently unclear
			return new org.eclipse.emf.common.util.BasicEList<org.eclipse.emf.ecore.resource.Resource.Diagnostic>();
		}
		return new org.devboost.stanford.language.resource.txt.util.TxtCopiedEList<org.eclipse.emf.ecore.resource.Resource.Diagnostic>(super.getWarnings());
	}
	
	/**
	 * Returns all errors that are associated with this resource.
	 */
	public org.eclipse.emf.common.util.EList<org.eclipse.emf.ecore.resource.Resource.Diagnostic> getErrors() {
		if (terminateReload) {
			// the contents' state is currently unclear
			return new org.eclipse.emf.common.util.BasicEList<org.eclipse.emf.ecore.resource.Resource.Diagnostic>();
		}
		return new org.devboost.stanford.language.resource.txt.util.TxtCopiedEList<org.eclipse.emf.ecore.resource.Resource.Diagnostic>(super.getErrors());
	}
	
	protected void runValidators(org.eclipse.emf.ecore.EObject root) {
		// checking constraints provided by EMF validator classes was disabled by option
		// 'disableEValidators'.
		
		if (new org.devboost.stanford.language.resource.txt.util.TxtRuntimeUtil().isEclipsePlatformAvailable()) {
			new org.devboost.stanford.language.resource.txt.util.TxtEclipseProxy().checkEMFValidationConstraints(this, root);
		}
	}
	
	public org.devboost.stanford.language.resource.txt.ITxtQuickFix getQuickFix(String quickFixContext) {
		return quickFixMap.get(quickFixContext);
	}
	
	protected void mark(org.devboost.stanford.language.resource.txt.ITxtTextDiagnostic diagnostic) {
		org.devboost.stanford.language.resource.txt.mopp.TxtMarkerHelper markerHelper = getMarkerHelper();
		if (markerHelper != null) {
			markerHelper.mark(this, diagnostic);
		}
	}
	
	protected void unmark(org.eclipse.emf.ecore.EObject cause) {
		org.devboost.stanford.language.resource.txt.mopp.TxtMarkerHelper markerHelper = getMarkerHelper();
		if (markerHelper != null) {
			markerHelper.unmark(this, cause);
		}
	}
	
	protected void unmark(org.devboost.stanford.language.resource.txt.TxtEProblemType analysisProblem) {
		org.devboost.stanford.language.resource.txt.mopp.TxtMarkerHelper markerHelper = getMarkerHelper();
		if (markerHelper != null) {
			markerHelper.unmark(this, analysisProblem);
		}
	}
	
	protected org.devboost.stanford.language.resource.txt.mopp.TxtMarkerHelper getMarkerHelper() {
		if (isMarkerCreationEnabled() && new org.devboost.stanford.language.resource.txt.util.TxtRuntimeUtil().isEclipsePlatformAvailable()) {
			if (markerHelper == null) {
				markerHelper = new org.devboost.stanford.language.resource.txt.mopp.TxtMarkerHelper();
			}
			return markerHelper;
		}
		return null;
	}
	
	public boolean isMarkerCreationEnabled() {
		if (loadOptions == null) {
			return true;
		}
		return !loadOptions.containsKey(org.devboost.stanford.language.resource.txt.ITxtOptions.DISABLE_CREATING_MARKERS_FOR_PROBLEMS);
	}
	
	protected boolean isLocationMapEnabled() {
		if (loadOptions == null) {
			return true;
		}
		return !loadOptions.containsKey(org.devboost.stanford.language.resource.txt.ITxtOptions.DISABLE_LOCATION_MAP);
	}
	
	protected boolean isLayoutInformationRecordingEnabled() {
		if (loadOptions == null) {
			return true;
		}
		return !loadOptions.containsKey(org.devboost.stanford.language.resource.txt.ITxtOptions.DISABLE_LAYOUT_INFORMATION_RECORDING);
	}
	
}
