package com.bkgd.toiletdemo.controller;

import com.bkgd.toiletdemo.POJO.WcDeviceHeart;
import com.bkgd.toiletdemo.cache.WcDeviceCacheManager;
import com.bkgd.toiletdemo.cache.WcDeviceHeartCacheManager;
import com.bkgd.toiletdemo.cache.WcToiletCacheManager;
import com.bkgd.toiletdemo.cache.WcToiletCleanCacheManager;
import com.bkgd.toiletdemo.util.DateUtil;
import org.springframework.boot.autoconfigure.data.ConditionalOnRepositoryType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.Map;

/**
 * com.bkgd.toiletdemo.controller
 *厕所保洁统计页面
 * @author lhf
 * @date 2019/1/8
 * @time 14:41
 * @project_name toiletdemo
 */
@Controller
@RequestMapping("/cada")
public class ToiletCada {


    /**
     * 公厕统计
     * @return
     */
    @RequestMapping("/toilet")
    public String toiletCada(ModelMap modelMap){

        //保洁统计
        int wctoiletsize = WcToiletCacheManager.wcToiletMap.size();
        modelMap.addAttribute("toiletsize",wctoiletsize);

        int wctoiletcleansize=WcToiletCleanCacheManager.wcToiletCleanMap.size();

        modelMap.addAttribute("toiletcleansize",wctoiletcleansize);
        //出勤统计
        //在线统计
        int wcdevicesize= WcDeviceCacheManager.wcDeviceMap.size();
        modelMap.addAttribute("wcdevicesize",wcdevicesize);
            //在线设备 距离当前时间2s
        int wcdeviceonlinesize=0;
        Map<String, WcDeviceHeart> heartmap = WcDeviceHeartCacheManager.wcDeviceHeartMap;
        for (WcDeviceHeart wcDeviceHeart : heartmap.values()) {
            String timeStamp=wcDeviceHeart.getParams().getTimeStamp();
            Date fromday = DateUtil.stringToDate(timeStamp, "yyyy/MM/dd HH:mm:ss");
            Date now=new Date();
            long second=DateUtil.getDayBySecondDate(fromday,now);
            System.out.println(wcDeviceHeart.getParams().getReaderID()+",延迟="+second);
            if(second < 20){
                //线程安全
                wcdeviceonlinesize+=1;
            }
        }

        modelMap.addAttribute("wcdeviceonlinesize",wcdeviceonlinesize);

        return "toiletCada";
    }
}
