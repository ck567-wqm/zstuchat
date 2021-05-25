package com.wqm.controller;

import com.wqm.common.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 用户头像保存类，提供/save接口，实现用户头像上传
 */
@RestController
public class AvatarSaveController {

    @RequestMapping("/save")
    public Result save(@RequestParam("file") MultipartFile[] multipartfiles, String productId) throws IOException {
        //获取项目编译之后的文件路径，一般是“项目路径/target/classes”
        String Path = (String.valueOf(Thread.currentThread().getContextClassLoader().getResource("") + "static/")).replaceAll("file:/", "").replaceAll("%20", " ").trim();
        if (Path.indexOf(":") != 1) {
            Path = File.separator + Path;
        }
        //遍历文件
        String fileName = null;
        if (multipartfiles != null && multipartfiles.length > 0) {
            for (MultipartFile item : multipartfiles) {
                fileName = item.getOriginalFilename();
                String filePath = Path + "avatar";//自定义上传路径
                File file = new File(filePath, fileName);
                if (!file.exists()) {//判断文件夹是否存在，如果不存在则创建
                    if (!file.getParentFile().exists()) {
                        file.getParentFile().mkdirs();
                    }
                    file.createNewFile();
                }
                item.transferTo(file);//上传文件
            }
        }

        return Result.succ("http://localhost:8081"+"/avatar/"+fileName);
    }

}
