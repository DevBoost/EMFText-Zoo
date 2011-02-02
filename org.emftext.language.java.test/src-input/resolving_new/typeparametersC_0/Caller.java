package resolving_new.typeparametersC_0;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Caller {

	public void tesMethodParameterTypeBinding() {
		Comparator comp = new Comparator(){

			public int compare(Object o1, Object o2) {
				return 0;
			}};
			
		Collections.singletonMap("key", "value").get("key").toLowerCase();
		Arrays.binarySearch(new Caller [] {new Caller()}, "", comp);
	}

}
