package com.spring.vongbase.mapper;

import com.spring.vongbase.entity.VPermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Abraham
 * @since 2021-05-01
 */
public interface VPermissionMapper extends BaseMapper<VPermission> {

    @Select("SELECT p.* FROM v_user AS u "+
            "    LEFT JOIN v_user_role AS ur ON u.id = ur.user_id " +
            "    LEFT JOIN v_role AS r ON r.id = ur.role_id " +
            "    LEFT JOIN v_role_permission AS rp ON r.id = rp.role_id " +
            "    LEFT JOIN v_permission AS p ON rp.permission_id = p.id " +
            "    WHERE u.id = #{id}")
    public List<VPermission> getLeftJoinByUserId(@Param("id") Long id);
}
