package com.bkgd.toiletdemo.POJO;

/**
 * com.bkgd.toiletdemo.POJO
 * 统计
 * @author lhf
 * @date 2019/1/14
 * @time 11:01
 * @project_name toiletdemo
 */
public class ToiletCada {
    private long wctoiletsize;//总
    private long toiletcleansize;//已保洁
    private long wcdeviceonlinesize;//在线设备

    public long getWctoiletsize() {
        return wctoiletsize;
    }

    public void setWctoiletsize(long wctoiletsize) {
        this.wctoiletsize = wctoiletsize;
    }

    public long getToiletcleansize() {
        return toiletcleansize;
    }

    public void setToiletcleansize(long toiletcleansize) {
        this.toiletcleansize = toiletcleansize;
    }

    public long getWcdeviceonlinesize() {
        return wcdeviceonlinesize;
    }

    public void setWcdeviceonlinesize(long wcdeviceonlinesize) {
        this.wcdeviceonlinesize = wcdeviceonlinesize;
    }
}
