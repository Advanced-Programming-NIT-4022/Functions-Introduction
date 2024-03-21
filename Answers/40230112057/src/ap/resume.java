package ap;
import java.util.Scanner;
public class resume {
   public String name;
   public String id;
   public String phone;

    public void fullName(String firstName,String lastName){
        String First=firstName.toLowerCase();
        String Second=lastName.toLowerCase();
        char[] neww1=First.toCharArray();
        char[] neww2=Second.toCharArray();
        neww1[0]-=32;
        neww2[0]-=32;
        String akhari=new String(neww1);
        String akharii=new String(neww2);
        this.name=akhari+" "+akharii;
    }
    public void phoneNumber(String phone){
        Scanner input=new Scanner(System.in);
        if(phone.length()==11 && phone.charAt(0)=='0' && phone.charAt(1)=='9'){
            this.phone=phone;
            return;
        }

        while(phone.length()!=10 || phone.charAt(0)!='9'){
            System.out.println("Wrong entry. Try again.");
            phone=input.next();
            if(phone.length()==11 && phone.charAt(0)=='0' && phone.charAt(1)=='9'){
                this.phone=phone;
                return;
            }
        }
        this.phone="0"+phone;
    }
    public void userId(String id){
        Scanner input=new Scanner(System.in);
        while(4>=id.length() || 13<=id.length()){
            System.out.println("Wrong entry. Try again.");
            id=input.next();
        }

        this.id=id;
    }
    public static String[] getInterests(interests obj,int n){
        Scanner input=new Scanner(System.in);
        String temp;
        for(int i=0;i<n;i++){
            System.out.println("interest number"+(i+1)+": ");
            temp=input.next();
            if(temp.equals(""))
                break;
            obj.add_intrests(temp);
        }
        return obj.array();
    }
    public static String userFullInformation(String fullName, String phoneNumber, String userId, interests obj){
        String text1=" Hello! My name is "+ fullName+". My ID is "+userId+".  Here are some of my interests:\n";
        for(int i=0;i<obj.size;i++){
            String text2=(i+1)+". "+obj.index_return(i)+"\n";
            text1+=text2;
        }
       return text1+"\nYou can reach me via my phone number "+phoneNumber+".\n";
    }
    public static String informationEncoder(String information,int shift){
        char[] temp=information.toCharArray();
        for(int i=0;i<temp.length;i++){
            if(temp[i]>96 && temp[i]<123)
                temp[i]+=temp[i]+shift>122 ? shift-26 :shift;
            else if (temp[i]>64 && temp[i]<91)
                temp[i]+=temp[i]+shift>90 ? shift-26 : shift;
            else if(temp[i]>=48 && temp[i]<=57)
                temp[i]+=temp[i]+shift>57 ? shift-10 : shift;

        }
        return new String(temp);
    }
    public static String informationDecoder(String information,int shift){
        char[] temp=information.toCharArray();
        for(int i=0;i<temp.length;i++){
            if(temp[i]>96 && temp[i]<123)
                temp[i]-=temp[i]-shift<97 ? shift-26 :shift;
            else if (temp[i]>64 && temp[i]<91)
                temp[i]-=temp[i]-shift<65 ? shift-26 : shift;
            else if(temp[i]>=48 && temp[i]<=57)
                temp[i]-=temp[i]-shift<48 ? shift-10 : shift;
        }
        return new String(temp);
    }

}
