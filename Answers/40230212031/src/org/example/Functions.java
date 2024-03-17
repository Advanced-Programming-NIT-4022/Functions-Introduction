package org.example;

import org.jetbrains.annotations.NotNull;

public class Functions {
        public String normalizingName (String firstName, String lastName) {
            String normalizedFirstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1).toLowerCase();
            //ابتدا حرف اول first name را با شروع اندیس از 0 و در نظر گرفتن پایان کلمه در اندیس 1 جدا کرده و به بزگ تبدیل میکنیم
// و بعد از ان از اندیس یک به بعد همه ی حروف را به کوچک تبدیل میکنیم

            String normalizedLastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1).toLowerCase();
//مانند بالایی
            return normalizedFirstName +" "+normalizedLastName;
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
}



