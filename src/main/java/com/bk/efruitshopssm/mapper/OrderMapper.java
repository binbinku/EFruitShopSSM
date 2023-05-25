package com.bk.efruitshopssm.mapper;

import com.bk.efruitshopssm.entity.Fruit;
import com.bk.efruitshopssm.entity.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {

    int AddOrder(Order order);

    List<Order> GetAllOrder();

    int DelOrder(int oid);
    int ModOrder(Order order);
}
