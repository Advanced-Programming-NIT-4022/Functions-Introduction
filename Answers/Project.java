import java.util.Scanner;

public class Project {
    public static void main(String[] args) {
        Scanner First = new Scanner(System.in);
        String first = First.nextLine();
        Scanner Last = new Scanner(System.in);
        String last = Last.nextLine();
        String FirstName = first.substring(0,1).toUpperCase() + first.substring(1).toLowerCase();
        String LastName = last.substring(0,1).toUpperCase() + last.substring(1).toLowerCase();

    }
}
