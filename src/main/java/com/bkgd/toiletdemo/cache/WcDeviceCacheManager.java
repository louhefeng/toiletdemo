package com.bkgd.toiletdemo.cache;

import com.bkgd.toiletdemo.POJO.WcToiletClean;
import com.bkgd.toiletdemo.model.WcDevice;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * com.bkgd.toiletdemo.cache
 *公厕设备数据缓存管理
 * @author lhf
 * @date 2019/1/10
 * @time 15:15
 * @project_name toiletdemo
 */
public class WcDeviceCacheManager {

    public static Map<String, WcDevice> wcDeviceMap;
}
