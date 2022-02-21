/**
 * 
 */
package com.treehub.restapi.samples.jsp.mybatis.mapper;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.treehub.restapi.samples.jsp.models.entities.SampleEntity;

import lombok.extern.slf4j.Slf4j;

/**
 * @author hyunho
 *
 */
@ExtendWith(SpringExtension.class)
@MybatisTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Slf4j
class SampleMapperTest {

    @Autowired
    public SampleMapper smMapper;
    
    @Test
    void test() {
        try {
            log.info("== method start ==");
            Optional<List<SampleEntity>> result = Optional.ofNullable(smMapper.sampleSelect());
            if(result.isPresent()) {
                log.info("data is exist");
                List<SampleEntity> list = result.get();
                for(SampleEntity samEn : list) {
                    log.info(ToStringBuilder.reflectionToString(samEn, ToStringStyle.JSON_STYLE));
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            fail("Excpetion : "+e.getMessage());
        } finally {
            log.info("== method end ==");
        }
        
        
    }

}
