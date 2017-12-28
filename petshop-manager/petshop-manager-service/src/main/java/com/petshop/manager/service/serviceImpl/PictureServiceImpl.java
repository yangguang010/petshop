package com.petshop.manager.service.serviceImpl;

import com.petshop.common.utils.FtpUtil;
import com.petshop.common.utils.IDUtil;
import com.petshop.manager.service.PictureService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 图片上传服务
 * Created by songyangguang on 2017/12/28.
 */
@Service
public class PictureServiceImpl implements PictureService {

    @Value("${FTP_ADDRESS}")
    private String FTP_ADDRESS;
    @Value("${FTP_PORT}")
    private int FTP_PORT;
    @Value("${FTP_USERNAME}")
    private String FTP_USERNAME;
    @Value("${FTP_PASSWORD}")
    private String FTP_PASSWORD;
    @Value("${FTP_BASEPATH}")
    private String FTP_BASEPATH;
    @Value("${IMAGES_ADDRESS}")
    private String IMAGES_ADDRESS;

    public Map uploadPicture(MultipartFile uploadFile) {
        Map resultMap = new HashMap<>();
        try {
            //生成一个新的文件名
            //取出原始文件名
            String oldName = uploadFile.getOriginalFilename();
            //生成新的文件名
            String newName = IDUtil.genImageName();
            newName = newName + oldName.substring(oldName.lastIndexOf("."));

            //文件路径：按照日期来写
            String filePath = new DateTime().toString("/yyyy/MM/dd");
            //图片上传
            boolean result = FtpUtil.uploadFile(FTP_ADDRESS, FTP_PORT, FTP_USERNAME, FTP_PASSWORD, FTP_BASEPATH,
                    filePath, newName, uploadFile.getInputStream());

            //返回结果
            if (!result) {
                resultMap.put("error", 1);
                resultMap.put("message", "文件上传失败！");
                return resultMap;
            } else {
                resultMap.put("error", 0);
                resultMap.put("url", IMAGES_ADDRESS + filePath + "/" + newName);
                return resultMap;
            }
        } catch (IOException e) {
            resultMap.put("error", 1);
            resultMap.put("message", "文件上传失败,发生异常！");
            return resultMap;
        }
    }
}
