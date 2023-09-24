package com.joe.sys.mapper;

import com.joe.sys.entity.Position;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author joe
 * @since 2023-02-19
 */
@Mapper
@Repository
public interface PositionMapper extends BaseMapper<Position> {
    // 批量添加用户数据
    public int addBatchPosition(List<Position> positionList);
}
