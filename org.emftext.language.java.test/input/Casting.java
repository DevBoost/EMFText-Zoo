public class Casting {
	{
		Casting c;
		Casting[] d = new Casting[1];
		c = (Casting) null;
		Casting e = (Casting) null;
		c = (Casting) c;
		d = (Casting[]) d;
		d = (Casting[]) d.clone();
		((Casting[]) d).clone();
		Casting c2 = new Casting2();
		Casting c3 = ((Casting2) c2).m();
		((Casting2)c3).m().toString();
		try {
			((Casting[]) d)[0].clone();
		} catch (CloneNotSupportedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		c = (Casting) d[0];
		float f = (byte) 1;
		d = (Casting[]) new Casting[2];
		
		{}
	}
	
	public class Casting2 extends Casting {
		public Casting m() {
			return new Casting2();
		}
	}
}
