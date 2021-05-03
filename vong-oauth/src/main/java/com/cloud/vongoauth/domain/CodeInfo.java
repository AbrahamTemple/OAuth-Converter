package com.cloud.vongoauth.domain;

import com.cloud.vongoauth.vo.OAuthGrantInfo;
import lombok.Setter;

/**
 * @version 6.1.8
 * @author: Abraham Vong
 * @date: 2021.4.26
 * @GitHub https://github.com/AbrahamTemple/
 * @description: 得到OAuth2授权码
 */

@Setter
public class CodeInfo extends OAuthGrantInfo{

    private static final Integer port = 8077;

    private static final String host = "localhost";

    private static final String type = "code";

    private static final String client_id = "client";

    public CodeInfo(Integer port, String host, String type, String clientId) {
        super(port, host, type, clientId);
    }

    /**
     *  创建实例
     * @return
     */
    public static CodeInfo getInstance() {
        return SingletonHolder.sInstance;
    }

    /**
     * 静态内部类单例模式
     */
    private static class SingletonHolder {
        private static final CodeInfo sInstance = new CodeInfo(port,host,type,client_id);
    }

    /**
     * 请求Code的认证地址
     * @return
     */
    @Override
    public String toString() {
        return "http://" + super.getHost() + ":" + super.getPort() +
                "/oauth/authorize?client_id=" + super.getClientId() +
                "&response_type=" + super.getType();
    }
}
