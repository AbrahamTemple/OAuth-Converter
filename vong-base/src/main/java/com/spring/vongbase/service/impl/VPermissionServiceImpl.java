package com.spring.vongbase.service.impl;

import com.spring.vongbase.entity.VPermission;
import com.spring.vongbase.mapper.VPermissionMapper;
import com.spring.vongbase.service.IVPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Abraham
 * @since 2021-05-01
 */
@Service
public class VPermissionServiceImpl extends ServiceImpl<VPermissionMapper, VPermission> implements IVPermissionService {

    @Override
    public List<VPermission> selectByUserId(Long id) {
        return super.baseMapper.getLeftJoinByUserId(id);
    }
}
