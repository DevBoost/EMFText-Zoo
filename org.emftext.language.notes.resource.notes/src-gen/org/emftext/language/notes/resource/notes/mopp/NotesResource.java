/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.notes.resource.notes.mopp;

public class NotesResource extends org.eclipse.emf.ecore.resource.impl.ResourceImpl implements org.emftext.language.notes.resource.notes.INotesTextResource {
	
	public class ElementBasedTextDiagnostic implements org.emftext.language.notes.resource.notes.INotesTextDiagnostic {
		
		private final org.emftext.language.notes.resource.notes.INotesLocationMap locationMap;
		private final org.eclipse.emf.common.util.URI uri;
		private final org.eclipse.emf.ecore.EObject element;
		private final org.emftext.language.notes.resource.notes.INotesProblem problem;
		
		public ElementBasedTextDiagnostic(org.emftext.language.notes.resource.notes.INotesLocationMap locationMap, org.eclipse.emf.common.util.URI uri, org.emftext.language.notes.resource.notes.INotesProblem problem, org.eclipse.emf.ecore.EObject element) {
			super();
			this.uri = uri;
			this.locationMap = locationMap;
			this.element = element;
			this.problem = problem;
		}
		
		public String getMessage() {
			return problem.getMessage();
		}
		
		public org.emftext.language.notes.resource.notes.INotesProblem getProblem() {
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
	
	public class PositionBasedTextDiagnostic implements org.emftext.language.notes.resource.notes.INotesTextDiagnostic {
		
		private final org.eclipse.emf.common.util.URI uri;
		
		private int column;
		private int line;
		private int charStart;
		private int charEnd;
		private org.emftext.language.notes.resource.notes.INotesProblem problem;
		
		public PositionBasedTextDiagnostic(org.eclipse.emf.common.util.URI uri, org.emftext.language.notes.resource.notes.INotesProblem problem, int column, int line, int charStart, int charEnd) {
			
			super();
			this.uri = uri;
			this.column = column;
			this.line = line;
			this.charStart = charStart;
			this.charEnd = charEnd;
			this.problem = problem;
		}
		
		public org.emftext.language.notes.resource.notes.INotesProblem getProblem() {
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
	
	private org.emftext.language.notes.resource.notes.INotesReferenceResolverSwitch resolverSwitch;
	private org.emftext.language.notes.resource.notes.INotesLocationMap locationMap;
	private int proxyCounter = 0;
	private org.emftext.language.notes.resource.notes.INotesTextParser parser;
	private java.util.Map<String, org.emftext.language.notes.resource.notes.INotesContextDependentURIFragment<? extends org.eclipse.emf.ecore.EObject>> internalURIFragmentMap = new java.util.LinkedHashMap<String, org.emftext.language.notes.resource.notes.INotesContextDependentURIFragment<? extends org.eclipse.emf.ecore.EObject>>();
	private java.util.Map<String, org.emftext.language.notes.resource.notes.INotesQuickFix> quickFixMap = new java.util.LinkedHashMap<String, org.emftext.language.notes.resource.notes.INotesQuickFix>();
	private java.util.Map<?, ?> loadOptions;
	
	/**
	 * If a post-processor is currently running, this field holds a reference to it.
	 * This reference is used to terminate post-processing if needed.
	 */
	private org.emftext.language.notes.resource.notes.INotesResourcePostProcessor runningPostProcessor;
	
	/**
	 * A flag to indicate whether reloading of the resource shall be cancelled.
	 */
	private boolean terminateReload = false;
	
	public NotesResource() {
		super();
		resetLocationMap();
	}
	
	public NotesResource(org.eclipse.emf.common.util.URI uri) {
		super(uri);
		resetLocationMap();
	}
	
	protected void doLoad(java.io.InputStream inputStream, java.util.Map<?,?> options) throws java.io.IOException {
		this.loadOptions = options;
		resetLocationMap();
		this.terminateReload = false;
		String encoding = null;
		java.io.InputStream actualInputStream = inputStream;
		Object inputStreamPreProcessorProvider = null;
		if (options != null) {
			inputStreamPreProcessorProvider = options.get(org.emftext.language.notes.resource.notes.INotesOptions.INPUT_STREAM_PREPROCESSOR_PROVIDER);
		}
		if (inputStreamPreProcessorProvider != null) {
			if (inputStreamPreProcessorProvider instanceof org.emftext.language.notes.resource.notes.INotesInputStreamProcessorProvider) {
				org.emftext.language.notes.resource.notes.INotesInputStreamProcessorProvider provider = (org.emftext.language.notes.resource.notes.INotesInputStreamProcessorProvider) inputStreamPreProcessorProvider;
				org.emftext.language.notes.resource.notes.mopp.NotesInputStreamProcessor processor = provider.getInputStreamProcessor(inputStream);
				actualInputStream = processor;
				encoding = processor.getOutputEncoding();
			}
		}
		
		parser = getMetaInformation().createParser(actualInputStream, encoding);
		parser.setOptions(options);
		org.emftext.language.notes.resource.notes.INotesReferenceResolverSwitch referenceResolverSwitch = getReferenceResolverSwitch();
		referenceResolverSwitch.setOptions(options);
		org.emftext.language.notes.resource.notes.INotesParseResult result = parser.parse();
		clearState();
		getContentsInternal().clear();
		org.eclipse.emf.ecore.EObject root = null;
		if (result != null) {
			root = result.getRoot();
			if (root != null) {
				getContentsInternal().add(root);
			}
			java.util.Collection<org.emftext.language.notes.resource.notes.INotesCommand<org.emftext.language.notes.resource.notes.INotesTextResource>> commands = result.getPostParseCommands();
			if (commands != null) {
				for (org.emftext.language.notes.resource.notes.INotesCommand<org.emftext.language.notes.resource.notes.INotesTextResource>  command : commands) {
					command.execute(this);
				}
			}
		}
		getReferenceResolverSwitch().setOptions(options);
		if (getErrors().isEmpty()) {
			runPostProcessors(options);
			if (root != null) {
				runValidators(root);
			}
		}
	}
	
	public void reload(java.io.InputStream inputStream, java.util.Map<?,?> options) throws java.io.IOException {
		try {
			isLoaded = false;
			java.util.Map<Object, Object> loadOptions = addDefaultLoadOptions(options);
			doLoad(inputStream, loadOptions);
			resolveAfterParsing();
		} catch (org.emftext.language.notes.resource.notes.mopp.NotesTerminateParsingException tpe) {
			// do nothing - the resource is left unchanged if this exception is thrown
		}
		isLoaded = true;
	}
	
	public void cancelReload() {
		org.emftext.language.notes.resource.notes.INotesTextParser parserCopy = parser;
		parserCopy.terminate();
		this.terminateReload = true;
		org.emftext.language.notes.resource.notes.INotesResourcePostProcessor runningPostProcessorCopy = runningPostProcessor;
		if (runningPostProcessorCopy != null) {
			runningPostProcessorCopy.terminate();
		}
	}
	
	protected void doSave(java.io.OutputStream outputStream, java.util.Map<?,?> options) throws java.io.IOException {
		org.emftext.language.notes.resource.notes.INotesTextPrinter printer = getMetaInformation().createPrinter(outputStream, this);
		org.emftext.language.notes.resource.notes.INotesReferenceResolverSwitch referenceResolverSwitch = getReferenceResolverSwitch();
		referenceResolverSwitch.setOptions(options);
		for (org.eclipse.emf.ecore.EObject root : getContentsInternal()) {
			printer.print(root);
		}
	}
	
	protected String getSyntaxName() {
		return "notes";
	}
	
	public org.emftext.language.notes.resource.notes.INotesReferenceResolverSwitch getReferenceResolverSwitch() {
		if (resolverSwitch == null) {
			resolverSwitch = new org.emftext.language.notes.resource.notes.mopp.NotesReferenceResolverSwitch();
		}
		return resolverSwitch;
	}
	
	public org.emftext.language.notes.resource.notes.mopp.NotesMetaInformation getMetaInformation() {
		return new org.emftext.language.notes.resource.notes.mopp.NotesMetaInformation();
	}
	
	protected void resetLocationMap() {
		if (isLocationMapEnabled()) {
			locationMap = new org.emftext.language.notes.resource.notes.mopp.NotesLocationMap();
		} else {
			locationMap = new org.emftext.language.notes.resource.notes.mopp.NotesDevNullLocationMap();
		}
	}
	
	public void addURIFragment(String internalURIFragment, org.emftext.language.notes.resource.notes.INotesContextDependentURIFragment<? extends org.eclipse.emf.ecore.EObject> uriFragment) {
		internalURIFragmentMap.put(internalURIFragment, uriFragment);
	}
	
	public <ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject> void registerContextDependentProxy(org.emftext.language.notes.resource.notes.INotesContextDependentURIFragmentFactory<ContainerType, ReferenceType> factory, ContainerType container, org.eclipse.emf.ecore.EReference reference, String id, org.eclipse.emf.ecore.EObject proxyElement, int position) {
		org.eclipse.emf.ecore.InternalEObject proxy = (org.eclipse.emf.ecore.InternalEObject) proxyElement;
		String internalURIFragment = org.emftext.language.notes.resource.notes.INotesContextDependentURIFragment.INTERNAL_URI_FRAGMENT_PREFIX + (proxyCounter++) + "_" + id;
		org.emftext.language.notes.resource.notes.INotesContextDependentURIFragment<?> uriFragment = factory.create(id, container, reference, position, proxy);
		proxy.eSetProxyURI(getURI().appendFragment(internalURIFragment));
		addURIFragment(internalURIFragment, uriFragment);
	}
	
	public org.eclipse.emf.ecore.EObject getEObject(String id) {
		if (internalURIFragmentMap.containsKey(id)) {
			org.emftext.language.notes.resource.notes.INotesContextDependentURIFragment<? extends org.eclipse.emf.ecore.EObject> uriFragment = internalURIFragmentMap.get(id);
			boolean wasResolvedBefore = uriFragment.isResolved();
			org.emftext.language.notes.resource.notes.INotesReferenceResolveResult<? extends org.eclipse.emf.ecore.EObject> result = null;
			// catch and report all Exceptions that occur during proxy resolving
			try {
				result = uriFragment.resolve();
			} catch (Exception e) {
				String message = "An expection occured while resolving the proxy for: "+ id + ". (" + e.toString() + ")";
				addProblem(new org.emftext.language.notes.resource.notes.mopp.NotesProblem(message, org.emftext.language.notes.resource.notes.NotesEProblemType.UNRESOLVED_REFERENCE, org.emftext.language.notes.resource.notes.NotesEProblemSeverity.ERROR), uriFragment.getProxy());
				new org.emftext.language.notes.resource.notes.util.NotesRuntimeUtil().logError(message, e);
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
				org.emftext.language.notes.resource.notes.INotesReferenceMapping<? extends org.eclipse.emf.ecore.EObject> mapping = result.getMappings().iterator().next();
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
			if (adapter instanceof org.emftext.language.notes.resource.notes.mopp.NotesLayoutInformationAdapter) {
				org.emftext.language.notes.resource.notes.mopp.NotesLayoutInformationAdapter layoutInformationAdapter = (org.emftext.language.notes.resource.notes.mopp.NotesLayoutInformationAdapter) adapter;
				layoutInformationAdapter.replaceProxy(proxy, target);
			}
		}
	}
	
	protected org.eclipse.emf.ecore.EObject getResultElement(org.emftext.language.notes.resource.notes.INotesContextDependentURIFragment<? extends org.eclipse.emf.ecore.EObject> uriFragment, org.emftext.language.notes.resource.notes.INotesReferenceMapping<? extends org.eclipse.emf.ecore.EObject> mapping, org.eclipse.emf.ecore.EObject proxy, final String errorMessage) {
		if (mapping instanceof org.emftext.language.notes.resource.notes.INotesURIMapping<?>) {
			org.eclipse.emf.common.util.URI uri = ((org.emftext.language.notes.resource.notes.INotesURIMapping<? extends org.eclipse.emf.ecore.EObject>)mapping).getTargetIdentifier();
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
						addProblem(new org.emftext.language.notes.resource.notes.mopp.NotesProblem(errorMessage, org.emftext.language.notes.resource.notes.NotesEProblemType.UNRESOLVED_REFERENCE, org.emftext.language.notes.resource.notes.NotesEProblemSeverity.ERROR), proxy);
					}
				}
				return result;
			}
			return null;
		} else if (mapping instanceof org.emftext.language.notes.resource.notes.INotesElementMapping<?>) {
			org.eclipse.emf.ecore.EObject element = ((org.emftext.language.notes.resource.notes.INotesElementMapping<? extends org.eclipse.emf.ecore.EObject>)mapping).getTargetElement();
			org.eclipse.emf.ecore.EReference reference = uriFragment.getReference();
			org.eclipse.emf.ecore.EReference oppositeReference = uriFragment.getReference().getEOpposite();
			if (!uriFragment.getReference().isContainment() && oppositeReference != null) {
				if (reference.isMany()) {
					org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList.ManyInverse<org.eclipse.emf.ecore.EObject> list = org.emftext.language.notes.resource.notes.util.NotesCastUtil.cast(element.eGet(oppositeReference, false));										// avoids duplicate entries in the reference caused by adding to the
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
			if (errorCand instanceof org.emftext.language.notes.resource.notes.INotesTextDiagnostic) {
				if (((org.emftext.language.notes.resource.notes.INotesTextDiagnostic) errorCand).wasCausedBy(cause)) {
					diagnostics.remove(errorCand);
					if (new org.emftext.language.notes.resource.notes.util.NotesRuntimeUtil().isEclipsePlatformAvailable()) {
						org.emftext.language.notes.resource.notes.mopp.NotesMarkerHelper.unmark(this, cause);
					}
				}
			}
		}
	}
	
	protected void attachResolveError(org.emftext.language.notes.resource.notes.INotesReferenceResolveResult<?> result, org.eclipse.emf.ecore.EObject proxy) {
		// attach errors to this resource
		assert result != null;
		final String errorMessage = result.getErrorMessage();
		if (errorMessage == null) {
			assert(false);
		} else {
			addProblem(new org.emftext.language.notes.resource.notes.mopp.NotesProblem(errorMessage, org.emftext.language.notes.resource.notes.NotesEProblemType.UNRESOLVED_REFERENCE, org.emftext.language.notes.resource.notes.NotesEProblemSeverity.ERROR, result.getQuickFixes()), proxy);
		}
	}
	
	protected void attachResolveWarnings(org.emftext.language.notes.resource.notes.INotesReferenceResolveResult<? extends org.eclipse.emf.ecore.EObject> result, org.eclipse.emf.ecore.EObject proxy) {
		assert result != null;
		assert result.wasResolved();
		if (result.wasResolved()) {
			for (org.emftext.language.notes.resource.notes.INotesReferenceMapping<? extends org.eclipse.emf.ecore.EObject> mapping : result.getMappings()) {
				final String warningMessage = mapping.getWarning();
				if (warningMessage == null) {
					continue;
				}
				addProblem(new org.emftext.language.notes.resource.notes.mopp.NotesProblem(warningMessage, org.emftext.language.notes.resource.notes.NotesEProblemType.UNRESOLVED_REFERENCE, org.emftext.language.notes.resource.notes.NotesEProblemSeverity.WARNING), proxy);
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
	
	protected void runPostProcessors(java.util.Map<?, ?> loadOptions) {
		if (new org.emftext.language.notes.resource.notes.util.NotesRuntimeUtil().isEclipsePlatformAvailable()) {
			org.emftext.language.notes.resource.notes.mopp.NotesMarkerHelper.unmark(this, org.emftext.language.notes.resource.notes.NotesEProblemType.ANALYSIS_PROBLEM);
		}
		if (terminateReload) {
			return;
		}
		// first, run the generated post processor
		runPostProcessor(new org.emftext.language.notes.resource.notes.mopp.NotesResourcePostProcessor());
		if (loadOptions == null) {
			return;
		}
		// then, run post processors that are registered via the load options extension
		// point
		Object resourcePostProcessorProvider = loadOptions.get(org.emftext.language.notes.resource.notes.INotesOptions.RESOURCE_POSTPROCESSOR_PROVIDER);
		if (resourcePostProcessorProvider != null) {
			if (resourcePostProcessorProvider instanceof org.emftext.language.notes.resource.notes.INotesResourcePostProcessorProvider) {
				runPostProcessor(((org.emftext.language.notes.resource.notes.INotesResourcePostProcessorProvider) resourcePostProcessorProvider).getResourcePostProcessor());
			} else if (resourcePostProcessorProvider instanceof java.util.Collection<?>) {
				java.util.Collection<?> resourcePostProcessorProviderCollection = (java.util.Collection<?>) resourcePostProcessorProvider;
				for (Object processorProvider : resourcePostProcessorProviderCollection) {
					if (terminateReload) {
						return;
					}
					if (processorProvider instanceof org.emftext.language.notes.resource.notes.INotesResourcePostProcessorProvider) {
						org.emftext.language.notes.resource.notes.INotesResourcePostProcessorProvider csProcessorProvider = (org.emftext.language.notes.resource.notes.INotesResourcePostProcessorProvider) processorProvider;
						org.emftext.language.notes.resource.notes.INotesResourcePostProcessor postProcessor = csProcessorProvider.getResourcePostProcessor();
						runPostProcessor(postProcessor);
					}
				}
			}
		}
	}
	
	protected void runPostProcessor(org.emftext.language.notes.resource.notes.INotesResourcePostProcessor postProcessor) {
		try {
			this.runningPostProcessor = postProcessor;
			postProcessor.process(this);
		} catch (Exception e) {
			new org.emftext.language.notes.resource.notes.util.NotesRuntimeUtil().logError("Exception while running a post-processor.", e);
		}
		this.runningPostProcessor = null;
	}
	
	public void load(java.util.Map<?, ?> options) throws java.io.IOException {
		java.util.Map<Object, Object> loadOptions = addDefaultLoadOptions(options);
		super.load(loadOptions);
		resolveAfterParsing();
	}
	
	protected void resolveAfterParsing() {
		org.eclipse.emf.ecore.util.EcoreUtil.resolveAll(this);
	}
	
	public void setURI(org.eclipse.emf.common.util.URI uri) {
		// because of the context dependent proxy resolving it is essential to resolve all
		// proxies before the URI is changed which can cause loss of object identities
		org.eclipse.emf.ecore.util.EcoreUtil.resolveAll(this);
		super.setURI(uri);
	}
	
	public org.emftext.language.notes.resource.notes.INotesLocationMap getLocationMap() {
		return locationMap;
	}
	
	public void addProblem(org.emftext.language.notes.resource.notes.INotesProblem problem, org.eclipse.emf.ecore.EObject element) {
		ElementBasedTextDiagnostic diagnostic = new ElementBasedTextDiagnostic(locationMap, getURI(), problem, element);
		getDiagnostics(problem.getSeverity()).add(diagnostic);
		if (new org.emftext.language.notes.resource.notes.util.NotesRuntimeUtil().isEclipsePlatformAvailable() && isMarkerCreationEnabled()) {
			org.emftext.language.notes.resource.notes.mopp.NotesMarkerHelper.mark(this, diagnostic);
		}
		addQuickFixesToQuickFixMap(problem);
	}
	
	public void addProblem(org.emftext.language.notes.resource.notes.INotesProblem problem, int column, int line, int charStart, int charEnd) {
		PositionBasedTextDiagnostic diagnostic = new PositionBasedTextDiagnostic(getURI(), problem, column, line, charStart, charEnd);
		getDiagnostics(problem.getSeverity()).add(diagnostic);
		if (new org.emftext.language.notes.resource.notes.util.NotesRuntimeUtil().isEclipsePlatformAvailable() && isMarkerCreationEnabled()) {
			org.emftext.language.notes.resource.notes.mopp.NotesMarkerHelper.mark(this, diagnostic);
		}
		addQuickFixesToQuickFixMap(problem);
	}
	
	protected void addQuickFixesToQuickFixMap(org.emftext.language.notes.resource.notes.INotesProblem problem) {
		java.util.Collection<org.emftext.language.notes.resource.notes.INotesQuickFix> quickFixes = problem.getQuickFixes();
		if (quickFixes != null) {
			for (org.emftext.language.notes.resource.notes.INotesQuickFix quickFix : quickFixes) {
				if (quickFix != null) {
					quickFixMap.put(quickFix.getContextAsString(), quickFix);
				}
			}
		}
	}
	
	@Deprecated	
	public void addError(String message, org.eclipse.emf.ecore.EObject cause) {
		addError(message, org.emftext.language.notes.resource.notes.NotesEProblemType.UNKNOWN, cause);
	}
	
	public void addError(String message, org.emftext.language.notes.resource.notes.NotesEProblemType type, org.eclipse.emf.ecore.EObject cause) {
		addProblem(new org.emftext.language.notes.resource.notes.mopp.NotesProblem(message, type, org.emftext.language.notes.resource.notes.NotesEProblemSeverity.ERROR), cause);
	}
	
	@Deprecated	
	public void addWarning(String message, org.eclipse.emf.ecore.EObject cause) {
		addWarning(message, org.emftext.language.notes.resource.notes.NotesEProblemType.UNKNOWN, cause);
	}
	
	public void addWarning(String message, org.emftext.language.notes.resource.notes.NotesEProblemType type, org.eclipse.emf.ecore.EObject cause) {
		addProblem(new org.emftext.language.notes.resource.notes.mopp.NotesProblem(message, type, org.emftext.language.notes.resource.notes.NotesEProblemSeverity.WARNING), cause);
	}
	
	protected java.util.List<org.eclipse.emf.ecore.resource.Resource.Diagnostic> getDiagnostics(org.emftext.language.notes.resource.notes.NotesEProblemSeverity severity) {
		if (severity == org.emftext.language.notes.resource.notes.NotesEProblemSeverity.ERROR) {
			return getErrors();
		} else {
			return getWarnings();
		}
	}
	
	protected java.util.Map<Object, Object> addDefaultLoadOptions(java.util.Map<?, ?> loadOptions) {
		java.util.Map<Object, Object> loadOptionsCopy = org.emftext.language.notes.resource.notes.util.NotesMapUtil.copySafelyToObjectToObjectMap(loadOptions);
		// first add static option provider
		loadOptionsCopy.putAll(new org.emftext.language.notes.resource.notes.mopp.NotesOptionProvider().getOptions());
		
		// second, add dynamic option providers that are registered via extension
		if (new org.emftext.language.notes.resource.notes.util.NotesRuntimeUtil().isEclipsePlatformAvailable()) {
			new org.emftext.language.notes.resource.notes.util.NotesEclipseProxy().getDefaultLoadOptionProviderExtensions(loadOptionsCopy);
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
		if (new org.emftext.language.notes.resource.notes.util.NotesRuntimeUtil().isEclipsePlatformAvailable() && isMarkerCreationEnabled()) {
			org.emftext.language.notes.resource.notes.mopp.NotesMarkerHelper.unmark(this, org.emftext.language.notes.resource.notes.NotesEProblemType.UNKNOWN);
			org.emftext.language.notes.resource.notes.mopp.NotesMarkerHelper.unmark(this, org.emftext.language.notes.resource.notes.NotesEProblemType.SYNTAX_ERROR);
			org.emftext.language.notes.resource.notes.mopp.NotesMarkerHelper.unmark(this, org.emftext.language.notes.resource.notes.NotesEProblemType.UNRESOLVED_REFERENCE);
		}
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
		return new org.emftext.language.notes.resource.notes.util.NotesCopiedEObjectInternalEList((org.eclipse.emf.ecore.util.InternalEList<org.eclipse.emf.ecore.EObject>) super.getContents());
	}
	
	/**
	 * Returns the raw contents of this resource.
	 */
	public org.eclipse.emf.common.util.EList<org.eclipse.emf.ecore.EObject> getContentsInternal() {
		return super.getContents();
	}
	
	public org.eclipse.emf.common.util.EList<org.eclipse.emf.ecore.resource.Resource.Diagnostic> getWarnings() {
		return new org.emftext.language.notes.resource.notes.util.NotesCopiedEList<org.eclipse.emf.ecore.resource.Resource.Diagnostic>(super.getWarnings());
	}
	
	public org.eclipse.emf.common.util.EList<org.eclipse.emf.ecore.resource.Resource.Diagnostic> getErrors() {
		return new org.emftext.language.notes.resource.notes.util.NotesCopiedEList<org.eclipse.emf.ecore.resource.Resource.Diagnostic>(super.getErrors());
	}
	
	protected void runValidators(org.eclipse.emf.ecore.EObject root) {
		// checking constraints provided by EMF validator classes was disabled by option
		// 'disableEValidators'.
		
		if (new org.emftext.language.notes.resource.notes.util.NotesRuntimeUtil().isEclipsePlatformAvailable()) {
			new org.emftext.language.notes.resource.notes.util.NotesEclipseProxy().checkEMFValidationConstraints(this, root);
		}
	}
	
	public org.emftext.language.notes.resource.notes.INotesQuickFix getQuickFix(String quickFixContext) {
		return quickFixMap.get(quickFixContext);
	}
	
	public boolean isMarkerCreationEnabled() {
		if (loadOptions == null) {
			return true;
		}
		return !loadOptions.containsKey(org.emftext.language.notes.resource.notes.INotesOptions.DISABLE_CREATING_MARKERS_FOR_PROBLEMS);
	}
	
	protected boolean isLocationMapEnabled() {
		if (loadOptions == null) {
			return true;
		}
		return !loadOptions.containsKey(org.emftext.language.notes.resource.notes.INotesOptions.DISABLE_LOCATION_MAP);
	}
	
}
