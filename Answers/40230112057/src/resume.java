import java.util.Scanner;
public class resume {
    public static void  main(String[] args){
    }
    public String fullName(String firstName,String lastName){
        String First=firstName.toLowerCase();
        String Second=lastName.toLowerCase();
        char[] neww1=First.toCharArray();
        char[] neww2=Second.toCharArray();
        neww1[0]-=32;
        neww2[0]-=32;
        String akhari=new String(neww1);
        String akharii=new String(neww2);
        return akhari+" "+akharii;
    }
    public static String phoneNumber(String phone){
        Scanner input=new Scanner(System.in);
        while(phone.length()!=10 || phone.charAt(0)!='9'){
            System.out.println("Wrong entry. Try again.");
            phone=input.next();
        }
        return "0"+phone;
    }
    public static String userId(String id){
        Scanner input=new Scanner(System.in);
        while(4>=id.length() || 13<=id.length()){
            System.out.println("Wrong entry. Try again.");
            id=input.next();
        }
        return id;
    }
    public static String[] getInterests(interests obj){
        Scanner input=new Scanner(System.in);
        System.out.println("how many interests do you have?");
        int n=input.nextInt();
        String temp="";
        for(int i=0;i<n;i++){
            temp=input.next();
            if(temp.equals(""))
                break;
            obj.add_intrests(temp);
        }
        return obj.array();
    }
    public void userFullInformation(String fullName, String phoneNumber, String userId, interests obj){
        System.out.print(" Hello! My name is "+ fullName+". My ID is "+userId+".  Here are some of my interests:\n");
        for(int i=0;i<obj.size;i++){
            System.out.println((i+1)+". "+obj.index_return(i));
        }
        System.out.println("You can reach me via my phone number "+phoneNumber+".");
    }
    public static String informationEncoder(String information,int shift){
        char[] temp=information.toCharArray();
        for(int i=0;i<temp.length;i++){
            if(temp[i]>96 && temp[i]<123)
                temp[i]+=temp[i]+shift>122 ? shift-26 :shift;
            else if (temp[i]>64 && temp[i]<91){
                temp[i]+=temp[i]+shift>90 ? shift-26 : shift;
            }
        }
        String finall=new String(temp);
        return finall;
    }
    public static String informationDecoder(String information,int shift){
        char[] temp=information.toCharArray();
        for(int i=0;i<temp.length;i++){
            if(temp[i]>96 && temp[i]<123)
                temp[i]-=temp[i]-shift<97 ? shift-26 :shift;
            else if (temp[i]>64 && temp[i]<91){
                temp[i]-=temp[i]-shift<65 ? shift-26 : shift;
            }
        }
        String finall=new String(temp);
        return finall;
    }

}
