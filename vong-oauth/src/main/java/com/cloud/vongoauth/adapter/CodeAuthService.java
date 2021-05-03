package com.cloud.vongoauth.adapter;

import com.cloud.vongoauth.vo.RestResponse;
import com.cloud.vongoauth.vo.TokenBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @version 6.1.8
 * @author: Abraham Vong
 * @date: 2021.4.27
 * @GitHub https://github.com/AbrahamTemple/
 * @description: 授权服务
 */
public interface CodeAuthService {
    public RestResponse<TokenBody> codes(String code);
    public RestResponse<TokenBody> gets();
}
