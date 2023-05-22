package com.bk.efruitshopssm.entity.Unit;

import lombok.Data;

@Data
public class LoginUnit
{
    private String account;
    private String password;
    private boolean rem;
}
