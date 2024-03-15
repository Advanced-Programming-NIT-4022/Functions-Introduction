import java.util.Scanner;

public class Main {
    public static String fullName(String firstname,String lastName) {
        String str1 = firstname.substring(1);
        String str2 = lastName.substring(1);
        String str3 = str1.toLowerCase();
        String str4 = str2.toLowerCase();
        String a = firstname.substring(0,1);
        String b = lastName.substring(0,1);
        String c = a.toUpperCase();
        String d = b.toUpperCase();
        String fullName = c + str3 + " " + d + str4;
        return fullName;
    }
    public static String phoneNumber(String phone) {
        Scanner sc = new Scanner(System.in);
        while ( ( phone.charAt(0) != '9' )||(phone.length() != 10 ) ) {
            System.out.println("Please enter a valid number.");
            phone = sc.nextLine();
        }
        String phoneNumber = "0"+phone;
        return phoneNumber;
    }
    public static String userId(String id) {
        Scanner sc = new Scanner(System.in);
        while ( ( id.length() < 4 ) || ( id.length() > 13 ) ) {
            System.out.println("Please enter a valid id.");
            id = sc.nextLine();
        }
        String userId = id;
        return userId;
    }
    public static void getInterests(String[] A) {
        Scanner sc = new Scanner(System.in);
        for (int i=0 ; i<10 ; i++) {
            String str = sc.nextLine();
            A[i] = str;
        }
    }
    public static void showArray(String[] A) {
        System.out.print("{");
        for (int i=0 ; i<10 ; i++) {
            System.out.print("\""+A[i]+"\",");
        }
        System.out.print("}\n");
    }
    public static void userFullInformation(String fullName, String phoneNumber, String userId, String[] interests) {
        System.out.println("Hello, My name is "+fullName+". My ID is "+userId+". Here are some of my interests:");
        for (int i=0 ; i<10 ; i++) {
            System.out.println((i+1)+". "+interests[i]);
        }
    }
    public static String informationEncoder(String information, int shift) {
        for (int i=0 ; i<information.length() ; i++) {
            int a = information.charAt(i);
            if (64 < a && a <91) {
                a = (((a - 65) + shift) % 26) + 65;
            }
            else if (96 < a && a < 123) {
                a = (((a - 97) + shift) % 26) + 97;
            }
            char b = (char)a;
            information = information.substring(0,i) + b + information.substring(i+1);
        }
        return information;
    }
    public static String informationDecoder(String encoded, int shift) {
        for (int i=0 ; i<encoded.length() ; i++) {
            int a = encoded.charAt(i);
            if (64 < a && a <91) {
                a = (((a - 65) - shift) % 26) + 65;
            }
            else if (96 < a && a < 123) {
                a = (((a - 97) - shift) % 26) + 97;
            }
            char b = (char)a;
            encoded = encoded.substring(0,i) + b + encoded.substring(i+1);
        }
        return encoded;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String firstName = sc.nextLine();
        String lastName = sc.nextLine();
        String fullName = fullName(firstName,lastName);
        System.out.println(fullName);
        String phone = sc.nextLine();
        String phoneNumber = phoneNumber(phone);
        System.out.println(phoneNumber);
        String id = sc.nextLine();
        String userId = userId(id);
        System.out.println(userId);
        String[] interests = new String[10];
        getInterests(interests);
        showArray(interests);
        userFullInformation(fullName,phoneNumber,userId,interests);
        String information = sc.nextLine();
        int shift = sc.nextInt();
        String encoded = informationEncoder(information,shift);
        String decoded = informationDecoder(encoded,shift);
        System.out.println(encoded);
        System.out.println(decoded);
    }
}