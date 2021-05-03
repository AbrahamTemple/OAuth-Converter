package com.cloud.vongoauth.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Nullable;
import javax.validation.constraints.Null;

/**
 * @version 6.1.8
 * @author: Abraham Vong
 * @date: 2021.4.26
 * @GitHub https://github.com/AbrahamTemple/
 * @description: OAuth2认证
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OAuthGrantInfo {

    private Integer port;
    private String host;
    private String type;
    private String codes;
    private String clientId;
    private String clientSecret;
    private String scopes;

    public OAuthGrantInfo(Integer port, String host, String type, String clientId) {
        this.port = port;
        this.host = host;
        this.type = type;
        this.clientId = clientId;
    }

    public OAuthGrantInfo(Integer port, String host, String type, String clientId, String clientSecret, String scopes) {
        this.port = port;
        this.host = host;
        this.type = type;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.scopes = scopes;
    }

    /**
     * 拼接访问的url地址
     * @return
     */
    @Override
    public String toString() {
        return "http://"+ host +":" + port ;
    }
}
