package com.petshop.common.pojo;

import java.util.List;

/**
 * 商品分页信息
 * Created by songyangguang on 2017/12/22.
 */
public class EasyUIDataGridResult {
    private long total;
    private List<?> rows;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}
