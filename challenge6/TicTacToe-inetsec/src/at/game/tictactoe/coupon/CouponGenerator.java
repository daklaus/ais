package at.game.tictactoe.coupon;

import android.content.Context;
import android.content.Intent;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CouponGenerator {
    Context context;

    public CouponGenerator(Context context) {
        this.context = context;
    }

    public void makeAndSendCoupon() {
        Intent intent = new Intent();
        intent.setAction("com.ultrasecret.MAGIC_ACTION");
        intent.addCategory("android.intent.category.DEFAULT");
        String str = "";
        String username = "inetsec028";
        for (int i = 0; i < username.length(); i++) {
            str = str + ((char) (((char) ((i * 90) + username.charAt(i))) % 128));
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes("UTF-8"));
            String secret = username.substring(username.length() - 3) + ":" + String.format("%064x", new BigInteger(1, messageDigest.digest()));
            intent.putExtra("com.ultrasecret.SECRET", secret);
            intent.setType("text/plain");
//            this.context.startActivity(intent);
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
