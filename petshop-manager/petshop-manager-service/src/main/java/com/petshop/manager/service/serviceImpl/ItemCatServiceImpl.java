package com.petshop.manager.service.serviceImpl;

import com.petshop.common.pojo.EasyUITreeNode;
import com.petshop.manager.dao.TbItemCatMapper;
import com.petshop.manager.pojo.TbItemCat;
import com.petshop.manager.pojo.TbItemCatExample;
import com.petshop.manager.pojo.TbItemCatExample.Criteria;
import com.petshop.manager.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品分类目录service
 * Created by songyangguang on 2017/12/25.
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private TbItemCatMapper tbItemCatMapper;

    @Override
    public List<EasyUITreeNode> getItemCatList(long parentId) {

        //创建example对象
        TbItemCatExample example = new TbItemCatExample();
        //设置查询条件
        Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        //执行查询
        List<TbItemCat> list = tbItemCatMapper.selectByExample(example);

        //转换成EasyUITreeNode节点
        List<EasyUITreeNode> easyUITreeNodeList = new ArrayList<EasyUITreeNode>();
        for (TbItemCat tbItemCat : list) {
            //创建一个节点对象
            EasyUITreeNode easyUITreeNode = new EasyUITreeNode();
            easyUITreeNode.setId(tbItemCat.getId());
            easyUITreeNode.setText(tbItemCat.getName());
            easyUITreeNode.setState(tbItemCat.getIsParent()?"closed":"open");

            easyUITreeNodeList.add(easyUITreeNode);
        }

        return easyUITreeNodeList;
    }
}
