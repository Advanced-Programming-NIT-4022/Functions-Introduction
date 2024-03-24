package org.example;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your first name: ");
        String firstName = sc.nextLine();
        System.out.println("Enter your last name: ");
        String lastName = sc.nextLine();
        String FullName = fullName(firstName, lastName);
        System.out.println("Full Name: " + FullName);

        System.out.println("Enter your phone number: ");
        char[] num = sc.next().toCharArray();
        char[] PN = phoneNumber(num);
        System.out.println(PN);

        System.out.println("Enter your ID: ");
        int ID = sc.nextInt();
        int userID = userid(ID);

        System.out.println("Enter your interest: ");
        String interest = sc.next();
        ArrayList<String> interests = new ArrayList<>();
        interests = getInterests(interest);
        System.out.println(interests);

        String full = userFullInformation(FullName, PN, userID, interests).toString();
        System.out.println(full);

        Scanner s = new Scanner(System.in);
        System.out.println("Enter a text to be encrypted: ");
        String information = s.nextLine();
        System.out.println("Enter wanted shift: ");
        int shift = s.nextInt();
        informationEncoder(information, shift);

        Scanner ss = new Scanner(System.in);
        System.out.println("Enter encoded text: ");
        information = ss.nextLine();
        System.out.println("Enter wanted shift: ");
        shift = ss.nextInt();
        informationDecoder(information, shift);

        Scanner sss = new Scanner(System.in);
        System.out.println("\nDo you want to see the encoded form of your info?" +
                "\nEnter 'yes' or 'no'.");
        String ans = sss.nextLine();
        if (ans.equals("yes")) {
            System.out.println("Ok then! Enter wanted shift: ");
            shift = s.nextInt();
            informationEncoder(full, shift);
        }

    }

    static String fullName(String firstName, String lastName) {
        char[] first = firstName.toCharArray();
        char[] last = lastName.toCharArray();
        first[0] = Character.toUpperCase(first[0]);
        last[0] = Character.toUpperCase(last[0]);
        for (int i = 1; i < first.length; i++) {
            first[i] = Character.toLowerCase(first[i]);
        }
        for (int i = 1; i < last.length; i++) {
            last[i] = Character.toLowerCase(last[i]);
        }
        String fullName = String.valueOf(first) + " " + String.valueOf(last);
        return fullName;
    }
    static char[] phoneNumber(char[] num) {
        Scanner sc = new Scanner(System.in);
        if (num.length == 10 && num[0] == '9') {
            char[] newNum = new char[num.length + 1];
            newNum[0] = '0';
            System.arraycopy(num, 0, newNum, 1, 10);
            return newNum;
        }
        else {
            System.out.println("Invalid number. Try again: ");
            num = sc.next().toCharArray();
            return phoneNumber(num);
        }
    }
    static int userid(int ID) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        int tmp = ID;
        for (; tmp > 0; tmp /= 10) {
            count++;
        }
        if (count > 3 && count < 14)
            return ID;
        else {
            System.out.println("Invalid ID. Try again: ");
            ID = sc.nextInt();
            return userid(ID);
        }
    }
    static ArrayList<String> getInterests(String interest) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> interests = new ArrayList<>();
        interests.add(interest);
        int count = 1;
        while (count < 10) {
            System.out.println("Enter another interest: (if there's none, enter 'done')");
            String word = sc.nextLine();
            if (word.equals("done"))
                break;
            else {
                interests.add(word);
                count++;
            }
        }
        return interests;
    }
    static StringBuilder userFullInformation(String FullName, char[] PN, int userID, ArrayList<String> interests) {
        StringBuilder full = new StringBuilder();
        full.append("\n\nHello! My name is ");
        full.append(FullName);
        full.append(". My ID is ");
        full.append(userID);
        full.append(". Here are some of my interests: ");
        for (int i = 0; i < interests.size(); i++) {
            full.append("\n");
            full.append((i+1));
            full.append(". ");
            full.append(interests.get(i));
        }
        full.append("\n\nYou can reach me via my phone number ");
        for (char c : PN) {
            full.append(c);
        }
        full.append(".");
        return full;
    }
    static void informationEncoder(String information,int shift) {
        StringBuffer encrypted = new StringBuffer();
        for (int i = 0; i < information.length(); i++) {
            if (((int)information.charAt(i) > 90 && (int)information.charAt(i) < 97) ||
                    ((int)information.charAt(i)  < 65) ||
                    ((int)information.charAt(i) > 122)) {
                encrypted.append(information.charAt(i));
                continue;
            }
            else if (Character.isUpperCase(information.charAt(i))) {
                char a = (char)(((int)information.charAt(i) + shift - 65) % 26 + 65);
                encrypted.append(a);
            }
            else {
                char a = (char)(((int)information.charAt(i) + shift - 97) % 26 + 97);
                encrypted.append(a);
            }
        }
        System.out.println("Encrypted text: " + encrypted);
    }
    static void informationDecoder(String information, int shift) {
        StringBuffer decoded = new StringBuffer();
        for (int i = 0; i < information.length(); i++) {
            if (((int)information.charAt(i) > 90 && (int)information.charAt(i) < 97) ||
                    ((int)information.charAt(i)  < 65) ||
                    ((int)information.charAt(i) > 122)) {
                decoded.append(information.charAt(i));
                continue;
            }
            else if (Character.isUpperCase(information.charAt(i))) {
                char a = (char)(((int)information.charAt(i) - shift - 65 + 26) % 26 + 65);
                decoded.append(a);
            }
            else {
                char a = (char)(((int)information.charAt(i) - shift - 97 + 26) % 26 + 97);
                decoded.append(a);
            }
        }
        System.out.println("decoded text: " + decoded);
    }
}