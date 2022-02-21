package com.treehub.restapi.samples.jsp.etc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.jupiter.api.BeforeEach;

class EncrpytTest {

    public StandardPBEStringEncryptor pbeEnc = null;
    @BeforeEach
    void setUp() throws Exception {
        String key = "01eb5a77ec97178dbac3f44e680a67da";
        pbeEnc = new StandardPBEStringEncryptor();
        pbeEnc.setProvider(new BouncyCastleProvider());
        pbeEnc.setAlgorithm("PBEWithSHA256And256BitAES-CBC-BC");
                                                       
        pbeEnc.setPassword(key); //2번 설정의 암호화 키를 입력
        
    }

    @Test
    void test() {
        String enc = pbeEnc.encrypt("1234"); //암호화 할 내용
        System.out.println("enc = " + enc); //암호화 한 내용을 출력
        
        //테스트용 복호화
        String des = pbeEnc.decrypt(enc);
        System.out.println("des = " + des);
        //fail("Not yet implemented");
    }

}
