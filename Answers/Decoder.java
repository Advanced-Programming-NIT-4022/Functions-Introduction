import java.util.Scanner;

public class Decoder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the encoded text to decode: ");
        String encodedText = scanner.nextLine();

        System.out.print("Enter the decryption key (an integer): ");
        int key = scanner.nextInt();

        String decodedText = decodeCaesar(encodedText, key);
        System.out.println("Decoded text: " + decodedText);

        scanner.close();
    }

    public static String decodeCaesar(String encodedText, int key) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < encodedText.length(); i++) {
            char currentChar = encodedText.charAt(i);

            if (Character.isLetter(currentChar)) {
                char decryptedChar = (char) ((currentChar - 'a' - key + 26) % 26 + 'a');
                result.append(decryptedChar);
            } else {
                result.append(currentChar);
            }
        }

        return result.toString();
    }
}