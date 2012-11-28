package dk.itu.sdg.language.xwpf


import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.xwpf.usermodel.IBody
import org.apache.poi.xwpf.usermodel.XWPFComment;
import org.apache.poi.xwpf.usermodel.XWPFDocument
import org.apache.poi.xwpf.usermodel.XWPFFooter
import org.apache.poi.xwpf.usermodel.XWPFHeader
import org.apache.poi.xwpf.usermodel.XWPFHyperlink;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun
import org.eclipse.core.internal.resources.File;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl

import dk.itu.sdg.language.xwpf.Comment
import dk.itu.sdg.language.xwpf.Paragraph
import dk.itu.sdg.language.xwpf.Document
import dk.itu.sdg.language.xwpf.Footer
import dk.itu.sdg.language.xwpf.Header
import dk.itu.sdg.language.xwpf.Paragraph as ModelParagraph
import dk.itu.sdg.language.xwpf.XwpfFactory
import dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfResourceFactory

import org.eclipse.emf.common.util.URI
import org.devboost.stanford.language.LanguageCreator
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl
import org.eclipse.core.internal.resources.File

class DocX2Model {
	
	def uri
	def File file
	def static private LanguageCreator languageCreator = new LanguageCreator()

	static final String XMI = "xmi"
	static final String XWPF = "xwpf"

	static final String DOCX = "docx"
	
	
	public DocX2Model(File file) {
		this.file = file
	}
	
	public EObject transform() {
		
		this.uri = file.getLocationURI()
		
		def XWPFDocument wordDocument = new XWPFDocument(new FileInputStream(file.getLocation().toString()))
				
		def headers = wordDocument.getHeaderList()
		def footers = wordDocument.getFooterList()
		def paragraphs = wordDocument.getParagraphs()
		def comments = wordDocument.getComments()
		def links = wordDocument.getHyperlinks()
		//TODO: implement conversion of Tables and  Pictures 
		
		def elements = [] 
		elements.addAll(headers)
		elements.addAll(footers)
		elements.addAll(paragraphs)
		elements.addAll(comments)
		elements.addAll(links)
				
		def XwpfFactory factory = XwpfFactory.eINSTANCE;
		def Document modelDocument = factory.createDocument()
		
		def long startTime = System.currentTimeMillis()
		
		elements.each {element -> 
			this.convert(element, factory, modelDocument)
		}
		def long estimatedTime = System.currentTimeMillis() - startTime
		println("convertion took " + estimatedTime / 1000 / 60 + " minutes")

		return modelDocument
	}
	
	/**
	 * Convert headers to model
	 * @param header
	 * @param factory
	 * @param modelDocument
	 * @return
	 */
	private Document convert(XWPFHeader header, XwpfFactory factory, Document modelDocument) {
		def Header modelHeader = factory.createHeader()
		modelHeader.setText(header.getText())
		modelHeader.setNlpContent(languageCreator.parse(header.getText()))
		modelDocument.headers.add(modelHeader)
		
		return modelDocument
	}
	
	/**
	 * Convert footer to model
	 * @param footer
	 * @param factory
	 * @param modelDocument
	 * @return
	 */
	private Document convert(XWPFFooter footer, XwpfFactory factory, Document modelDocument) {
		def Footer modelFooter = factory.createFooter()
		modelFooter.setText(footer.getText())
		modelFooter.setNlpContent(languageCreator.parse(footer.getText()))
		modelDocument.footers.add(modelFooter)
		
		return modelDocument
	}

