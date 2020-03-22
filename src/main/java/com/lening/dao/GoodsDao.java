package com.lening.dao;

import com.lening.entity.GoodsBean;
import com.lening.entity.TypeBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GoodsDao extends JpaRepository<GoodsBean,Integer> {

    @Query("select c from TypeBean c where c.pid=?1")
    List<TypeBean> getTypeListById(Integer tid);


}
