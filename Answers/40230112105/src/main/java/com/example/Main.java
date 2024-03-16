public class Main {
    static String fullName(String fistName,String lastName) {
        fristName = fristName.toLowerCase();
        lastName = lastName.toLowerCase();
        fristName = fristName.substring(0,1).toUpperCase() + fristName.substring(1);
        lastName = lastName.substring(0,1).toUpperCase() + lastName.substring(1);
        return firstName + " " + lastName;

    }
}