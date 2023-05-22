package com.bk.efruitshopssm.mapper;

import com.bk.efruitshopssm.entity.Fruit;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FruitMapper
{
    List<Fruit> GetAllFruit();
    List<Fruit> GetFruitsByCategory(int fcategory);
}
