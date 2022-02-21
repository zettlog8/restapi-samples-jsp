package com.treehub.restapi.samples.jsp.etc;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import com.treehub.restapi.samples.jsp.utils.DatetimeUtils;

class DatetimeUtilsTest {

    @Test
    void testGetNow() {
        String key = DatetimeUtils.getNow(null);
        if (StringUtils.isEmpty(key)) {
            fail("Not yet generated");
        } else {
            System.out.println("success : "+key);
        }
    }
}