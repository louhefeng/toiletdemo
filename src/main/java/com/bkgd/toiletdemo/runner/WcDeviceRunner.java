package com.bkgd.toiletdemo.runner;

import com.bkgd.toiletdemo.cache.WcDeviceCacheManager;
import com.bkgd.toiletdemo.cache.WcToiletCacheManager;
import com.bkgd.toiletdemo.dao.WcDeviceDao;
import com.bkgd.toiletdemo.dao.WcToiletDao;
import com.bkgd.toiletdemo.model.WcDevice;
import com.bkgd.toiletdemo.model.WcToilet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * com.bkgd.toiletdemo.runner
 *公厕设备数据初始化话到内存中
 * @author lhf
 * @date 2019/1/9
 * @time 17:33
 * @project_name toiletdemo
 */
@Component
public class WcDeviceRunner implements CommandLineRunner {

    @Autowired
    private WcDeviceDao wcDeviceDao;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("初始化rfid设备数据到内存中....");
        List<WcDevice> wcToiletDeviceList = wcDeviceDao.selectWcdevice();
        System.out.println("rfid设备数量："+wcToiletDeviceList.size()+"");
        WcDeviceCacheManager.wcDeviceMap=wcToiletDeviceList.stream().collect(Collectors.toMap(WcDevice::getDevno, wcDevice -> wcDevice));
        System.out.println("初始化rfid数据到内存,Map打印："+Arrays.toString(WcDeviceCacheManager.wcDeviceMap.entrySet().toArray()));
    }
}
