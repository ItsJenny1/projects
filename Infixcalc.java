import java.util.Stack;
import java.util.Scanner;
public class Infixcalc {
    public static void main(String[] args) {

        // System.out.print("B)");
        boolean fin = false;
        Stack<String> operator = new Stack();//creates a stack that is a double
        Stack<Double> numbers = new  Stack();//creates a stack that is a double
        Scanner scan = new Scanner(System.in);
        //System.out.println("print expression");
        String operation;
        double op1,op2;
        String opp;
        double r = 0;//result
        System.out.println("print expression with space in between eg. 55 + 5 =, press = and enter to finish");
        while (!fin) {//while this is not finished

            operation = scan.next();//it gets the next operation//ALSO ACCOUNTS FOR MULTIPLE DIGIT VARIABLES//TEST CASE


            if (!Op(operation)) { //Checks whether the user input is not an operand
                if (operation.equals("=")){//if the user input is '=' then the code stops calculates the operation
                    fin=true;
                }
                else if (isNum(operation)){ //check if there is a number value
                    numbers.push((double) Integer.parseInt(operation));//if there is a number value it gets pushed to the numbers stack
                }else {
                    System.out.println("Not a valid expression \n please input a valid expression"); //TEST CASE re-runs the code in the even the user puts a value that is not a number and not an operand
                }
            } else {
                if (!operator.isEmpty()) {//works as long as the operator stack is not empty
                    if (firstCome(operation) <= firstCome(operator.peek())) {//checks the operator at the top of the opeator stack and the the current operator in th user input

                        op2 = numbers.pop();//it takes out a value for the right side
                        op1 = numbers.pop();//value for the left side
                        opp = operator.pop();//takes out the highest operator precedence
                        r = evaluate(opp, op1, op2);//calls the evaluate method that does the arithmetic calculation
                        numbers.push(r);//once the calculation is finished the vale gets pushed back onto the stack....and it will do this until till the operation has ended
                    }


                }
                operator.push(operation);//makes sure that the operator stack is not empty
            }

        }
        if (!operator.isEmpty()) {
            do {
                op2 = numbers.pop();//it takes out a value for the right side
                op1 = numbers.pop();//value for the left side
                opp = operator.pop();//takes out the highest operator precedence
                r = evaluate(opp, op1, op2);//calls the evaluate method that does the arithmetic calculation
                numbers.push(r);//once the calculation is finished the vale gets pushed back onto the stack....and it will do this until till the operation has ended
            } while (!operator.isEmpty());
        }
        System.out.println(numbers.pop());
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
            System.out.println("Might be a wrong operation");

            return 0.0;
        }
    }
    public static int firstCome (String sign){//assigns values to operand to check for precedence
        if (sign.equals("*")||sign.equals("/")){ //'*' and '/' have the same precedence however both are higher than '+' and '-' so they are bigger in the scope
            return 2;
        }else if (sign.equals("+")||sign.equals("-")){//'+' and '-' have the lowest precedence so the have the lowest number
            return 1;
        }else if (sign.equals("(")||sign.equals(")")){//In the event a parenthesis is use, PEMDAS a parenthesis has the highest precedence
            return 3;
        }else {
            return -1;
        }
    }
    static boolean Op(String op) {//searches through the string for any one of these functions...
        return op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/") || op.equals("%") || op.equals("(") || op.equals(")");
    }

    public static boolean isNum (String num){//returns true if the operation has values that are integers
        try {
            int yes = Integer.parseInt(num);//uses the parseInt java function
            return true;

        } catch (Exception e){
            return false;

        }

    }


}
// Time complexity is O(n)
// Space Complexity is a little greater than O(n)