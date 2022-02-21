/**
 * 
 */
package com.treehub.restapi.samples.jsp.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.treehub.restapi.samples.jsp.models.entities.SampleEntity;


/**
 * @author hyunho
 *
 */
@Mapper
public interface SampleMapper {
    public List<SampleEntity> sampleSelect(); 
}
