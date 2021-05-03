package com.cloud.vongoauth.service.impl;

import com.cloud.vongoauth.dto.PermissionsDto;
import com.cloud.vongoauth.entity.vPermission;
import com.cloud.vongoauth.mapper.VPermissionMapper;
import com.cloud.vongoauth.service.VPermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @version 6.1.8
 * @author: Abraham Vong
 * @date: 2021.4.1
 * @GitHub https://github.com/AbrahamTemple/
 * @description: 权限表业务
 */
@Service
public class VPermissionServiceImpl implements VPermissionService {

    @Resource
    private VPermissionMapper vPermissionMapper;

    public List<vPermission> selectByUserId(Long id) {
        return new PermissionsDto(vPermissionMapper.selectByLeftUserId(id)).PermissionsIfExist();
    }
}
