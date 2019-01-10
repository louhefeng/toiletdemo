package com.bkgd.toiletdemo;

import com.bkgd.toiletdemo.util.DateUtil;

import java.util.Date;

/**
 * com.bkgd.toiletdemo
 *
 * @author lhf
 * @date 2019/1/10
 * @time 16:11
 * @project_name toiletdemo
 */
public class OtherTest {


    public static void main(String[] args) {

        Date fromday = DateUtil.stringToDate("2019/01/10 14:34:33", "yyyy/MM/dd HH:mm:ss");
        Date today = DateUtil.stringToDate("2019/01/10 14:34:34", "yyyy/MM/dd HH:mm:ss");
       long secondDate= DateUtil.getDayBySecondDate(fromday,today);
        System.out.println(secondDate);
    }
}