	/**
	 * Convert paragraph
	 * @param paragraph
	 * @param factory
	 * @param modelDocument
	 * @return
	 */
	private Document convert(XWPFParagraph paragraph, XwpfFactory factory, Document modelDocument) {		
		
		def Paragraph modelParagraph = factory.createParagraph()
		modelParagraph.setText(paragraph.getText())
		modelParagraph.setNlpContent(languageCreator.parse(paragraph.getText()))
		
		modelParagraph.setAlignment(paragraph.getAlignment().getValue())
		modelParagraph.setBorderBottom(paragraph.getBorderBottom().getValue())
		modelParagraph.setBorderTop(paragraph.getBorderTop().getValue())
		modelParagraph.setBorderBetween(paragraph.getBorderBetween().getValue())
		modelParagraph.setBorderLeft(paragraph.getBorderLeft().getValue())
		modelParagraph.setBorderRight(paragraph.getBorderRight().getValue())
		modelParagraph.setVerticalAlignment(paragraph.getVerticalAlignment().getValue())
		
		modelParagraph.setFootnoteText(paragraph.getFootnoteText())
		
		modelParagraph.setIndentFstLine(paragraph.getIndentationFirstLine())
		modelParagraph.setIndentHanging(paragraph.getIndentationHanging())
		modelParagraph.setIndentLeft(paragraph.getIndentationLeft())
		modelParagraph.setIndentRight(paragraph.getIndentationRight())
		
		modelParagraph.setSpacingAfter(paragraph.getSpacingAfter())
		modelParagraph.setSpacingAfterLines(paragraph.getSpacingAfterLines())
		modelParagraph.setSpacingBefore(paragraph.getSpacingBefore())
		modelParagraph.setSpacingBeforeLines(paragraph.getSpacingBeforeLines())
		modelParagraph.setSpacingLineRule(paragraph.getSpacingLineRule().getValue())
		
//		if (paragraph.getStyle().equals(Style.UNRECOGNIZED.getLiteral())) {
//			modelParagraph.setStyle(Style.UNRECOGNIZED)
//		} else if (paragraph.getStyle().equals(Style.HEADING1.getLiteral())) {
//			modelParagraph.setStyle(Style.HEADING1)
//		} else if (paragraph.getStyle().equals(Style.HEADING2.getLiteral())) {
//			modelParagraph.setStyle(Style.HEADING2)
//		} else if (paragraph.getStyle().equals(Style.HEADING3.getLiteral())) {
//			modelParagraph.setStyle(Style.HEADING3)
//		} else if (paragraph.getStyle().equals(Style.HEADING4.getLiteral())) {
//			modelParagraph.setStyle(Style.HEADING4)
//		} else if (paragraph.getStyle().equals(Style.BODY_TEXT.getLiteral())) {
//			modelParagraph.setStyle(Style.BODY_TEXT)
//		} else if (paragraph.getStyle().equals(Style.BODY_TEXT_WITH_LIST.getLiteral())) {
//			modelParagraph.setStyle(Style.BODY_TEXT_WITH_LIST)
//		} else if (paragraph.getStyle().equals(Style.LIST_PARAGRAPH.getLiteral())) {
//			modelParagraph.setStyle(Style.LIST_PARAGRAPH)
//		} else if (paragraph.getStyle().equals(Style.LIST_BULLET1.getLiteral())) {
//			modelParagraph.setStyle(Style.LIST_BULLET1)
//		} else if (paragraph.getStyle().equals(Style.LIST_BULLET2.getLiteral())) {
//			modelParagraph.setStyle(Style.LIST_BULLET2)
//		} else if (paragraph.getStyle().equals(Style.LIST_BULLET3.getLiteral())) {
//			modelParagraph.setStyle(Style.LIST_BULLET3)
//		} else if (paragraph.getStyle().equals(Style.NORMAL.getLiteral())) {
//			modelParagraph.setStyle(Style.NORMAL)
//		} 
		
		switch (paragraph.getStyle()) {
		
			case Style.UNRECOGNIZED:
				modelParagraph.setStyle(Style.UNRECOGNIZED)
				break;

			case Style.HEADING1:
				modelParagraph.setStyle(Style.HEADING1)
				break;

			case Style.HEADING2:
				modelParagraph.setStyle(Style.HEADING2)
				break;
				case Style.HEADING3:
				modelParagraph.setStyle(Style.HEADING3)
				break;

			case Style.HEADING4:
				modelParagraph.setStyle(Style.HEADING4)
				break;

			case Style.BODY_TEXT:
				modelParagraph.setStyle(Style.BODY_TEXT)
				break;
			
			case Style.BODY_TEXT_WITH_LIST:
				modelParagraph.setStyle(Style.BODY_TEXT_WITH_LIST)
				break;

			case Style.LIST_PARAGRAPH:
				modelParagraph.setStyle(Style.LIST_PARAGRAPH)
				break;

			case Style.LIST_BULLET1:
				modelParagraph.setStyle(Style.LIST_BULLET1)
				break;
				case Style.LIST_BULLET2:
				modelParagraph.setStyle(Style.LIST_BULLET2)
				break;

			case Style.LIST_BULLET3:
				modelParagraph.setStyle(Style.LIST_BULLET3)
				break;

			case Style.NORMAL:
				modelParagraph.setStyle(Style.NORMAL)
				break;
				
			default:
				break;
		}
		
		
		paragraph.getRuns().each{ run ->
			this.convert(run, factory, modelParagraph)
		}
		
		this.convert(paragraph.getPart(), factory, modelParagraph)
		this.convert(paragraph.getBody(), factory, modelParagraph)
		
		modelDocument.paragraphs.add(modelParagraph)
		
		return modelDocument
	}
		
