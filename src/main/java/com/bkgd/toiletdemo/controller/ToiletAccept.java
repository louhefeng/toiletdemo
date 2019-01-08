package com.bkgd.toiletdemo.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * com.bkgd.toiletdemo.controller
 *公厕实时数据接收
 * @author lhf
 * @date 2019/1/8
 * @time 14:28
 * @project_name toiletdemo
 */
@Component
@RequestMapping("/")
public class ToiletAccept {

    /**
     * 接收
     * @return  0、失败,1、成功
     */
    @RequestMapping("/rfid")
    @ResponseBody
    private String accept(String param){
        //1转换数据
        //2解析数据
        //3整理数据
        //4数据放入内存中
        //5返回成功或者失败
        return "";
    }
}
