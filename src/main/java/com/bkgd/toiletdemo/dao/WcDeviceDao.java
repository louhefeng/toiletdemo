package com.bkgd.toiletdemo.dao;

import com.bkgd.toiletdemo.model.WcDevice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * mybatis 生成工具generator生成
 */
@Mapper
public interface WcDeviceDao {
    int deleteByPrimaryKey(String devid);

    int insert(WcDevice record);

    int insertSelective(WcDevice record);

    WcDevice selectByPrimaryKey(String devid);

    int updateByPrimaryKeySelective(WcDevice record);

    int updateByPrimaryKey(WcDevice record);
    /**
     * 查询所有rfid设备
     */
    List<WcDevice> selectWcdevice();
}