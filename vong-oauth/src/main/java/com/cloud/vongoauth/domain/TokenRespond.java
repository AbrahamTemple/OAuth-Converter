package com.cloud.vongoauth.domain;

import com.cloud.vongoauth.vo.TokenBody;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * @version 6.1.8
 * @author: Abraham Vong
 * @date: 2021.4.13
 * @GitHub https://github.com/AbrahamTemple/
 * @description: Access Token响应式对象
 */

@Getter
public class TokenRespond {

    private final Integer okStatus = 200;

    private final Integer failStatus = 500;

    private final String nonUserMsg = "用户不存在";

    private final String passErrMsg = "密码错误";

    private final String okAuthMsg = "认证成功";

    private final String badAuthMsg = "认证失败";

}