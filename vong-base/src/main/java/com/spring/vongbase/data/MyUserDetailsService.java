package com.spring.vongbase.data;

import com.spring.vongbase.entity.VPermission;
import com.spring.vongbase.entity.VUser;
import com.spring.vongbase.service.IVPermissionService;
import com.spring.vongbase.service.IVUserService;
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
    private IVUserService vUserService;

    @Resource
    private IVPermissionService vPermissionService;

    /**
     * 从数据库中查找并赋予SpringSecurity对应登录用户的信息
     * @param name
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        VUser loginUser = vUserService.getByUserName(name);
        if(loginUser==null) {
            throw new UsernameNotFoundException(name + "用户名不存在");
        }
        List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
        List<VPermission> vPermissions = vPermissionService.selectByUserId(loginUser.getId());
        vPermissions.forEach( vp ->{
            System.out.println(vp.getEnableName());
            roles.add(new SimpleGrantedAuthority(vp.getEnableName()));
        });
        return new User(loginUser.getUsername(),loginUser.getPassword(),roles);
    }
}
