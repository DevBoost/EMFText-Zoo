public class ArrayInitializers {
	public ArrayInitializers[] field1 = new ArrayInitializers[2];
	public ArrayInitializers[] field2 = new ArrayInitializers[] {};
	public ArrayInitializers[] fieldWithCommaAtEnd = new ArrayInitializers[] {
			new ArrayInitializers(), 
			new ArrayInitializers(), 
			new ArrayInitializers(), 
	};
	public ArrayInitializers[] fieldWithoutCommaAtEnd = new ArrayInitializers[] {
			new ArrayInitializers(), 
			new ArrayInitializers(), 
			new ArrayInitializers()
	};
	public ArrayInitializers[][] fieldWithTwoDimensions = new ArrayInitializers[][] {
			new ArrayInitializers[] {
					new ArrayInitializers(), 
					new ArrayInitializers(),
			},
			new ArrayInitializers[] {
					new ArrayInitializers(), 
					new ArrayInitializers()
			},
	};

	public void method() {
		ArrayInitializers[] variable = new ArrayInitializers[2341];
		ArrayInitializers[] variableWithCommaAtEnd = new ArrayInitializers[] {
				new ArrayInitializers(), 
				new ArrayInitializers(), 
				new ArrayInitializers(), 
		};
		ArrayInitializers[] variableWithoutCommaAtEnd = new ArrayInitializers[] {
				new ArrayInitializers(), 
				new ArrayInitializers(), 
				new ArrayInitializers()
		};
	}
}
