package com.petshop.manager.serviceTest;

import com.petshop.manager.dao.TbItemMapper;
import com.petshop.manager.pojo.TbItem;
import com.petshop.manager.service.ItemService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by songyangguang on 2017/12/15.
 */

public class ItemServiceTest extends BaseTest {
    @Autowired
    private TbItemMapper itemMapper;

    @Test
    public void selectItemById() {
        Long id = 536563l;
        TbItem tbItem = itemMapper.selectByPrimaryKey(id);
        System.out.println(tbItem.getCid());
    }
}
