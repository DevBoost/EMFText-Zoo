public class Literals {
	public void method () {
		int i1 = 3;
		int i2 = 0x1;
		long i3 = 010l;
		long i4 = 007L;
		long i5 = 0x1ffffffffffff00L;
		double f1 = 1.5;
		char c = 'a';
		String s = "abc";
		boolean falze = false;
		boolean truh = true;
		Literals nuhl = null;
		float f2 = 1.5f;
		
		// some assignments to avoid warnings
		this.i1 = i1;
		this.i2 = i2;
		this.i3 = i3;
		this.i4 = i4;
		this.f1 = f1;
		this.c = c;
		this.s = s;
		this.falze = falze;
		this.truh = truh;
		this.nuhl = nuhl;
		this.f2 = f2;
	}
	public int i1 = 3;
	public int i2 = 0x1;
	public long i3 = 010l;
	public long i4 = 000L;
	public double f1 = 1.5;
	public char c = 'a';
	public String s = "abc";
	public boolean falze = false;
	public boolean truh = true;
	public Literals nuhl = null;
	public float f2 = 1.5f;
	public long maxLong = 0xffffffffffffffffL;
	public boolean b = -0xffffffffffffffffL == ~0xffffffffffffffffL+1;
}
