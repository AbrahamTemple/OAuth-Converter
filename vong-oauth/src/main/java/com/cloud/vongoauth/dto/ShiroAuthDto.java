package com.cloud.vongoauth.dto;

import com.cloud.vongoauth.entity.vUser;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apache.shiro.util.ByteSource;

/**
 * @version 6.1.8
 * @author: Abraham Vong
 * @date: 2021.4.26
 * @GitHub https://github.com/AbrahamTemple/
 * @description: Shiro认证对象
 */

@Data
public class ShiroAuthDto {

    private vUser principal;
    private String encryptionCode;
    private String clearCode;
    private String credentials;

    private ByteSource salt;
    private String realmName;

    public ShiroAuthDto(vUser principal, String encryptionCode, String clearCode, String credentials) {
        this.principal = principal;
        this.encryptionCode = encryptionCode;
        this.clearCode = clearCode;
        this.credentials = credentials;
    }
}
