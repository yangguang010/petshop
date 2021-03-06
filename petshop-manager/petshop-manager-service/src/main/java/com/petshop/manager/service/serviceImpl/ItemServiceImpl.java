package com.petshop.manager.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.petshop.common.pojo.EasyUIDataGridResult;
import com.petshop.common.pojo.PetshopResult;
import com.petshop.common.utils.IDUtil;
import com.petshop.manager.dao.TbItemDescMapper;
import com.petshop.manager.dao.TbItemMapper;
import com.petshop.manager.dao.TbItemParamItemMapper;
import com.petshop.manager.pojo.TbItem;
import com.petshop.manager.pojo.TbItemDesc;
import com.petshop.manager.pojo.TbItemExample;
import com.petshop.manager.pojo.TbItemParamItem;
import com.petshop.manager.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by songyangguang on 2017/12/15.
 */
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private TbItemMapper tbItemMapper;
    @Autowired
    private TbItemDescMapper tbItemDescMapper;
    @Autowired
    private TbItemParamItemMapper tbItemParamItemMapper;

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

    /**
     * 添加商品信息
     * @param tbItem
     * @return
     */
    @Override
    public PetshopResult createItem(TbItem tbItem, String desc,String itemParam) throws Exception {
        //表单中已经有一些TbItem中的属性，但还有一些属性需要补全
        //生成商品的id
        Long itemId = IDUtil.genItemId();
        tbItem.setId(itemId);

        //设置商品的状态
        tbItem.setStatus((byte)1);

        //设置商品的创建时间
        tbItem.setCreated(new Date());
        tbItem.setUpdated(new Date());

        //插入数据库
        tbItemMapper.insert(tbItem);
        //保存商品描述信息
        PetshopResult result1 = insertItemDesc(itemId,desc);
        PetshopResult result2 = insertItemParamItem(itemId,itemParam);
        if(result1.getStatus() != 200 || result2.getStatus() != 200) {
            throw new Exception("商品信息插入错误！");
        }
        return PetshopResult.ok();
    }

    //插入商品规格信息
    private PetshopResult insertItemParamItem(Long itemId, String itemParam) {

        //创建一个ItemParamItem对象
        TbItemParamItem tbItemParamItem = new TbItemParamItem();
        tbItemParamItem.setItemId(itemId);
        tbItemParamItem.setParamData(itemParam);
        tbItemParamItem.setCreated(new Date());
        tbItemParamItem.setUpdated(new Date());

        //插入数据
        tbItemParamItemMapper.insert(tbItemParamItem);

        return PetshopResult.ok();

    }

    //插入商品的信息描述
    private PetshopResult insertItemDesc(Long itemId,String desc) {
        //创建一个商品，描述信息对象tbItemDesc
        TbItemDesc tbItemDesc = new TbItemDesc();
        tbItemDesc.setItemId(itemId);
        tbItemDesc.setItemDesc(desc);
        tbItemDesc.setCreated(new Date());
        tbItemDesc.setUpdated(new Date());
        //插入数据
        tbItemDescMapper.insert(tbItemDesc);
        return PetshopResult.ok();
    }
}
