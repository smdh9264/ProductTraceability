package com.pt.ptauth.feign;

import com.pt.ptdealeruser.dto.UserInfo;
import com.pt.ptdealeruser.entity.SysUser;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

/**
 * @author wl
 */

public interface RemoteUserFeignClient {
    @RequestLine("GET /user/info/{username}")
    UserInfo info(@Param("username") String username );
    @RequestLine("GET /test")
    @Headers("Accept: {contentType}")
    SysUser test();
}
