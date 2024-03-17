package t2;

import java.util.Scanner;

public class UserFullinformation
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);

        System.out.println("Please enter your name");
        String Firstname=sc.nextLine();
        String Lastname=sc.nextLine();

        System.out.println("Please enter your phone number");
        String num=search();

        System.out.println("Please enter your student ID");
        String Id=seeifright();

        System.out.println("Please write some of your interests");
        Scanner scan = new Scanner(System.in);
        String[] list = new String[10];
        int a=1;
        String interests;
        for (int i=0;i<10;i++)
        {
            System.out.println("write your word");
            interests = sc.nextLine();

            list[i]=interests;

            System.out.println("do you want to stop writing? (enter 0 to stop and 1 to continue)");
            a=scan.nextInt();
            if (a==0)
                break;
            else
                continue;
        }
        
        //printing process
        System.out.print("Hello! My name is " + change(Firstname, Lastname) + ".");
        System.out.print("My ID is " + Id + ". Here are some of my interests:");
        printit(list);
        System.out.println("\n You can reach me via my phone number " + num + ".");
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
    public static String search()
    {
        Scanner sc = new Scanner(System.in);
        String num=sc.nextLine();

        if ((num.length()==11)&&((num.charAt(0)=='0')&&(num.charAt(1)=='9')))
        {
            return num;
        }
        else if ((num.length()==10)&&(num.charAt(0)=='9'))
        {
            num=0+num;
        }
        else
        {
            System.out.println("Wrong entry. Try again.");
            num=search();
        }
        return num;
    }
    public static String seeifright()
    {
        Scanner sc = new Scanner(System.in);
        String Id=sc.nextLine();

        if ((Id.length()>=15)||(Id.length()<=2))
        {
            System.out.println("wrong student ID. please try again.");
            Id=seeifright();
        }
        return Id;
    }
    public static void printit(String[] list)
    {
        boolean checking=true;
        System.out.print("{");
        for (int i=0;i<10;i++)
        {
            if(checking!=true)
                System.out.print(",");
            if(list[i]==null)
            {
                System.out.print("}");
                break;
            }
            System.out.print("\""+list[i]+"\"");
            checking=false;
            if (list[i+1]==null)
                checking=true;
        }
    }
}
