public class TypeReferencing {
	public class InnerType {
		public class InnerInnerType {
		}
	}
	public class InnerGenericType<T> {
		public class InnerInnerGenericType<T> {
		}
	}
	
	public void method() {
		TypeReferencing variable0;
		TypeReferencing.InnerType variable1;
		TypeReferencing.InnerType.InnerInnerType variable2;
		TypeReferencing.InnerGenericType<InnerType> variable3;
		TypeReferencing.InnerGenericType<InnerType>.InnerInnerGenericType<InnerType> variable4;
		
		pkg.EmptyClass variable5;
		pkg.inner.Inner variable6;
	}
}
