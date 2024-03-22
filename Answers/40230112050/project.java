import java.util.Objects;
import java.util.Scanner;

public class project {
    public static void main(String[] args) {
        String First_name, Last_name, phonenumber = "null" , ID = "null" , intrest = "null";
        Scanner input = new Scanner(System.in);
        System.out.println("please enter your first_name: ");
        First_name = input.nextLine();
        System.out.println("please enter your last_name: ");
        Last_name = input.nextLine();
        String alfabet = "abcdefghijklmnopqrstuvwxyz";
        String[]alfabet1 = {"a" , "b" , "c" , "d", "e","f","g","h" , "i" , "j" , "k" ,"l" ,"m" , "n", "o" , "p" ,"q","r","s","t","u","v", "w" , "x", "y","z"};

        int i = 3;



        String testo ="Hello! My name is " + Fullname(First_name , Last_name) +". My ID is "+ ID(ID) +".here are some of my intrests:"+ intrest(intrest) + "\nyou can reach me via my phone number "+ final_phonenumber(phonenumber);
        //System.out.format("Hello! My name is %s. My ID is %s.here are some of my intrests:%s \nyou can reach me via my phone number %s " , Fullname(First_name , Last_name) , ID(ID) , intrest(intrest) , final_phonenumber(phonenumber));
        String test = testo.toLowerCase();
        String[]test1 = test.split("");
        System.out.println("\ndo you want to see the encoded result: ");
        String y = input.nextLine();
        if(Objects.equals(y, "no") || Objects.equals(y, "-"))
            System.out.println(testo);
        else if(Objects.equals(y, "yes") || Objects.equals(y, "+")  ) {
            for (int x = 0; x < test1.length; x++) {
                if (test1[x] == " ") continue;
                int f = alfabet.indexOf(test1[x]) + i;
                if (f > 26)
                    f %= 26;
                test1[x] = alfabet1[f];
                System.out.print(test1[x]);
            }
        }










    }

    public static String Fullname(String First_name, String last_name) {
        First_name = First_name.toLowerCase();
        last_name = last_name.toLowerCase();


        String[] list = First_name.split("");
        String[] list_2 = last_name.split("");
        list[0] = list[0].toUpperCase();
        list_2[0] = list_2[0].toUpperCase();
        for (int i = 1; i < list.length; i++) {
            list[0] += list[i];

        }

        for (int i = 1; i < list_2.length; i++) {
            list_2[0] += list_2[i];
        }

        String Fullname = list[0] + " " + list_2[0];

        return Fullname;
    }

    public static String final_phonenumber(String phonenumber) {
        Scanner input = new Scanner(System.in);
        System.out.println("please enter your phone_number: ");
        phonenumber = input.nextLine();
        String[] phone = phonenumber.split("");
        while (true) {
            if (phone.length <= 11 && phone.length >= 10 && (Objects.equals(phone[0], "9") || Objects.equals(phone[0], "0"))) {
                break;
            }
            System.out.println("WRONG! please try again!");
            phonenumber = input.nextLine();
            phone = phonenumber.split("");
        }
        if (phone[0] .equals("9")) {
            for(int i = 1 ; i < phone.length ; i++){
                phone[0] += phone[i];
            }
            phone[0] = "0" + phone[0];
        }
        else if(phone[0].equals("0")){
            for(int x = 1 ; x < phone.length ; x++){
                phone[0] += phone[x];
            }
        }
        return phone[0];
    }

    public static String ID(String ID) {
        Scanner input = new Scanner(System.in);
        System.out.println("please enter ur ID: ");
        ID = input.nextLine();

        String[] id = ID.split("");

        while(true){
            if(id.length < 13 && id.length > 4 ) {
                break;
            }
            System.out.println("Wrong please try again");
            ID = input.nextLine();
            id = ID.split("");
        }
        for(int i = 1 ; i < id.length ; i++){
            id[0] += id[i];
        }
        return id[0];
    }

    public static String intrest(String intrest) {
        String[] intrests_list = new String[10];
        String[]list = new String[10];
        list[0] = " ";

        System.out.println("please enter ur intrests: ");


        for(int i = 0 ; i < 10 ; i++){
            Scanner input = new Scanner(System.in);
            intrest = input.nextLine();

            intrests_list[i] = intrest;
            if(intrests_list[i] == "end")break;
        }


        for(int x = 1 ; x < 11 ; x++){

            list[0] += "\n" + x + "_" + intrests_list[x - 1];
        }
        return list[0];

    }

    }


