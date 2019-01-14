package com.bkgd.toiletdemo.POJO;

import com.bkgd.toiletdemo.model.WcDevice;
import com.bkgd.toiletdemo.model.WcToilet;

/**
 * com.bkgd.toiletdemo.POJO
 * 统计类
 * @author lhf
 * @date 2019/1/14
 * @time 10:16
 * @project_name toiletdemo
 */
public class ToiletCadaList {

    private WcToilet wcToilet;
    private WcDevice wcDevice;
    private WcDeviceHeart wcDeviceHeart;
    private WcToiletClean wcToiletClean;
    private long heartdelay;
    private long cleandelay;
    //get set method

    public WcToilet getWcToilet() {
        return wcToilet;
    }

    public void setWcToilet(WcToilet wcToilet) {
        this.wcToilet = wcToilet;
    }

    public WcDevice getWcDevice() {
        return wcDevice;
    }

    public void setWcDevice(WcDevice wcDevice) {
        this.wcDevice = wcDevice;
    }

    public WcDeviceHeart getWcDeviceHeart() {
        return wcDeviceHeart;
    }

    public void setWcDeviceHeart(WcDeviceHeart wcDeviceHeart) {
        this.wcDeviceHeart = wcDeviceHeart;
    }

    public WcToiletClean getWcToiletClean() {
        return wcToiletClean;
    }

    public void setWcToiletClean(WcToiletClean wcToiletClean) {
        this.wcToiletClean = wcToiletClean;
    }

    public long getHeartdelay() {
        return heartdelay;
    }

    public void setHeartdelay(long heartdelay) {
        this.heartdelay = heartdelay;
    }

    public long getCleandelay() {
        return cleandelay;
    }

    public void setCleandelay(long cleandelay) {
        this.cleandelay = cleandelay;
    }
}
