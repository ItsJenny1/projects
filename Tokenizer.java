
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Tokenizer {
    private final Scanner scanner;

    public Tokenizer(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        this.scanner = new Scanner(file);
    }

    public String nextLine() {
        if (this.scanner.hasNextLine()) {
            StringBuilder sb = new StringBuilder();
            String line = this.scanner.nextLine();
            sb.append(line);
            while (this.scanner.hasNextLine()) {
                String nextLine = this.scanner.nextLine();
                sb.append("\n").append(nextLine);
                if (nextLine.matches(".*(;|\\}|\\)).*")) {
                    break;
                }
            }
            return sb.toString();
        } else {
            return null;
        }
    }
}




