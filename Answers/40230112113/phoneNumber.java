package t2;

import java.util.Scanner;

public class phoneNumber
{
    public static void main(String[] args)
    {
        search();
    }
    public static void search()
    {
        Scanner sc = new Scanner(System.in);
        String num=sc.nextLine();
        if ((num.length()==11)&&((num.charAt(0)=='0')&&(num.charAt(1)=='9')))
        {
            System.out.println(num);
        }
        else if ((num.length()==10)&&(num.charAt(0)=='9'))
        {
            num=0+num;
            System.out.println(num);
        }
        else
        {
            System.out.println("Wrong entry. Try again.");
            search();
        }
    }
}
