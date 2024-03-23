import java.util.ArrayList;
import java.util.regex.Pattern;

public class Functions {


    public String fullName(String fName, String lName) {
        String resultFName = fName.substring(0, 1).toUpperCase() + fName.substring(1).toLowerCase();
        String resultLName = lName.substring(0, 1).toUpperCase() + lName.substring(1).toLowerCase();


        return resultFName + ' ' + resultLName;
    }

    public String phoneNumber(String phone) {
        char characterAtIndex0 = phone.charAt(0);
        int phoneSize = phone.length();
        if (characterAtIndex0 == '9' && phoneSize == 10 && phone.matches("[0-9]+")) {
            return '0' + phone;
        } else {
            return "Wrong entry. Try again.";
        }
    }

    public String userId(String id) {
        int idSize = id.length();

        if (idSize >= 4 && idSize <= 13 && id.matches("[0-9]+")) {
            return id;
        } else {
            return "Wrong entry. Try again.";
        }

    }

    public StringBuilder getInterests(ArrayList<String> interests) {

        StringBuilder result4 = new StringBuilder();
        result4.append('{');
        for (int i = 0; i < interests.size(); i++) {
            result4.append('"').append(interests.get(i)).append('"');
            if (i != interests.size() - 1) {
                result4.append(", ");
            }
        }
        result4.append('}');
        return result4;
    }

    public StringBuilder userFullInformation(String fullName, String phoneNumber, String userID, ArrayList<String> interests) {
        StringBuilder userFullInformation =new StringBuilder();
        userFullInformation.append(" Hello! My name is " + fullName + ". My ID is " + userID + ". Here are some of my interests:\n");
        for (int i = 0; i < interests.size(); i++) {
            userFullInformation.append(i + 1 + ". " + interests.get(i) + "\n");
        }
        userFullInformation.append("You can reach me via my phone number " + phoneNumber + ".");
        return userFullInformation;
    }

    public String informationEncoder(String information, int shift) {
        StringBuilder newString = new StringBuilder();
        for (int i = 0; i < information.length(); i++) {
            if (information.charAt(i) > 96 && information.charAt(i) < 123) {    //اگر حروف کوچک بود
                if (information.charAt(i) + shift < 123) {
                    char newChar = (char) (information.charAt(i) + shift);
                    newString.append(newChar);
                } else {
                    char newChar = (char) (96 + ((information.charAt(i) + shift) - 122));
                    newString.append(newChar);
                }
            } else if (information.charAt(i) > 64 && information.charAt(i) < 91) {
                if (information.charAt(i) + shift < 91) {
                    char newChar = (char) (information.charAt(i) + shift);
                    newString.append(newChar);
                } else {
                    char newChar = (char) (64 + ((information.charAt(i) + shift) - 90));
                    newString.append(newChar);
                }
            } else {
                newString.append(information.charAt(i));
            }

        }
        return newString.toString();
    }


    public String informationDecoder(String information , int shift){
        StringBuilder newString = new StringBuilder();
        for (int i = 0; i < information.length(); i++) {
            if (information.charAt(i) > 96 && information.charAt(i) < 123) {    //اگر حروف کوچک بود
                if (information.charAt(i) - shift >96) {
                    char newChar = (char) (information.charAt(i) - shift);
                    newString.append(newChar);
                } else {
                    char newChar = (char) (123 + ((information.charAt(i) - shift) - 97));
                    newString.append(newChar);
                }
            } else if (information.charAt(i) > 64 && information.charAt(i) < 91) {
                if (information.charAt(i) - shift >64) {
                    char newChar = (char) (information.charAt(i) - shift);
                    newString.append(newChar);
                } else {
                    char newChar = (char) (91 + ((information.charAt(i) - shift) - 65));
                    newString.append(newChar);
                }
            } else {
                newString.append(information.charAt(i));
            }

        }
        return newString.toString();
    }
    }

