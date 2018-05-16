package com.petshop.restful.service.impl;

import com.petshop.manager.dao.TbItemCatMapper;
import com.petshop.manager.pojo.TbItem;
import com.petshop.manager.pojo.TbItemCat;
import com.petshop.manager.pojo.TbItemCatExample;
import com.petshop.manager.pojo.TbItemCatExample.Criteria;
import com.petshop.restful.pojo.CatNode;
import com.petshop.restful.pojo.CatResult;
import com.petshop.restful.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by songyangguang on 2018/1/31.
 */
@Service
public class getItemCatServiceImpl implements ItemCatService {
    @Autowired
    private TbItemCatMapper tbItemCatMapper;
    @Override
    public CatResult getItemCatList() {
        CatResult catResult = new CatResult();
        //查询分类列表
        catResult.setData(getCatList(0));
        return catResult;
    }

    /**
     * 查询分类列表的方法
     * @param parentId
     * @return
     */
    private List<?> getCatList(long parentId) {
        TbItemCatExample example = new TbItemCatExample();
        Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);

        //返回值list
        //执行查询
        List<TbItemCat> list = tbItemCatMapper.selectByExample(example);

        List resultList = new ArrayList<>();
        //向resultList中添加节点
        for (TbItemCat tbItemCat : list) {
            //非叶子节点
            if (tbItemCat.getIsParent()) {
                CatNode catNode = new CatNode();
                if (tbItemCat.getParentId() == 0) {
                    catNode.setName("<a href='/prodecrts/" + tbItemCat.getId() + ".html'>" + tbItemCat.getName() + "</a>");
                } else {
                    catNode.setName(tbItemCat.getName());
                }
                catNode.setUrl("/products/" + tbItemCat.getId() + ".html");
                catNode.setItem(getCatList(tbItemCat.getId()));

                resultList.add(catNode);
            } else {//叶子节点
                resultList.add("/products/" + tbItemCat.getId() + ".html|" + tbItemCat.getName());
            }
        }
        return resultList;
    }
}
