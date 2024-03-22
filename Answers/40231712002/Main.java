public class Main {
    public static String fullname(String firstname, String lastname) {
        String firstCharFirstname = firstname.substring(0, 1).toUpperCase();
        String firstCharLastname = lastname.substring(0, 1).toUpperCase();
        String otherfirstname = firstname.substring(1).toLowerCase();
        String otherlastname = lastname.substring(1).toLowerCase();

        return ("Name:" + firstCharFirstname + otherfirstname + firstCharLastname + otherlastname);

    }

    public static void main(String[] args) {

        System.out.println(fullname("kosar ", "mousavi"));
    }
}
