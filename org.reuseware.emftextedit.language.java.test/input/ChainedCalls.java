public class ChainedCalls {
	public class Inner {

	}
	public class InnerGeneric<T> {
		public <T> InnerGeneric () {
			ChainedCalls.this.toString();
			ChainedCalls.super.hashCode();
		}
	}
	public int a;
	public ChainedCalls ref;
	public ChainedCalls[] refArray;
	
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
	{
		ChainedCalls[].class.toString();
	}
	{
		refArray[1].toString();
	}
	{
		ChainedCalls.Inner.class.toString();
	}
	{
		this.new Inner();
	}
}
