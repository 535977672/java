package test;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class main {

    public static void main(String arg[]) {
        String wen = "的附加费经济学家~！@#￥%……&*1234567890；‘。，、】【、{}|“：？》《";
        String pass = "123456789";
        
        String str = Enande.encrypt(wen, pass);
        System.out.println(str);
        
        
        System.out.println(Enande.decrypt(str, pass));
    }
}
