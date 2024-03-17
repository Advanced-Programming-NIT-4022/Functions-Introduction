package t2;

import java.util.Scanner;

public class FullName
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String Firstname=sc.nextLine();
        String Lastname=sc.nextLine();
        sc.close();
        ;
        System.out.println(change(Firstname, Lastname));
    }
    public static String change(String s1 , String s2)
    {
        s1=s1.toLowerCase();
        s2=s2.toLowerCase();

        s1 = s1.substring(0, 1).toUpperCase() + s1.substring(1);
        s2 = s2.substring(0, 1).toUpperCase() + s2.substring(1);

        String s3=s1+" "+s2;

        return s3;
    }
}
