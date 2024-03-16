package org.example;

import java.util.Scanner;
public class Main {
    static String fullName(String fn,String ln) {
        String kn=fn+" "+ln;
        return kn;
    }
    static String phoneNumber(String shn) {
        if (shn.length()==10 && shn.charAt(0)=='9') {
            String eshn="0"+shn;
            return eshn;
        } else {
            System.out.print("Wrong entry. Try again: ");
            return null;
        }
    }
    static String userId(String id) {
        if (id.length()>=4 && id.length()<=13) {
            return id;
        } else {
            System.out.print("Wrong id! Try another: ");
            return null;
        }
    }
    static String[] getInterests(String alg,int r,String[] interests) {
        interests[r]=alg;
        return interests;
    }
    static void fullinformation(String n,String t,String stid,String[] algh,int ra) {
        System.out.println("hello! my name is "+n+". My ID is "+stid+". Here are some of my interests:");
        for (int i=0;i<ra;i++) {
            System.out.println(i+1+". "+algh[i]);
        }
        System.out.print("You can reach me via my phone number "+t);
    }
    static String encode(String s,int skh) {
        String result="";
        char[] h=s.toCharArray();
        for (int i=0;i<h.length;i++) {
            if (h[i] >= 'a' && h[i] <= 'z') {
                int posorg = h[i] - 'a';
                int posnew = (posorg + skh) % 26;
                char newch = (char) ('a' + posnew);
                result = result + newch;
            } else if (h[i] >= 'A' && h[i] <= 'Z') {
                int posorg = h[i] - 'A';
                int posnew = (posorg + skh) % 26;
                char newch = (char) ('A' + posnew);
                result = result + newch;
            } else {
                result = result + h[i];
            }
        }
        return result;
    }
    static String decode(String s,int mkh) {
        return encode(s,mkh);
    }
    public static void main(String[] args) {

        }
    }
}