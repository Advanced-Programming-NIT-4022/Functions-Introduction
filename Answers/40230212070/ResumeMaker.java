import java.util.ArrayList;
import java.util.Scanner;

public class ResumeMaker {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        String firstName,lastName,phone="",userId="",interest;
        ArrayList<String> interests=new ArrayList<>();
        int shift =0;
        System.out.println("Welcome to the Resume Maker!");
        System.out.print("Enter your first name: ");
        firstName = scanner.nextLine();
        System.out.print("Enter your last name: ");
        lastName = scanner.nextLine();
        String fullName = fullName(firstName, lastName);
        phone = getPhoneNumber(scanner);
        userId = getUserId(scanner);
        interests = getInterests(scanner);
        String choice;
        do{    System.out.println("\nHow would you like to see your information?");
            System.out.println("1. Normal");
            System.out.println("2. Encrypted (enter a shift value)");
            System.out.println("3. Exit");
            choice = scanner.nextLine();
            switch (choice){

                switch (choice) {
                    case "1":
                        System.out.println("\nYour information:");
                        System.out.println(userFullInformation(fullName, phone, userId, interests));
                        break;
                    case "2":
                        do {
                            System.out.print("Enter a shift value for encryption (1-25): ");
                            String inputShift = scanner.nextLine();
                            if (!isInteger(inputShift) ||shift < 1 || shift > 25) {
                                System.out.println("Invalid shift value. Please enter a number between 1 and 25.");
                            } else {
                                shift = Integer.parseInt(inputShift);
                            }
                        } while (shift < 1 || shift > 25);
                        String encodedInfo = informationEncoder(userFullInformation(fullName, phone, userId, interests), shift);
                        System.out.println("\nYour encoded information:");
                        System.out.println(encodedInfo);
                        break;
                    case "3":
                        System.out.println("Thank you for using the Resume Maker!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter 1, 2, or 3.");
                }
            } while (!choice.equals("3"));
            }
}
