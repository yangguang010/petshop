package com.petshop.manager.controller;

import com.petshop.manager.pojo.TbItem;
import com.petshop.manager.service.ItemService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by songyangguang on 2017/12/15.
 */

public class ItemServiceTest extends BaseTest {
    @Autowired
    private ItemService itemService;
    @Test
    public void selectItemById() {
        Long id = 536563L;
        TbItem tbItem = itemService.selectItem(id);
        System.out.println(tbItem);
    }
}
