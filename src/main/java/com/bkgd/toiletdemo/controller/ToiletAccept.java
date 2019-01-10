package com.bkgd.toiletdemo.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.bkgd.toiletdemo.POJO.ResPonse;
import com.bkgd.toiletdemo.POJO.SuccessResponse;
import com.bkgd.toiletdemo.POJO.WcToiletClean;
import com.bkgd.toiletdemo.cache.WcToiletCacheManager;
import com.bkgd.toiletdemo.cache.WcToiletCleanCacheManager;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * com.bkgd.toiletdemo.controller
 * 公厕实时数据接收
 *
 * @author lhf
 * @date 2019/1/8
 * @time 14:28
 * @project_name toiletdemo
 */
@RestController
@RequestMapping("/")
public class ToiletAccept {

    /**
     * 接收
     *
     * @return 0、失败,1、成功
     */
    @RequestMapping("/acceptrfid")
    @ResponseBody
    public ResPonse accept(@RequestBody WcToiletClean wcToiletClean) {
        //1转换数据
        //2解析数据
        //3整理数据
        //4数据放入内存中
        try {
            if (WcToiletCacheManager.wcToiletMap.containsKey(wcToiletClean.getParams().getcId())) {
                WcToiletCleanCacheManager.wcToiletCleanMap.put(wcToiletClean.getParams().getcId(), wcToiletClean);
              //  System.out.println("接收到的公厕保洁成数据后，存入MAP，MAP数据集合：" + Arrays.toString(WcToiletCleanCacheManager.wcToiletCleanMap.entrySet().toArray()));
            } else {
               // System.out.println("厕所设备" + wcToiletClean.getParams().getcId() + ",不存在");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //5返回成功或者失败
        SuccessResponse successResponse = new SuccessResponse(wcToiletClean.getId());

        return successResponse;
    }
}
