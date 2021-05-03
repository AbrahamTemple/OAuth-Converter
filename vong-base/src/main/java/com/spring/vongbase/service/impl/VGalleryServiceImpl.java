package com.spring.vongbase.service.impl;

import com.spring.vongbase.entity.VGallery;
import com.spring.vongbase.mapper.VGalleryMapper;
import com.spring.vongbase.service.IVGalleryService;
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
public class VGalleryServiceImpl extends ServiceImpl<VGalleryMapper, VGallery> implements IVGalleryService {

    @Override
    public List<VGallery> getGalleryByUserId(Long id) {
        return super.baseMapper.getLeftJoinByUserId(id);
    }
}
