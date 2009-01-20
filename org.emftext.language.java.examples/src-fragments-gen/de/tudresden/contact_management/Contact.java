package de .tudresden .contact_management ; 


class Contact { 
	protected String name ; 
	protected Address address ; 
	protected java.util.LinkedList < Relationship > srcRelationships ; 
	protected java.util.LinkedList < Relationship > targetRelationships ; 
	protected Group group ; 
} 

