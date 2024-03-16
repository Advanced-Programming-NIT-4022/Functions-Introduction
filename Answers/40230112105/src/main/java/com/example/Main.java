import java.util.Scanner;

public class Main {
    static String fullName(String fistName,String lastName) {
        fristName = fristName.toLowerCase();
        lastName = lastName.toLowerCase();
        fristName = fristName.substring(0,1).toUpperCase() + fristName.substring(1);
        lastName = lastName.substring(0,1).toUpperCase() + lastName.substring(1);
        return firstName + " " + lastName;

    }

    static String phoneNumber(long number) {
        Scanner intScanner = new Scanner(System.in);
        String strNumber;
        int size;
        boolean flag = false;
        while(!flag){
            strNumber = String.valueOf(number);
            size = strNumber.length();
            if (strNumber.substring(0, 1).equals("9") && size == 9) {
                falg = true;
            } else {
                System.out.println("Wrong entry. Try again");
                number = intScanner.nextInt();
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
            if(strId.lenght() <= 13 && strId.length() >= 4){
                flag = true;
            } else {
                System.out.println("Wrong entry. Try again");
                id = longScanner.nextLong();
            }
        }
        return id;
    }
}