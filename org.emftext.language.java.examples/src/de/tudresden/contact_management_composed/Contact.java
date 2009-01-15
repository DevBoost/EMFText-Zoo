package de .tudresden .contact_management ; 


class Contact { 
	protected String name ; 
	protected Address address ; 
	protected java.util.LinkedList < Relationship > targetOf ; 
	protected java.util.LinkedList < Relationship > sourceOf ; 
	protected ContactList list ; 
	protected Group source ; 
} 

