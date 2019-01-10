package com.bkgd.toiletdemo.controller;

import com.bkgd.toiletdemo.POJO.ResPonse;
import com.bkgd.toiletdemo.POJO.SuccessResponse;
import com.bkgd.toiletdemo.POJO.WcDeviceHeart;
import com.bkgd.toiletdemo.POJO.WcToiletClean;
import com.bkgd.toiletdemo.cache.WcDeviceCacheManager;
import com.bkgd.toiletdemo.cache.WcDeviceHeartCacheManager;
import com.bkgd.toiletdemo.cache.WcToiletCacheManager;
import com.bkgd.toiletdemo.cache.WcToiletCleanCacheManager;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * com.bkgd.toiletdemo.controller
 * rfid心跳实时数据接收
 *
 * @author lhf
 * @date 2019/1/19
 * @time 15:37
 * @project_name toiletdemo
 */
@RestController
public class ToiletHeartAccept {

    /**
     * 接收rfid心跳数据
     *
     * @return 0、失败,1、成功
     */
    @RequestMapping("/acceptheart")
    @ResponseBody
    public ResPonse accept(@RequestBody WcDeviceHeart wcDeviceHeart) {
        //1转换数据
        //2解析数据
        //3整理数据
        //4数据放入内存中
        try {
            if(wcDeviceHeart.getMethod().equals("UploadHeart"))//以防万一，加个判断
            {
                if(WcDeviceCacheManager.wcDeviceMap.containsKey(wcDeviceHeart.getParams().getReaderID())){
                    WcDeviceHeartCacheManager.wcDeviceHeartMap.put(wcDeviceHeart.getParams().getReaderID(), wcDeviceHeart);
                  //  System.out.println("接收到的rfid数据后，存入MAP，MAP数据集合：" + Arrays.toString(WcDeviceHeartCacheManager.wcDeviceHeartMap.entrySet().toArray()));
                }else{
                 //   System.out.println("rfid 其他数据不接受");
                }
            }else{
                System.out.println("rfid 其他方法不接受");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //5返回成功或者失败
        SuccessResponse successResponse = new SuccessResponse(wcDeviceHeart.getId());

        return successResponse;
    }
}
