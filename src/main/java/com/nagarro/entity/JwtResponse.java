package com.nagarro.entity;

import java.io.Serializable;

public class JwtResponse implements Serializable {
    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwttoken;
    private final String userName;
    private final String userType;

    public JwtResponse(String jwttoken, String userName, String userType) {
        this.jwttoken = jwttoken;
        this.userName = userName;
        this.userType = userType;
    }

    public String getToken() {
        return this.jwttoken;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getUserType() {
        return this.userType;
    }
}