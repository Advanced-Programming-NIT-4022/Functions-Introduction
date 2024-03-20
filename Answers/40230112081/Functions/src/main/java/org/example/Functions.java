package org.example;
import java.util.Objects;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Functions {
    public String normalizeName(String name)
    {
        String out = "";
        char[] chars = name.toCharArray();
        if((int)chars[0] >= 97 && (int)chars[0] <= 122)
        {
            out += String.valueOf((char)((int)chars[0] - 32));
        }
        else
            out += String.valueOf(chars[0]);
        for(int i = 1;i < chars.length;i++)
        {
            if((int)chars[i] <= 90 && (int)chars[i] >= 65)
            {
                out += String.valueOf((char)((int)chars[i] + 32));
            }
            else
                out += String.valueOf(chars[i]);
        }
        return out;
    }
    public String fullName(String firstName, String lastName){
        firstName = normalizeName(firstName);
        lastName = normalizeName(lastName);
        return firstName + " " + lastName;
    }

    public boolean isAllNumber(String phone)
    {
        for(int i = 0;i < phone.length();i++){
            if((int)phone.charAt(i) < 48 || (int)phone.charAt(i) > 57)
                return false;
        }
        return true;
    }
    public String phoneNumber(String phone){
        if(phone.charAt(0) == '9' && phone.length() == 10 && isAllNumber(phone))
            return "0"+phone;
        return "Wrong entry. Try again.";
    }

    public String userID(String Id)
    {
        if(Id.length() >= 4 && Id.length() <= 13)
            return Id;
        else
            return "Wrong entry. Try again.";
    }

    public String[] getInterests(Vector interests) { // interests is empty array, passed by ref
        Scanner scn = new Scanner(System.in);
        String inp;
        String flag;
        while(interests.capacity() <= 10)
        {
            inp = scn.nextLine();
            interests.push(inp);
            System.out.println("Continue : [Y/N]");
            flag = scn.nextLine();
            if(Objects.equals(flag, "N") || Objects.equals(flag, "n"))
                break;
        }
        scn.close();
        return interests.get_arr();
    }

    public void userFullInformation(String fullName, String phoneNumber, String userId, String[] interests)
    {
        String out = "Hello! My name is "+fullName+". My ID is "+userId+". Here are some of my interests:";
        System.out.println(out);
        for(int i = 0;i < interests.length;i++)
        {
            System.out.print(i+1);
            System.out.print(". ");
            System.out.println(interests[i]);
        }
        System.out.print("\n");
        String end = "You can reach me via my phone number "+phoneNumber+".";
        System.out.println(end);
    }

    public  boolean isCapital(char chr)
    {
        return ((int)chr >= 65)&&((int)chr <= 90);
    }
    public  boolean isAlpha(char chr){
        return (((int)chr >= 65)&&((int)chr <= 90)) || (((int)chr >= 97)&&((int)chr <= 122));
    }
    public String cipher(char chr, int shift){
        int place;
        int fi;
        String out;
        if(isCapital(chr))
        {
            place = (int)chr - 64;
            fi = place + shift;
            if(fi < 0)
                fi = 26 + fi;
            out = String.valueOf((char)(((fi) % 26 + 64)));
        }
        else
        {
            place = (int)chr - 96;
            fi = place + shift;
            if(fi < 0)
                fi = 26 + fi;

            out = String.valueOf((char)(((fi) % 26 + 96)));
        }
        return out;
    }
    public String informationEncoder(String information,int shift)
    {
        String out = "";
        for(int i = 0;i < information.length();i++)
        {
            if(isAlpha(information.charAt(i)))
            {
                out += cipher(information.charAt(i), shift);
            }
            else
            {
                out += String.valueOf(information.charAt(i));
            }
        }
        return out;
    }
    public  String informationDecoder(String information, int shift)
    {
        String out = "";
        for(int i = 0;i < information.length();i++)
        {
            if(isAlpha(information.charAt(i)))
            {
                out += cipher(information.charAt(i), -1*shift);
            }
            else
            {
                out += String.valueOf(information.charAt(i));
            }
        }
        return out;
    }
}