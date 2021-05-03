package com.spring.vongbase.mapper;

import com.spring.vongbase.entity.VCover;
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
public interface VCoverMapper extends BaseMapper<VCover> {

    @Select("SELECT c.* FROM v_user AS u " +
            "LEFT JOIN v_user_cover AS uc ON u.id = uc.user_id " +
            "LEFT JOIN v_cover AS c ON c.id = uc.cover_id " +
            "WHERE u.username = #{name}")
    public List<VCover> getLeftJoinByUserName(@Param("name") String name);
}
