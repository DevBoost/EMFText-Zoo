public class CommentsBetweenReferenceSequenceParts {
	
	public CommentsBetweenReferenceSequenceParts getSelf() {
		return this;
	}
	
	{
		getSelf(). // a comment
		getSelf(). // another comment
		getSelf();
		
	}
}
