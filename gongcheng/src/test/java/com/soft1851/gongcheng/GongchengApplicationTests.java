package com.soft1851.gongcheng;

import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GongchengApplicationTests {

    @Test
    void contextLoads() {
    }


    @Autowired
    StringEncryptor stringEncryptor;

    @Test
    public void encryptPwd() {
        String result = stringEncryptor.encrypt("root");
        System.out.println("==================");
        System.out.println(result);
        System.out.println("==================");
    }
}
