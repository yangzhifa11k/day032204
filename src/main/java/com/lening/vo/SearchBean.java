package com.lening.vo;

import lombok.Data;

@Data
public class SearchBean {

    private String gname;
    private Integer sprice;
    private Integer eprice;
    private String yema;
    private String pageSize;

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public Integer getSprice() {
        return sprice;
    }

    public void setSprice(Integer sprice) {
        this.sprice = sprice;
    }

    public Integer getEprice() {
        return eprice;
    }

    public void setEprice(Integer eprice) {
        this.eprice = eprice;
    }

    public String getYema() {
        return yema;
    }

    public void setYema(String yema) {
        this.yema = yema;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }
}
