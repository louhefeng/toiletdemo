package com.bkgd.toiletdemo.POJO;

/**
 * com.bkgd.toiletdemo.POJO
 *  公厕实时数据参数
 * @author lhf
 * @date 2019/1/10
 * @time 9:32
 * @project_name toiletdemo
 */
public class Param {

    private String id;
    /**
     * rfid标签ID
     */
    private String targID;
    /**
     * 读头ID
     */
    private String readerID;
    /**
     * 信号量
     */
    private String rssi;
    /**
     * 是否低电量
     */
    private String lowBattery;
    /**
     * RFID Server收到该条数据的时间年/月/日 时:分:秒
     */
    private String timeStamp;
    /**
     * 当前数据包的包ID，标签每发一个包，都会在下一个包的ID加1，到255后，从0开始重新循环累加。
     */
    private String packID;
    /**
     * 厕所id
     */
    private String cId;

    //get set method


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTargID() {
        return targID;
    }

    public void setTargID(String targID) {
        this.targID = targID;
    }

    public String getReaderID() {
        return readerID;
    }

    public void setReaderID(String readerID) {
        this.readerID = readerID;
    }

    public String getRssi() {
        return rssi;
    }

    public void setRssi(String rssi) {
        this.rssi = rssi;
    }

    public String getLowBattery() {
        return lowBattery;
    }

    public void setLowBattery(String lowBattery) {
        this.lowBattery = lowBattery;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getPackID() {
        return packID;
    }

    public void setPackID(String packID) {
        this.packID = packID;
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }
}
