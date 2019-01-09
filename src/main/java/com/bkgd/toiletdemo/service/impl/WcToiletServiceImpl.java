package com.bkgd.toiletdemo.service.impl;

import com.bkgd.toiletdemo.dao.WcToiletDao;
import com.bkgd.toiletdemo.model.WcToilet;
import com.bkgd.toiletdemo.service.WcToiletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * com.bkgd.toiletdemo.service.impl
 *
 * @author lhf
 * @date 2019/1/9
 * @time 15:36
 * @project_name toiletdemo
 */
@Service
public class WcToiletServiceImpl implements WcToiletService {

    @Autowired
    private WcToiletDao wcToiletDao;

    @Override
    public List<WcToilet> selectWcToile() {
        return wcToiletDao.selectWctoilet();
    }
}
