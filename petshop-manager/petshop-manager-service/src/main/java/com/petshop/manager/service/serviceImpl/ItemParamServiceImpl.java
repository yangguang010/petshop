package com.petshop.manager.service.serviceImpl;

import com.petshop.common.pojo.PetshopResult;
import com.petshop.manager.dao.TbItemParamMapper;
import com.petshop.manager.pojo.TbItemParam;
import com.petshop.manager.pojo.TbItemParamExample.Criteria;
import com.petshop.manager.pojo.TbItemParamExample;
import com.petshop.manager.service.ItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by songyangguang on 2018/1/3.
 */
@Service
public class ItemParamServiceImpl implements ItemParamService {

    @Autowired
    private TbItemParamMapper tbItemParamMapper;
    /**
     * 根据选定的分类ID查询相关的商品规格模板
     * @param cid
     * @return
     */
    @Override
    public PetshopResult getItemParamByCId(long cid) {

        TbItemParamExample tbItemParam = new TbItemParamExample();
        Criteria criteria = tbItemParam.createCriteria();
        criteria.andItemCatIdEqualTo(cid);

        List<TbItemParam> list = tbItemParamMapper.selectByExample(tbItemParam);

        //判断是否数据库中已经有了对应的模板
        if (list != null && list.size() > 0) {
            return PetshopResult.ok(list.get(0));
        } else {
            return PetshopResult.ok();
        }
    }

    @Override
    public PetshopResult saveItemParam(TbItemParam tbItemParam) {

        //补全pojo


        tbItemParamMapper.insert(tbItemParam);
        return null;
    }
}
