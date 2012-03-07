package resolving_new.methodOverloading_2;
import java.util.ArrayList;

public class MethodOverloading {
	
	 // target:1
    public Object[] getAnnotations // target:1
    	(int lineNumber) {
        	return null;
    }
    
    // target:2
    private ArrayList<Object> getAnnotations  // 2 returns list (not array)
    	(Object lineAnnotations) {
        	return null;
    }

    public void m() {
        // source:1:target
    	getAnnotations(0);    	
        ArrayList lineAnnotationsArray = new ArrayList();
        // source:2:target
        getAnnotations(lineAnnotationsArray.get(0));

        ArrayList<Object> result = new ArrayList<Object>();
        result.addAll(getAnnotations(lineAnnotationsArray.get(0)));
    }


}
