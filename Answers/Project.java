import java.util.Scanner;

public class Project {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("1.Setting Name");
        System.out.println("2.Setting Phone");
        System.out.println("3.Setting Id");
        System.out.println("4.Setting Interests");
        int in = input.nextInt();
        if(in == 1 ){
            Scanner First = new Scanner(System.in);
            System.out.println("Enter The FirstName : ");
            String first = First.nextLine();
            Scanner Last = new Scanner(System.in);
            System.out.println("Enter The LastName : ");
            String last = Last.nextLine();
            String FirstName = first.substring(0,1).toUpperCase() + first.substring(1).toLowerCase();
            String LastName = last.substring(0,1).toUpperCase() + last.substring(1).toLowerCase();
            String FullName = FirstName + " " + LastName;
            System.out.println("saving...");
            System.out.println();
            System.out.println("FullName Is : " + FullName);
        }

    }
}
