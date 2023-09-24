package com.joe.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.joe.sys.entity.Truth;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TruthMapper extends BaseMapper<Truth> {

    int addBatchTruth(List<Truth> truthList);
}
