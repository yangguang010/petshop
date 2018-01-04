package com.petshop.manager.controller;

import com.petshop.common.utils.JsonUtil;
import com.petshop.manager.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * 上传图片处理
 * Created by songyangguang on 2017/12/28.
 */
@Controller
public class PictureController {
    @Autowired
    private PictureService pictureService;

    @RequestMapping("/pic/upload")
    @ResponseBody
    public String pictureUpload(MultipartFile uploadFile) {
        Map result = pictureService.uploadPicture(uploadFile);
        /**
         * 为了提高浏览器兼容性问题，需要将result转换成JSON格式的字符串并返回
         */
        String json = JsonUtil.objectToJson(result);
        return json;
    }
}
