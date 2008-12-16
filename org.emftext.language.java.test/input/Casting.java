public class Casting {
	{
		Casting c;
		Casting[] d = new Casting[1];
		c = (Casting) null;
		Casting e = (Casting) null;
		c = (Casting) c;
		d = (Casting[]) d;
		((Casting[]) d).clone();
		c = (Casting) d[0];
		float f = (byte) 1;
	}
}
