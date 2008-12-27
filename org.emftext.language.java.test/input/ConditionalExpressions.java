public class ConditionalExpressions {
	public void allResourcesFor() {
		boolean files = true;
		int count = 5;
		ConditionalExpressions[] toReturn = files ? (ConditionalExpressions[]) new ConditionalExpressions[count] : (ConditionalExpressions[]) new ConditionalExpressions[count];
	}
}
