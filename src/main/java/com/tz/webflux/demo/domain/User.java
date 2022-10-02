package com.tz.webflux.demo.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {

    private static final long serialVersionUID = -866669716491761596L;

    private String id;
    private String username;
    private String phone;
    private String email;
    private String name;
    private Date birthday;
}
