package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class MainClass {
    public static void main(String[] args) {
    }

    public static String fullName(String firstName, String lastName) {

        firstName = firstName.toLowerCase();
        String[] f = firstName.split("");
        f[0] = f[0].toUpperCase();
        firstName = "";
        for (int i = 0; i < f.length; i++) {
            firstName = firstName + f[i];
        }
        lastName = lastName.toLowerCase();
        String[] l = lastName.split("");
        l[0] = l[0].toUpperCase();
        lastName = "";
        for (int i = 0; i < l.length; i++) {
            lastName = lastName + l[i];
        }
        String fullName = firstName + " " + lastName;

        return fullName;
    }

    public static String phoneNumber(String phone) {
        String[] p = phone.split("");
        if (phone.length() < 10 || !p[0].equals("9")) {
            return "Wrong entry. Try again.";
        }
        phone = "0" + phone;
        return phone;
    }

    public static String userId(String id) {
        boolean status = false;
        if (id.length() >= 4 && id.length() <= 13) {
            status = true;
        }
        if (status) {
            return id;
        } else {

            Scanner input = new Scanner(System.in);
            while (id.length() < 4 || id.length() > 13) {
                System.out.print(" Invalid id,try again (between 4 to 13 digits): ");
                id = input.nextLine();
            }
            return id;
        }
    }

    public static String[] getInterests() {
        Scanner input = new Scanner(System.in);
        String[] interest = new String[10];
        System.out.println(" Enter your interests (0 for exit) and press [Enter] : ");
        String t = "";
        int k = 0;
        for (int i = 0; ; i++) {
            System.out.print(" interest[" + (i + 1) + "] : ");
            t = input.nextLine();
            if (t.equals("0")) {
                break;
            }
            interest[i] = t;
            k++;

        }
        String[] interest2 = new String[k];
        for (int i = 0; i < k; i++) {
            interest2[i] = interest[i];
        }

        return interest2;
    }

    public static String userFullInformation(String fullName, String phoneNumber, String userID, String[] interests) {
        String interest = "";
        for (int i = 0; i < interests.length; i++) {
            {
                interest = interest + (i + 1) + "." + interests[i] + "\n";
            }

        }
        String info = "Hello! My name is " + fullName + ". My ID is " + userID + ". Here are some of my interests:\n";
        info = info + interest;
        info = info + "\n" + "You can reach me via my phone number " + phoneNumber + ".";
        return info;
    }

    public static String informationEncoder(String information, int shift) {
        shift = shift % 26;
        char[] a = information.toCharArray();
        for (int i = 0; i < a.length; i++) {
            if (((int) a[i] >= 65 && (int) a[i] <= 90) || ((int) a[i] >= 97 && (int) a[i] <= 122)) {
                a[i] += shift;
                if (((int) a[i] - shift >= 65 && (int) a[i] - shift <= 90) && (int) a[i] > 90) {
                    a[i] -= 26;
                }
                if (((int) a[i] - shift >= 97 && (int) a[i] - shift <= 122) && (int) a[i] > 122) {
                    a[i] -= 26;
                }
            }
        }
        String resault = "";
        for (int i = 0; i < a.length; i++) {

            resault = resault + a[i];

        }
        return resault;


    }

    public static String informationDecoder(String information, int shift) {
        shift = shift % 26;
        shift = -shift;
        char[] a = information.toCharArray();
        for (int i = 0; i < a.length; i++) {
            if (((int) a[i] >= 65 && (int) a[i] <= 90) || ((int) a[i] >= 97 && (int) a[i] <= 122)) {
                a[i] += shift;
                if (((int) a[i] - shift >= 65 && (int) a[i] - shift <= 90) && (int) a[i] < 65) {
                    a[i] += 26;
                }
                if (((int) a[i] - shift >= 97 && (int) a[i] - shift <= 122) && (int) a[i] < 97) {
                    a[i] += 26;
                }
            }
        }
        String resault = "";
        for (int i = 0; i < a.length; i++) {

            resault = resault + a[i];

        }
        return resault;


    }


}
