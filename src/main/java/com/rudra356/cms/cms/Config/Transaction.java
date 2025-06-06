package com.rudra356.cms.cms.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class Transaction {
    @Bean
    public PlatformTransactionManager manager(MongoDatabaseFactory Db) {
        return new MongoTransactionManager(Db);
    }
}
