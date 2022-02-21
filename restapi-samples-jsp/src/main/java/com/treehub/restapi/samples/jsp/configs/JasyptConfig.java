package com.treehub.restapi.samples.jsp.configs;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JasyptConfig {

    @Bean("jasyptStringEncryptor")
    public StringEncryptor stringEncryptor() {
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword("01eb5a77ec97178dbac3f44e680a67da"); //암호화에 사용할 키 -> 중요
        config.setAlgorithm("PBEWithSHA256And256BitAES-CBC-BC"); //사용할 알고리즘
        config.setProvider(new BouncyCastleProvider());
        config.setKeyObtentionIterations("1000");
        config.setPoolSize("1");
        config.setProviderName("Dexconsulting");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setStringOutputType("base64");
        encryptor.setConfig(config);
        return encryptor;
    }
}