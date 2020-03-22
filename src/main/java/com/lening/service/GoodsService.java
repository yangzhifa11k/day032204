package com.lening.service;

import com.lening.entity.GoodsBean;
import com.lening.entity.TypeBean;
import com.lening.result.Page;
import com.lening.vo.SearchBean;

import java.util.List;

public interface GoodsService {


    Integer getGoodsCount(SearchBean searchBean);

    List<GoodsBean> findGoodsList(SearchBean searchBean, Page page);

    void saveGoods(GoodsBean goodsBean);

    List<TypeBean> getTypeListById(Integer tid);
}
