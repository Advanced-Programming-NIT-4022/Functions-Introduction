package tamrin2_AP;

import java.util.Scanner;

public class CaesarDecoder {

    public static void main(String[] args) {

        System.out.print("enter sentence : ");
        Scanner input = new Scanner(System.in);
        String stringinput = input.nextLine();

        System.out.print("shift : ");
        Scanner inputshift = new Scanner(System.in);
        int shift = input.nextInt();


        char[] sentence = stringinput.toCharArray();
        int asci;

        for (int i = 0; i < sentence.length; i++) {

            asci = sentence[i];


            if ((asci - shift) >= 65 && asci <= 90)
            {
                sentence[i] = (char) (asci - shift);
            }

            else if ((asci - shift) < 65 && asci <= 90)
            {
                if (asci==32)
                    continue;

                sentence[i] = (char) (91 - (65 - (asci - shift)));
            }

            else if ((asci - shift) >= 97 && (asci - shift) <= 122)
            {
                sentence[i] = (char) (asci - shift);
            }

            else if ((asci - shift) < 97 && asci >= 97)
            {
                sentence[i] = (char) ((123-(97 - (asci - shift))));
            }

        }

        for (int i = 0; i < sentence.length; i++)
        {
            System.out.print(sentence[i]);
        }
    }
}
