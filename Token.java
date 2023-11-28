import java.io.File;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Token {
    private Scanner scanner;
    private String currentToken;
    private String nextToken;

    public Token(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        scanner = new Scanner(file);
        currentToken = null;
        nextToken = null;
    }

    public String getCurrentToken() {
        return currentToken;
    }

    public String getNextToken() {
        return nextToken;
    }

    public boolean hasNext() {
        return scanner.hasNext();
    }

    public void advance() {
        if (scanner.hasNext()) {
            if (currentToken == null) {
                currentToken = scanner.next();
            } else {
                currentToken = nextToken;
            }
            nextToken = scanner.hasNext() ? scanner.next() : null;
        }
    }

}

//  public static String nextToken() {
//        if (scanner.hasNext()) {
//            currentToken = scanner.next();
//            return currentToken;
//        } else {
//            return null;
//        }
//    }