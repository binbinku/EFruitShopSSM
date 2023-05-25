package com.bk.efruitshopssm.mapper;

import com.bk.efruitshopssm.entity.FruitCategory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FruitCategoryMapper
{
    List<FruitCategory> GetAllFruitCategory();
    int AddCategory(String categoryName);
    int DeleteCategory(int fcno);

    int ModCategory(FruitCategory category);
}
