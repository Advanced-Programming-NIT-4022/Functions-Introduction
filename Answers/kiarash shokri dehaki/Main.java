package com.company;
import java.util.Scanner;
import java.security.PublicKey;

public class Main {



    public static String fullNa(String firstna, String lastna) {


        String f1 = firstna.substring(1);
        String l1 = lastna.substring(1);
        String fl = f1.toLowerCase();
        String ll = l1.toLowerCase();
        String f11 = firstna.substring(0, 1);
        String l11 = lastna.substring(0, 1);
        String f = f11.toUpperCase();
        String l = l11.toUpperCase();

        String fullNa = f + fl + " " + l + ll;

        return fullNa;

    }

    public static String phnNum(String phn) {
        Scanner pn = new Scanner(System.in);
        while ((phn.length() != 10) || (phn.charAt(0) != '9')) {
            System.out.println("wrong.pleas try again");
           phn = pn.nextLine();

        }
        String phnNum = "0" + phn;
        return phnNum;
    }

    public static String usId(String Id) {
        Scanner pn = new Scanner(System.in);
        while ((Id.length() <= 3) || (Id.length() >= 14)) {
            System.out.println("enter another ID");
            Id = pn.nextLine();
        }
        String usId = Id;
        return usId;
    }

    public static void getInterests(String[] K) {
        Scanner pn = new Scanner(System.in);
        for (int h = 0; h <= 9; h++) {
            String a = pn.nextLine();
            K[h] = a;
            if (K[h].isEmpty()) {
                break;
            }
        }
    }

    public static void showArray(String[] K) {
        System.out.print("{");
        for (int h = 0; h <= 9; h++) {
            if (K[h].isEmpty()) {
                break;
            }
            System.out.print("\"" + K[h] + "\",");
        }
        System.out.print("}\n");
    }

    public static void userFullInformation(String fullNa, String phnNum, String usId, String[] interests) {
        System.out.println("Hello, my name is" + fullNa + "my Id is" + usId + ".here are some of my :");
        for (int h = 0; h <= 9; h++) {
            if (interests[h].isEmpty()) {
                break;
            }
            System.out.println((h + 1) + ". " + interests[h]);
        }
        System.out.println("You can reach me via my phone numbe " + phnNum);
    }

    public static String infEncoder(String inf, int shift) {
        for (int y = 0; y < inf.length(); y++) {
            int k = inf.charAt(y);
            if (k >= 65 && k <= 90) {
                k = (((k - 65) + shift) % 26) + 65;
            } else if (k >= 97 && k <= 122) {
                k = (((k - 97) + shift) % 26) + 97;
            }
            char u = (char) k;
            inf = inf.substring(0, 1) + u + inf.substring(y + 1);
        }
        return inf;
    }

    public static String infDecoder(String encdd, int shift) {
        for (int h = 0; h < encdd.length(); h++) {
            int y = encdd.charAt(h);


            if (y >= 65 && y <= 90) {
                y = (((y - 65) + shift) % 26) + 65;
            } else if (y >= 97 && y <= 122) {
                y = (((y - 97) + shift) % 26) + 97;
            }

            char u = (char) y;
            encdd = encdd.substring(0, 1) + u + encdd.substring(y + 1);
        }
        return encdd;

    }

    public static void main (String[] args) {
        Scanner pn = new Scanner(System.in);

        String firstna = pn.nextLine();
        String lastna = pn.nextLine();
        String fullNa = fullNa(firstna, lastna);
        System.out.println(fullNa);
        String phn = pn.nextLine();
        String phnNum = phnNum(phn);
        System.out.println(phnNum);
        String Id = pn.nextLine();
        String usId =usId(Id);
        System.out.println(usId);
        String[] interests = new String[10];
        getInterests(interests);
        showArray(interests);
        userFullInformation(fullNa,  phnNum,usId,interests);
        String inf = pn.nextLine();
        int shift =+ pn.nextInt();
        String encdd = infEncoder(inf,shift);
        String decdd = infEncoder(encdd,shift);
        System.out.println(encdd);
        System.out.println(decdd);

    }
}










