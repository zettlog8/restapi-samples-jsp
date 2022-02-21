package com.treehub.restapi.samples.jsp.controllers;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

    @Service
    @RequiredArgsConstructor
    public class LoginDAO {
        
        private SqlSessionTemplate sql;
        
        public int loginCheck(LoginVO v, HttpServletRequest req) {
       
        System.out.println("다오리퀘스트임"+req.getParameter("USER_ID"));
        System.out.println("다오임"+v.getUSER_ID());
        
        return sql.getMapper(loginMapper.class).loginCheck(v);
    }
    
    }
    
    
    
    
