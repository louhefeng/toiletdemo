package com.bkgd.toiletdemo.POJO;

/**
 * com.bkgd.toiletdemo.POJO
 *
 * @author lhf
 * @date 2019/1/10
 * @time 15:33
 * @project_name toiletdemo
 */
public class WcDeviceHeart {

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

    //get set

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
}
