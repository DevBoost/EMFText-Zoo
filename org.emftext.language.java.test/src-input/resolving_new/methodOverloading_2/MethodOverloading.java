package resolving_new.methodOverloading_2;
import java.util.ArrayList;

public class MethodOverloading {
	
    public Object[] getAnnotations // target:1
    	(int lineNumber) {
        	return null;
    }
    
    //2: returns list
    private ArrayList<Object> getAnnotations // target:2
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
