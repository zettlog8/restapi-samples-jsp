package com.treehub.restapi.samples.jsp.controllers;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginVO {

    private String USER_ID;
    private String USER_PASSWORD;
    
    
}
