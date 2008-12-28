public class CommentsInArrayInitializers {

	protected Integer[] m1() {
		return new Integer[] {
				new Integer(1), // some comment
		};
	}

	protected Integer[][] m2() {
		return new Integer[1][2// some comment
		                      ];
	}

	protected String[][] m3() {
		return new String[][] { {"s1"}, // comment1
				{"s2", // comment2 
				"s3"}, // comment3
		};
	}
}
