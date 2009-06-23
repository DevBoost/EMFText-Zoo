package org.emftext.language.java.treejava.examples;

class Room {
	public Room(Door... doors) {
		System.out.println("-- ROOM");
	}

	public Room(String name, Door... doors) {
		System.out.println("-- ROOM " + name);
	}
}