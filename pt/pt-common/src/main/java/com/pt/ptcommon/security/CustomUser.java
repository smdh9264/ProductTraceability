package com.pt.ptcommon.security;


import lombok.Getter;
import lombok.Setter;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * @author wl
 * @date 2020/5/19
 * 扩展用户信息
 */
public class CustomUser extends User {
    /**
     * 用户ID
     */
    @Getter
    private String id;

    @Getter
    @Setter
    private String clientId;

    @Getter
    @Setter
    private String deptId;

    /**
     * Construct the <code>User</code> with the details required by
     * {@link DaoAuthenticationProvider}.
     *
     * @param id                    用户ID
     * @param username              the username presented to the
     *                              <code>DaoAuthenticationProvider</code>
     * @param password              the password that should be presented to the
     *                              <code>DaoAuthenticationProvider</code>

     * @param authorities           the authorities that should be granted to the caller if they
     *                              presented the correct username and password and the user is enabled. Not null.
     * @throws IllegalArgumentException if a <code>null</code> value was passed either as
     *                                  a parameter or as an element in the <code>GrantedAuthority</code> collection
     */
    public CustomUser(String id, String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.id = id;
    }

    public CustomUser(String id, String username, String password, String clientId,Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.id = id;
        this.clientId = clientId;
    }

    public CustomUser(String id, String username, String password, String deptId,String clientId,Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.id = id;
        this.clientId = clientId;
        this.deptId = deptId;
    }
}