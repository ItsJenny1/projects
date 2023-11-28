import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static final String EXPRESSION = "Expression";
    public static final String IF_CODE = "If statement";


    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("plc6.txt"));
            StringBuilder lineBuilder = new StringBuilder();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();

                if (!line.isEmpty()) {
                    lineBuilder.append(line);

                    if (line.matches(".*[;)}].*")) {
                        String currentLine = lineBuilder.toString();
                        lineBuilder.setLength(0);

                        System.out.println("Current line: " + currentLine);

                        if (isExpression(currentLine)) {
                            System.out.println("Expression");
                        }
                        if (isIf_stmnt(currentLine)) {
                            System.out.println("if");
                        }
                    }
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
    public static boolean isExpression(String line) {
        // check if the line contains a letter or a word
        boolean hasWordOrLetter = line.matches(".*[a-zA-Z].*");

        // check if the line contains an operator
        boolean hasOperator = line.matches(".*[+\\-*/%].*");

        // return true if the line has a word/letter and an operator
        return hasWordOrLetter && hasOperator;
    }
    public static boolean isIf_stmnt (String line){
        boolean hasWordOrLetter = line.startsWith("if");
        return hasWordOrLetter;
    }
    void ifstmt(String Line){

    }


}