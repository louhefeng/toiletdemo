package com.bkgd.toiletdemo.runner;

import com.bkgd.toiletdemo.cache.WcToiletCacheManager;
import com.bkgd.toiletdemo.dao.WcToiletDao;
import com.bkgd.toiletdemo.model.WcToilet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * com.bkgd.toiletdemo.runner
 *公厕数据初始化话到内存中
 * @author lhf
 * @date 2019/1/9
 * @time 17:33
 * @project_name toiletdemo
 */
@Component
public class WcToiletRunner implements CommandLineRunner {

    @Autowired
    private WcToiletDao wcToiletDao;
    @Override
    public void run(String... args) throws Exception {
        System.out.println("初始化公厕数据到内存中....");

        List<WcToilet> wctoiletList = wcToiletDao.selectWctoilet();
        System.out.println(wctoiletList.size()+"获取结果数量");
        WcToiletCacheManager.wcToiletMap=wctoiletList.stream().collect(Collectors.toMap(WcToilet::getTid,wcToilet -> wcToilet));
        System.out.println("Map打印："+Arrays.toString(WcToiletCacheManager.wcToiletMap.entrySet().toArray()));
    }
}
