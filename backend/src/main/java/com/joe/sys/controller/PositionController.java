package com.joe.sys.controller;

import com.joe.sys.service.IPositionService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.HashMap;
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
@RequestMapping("/sys/position")
public class PositionController {
    @Resource
    IPositionService positionService;

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
            if (positionService.importPositionInfo(fileName,is)){
                map.put("msg","数据添加成功");
                return map;
            }else {
                map.put("msg","数据添加失败，请重新添加");
                return map;
            }
        }
    }
}
