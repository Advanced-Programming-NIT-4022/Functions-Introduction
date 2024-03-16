package org.example;

public class Class01 {
    public String fullName(String firstName, String lastName) {
        String[] str1 = firstName.trim().split(" ");
        String[] str2 = lastName.trim().split(" ");
        int Number = 2 * (str1.length);
        int Number1 = 2 * (str2.length);
        int Number2 = 0;
        int Number3 = Number + Number1;
        String[] str3 = new String[Number3];
        String[] str4 = new String[Number3];
        StringBuilder str5 = new StringBuilder();
        String str6 = "";
        for (int i = 0; i < Number; i++) {
            str3[i] = str1[Number2].substring(0, 1).toUpperCase();
            i++;
            str3[i] = str1[Number2].substring(1).toLowerCase();
            Number2++;
        }
        Number2 = 0;
        for (int j = Number; j < Number3; j++) {

            str3[j] = str2[Number2].substring(0, 1).toUpperCase();
            j++;
            str3[j] = str2[Number2].substring(1).toLowerCase();
            Number2++;
        }
        for (int i = 0; i < Number3; i++) {
            str4[i] = str3[i];
            i++;
            str4[i] = str3[i] + " ";
        }

        for (String str : str4) {
            str5.append(str);
        }
        str6 = str5.toString();
        return str6;
    }

    public void phoneNumber(String number) {
        int Number = number.length();
        if (Number == 11) {
            System.out.println(number);
        } else if (Number == 10) {
            System.out.println("0" + number);
        } else {
            System.out.println("Wrong entry. try again");
        }
    }

    public String userID(String id) {
        int Number = id.length();
        if (Number < 13 && 4 < Number) {
            return id;
        } else {
            return "Please enter the number of digits in the specified range";
        }

    }

    public String getinterests(String[] active, int number) {
        String[] strings = new String[number];
        String result = "";
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < number; i++) {
            strings[i] = (i+1) + "-" + active[i] + "\n";
        }
        for (String str : strings) {
            string.append(str);
        }
        result = string.toString();
        return result;
    }

    public static String encrypt(String text, int s) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            if (Character.isUpperCase(text.charAt(i))) {
                char ch = (char) (((int) text.charAt(i) + s - 65) % 26 + 65);
                result += ch;
            } else {
                char ch = (char) (((int) text.charAt(i) + s - 97) % 26 + 97);
                result += ch;
            }
        }
        return result;
    }


    public String conversion1(String number) {
        char[] charArray = number.toCharArray();
        int number1 = charArray.length;
        StringBuilder str = new StringBuilder();
        String[] str1 = new String[number1];
        String result = "";
        for (int i = 0; i < number1; i++) {
            charArray[i] = '*';
            str1[i] = java.lang.String.valueOf(charArray[i]);
        }
        for (String str2 : str1) {
            str.append(str2);
        }
        result = str.toString();
        return result;
    }

    public String conversion2(String id) {
        char[] charArray = id.toCharArray();
        int number1 = charArray.length;
        StringBuilder str = new StringBuilder();
        String[] str1 = new String[number1];
        String result = "";
        for (int i = 0; i < number1; i++) {
            charArray[i] = '*';
            str1[i] = java.lang.String.valueOf(charArray[i]);
        }

        for (String str2 : str1) {
            str.append(str2);
        }
        result = str.toString();
        return result;
    }
}
