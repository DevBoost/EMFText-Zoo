

import java.util.LinkedList;
import java.util.List;

public class Import2 {

	public List<Import1> observers = new LinkedList<Import1>(); 

	public void attach(Import1 observer) {
		observers.add(observer);
	}
	
	public void detach(Import1 observer) {
		observers.remove(observer);
	}
	
	public void notifyMe() {
	}
}