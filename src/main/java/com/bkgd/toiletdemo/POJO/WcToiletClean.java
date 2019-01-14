package com.bkgd.toiletdemo.POJO;

/**
 * com.bkgd.toiletdemo.POJO
 *公厕保洁数据对象
 * @author lhf
 * @date 2019/1/9
 * @time 18:23
 * @project_name toiletdemo
 */
public class WcToiletClean {

    /**
     * 方法名
     */
    private String method;
    /**
     * 发送方标识ID
     */
    private String id;
    /**
     * 版本号
     */
    private String version;
    /**
     * 详细参数
     */
    private Param params;

    /**
     * 保洁开始时间.2s不持续
     * @return
     */
    private String starttime;

    //get set method
    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Param getParams() {
        return params;
    }

    public void setParams(Param params) {
        this.params = params;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }
}
