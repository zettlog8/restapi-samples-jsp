package com.treehub.restapi.samples.jsp.etc;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import com.treehub.restapi.samples.jsp.utils.GenerateKeyUtils;

class GenerateKeyUtilsTest {

    @Test
    void testGetUuid4() {
        String key = GenerateKeyUtils.getUUID4();
        if (StringUtils.isEmpty(key)) {
            fail("Not yet generated");
        } else {
            System.out.println("success : "+key);
        }
    }
    
    @Test
    void testGetUuid1() {
        for(int i=0 ; i<1 ; i++ ) {
            String key = GenerateKeyUtils.getUUID1();
            if (StringUtils.isEmpty(key)) {
                fail("Not yet generated");
            } else {
                System.out.println("getUUID1 : "+key);
            }
        }
    }

    @Test
    void testGetOrderedUuid() {
        String key = GenerateKeyUtils.getOrderedUUID();
        if (StringUtils.isEmpty(key)) {
            fail("Not yet generated");
        } else {
            System.out.println("success : "+key);
        }
    }

    
    @Test
    void testGetGenloop() {
        
        for(int i=0 ; i < 47 ; i++) {
            String key = GenerateKeyUtils.getOrderedUUID();
            System.out.println(GenerateKeyUtils.getOrderedUUID());
        }
    }   
}