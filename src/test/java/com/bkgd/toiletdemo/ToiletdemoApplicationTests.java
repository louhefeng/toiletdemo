package com.bkgd.toiletdemo;

import com.bkgd.toiletdemo.dao.WcToiletDao;
import com.bkgd.toiletdemo.model.WcToilet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ToiletdemoApplicationTests {

    @Autowired
    private WcToiletDao wcToiletDao;
    @Test
    public void contextLoads() {
        List<WcToilet> toilelist = wcToiletDao.selectWctoilet();
        System.out.println(toilelist.size());
    }

}

