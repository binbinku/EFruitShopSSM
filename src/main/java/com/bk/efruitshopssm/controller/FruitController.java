package com.bk.efruitshopssm.controller;

import com.bk.efruitshopssm.entity.Fruit;
import com.bk.efruitshopssm.mapper.FruitMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FruitController
{

    @Autowired
    FruitMapper fruitMapper;

    @GetMapping("/getallfruit")
    public List<Fruit> GetAllFruitHandler()
    {
        return fruitMapper.GetAllFruit();
    }
}
