package com.bkgd.toiletdemo.model;

import java.util.Date;

public class WcDevice {
    private String devid;

    private String devno;

    private String storeman;

    private String devtype;

    private String tid;

    private String tcode;

    private String tname;

    private String unitcode;

    private String devname;

    private String repaircycle;

    private Date putindate;

    private String picurl;

    private String devparam;

    public String getDevid() {
        return devid;
    }

    public void setDevid(String devid) {
        this.devid = devid == null ? null : devid.trim();
    }

    public String getDevno() {
        return devno;
    }

    public void setDevno(String devno) {
        this.devno = devno == null ? null : devno.trim();
    }

    public String getStoreman() {
        return storeman;
    }

    public void setStoreman(String storeman) {
        this.storeman = storeman == null ? null : storeman.trim();
    }

    public String getDevtype() {
        return devtype;
    }

    public void setDevtype(String devtype) {
        this.devtype = devtype == null ? null : devtype.trim();
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid == null ? null : tid.trim();
    }

    public String getTcode() {
        return tcode;
    }

    public void setTcode(String tcode) {
        this.tcode = tcode == null ? null : tcode.trim();
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname == null ? null : tname.trim();
    }

    public String getUnitcode() {
        return unitcode;
    }

    public void setUnitcode(String unitcode) {
        this.unitcode = unitcode == null ? null : unitcode.trim();
    }

    public String getDevname() {
        return devname;
    }

    public void setDevname(String devname) {
        this.devname = devname == null ? null : devname.trim();
    }

    public String getRepaircycle() {
        return repaircycle;
    }

    public void setRepaircycle(String repaircycle) {
        this.repaircycle = repaircycle == null ? null : repaircycle.trim();
    }

    public Date getPutindate() {
        return putindate;
    }

    public void setPutindate(Date putindate) {
        this.putindate = putindate;
    }

    public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl == null ? null : picurl.trim();
    }

    public String getDevparam() {
        return devparam;
    }

    public void setDevparam(String devparam) {
        this.devparam = devparam == null ? null : devparam.trim();
    }
}