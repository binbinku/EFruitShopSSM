package com.bk.efruitshopssm.controller.main;

import com.bk.efruitshopssm.entity.Fruit;
import com.bk.efruitshopssm.entity.FruitCategory;
import com.bk.efruitshopssm.mapper.FruitCategoryMapper;
import com.bk.efruitshopssm.mapper.FruitMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class ShopController {

    @Autowired
    FruitCategoryMapper fruitCategoryMapper;

    @Autowired
    FruitMapper fruitMapper;

    @GetMapping("/shop")
    public ShopDisplayUnit ShopHandler()
    {
        ShopDisplayUnit sdu = new ShopDisplayUnit();
        sdu.setFruitUnitList(fruitMapper.GetAllFruit());
        sdu.setFruitCategoryList(fruitCategoryMapper.GetAllFruitCategory());

        return sdu;
    }


}

@Data
class ShopDisplayUnit
{
    private List<Fruit> fruitUnitList;
    private List<FruitCategory> fruitCategoryList;
}
