package com.bkgd.toiletdemo.controller;

import com.bkgd.toiletdemo.POJO.ToiletCada;
import com.bkgd.toiletdemo.POJO.WcDeviceHeart;
import com.bkgd.toiletdemo.POJO.WcToiletClean;
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
import org.springframework.web.bind.annotation.ResponseBody;

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
public class ToiletCadaController {


    /**
     * 公厕统计
     * @return
     */
    @RequestMapping("/toilet")
    @ResponseBody
    public ToiletCada toiletCada(ModelMap modelMap){

        ToiletCada toiletCada=new ToiletCada();
        //保洁统计
        int wctoiletsize = WcToiletCacheManager.wcToiletMap.size();
        modelMap.addAttribute("toiletsize",wctoiletsize);
        toiletCada.setWctoiletsize(wctoiletsize);

        //已保洁， 保洁时间持续50s,为已保洁
        int wctoiletcleansize=0;
        Map<String, WcToiletClean> wcToiletCleanMap = WcToiletCleanCacheManager.wcToiletCleanMap;
        Date now=new Date();
        for (WcToiletClean wcToiletClean : wcToiletCleanMap.values()) {
            String starttime = wcToiletClean.getStarttime();
            Date startdate = DateUtil.stringToDate(starttime, "yyyy/MM/dd HH:mm:ss");
            long second = DateUtil.getDayBySecondDate(startdate, now);
            if(second>49){
                wctoiletcleansize+=1;
            }
        }
        toiletCada.setToiletcleansize(wctoiletcleansize);
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

            long second=DateUtil.getDayBySecondDate(fromday,now);
          //  System.out.println(wcDeviceHeart.getParams().getReaderID()+",延迟="+second);
            if(second < 40){
                //线程安全
                wcdeviceonlinesize+=1;
            }
        }
        toiletCada.setWcdeviceonlinesize(wcdeviceonlinesize);
        modelMap.addAttribute("wcdeviceonlinesize",wcdeviceonlinesize);

        return toiletCada;
    }
}
