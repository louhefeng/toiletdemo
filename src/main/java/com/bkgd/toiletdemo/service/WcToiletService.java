package com.bkgd.toiletdemo.service;

import com.bkgd.toiletdemo.model.WcToilet;

import java.util.List;

/**
 * com.bkgd.toiletdemo.service
 * 厕所保洁业务接口
 * @author lhf
 * @date 2019/1/9
 * @time 15:35
 * @project_name toiletdemo
 */
public interface WcToiletService {
    /**
     * 查询所有厕所数据
     * @return WcToilet集合
     */
    List<WcToilet> selectWcToile();
}
