
import java.util.Stack;
import java.util.Scanner;
public class PostFixCalc {
    //3 5 + 1-
    // 3+5-1
    public static void main(String[] args) {

        boolean fin = false;
        Stack<Double> calc =new Stack();//creates a stack that is a doble

        Scanner scan = new Scanner(System.in);
        //System.out.println("print expression");
        String operation;
        double op1,op2;
        double r = 0;//result
        System.out.println("print expression, press = and enter to finish");
        while(!fin){//while this is not finished

            operation = scan.next();//it gets the next operation//ALSO ACCOUNTS FOR MULTIPLE DIGIT VARIABLES//TEST CASE
            if (isNum(operation)){//goes to the isNum method that checks if the number written is integer or not
                int yes = Integer.parseInt(operation);//basically does the same thing
                calc.push((double)yes);//if the number is integer then the number is pushed into the stack

            }else if (operation.equals("=")){//if the operation is = then the calculation is done
                fin = true;

            }
            else if (Op(operation)){//if the operation has a operator in it
                op2 = calc.pop();//it takes out a value for the right side
                op1=calc.pop();//value for the left side
                r= evaluate(operation,op1,op2);//calls the evaluate method that does the arithmetic calculation
                calc.push(r);//once the calculation is finished the vale gets pushed back onto the stack....and it will do this until till the operation has ended


            }else if (operation.isEmpty()){ //TEST CASE 2
                System.out.println("Stack is empty");
            }


            //calc.pop();

        }System.out.println(r);//prints out the result





    }
    private static Double evaluate(String operation, Double op1, Double op2) {//for the arithmetics
        if (operation.equals("*")) {
            return op1 * op2;//if in the operation string "*" is found it multiplies the top operation and the new top operation
        }
        if (operation.equals("+")) {
            return op1 + op2;//if in the operation string "+" is found it adds the top operation and the new top operation
        }
        if (operation.equals("-")) {
            return op1 - op2;//if in the operation string "-" is found it subtracts the top operation and the new top operation
        }
        if (operation.equals("/")) {
            return op1 / op2;//if in the operation string "/" is found it divides the top operation and the new top operation
        }
        if (operation.equals("%")) {
            return op1 % op2;//if in the operation string "%" is found it uses modulus on the top operation and the new top operation
        }else {
            System.out.println("Might be a wrron operation");

            return 0.0;
        }
    }

     public static boolean isNum (String num){//returns true if the operation has values that are integers
        try {
            int yes = Integer.parseInt(num);//uses the parseInt java function
            return true;

        } catch (Exception e){
            return false;

        }

     }
     static boolean Op(String op) {//seaches through the string for any one of these functions...
         return op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/") || op.equals("%");
     }




}
