public class Functions {


    // fullName Function

    public static void fullName(String firstName , String lastName){

        firstName = firstName.toLowerCase();
        String[] firstname = firstName.split("");
        firstname[0] = firstname[0].toUpperCase();
        String Firstname = String.join("" , firstname);

        lastName = lastName.toLowerCase();
        String[] lastname = lastName.split("");
        lastname[0] = lastname[0].toUpperCase();
        String Lastname = String.join("" , lastname);

        System.out.println("FullName : " + Firstname + " " + Lastname);

    }

    public static void main(String[] args) {
        fullName("sadra" , "ahmadi");
    }
}