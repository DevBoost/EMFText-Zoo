package org.emftext.language.java.diagram.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;
import org.emftext.language.java.diagram.providers.JavaElementTypes;

/**
 * @generated
 */
public class JavaPaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createNodes1Group());
		paletteRoot.add(createLinks2Group());
	}

	/**
	 * Creates "Nodes" palette tool group
	 * @generated
	 */
	private PaletteContainer createNodes1Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.Nodes1Group_title);
		paletteContainer.add(createAnnotation1CreationTool());
		paletteContainer.add(createAnnotationMethod2CreationTool());
		paletteContainer.add(createCompilationUnit3CreationTool());
		paletteContainer.add(createClassifierImport4CreationTool());
		paletteContainer.add(createStaticImport5CreationTool());
		paletteContainer.add(createClass6CreationTool());
		paletteContainer.add(createInterface7CreationTool());
		paletteContainer.add(createEnumeration8CreationTool());
		paletteContainer.add(createConstructor9CreationTool());
		paletteContainer.add(createField10CreationTool());
		paletteContainer.add(createMethod11CreationTool());
		paletteContainer.add(createBlock12CreationTool());
		paletteContainer.add(createPackageDescriptor13CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Links" palette tool group
	 * @generated
	 */
	private PaletteContainer createLinks2Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.Links2Group_title);
		paletteContainer.add(createClassifiers1CreationTool());
		paletteContainer.add(createStaticMembers2CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAnnotation1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(JavaElementTypes.Annotation_3024);
		types.add(JavaElementTypes.Annotation_3014);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Annotation1CreationTool_title,
				Messages.Annotation1CreationTool_desc, types);
		entry.setSmallIcon(JavaElementTypes
				.getImageDescriptor(JavaElementTypes.Annotation_3024));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAnnotationMethod2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(JavaElementTypes.AnnotationMethod_3018);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.AnnotationMethod2CreationTool_title,
				Messages.AnnotationMethod2CreationTool_desc, types);
		entry.setSmallIcon(JavaElementTypes
				.getImageDescriptor(JavaElementTypes.AnnotationMethod_3018));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createCompilationUnit3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(JavaElementTypes.CompilationUnit_2001);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.CompilationUnit3CreationTool_title,
				Messages.CompilationUnit3CreationTool_desc, types);
		entry.setSmallIcon(JavaElementTypes
				.getImageDescriptor(JavaElementTypes.CompilationUnit_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createClassifierImport4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(JavaElementTypes.ClassifierImport_3016);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.ClassifierImport4CreationTool_title,
				Messages.ClassifierImport4CreationTool_desc, types);
		entry.setSmallIcon(JavaElementTypes
				.getImageDescriptor(JavaElementTypes.ClassifierImport_3016));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createStaticImport5CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(JavaElementTypes.StaticImport_3017);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.StaticImport5CreationTool_title,
				Messages.StaticImport5CreationTool_desc, types);
		entry.setSmallIcon(JavaElementTypes
				.getImageDescriptor(JavaElementTypes.StaticImport_3017));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createClass6CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(JavaElementTypes.Class_3001);
		types.add(JavaElementTypes.Class_3019);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Class6CreationTool_title,
				Messages.Class6CreationTool_desc, types);
		entry.setSmallIcon(JavaElementTypes
				.getImageDescriptor(JavaElementTypes.Class_3001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createInterface7CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(JavaElementTypes.Interface_3021);
		types.add(JavaElementTypes.Interface_3013);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Interface7CreationTool_title,
				Messages.Interface7CreationTool_desc, types);
		entry.setSmallIcon(JavaElementTypes
				.getImageDescriptor(JavaElementTypes.Interface_3021));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEnumeration8CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(JavaElementTypes.Enumeration_3020);
		types.add(JavaElementTypes.Enumeration_3012);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Enumeration8CreationTool_title,
				Messages.Enumeration8CreationTool_desc, types);
		entry.setSmallIcon(JavaElementTypes
				.getImageDescriptor(JavaElementTypes.Enumeration_3020));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createConstructor9CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(JavaElementTypes.Constructor_3026);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Constructor9CreationTool_title,
				Messages.Constructor9CreationTool_desc, types);
		entry.setSmallIcon(JavaElementTypes
				.getImageDescriptor(JavaElementTypes.Constructor_3026));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createField10CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(JavaElementTypes.Field_3022);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Field10CreationTool_title,
				Messages.Field10CreationTool_desc, types);
		entry.setSmallIcon(JavaElementTypes
				.getImageDescriptor(JavaElementTypes.Field_3022));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createMethod11CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(JavaElementTypes.Method_3023);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Method11CreationTool_title,
				Messages.Method11CreationTool_desc, types);
		entry.setSmallIcon(JavaElementTypes
				.getImageDescriptor(JavaElementTypes.Method_3023));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createBlock12CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(JavaElementTypes.Block_3027);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Block12CreationTool_title,
				Messages.Block12CreationTool_desc, types);
		entry.setSmallIcon(JavaElementTypes
				.getImageDescriptor(JavaElementTypes.Block_3027));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createPackageDescriptor13CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(JavaElementTypes.PackageDescriptor_3025);
		types.add(JavaElementTypes.PackageDescriptor_3015);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.PackageDescriptor13CreationTool_title,
				Messages.PackageDescriptor13CreationTool_desc, types);
		entry.setSmallIcon(JavaElementTypes
				.getImageDescriptor(JavaElementTypes.PackageDescriptor_3025));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createClassifiers1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(JavaElementTypes.ClassifierImportClassifiers_4001);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.Classifiers1CreationTool_title,
				Messages.Classifiers1CreationTool_desc, types);
		entry
				.setSmallIcon(JavaDiagramEditorPlugin
						.findImageDescriptor("/org.eclipse.epsilon.eugenia.runtime/icons/Link.gif")); //$NON-NLS-1$
		entry
				.setLargeIcon(JavaDiagramEditorPlugin
						.findImageDescriptor("/org.eclipse.epsilon.eugenia.runtime/icons/Link.gif")); //$NON-NLS-1$
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createStaticMembers2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(JavaElementTypes.StaticImportStaticMembers_4002);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.StaticMembers2CreationTool_title,
				Messages.StaticMembers2CreationTool_desc, types);
		entry
				.setSmallIcon(JavaDiagramEditorPlugin
						.findImageDescriptor("/org.eclipse.epsilon.eugenia.runtime/icons/Link.gif")); //$NON-NLS-1$
		entry
				.setLargeIcon(JavaDiagramEditorPlugin
						.findImageDescriptor("/org.eclipse.epsilon.eugenia.runtime/icons/Link.gif")); //$NON-NLS-1$
		return entry;
	}

	/**
	 * @generated
	 */
	private static class NodeToolEntry extends ToolEntry {

		/**
		 * @generated
		 */
		private final List elementTypes;

		/**
		 * @generated
		 */
		private NodeToolEntry(String title, String description,
				List elementTypes) {
			super(title, description, null, null);
			this.elementTypes = elementTypes;
		}

		/**
		 * @generated
		 */
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeCreationTool(elementTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}

	/**
	 * @generated
	 */
	private static class LinkToolEntry extends ToolEntry {

		/**
		 * @generated
		 */
		private final List relationshipTypes;

		/**
		 * @generated
		 */
		private LinkToolEntry(String title, String description,
				List relationshipTypes) {
			super(title, description, null, null);
			this.relationshipTypes = relationshipTypes;
		}

		/**
		 * @generated
		 */
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeConnectionTool(relationshipTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}
}
