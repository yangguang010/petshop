package com.petshop.manager.controller;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Created by songyangguang on 2017/12/27.
 */
public class FTPTest {

    @Test
    public void testFTPClient() throws Exception {
        //创建一个FTPClient
        String filepath = "/2017/12/28";
        FTPClient ftpClient = new FTPClient();
        //创建FTP连接，默认端口是21
        ftpClient.connect("192.168.197.128",21);
        //登录FTP服务器，使用用户名和密码
        ftpClient.login("ftpuser","ftpuser123");
        //读取本地文件
        FileInputStream inputStream = new FileInputStream(new File("C:\\1.jpg"));

        //  切换到上传目录
        if(!ftpClient.changeWorkingDirectory(filepath)) {
            //如果目录不存在创建目录
            String[] dirs = filepath.split("/");
            String tempPath = "";
            for (String dir : dirs) {
                if(null == dir || "".equals(dir))
                    continue;
                tempPath += "/" + dir;
                if(!ftpClient.changeWorkingDirectory(tempPath)) {
                    if (!ftpClient.makeDirectory(tempPath)) {
                        System.out.println("ERROR!");
                    } else {
                        ftpClient.changeWorkingDirectory(tempPath);
                    }
                }
            }
        }

        //修改上传文件的格式
        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
        //切入目录
       // String dir = "/www/images";

        //上传文件
            //第一个参数：服务器端的文档名字
            //第二个参数：上传文档的inputStream
        ftpClient.storeFile("hello4.jpg",inputStream);
        //关闭连接
        ftpClient.logout();
    }
}
