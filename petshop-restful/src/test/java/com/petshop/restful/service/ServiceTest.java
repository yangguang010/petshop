package com.petshop.restful.service;

import com.petshop.restful.pojo.CatResult;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by songyangguang on 2018/2/1.
 */
public class ServiceTest extends BaseTest {
    @Autowired
    private ItemCatService itemCatService;

    @Test
    public void testGetCatListService() {
        CatResult catResult = itemCatService.getItemCatList();
        System.out.println(catResult.getData());
    }
}
