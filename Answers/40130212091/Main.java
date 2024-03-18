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

        // phone number
        System.out.println("Enter phone number : ");
        String phone = sc.next();
        String newPhone = phoneNumber(phone);
        while(newPhone == "Wrong"){
            System.out.println("Wrong entry. Try again.");
            phone = sc.next();
            newPhone = phoneNumber(phone);
        }

        // user ID
        System.out.println("Enter User ID : ");
        String id = sc.next();
        String newId = userId(id);
        while (newId == "Wrong"){
            System.out.println("ID is incorrect. please enter again : ");
            id = sc.next();
            newId = userId(id);
        }

        // user interest
        String[] interests = getInterests();

        // user full information
        userFullInformation(full_name, newPhone, newId, interests);
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

    public static String userId(String id){
        if(id.length() >= 4 && id.length() <= 13 && id.matches("\\d+")){
            return id;
        }
        return "Wrong";
    }

    public static String[] getInterests(){
        Scanner sc = new Scanner(System.in);
        String[] intersets = new String[10];
        int count = 0;
        System.out.println("Enter interest : ");
        intersets[count] = sc.nextLine();
        while (count < 10){
            if(intersets[count].isEmpty()){
                break;
            }
            count++;
            System.out.println("Enter interest : ");
            intersets[count] = sc.nextLine();
        }
        String[] result = new String[count];
        for(int i = 0; i < count; i++){
            result[i] = intersets[i];
        }
        return result;
    }

    public static void userFullInformation(String fullName, String phoneNumber, String userID, String[] interests){
        System.out.println("Hello! My nam is " + fullName + ". My ID is " + userID + ". Here are some of my interests : ");
        int i = 1;
        for (String interest : interests){
            System.out.print(i + ". ");
            System.out.println(interest);
            i++;
        }
        System.out.println("You can reach me via my phone number " + phoneNumber);
    }
}
