package com.cloud.vongoauth.adapter.impl;

import com.cloud.vongoauth.adapter.LoginAuthService;
import com.cloud.vongoauth.domain.CredentialsGrantInfo;
import com.cloud.vongoauth.domain.TokenRespond;
import com.cloud.vongoauth.vo.OAuthGrantInfo;
import com.cloud.vongoauth.vo.RestResponse;
import com.cloud.vongoauth.vo.TokenBody;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @version 6.1.8
 * @author: Abraham Vong
 * @date: 2021.4.27
 * @GitHub https://github.com/AbrahamTemple/
 * @description: 登录认证适配器
 */
@Service
public class LoginAuthAdapter extends TokenRespond implements LoginAuthService {

    protected OAuthGrantInfo instance;

    /**
     * shiro登录认证，结束后再请求密码模式的token
     * @param username 用户名
     * @param password 密码
     * @return access_token
     */

    @Override
    public RestResponse<TokenBody> auth(String username, String password, String clientId, String clientSecret) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
        } catch (UnknownAccountException e){
            return new RestResponse<TokenBody>(getFailStatus(),getNonUserMsg(),null);
        } catch (IncorrectCredentialsException e){
            System.out.println(e.getLocalizedMessage());
            return new RestResponse<TokenBody>(getFailStatus(),getPassErrMsg(),null);
        } catch (Exception e){
            return new RestResponse<TokenBody>(getFailStatus(),getBadAuthMsg(),null);
        }
        instance = CredentialsGrantInfo.getInstance();
        instance.setClientId(clientId);
        instance.setClientSecret(clientSecret);
        TokenBody body = new RestTemplate().getForObject(instance.toString(), TokenBody.class);
        return new RestResponse<TokenBody>(getOkStatus(), getOkAuthMsg(), body);
    }
}
