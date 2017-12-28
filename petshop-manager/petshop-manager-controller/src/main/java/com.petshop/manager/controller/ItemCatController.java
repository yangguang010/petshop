package com.petshop.manager.controller;

import com.petshop.common.pojo.EasyUITreeNode;
import com.petshop.manager.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 商品分类目录controller
 * Created by songyangguang on 2017/12/25.
 */
@Controller
@RequestMapping("/item/cat")
public class ItemCatController {

    @Autowired
    private ItemCatService itemCatService;

    @RequestMapping("/list")
    @ResponseBody
    public List<EasyUITreeNode> getItemCatList(@RequestParam(value = "id",defaultValue = "0") Long parentId) {
        List<EasyUITreeNode> easyUITreeNodes = itemCatService.getItemCatList(parentId);
        return easyUITreeNodes;
    }
}
