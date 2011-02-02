
public class EqualityExpression {
    void foo(int i) {
    	double x = 3.0E4;
    	double y= 3e2f;
    	double z = 3.32423e4;
    	double a = 3;
    	double b = 9;
    	double c = 9f;
    	
    	
        switch (i) {
            case (("1" == "2" == true != false == false != false == true == false == false != true) ? 1 : 0):
            case (("1" != "2" == true) ? 2 : 0):
            case (("1" == "2" != true) ? 3 : 0):
            case (("1" != "2" != false) ? 4 : 0):
        }
    }
}
