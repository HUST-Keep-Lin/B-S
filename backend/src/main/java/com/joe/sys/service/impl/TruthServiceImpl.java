package com.joe.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.joe.sys.entity.Truth;
import com.joe.sys.mapper.TruthMapper;
import com.joe.sys.service.ITruthService;
import com.joe.sys.utils.ImportExcelUtils3;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.List;

@Service
public class TruthServiceImpl extends ServiceImpl<TruthMapper, Truth> implements ITruthService {
    @Resource
    TruthMapper truthMapper;

    @Resource
    ImportExcelUtils3 excelUtils3;

    @Override
    public boolean importTruthInfo(String fileName, InputStream is) {
        try {
            List<Truth> truthList = excelUtils3.upload(fileName, is);
            return addBatchTruth(truthList); // 批量添加
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addBatchTruth(List<Truth> truthList) {
        return truthMapper.addBatchTruth(truthList) > 0;
    }
}
