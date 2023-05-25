package com.bk.efruitshopssm.controller.main;

import com.bk.efruitshopssm.entity.CartItem;
import com.bk.efruitshopssm.entity.Order;
import com.bk.efruitshopssm.mapper.OrderMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController
{
    @Autowired
    OrderMapper orderMapper;
    @PostMapping("/buy")
    public boolean SubmitOrderHandler(@RequestBody CartData data)
    {
        List<CartItem> items = data.buyUnits;

        Order order = new Order();

        int sum = 0;
        for(CartItem item : items)
        {
            sum+=item.getCount()*item.getData().getFprice();
        }
        order.setTotalprice(sum);
        order.setAccount("unknow");
        order.setAddress("unknow");
        order.setTelephone("unknow");

        orderMapper.AddOrder(order);

        return  true;
    }

    @GetMapping("getallorder")
    public List<Order> GetAllOrderHandler()
    {
        return orderMapper.GetAllOrder();
    }
    @PostMapping("modorder")
    public boolean ModOrderHanlder(@RequestBody RecOrder rec)
    {
        int row = 0;
        switch (rec.getType())
        {
            case "ADD": row = orderMapper.AddOrder(rec.getData()); break;
            case "DEL": row = orderMapper.DelOrder(rec.getData().getOid()); break;
            case "MOD": row = orderMapper.ModOrder(rec.getData()); break;
        }

        return row!=0;
    }



}

@Data
class CartData
{
    List<CartItem> buyUnits;
}

@Data
class RecOrder
{
    private String type;
    private Order data;
}
