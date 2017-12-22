package com.petshop.manager.controller;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by songyangguang on 2017/12/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:mybatis/SqlMapConfig.xml","classpath:spring/applicationContext-dao.xml","classpath:spring/applicationContext-service.xml"})
public class BaseTest {

}
