package com.bkgd.toiletdemo.dao;

import com.bkgd.toiletdemo.model.WcToilet;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * com.bkgd.toiletdemo.dao
 *
 * @author lhf
 * @date 2019/1/9
 * @time 13:39
 * @project_name toiletdemo
 */
@Mapper
public interface WcToiletDao {

    int deleteByPrimaryKey(String tid);

    int insert(WcToilet record);

    int insertSelective(WcToilet record);

    WcToilet selectByPrimaryKey(String tid);

    int updateByPrimaryKeySelective(WcToilet record);

    int updateByPrimaryKey(WcToilet record);

    /**
     * 查询所有数据
     * @return 集合
     */
    List<WcToilet> selectWctoilet();
}
