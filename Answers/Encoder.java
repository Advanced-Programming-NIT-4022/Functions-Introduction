public static String Caesar(String text, int key) {
    StringBuilder result = new StringBuilder();

    for (int i = 0; i < text.length(); i++) {
        char newchar = text.charAt(i);

        if (Character.isLetter(newchar)) {
            char endchar = (char) ((newchar - 'a' + key) % 26 + 'a');
            result.append(endchar);
        } else {
            result.append(newchar);
        }
    }

    return result.toString();
}
}
public class Encoder {
    public static void main(String[] args) {

    }
}
