package ap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        int menu,index=0;

        resume[] obj;
        obj=new resume[100];
        interests[] ooj=new interests[100];
        boolean done=true;
        while(done){
            System.out.println("menu:\n1.add a resume\n2.show list of resumes\n3.exit");
            menu=input.nextInt();
            switch (menu){
                case 1:
                    obj[index]=new resume();
                    String firstname=new String();
                    String lastname=new String();
                    System.out.println("enter your first name:");
                    firstname=input.next();
                    System.out.println("enter your last name:");
                    lastname=input.next();
                    obj[index].fullName(firstname,lastname);
                    String phone=new String();
                    System.out.println("enter phone number:");
                    phone=input.next();
                    obj[index].phoneNumber(phone);
                    System.out.println("enter user id:");
                    String id=input.next();
                    obj[index].userId(id);
                    obj[index].isactive=1;
                    System.out.println("how many interests do you have?");
                    int n=input.nextInt();
                    ooj[index]=new interests(n);
                    resume.getInterests(ooj[index],n);
                    index++;
                    break;
                case 2:
                    for(int i=0;i<index;i++){
                        System.out.println((i+1)+".\n"+"name:"+obj[i].name+"\n\n");
                    }
                case 3:
                    done=false;
            }
        }
    }
}
