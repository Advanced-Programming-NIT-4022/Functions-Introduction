public class Main {
    public static String fullname(String firstname, String lastname) {
        String firstCharFirstname = firstname.substring(0, 1).toUpperCase();
        String firstCharLastname = lastname.substring(0, 1).toUpperCase();
        String otherfirstname = firstname.substring(1).toLowerCase();
        String otherlastname = lastname.substring(1).toLowerCase();

        return ("Name:" + firstCharFirstname + otherfirstname + firstCharLastname + otherlastname);

    }
    public static String phonenumber(String number)
    {
        if(number.length()==10)
        {
            return ("0"+number);
        }
        else
        {
            return ("Wrong entry.Try again.");
        }
    }
    public static void main(String[] args) {

        System.out.println(fullname("kosar ", "mousavi"));
        System.out.println(phonenumber("9114867186"));
    }
}
