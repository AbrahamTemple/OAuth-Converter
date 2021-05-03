package com.cloud.vongoauth.adapter.impl;

import com.cloud.vongoauth.adapter.CodeAuthService;
import com.cloud.vongoauth.domain.CodeGrantInfo;
import com.cloud.vongoauth.domain.CodeInfo;
import com.cloud.vongoauth.domain.TokenRespond;
import com.cloud.vongoauth.vo.OAuthGrantInfo;
import com.cloud.vongoauth.vo.RestResponse;
import com.cloud.vongoauth.vo.TokenBody;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @version 6.1.8
 * @author: Abraham Vong
 * @date: 2021.4.27
 * @GitHub https://github.com/AbrahamTemple/
 * @description: 授权服务适配器
 */
@Service
public class CodeAuthAdapter extends TokenRespond implements CodeAuthService {

    protected OAuthGrantInfo instance;

    /**
     * RestTemple访问构建好的授权模式认证地址
     * @param code 授权码
     * @return access_token
     */
    @Override
    public RestResponse<TokenBody> codes(String code) {
        instance = CodeGrantInfo.getInstance();
        instance.setCodes(code);
        TokenBody body = new RestTemplate().getForObject(instance.toString(), TokenBody.class);
        return new RestResponse<TokenBody>(getOkStatus(),getOkAuthMsg(),body);
    }

    /**
     * 返回code，自动映射请求 http://localhost:8077/o/code
     * @return code
     */
    @Override
    public RestResponse<TokenBody> gets() {
        instance = CodeInfo.getInstance();
        TokenBody body = new RestTemplate().getForObject(instance.toString(), TokenBody.class);
        return new RestResponse<TokenBody>(getOkStatus(),getOkAuthMsg(),body);
    }
}
