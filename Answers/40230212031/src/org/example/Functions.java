package org.example;

    public class Functions {
        public String normalizingName (String firstName, String lastName) {
            String normalizedFirstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1).toLowerCase();
            //ابتدا حرف اول first name را با شروع اندیس از 0 و در نظر گرفتن پایان کلمه در اندیس 1 جدا کرده و به بزگ تبدیل میکنیم
// و بعد از ان از اندیس یک به بعد همه ی حروف را به کوچک تبدیل میکنیم

            String normalizedLastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1).toLowerCase();
//مانند بالایی
            return normalizedFirstName +" "+normalizedLastName;
        }

}


