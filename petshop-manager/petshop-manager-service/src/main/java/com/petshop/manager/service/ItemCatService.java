package com.petshop.manager.service;

import com.petshop.common.pojo.EasyUITreeNode;

import java.util.List;

/**
 * 商品分类查询
 * Created by songyangguang on 2017/12/25.
 */
public interface ItemCatService {

    /**
     * 根据分类tree的根节点ID查询分类信息
     * @param parentId
     * @return
     */
    List<EasyUITreeNode> getItemCatList(long parentId);
}
