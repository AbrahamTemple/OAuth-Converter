package com.cloud.vongoauth.data;

import com.cloud.vongoauth.entity.vPermission;
import com.cloud.vongoauth.entity.vUser;
import com.cloud.vongoauth.service.impl.VPermissionServiceImpl;
import com.cloud.vongoauth.service.impl.VUserServiceImpl;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Resource
    private VUserServiceImpl vUserService;

    @Resource
    private VPermissionServiceImpl vPermissionService;

    /**
     * 从数据库中查找并赋予SpringSecurity对应登录用户的信息
     * @param name
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        vUser loginUser = vUserService.getByUserName(name);
        if(loginUser==null) {
            throw new UsernameNotFoundException(name + "用户名不存在");
        }
        List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
        List<vPermission> vPermissions = vPermissionService.selectByUserId(loginUser.getId());
        vPermissions.forEach( vp ->{
            System.out.println(vp.getEnableName());
            roles.add(new SimpleGrantedAuthority(vp.getEnableName()));
        });
        return new User(loginUser.getUsername(),loginUser.getPassword(),roles);
    }
}
