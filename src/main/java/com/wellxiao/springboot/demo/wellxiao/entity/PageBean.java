package com.wellxiao.springboot.demo.wellxiao.entity;


import lombok.Data;

import java.util.List;

@Data
public class PageBean<T> {
    private int currentPage = 1;
    // 每页显示的总条数
    private int pageSize = 10;
    // 总条数
    private int totalNum;
    // 是否有下一页
    private int isMore;
    // 总页数
    private int totalPage;
    // 开始索引
    private int startIndex;
    // 分页结果
    private List<T> list;

    public PageBean() {
        super();
    }

    public PageBean(int currentPage, int pageSize, int totalNum,List<T> list) {
        super();
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalNum = totalNum;
        this.list = list;
        this.totalPage = (this.totalNum+this.pageSize-1)/this.pageSize;
        this.startIndex = (this.currentPage-1)*this.pageSize;
        this.isMore = this.currentPage >= this.totalPage?0:1;
    }
}
