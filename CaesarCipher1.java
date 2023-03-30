import java.util.Scanner;
public class CaesarCipher {
    public static void main(String[] args) {
        boolean yes = false;
        int key =0;

        Scanner nu = new Scanner(System.in);
        System.out.println("Please enter word");
        String word = nu.next();

        while(!yes){
            System.out.println("Input any integer from 0-25");
            key = nu.nextInt();
            if (key<26&&key>=0){
                yes = true;
            }
            else{
                System.out.println("Please enter any integer from 0-25");
            }
        }
        for (int i=0; i<word.length();i++){
            word = word.toUpperCase();

            char c = word.charAt(i);
            int position = c -'A';
            int changePosition =(position+key)%26;
            char encrypted = (char) ('A'+changePosition);

            System.out.print(encrypted);

        }



    }
}
