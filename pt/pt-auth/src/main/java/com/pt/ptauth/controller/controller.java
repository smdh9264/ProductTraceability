package com.pt.ptauth.controller;


import cn.hutool.core.util.StrUtil;
import com.pt.ptcommon.constant.CacheConstants;
import com.pt.ptdealeruser.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2RefreshToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("token")
public class controller {



    @Autowired
    TokenStore tokenStore;
    @Autowired
    CacheManager cacheManager;

    @GetMapping("/test")
    public SysUser test(){
        System.out.println("1");
        SysUser sysUser = new SysUser();
        sysUser.setId("1");
        return sysUser;
//        remoteUserService.test(username);
    }
    /**
     * 退出并删除token
     *
     * @param authHeader Authorization
     */
    @DeleteMapping("/logout")
    public ResponseEntity<Boolean> logout(@RequestHeader(value = HttpHeaders.AUTHORIZATION, required = false) String authHeader) {
        if (StrUtil.isBlank(authHeader)) {
            return ResponseEntity.ok(true);
        }

        String tokenValue = authHeader.replace(OAuth2AccessToken.BEARER_TYPE, StrUtil.EMPTY).trim();
        return removeToken(tokenValue);
    }
    /**
     * 令牌管理调用
     *
     * @param token token
     */
    @DeleteMapping("/{token}")
    public ResponseEntity<Boolean> removeToken(@PathVariable("token") String token) {
        OAuth2AccessToken accessToken = tokenStore.readAccessToken(token);
        if (accessToken == null || StrUtil.isBlank(accessToken.getValue())) {
            return ResponseEntity.ok(true);
        }

        OAuth2Authentication auth2Authentication = tokenStore.readAuthentication(accessToken);
        // 清空用户信息
        cacheManager.getCache(CacheConstants.USER_DETAILS)
                .evict(auth2Authentication.getName());

        // 清空access token
        tokenStore.removeAccessToken(accessToken);

        // 清空 refresh token
        OAuth2RefreshToken refreshToken = accessToken.getRefreshToken();
        tokenStore.removeRefreshToken(refreshToken);
        return ResponseEntity.ok(true);
    }

}
