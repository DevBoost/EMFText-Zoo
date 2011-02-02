public class CommentsBetweenCatchClauses {

    public void m() {
        try {
        } catch (Exception e) {
        }
        // a comment
        catch (Throwable e) {
        } finally {
        }
    }

}
