public final class Modifiers {
	
	native synchronized void method1();
	synchronized strictfp void method2() {
	}
	
	transient volatile Modifiers field;

	private class PrivateClass {
	}
	private final class PrivateFinalClass {
	}
	final private class FinalPrivateClass {
	}
	private abstract class PrivateAbstractClass {
	}
	abstract private class AbstractPrivateClass {
	}
	private static class PrivateStaticClass {
	}
	static private class StaticPrivateClass {
	}
	
	{
		// some instantiations to avoid warnings
		new PrivateClass();
		new PrivateFinalClass();
		new FinalPrivateClass();
		new PrivateAbstractClass() {};
		new AbstractPrivateClass() {};
		new PrivateStaticClass();
		new StaticPrivateClass();
	}

	protected class ProtectedClass {
	}
	protected final class ProtectedFinalClass {
	}
	final protected class FinalProtectedClass {
	}
	protected abstract class ProtectedAbstractClass {
	}
	abstract protected class AbstractProtectedClass {
	}
	protected static class ProtectedStaticClass {
	}
	static protected class StaticProtectedClass {
	}

	class DefaultClass {
	}
	final class DefaultFinalClass {
	}
	abstract class DefaultAbstractClass {
	}
	static class DefaultStaticClass {
	}

	public class PublicClass {
	}
	public final class PublicFinalClass {
	}
	final public class FinalPublicClass {
	}
	public abstract class PublicAbstractClass {
	}
	abstract public class AbstractPublicClass {
	}
	public static class PublicStaticClass {
	}
	static public class StaticPublicClass {
	}
}
