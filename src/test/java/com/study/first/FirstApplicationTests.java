package com.study.first;

import com.study.first.controller.TestController;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

@SpringBootTest
class FirstApplicationTests {

    private static final String AES_PASSWORD_TOKEN = "1243453457976443";

    @Autowired
    private TestController testController;

    @Test
    void contextLoads() {
        String timestamp = Long.toString(System.currentTimeMillis());
        String token = encrypt("TEST");
        byte[] md5Pre = DigestUtils.md5(timestamp + token);
        String sign = byteToHexStringNoUpper(md5Pre);

        System.out.println("timestamp: " + timestamp);
        System.out.println("token: " + token);
        System.out.println("sign: " + sign);
    }

    public static String byteToHexStringNoUpper(byte[] b) {
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            String hex = Integer.toHexString(b[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    private static String encrypt(String str) {
        try {
            byte[] kb = AES_PASSWORD_TOKEN.getBytes("utf-8");
            SecretKeySpec sks = new SecretKeySpec(kb, "AES");
            //算法/模式/补码方式
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, sks);
            byte[] eb = cipher.doFinal(str.getBytes("utf-8"));
            return Base64.getEncoder().encodeToString(eb);
        } catch (Exception e) {
            return null;
        }
    }

    @Test
    public void controllerTest(){
        testController.testSomething();
    }
}
