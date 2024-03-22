import java.util.*;
import java.lang.*;
public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        //fullName
//        System.out.print("Enter your first name: ");
//        String firstN = input.next();
//        System.out.print("Enter your last name: ");
//        String lastN = input.next();
//        System.out.println(Functions.fullName(firstN,lastN));



        //phoneNumber
//        System.out.print("Enter your phone number: ");
//        String number = "";
//        do
//        {
//            number = input.next();
//            System.out.println(Functions.phoneNumber(number));
//        }
//        while (Functions.phoneNumber(number).equals("Wrong entry. Tty again."));



        //userId
//        System.out.print("Enter your user ID: ");
//        String userid = "";
//        do
//        {
//            userid = input.next();
//            System.out.println(Functions.userId(userid));
//        }
//        while (Functions.userId(userid).equals("Wrong entry!"));



        //getInterests
//        String[] str = new String[10];
//        System.out.println("Enter your interests: (Enter null if you are done)");
//        for (int i=0 ; i<10 ; i++)
//        {
//            System.out.print((i+1) + ". ");
//            str[i] = input.nextLine();
//            if (str[i].equals("null")) break;
//        }
//        System.out.println(Functions.getInterests(str));



        //userFullInformation
        System.out.print("Enter your full name: ");
        String Fname = input.nextLine();
        String[] Ilist = new String[10];
        System.out.println("Enter your interests: (Enter null if you are done)");
        for (int i=0 ; i<10 ; i++)
        {
            System.out.print((i+1) + ". ");
            Ilist[i] = input.nextLine();
            if (Ilist[i].equals("null")) break;
        }
        String Pnumb;
        do
        {
            System.out.print("Enter your phone number: ");
            Pnumb = input.next();
        }
        while (Functions.phoneNumber(Pnumb).equals("Wrong entry. Tty again."));
        String Uid;
        do
        {
            System.out.print("Enter your ID: ");
            Uid = input.next();
        }
        while (Functions.userId(Uid).equals("Wrong entry!"));
        String fullInfo = Functions.userFullInformation(Fname, Pnumb, Uid, Ilist);
        System.out.println(fullInfo);
        int choose, shift;
        do
        {
            System.out.print("\nChoose your operator: (Enter the number)\n(1)Encode\n(2)Decode\n(3)Exit\nOperator: ");
            choose = input.nextInt();
            if (choose < 3)
            {
                System.out.print("Enter shift number: ");
                shift = input.nextInt();
                if (choose == 1)
                {
                    fullInfo = Functions.informationEncoder(fullInfo, shift);
                    System.out.println(fullInfo);
                }
                else if (choose == 2)
                {
                    fullInfo = Functions.informationDecoder(fullInfo, shift);
                    System.out.println(fullInfo);
                }
            }
            else if (choose > 3)
            {
                System.out.println("Wrong entry! try again:");
            }
        }
        while (choose != 3);



        //informationEncoder
//        System.out.print("Enter the information: ");
//        String info = input.nextLine();
//        System.out.print("Enter shift number: ");
//        int numb = input.nextInt();
//        System.out.println(Functions.informationEncoder(info,numb));

//        Hello, my name is Aryanoor. I am learning Java.01234



        //informationDecoder
//        System.out.print("Enter the code: ");
//        String code = input.nextLine();
//        System.out.print("Enter the shift number: ");
//        int numb = input.nextInt();
//        System.out.println(Functions.informationDecoder(code,numb));

//        Fvb mvbuk Tl jvyyljasf. 8170
    }
}