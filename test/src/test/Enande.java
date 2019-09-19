package test;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * java�ӽ���
 * @author Administrator
 *
 */
public class Enande {
    /**
     * @param sourceString
     * @param password
     * @return ����
     */
    public static String encrypt(String sourceString, String password) {
    	String source = Base64.getEncoder().encodeToString(sourceString.getBytes(StandardCharsets.UTF_8));
        char[] p = password.toCharArray(); // �ַ���ת�ַ�����
        int n = p.length; // ���볤��
        char[] c = source.toCharArray(); 
        int m = c.length; // �ַ�������
        for (int k = 0; k < m; k++) {
            int mima = c[k] + p[k % n]; // ����
            c[k] = (char) mima;
        }
        return Base64.getEncoder().encodeToString(new String(c).getBytes(StandardCharsets.UTF_8));
    }

    /**
     *
     * @param sourceString
     * @param password
     * @return ����
     */
    public static String decrypt(String sourceString, String password) {
    	String source = new String(Base64.getDecoder().decode(sourceString), StandardCharsets.UTF_8);
        char[] p = password.toCharArray(); // �ַ���ת�ַ�����
        int n = p.length; // ���볤��
        char[] c = source.toCharArray();
        int m = c.length; // �ַ�������
        for (int k = 0; k < m; k++) {
            int mima = c[k] - p[k % n]; // ����
            c[k] = (char) mima;
        }
        return new String(Base64.getDecoder().decode(new String(c)), StandardCharsets.UTF_8);
    }
}