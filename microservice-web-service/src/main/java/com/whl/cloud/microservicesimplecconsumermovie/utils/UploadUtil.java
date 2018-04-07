package com.whl.cloud.microservicesimplecconsumermovie.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * 上传文件工具类
 * file:上传文件
 * path:保存文件路径
 */
public class UploadUtil {
    public static String uploadFile(MultipartFile file, String path) throws IOException {
        File tempfile = null;
        //获取上传文件name
        String fileName = file.getOriginalFilename();
        //获取文件后缀名
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        //拼接保存文件名
        String saveFileName = Integer.toHexString(new Random().nextInt()) + suffix;
        tempfile = new File(path, saveFileName);
        if (!tempfile.getParentFile().exists()) {
            //如果不存在父文件夹就创建
            tempfile.getParentFile().mkdir();
        } else if (tempfile.exists()) {
            //如果该文件已经存在就删除
            tempfile.delete();
        }
        //创建文件
        tempfile.createNewFile();
        //将上传的文件写入服务器文件中
        file.transferTo(tempfile);
        //返回保存文件的名字
        return tempfile.getName();
    }
}
