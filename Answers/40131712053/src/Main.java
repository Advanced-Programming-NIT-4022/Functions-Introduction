public class Main {
    public static void main(String[] args) {

    }

    public static String fullName(String firstName, String lastName){
        return firstName + " " + lastName;
    }

    public static String phoneNumber(String phone){
        boolean isAllDigits = true;
        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                isAllDigits = false;
                break;
            }
        }
        if (!isAllDigits) {
            return "wrong";
        }
        if(phone.length() !=10){
            return "wrong";
        }
        if(phone.charAt(0)!='9'){
            return "wrong";
        }
        return "0"+phone;
    }




}