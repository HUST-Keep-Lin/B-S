package com.joe.sys.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.joe.sys.service.IRunningService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author joe
 * @since 2023-02-19
 */
@RestController
@RequestMapping("/sys/running")
public class RunningController {
    @Resource
    IRunningService runningService;

    // 批量添加数据
    @PostMapping("/upload")
    public Map<String,String> upload(@RequestParam("file") MultipartFile excelFile) throws Exception{
        Map<String,String> map = new HashMap<>();
        if (excelFile.isEmpty()){
            map.put("mag","文件夹为空，重新上传");
            return map;
        }else {
            String fileName = excelFile.getOriginalFilename();
            InputStream is = excelFile.getInputStream();
            if (runningService.importRunningInfo(fileName,is)){
                map.put("msg","数据添加成功");
                return map;
            }else {
                map.put("msg","数据添加失败，请重新添加");
                return map;
            }
        }
    }

    @GetMapping("/show")
    public Map<String, List> show() throws JsonProcessingException, FileNotFoundException {
        Map<String, List> map1 = runningService.pdrCalculate();
        return map1;
    }

    @GetMapping("/show2")
    public Map<String, List> show2(){
        Map<String, List> map2 = runningService.showIndex();
        return map2;
    }

    @PostMapping("/user/login")
    public Map<String, Object> login(Object object){
        Map<String, Object> mapLogin= new LinkedHashMap<>();
        Map<String, String> mapTemp = new LinkedHashMap<>();
        mapTemp.put("token","admin-token");
        mapLogin.put("code",20000);
        mapLogin.put("data",mapTemp);
        return mapLogin;
    }

    @GetMapping("/user/info")
    public Map<String, Object> info(Object object){
        Map<String,Object> mapInfo = new LinkedHashMap<>();
        mapInfo.put("code", 20000);
        return mapInfo;
    }
}
