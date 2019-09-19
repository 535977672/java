package test;

import java.nio.charset.StandardCharsets;
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
    	String source = Base64.getEncoder().encodeToString(sourceString.getBytes(StandardCharsets.UTF_8));
        char[] p = password.toCharArray(); // 字符串转字符数组
        int n = p.length; // 密码长度
        char[] c = source.toCharArray(); 
        int m = c.length; // 字符串长度
        for (int k = 0; k < m; k++) {
            int mima = c[k] + p[k % n]; // 加密
            c[k] = (char) mima;
        }
        return Base64.getEncoder().encodeToString(new String(c).getBytes(StandardCharsets.UTF_8));
    }

    /**
     *
     * @param sourceString
     * @param password
     * @return 明文
     */
    public static String decrypt(String sourceString, String password) {
    	String source = new String(Base64.getDecoder().decode(sourceString), StandardCharsets.UTF_8);
        char[] p = password.toCharArray(); // 字符串转字符数组
        int n = p.length; // 密码长度
        char[] c = source.toCharArray();
        int m = c.length; // 字符串长度
        for (int k = 0; k < m; k++) {
            int mima = c[k] - p[k % n]; // 解密
            c[k] = (char) mima;
        }
        return new String(Base64.getDecoder().decode(new String(c)), StandardCharsets.UTF_8);
    }
}