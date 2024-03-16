import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        // full name
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Your first name :");
        String first_name = sc.next();
        System.out.println("Enter your last name :");
        String last_name = sc.next();
        String full_name = fullName(first_name, last_name);
        System.out.println(full_name);
        // phone number
        System.out.println("Enter phone number : ");
        String phone = sc.next();
        String newPhone = phoneNumber(phone);
        while(newPhone == "Wrong"){
            System.out.println("Wrong entry. Try again.");
            phone = sc.next();
            newPhone = phoneNumber(phone);
        }
        System.out.println(newPhone);
        // 

    }

    public static String fullName(String firstName, String lastName) {
        firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1).toLowerCase();
        lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1).toLowerCase();
        return firstName + " " + lastName;
    }

    public static String phoneNumber(String phone){
        if (phone.length() == 10 && phone.startsWith("9")){
            return "0" + phone;
        }
        return "Wrong";
    }
}
