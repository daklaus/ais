package at.game.tictactoe;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main {

    public static void main(String[] args) {
        String str = "";

        String username = "inetsec028";

        if(args.length > 0)
            username = args[0];

        for (int i = 0; i < username.length(); i++) {
            str = str + ((char) (((char) ((i * 90) + username.charAt(i))) % 128));
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes("UTF-8"));
            String secret = username.substring(username.length() - 3) + ":" + String.format("%064x", new BigInteger(1, messageDigest.digest()));
            System.out.println(String.format("The secret is: %s", secret));
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
