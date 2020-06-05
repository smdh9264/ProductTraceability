package com.pt.ptauth.endpoint;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.StrUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.data.redis.core.ConvertingCursor;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.http.HttpHeaders;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2RefreshToken;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * token相关服务
 * @author wl
 * @date 2020/5/19
 */
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/token")
public class TokenEndPoint {

//    private final TokenStore tokenStore;
//    private final RedisTemplate redisTemplate;
//    private final CacheManager cacheManager;
//
//    /**
//     * 退出并删除token
//     *
//     * @param authHeader Authorization
//     */
//    @DeleteMapping("/logout")
//    public R logout(@RequestHeader(value = HttpHeaders.AUTHORIZATION, required = false) String authHeader) {
//        if (StrUtil.isBlank(authHeader)) {
//            return R.ok();
//        }
//
//        String tokenValue = authHeader.replace(OAuth2AccessToken.BEARER_TYPE, StrUtil.EMPTY).trim();
//        return removeToken(tokenValue);
//    }
//
//    /**
//     * 令牌管理调用
//     *
//     * @param token token
//     */
//
//    @DeleteMapping("/{token}")
//    public R removeToken(@PathVariable("token") String token) {
//        OAuth2AccessToken accessToken = tokenStore.readAccessToken(token);
//        if (accessToken == null || StrUtil.isBlank(accessToken.getValue())) {
//            return R.ok();
//        }
//
//        OAuth2Authentication auth2Authentication = tokenStore.readAuthentication(accessToken);
//        // 清空用户信息
//        cacheManager.getCache(CacheConstants.USER_DETAILS)
//                .evict(auth2Authentication.getName());
//
//        // 清空access token
//        tokenStore.removeAccessToken(accessToken);
//
//        // 清空 refresh token
//        OAuth2RefreshToken refreshToken = accessToken.getRefreshToken();
//        tokenStore.removeRefreshToken(refreshToken);
//        return R.ok();
//    }
//
//
//    /**
//     * 查询token
//     *
//     * @param params 分页参数
//     * @return
//     */
//    @PostMapping("/page")
//    public R tokenList(@RequestBody Map<String, Object> params) {
//        //根据分页参数获取对应数据
//        String key = String.format("%sauth_to_access:*", CacheConstants.PROJECT_OAUTH_ACCESS);
//        List<String> pages = findKeysForPage(key, MapUtil.getInt(params, CommonConstants.CURRENT)
//                , MapUtil.getInt(params, CommonConstants.SIZE));
//
//        redisTemplate.setKeySerializer(new StringRedisSerializer());
//        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
//        Page result = new Page(MapUtil.getInt(params, CommonConstants.CURRENT), MapUtil.getInt(params, CommonConstants.SIZE));
//        result.setRecords(redisTemplate.opsForValue().multiGet(pages));
//        result.setTotal(redisTemplate.keys(key).size());
//        return R.ok(result);
//    }
//
//
//    private List<String> findKeysForPage(String patternKey, int pageNum, int pageSize) {
//        ScanOptions options = ScanOptions.scanOptions().count(1000L)
//                .match(patternKey).build();
//        RedisSerializer<String> redisSerializer = (RedisSerializer<String>) redisTemplate.getKeySerializer();
//        Cursor cursor = (Cursor) redisTemplate.executeWithStickyConnection(redisConnection -> new ConvertingCursor<>(redisConnection.scan(options), redisSerializer::deserialize));
//        List<String> result = new ArrayList<>();
//        int tmpIndex = 0;
//        int startIndex = (pageNum - 1) * pageSize;
//        int end = pageNum * pageSize;
//
//        assert cursor != null;
//        while (cursor.hasNext()) {
//            if (tmpIndex >= startIndex && tmpIndex < end) {
//                result.add(cursor.next().toString());
//                tmpIndex++;
//                continue;
//            }
//            if (tmpIndex >= end) {
//                break;
//            }
//            tmpIndex++;
//            cursor.next();
//        }
//
//        try {
//            cursor.close();
//        } catch (IOException e) {
//            log.error("关闭cursor 失败");
//        }
//        return result;
//    }
}
