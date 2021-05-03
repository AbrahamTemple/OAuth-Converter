package com.cloud.vongoauth.service;


import com.cloud.vongoauth.entity.vPermission;

import java.util.List;

public interface VPermissionService {
    public List<vPermission> selectByUserId(Long id);
}
