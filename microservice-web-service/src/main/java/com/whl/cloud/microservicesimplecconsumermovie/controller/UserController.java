package com.whl.cloud.microservicesimplecconsumermovie.controller;

import com.whl.cloud.microservicesimplecconsumermovie.entity.User;
import com.whl.cloud.microservicesimplecconsumermovie.utils.UploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller  //注意这里必须为Controller
@RequestMapping("/movie")
public class UserController {

    @Value("${user.urlPath}")
    private String urlpath;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/allUser")
    @ResponseBody
    private User getAllUser(){
       // ResponseEntity<List<User>> responseEntity = restTemplate.exchange(urlpath, HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {});
        User user = restTemplate.getForObject(urlpath+"user/getUser?userId=2",User.class);
        return user;
    }

    @GetMapping("/view/index")
    public String getIndex(HashMap<String,Object> map){
        map.put("hello","欢迎来到SpringBoot首页");
        return "/user/index";

    }

    /**
     * 文件上传
     * @return
     */
    @PostMapping("/upload")
    @ResponseBody
    public Map<String,Object> fileUpload(MultipartFile file , HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        try {
            //获取保存文件路径
            String path = System.getProperty("user.dir")+"/upload";
            //文件download
            String realFileName = UploadUtil.uploadFile(file,path);
            map.put("code",0);
            map.put("file",realFileName);
        }catch (Exception e){
            map.put("code",1);
            e.printStackTrace();
        }
        return map;
    }
}
