package com.spring.vongbase.service;

import com.spring.vongbase.entity.VPermission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Abraham
 * @since 2021-05-01
 */
public interface IVPermissionService extends IService<VPermission> {
    public List<VPermission> selectByUserId(Long id);
}
