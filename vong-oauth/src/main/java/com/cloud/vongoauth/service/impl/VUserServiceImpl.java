package com.cloud.vongoauth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cloud.vongoauth.entity.vUser;
import com.cloud.vongoauth.mapper.VUserMapper;
import com.cloud.vongoauth.service.VUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @version 6.1.8
 * @author: Abraham Vong
 * @date: 2021.4.1
 * @GitHub https://github.com/AbrahamTemple/
 * @description: 用户表业务
 */
@Service
public class VUserServiceImpl implements VUserService {

    @Resource
    private VUserMapper vUserMapper;

    public vUser getByUserName(String username) {
        QueryWrapper<vUser> userInfo = new QueryWrapper<vUser>().eq("username", username);
        return vUserMapper.selectOne(userInfo);
    }

}
