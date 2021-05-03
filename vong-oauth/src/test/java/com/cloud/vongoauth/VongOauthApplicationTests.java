package com.cloud.vongoauth;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
class VongOauthApplicationTests {

    @Test
    void contextLoads() {
        System.out.println(UUID.nameUUIDFromBytes("vue".getBytes()).toString());
        System.out.println(UUID.nameUUIDFromBytes("admin".getBytes()).toString());
    }

}
