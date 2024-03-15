package tamrin1_AP;

import java.util.Scanner;

public class CaesarEncoder {

    public static void main(String[] args) {

        System.out.print("enter sentence : ");
        Scanner input = new Scanner(System.in);
        String stringinput = input.nextLine();

        System.out.print("shift : ");
        Scanner inputshift = new Scanner(System.in);
        int shift = input.nextInt();


        char[] sentence = stringinput.toCharArray();
        int asci;

        for (int i=0 ; i<sentence.length ; i++)
        {

            asci = sentence[i];


            if ((asci+shift)>=65 && (asci+shift)<=90)
            {
                sentence[i] = (char)(asci+shift);
            }

            else if ((asci+shift)>90 && (asci+shift)<=122)
            {
                if (asci<=90)
                {
                    sentence[i]=(char) (64+((asci+shift)-90));
                }
                else if (asci>90)
                {
                    sentence[i]=(char)(asci+shift);
                }

            }

            else if ((asci+shift)>=97 && (asci+shift)<=122)
            {
                sentence[i]=(char) asci;
            }

            else if ((asci+shift)>122 )
            {
                sentence[i]=(char) (96+((asci+shift)-122));
            }


        }

        for (int i=0 ; i< sentence.length ; i++)
        {
            System.out.print(sentence[i]);
        }








    }
}
