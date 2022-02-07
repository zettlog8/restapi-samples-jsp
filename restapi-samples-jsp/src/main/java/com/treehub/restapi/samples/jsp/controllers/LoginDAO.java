package com.treehub.restapi.samples.jsp.controllers;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class LoginDAO {

    @Autowired
    SqlSession sql;
    
    public int loginCheck(LoginVO vo) {
        
        return sql.getMapper(loginMapper.class).loginCheck(vo);
    }
    
    
    
    
}
