package t2;

import java.util.Scanner;
import java.util.Vector;

/*to whoever is reading this
 i'm using vector here because i knew how to use it in cpp
 and vector is much better than normal String array
 so i did a little searching in google(no it wasn't little. it felt like i could die midway)
 and now here it is . vector in java :>*/

public class AllinOne
{
    @SuppressWarnings("unchecked")
    //it's just a recommendation of vscode
    /* i also searched to see what this thing do.
    it simply seems that java is much stricter than cpp
    and i keep comparing them because i don't know any other programming language 
    :> */
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
        Vector list =new Vector();
        int a=1;
        String interests;
        String simplified="";
        for (int i=0;i<10;i++)
        {
            System.out.println("write your word");
            interests = sc.nextLine();

            list.add(interests);
            simplified= String.join(", ", list);

            System.out.println("do you want to stop writing? (enter 0 to stop and 1 to continue)");
            a=scan.nextInt();
            if (a==0)
                break;
            else
                continue;
        }

         
        
        //printing process
        String str1=change(Firstname, Lastname);
        String information="Hello! My name is " + str1 + ". My ID is " + Id + ". Here are some of my interests: \n" + simplified + ".\n You can reach me via my phone number " + num + ".";
        menu(information);
        
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

        if ((Id.length()>=14)||(Id.length()<=3))
        {
            System.out.println("wrong student ID. please try again.");
            Id=seeifright();
        }
        return Id;
    }
    public static void menu(String information)
    {
        Scanner scans= new Scanner(System.in);
        System.out.println("****MENU****");
        System.out.println("1-Encoded" + "\n" + "2-Decoded" + "\n" + "3-Exit");
        int a=scans.nextInt();

        if (a==3)
            System.exit(0);

        if (a==1)
        {
            System.out.println("now enter the amount of shift you want");
            int shift=scans.nextInt();
            char[] newerstr=Encoder(information , shift);
            System.out.println(newerstr);
            menu(information);
        }
        else if (a==2)
        {
            Decoder(information);
            menu(information);
        }
    }

    public static char[] Encoder(String str , int shift)
    {
        String[] newstr=str.split(" ");
        char[] newerstr=new char[256];
        int t=0;
        for (int i=0;i<newstr.length;i++)
        {
            for (int j=0;j<newstr[i].length();j++)
            {
                int ascii=(int)newstr[i].charAt(j)+shift;
                if ((newstr[i].charAt(j)>='A')&&(newstr[i].charAt(j)<='z'))
                {
                    if ((ascii>122))
                    {
                        for (int k=1;k<=shift;k++)
                        {
                            int z=1;
                            int replacement=0;
                            if (((int)newstr[i].charAt(j)+k)>=122)
                            {
                                replacement=97+z;
                            }
                            if (z+k==shift)
                            {
                                newerstr[t]=(char)replacement;
                                t++;
                                break;
                            }
                            else
                                z++;
                        }
                    }
                    else if((ascii>90)&&((newstr[i].charAt(j)>='A')&&(newstr[i].charAt(j)<='Z')))
                    {
                        for (int k=1;k<=shift;k++)
                        {
                            int z=1;
                            int replacement=0;
                            if (((int)newstr[i].charAt(j)+k)>=90)
                            {
                                replacement=65+z;
                            }
                            if (z+k==shift)
                            {
                                newerstr[t]=(char)replacement;
                                t++;
                                break;
                            }
                            else
                                z++;
                        }
                    }
                    else
                    {
                        newerstr[t]=(char)ascii;
                        t++;
                    }
                }
                else
                {
                    newerstr[t]=newstr[i].charAt(j);
                    t++;
                }
            }
            newerstr[t]=' ';
            t++;
        }
        return newerstr;
    }

    public static void Decoder(String str)
    {
        System.out.println(str);
    }
}
