package com.spring.vongbase.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.spring.vongbase.entity.VUser;
import com.spring.vongbase.mapper.VUserMapper;
import com.spring.vongbase.service.IVUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Abraham
 * @since 2021-05-01
 */
@Service
public class VUserServiceImpl extends ServiceImpl<VUserMapper, VUser> implements IVUserService {

    @Override
    public VUser getByUserName(String name) {
        return super.getOne(new QueryWrapper<VUser>().eq("username",name));
    }

    @Override
    public String getNameByClientId(String clientId) {
        return super.getOne(new QueryWrapper<VUser>().eq("client_id",clientId)).getUsername();
    }
}
