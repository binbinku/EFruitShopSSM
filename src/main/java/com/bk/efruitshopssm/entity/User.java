package com.bk.efruitshopssm.entity;

import lombok.Data;

@Data
public class User
{
    private int id;

    private String account;

    private String password;

    private String gender;

    private String telephone;

    private String address;

    private String email;

    private String signtime;
}
