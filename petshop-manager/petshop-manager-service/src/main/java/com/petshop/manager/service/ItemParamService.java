package com.petshop.manager.service;

import com.petshop.common.pojo.PetshopResult;
import com.petshop.manager.pojo.TbItemParam;

/**
 * Created by songyangguang on 2018/1/3.
 */
public interface ItemParamService {
    /**
     * 根据选定商品的分类id查询分类规格参数模板
     * @param cid
     * @return
     */
    PetshopResult getItemParamByCId(long cid);

    /**
     * 保存商品规格参数模板
     * @param tbItemParam
     * @return
     */
    PetshopResult insertItemParam(TbItemParam tbItemParam);
}
