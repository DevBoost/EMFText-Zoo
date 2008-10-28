public class ChainedCalls {
	public int a;
	public ChainedCalls ref;
	
	public static ChainedCalls m() {
		return null;
	}
	
	{
		m();
	}
	{
		a = m().a;
	}
	{
		m().a = 1;
	}
	{
		m().m().m();
	}
	{
		this.m();
	}
	{
		ref.m();
	}
	{
		ref.m().ref.m();
	}
	{
		java.lang.String.class.toString();
	}
	{
		ChainedCalls.m();
	}
	{
		ref = ChainedCalls.this;
		ChainedCalls.this.m();
	}
	{
		new ChainedCalls().m();
	}
}
