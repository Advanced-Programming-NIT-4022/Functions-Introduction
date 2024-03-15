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

    public static void main(String[] args) {

    }
}