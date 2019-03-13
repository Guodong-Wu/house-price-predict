package edu.seu.housepricepredict.domain.page;

import java.util.List;

/**
 * @author guodonwu@163.com
 * @date 11:28 2019/3/13
 * 分页实体类
 */

public class PageBean<T> {
    /**
     * 页面大小
     */
    private int pageSize;
    /**
     * 当前页数
     */
    private int currPage;
    /**
     * 总页数
     */
    private int totalPage;
    /**
     * 总记录数
     */
    private int totalCount;
    /**
     * 查询结果列表
     */
    private List<T> list;

    @Override
    public String toString() {
        return "PageBean{" +
                "pageSize=" + pageSize +
                ", currPage=" + currPage +
                ", totalPage=" + totalPage +
                ", totalCount=" + totalCount +
                ", list=" + list +
                '}';
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrPage() {
        return currPage;
    }

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
