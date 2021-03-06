package com.bkgd.toiletdemo.cache;

import com.bkgd.toiletdemo.POJO.WcToiletClean;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * com.bkgd.toiletdemo.cache
 *公厕保洁数据缓存管理
 * 接收第三方推送过来的公厕保洁数据
 * 有并发的可能性，需要注意线程安全
 * @author lhf
 * @date 2019/1/9
 * @time 18:21
 * @project_name toiletdemo
 */
public class WcToiletCleanCacheManager {
    /**
     * 线程安全
     */
    public static Map<String, WcToiletClean> wcToiletCleanMap=new ConcurrentHashMap<String,WcToiletClean>();
}
