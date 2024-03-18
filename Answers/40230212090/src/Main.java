import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner strScanner = new Scanner(System.in);
        Scanner intScanner = new Scanner(System.in);


        //first Function
        System.out.println("please Enter the firstName : ");
        String firstName = strScanner.next();
        System.out.println("please Enter the lastName : ");
        String lastName = strScanner.next();
        System.out.println(fullName(firstName,lastName));


        //second Function

        System.out.println("please Enter the phoneNumber : ");
        String phoneNum = strScanner.next();
        System.out.println(phoneNumber(phoneNum));
        while (phoneNumber(phoneNum) == "Wrong entry. Try again.")
        {
            phoneNum = strScanner.next();
            System.out.println(phoneNumber(phoneNum));
        }


        //third Function
        System.out.println("please Enter the ID : ");
        String ID = strScanner.next();
        System.out.println(userId(ID));
        while (userId(ID).equals("another entry!"))
        {
            ID = strScanner.next();
            System.out.println(userId(ID));
        }


        //fourth Function

        ArrayList<String> interestsArray = new ArrayList<>();
        for (int i = 0 ; i < 10 ; i++)
        {
            System.out.format("please Enter the interest %d : ",i+1);
            System.out.println("(Note : if you press 0 it will be finish.)");
            interestsArray.add(strScanner.nextLine());
            if (Objects.equals(interestsArray.get(i), "0"))
            {
                break;
            }
        }
        //الان صفر رو هم قرار داده اخرش
        int interestsSize = interestsArray.size();
        // میگیم اخریش رو پاک کن
        interestsArray.remove(interestsSize-1);
        // حالا عنصری که پاک کردیم تعداد اعضا هم یدونه کم شد دیگه
        interestsSize = interestsArray.size();

        System.out.println(interestsArray);



        //fifth Function
        System.out.println("Please enter the full name : ");
        String fullName5 = strScanner.nextLine();
        System.out.println("Please enter the phone number : ");
        String phoneNumber5 = strScanner.nextLine();
        System.out.println("Please enter the User ID : ");
        String UserID5 = strScanner.nextLine();
        userFullInformation(fullName5,phoneNumber5,UserID5,interestsArray);


        //sixth Function
        System.out.println("please enter the sentence : ");
        String information = strScanner.nextLine();
        System.out.println("now enter the amount of shift you want : ");
        int shift = intScanner.nextInt();
        System.out.println(informationEncoder(information , shift));

        //seventh Function
        System.out.println("please enter the sentence : ");
        String information2 = strScanner.nextLine();
        System.out.println("now enter the amount of shift you want : ");
        int shift2 = intScanner.nextInt();
        System.out.println(informationDecoder(information2 , shift2));

    }
    public static String fullName(String firstName, String lastName)
    {
        char[] arrayFirstName = firstName.toCharArray();
        char[] arrayLastName = lastName.toCharArray();

        int lengthOfFirstName = arrayFirstName.length;
        int lengthOfLastName = arrayLastName.length;
        /*
        اگر بازه کد اسکی کاراکتر بین 65 تا 90 بود یعنی حروف بزرگ است و باید به حروف کوچک تبدیل شود پس بعلاوه 32 میکنیم
        اگر در بازه 97  تا 122 بود یعنی حروف کوچک است و باید به حروف بزرگ تبدیل شود پس منهای 32 میکنی
         */
        if ( arrayFirstName[0] >= 97 && arrayFirstName[0] <= 122 )
        {
            arrayFirstName[0] = (char) (arrayFirstName[0] - 32);
            //arrayFirstName[0] = Character.toUpperCase(arrayFirstName[0]);
        }

        if ( arrayLastName[0] >= 97 && arrayLastName[0] <= 122 )
        {
            //arrayLastName[0] = (char) (arrayLastName[0] - 32);
            arrayLastName[0] = Character.toUpperCase(arrayLastName[0]);
        }

        for (int i = 1 ; i < lengthOfFirstName ; i++)
        {
            if (arrayFirstName[i] >= 65 && arrayFirstName[i] <= 90)
            {
                arrayFirstName[i] = (char) (arrayFirstName[i] + 32);
            }
        }

        for (int i = 1 ; i < lengthOfLastName ; i++)
        {
            if (arrayLastName[i] >= 65 && arrayLastName[i] <= 90)
            {
                arrayLastName[i] = Character.toLowerCase(arrayLastName[i]);
                //arrayLastName[i] = (char) (arrayLastName[i] + 32);
            }
        }



        String finalWord = "";
        for (int j = 0; j < lengthOfFirstName; j++)
        {
            finalWord = finalWord + arrayFirstName[j];
        }

        if (lastName != " ")
        {
            finalWord = finalWord + " ";
        }

        if (lastName != " ")
        {
            for (int j = 0; j < lengthOfLastName; j++)
            {
                finalWord = finalWord + arrayLastName[j];

            }
        }

        return finalWord;
    }


    public static String phoneNumber(String phone)
    {
        int phoneLength = phone.length();

        if (!phone.startsWith("9") | phoneLength != 10) return "Wrong entry. Try again.";

        return "0" + phone;
    }


    public static String userId(String id)
    {
        int IDLength = id.length();
        if ( IDLength >= 4 && IDLength <= 13 )
        {
            return id;
        }
        else
        {
            return "another entry!";
        }
    }

    public static String[] getInterests(String interests)
    {
        // تو بدنه زده شد
        return null;
    }

    public static void userFullInformation(String fullName,String phoneNumber,String userID,ArrayList interests)
    {
        System.out.println("Hello! My name is " + fullName + ". My Id is " + phoneNumber + ". Here are some of my interests:");
        for (int i = 0 ; i < interests.size() ; i++)
        {
            System.out.println( (i+1) + "." + interests.get(i));
        }
        System.out.println("You can reach me via my phone number " + phoneNumber);
    }


    public static String informationEncoder(String information,int shift)
    {
        char[] informationArray = information.toCharArray();

        for (int i = 0 ; i < information.length() ; i++)
        {
            if (informationArray[i] >= 65 && informationArray[i] <= 90)
            {
                informationArray[i] = (char) (informationArray[i] + shift);

                if (informationArray[i] > 90)
                {
                    informationArray[i] = (char) (informationArray[i] - 26 );
                }
            }

            else if (informationArray[i] >= 97 && informationArray[i] <= 122)
            {
                informationArray[i] = (char) (informationArray[i] + shift);

                if (informationArray[i] > 122)
                {
                    informationArray[i] = (char) (informationArray[i] - 26 );
                }
            }
        }

        String finalInformation = "";

        for (int i = 0; i < information.length(); i++)
        {
            finalInformation = finalInformation + informationArray[i];
        }

        return finalInformation;

    }

    public static String informationDecoder(String information,int shift)
    {
        char[] informationArray = information.toCharArray();

        for (int i = 0 ; i < information.length() ; i++)
        {
            if (informationArray[i] >= 65 && informationArray[i] <= 90)
            {
                informationArray[i] = (char) (informationArray[i] - shift);

                if (informationArray[i] < 65)
                {
                    informationArray[i] = (char) (informationArray[i] + 26 );
                }
            }

            else if (informationArray[i] >= 97 && informationArray[i] <= 122)
            {
                informationArray[i] = (char) (informationArray[i] - shift);

                if (informationArray[i] < 97)
                {
                    informationArray[i] = (char) (informationArray[i] + 26 );
                }
            }
        }

        String finalInformation = "";

        for (int i = 0; i < information.length(); i++)
        {
            finalInformation = finalInformation + informationArray[i];
        }

        return finalInformation;

    }
}