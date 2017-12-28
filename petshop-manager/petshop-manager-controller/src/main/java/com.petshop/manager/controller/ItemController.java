package com.petshop.manager.controller;

import com.petshop.common.pojo.EasyUIDataGridResult;
import com.petshop.manager.pojo.TbItem;
import com.petshop.manager.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 商品Contrlloer
 * Created by songyangguang on 2017/12/16.
 */
@Controller
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @RequestMapping("/{itemId}")
    @ResponseBody
    public TbItem getItemById(@PathVariable Long itemId) {
        TbItem tbItem = itemService.selectItem(itemId);
        return tbItem;
    }

    /**
     * 根据页面的信息查询商品的列表
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public EasyUIDataGridResult getItemList(Integer page,Integer rows) {
        EasyUIDataGridResult easyUIDataGridResult = itemService.getItemsList(page,rows);
        return easyUIDataGridResult;
    }
}
