package com.joe.sys.service;

import com.joe.sys.entity.Position;
import com.baomidou.mybatisplus.extension.service.IService;

import java.io.InputStream;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author joe
 * @since 2023-02-19
 */
public interface IPositionService extends IService<Position> {

    boolean importPositionInfo(String fileName, InputStream is);

    // 批量添加用户数据
    boolean addBatchPosition(List<Position> positionList);
}
