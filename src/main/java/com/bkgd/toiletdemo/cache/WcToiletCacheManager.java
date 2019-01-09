package com.bkgd.toiletdemo.cache;

import com.bkgd.toiletdemo.model.WcToilet;

import java.util.Map;

/**
 * com.bkgd.toiletdemo.cache
 *公厕数据缓存管理类
 * @author lhf
 * @date 2019/1/9
 * @time 17:55
 * @project_name toiletdemo
 */
public class WcToiletCacheManager
{

    /**
     * 缓存公厕数据
     * 不存在并发，不需要线程安全
     */
    public   static Map<String, WcToilet> wcToiletMap;

}
