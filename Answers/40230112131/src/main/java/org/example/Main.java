package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        //2
        Scanner scanner = new Scanner(System.in);
        String phone;

        do {
            System.out.print("Phone: ");
            phone = scanner.nextLine();
            phone = phoneNumber(phone);
        } while (phone == null);

        System.out.println("Output: " + phone);






        //3
        String id;

        do {
            System.out.print("ID: ");
            id = scanner.nextLine();
            id = userId(id);
        } while (id == null);

        System.out.println("Output: " + id);






        //4
        String[] interests = new String[10];
        System.out.println("Enter your interests (maximum 10). Enter 'done' to finish:");
        int count = 0;
        String interest;
        do {
            System.out.print("Input: ");
            interest = scanner.nextLine().trim();

            if (!interest.equalsIgnoreCase("done")) {
                if (count < 10) {
                    interests[count] = interest;
                    count++;
                } else {
                    System.out.println("Maximum number of interests reached.");
                    break;
                }
            }
        } while (!interest.equalsIgnoreCase("done"));

        System.out.print("Output: {");
        for (int i = 0; i < count; i++) {
            System.out.print("\"" + interests[i] + "\"");
            if (i < count - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("}");







        //5
        System.out.print("Full name: ");
        String fullName = scanner.nextLine();

        System.out.print("Phone number: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("User ID: ");
        String userID = scanner.nextLine();

        String[] interests2 = getInterests(scanner);

        String output = userFullInformation(fullName, phoneNumber, userID, interests2);
        System.out.println(output);







        //6
        String information = "Hello, my name is Aryanoor. I am learning Java.";
        int shift = 3;

        String encryptedInformation = informationEncoder(information, shift);
        System.out.println("Output: " + encryptedInformation);






        //7
        System.out.print("Enter your information: ");
        String information2 = scanner.nextLine();

        // Get the shift value
        System.out.print("Enter the shift value: ");
        int shift2 = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        // Encrypt the information
        String encodedInformation = informationEncoder2(information2, shift2);
        System.out.println("Encoded information: " + encodedInformation);

        // Decode the encoded information
        String decodedInformation = informationDecoder(encodedInformation, shift2);
        System.out.println("Decoded information: " + decodedInformation);
    }




    public static String phoneNumber(String phone) {
        if (phone.startsWith("9") && phone.length() == 10) {
            return "0" + phone;
        } else {
            System.out.println("Wrong entry. Try again.");
            return null;
        }
    }
    public static String userId(String id) {
        if (id.length() >= 4 && id.length() <= 13) {
            if (id.matches("\\d+")) {
                return id;
            } else {
                System.out.println("Invalid format. ID should contain only digits.");
                return null;
            }
        } else {
            System.out.println("Invalid length. ID should be between 4 to 13 digits.");
            return null;
        }
    }
    public static String userFullInformation(String fullName, String phoneNumber, String userID, String[] interests) {
        StringBuilder info = new StringBuilder("Hello! My name is " + fullName + ". My ID is " + userID + ". Here are some of my interests:\n");

        for (int i = 0; i < interests.length; i++) {
            info.append(i + 1).append(". ").append(interests[i]).append("\n");
        }

        info.append("\nYou can reach me via my phone number ").append(phoneNumber).append(".");
        return info.toString();
    }

    public static String[] getInterests(Scanner scanner) {
        String[] interests = new String[10];

        System.out.println("Enter your interests (maximum 10). Enter 'done' to finish:");

        int count = 0;
        String interest;
        do {
            System.out.print("Interest: ");
            interest = scanner.nextLine().trim();

            if (!interest.equalsIgnoreCase("done")) {
                if (count < 10) {
                    interests[count] = interest;
                    count++;
                } else {
                    System.out.println("Maximum number of interests reached.");
                    break;
                }
            }
        } while (!interest.equalsIgnoreCase("done"));

        // Truncate the interests array if the count is less than 10
        String[] truncatedInterests = new String[count];
        System.arraycopy(interests, 0, truncatedInterests, 0, count);
        return truncatedInterests;
    }

    public static String informationEncoder(String information, int shift) {
        StringBuilder encrypted = new StringBuilder();

        for (int i = 0; i < information.length(); i++) {
            char currentChar = information.charAt(i);

            // Encrypt alphabetic characters (ignore non-alphabetic characters)
            if (Character.isLetter(currentChar)) {
                // Determine if the character is uppercase or lowercase
                char base = Character.isUpperCase(currentChar) ? 'A' : 'a';
                // Apply the Caesar Cipher shift
                char encryptedChar = (char) (((currentChar - base + shift) % 26) + base);
                encrypted.append(encryptedChar);
            } else {
                // Keep non-alphabetic characters unchanged
                encrypted.append(currentChar);
            }
        }

        return encrypted.toString();
    }
    public static String informationEncoder2(String information, int shift) {
        return applyCipher(information, shift);
    }

    public static String informationDecoder(String encodedInformation, int shift) {
        // To decode, we apply a negative shift
        return applyCipher(encodedInformation, -shift);
    }

    private static String applyCipher(String text, int shift) {
        StringBuilder result = new StringBuilder();

        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isUpperCase(character) ? 'A' : 'a';
                char encryptedChar = (char) (((character - base + shift + 26) % 26) + base);
                result.append(encryptedChar);
            } else {
                result.append(character);
            }
        }

        return result.toString();
    }
}