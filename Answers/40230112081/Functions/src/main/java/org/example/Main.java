package org.example;

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Functions obj = new Functions();
        Vector v = new Vector();
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter Student Firstname and lastname :");
        System.out.println("Firstname :");
        String str;
        String str1;
        str = scn.nextLine();
        System.out.println("Lastname :");
        str1 = scn.nextLine();
        String name = obj.fullName(str, str1);
        String ID, p_number;
        while(true)
        {
            System.out.println("Enter Student phoneNumber");
            str = scn.nextLine();
            if(obj.phoneNumber(str) != "Wrong entry. Try again.")
            {
                p_number = obj.phoneNumber(str);
                break;
            }
            else{
                System.out.println("Try again");
            }
        }
        while(true)
        {
            System.out.println("Enter Student ID");
            str = scn.nextLine();
            if(obj.userID(str) != "Wrong entry. Try again.")
            {
                ID = obj.userID(str);
                break;
            }
            else{
                System.out.println("Try again");
            }
        }
        String[] arr = obj.getInterests(v);
        obj.userFullInformation(name, p_number, ID, arr);
        scn.close();
    }
}