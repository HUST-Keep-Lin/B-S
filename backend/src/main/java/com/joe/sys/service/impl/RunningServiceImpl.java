package com.joe.sys.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.joe.sys.entity.Result;
import com.joe.sys.entity.Running;
import com.joe.sys.mapper.RunningMapper;
import com.joe.sys.service.IRunningService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.joe.sys.utils.ImportExcelUtils2;
import com.joe.sys.utils.ImportExcelUtils4;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.*;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author joe
 * @since 2023-02-19
 */
@Service
public class RunningServiceImpl extends ServiceImpl<RunningMapper, Running> implements IRunningService {
    @Resource
    RunningMapper runningMapper;

    @Resource
    ImportExcelUtils2 excelUtils2;

    @Resource
    ImportExcelUtils4 excelUtils4;

    @Override
    public boolean addBatchRunning(List<Running> runningList) {
        return runningMapper.addBatchRunning(runningList) > 0;
    }

    @Override
    public boolean addBatchResult(List<Result> resultList) {
        return runningMapper.addBatchResult(resultList) > 0;
    }

    @Override
    public Map<String, List> pdrCalculate() throws JsonProcessingException, FileNotFoundException {
        Map<String, List> map = new LinkedHashMap<>();
        List listX = runningMapper.selectX();
        List listY = runningMapper.selectY();
        List listAccx = runningMapper.selectAccx();
        List listAccy = runningMapper.selectAccy();
        List listAccz = runningMapper.selectAccz();
        List listGyroscopex = runningMapper.selectGyroscopex();
        List listGyroscopey = runningMapper.selectGyroscopey();
        List listGyroscopez = runningMapper.selectGyroscopez();
        List listStay = runningMapper.selectStay();
        List listTimestamp = runningMapper.selectTimestamp();
        List listBatch = runningMapper.selectBatch();
        List listStep = runningMapper.selectStep();
        List listXt = runningMapper.selectXt();
        List listYt = runningMapper.selectYt();


        map.put("x",listX);
        map.put("y",listY);
        map.put("accx",listAccx);
        map.put("accy",listAccy);
        map.put("accz",listAccz);
        map.put("gyroscopex",listGyroscopex);
        map.put("gyroscopey",listGyroscopey);
        map.put("gyroscopez",listGyroscopez);
        map.put("xt",listXt);
        map.put("yt",listYt);

        String pyPath = "E:\\Homework\\project\\backend\\src\\main\\resources\\program\\pdr.py";
        String[] arguments = new String[] {"python", pyPath};
        String result = "";
        try {
            Process process = Runtime.getRuntime().exec(arguments);
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            in.close();
            int re = process.waitFor();
            System.out.println(re);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(result);
        result = "E:\\Homework\\project\\backend\\src\\main\\resources\\file\\infomation.xlsx";
        System.out.println("result:" + result);

        File file = new File(result);
        InputStream is = new FileInputStream(file);
        if(importResultInfo(is)){
            List<Double> listXr = runningMapper.selectXr();
            List<Double> listYr = runningMapper.selectYr();
            List<Double> listArg = runningMapper.selectArg();
            List<Double> listError = runningMapper.selectError();

            for (int i = 0; i < listXr.size(); i++) {
                if(listXr.get(i) == -500){
                    listXr.remove(i);
                    i --;
                }
            }
            for (int i = 0; i < listYr.size(); i++) {
                if (listYr.get(i) == -500) {
                    listYr.remove(i);
                    i--;
                }
            }
            for (int i = 0; i < listArg.size(); i++) {
                if (listArg.get(i) == -500) {
                    listArg.remove(i);
                    i--;
                }
            }
            for (int i = 0; i < listError.size(); i++) {
                if (listError.get(i) == -500) {
                    listError.remove(i);
                    i--;
                }
            }

            map.put("xr",listXr);
            map.put("yr",listYr);
            map.put("arg",listArg);
            map.put("error",listError);
            return map;
        }
        return null;
    }

    @Override
    public Map<String, List> showIndex() {
        Map<String, List> map = new LinkedHashMap<>();
        List<Double> listCdfx = runningMapper.selectCdfx();
        List<Double> listCdfy = runningMapper.selectCdfy();
        List<Double> listPerror = runningMapper.selectPerror();
        List<Double> listError = runningMapper.selectError();
        double average = 0.0;
        for (int i = 0; i < listPerror.size(); i++) {
            if (listPerror.get(i) == -500){
                listPerror.remove(i);
                i --;
            }
        }

        for (int i = 0; i < listError.size(); i++) {
            if (listError.get(i) == -500){
                listError.remove(i);
                i --;
            }
        }

        for (int i = 0; i < listError.size(); i++) {
            average += listError.get(i);
        }
        average = average/listError.size();
        listPerror.add(average);
        map.put("cdfx",listCdfx);
        map.put("cdfy",listCdfy);
        map.put("perror",listPerror);
        return map;
    }

    @Override
    public boolean importRunningInfo(String fileName, InputStream is) {
        try {
            List<Running> runningList = excelUtils2.upload(fileName, is);
            return addBatchRunning(runningList); // 批量添加
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean importResultInfo(InputStream is) {
        try {
            List<Result> resultList = excelUtils4.upload(is);
            return addBatchResult(resultList); // 批量添加
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
