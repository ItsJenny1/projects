import java.io.FileNotFoundException;

public class grammarLex {
    public static final String EXPRESSION = "Expression";

    public static final String STMNT = "Statement";
    public static final String IF_STMT = "IF STATEMENT";
    public static final String BLOCK = "BLOCK";
    public static final String WHILE_LOOP = "WHILE LOOP";
    public static final String BOOL_EXPR = "BOOLEAN EXPRESSION";


    public static final String INT_LIT = "integer";
    public static final String IDENT = "variable identifiers";
    public static final String ASSIGN_OP = "Assignment Operation";
    public static final String ADD_OP = "Addition Operation";
    public static final String SUB_OP = "Subtraction Operation";
    public static final String MULT_OP = "Multiplication Operation";
    public static final String DIV_OP = "Division Operation";
    public static final String LEFT_PAREN = "Left Parenthesis";
    public static final String LESS_OP = "Less <";
    public static final String LESSTHAN_OP = "Less Than <=";
    public static final String GREAT_OP = "Greater Than >";
    public static final String GREATTHAN_OP = "Greater than >=";
    public static final String AND_OP = "Logical AND";
    public static final String OR_OP = "Logical OR";
    public static final String FLOAT_LIT = "Float Literal";
    public static final String RIGHT_PAREN = "Right Parenthesis";
    public static final String MOD_OP = "Modulus Operand";
    public static final String EQUAL_OP = "Equal operand";
    String nextToken;

    public static void main(String[] args) {
        try {
            Token tokenizer = new Token("plc6.txt");
            while (tokenizer.hasNext()) {
                tokenizer.advance();
                String currentToken = tokenizer.getCurrentToken();
                String nextToken = tokenizer.getNextToken();
                System.out.println("Current token: " + currentToken);
                if (nextToken != null) {
                    System.out.println("Next token: " + nextToken);
                }
                if(currentToken.equals(EXPRESSION)){

                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }



    public static boolean isBool(String line){
        return line.contains("==")||line.contains("!=")||line.contains("!=")||line.contains("&&")||line.contains("||")||line.contains("<")
                ||line.contains(">")||line.contains(">=")||line.contains("<=");

    }
    void error(){
        System.out.println("error");
    }
  void BOOl(String current, String next){
        if (nextToken!= IF_STMT){
            error();
        }
  }



}

