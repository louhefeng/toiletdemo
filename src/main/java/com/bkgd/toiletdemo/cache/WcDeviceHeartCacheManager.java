package com.bkgd.toiletdemo.cache;

import com.bkgd.toiletdemo.POJO.WcDeviceHeart;
import com.bkgd.toiletdemo.POJO.WcToiletClean;
import com.bkgd.toiletdemo.model.WcDevice;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * com.bkgd.toiletdemo.cache
 *rfid 心跳处理
 * 接收第三方推送过来的数据
 * 有并发的可能性，需要注意线程安全
 * @author lhf
 * @date 2019/1/9
 * @time 18:21
 * @project_name toiletdemo
 */
public class WcDeviceHeartCacheManager {
    /**
     * 线程安全
     */
    public static Map<String, WcDeviceHeart> wcDeviceHeartMap=new HashMap<String, WcDeviceHeart>();
}
