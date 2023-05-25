package com.bk.efruitshopssm.entity.Unit;

import lombok.Data;

@Data
public class LoginBackUnit
{
    private boolean loginSucceeded;
    private String redirectUrl;
}
