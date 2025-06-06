package com.rudra356.cms.cms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CmsApplication {

    public static void main(String[] args) {
        System.setProperty("https.protocols", "TLSv1.2");
        SpringApplication.run(CmsApplication.class, args);
    }

}
