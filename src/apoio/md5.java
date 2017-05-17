/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apoio;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author christian
 */
public class md5 {

    public static String md5(String senha) {
        String sen = "";
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
        sen = hash.toString(16);
        return sen;
    }

//    public String md5(String string) {
//        try {
//            MessageDigest m = MessageDigest.getInstance("MD5");
//            m.update(string.getBytes(), 0, string.length());
//            System.out.println("MD5: " + new BigInteger(1, m.digest()).toString(16));
//            return new BigInteger(1, m.digest()).toString(16);
//        } catch (NoSuchAlgorithmException exception) {
//            System.out.println(exception);
//        }
//        return null;
//    }
}
