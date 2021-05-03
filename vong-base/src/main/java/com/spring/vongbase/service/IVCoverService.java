package com.spring.vongbase.service;

import com.spring.vongbase.entity.VCover;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Abraham
 * @since 2021-05-01
 */
public interface IVCoverService extends IService<VCover> {
    public List<VCover> getCoverByUserName(String name);
}
