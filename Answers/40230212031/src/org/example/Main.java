package org.example;

import java.util.Arrays;
import java.util.Scanner;

import static org.example.Functions.informationDecoder;
import static org.example.Functions.informationEncoder;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter your last name: ");
        String lastName = scanner.nextLine();

        Functions functions = new Functions();
        String normalizedName = functions.normalizingName(firstName, lastName);

        System.out.println("Normalized name: " + normalizedName);
//////////////////////////////////////////////////////////////////////

        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine();

        while (!functions.checking(phone)) {
            //اگر شماره وارد شده توسط کاربر صحیح نبود
            System.out.println("Error . Try again.");
            System.out.print("Enter phone number: ");
            phone = scanner.nextLine();
            //دریافت مجدد شماره توسط کاربر
        }

        String formattedPhone = functions.formatPhoneNumber(phone);
        //در اینجا شماره قطغا درسته و به کاربر نمایش داده میشود
        System.out.println("Your phone number: " + formattedPhone);

        /////////////////////////////////////////////////////////////////////////
        String userId = "";
        while (true) {
            System.out.print("Enter user ID: ");
            userId = scanner.nextLine();
            String validatedUserId = functions.validateUserId(userId);
            if (!validatedUserId.startsWith("Invalid")) {
                System.out.println("Validated user ID: " + validatedUserId);
                break;
            } else {
                System.out.println(validatedUserId);
            }
        }
        ////////////////////////////////////////////////////////////////////////////


        scanner = new Scanner(System.in);

        System.out.println("Please enter your interests (maximum 10 interests, enter 'done' to finish):");

        String[] userInterests = new String[10];

        int i = 0;

        String input;
        // تعریف متغیر برای ذخیره ورودی کاربر

        while (i < userInterests.length) { // حلقه برای دریافت حداکثر 10 علاقه‌مندی از کاربر

            System.out.print("Input: ");

            input = scanner.nextLine().trim();
            //  حذف فاصله‌های اضافی از ابتدا و انتهای رشته

            if (input.equals("done")) { // اگر ورودی "done" باشد حلقه متوقف می‌شود
                break;
            }

            userInterests[i++] = input;
            // ذخیره ورودی کاربر در آرایه علاقه‌مندی‌ها و افزایش شمارنده
        }

        functions = new Functions();

        String[] interests = functions.getInterests(userInterests);
// فراخوانی متد getInterests با استفاده از آرایه علاقه‌مندی‌های کاربر و ذخیره نتیجه در آرایه جدید
        System.out.print("Output: ");

        for (String interest : interests) {
            // حلقه برای نمایش علاقه‌مندی‌های دریافت شده به کاربر

            if (interest != null) {    //اگر مقدار غیر null باشد نمایش آن
                System.out.print(interest + "-");
            }
        }
        ///////////////////////////////////////////////////////////////////////////////////////
        String information = normalizedName + ", " + formattedPhone + ", " + userId + ", " + Arrays.toString(interests);
        ////////////////////////////////////////////////////////////////////////////////////////////////
        String encodedInformation = null;
        while (true) {
            System.out.print("Do you want to encode, decode your information, or exit? (encode/decode/exit): ");
            String choice = scanner.nextLine();

            switch (choice.toLowerCase()) {
                case "encode":
                    System.out.print("Enter shift value: ");
                    int shiftEncode = scanner.nextInt();
                    scanner.nextLine();
                    // خالی کردن خط بعدی
                    encodedInformation = informationEncoder(information, shiftEncode);
                    System.out.println("Encoded information: " + encodedInformation);
                    break;
                case "decode":
                    if (encodedInformation == null) {
                        // اگر کاربر کد مورد نظرش را وارد نکرده عبارت زیر را چاپ می کند
                        System.out.println("No encoded information available. Please encode the information first.");
                        continue; // برگشت به ابتدای حلقه برای ورود مجدد دستور
                    }
                    System.out.print("Enter shift value: ");
                    int shiftDecode = scanner.nextInt();
                    scanner.nextLine();

                    String decodedInformation = informationDecoder(encodedInformation, shiftDecode);
                    System.out.println("Decoded information: " + decodedInformation);
                    break;
                case "exit":
                    System.out.println("Exiting program...");
                    return; // خروج از حلقه و پایان برنامه
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}