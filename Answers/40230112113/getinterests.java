package t2;

import java.util.Scanner;

public class getinterests
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Scanner scan = new Scanner(System.in);
        String[] list = new String[10];
        int a=1;
        for (int i=0;i<10;i++)
        {
            System.out.println("write your word");
            String interests = sc.nextLine();

            list[i]=interests;

            System.out.println("do you want to stop writing? (enter 0 to stop and 1 to continue)");
            a=scan.nextInt();
            if (a==0)
                break;
            else
                continue;
        }
        boolean checking=true;
        System.out.print("{");
        for (int i=0;i<10;i++)
        {
            if(checking!=true)
                System.out.print(",");
            if(list[i]==null)
            {
                System.out.print("}");
                break;
            }
            System.out.print("\""+list[i]+"\"");
            checking=false;
            if (list[i+1]==null)
                checking=true;
        }
    }    
}
