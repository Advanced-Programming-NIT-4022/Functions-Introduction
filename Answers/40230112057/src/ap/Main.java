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
            System.out.println("****************\nmenu:\n1.add a resume\n2.show list of resumes\n3.exit\n****************");
            menu=input.nextInt();
            switch (menu) {
                case 1 -> {
                    obj[index] = new resume();
                    String firstname;
                    String lastname;
                    System.out.println("enter your first name:");
                    firstname = input.next();
                    System.out.println("enter your last name:");
                    lastname = input.next();
                    obj[index].fullName(firstname, lastname);
                    String phone;
                    System.out.println("enter phone number:");
                    phone = input.next();
                    obj[index].phoneNumber(phone);
                    System.out.println("enter user id:");
                    String id = input.next();
                    obj[index].userId(id);
                    System.out.println("how many interests do you have?");
                    int n = input.nextInt();
                    while(n>10){
                        System.out.println("the maximum number of interests is 10! enter another number: ");
                        n = input.nextInt();
                    }
                    ooj[index] = new interests(n);
                    resume.getInterests(ooj[index], n);
                    index++;
                }
                case 2 -> {
                    if(index==0){
                        System.out.println("there is no list");
                        break;
                    }
                    System.out.println("##################");
                    for (int i = 0; i < index; i++)
                        System.out.print((i + 1) + "." + "name:" + obj[i].name + "\n");
                    System.out.println("##################");
                    System.out.println("enter the number behind the name that you want to see the encrypted resume:");
                    int m = input.nextInt();
                    System.out.println("enter the shift for encryption:");
                    int shift = input.nextInt();
                    String text1 = resume.userFullInformation(obj[m - 1].name, obj[m - 1].phone, obj[m - 1].id, ooj[m - 1]);
                    String text2 = resume.informationEncoder(text1, shift);
                    System.out.println(text2);
                    System.out.println("do you want it decrypted?[y/n]");
                    String bul = input.next();
                    if (bul.equals("y") || bul.equals("Y")) {
                        String text3 = resume.informationDecoder(text2, shift);
                        System.out.println(text3);
                    }
                }
                case 3 -> done = false;
            }
        }
    }
}
