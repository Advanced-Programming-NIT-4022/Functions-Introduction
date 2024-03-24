import java.util.Scanner;

import static java.lang.String.valueOf;

public class Main
{
    public static void main(String[] args) {
        Scanner stringInput = new Scanner(System.in);
        }
//        public static String fullName(String firstName,String lastName)
//        {
//            Scanner input = new Scanner(System.in);
//            firstName = input.next();
//            lastName = input.next();
//            firstName = firstName.toLowerCase();
//            lastName = lastName.toLowerCase();
//            String fullname = "";
//            char firsta[] = firstName.toCharArray();
//            char lasta[] = lastName.toCharArray();
//            firsta[0] -= 32;
//            lasta[0] -= 32;
//            int n1 = firsta.length;
//            int n2 = lasta.length;
//            char fulla[] = new char[n1 + n2 + 1];
//            for (int i = 0; i < n1; i++) {
//                fulla[i] = firsta[i];
//            }
//            fulla[n1] = ' ';
//            for (int i = 0; i < n2; i++) {
//                fulla[i + n1 + 1] = lasta[i];
//            }
//            fullname=valueOf(fulla);
//            return fullname;
//        }


//    public static String phoneNumber(String phone)
//    {
//        Scanner input = new Scanner(System.in);
//        phone = input.next();
//        char[] phoneArray = phone.toCharArray();
//        String  newPhone="0";
//        int n=phone.length();
//        while (n!=10 || phoneArray[0]!='9') {
//            System.out.println("Worng entry. Try again");
//            phone = input.next();
//            n=phone.length();
//            phoneArray = phone.toCharArray();
//        }
//        newPhone+=phone;
//        return newPhone;
//    }

//    public static String userId(String id)
//    {
//        Scanner input = new Scanner(System.in);
//        int n=0;
//        while (n>13 || n<4) {
//            id = input.next();
//            n=id.length();
//            if(id.length()>13 || id.length()<4) {
//                System.out.println("Worng ID. Try again");
//            }
//        }
//        return id;
//    }

//    public static String getInterests(String interest)
//    {
//        Scanner input = new Scanner(System.in);
//        int i=0;
//        interest="";
//        String x="{";
//        while(i<10){
//            interest = input.nextLine();
//            if(interest.length()!=0){
//            x= x+ "\"" + interest+ "\",";
//            }else{
//                break;
//            }
//            i++;
//        }
//        if(x.length()!=1) {
//            x = x.substring(0, x.length() - 1) + "}";
//        }else{
//            x="{}";
//        }
//            return x;
//    }

    public static String userFullInformation(String fullName, String phoneNumber, String userID,String interests)

    {
        Scanner input = new Scanner(System.in);
        fullName = input.nextLine().trim();
        phoneNumber = input.nextLine();
        userID = input.nextLine();
        interests = input.nextLine();
        interests=interests.replace("}","").replace("{","").replace(" ","").replace("\"","");
        String[] interestsArray = interests.split(",");
        String output="Hello! My name is " + fullName + ". My ID is "+ userID + ". Here are some of my interests:";
        for(int i=0;i<interestsArray.length;i++){
            output=output + "\n" + (i+1) +"." +interestsArray[i];
        }
        output=output+"\n\n"+"You can reach me via my phone number "+phoneNumber+".";
        return output;
    }

//    public static String informationEncoder(String information, String shift)
//    {
//        Scanner input = new Scanner(System.in);
//        information = input.nextLine();
//        shift = input.nextLine();
//        int x=Integer.parseInt(shift);
//        char[] info= information.toCharArray();
//        int n=info.length;
//        for(int i=0 ; i<n ; i++){
//            if((info[i]<91 && info[i]>64 && (info[i]+x)>90)||(info[i]<123 && info[i]>96 && (info[i]+x)>122)){
//                info[i]+=x;
//                info[i]-=26;
//            }else if((info[i]<91 && info[i]>64)||(info[i]<123 && info[i]>96)){
//                info[i]+=x;
//            }
//        }
//        String y= new String(info);
//        return y;
//    }

//    public static String informationDecoder(String information, String shift)
//    {
//        Scanner input = new Scanner(System.in);
//        information = input.nextLine();
//        shift = input.nextLine();
//        int x=Integer.parseInt(shift);
//        char[] info= information.toCharArray();
//        int n=info.length;
//        for(int i=0 ; i<n ; i++){
//            if((info[i]<91 && info[i]>64 && (info[i]-x)<65)||(info[i]<123 && info[i]>96 && (info[i]-x)<97)){
//                info[i]-=x;
//                info[i]+=26;
//            }else if((info[i]<91 && info[i]>64)||(info[i]<123 && info[i]>96)){
//                info[i]-=x;
//            }
//        }
//        String y= new String(info);
//        return y;
//    }

}