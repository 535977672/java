package test;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class main {

    public static void main(String arg[]) {
        String wen = "°Ù¶È µØ\nggg\t31!@#$%^&*()£¡@#£¤%¡­¡­&*£¨£©¡·¡¶";
        String pass = "2nd7cju6";
        
        String str = Enande.encrypt(wen, pass);
        System.out.println(str);
        System.out.println(Enande.decrypt(str, pass));
        
        
        str = Enande.encrypt2(wen, pass);
        System.out.println(str);
        System.out.println(Enande.decrypt2(str, pass));
        
        
        str = Enande.encrypt3(wen, pass);
        System.out.println(str);
        System.out.println(Enande.decrypt3(str, pass));
        
    }
}
