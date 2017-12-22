package com.petshop.manager.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.petshop.common.pojo.EasyUIDataGridResult;
import com.petshop.manager.dao.TbItemMapper;
import com.petshop.manager.pojo.TbItem;
import com.petshop.manager.pojo.TbItemExample;
import com.petshop.manager.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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


    /**
     * 商品列表查询
     * @param page
     * @param rows
     * @return
     */
    public EasyUIDataGridResult getItemsList(int page, int rows) {
        //根据页面信息查询商品列表
        TbItemExample itemExample = new TbItemExample();

        //分页信息
        PageHelper.startPage(page,rows);
        List<TbItem> tbItemList = tbItemMapper.selectByExample(itemExample);

        //创建一个返回值对象
        EasyUIDataGridResult easyUIDataGridResult = new EasyUIDataGridResult();
        easyUIDataGridResult.setRows(tbItemList);
        //创建总条数
        PageInfo<TbItem> pageInfo = new PageInfo<>(tbItemList);
        easyUIDataGridResult.setTotal(pageInfo.getTotal());
        return easyUIDataGridResult;
    }
}
