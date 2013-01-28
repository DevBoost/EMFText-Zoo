package dk.itu.sdg.language.xwpf


import org.apache.poi.xwpf.model.XWPFCommentsDecorator
import org.apache.poi.xwpf.model.XWPFParagraphDecorator
import org.apache.poi.xwpf.usermodel.XWPFDocument
import org.apache.poi.xwpf.usermodel.XWPFHeader;
import org.apache.poi.xwpf.usermodel.XWPFParagraph
import org.apache.poi.xwpf.usermodel.XWPFRun
import org.eclipse.emf.ecore.EObject

class Model2DocX {
	
	Document modelDocument
	
	public Model2DocX (Document modelDocument) {
		this.modelDocument = modelDocument
	}
	
	public XWPFDocument transform() {
		def XWPFDocument xDocument = new XWPFDocument()
		
		this.modelDocument.eContents().each {modelElement ->
			this.convert(modelElement, xDocument)
		}
		
		return xDocument
	}
	
	private XWPFDocument convert(Header element, XWPFDocument xDocument) {
		
		XWPFHeader header = xDocument.getHeaderFooterPolicy()
		return xDocument	
	}
	
	private XWPFDocument convert(Footer element, XWPFDocument xDocument) {
		
		return xDocument
	}
	
	private XWPFDocument convert(Paragraph element, XWPFDocument xDocument) {
		
		XWPFParagraph paragraph = xDocument.createParagraph()
		
		paragraph.setAlignment(paragraph.getAlignment().valueOf(element.getAlignment()))
		paragraph.setBorderBottom(paragraph.getBorderBottom().valueOf(element.getBorderBottom()))
		paragraph.setBorderTop(paragraph.getBorderTop().valueOf(element.getBorderTop()))
		paragraph.setBorderBetween(paragraph.getBorderBetween().valueOf(element.getBorderBetween()))
		paragraph.setBorderLeft(paragraph.getBorderLeft().valueOf(element.getBorderLeft()))
		paragraph.setBorderRight(paragraph.getBorderRight().valueOf(element.getBorderRight()))
		paragraph.setVerticalAlignment(paragraph.getVerticalAlignment().valueOf(element.getVerticalAlignment()))
//		paragraph.footnoteText = element.getFootNoteText()
		paragraph.setIndentationFirstLine(element.getIndentFstLine())
		paragraph.setIndentationHanging(element.getIndentHanging())
		paragraph.setIndentationLeft(element.getIndentLeft())
		paragraph.setIndentationRight(element.getIndentRight())
		paragraph.setSpacingAfter(element.getSpacingAfter())
		paragraph.setSpacingAfterLines(element.getSpacingAfterLines())
		paragraph.setSpacingBefore(element.getSpacingBefore())
		paragraph.setSpacingBeforeLines(element.getSpacingBeforeLines())
		paragraph.setSpacingLineRule(paragraph.getSpacingLineRule().valueOf(element.getSpacingLineRule()))
		paragraph.setStyle(element.getStyle())
		
		element.getRuns().each{ run ->
			this.convert(run, paragraph)
		}
		//TODO: convert Runs here
		
		return xDocument
	}
	
	private XWPFDocument convert(Comment element, XWPFDocument xDocument) {
		
		XWPFParagraphDecorator decorator = new XWPFCommentsDecorator()
		
//		xDocument.crea
		
		return xDocument
	}
	
	private XWPFParagraph convert(Run element, XWPFParagraph xParagraph) {
		
		XWPFRun run = xParagraph.createRun()
		
		run.setFontFamily(element.getFontFamily())
		run.setFontSize(element.getFontSize())
		run.setBold(element.isIsBold())
		run.setItalic(element.isIsItalic())
		run.setStrike(element.isIsStrike())
		run.setColor(element.getColor())
		run.setTextPosition(element.getTextPosition())
		println(element.getText())
		run.setText(element.getText())
		//TODO: replace enter with carriage return and breaks???
		
		return xParagraph
	}
	
	private XWPFDocument convert(Body element, XWPFDocument xDocument) {
		//TODO: check if I need this
		return xDocument
	}
	
	
	public void saveDocX(XWPFDocument xDocument) {
		
		FileOutputStream out = new FileOutputStream("/Users/ropf/Documents/eclipse/runtime_indigo_dresden/dk.itu.sdg.coral.library/example/report2.docx");
		xDocument.write(out);
		out.close();
		
	}

}
