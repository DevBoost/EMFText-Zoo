package example.for2shortfor;

import java.util.Arrays;
import java.util.List;


public class Test {
	public void test () {
	List < String > strings = Arrays.asList ( "1" , "2" , "3" , "4" ) ;
	for ( String one : strings ) {
		System.out.println ( one ) ;
	}
}
}