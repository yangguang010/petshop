package com.petshop.manager.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.petshop.manager.dao.TbItemMapper;
import com.petshop.manager.pojo.TbItem;
import com.petshop.manager.pojo.TbItemExample;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by songyangguang on 2017/12/21.
 */
public class PaperTest extends BaseTest{

    @Autowired
    private TbItemMapper tbItemMapper;
    @Test
    public void selectItemByItem() {

        TbItemExample tbItemExample = new TbItemExample();

        PageHelper.startPage(1,10);
        List<TbItem> tbItemList = tbItemMapper.selectByExample(tbItemExample);


/*        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
        TbItemMapper mapper = applicationContext.getBean(TbItemMapper.class);
        TbItemExample example = new TbItemExample();

        PageHelper.startPage(1,10);
        List<TbItem> tbItemList = mapper.selectByExample(example);

        for (TbItem tbItem : tbItemList) {
            System.out.println(tbItem.getTitle());
        }
        //取出分页信息
        PageInfo<TbItem> pageInfo = new PageInfo<>(tbItemList);
        long total = pageInfo.getTotal();
        System.out.println("共有商品的数量：" + total);*/

    }

}
