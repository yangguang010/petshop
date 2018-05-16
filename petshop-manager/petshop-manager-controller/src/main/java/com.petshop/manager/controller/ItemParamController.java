package com.petshop.manager.controller;

import com.petshop.common.pojo.PetshopResult;
import com.petshop.manager.pojo.TbItemParam;
import com.petshop.manager.service.ItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 商品分类规格参数Controller
 * Created by songyangguang on 2018/1/3.
 */
@Controller
@RequestMapping("/item/param")
public class ItemParamController {
    @Autowired
    private ItemParamService itemParamService;

    @RequestMapping("/query/itemcatid/{itemCatId}")
    @ResponseBody
    public PetshopResult getItemParamByCid(@PathVariable long itemCatId) {
        PetshopResult result = itemParamService.getItemParamByCId(itemCatId);
        return result;
    }

    @RequestMapping("/save/{cid}")
    @ResponseBody
    public PetshopResult insertItemParam(@PathVariable Long cid,String paramData) {
        TbItemParam tbItemParam = new TbItemParam();
        tbItemParam.setItemCatId(cid);
        tbItemParam.setParamData(paramData);
        PetshopResult result = itemParamService.insertItemParam(tbItemParam);
        return result;
    }
}
