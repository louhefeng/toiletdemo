package com.bkgd.toiletdemo.POJO;

import com.bkgd.toiletdemo.util.DateUtil;

/**
 * com.bkgd.toiletdemo.POJO
 *  成功返回
 * @author lhf
 * @date 2019/1/10
 * @time 10:05
 * @project_name toiletdemo
 */
public class SuccessResponse extends ResPonse{
    private String result;

    public SuccessResponse(){
    }

    public SuccessResponse(String id){
        this.id=id;
        this.result= DateUtil.getCurrentDateTime("yyyy/MM/dd HH:mm:ss");
    }

    //GET SET METHOD


    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
