package com.treehub.restapi.samples.jsp.controllers;

import java.io.Reader;
import org.apache.ibatis.io.Resources; // ibatis 는 pom.xml에 주입해줘야한다.
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoyBean {
    private static SqlSessionFactory sessionFactory = null;
    static {
        try {
            if(sessionFactory == null) {
                Reader reader = Resources.getResourceAsReader("MyBatis 환경설정 파일");
                sessionFactory = new SqlSessionFactoryBuilder().build(reader); // 설정 정보 읽고 객체 생성
            }
        }catch(Exception e) {
            System.out.println("오류 내용: " + e);
        }
    }
    public static SqlSession getSqlSessionInstance() {
        return sessionFactory.openSession(); // SessionFactory에서 SqlSession 얻어오기
    }
}