	private Document convert(XWPFComment comment, XwpfFactory factory, Document modelDocument) {
		def Comment modelComment = factory.createComment()
		modelComment.setText(comment.getText())
		modelComment.setNlpContent(languageCreator.parse(comment.getText()))
		modelComment.setIdentifier(comment.getId())
		modelComment.setAuthor(comment.getAuthor())
		
		modelDocument.comments.add(modelComment)
		
		return modelDocument
	}
	
	private ModelParagraph convert(XWPFRun run, XwpfFactory factory, ModelParagraph modelParagraph) {
		
		def Run modelRun = factory.createRun()
		
		modelRun.setFontFamily(run.getFontFamily())
		modelRun.setFontSize(run.getFontSize())
		modelRun.setIsBold(run.isBold())
		modelRun.setIsItalic(run.isItalic())
		modelRun.setIsStrike(run.isStrike())
		modelRun.setColor(run.getColor())
		modelRun.setTextPosition(run.getTextPosition())
		modelRun.setText(run.getText(run.getTextPosition()))
		
		modelParagraph.runs.add(modelRun)
		
		return modelParagraph
	}
	
	private ModelParagraph convert(IBody body, XwpfFactory factory, ModelParagraph modelParagraph) {
		
		def Body modelBody = factory.createBody()
		
				
		modelParagraph.setBody(modelBody)
		
		return modelParagraph
	}
	
	
	private ModelParagraph convert(POIXMLDocumentPart part, XwpfFactory factory, ModelParagraph modelParagraph) {
		
		def Part modelPart = factory.createPart()
		
		part.getRelations()
				
		modelParagraph.setPart(modelPart)
		
		return modelParagraph
	}
	
	private Document convert(XWPFHyperlink hyperlink, XwpfFactory factory, Document modelDocument) {
		def Hyperlink modelLink = factory.createHyperlink()
		modelLink.setIdentifier(hyperlink.getId())
		modelLink.setUrl(hyperlink.getURL().toString())
		modelDocument.hyperlinks.add(modelLink)
		
		return modelDocument
	}
	
	public void saveModel(Document modelDocument) {
		
		
		Resource.Factory.Registry resourceRegistry = Resource.Factory.Registry.INSTANCE
		Map<String, Object> m = resourceRegistry.getExtensionToFactoryMap()
		m.put(XWPF, new XwpfResourceFactory())
	
		ResourceSet resourceSet = new ResourceSetImpl()
		
		def location = "/" + file.getProjectRelativePath().toString().replace(DOCX, XWPF)
		def project = file.getProject().toString().replace("P","")
		
		URI newUri = URI.createURI(project + location)
		Resource resource = resourceSet.createResource(newUri)
		resource.getContents().add(modelDocument)
	
		try {
			resource.save(null)
		} catch (IOException e) {
			e.printStackTrace()
		}
	}

	public void saveXMI(Document modelDocument, File file) {
		
		
		Resource.Factory.Registry resourceRegistry = Resource.Factory.Registry.INSTANCE
		Map<String, Object> m = resourceRegistry.getExtensionToFactoryMap()
		m.put(XMI, new XMIResourceFactoryImpl())
	
		ResourceSet resourceSet = new ResourceSetImpl()
		def location = "/" + file.getProjectRelativePath().toString().replace(DOCX, XMI)
		def project = file.getProject().toString().replace("P","")
		
		URI newUri = URI.createURI(project + location)
		Resource resource = resourceSet.createResource(newUri)
		resource.getContents().add(modelDocument)
	
		try {
			resource.save(null)
		} catch (IOException e) {
			e.printStackTrace()
		}
	}
		
	private void traverseModel(Document documentModel) {
		documentModel.eContents().each{element ->
			println(element.getClass().getName())
			println(element.getText())
		}
	}
}
