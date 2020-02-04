import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Cipher {

    public static void main(String[] args) {
        String[] testEncrypt = {"terminal", "debugging", "control"};
        String[] testDecrypt = {"yjwrnsfq", "ijgzllnsl",  "htsywtq"};

        try {
            for (String s: testEncrypt) {
                System.out.println(encrypt(s, 5));
            }
            for (String s: testDecrypt) {
                System.out.println(decrypt(s, 5));
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static String encrypt(String text, int s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if(Character.isUpperCase(text.charAt(i))) {
                char ch = (char) ((int)(text.charAt(i) + s - 65) % 26 + 65);
                sb.append(ch);
            } else {
                char ch = (char)  (((int)text.charAt(i) + s - 97) % 26 + 97);
                sb.append(ch);
            }
        }

        return sb.toString();
    }

    public static String decrypt(String text, int s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if(Character.isUpperCase(text.charAt(i))) {
                char ch = (char) ((int)(text.charAt(i) - s - 65) % 26 + 65);
                sb.append(ch);
            } else {
                char ch = (char)  (((int)text.charAt(i) - s - 97) % 26 + 97);
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}
