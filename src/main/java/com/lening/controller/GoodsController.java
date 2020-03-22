package com.lening.controller;

import com.lening.entity.GoodsBean;
import com.lening.entity.TypeBean;
import com.lening.result.Page;
import com.lening.result.Result;
import com.lening.service.GoodsService;
import com.lening.vo.SearchBean;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class GoodsController {
    @Resource
    private GoodsService goodsService;

    @RequestMapping("/saveGoods")
    public Result saveGoods(@RequestBody GoodsBean goodsBean){
        try {
            goodsService.saveGoods(goodsBean);
            return  new Result(true, "编辑成功");
        }catch (Exception e){
            e.printStackTrace();
        }
        return new Result(false, "编辑失败");
    }

    @RequestMapping("/getTypeListById")
    public List<TypeBean> getTypeListById(Integer tid){
        return goodsService.getTypeListById(tid);
    }


    @RequestMapping("/findAll")
    public Map findAll(@RequestBody SearchBean searchBean){
        Map map = new HashMap();

        Integer count = goodsService.getGoodsCount(searchBean);
        Page page = new Page(searchBean.getYema(), count, searchBean.getPageSize());
        List<GoodsBean> list = (List<GoodsBean>) goodsService.findGoodsList(searchBean,page);
        map.put("page", page);
        map.put("goodsList", list);
        return map;
    }
}
