import java.util.Scanner;

public class Main {
    static String fullName(String fristName,String lastName) {
        fristName = fristName.toLowerCase();
        lastName = lastName.toLowerCase();
        fristName = fristName.substring(0,1).toUpperCase() + fristName.substring(1);
        lastName = lastName.substring(0,1).toUpperCase() + lastName.substring(1);
        return fristName + " " + lastName;

    }

    static String phoneNumber(String number) {
        Scanner strScanner = new Scanner(System.in);
        int size;
        boolean flag = false;
        while(!flag){
            size = number.length();
            if (number.substring(0, 1).equals("9") && size == 10) {
                flag = true;
            } else {
                System.out.println("Wrong entry. Try again");
                number = strScanner.next();
            }
        }
        return "0" + number;
    }

    static long userId(long id) {
        Scanner longScanner = new Scanner(System.in);
        String strId;
        boolean flag = false;
        while(!flag) {
            strId = String.valueOf(id);
            if(strId.length() <= 13 && strId.length() >= 4){
                flag = true;
            } else {
                System.out.println("Wrong entry. Try again");
                id = longScanner.nextLong();
            }
        }
        return id;
    }

    static String[] getInterests(String[] interests) { 
        Scanner strScanner = new Scanner(System.in);
        String interest = "NIMA";
        int index = 0;
        while (index != 10) {
            System.out.print("give me your interest(if you dont have more interests type\"end\"): ");
            interest = strScanner.next();
            if (interest.equals("end")) {
                break;
            } else {
                interests[index] = interest;
                index++;
            }
        }
        
        return interests;
    }

    static String userFullInformation(String full_name, String number, long ID, String[] interests){
        String info = "Hello! my name is " + full_name + ". My ID is " + ID + ". Here are some of my interests: " + "\n";
        String interest = "";
        int i = 0;
        while (interests[i] != null) {
            interest += i + 1 + ". " + interests[i] + "\n";
            i++;
        }
        String info2 = "You can reach me via my phone number " + number;
        String full_info = info + interest + info2;
        return full_info;
    }

    static String informationEncoder(String information,int shift) {
        int shift_temp = shift;
        String new_sentence = "";
        for(int i = 0; i< information.length(); i++){
            char character = information.charAt(i);
            if((character <= 90 && character >= 65) || (character <= 122 && character >= 97) || (character <= 57 && character >= 48)) {
                if(character + shift <= 90){
                    character += shift;
                } else if (character + shift <= 122 && character >= 97) {
                    character += shift;
                } else if (character + shift >= 122 && character >= 97) {
                    shift -= 122 - character;
                    character = (char)(96 + shift);
                } else if (character + shift >= 90) {
                    shift -= 90 - character;
                    character = (char)(64 + shift);
                }
            }
            new_sentence = new_sentence + character;
            shift = shift_temp;
        }
        return new_sentence;
    }

    public static void main(String[] args) {
        System.out.println("RUNNIG >>> fullName function");
        Scanner strScanner = new Scanner(System.in);
        System.out.print("please enter your first name: ");
        String name = strScanner.next();
        System.out.print("please enter your last name: ");
        String last = strScanner.next();
        System.out.println(fullName(name, last));
        ////////////////////////////////////////////////
        System.out.println("RUNNING >>> phoneNumber function");
        System.out.print("please enter your number witout zero ate the first: ");
        String number = strScanner.next();
        System.out.println(phoneNumber(number));
        ////////////////////////////////////////////////
        System.out.println("RUNNING >>> userId function");
        Scanner longScanner = new Scanner(System.in);
        System.out.print("please give me a standard ID: ");
        long ID = longScanner.nextLong();
        System.out.println(userId(ID));
        ////////////////////////////////////////////////
        System.out.println("RUNNING >>> getInterests function");
        String[] interests = new String[10];
        interests = getInterests(interests);
        int i = 0;
        System.out.print("interests: {");
        while (interests[i] != null) {
            System.out.print("\"" + interests[i] + "\" ");
            i++;
        }
        System.out.println("}");
        /////////////////////////////////////////////////
        System.out.println("RUNNING >>> userFullInformation function");
        String full_name = fullName(name, last);
        System.out.println(userFullInformation(full_name, number, ID, interests));
        /////////////////////////////////////////////////
        System.out.println("RUNNING >>> informationEncoder function");
        Scanner intScanner = new Scanner(System.in);
        System.out.print("How much do you want to shift your information: ");
        int shift = intScanner.nextInt();
        System.out.println(informationEncoder(userFullInformation(full_name, number, ID, interests), shift));
        //////////////////////////////////////////////////
    }
}