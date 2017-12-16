package com.petshop.manager.service.serviceImpl;

import com.petshop.manager.dao.TbItemMapper;
import com.petshop.manager.pojo.TbItem;
import com.petshop.manager.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by songyangguang on 2017/12/15.
 */
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private TbItemMapper tbItemMapper;

    public TbItem selectItem(Long itemId) {
        TbItem tbItem = tbItemMapper.selectByPrimaryKey(itemId);
        return tbItem;
    }
}
