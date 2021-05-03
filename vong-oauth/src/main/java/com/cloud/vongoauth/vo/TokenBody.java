package com.cloud.vongoauth.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @version 6.1.8
 * @author: Abraham Vong
 * @date: 2021.4.27
 * @GitHub https://github.com/AbrahamTemple/
 * @description: Access Token对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TokenBody implements Serializable {
    private String access_token;
    private String token_type;
    private Integer expires_in;
    private String scope;
}
