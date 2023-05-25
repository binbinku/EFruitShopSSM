package com.bk.efruitshopssm.controller.main;

import com.bk.efruitshopssm.entity.Fruit;
import com.bk.efruitshopssm.mapper.FruitMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping("/getacategoryfruit")
    public List<Fruit> GetACategoryFruitHandler(int fcno)
    {
        return fruitMapper.GetFruitsByCategory(fcno);
    }

    @PostMapping("modfruit")
    public boolean ModFruit(@RequestBody RecModFruit rec)
    {
        int row = 0;
        switch (rec.getType())
        {
            case "ADD": row = fruitMapper.AddFruit(rec.getData()); break;
            case "DEL": row = fruitMapper.DelFruit(rec.getData().getFno()); break;
            case "MOD": row = fruitMapper.ModFruit(rec.getData()); break;
        }

        return row!=0;
    }
}
@Data
class RecModFruit
{
    private String type;
    private Fruit data;
}
