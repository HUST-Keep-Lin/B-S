package com.joe.sys.mapper;

import com.joe.sys.entity.Result;
import com.joe.sys.entity.Running;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
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
public interface RunningMapper extends BaseMapper<Running> {

    int addBatchRunning(List<Running> runningList);

    @Select("select x from position")
    List<Double> selectX();

    @Select("select y from position")
    List<Double> selectY();

    @Select("select accx from running")
    List<Integer> selectAccx();

    @Select("select accy from running")
    List<Integer> selectAccy();

    @Select("select accz from running")
    List<Integer> selectAccz();

    @Select("select gyroscopex from running")
    List<Integer> selectGyroscopex();

    @Select("select gyroscopey from running")
    List<Integer> selectGyroscopey();

    @Select("select gyroscopez from running")
    List<Integer> selectGyroscopez();

    @Select("select stay from running")
    List<Integer> selectStay();

    @Select("select timestamp from running")
    List<String> selectTimestamp();

    @Select("select batch from running")
    List<Integer> selectBatch();

    @Select("select step from truth")
    List<Integer> selectStep();

    @Select("select xt from truth")
    List<Double> selectXt();

    @Select("select yt from truth")
    List<Double> selectYt();

    @Select("select xr from result")
    List<Double> selectXr();

    @Select("select yr from result")
    List<Double> selectYr();

    @Select("select arg from result")
    List<Double> selectArg();

    @Select("select error from result")
    List<Double> selectError();

    @Select("select cdfx from result")
    List<Double> selectCdfx();

    @Select("select cdfy from result")
    List<Double> selectCdfy();

    @Select("select Perror from result")
    List<Double> selectPerror();

    int addBatchResult(List<Result> resultList);
}
