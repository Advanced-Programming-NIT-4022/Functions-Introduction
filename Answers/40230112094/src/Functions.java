import java.util.*;
import java.lang.*;
public class Functions
{
    public static String fullName (String firstname, String lastname)
    {
        String FN = firstname.substring(0,1).toUpperCase() + firstname.substring(1).toLowerCase();
        String LN = lastname.substring(0,1).toUpperCase() + lastname.substring(1).toLowerCase();
        String fullname = FN + " " + LN;
        return fullname;
    }
    public static String phoneNumber(String phone)
    {
        int length = phone.length();
        if (length == 11 & phone.startsWith("0"))
        {
            return phone;
        }
        else if (length == 10 & phone.startsWith("9"))
        {
            phone = "0" + phone;
            return phone;
        }
        else
        {
            String error = "Wrong entry. Tty again.";
            return error;
        }
    }
    public static String userId(String id)
    {
        int length = id.length();
        if (length >= 4 & length <= 13)
        {
            return id;
        }
        else
        {
            return "Wrong entry!";
        }
    }
    public static String getInterests(String[] interests)
    {
        String showList = "{";
        for (int i=0 ; i<10 ; i++)
        {
            if (interests[i].equals("null"))
            {
                showList = showList + "X";
                showList = showList.replaceAll(", X","}");
                break;
            }
            showList = showList + "\"" + interests[i] + "\", ";
            if (i == 9)
            {
                showList = showList + "X";
                showList = showList.replaceAll(", X","}");
            }
        }
        return showList;
    }
    public static String userFullInformation(String fullName, String phoneNumber, String userId, String[] interests)
    {
        String[] splitedname = fullName.split(" ");
        String name = Functions.fullName(splitedname[0],splitedname[1]);
        for (int i=0 ; i<10 ; i++)
        {
            if (interests[i].equals("null")) break;
            interests[i] = interests[i].substring(0,1).toUpperCase() + interests[i].substring(1).toLowerCase();
        }
        String massage =  String.format("\nHello! My name is %s. My ID is %s. Here are some of my interests:", name, userId);
        for (int i=0 ; i < interests.length ; i++)
        {
            if (interests[i].equals("null")) break;
            massage = massage + "\n" + (i+1) + ". " + interests[i];
        }
        massage = massage + String.format("\nYou can reach me via my phone number %s.\n", Functions.phoneNumber(phoneNumber));
        return massage;
    }
    public static String informationEncoder(String information, int shift)
    {
        char[] LCA = new char[26];
        char[] UCA = new char[26];
        char[] Numbers = new char[10];
        LCA[0] = 'a';
        UCA[0] = 'A';
        Numbers[0] = '0';
        for (int i=1 ; i<26 ; i++)
        {
            LCA[i] = (char) (LCA[i-1] + 1);
            UCA[i] = (char) (UCA[i-1] + 1);
        }
        for (int i=1 ; i<10 ; i++) Numbers[i] = (char) (Numbers[i-1] + 1);
        String[] infoInChar = information.split(" ");
        int n = infoInChar.length;
        int numbShift = shift;
        if (shift > 9) numbShift %= 9;
        if (shift > 25) shift %= 25;
        for (int i=0 ; i<n ; i++)
        {
            char[] Trans = infoInChar[i].toCharArray();
            int m = Trans.length;
            infoInChar[i] = "";
            for (int j=0 ; j<m ; j++)
            {
                for (int k=0 ; k<26 ; k++)
                {
                    if (Trans[j] == LCA[k])
                    {
                        if (k+shift <= 25)
                        {
                            Trans[j] = LCA[k+shift];
                            break;
                        }
                        else
                        {
                            Trans[j] = LCA[k+shift-26];
                            break;
                        }
                    }
                    else if (Trans[j] == UCA[k])
                    {
                        if (k+shift <= 25)
                        {
                            Trans[j] = UCA[k+shift];
                            break;
                        }
                        else
                        {
                            Trans[j] = UCA[k+shift-26];
                            break;
                        }
                    }
                }
                for (int k=0 ; k<10 ; k++)
                {
                    if (Trans[j] == Numbers[k])
                    {
                        if (k+numbShift <= 9)
                        {
                            Trans[j] = Numbers[k+numbShift];
                            break;
                        }
                        else
                        {
                            Trans[j] = Numbers[k+numbShift-10];
                            break;
                        }
                    }
                }
                infoInChar[i] = infoInChar[i] + Trans[j];
            }
        }
        String resault = " ";
        for (int i=0 ; i<n ; i++)
        {
            resault = resault + infoInChar[i] + " ";
        }
        return resault.trim();
    }
    public static String informationDecoder(String information, int shift)
    {
        char[] LCA = new char[26];
        char[] UCA = new char[26];
        char[] Numbers = new char[10];
        LCA[0] = 'a';
        UCA[0] = 'A';
        Numbers[0] = '0';
        for (int i=1 ; i<26 ; i++)
        {
            LCA[i] = (char) (LCA[i-1] + 1);
            UCA[i] = (char) (UCA[i-1] + 1);
        }
        for (int i=1 ; i<10 ; i++) Numbers[i] = (char) (Numbers[i-1] + 1);;
        String[] infoInChar = information.split(" ");
        int n = infoInChar.length;
        int numbShift = shift;
        if (shift > 9) numbShift %= 9;
        if (shift > 25) shift %= 25;
        for (int i=0 ; i<n ; i++)
        {
            char[] Trans = infoInChar[i].toCharArray();
            int m = Trans.length;
            infoInChar[i] = "";
            for (int j=0 ; j<m ; j++)
            {
                for (int k=0 ; k<26 ; k++)
                {
                    if (LCA[k] == Trans[j])
                    {
                        if (shift-k > 0)
                        {
                            Trans[j] = LCA[26+k-shift];
                            break;
                        }
                        else
                        {
                            Trans[j] = LCA[k-shift];
                            break;
                        }
                    }
                    else if (Trans[j] == UCA[k])
                    {
                        if (shift-k > 0)
                        {
                            Trans[j] = UCA[26+k-shift];
                            break;
                        }
                        else
                        {
                            Trans[j] = UCA[k-shift];
                            break;
                        }
                    }
                }
                for (int k=0 ; k<10 ; k++)
                {
                    if (Trans[j] == Numbers[k])
                    {
                        if (numbShift-k > 0)
                        {
                            Trans[j] = Numbers[10+k-numbShift];
                            break;
                        }
                        else
                        {
                            Trans[j] = Numbers[k-numbShift];
                            break;
                        }
                    }
                }
                infoInChar[i] = infoInChar[i] + Trans[j];
            }
        }
        String resault = " ";
        for (int i=0 ; i<n ; i++)
        {
            resault = resault + infoInChar[i] + " ";
        }
        return resault.trim();
    }
}
