package com.cloud.vongoauth.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class vRolePermission {

    @TableId(type = IdType.AUTO)
    private Long id;
    private int roleId;
    private int permissionId;
}
