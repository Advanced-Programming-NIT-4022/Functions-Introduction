package t2;

import java.util.Scanner;

public class userid
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String Id=sc.nextLine();
        if ((Id.length()>13)&&(Id.length()<4))
        {
            System.out.println("wrong student ID. please try again");
            main(args);
        }
        else
        {
            System.out.println(Id);
        }
    }
}
