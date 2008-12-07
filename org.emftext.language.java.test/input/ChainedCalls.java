public class ChainedCalls {
	public class Inner {

	}
	public class InnerGeneric<T> {
		public <S> InnerGeneric () {
			ChainedCalls.this.toString();
			ChainedCalls.super.hashCode();
		}
	}
	public int a;
	public ChainedCalls ref;
	public ChainedCalls[] refArray;
	public ChainedCalls[][] twoDimensionalArray;
	
	public ChainedCalls m() {
		return null;
	}
	
	public static ChainedCalls staticM() {
		return null;
	}
	
	public ChainedCalls m(ChainedCalls cc) {
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
		m(null).m(null).m(this);
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
		ChainedCalls.staticM();
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
		ChainedCalls[][].class.toString();
	}
	{
		refArray[1].toString();
	}
	{
		twoDimensionalArray[1][2].toString();
	}
	{
		ChainedCalls.Inner.class.toString();
	}
	{
		this.new Inner();
	}
}
