

public class Cipher {
    public static String Encoding(String Information , int shift){
       char[] Arrayofchar = Information.toCharArray();
       for(int i = 0 ; i < Arrayofchar.length ; i++){
           Arrayofchar[i] = (char) (Arrayofchar[i] + shift);
       }
       Information = new String(Arrayofchar);

       return Information;
    }
}
