package com.cloud.vongoauth.shiro;


import com.cloud.vongoauth.dto.ShiroAuthDto;
import com.cloud.vongoauth.entity.vUser;
import com.cloud.vongoauth.service.VUserService;
import com.cloud.vongoauth.service.impl.VUserServiceImpl;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;

/**
 * @version 6.1.8
 * @author: Abraham Vong
 * @date: 2021.4.26
 * @GitHub https://github.com/AbrahamTemple/
 * @description: Shiro认证核心业务
 */
public class UserRealm extends AuthorizingRealm {

    @Resource
    VUserService vUserService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken LoginToken = (UsernamePasswordToken) token;
        vUser vUserName = vUserService.getByUserName(LoginToken.getUsername());
        //数据库该用户名
        if (vUserName == null) {
            throw new UnknownAccountException();
        }
        ShiroAuthDto dto = new ShiroAuthDto(vUserName, vUserName.getPassword(), String.valueOf(LoginToken.getPassword()), null);
        if (new BCryptPasswordEncoder().matches(dto.getClearCode(), dto.getEncryptionCode())) {
            dto.setCredentials(dto.getClearCode()); //比对明码再加盐值
        }
        if (dto.getCredentials() == null){
            throw new IncorrectCredentialsException();//抛出密码错误异常
        }
        dto.setSalt(ByteSource.Util.bytes(LoginToken.getUsername()));
        dto.setRealmName(getName());
        return new SimpleAuthenticationInfo(dto.getPrincipal(), dto.getCredentials(), dto.getSalt(), dto.getRealmName());
    }
}
