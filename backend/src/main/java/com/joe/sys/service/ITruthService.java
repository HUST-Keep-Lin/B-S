package com.joe.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.joe.sys.entity.Truth;

import java.io.InputStream;
import java.util.List;

public interface ITruthService extends IService<Truth> {
    boolean importTruthInfo(String fileName, InputStream is);

    // 批量添加用户数据
    boolean addBatchTruth(List<Truth> truthList);
}
