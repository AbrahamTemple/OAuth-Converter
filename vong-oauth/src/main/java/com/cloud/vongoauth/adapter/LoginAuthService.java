package com.cloud.vongoauth.adapter;

import com.cloud.vongoauth.vo.RestResponse;
import com.cloud.vongoauth.vo.TokenBody;

/**
 * @version 6.1.8
 * @author: Abraham Vong
 * @date: 2021.4.27
 * @GitHub https://github.com/AbrahamTemple/
 * @description: 登录认证服务
 */
public interface LoginAuthService {
    public RestResponse<TokenBody> auth(String username, String password, String clientId, String clientSecret);
}
