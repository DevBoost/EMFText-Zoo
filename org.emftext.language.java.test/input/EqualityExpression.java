
public class EqualityExpression {
    void foo(int i) {
        switch (i) {
            case (("1" == "2" == true != false == false != false == true == false == false != true) ? 1 : 0):
            case (("1" != "2" == true) ? 2 : 0):
            case (("1" == "2" != true) ? 3 : 0):
            case (("1" != "2" != false) ? 4 : 0):
        }
    }
}
