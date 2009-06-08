package org.emftext.language.valueflow.diagram.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;
import org.emftext.language.valueflow.diagram.providers.ValueflowElementTypes;

/**
 * @generated
 */
public class ValueflowPaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createObjects1Group());
		paletteRoot.add(createConnections2Group());
	}

	/**
	 * Creates "Objects" palette tool group
	 * @generated
	 */
	private PaletteContainer createObjects1Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.Objects1Group_title);
		paletteContainer.add(createAgent1CreationTool());
		paletteContainer.add(createGiveState2CreationTool());
		paletteContainer.add(createInitial3CreationTool());
		paletteContainer.add(createModel4CreationTool());
		paletteContainer.add(createTakeState5CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Connections" palette tool group
	 * @generated
	 */
	private PaletteContainer createConnections2Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.Connections2Group_title);
		paletteContainer.add(createGiveTo1CreationTool());
		paletteContainer.add(createNextState2CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAgent1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(ValueflowElementTypes.Agent_1001);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Agent1CreationTool_title,
				Messages.Agent1CreationTool_desc, types);
		entry.setSmallIcon(ValueflowElementTypes
				.getImageDescriptor(ValueflowElementTypes.Agent_1001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createGiveState2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(ValueflowElementTypes.GiveState_2002);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.GiveState2CreationTool_title,
				Messages.GiveState2CreationTool_desc, types);
		entry.setSmallIcon(ValueflowElementTypes
				.getImageDescriptor(ValueflowElementTypes.GiveState_2002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createInitial3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(ValueflowElementTypes.Initial_2001);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Initial3CreationTool_title,
				Messages.Initial3CreationTool_desc, types);
		entry.setSmallIcon(ValueflowElementTypes
				.getImageDescriptor(ValueflowElementTypes.Initial_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createModel4CreationTool() {
		ToolEntry entry = new ToolEntry(Messages.Model4CreationTool_title,
				Messages.Model4CreationTool_desc, null, null) {
		};
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createTakeState5CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(ValueflowElementTypes.TakeState_2003);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.TakeState5CreationTool_title,
				Messages.TakeState5CreationTool_desc, types);
		entry.setSmallIcon(ValueflowElementTypes
				.getImageDescriptor(ValueflowElementTypes.TakeState_2003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createGiveTo1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(ValueflowElementTypes.GiveStateGiveTo_3002);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.GiveTo1CreationTool_title,
				Messages.GiveTo1CreationTool_desc, types);
		entry
				.setSmallIcon(ValueflowElementTypes
						.getImageDescriptor(ValueflowElementTypes.GiveStateGiveTo_3002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createNextState2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(ValueflowElementTypes.StateNextState_3001);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.NextState2CreationTool_title,
				Messages.NextState2CreationTool_desc, types);
		entry.setSmallIcon(ValueflowElementTypes
				.getImageDescriptor(ValueflowElementTypes.StateNextState_3001));
		entry.setLargeIcon(entry.getSmallIcon());
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
