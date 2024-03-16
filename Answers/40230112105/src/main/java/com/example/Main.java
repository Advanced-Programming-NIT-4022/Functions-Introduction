import java.util.Scanner;

public class Main {
    static String fullName(String fristName,String lastName) {
        fristName = fristName.toLowerCase();
        lastName = lastName.toLowerCase();
        fristName = fristName.substring(0,1).toUpperCase() + fristName.substring(1);
        lastName = lastName.substring(0,1).toUpperCase() + lastName.substring(1);
        return fristName + " " + lastName;

    }

    static String phoneNumber(long number) {
        Scanner longScanner = new Scanner(System.in);
        String strNumber = "999";
        int size;
        boolean flag = false;
        while(!flag){
            strNumber = String.valueOf(number);
            size = strNumber.length();
            if (strNumber.substring(0, 1).equals("9") && size == 10) {
                flag = true;
            } else {
                System.out.println("Wrong entry. Try again");
                number = longScanner.nextLong();
            }
        }
        return "0" + strNumber;
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
        Scanner longScanner = new Scanner(System.in);
        System.out.print("please enter your number witout zero ate the first: ");
        long number = longScanner.nextLong();
        System.out.println(phoneNumber(number));
        ////////////////////////////////////////////////
        System.out.println("RUNNING >>> userId function");
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
        
    }

}