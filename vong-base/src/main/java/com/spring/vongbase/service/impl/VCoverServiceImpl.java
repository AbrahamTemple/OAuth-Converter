package com.spring.vongbase.service.impl;

import com.spring.vongbase.entity.VCover;
import com.spring.vongbase.mapper.VCoverMapper;
import com.spring.vongbase.service.IVCoverService;
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
public class VCoverServiceImpl extends ServiceImpl<VCoverMapper, VCover> implements IVCoverService {

    @Override
    public List<VCover> getCoverByUserName(String name) {
        return super.baseMapper.getLeftJoinByUserName(name);
    }
}
