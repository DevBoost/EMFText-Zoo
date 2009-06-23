package org.emftext.language.java.treejava.examples;

class House {
	public House(Room... rooms) {
		System.out.println("HOUSE");
	}

	public House(String name, Room... rooms) {
		System.out.println("HOUSE " + name);
	}
} 