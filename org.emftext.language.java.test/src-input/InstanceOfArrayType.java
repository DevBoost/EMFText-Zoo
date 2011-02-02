public class InstanceOfArrayType {
	{
		byte[] obj = null;
		if (obj instanceof byte[]) {
		}
	}
	
	{
		boolean b = new String[] {} instanceof String[];
	}
	
	{
		boolean b = new int[1] instanceof Object;
	}
}
