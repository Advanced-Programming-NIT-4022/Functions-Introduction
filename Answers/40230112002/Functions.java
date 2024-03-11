import java.util.Scanner;

public class Functions {
    // fullName Function
    public static String fullName(String firstName , String lastName){

        firstName = firstName.toLowerCase();
        String[] firstname = firstName.split("");
        firstname[0] = firstname[0].toUpperCase();
        String Firstname = String.join("" , firstname);

        lastName = lastName.toLowerCase();
        String[] lastname = lastName.split("");
        lastname[0] = lastname[0].toUpperCase();
        String Lastname = String.join("" , lastname);
        String FullName = Firstname+" "+Lastname;

        return FullName;
    }

    public static String Phone(String phone) {

        String[] phoneNumbers = phone.split("");
        Scanner sc = new Scanner(System.in);
        while(true){
            if(phoneNumbers[0].equals("9") && phoneNumbers.length == 10){
                phone = "0" + phone;
                return phone;
            }
            else{
                System.out.println("Error : Unvalid Phone number !! \n Try Again ... \n Enter a valid Phone number : ");
                return "Error";
            }
        }
    }



    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your firstname : ");
        String firstname = sc.nextLine();
        System.out.println("Enter your lastname : ");
        String lastname = sc.nextLine();
        String Fullname = fullName(firstname , lastname);

        System.out.println("Enter a valid Phone number : ");
        while (true){

            String phone = sc.nextLine();
            if(!Phone(phone).equals("Error")){
                phone = Phone(phone);
                break;
            }
        }

    }
}