package com.petshop.common.pojo;

/**
 * 商品分目，EasyUI分类树节点信息
 * Created by songyangguang on 2017/12/25.
 */
public class EasyUITreeNode {
    private long id;
    private String text;
    private String state;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
