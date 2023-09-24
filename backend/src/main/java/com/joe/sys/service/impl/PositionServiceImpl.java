package com.joe.sys.service.impl;

import com.joe.sys.entity.Position;
import com.joe.sys.mapper.PositionMapper;
import com.joe.sys.service.IPositionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.joe.sys.utils.ImportExcelUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author joe
 * @since 2023-02-19
 */
@Service
public class PositionServiceImpl extends ServiceImpl<PositionMapper, Position> implements IPositionService {

    @Resource
    PositionMapper positionMapper;

    @Resource
    ImportExcelUtils excelUtils;

    @Override
    public boolean addBatchPosition(List<Position> positionList) {
        return positionMapper.addBatchPosition(positionList) > 0;
    }

    @Override
    public boolean importPositionInfo(String fileName, InputStream is) {
        try {
            List<Position> positionList = excelUtils.upload(fileName, is);
            return addBatchPosition(positionList); // 批量添加
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
