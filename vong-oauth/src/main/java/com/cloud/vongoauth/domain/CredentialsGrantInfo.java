package com.cloud.vongoauth.domain;

import com.cloud.vongoauth.vo.OAuthGrantInfo;
import lombok.Setter;

/**
 * @version 6.1.8
 * @author: Abraham Vong
 * @date: 2021.4.26
 * @GitHub https://github.com/AbrahamTemple/
 * @description: OAuth2密码模式认证请求参数
 */
@Setter
public class CredentialsGrantInfo extends OAuthGrantInfo {


    private static final Integer port = 8077;

    private static final String client_id = "clients";

    private static final  String client_secret = "secrets";

    private static final String host = "localhost";

    private static final String type = "client_credentials";

    private static final String scopes = "app";

    /**
     *  创建实例
     * @return
     */
    public static CredentialsGrantInfo getInstance() {
        return SingletonHolder.sInstance;
    }

    /**
     * 静态内部类单例模式
     */
    private static class SingletonHolder {
        private static final CredentialsGrantInfo sInstance = new CredentialsGrantInfo(port,host,type,client_id,client_secret,scopes);
    }

    /**
     * 将这些参数传递给父类
     * @param port
     * @param host
     * @param type
     * @param clientId
     * @param clientSecret
     * @param scopes
     */
    public CredentialsGrantInfo(Integer port, String host, String type, String clientId, String clientSecret, String scopes) {
        super(port, host, type, clientId, clientSecret,scopes);
    }

    /**
     * 返回构造的OAuth认证访问地址
     * @return
     */
    @Override
    public String toString() {
        return super.toString() +
                "/oauth/token?grant_type=" + super.getType() +
                "&client_id=" + super.getClientId() +
                "&client_secret=" + super.getClientSecret() +
                "&scopes=" + super.getScopes();
    }
}
