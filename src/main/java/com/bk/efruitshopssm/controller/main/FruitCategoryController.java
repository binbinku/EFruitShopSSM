package com.bk.efruitshopssm.controller.main;

import com.bk.efruitshopssm.entity.FruitCategory;
import com.bk.efruitshopssm.mapper.FruitCategoryMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FruitCategoryController
{
    @Autowired
    FruitCategoryMapper fruitCategoryMapper;
    @GetMapping("/getallcategory")
    public List<FruitCategory> GetAllCategoryHandler()
    {
        return fruitCategoryMapper.GetAllFruitCategory();
    }

    @PostMapping("/addcategory")
    public boolean AddCategoryHandler(@RequestBody FruitCategory category)
    {
        int row = fruitCategoryMapper.AddCategory(category.getCategoryName());
        return row!=0;
    }
    @PostMapping("/delcategory")
    public boolean DelCategoryHandler(@RequestBody FruitCategory category)
    {
        int row = fruitCategoryMapper.DeleteCategory(category.getFcno());
        return row!=0;
    }

    @PostMapping("/modcategory")
    public boolean ModCategoryHandler(@RequestBody FruitCategory category)
    {
        int row = fruitCategoryMapper.ModCategory(category);
        return row!=0;
    }

}
@Data
class RecAddCategory
{
    private FruitCategory category;
}
