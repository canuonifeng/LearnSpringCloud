package com.cloud.entity;

import java.io.Serializable;

public class Role implements Serializable{
    private String name;
    private String code;

    public Role(String name, String code){
        setName(name);
        setCode(code);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
