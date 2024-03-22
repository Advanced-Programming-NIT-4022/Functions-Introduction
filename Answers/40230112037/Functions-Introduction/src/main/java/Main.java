import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean done = false;
        String[] interests = new String[0];
        String firstname, lastname, fullname = "", id = "", phone = "";
        boolean fullNameDone, idDone, phoneDone, interestsDone;
        fullNameDone = idDone = phoneDone = interestsDone = false;
        while (!done) {
            try {
                if (!fullNameDone) {
                    System.out.print("First Name: ");
                    firstname = scanner.nextLine();
                    System.out.print("Last Name: ");
                    lastname = scanner.nextLine();
                    fullname = fullName(firstname, lastname);
                    fullNameDone = true;
                }
                if (!phoneDone) {
                    System.out.print("Phone number: ");
                    phone = phoneNumber(scanner.nextLine());
                    phoneDone = true;
                }
                if (!idDone) {
                    System.out.print("User ID: ");
                    id = userId(scanner.nextLine());
                    idDone = true;
                }
                if (!interestsDone) {
                    System.out.println("Interests: (Enter an empty line to stop)");
                    interests = getInterests(10);
                    interestsDone = true;
                }
                done = true;
            } catch (Error error) {
                System.out.println(error.getMessage());
            } catch (Exception exception) {
                System.out.println("Wrong Input!");
            }
        }
        done = false;
        while (!done) {
            try {
                System.out.print("Do you want to get the output encoded? [Y/n] ");
                String input = scanner.nextLine();
                if (input.isBlank() || input.startsWith("y") || input.startsWith("Y")) {
                    System.out.print("Enter shift value: ");
                    int shift = scanner.nextInt();
                    System.out.println(informationEncoder(userFullInformation(fullname, phone, id, interests), shift));
                    done = true;
                } else if (input.startsWith("n") || input.startsWith("N")) {
                    System.out.println(userFullInformation(fullname, phone, id, interests));
                    done = true;
                }
            } catch (Exception exception) {
                System.out.println("Unexpected error happened!");
            }
        }
        scanner.close();
    }

    public static String normalizeName(String name) {
        return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    }

    public static String fullName(String firstName, String lastName) {
        if (firstName.isBlank()) {
            throw new Error("firstName is Empty!");
        }
        if (lastName.isBlank()) {
            throw new Error("lastName is Empty!");
        }
        firstName = normalizeName(firstName);
        lastName = normalizeName(lastName);
        return firstName + " " + lastName;
    }

    public static String phoneNumber(String phone) {
        switch (phone.length()) {
            case 10:
                if (phone.charAt(0) != '9') {
                    throw new Error("invalid phone number! (enter phone number like 09xxxxxxxxx or 9xxxxxxxxx)");
                }
                phone = "0" + phone;
                break;
            case 11:
                if (phone.charAt(0) != '0' || phone.charAt(1) != '9') {
                    throw new Error("invalid phone number! (enter phone number like 09xxxxxxxxx or 9xxxxxxxxx)");
                }
                break;
            default:
                throw new Error("invalid phone number! (phone number length should be 10 or 11)");
        }
        for (char i : phone.toCharArray()) {
            if (i < '0' || i > '9') {
                throw new Error("invalid phone number! (phone number should only contains numbers)");
            }
        }
        return phone;
    }

    public static String userId(String id) {
        if (id.length() < 4 || id.length() > 13) {
            throw new Error("id is not valid! (id length should be between 4 and 13)");
        }
        for (char i : id.toCharArray()) {
            if (i < '0' || i > '9') {
                throw new Error("id is not valid! (id should only contains numbers)");
            }
        }
        return id;
    }

    public static String arrayToString(String[] array) {
        StringBuilder arrayString = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            arrayString.append(i + 1);
            arrayString.append(". ");
            arrayString.append(array[i]);
            if (i != array.length - 1) arrayString.append("\n");
        }
        return arrayString.toString();
    }

    public static String[] getInterests(int number) {
        if (number < 1) {
            throw new Error("Unexpected error!");
        }
        String[] interests = new String[number];
        Scanner scanner = new Scanner(System.in);
        int i;
        for (i = 0; i < 10; i++) {
            String nextLine = scanner.nextLine();
            if (nextLine.isBlank()) break;
            interests[i] = nextLine;
        }
        scanner.close();
        return Arrays.copyOf(interests, i);
    }

    public static String informationEncoder(String information, int shift) {
        char[] encodedInformation = new char[information.length()];
        char[] informationChars = information.toCharArray();
        for (int i = 0; i < informationChars.length; i++) {
            if (informationChars[i] >= 'a' && informationChars[i] <= 'z') {
                encodedInformation[i] = (char) (((informationChars[i] + shift - 'a') + 26) % 26 + 'a');
            } else if (informationChars[i] >= 'A' && informationChars[i] <= 'Z') {
                encodedInformation[i] = (char) (((informationChars[i] + shift - 'A') + 26) % 26 + 'A');
            } else if (informationChars[i] >= '0' && informationChars[i] <= '9') {
                encodedInformation[i] = (char) (((informationChars[i] + shift - '0') + 10) % 10 + '0');
            } else {
                encodedInformation[i] = informationChars[i];
            }
        }
        return new String(encodedInformation);
    }

    public static String informationDecoder(String information, int shift) {
        return informationEncoder(information, -shift);
    }

    public static String userFullInformation(String fullname, String phonenumber, String userid, String[] interests) {
        String intererestsString = (interests.length != 0) ? " Here are some of my interests:\n" + arrayToString(interests) : "";
        return "Hello! My name is " + fullname + ". My ID is " + userid + "." + intererestsString + "\n\nYou can reach me via my phone number " + phonenumber + ".";
    }
}
