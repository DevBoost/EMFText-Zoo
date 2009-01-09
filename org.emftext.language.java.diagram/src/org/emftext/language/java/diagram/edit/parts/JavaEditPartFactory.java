package org.emftext.language.java.diagram.edit.parts;

import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.emftext.language.java.diagram.part.JavaVisualIDRegistry;

/**
 * @generated
 */
public class JavaEditPartFactory implements EditPartFactory {

	/**
	 * @generated
	 */
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			switch (JavaVisualIDRegistry.getVisualID(view)) {

			case PackageEditPart.VISUAL_ID:
				return new PackageEditPart(view);

			case CompilationUnitEditPart.VISUAL_ID:
				return new CompilationUnitEditPart(view);

			case CompilationUnitCommentsEditPart.VISUAL_ID:
				return new CompilationUnitCommentsEditPart(view);

			case ClassEditPart.VISUAL_ID:
				return new ClassEditPart(view);

			case ClassNameEditPart.VISUAL_ID:
				return new ClassNameEditPart(view);

			case AnnotationMethodEditPart.VISUAL_ID:
				return new AnnotationMethodEditPart(view);

			case AnnotationMethodNameEditPart.VISUAL_ID:
				return new AnnotationMethodNameEditPart(view);

			case Class2EditPart.VISUAL_ID:
				return new Class2EditPart(view);

			case ClassName2EditPart.VISUAL_ID:
				return new ClassName2EditPart(view);

			case EnumerationEditPart.VISUAL_ID:
				return new EnumerationEditPart(view);

			case EnumerationNameEditPart.VISUAL_ID:
				return new EnumerationNameEditPart(view);

			case InterfaceEditPart.VISUAL_ID:
				return new InterfaceEditPart(view);

			case InterfaceNameEditPart.VISUAL_ID:
				return new InterfaceNameEditPart(view);

			case FieldEditPart.VISUAL_ID:
				return new FieldEditPart(view);

			case FieldNameEditPart.VISUAL_ID:
				return new FieldNameEditPart(view);

			case MethodEditPart.VISUAL_ID:
				return new MethodEditPart(view);

			case MethodNameEditPart.VISUAL_ID:
				return new MethodNameEditPart(view);

			case AnnotationEditPart.VISUAL_ID:
				return new AnnotationEditPart(view);

			case AnnotationNameEditPart.VISUAL_ID:
				return new AnnotationNameEditPart(view);

			case PackageDescriptorEditPart.VISUAL_ID:
				return new PackageDescriptorEditPart(view);

			case PackageDescriptorNameEditPart.VISUAL_ID:
				return new PackageDescriptorNameEditPart(view);

			case ConstructorEditPart.VISUAL_ID:
				return new ConstructorEditPart(view);

			case ConstructorNameEditPart.VISUAL_ID:
				return new ConstructorNameEditPart(view);

			case BlockEditPart.VISUAL_ID:
				return new BlockEditPart(view);

			case BlockNameEditPart.VISUAL_ID:
				return new BlockNameEditPart(view);

			case Enumeration2EditPart.VISUAL_ID:
				return new Enumeration2EditPart(view);

			case EnumerationName2EditPart.VISUAL_ID:
				return new EnumerationName2EditPart(view);

			case Interface2EditPart.VISUAL_ID:
				return new Interface2EditPart(view);

			case InterfaceName2EditPart.VISUAL_ID:
				return new InterfaceName2EditPart(view);

			case Annotation2EditPart.VISUAL_ID:
				return new Annotation2EditPart(view);

			case AnnotationName2EditPart.VISUAL_ID:
				return new AnnotationName2EditPart(view);

			case PackageDescriptor2EditPart.VISUAL_ID:
				return new PackageDescriptor2EditPart(view);

			case PackageDescriptorName2EditPart.VISUAL_ID:
				return new PackageDescriptorName2EditPart(view);

			case ClassifierImportEditPart.VISUAL_ID:
				return new ClassifierImportEditPart(view);

			case ClassifierImportCommentsEditPart.VISUAL_ID:
				return new ClassifierImportCommentsEditPart(view);

			case StaticImportEditPart.VISUAL_ID:
				return new StaticImportEditPart(view);

			case StaticImportCommentsEditPart.VISUAL_ID:
				return new StaticImportCommentsEditPart(view);

			case CompilationUnitCompilationUnitImportsCompartmentEditPart.VISUAL_ID:
				return new CompilationUnitCompilationUnitImportsCompartmentEditPart(
						view);

			case CompilationUnitCompilationUnitClassifiersCompartmentEditPart.VISUAL_ID:
				return new CompilationUnitCompilationUnitClassifiersCompartmentEditPart(
						view);

			case ClassClassMembersCompartmentEditPart.VISUAL_ID:
				return new ClassClassMembersCompartmentEditPart(view);

			case ClassClassMembersCompartment2EditPart.VISUAL_ID:
				return new ClassClassMembersCompartment2EditPart(view);

			case EnumerationEnumerationMembersCompartmentEditPart.VISUAL_ID:
				return new EnumerationEnumerationMembersCompartmentEditPart(
						view);

			case InterfaceInterfaceMembersCompartmentEditPart.VISUAL_ID:
				return new InterfaceInterfaceMembersCompartmentEditPart(view);

			case AnnotationAnnotationMembersCompartmentEditPart.VISUAL_ID:
				return new AnnotationAnnotationMembersCompartmentEditPart(view);

			case EnumerationEnumerationMembersCompartment2EditPart.VISUAL_ID:
				return new EnumerationEnumerationMembersCompartment2EditPart(
						view);

			case InterfaceInterfaceMembersCompartment2EditPart.VISUAL_ID:
				return new InterfaceInterfaceMembersCompartment2EditPart(view);

			case AnnotationAnnotationMembersCompartment2EditPart.VISUAL_ID:
				return new AnnotationAnnotationMembersCompartment2EditPart(view);

			case ClassifierImportClassifiersEditPart.VISUAL_ID:
				return new ClassifierImportClassifiersEditPart(view);

			case ClassifierImportClassifiersExternalLabelEditPart.VISUAL_ID:
				return new ClassifierImportClassifiersExternalLabelEditPart(
						view);

			case StaticImportStaticMembersEditPart.VISUAL_ID:
				return new StaticImportStaticMembersEditPart(view);

			case StaticImportStaticMembersExternalLabelEditPart.VISUAL_ID:
				return new StaticImportStaticMembersExternalLabelEditPart(view);
			}
		}
		return createUnrecognizedEditPart(context, model);
	}

	/**
	 * @generated
	 */
	private EditPart createUnrecognizedEditPart(EditPart context, Object model) {
		// Handle creation of unrecognized child node EditParts here
		return null;
	}

	/**
	 * @generated
	 */
	public static CellEditorLocator getTextCellEditorLocator(
			ITextAwareEditPart source) {
		if (source.getFigure() instanceof WrappingLabel)
			return new TextCellEditorLocator((WrappingLabel) source.getFigure());
		else {
			return new LabelCellEditorLocator((Label) source.getFigure());
		}
	}

	/**
	 * @generated
	 */
	static private class TextCellEditorLocator implements CellEditorLocator {

		/**
		 * @generated
		 */
		private WrappingLabel wrapLabel;

		/**
		 * @generated
		 */
		public TextCellEditorLocator(WrappingLabel wrapLabel) {
			this.wrapLabel = wrapLabel;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getWrapLabel() {
			return wrapLabel;
		}

		/**
		 * @generated
		 */
		public void relocate(CellEditor celleditor) {
			Text text = (Text) celleditor.getControl();
			Rectangle rect = getWrapLabel().getTextBounds().getCopy();
			getWrapLabel().translateToAbsolute(rect);
			if (getWrapLabel().isTextWrapOn()
					&& getWrapLabel().getText().length() > 0) {
				rect.setSize(new Dimension(text.computeSize(rect.width,
						SWT.DEFAULT)));
			} else {
				int avr = FigureUtilities.getFontMetrics(text.getFont())
						.getAverageCharWidth();
				rect.setSize(new Dimension(text.computeSize(SWT.DEFAULT,
						SWT.DEFAULT)).expand(avr * 2, 0));
			}
			if (!rect.equals(new Rectangle(text.getBounds()))) {
				text.setBounds(rect.x, rect.y, rect.width, rect.height);
			}
		}
	}

	/**
	 * @generated
	 */
	private static class LabelCellEditorLocator implements CellEditorLocator {

		/**
		 * @generated
		 */
		private Label label;

		/**
		 * @generated
		 */
		public LabelCellEditorLocator(Label label) {
			this.label = label;
		}

		/**
		 * @generated
		 */
		public Label getLabel() {
			return label;
		}

		/**
		 * @generated
		 */
		public void relocate(CellEditor celleditor) {
			Text text = (Text) celleditor.getControl();
			Rectangle rect = getLabel().getTextBounds().getCopy();
			getLabel().translateToAbsolute(rect);
			int avr = FigureUtilities.getFontMetrics(text.getFont())
					.getAverageCharWidth();
			rect.setSize(new Dimension(text.computeSize(SWT.DEFAULT,
					SWT.DEFAULT)).expand(avr * 2, 0));
			if (!rect.equals(new Rectangle(text.getBounds()))) {
				text.setBounds(rect.x, rect.y, rect.width, rect.height);
			}
		}
	}
}
