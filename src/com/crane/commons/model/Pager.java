package com.crane.commons.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pager {
    private int pageNow = 1;
    private int pageSize =6;
    private int totalCount;
    private int totalPages;
    private List<?> datas;
    private int offset;
    private Map<String,Object> query = new HashMap<String,Object>();
    


    @Override
    public String toString() {
        return "Pager [pageNow=" + this.pageNow + ", pageSize=" + this.pageSize + ", totalCount=" + this.totalCount
                + ", totalPages=" + this.totalPages + ", datas=" + this.datas + ", offset=" + this.offset + ", query="
                + this.query + "]";
    }
    public Map<String , Object> getQuery() {
        return this.query;
    }
    public void setQuery(Map<String , Object> query ) {
        this.query = query;
    }
    public int getPageNow() {
        return this.pageNow;
    }
    public void setPageNow(int pageNow ) {
        this.pageNow = pageNow;
    }
    public int getPageSize() {
        return this.pageSize;
    }
    public void setPageSize(int pageSize ) {
        this.pageSize = pageSize;
    }
    public int getTotalCount() {
        return this.totalCount;
    }
    public void setTotalCount(int totalCount ) {
        this.totalCount = totalCount;
    }
    public int getTotalPages() {
        this.totalPages = this.totalCount%this.pageSize==0?this.totalCount/this.pageSize:this.totalCount/this.pageSize+1;
        return this.totalPages;
    }
    public void setTotalPages(int totalPages ) {
        this.totalPages = totalPages;
    }
    public List<?> getDatas() {
        return this.datas;
    }
    public void setDatas(List<?> datas ) {
        this.datas = datas;
    }
    public int getOffset() {
        return (this.pageNow-1)*this.pageSize;
    }
    public void setOffset(int offset ) {
        this.offset = offset;
    }
}
