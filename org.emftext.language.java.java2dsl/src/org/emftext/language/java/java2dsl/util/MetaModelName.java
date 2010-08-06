package org.emftext.language.java.java2dsl.util;

public enum MetaModelName {

		JAVA("Java"),
		PROPERTY("Property"),
		CLOSURE("Closure");
		
		private final String name;

		private MetaModelName(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return name;
		}

}
