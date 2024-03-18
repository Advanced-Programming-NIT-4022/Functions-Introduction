package org.example;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class Functions {
    public String normalizingName(String firstName, String lastName) {
        String normalizedFirstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1).toLowerCase();
        //ابتدا حرف اول first name را با شروع اندیس از 0 و در نظر گرفتن پایان کلمه در اندیس 1 جدا کرده و به بزگ تبدیل میکنیم
// و بعد از ان از اندیس یک به بعد همه ی حروف را به کوچک تبدیل میکنیم

        String normalizedLastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1).toLowerCase();
//مانند بالایی
        return normalizedFirstName + " " + normalizedLastName;
    }

    //********************************************************************************************************************
    public String formatPhoneNumber(String phoneNumber) {
        if (checking(phoneNumber)) {
            return "0" + phoneNumber;
        } else {
            return "Wrong entry. Try again.";
        }
    }

    public boolean checking(String phone) {
        return phone.startsWith("9") && phone.length() == 10;
    }

    //**********************************************************************************************************************
    public String validateUserId(String userId) {

        if (userId.length() >= 4 && userId.length() <= 13) {
            // بررسی طول شناسه کاربری
            return userId;
        } else {
            return "Invalid user ID. Please enter a user ID between 4 and 13 digits.";
        }
    }

    //*************************************************************************************************************************
    public String[] getInterests(String[] userInterests) {
        String[] interests = new String[10];

        for (int i = 0; i < Math.min(userInterests.length, 10); i++) { // حلقه برای کپی کردن علاقه‌مندی‌های کاربر از آرایه ورودی به آرایه جدید
            interests[i] = userInterests[i];
        }

        return interests;
    }

    //*************************************************************************************************************************************
    public String userFullInformation(String fullName, String phoneNumber, String userID, String[] interests) {

        StringBuilder userInfo = new StringBuilder();

        userInfo.append("Full name: ").append(fullName).append("\n");


        userInfo.append("Phone number: ").append(phoneNumber).append("\n");


        userInfo.append("User ID: ").append(userID).append("\n");


        userInfo.append("Interests: ").append(Arrays.toString(interests)).append("\n");


        userInfo.append("\nOutput: Hello! My name is ").append(fullName).append(". My ID is ").append(userID)
                .append(". Here are some of my interests:\n");
        for (int i = 0; i < interests.length; i++) {
            userInfo.append(i + 1).append(". ").append(interests[i]).append("\n");
        }

        userInfo.append("\nYou can reach me via my phone number ").append(phoneNumber).append(".");


        return userInfo.toString();
    }

    //***************************************************************************************************
    public static String informationEncoder(String information, int shift) {
        StringBuilder encodedInformation = new StringBuilder();
        // برای جمع اوری اطلاعات رمز گذاری شده
        for (int i = 0; i < information.length(); i++) {// حلقه برای گردش از ابتدای رشته تا انتها
            char ch = information.charAt(i);

            if (Character.isLetter(ch)) {// بررسی اینکه آیا کاراکتر یک حرف است یا نه
                char base;
                if (ch>= 'A' && ch <= 'Z') { // تعیین پایه برای حروف بزرگ و کوچک است
                    base = 'A';
                } else {
                    base = 'a';
                }

                char encodedChar = (char) (((ch - base + shift) % 26) + base);
               encodedInformation.append(encodedChar);
            } else {
                encodedInformation.append(ch); // اگر کاراکتر غیر حروفی بود، بدون تغییر اضافه شود
            }
        }

        return encodedInformation.toString();
    }
    public static String informationDecoder(String encodedInformation, int shift) {
        return informationEncoder(encodedInformation, 26 - shift); // برای رمزگشایی از شیفت معکوس استفاده می‌شود
    }
}