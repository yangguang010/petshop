package com.petshop.restful.controller;

import com.petshop.common.utils.JsonUtil;
import com.petshop.restful.pojo.CatResult;
import com.petshop.restful.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by songyangguang on 2018/2/1.
 */
@Controller
@RequestMapping("/itemcat")
public class ItemCatController {
    @Autowired
    private ItemCatService itemCatService;

    @RequestMapping(value = "/list",produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    @ResponseBody
    public String getItemCatList(String callback) {
        CatResult catResult = itemCatService.getItemCatList();
        //将pojo转化成字符串
        String json = JsonUtil.objectToJson(catResult);
        //拼装返回值
        String result = callback + "(" + json + ");";

        return result;
    }
    /*@RequestMapping("/list")
    @ResponseBody
    public Object getItemCatList(String callback) {
        CatResult catResult = itemCatService.getItemCatList();
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(catResult);
        mappingJacksonValue.setJsonpFunction(callback);
        return mappingJacksonValue;
    }*/
}
