/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.prolog.resource.pl.debug;

/**
 * DebugMessages are exchanged between the debug server (the Eclipse debug
 * framework) and the debug client (a running process or interpreter). To exchange
 * messages they are serialized and sent over sockets.
 */
public class PlDebugMessage {
	
	private static final char DELIMITER = ':';
	private org.emftext.language.prolog.resource.pl.debug.EPlDebugMessageTypes messageType;
	private String[] arguments;
	
	public PlDebugMessage(org.emftext.language.prolog.resource.pl.debug.EPlDebugMessageTypes messageType, String[] arguments) {
		super();
		this.messageType = messageType;
		this.arguments = arguments;
	}
	
	public PlDebugMessage(org.emftext.language.prolog.resource.pl.debug.EPlDebugMessageTypes messageType, java.util.List<String> arguments) {
		super();
		this.messageType = messageType;
		this.arguments = new String[arguments.size()];
		for (int i = 0; i < arguments.size(); i++) {
			this.arguments[i] = arguments.get(i);
		}
	}
	
	public org.emftext.language.prolog.resource.pl.debug.EPlDebugMessageTypes getMessageType() {
		return messageType;
	}
	
	public String[] getArguments() {
		return arguments;
	}
	
	public String serialize() {
		java.util.List<String> parts = new java.util.ArrayList<String>();
		parts.add(messageType.name());
		for (String argument : arguments) {
			parts.add(argument);
		}
		return org.emftext.language.prolog.resource.pl.util.PlStringUtil.encode(DELIMITER, parts);
	}
	
	public static PlDebugMessage deserialize(String response) {
		java.util.List<String> parts = org.emftext.language.prolog.resource.pl.util.PlStringUtil.decode(response, DELIMITER);
		String messageType = parts.get(0);
		String[] arguments = new String[parts.size() - 1];
		for (int i = 1; i < parts.size(); i++) {
			arguments[i - 1] = parts.get(i);
		}
		org.emftext.language.prolog.resource.pl.debug.EPlDebugMessageTypes type = org.emftext.language.prolog.resource.pl.debug.EPlDebugMessageTypes.valueOf(messageType);
		PlDebugMessage message = new PlDebugMessage(type, arguments);
		return message;
	}
	
	public boolean hasType(org.emftext.language.prolog.resource.pl.debug.EPlDebugMessageTypes type) {
		return this.messageType == type;
	}
	
	public String getArgument(int index) {
		return getArguments()[index];
	}
	
	public String toString() {
		return this.getClass().getSimpleName() + "[" + messageType.name() + ": " + org.emftext.language.prolog.resource.pl.util.PlStringUtil.explode(arguments, ", ") + "]";
	}
	
}
