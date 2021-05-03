package com.cloud.vongoauth.rest;

import com.cloud.vongoauth.adapter.CodeAuthService;
import com.cloud.vongoauth.adapter.LoginAuthService;
import com.cloud.vongoauth.vo.RestResponse;
import com.cloud.vongoauth.vo.TokenBody;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 主认证控制类
 */
@CrossOrigin
@RestController
@RequestMapping("/o")
public class OAuthController {

    @Resource
    LoginAuthService loginAuthService;

    @Resource
    CodeAuthService codeAuthService;

    /**
     * 密码模式请求token
     * @param username 用户名
     * @param password 密码
     * @return access_token
     */
    @RequestMapping("/pass")
    public RestResponse<TokenBody> getPassToken(@RequestParam String username, @RequestParam String password,
                                                @RequestParam String clientId, @RequestParam String clientSecret){
        return loginAuthService.auth(username,password,clientId,clientSecret);
    }

    /**
     * 授权码模式请求token
     * 获取token请访问 http://localhost:8077/oauth/authorize?client_id=client&response_type=code
     * @param code  授权码
     * @return access_token
     */
    @RequestMapping("/code")
    public RestResponse<TokenBody> getCodesToken(@RequestParam String code){
        return codeAuthService.codes(code);
    }

    /**
     * 请求code，中继映射请求获取token
     * @return  access_token
     */
    @RequestMapping("/code/get")
    public RestResponse<TokenBody> getCodes(){
        return codeAuthService.gets();
    }

    /**
     * 获取Spring Security绑定的用户表信息
     * @return 返回除去密码的所有信息
     */
    @RequestMapping("/info")
    public Object info(){
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

//    @PreAuthorize("hasAuthority('VONG_IMG')")
//    @GetMapping("apply")
//    public String applyOrder(){
//        return "图片相册权限";
//    }
//
//    @PreAuthorize("hasAuthority('VONG_MUSIC')")
//    @GetMapping("apply2")
//    public String applyOrder2(){
//        return "免费听歌权限";
//    }
}
