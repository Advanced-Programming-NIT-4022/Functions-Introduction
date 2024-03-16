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
        System.out.println("You can reach me via my phone number "+t+".");
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
    static String decode(String u,int mkh) {
        return encode(u,26-(mkh%26));
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("enter your first name: ");
        String fname=sc.nextLine();
        System.out.print("enter your last name: ");
        String lname=sc.nextLine();
        String funame=fullName(fname,lname);
        System.out.print("enter your phone number: ");
        String telesho="";
        for (;;) {
            String sho=sc.nextLine();
            telesho=phoneNumber(sho);
            if (telesho==null) {
                continue;
            } else {
                break;
            }
        }
        System.out.print("enter your student id: ");
        String checkid="";
        for (;;) {
            String Id=sc.nextLine();
            checkid=userId(Id);
            if (checkid==null) {
                continue;
            } else {
                break;
            }
        }
        String[] alghe=new String[10];
        String[] j=new String[10];
        int p=0;
        System.out.println("enter your interests. if its enough,enter \"tamam\".");
        for (;;) {
            System.out.print("my interest is: ");
            String adat=sc.nextLine();
            if (adat.equals("tamam")==true) {
                break;
            }
            j=getInterests(adat,p,alghe);
            p++;
        }
        System.out.println("1.original");
        System.out.println("2.encode");
        System.out.println("3.decode");
        System.out.println("4.exit");
        System.out.print("choose the number of one option above for showing resume:");
        String gozine=sc.nextLine();
        switch(gozine) {
            case "1":
                fullinformation(funame, telesho, checkid, j, p);
                break;
            case "2":
                System.out.print("enter a shift number: ");
                int offset=sc.nextInt();
                String s1=encode("hello! my name is "+funame+". My ID is "+checkid+". Here are some of my interests:",offset);
                System.out.println(s1);
                for (int i=0;i<p;i++) {
                    int t=i+1;
                    System.out.println(encode(t+"."+alghe[i],offset));
                }
                String s2=encode("You can reach me via my phone number "+telesho+".",offset);
                System.out.println(s2);
                break;
            case "3":
                System.out.print("enter a shift number: ");
                int ofset=sc.nextInt();
                String ss1=decode("hello! my name is "+funame+". My ID is "+checkid+". Here are some of my interests:",ofset);
                System.out.println(ss1);
                for (int i=0;i<p;i++) {
                    int t=i+1;
                    System.out.println(decode(t+"."+alghe[i],ofset));
                }
                String ss2=decode("You can reach me via my phone number "+telesho+".",ofset);
                System.out.println(ss2);
                break;
            case "4":
                break;
            default:
                System.out.println("your option number is wrong!");
        }
    }
}