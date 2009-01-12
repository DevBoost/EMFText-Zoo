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

	public void m1() {
		ArrayInitializers[] variable = new ArrayInitializers[2341];
		variable.toString();
	}

	public void m2() {
		ArrayInitializers[][] variable2 = new ArrayInitializers[2341][];
		variable2.toString();
	}

	public void m3() {
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
		variableWithCommaAtEnd.toString();
		variableWithoutCommaAtEnd.toString();
	}
	
	public void m4() {
		int[] ia = { , };
	}
	
	public void m5() {
		new int[]{1}[0] = 1;
		int[][][] f = new int[1][][].clone();
		int i2 = new int[]{1}[0];
	}
}
