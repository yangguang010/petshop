package com.petshop.manager.service;

import com.petshop.common.pojo.EasyUIDataGridResult;
import com.petshop.manager.pojo.TbItem;

/**
 * Created by songyangguang on 2017/12/14.
 */
public interface ItemService {
    TbItem selectItem(Long ItemId);

    EasyUIDataGridResult getItemsList(int page,int rows);

}
