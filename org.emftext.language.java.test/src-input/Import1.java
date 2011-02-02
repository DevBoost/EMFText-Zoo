import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Import1 {

	public List<Import2> subjects = new ArrayList<Import2>();

	public void update() {
		Iterator<Import2> it;
		it = subjects.iterator();
		
		while(it.hasNext()) {
			Import2 subject;
			subject = it.next();
			subject.notify();
		}
	}
	
}