package com.bk.efruitshopssm.entity;

import lombok.Data;

@Data
public class CartItem {
    private Fruit data;

    private int count;
}
