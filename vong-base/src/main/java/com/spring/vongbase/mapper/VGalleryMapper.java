package com.spring.vongbase.mapper;

import com.spring.vongbase.entity.VGallery;
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
public interface VGalleryMapper extends BaseMapper<VGallery> {

    @Select("SELECT g.* FROM v_cover AS c " +
            "LEFT JOIN v_cover_gallery AS ug ON c.id = ug.cover_id " +
            "LEFT JOIN v_gallery AS g ON ug.gallery_id = g.id " +
            "WHERE c.id = #{id}")
    public List<VGallery> getLeftJoinByUserId(@Param("id") Long id);
}
