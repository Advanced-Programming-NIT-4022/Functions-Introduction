package org.example;

import java.util.Objects;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
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

        return interests.get_arr();
    }
    public static void main(String[] args) {

    }
}