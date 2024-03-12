package org.example;
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
}