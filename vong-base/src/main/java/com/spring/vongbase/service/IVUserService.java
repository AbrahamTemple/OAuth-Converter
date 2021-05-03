package com.spring.vongbase.service;

import com.spring.vongbase.entity.VUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Abraham
 * @since 2021-05-01
 */
public interface IVUserService extends IService<VUser> {
    public VUser getByUserName(String name);
    public String getNameByClientId(String clientId);
}
