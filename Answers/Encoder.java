import java.util.Scanner;

public class Encoder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the information to encrypt: ");
        String userInput = scanner.nextLine();

        System.out.print("Enter the encryption key (an integer): ");
        int key = scanner.nextInt();

        String endText = Caesar(userInput, key);
        System.out.println("Encrypted text: " + endText);

        scanner.close();
    }
    public static String Caesar(String text, int key) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char newchar = text.charAt(i);

            if (Character.isLetter(newchar)) {
                char endchar = (char) ((newchar - 'A' + key) % 26 + 'A');
                result.append(endchar);
            } else {
                result.append(newchar);
            }
        }

        return result.toString();
    }
}

