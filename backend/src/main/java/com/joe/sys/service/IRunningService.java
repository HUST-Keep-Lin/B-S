package com.joe.sys.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.joe.sys.entity.Result;
import com.joe.sys.entity.Running;
import com.baomidou.mybatisplus.extension.service.IService;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author joe
 * @since 2023-02-19
 */
public interface IRunningService extends IService<Running> {
    boolean importRunningInfo(String fileName, InputStream is);

    boolean importResultInfo(InputStream is);

    // 批量添加用户数据
    boolean addBatchRunning(List<Running> runningList);

    boolean addBatchResult(List<Result> resultList);

    Map<String, List> pdrCalculate() throws JsonProcessingException, FileNotFoundException;

    Map<String, List> showIndex();
}
