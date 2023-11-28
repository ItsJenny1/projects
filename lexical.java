import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;
import java.util.Scanner;

public class lexical {
    public static final String EXPRESSION = "Expression";
    public static final String STMNT = "Statement";
    public static final String IF_STMT = "IF STATEMENT";
    public static final String block = "BLOCK";
    public static final String WHILE_LOOP = "WHILE LOOP";



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
    public static final String DATA_TYPE = "DATA TYPE";


    public static void main(String[] args) {

        try {

            // Open the text file for reading
            File file = new File("plc6.txt");
            Scanner scanner = new Scanner(file);
            StringBuilder token = new StringBuilder();
            StringBuilder lineBuilder = new StringBuilder();

            // Loop through the file character by character

            String result;
            //String word = "";
            while (scanner.hasNextLine())  {
                String line = scanner.nextLine().trim();
                String currentLine;
                if (!line.isEmpty()) {
                    lineBuilder.append(line);

                    if (line.matches(".*[;)}].*")) {
                        currentLine = lineBuilder.toString();
                        lineBuilder.setLength(0);

                        System.out.println("Current line: " + currentLine);

                        for (int i = 0; i < line.length(); i++) {

                            char ch = line.charAt(i);


                            if (!Op(Integer.toString(ch))) {

                                if (Character.isDigit(ch)) {
                                    token.append((char) ch);
                                } else if (ch == '.') {
                                    token.append((char) ch);
                                } else if (Character.isWhitespace(ch)) {
                                    if (token.length() > 0) {
                                        String word = token.toString();
                                        if (num(word) || decL(word) || binL(word) || hexL(word) || octL(word)) {
                                            System.out.println(word + " " + INT_LIT);
                                        } else if (dec(word)) {
                                            System.out.println(word + " is a decimal.");
                                        } else if (isfloat(word) || decfl(word) || hexfl(word)) {
                                            System.out.println(word + " " + FLOAT_LIT);
                                        } else if (var(word)) {
                                            System.out.println(word + " " + IDENT);
                                        }  else if (Op(word)) {
                                            result = evaluate(word);
                                            System.out.println(word + " " + result);

                                        } else if (isExpression(currentLine)) {
                                            System.out.println(currentLine + " " + EXPRESSION);
                                        }else if (evalType(currentLine)) {
                                            System.out.println(currentLine + " " + DATA_TYPE);
                                        }else if (if_stmnt(currentLine)) {
                                            System.out.println(currentLine + " " + IF_STMT);
                                        }else if (while_stmnt(currentLine)) {
                                            System.out.println(currentLine + " " + WHILE_LOOP);
                                        } else if (BLOCK(currentLine)) {
                                            System.out.println(currentLine + " " + block);
                                        }else if (stmnt(currentLine)) {
                                            System.out.println(currentLine + " " + STMNT);
                                        }else {
                                            System.out.println(word + " Unable to identify");
                                        }
                                        token.setLength(0);
                                    }
                                } else {
                                    token.append((char) ch);
                                }


                            }


                        }
                    }
                }

            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    static boolean Op (String op){
        return op.equals("+")||op.equals("-")||op.equals("*")||op.equals("/")||op.equals("%")||op.equals("(")||
                op.equals(")")||op.equals("=");
    }
    static boolean IDS (String op){
        return op.equals("int")||op.equals("var")||op.equals("char")||op.equals("String")||op.equals("long")||op.equals("double")||
                op.equals("boolean")||op.equals("Array");
    }

    public static boolean BLOCK(String line){

        if(line.contains("{")||line.startsWith("}")){
           return true;
        }
        return false;

    }
    //<BOOL_EXPR> --> <BTERM> {(`>`|`<`|`>=`|`<=`) <BTERM>}
    //
    //<BTERM> --> <BAND> {(`==`|`!=`) <BAND>}
    //<BAND> --> <BOR> {`&&` <BOR>}
    //<BOR> --> <EXPR> {`&&` <EXPR>}
    public static boolean isBool(String line){
      return line.contains("==")||line.contains("!=")||line.contains("false")||line.contains("&&")||line.contains("||")||line.contains("<")
              ||line.contains(">")||line.contains(">=")||line.contains("<=")||line.contains("!")||line.contains("true");

    }
    public static boolean isif(String line){
        line = line.trim();
        if(line.startsWith("if")){
            int index = line. indexOf('(');
            return (index >=0 && index < line.length()-1);
        }
        return false;

    }
    public static boolean iswhile(String line){
        line = line.trim();
        if(line.startsWith("while")){
            int index = line. indexOf('(');
            return (index >=0 && index < line.length()-1);
        }
        return false;

    }
    public static boolean while_stmnt(String line){
        if (iswhile(line)&& isBool(line)){
            return true;
        }
        return false;
    }
    public static boolean if_stmnt(String line){
        if (isif(line)&& isBool(line)){
            return true;
        }
        return false;
    }



    public static boolean isExpression(String line) {
        //Check if its a par
        // check if the line contains a letter or a word
        boolean hasWordOrLetter = line.matches(".*[a-zA-Z].*");

        // check if the line contains an operator
        boolean hasOperator = line.matches(".*[+\\-*/%].*");

        // return true if the line has a word/letter and an operator
        return hasWordOrLetter && hasOperator;
    }
    public static boolean evalType(String word) {
        if(IDS(word)){
            return true;
        }
        return false;
    }
        private static String evaluate(String word){

        if(word.equals("+")){
            return ADD_OP;
        }
        if(word.equals("-")){
            return SUB_OP;
        }
        if(word.equals("*")){
            return MULT_OP;
        }
        if(word.equals("/")){
            return DIV_OP;
        }
        if(word.equals("%")){
            return MOD_OP;
        }
        if(word.equals("(")){
            return LEFT_PAREN;
        }
        if(word.equals(")")){
            return RIGHT_PAREN;
        }
        if(word.equals("=")){
            return EQUAL_OP;
        }
        if(word.equals("==")){
            return ASSIGN_OP;
        }
        if(word.equals("<")){
            return LESS_OP;
        }
        if(word.equals("<=")){
            return LESSTHAN_OP;
        }
        if(word.equals(">")){
            return GREAT_OP;
        }
        if(word.equals(">=")){
            return GREATTHAN_OP;
        }
        if(word.equals("&&")){
            return AND_OP;
        }
        if(word.equals("||")){
            return OR_OP;
        }


        return String.valueOf(0);
    }
    private static boolean num (String str) {
        return str.matches("\\d+");
    }

    private static boolean dec (String str) {
        return str.matches("\\d+\\.\\d+");
    }
    private static boolean hexL (String str) {
        return str.matches("^0[Xx][0-9A-Fa-f]+");
    }
    private static boolean octL (String str) {
        return str.matches("^0[0-7]+");
    }
    private static boolean decL (String str) {
        return str.matches("^[-+]?\\\\d+");
    }
    private static boolean binL (String str) {
        return str.matches("^0[Bb][01]+");
    }
    private static boolean isfloat(String str) {
        return str.matches("\\d+\\.\\d+[f|F]");
    }
    private static boolean decfl(String str) {
        return str.matches("^[-+]?\\\\d*\\\\.\\\\d+(?:[eE][-+]?\\\\d+)?");
    }
    private static boolean hexfl(String str) {
        return str.matches("^[-+]?0[xX](?:[0-9A-Fa-f]+\\.?|[0-9A-Fa-f]*\\.[0-9A-Fa-f]+)[pP][-+]?\\d+");
    }
    private static boolean var(String str) {
        return str.matches("^[a-zA-Z_$][a-zA-Z0-9_$]*");
    }
    public static boolean stmnt (String line) {
        if (line == "while") {
            while_stmnt(line);
        } else if (line == "if") {
            if_stmnt(line);
        } else if (var(line) || decL(line) || isfloat(line)) {
            isExpression(line);
            return true;

        }

            return false;



    }
}
