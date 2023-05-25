package com.bk.efruitshopssm.entity;

import lombok.Data;

@Data
public class Order
{
    private int oid;
    private String account;
    private String address;
    private String telephone;
    private int totalprice;
}
