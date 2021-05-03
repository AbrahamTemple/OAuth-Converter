package com.spring.vongbase.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.spring.vongbase.entity.VUser;
import com.spring.vongbase.entity.VUserCover;
import com.spring.vongbase.mapper.VUserCoverMapper;
import com.spring.vongbase.service.IVUserCoverService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Abraham
 * @since 2021-05-01
 */
@Service
public class VUserCoverServiceImpl extends ServiceImpl<VUserCoverMapper, VUserCover> implements IVUserCoverService {
}
