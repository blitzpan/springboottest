package com.pan.po;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Arrays;
import java.util.Collection;

/**
 * 继承UserDetails，这样user就能当成Spring Security的用户了
 * Created by Administrator on 2017-3-22.
 */

@Entity
public class Reader implements UserDetails {
    @Id
    private String username;//username上有id注解，标识这是这个类的唯一标识
    private String fullname;
    private String password;

    /**
     * 这里始终为用户授予reader权限
     * @return
     */
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return Arrays.asList(new SimpleGrantedAuthority("READER"));
    }

    /**
     * 不过期
     * @return
     */
    public boolean isAccountNonExpired(){
        return true;
    }

    /**
     * 不加锁
     * @return
     */
    public boolean isAccountNonLocked(){
        return true;
    }

    /**
     * 证书是否过期
     * @return
     */
    public boolean isCredentialsNonExpired(){
        return true;
    }
    public boolean isEnabled(){
        return true;
    }


    @Override
    public String toString() {
        return "Reader{" +
                "username='" + username + '\'' +
                ", fullname='" + fullname + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
