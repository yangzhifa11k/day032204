package com.lening.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="tb_goods")
public class GoodsBean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gid;
    private String gname;
    private Integer gprice;
    private Integer gstock;
    private String gtype;

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public Integer getGprice() {
        return gprice;
    }

    public void setGprice(Integer gprice) {
        this.gprice = gprice;
    }

    public Integer getGstock() {
        return gstock;
    }

    public void setGstock(Integer gstock) {
        this.gstock = gstock;
    }

    public String getGtype() {
        return gtype;
    }

    public void setGtype(String gtype) {
        this.gtype = gtype;
    }

    @Override
    public String toString() {
        return "GoodsBean{" +
                "gid=" + gid +
                ", gname='" + gname + '\'' +
                ", gprice=" + gprice +
                ", gstock=" + gstock +
                ", gtype='" + gtype + '\'' +
                '}';
    }
}
