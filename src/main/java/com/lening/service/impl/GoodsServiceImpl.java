package com.lening.service.impl;

import com.lening.dao.GoodsDao;
import com.lening.entity.GoodsBean;
import com.lening.entity.TypeBean;
import com.lening.result.Page;
import com.lening.service.GoodsService;
import com.lening.vo.SearchBean;
import org.springframework.stereotype.Service;
import com.lening.service.GoodsService;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.List;

@Service
public class GoodsServiceImpl  implements GoodsService {

    @Resource
    private GoodsDao goodsDao;

    @Resource
    private EntityManager entityManager;

    @Override
    public Integer getGoodsCount(SearchBean searchBean) {
        String sql="select count(*) from tb_goods    ";

        Query query = entityManager.createNativeQuery(sql);

        BigInteger singleResult = (BigInteger)query.getSingleResult();
        return singleResult.intValue();
    }

    @Override
    public List<GoodsBean> findGoodsList(SearchBean searchBean, Page page) {
        String sql="select * from tb_goods  ";

        sql+=" limit "+page.getStartRecord()+","+page.getPageSize();
        Query query = entityManager.createNativeQuery(sql, GoodsBean.class);
        List list = query.getResultList();
        return list;
    }

    @Override
    public void saveGoods(GoodsBean goodsBean) {
        goodsDao.save(goodsBean);
    }

    @Override
    public List<TypeBean> getTypeListById(Integer tid) {
        return goodsDao.getTypeListById(tid);
    }
}
