package com.spring.vongbase.rest;

import com.spring.vongbase.entity.VCover;
import com.spring.vongbase.entity.VGallery;
import com.spring.vongbase.service.IVCoverService;
import com.spring.vongbase.service.IVGalleryService;
import com.spring.vongbase.service.IVUserService;
import com.spring.vongbase.vo.RestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @version 6.1.8
 * @author: Abraham Vong
 * @date: 2021.4.4
 * @GitHub https://github.com/AbrahamTemple/
 * @description: 资源服务器的主控制类
 */
@Slf4j
@RestController
@CrossOrigin(allowedHeaders = {"Authorization"})
public class ResController {

    @Resource
    IVCoverService ivCoverService;

    @Resource
    IVGalleryService ivGalleryService;

    @Resource
    IVUserService ivUserService;

//    @GetMapping("/user/cover")
//    public RestResponse<List<VCover>> getUserCover(){
//        return new RestResponse<List<VCover>>(HttpStatus.OK.value(), HttpStatus.OK.toString(),ivCoverService.list(null));
//    }

    @RequestMapping("/cover")
    public RestResponse<List<VCover>> getUserCover(){
        String name = ivUserService.getNameByClientId(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
        return new RestResponse<List<VCover>>(HttpStatus.OK.value(), HttpStatus.OK.toString(), ivCoverService.getCoverByUserName(name));
    }

    @RequestMapping("/gall/{id}")
    public RestResponse<List<VGallery>> getCoverGallery(@PathVariable("id") Long id){
        return new RestResponse<List<VGallery>>(HttpStatus.OK.value(), HttpStatus.OK.toString(), ivGalleryService.getGalleryByUserId(id));
    }

    @RequestMapping("/info")
    public Object info(){
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}

