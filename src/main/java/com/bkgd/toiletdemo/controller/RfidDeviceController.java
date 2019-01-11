package com.bkgd.toiletdemo.controller;

import com.bkgd.toiletdemo.POJO.WcDeviceHeart;
import com.bkgd.toiletdemo.cache.WcDeviceCacheManager;
import com.bkgd.toiletdemo.cache.WcDeviceHeartCacheManager;
import com.bkgd.toiletdemo.model.WcDevice;
import com.bkgd.toiletdemo.util.DateUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * com.bkgd.toiletdemo.controller
 *  rfid设备在线状态展示
 *  在线设备展示
 * @author lhf
 * @date 2019/1/11
 * @time 11:19
 * @project_name toiletdemo
 */
@Controller
@RequestMapping("/rfid")
public class RfidDeviceController {




    @RequestMapping("/online")
    public String showOnline(){
        return "rfidonline";
    }
    /**
     * rfid设备在线数据
     * @return
     */
    @RequestMapping("/getOline")
    @ResponseBody
    public List<WcDevice> getOnline(){
        try {
            List<WcDevice> onlinDevice=new ArrayList<WcDevice>();
            Map<String, WcDeviceHeart> heartmap = WcDeviceHeartCacheManager.wcDeviceHeartMap;
            for (WcDeviceHeart wcDeviceHeart : heartmap.values()) {
                String timeStamp=wcDeviceHeart.getParams().getTimeStamp();
                Date fromday = DateUtil.stringToDate(timeStamp, "yyyy/MM/dd HH:mm:ss");
                Date now=new Date();
                long second=DateUtil.getDayBySecondDate(fromday,now);
                //  System.out.println(wcDeviceHeart.getParams().getReaderID()+",延迟="+second);
                //在线状态判断
                if(second < 20){
                    WcDevice wcdevice = WcDeviceCacheManager.wcDeviceMap.get(wcDeviceHeart.getParams().getReaderID());
                    onlinDevice.add(wcdevice);
                }
            }
            System.out.println("在线数量"+onlinDevice.size());
            return onlinDevice;
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
    /**
     * rfid设备列表，在线离线状态展示
     * @return
     */
    @RequestMapping("/list")
    public String showlist(){
        try {

        }catch (Exception e){
            e.printStackTrace();
        }
        return "rfidlist";
    }

}
