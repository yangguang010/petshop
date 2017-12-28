package com.petshop.manager.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * Created by songyangguang on 2017/12/28.
 */
public interface PictureService {
    Map uploadPicture(MultipartFile uploadFile);
}
