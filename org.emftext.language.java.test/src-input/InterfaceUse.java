
public class InterfaceUse {
	static {
		Interface3 x = null;
		//TODO this does not compile with javac version on Jenkins CI
		//x.getX().getBytes();
	}
}
