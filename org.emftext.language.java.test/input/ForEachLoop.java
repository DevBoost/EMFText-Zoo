
public class ForEachLoop {

	private ForEachLoop[] collection;
	
	public void simpleForEach() {
		for(ForEachLoop next: collection){}
	}

	public void forEachWithModifier() {
		for(final ForEachLoop next: collection){}
	}
	
}
