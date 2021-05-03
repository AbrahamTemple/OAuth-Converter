package com.cloud.vongoauth.dto;

import com.cloud.vongoauth.entity.vPermission;
import lombok.*;

import java.util.List;

/**
 * @version 6.1.8
 * @author: Abraham Vong
 * @date: 2021.4.26
 * @GitHub https://github.com/AbrahamTemple/
 * @description: 拥有该权限的用户列表
 */
@Data
@RequiredArgsConstructor
public class PermissionsDto {

    @NonNull
    List<vPermission> vPermissions;

    /**
     * 判断列表是否为空
     * @return
     */
    public List<vPermission> PermissionsIfExist(){
        return this.vPermissions.size()>0?this.vPermissions:null;
    }

}
