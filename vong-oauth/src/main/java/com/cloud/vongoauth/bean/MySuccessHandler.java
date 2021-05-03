package com.cloud.vongoauth.bean;

import org.apache.catalina.security.SecurityUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @version 6.1.8
 * @author: Abraham Vong
 * @date: 2021.4.28
 * @GitHub https://github.com/AbrahamTemple/
 * @description:
 */
@Component
public class MySuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        RequestCache cache = new HttpSessionRequestCache();
        SavedRequest savedRequest = cache.getRequest(request, response);
        String url = savedRequest==null?"http://localhost:8077/o/info":savedRequest.getRedirectUrl();
        System.out.println(url);
        response.sendRedirect(url);
    }
}
