package test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * java加解密
 * @author Administrator
 *
 */
public class Enande {
    
    /**
     * @param sourceString
     * @param password
     * @return 密文
     */
    public static String encrypt(String sourceString, String password) {
    	char[] p = password.toCharArray(); // 字符串转字符数组
        int n = p.length; // 密码长度
        char[] c = sourceString.toCharArray(); 
        int m = c.length; // 字符串长度
        for (int k = 0; k < m; k++) {
            int mima = c[k] + p[k % n]; // 加密
            c[k] = (char) mima;
        }
        return new String(c);
    }

    /**
     *
     * @param sourceString
     * @param password
     * @return 明文
     */
    public static String decrypt(String sourceString, String password) {
    	char[] p = password.toCharArray(); // 字符串转字符数组
        int n = p.length; // 密码长度
        char[] c = sourceString.toCharArray();
        int m = c.length; // 字符串长度
        for (int k = 0; k < m; k++) {
            int mima = c[k] - p[k % n]; // 解密
            c[k] = (char) mima;
        }
        return new String(c);
    }

    /**
     * @param sourceString
     * @param password
     * @return 密文
     */
    public static String encrypt2(String sourceString, String password) {
    	return Base64.getEncoder().encodeToString(Enande.encrypt(sourceString, password).replaceAll("\\s", "").getBytes(StandardCharsets.UTF_8));
    }
    
    public static String md5Encode(String content) {
        byte[] hash;
        try {
            hash = MessageDigest.getInstance("MD5").digest(content.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("NoSuchAlgorithmException",e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UnsupportedEncodingException", e);
        }
        //对生成的16字节数组进行补零操作
        StringBuilder hex = new StringBuilder(hash.length * 2);
        for (byte b : hash) {
            if ((b & 0xFF) < 0x10){
                hex.append("0");
            }
            hex.append(Integer.toHexString(b & 0xFF));
        }
        return hex.toString();
    }
}