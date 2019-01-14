package com.bkgd.toiletdemo.controller;

import com.bkgd.toiletdemo.POJO.ToiletCadaList;
import com.bkgd.toiletdemo.POJO.WcDeviceHeart;
import com.bkgd.toiletdemo.POJO.WcToiletClean;
import com.bkgd.toiletdemo.cache.WcDeviceCacheManager;
import com.bkgd.toiletdemo.cache.WcDeviceHeartCacheManager;
import com.bkgd.toiletdemo.cache.WcToiletCacheManager;
import com.bkgd.toiletdemo.cache.WcToiletCleanCacheManager;
import com.bkgd.toiletdemo.model.WcDevice;
import com.bkgd.toiletdemo.model.WcToilet;
import com.bkgd.toiletdemo.util.DateUtil;
import org.springframework.stereotype.Controller;
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
                if(second < 40){
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
     * 实时信息， 公厕所在设备心跳和保洁数据以及延迟数据
     * @return
     */
    @RequestMapping("/cadalist")
    @ResponseBody
    public List<ToiletCadaList> getCadaList(){

        try {
            List<ToiletCadaList>  cada=null;
            //有数据设备
            Map<String, WcDeviceHeart> wcDeviceHeartMap = WcDeviceHeartCacheManager.wcDeviceHeartMap;
            if(wcDeviceHeartMap.values().size()>0){
                cada=new ArrayList<ToiletCadaList>();
            }else {
                return null;
            }
            Date now = new Date();
            for(WcDeviceHeart wcDeviceHeart:wcDeviceHeartMap.values()){
                ToiletCadaList toiletCadaList=new ToiletCadaList();
                toiletCadaList.setWcDeviceHeart(wcDeviceHeart);
                WcDevice wcDevice = WcDeviceCacheManager.wcDeviceMap.get(wcDeviceHeart.getParams().getReaderID());
                WcToilet wcToilet = WcToiletCacheManager.wcToiletMap.get(wcDevice.getTid());

                WcToiletClean wctoiletclean = WcToiletCleanCacheManager.wcToiletCleanMap.get(wcToilet.getCid());
                toiletCadaList.setWcToilet(wcToilet);
                toiletCadaList.setWcDevice(wcDevice);
                toiletCadaList.setWcToiletClean(wctoiletclean);

                String heartstemp = wcDeviceHeart.getParams().getTimeStamp();
                Date heartdate = DateUtil.stringToDate(heartstemp, "yyyy/MM/dd HH:mm:ss");

                toiletCadaList.setHeartdelay(now.getTime()-heartdate.getTime());//心跳延迟 毫秒
                if(wctoiletclean!=null){
                    String cleanstemp =  wctoiletclean.getParams().getTimeStamp();
                    Date cleansdate = DateUtil.stringToDate(cleanstemp, "yyyy/MM/dd HH:mm:ss");
                    toiletCadaList.setCleandelay(now.getTime()-cleansdate.getTime());//保洁延迟 毫秒
                }else{
                    toiletCadaList.setCleandelay(0);//保洁延迟 毫秒
                }
                cada.add(toiletCadaList);
            }
            return cada;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
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
