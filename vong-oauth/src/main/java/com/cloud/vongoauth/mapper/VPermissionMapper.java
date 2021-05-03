package com.cloud.vongoauth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.vongoauth.entity.vPermission;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface VPermissionMapper extends BaseMapper<vPermission> {
    /*SELECT p.* FROM v_user AS u
    LEFT JOIN v_user_role AS ur ON u.id = ur.user_id
    LEFT JOIN v_role AS r ON r.id = ur.role_id
    LEFT JOIN v_role_permission AS rp ON r.id = rp.role_id
    LEFT JOIN v_permission AS p ON rp.permission_id = p.id
    WHERE u.id = ?*/

    @Select("SELECT p.* FROM v_user AS u "+
            "    LEFT JOIN v_user_role AS ur ON u.id = ur.user_id " +
            "    LEFT JOIN v_role AS r ON r.id = ur.role_id " +
            "    LEFT JOIN v_role_permission AS rp ON r.id = rp.role_id " +
            "    LEFT JOIN v_permission AS p ON rp.permission_id = p.id " +
            "    WHERE u.id = #{id}")
    public List<vPermission> selectByLeftUserId(@Param("id") Long id);
}
