package com.pan.security;

import com.pan.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * 创建自定义的security来覆盖默认的security功能
 * Created by Administrator on 2017-3-22.
 */

@Profile("dev") //如果使用的配置文件是开发文件application-dev.properties的话，那么激活本类，否则不激活
@Configuration
@EnableWebSecurity
public class SecurityConfigDev extends WebSecurityConfigurerAdapter {
    @Autowired
    private ReaderRepository readerRepository;

    protected  void configure(HttpSecurity http) throws Exception{
        http.csrf().disable();//不加这一句就一直报Could not verify the provided CSRF token because your session was not found.
        //要求访问路径/read/*的用户必须有reader角色
        //其他的路径都允许访问permit
        //设置登录表单的路径
        http.authorizeRequests()
                .antMatchers("/**").permitAll()
                .and()
                .formLogin().loginPage("/login")
                .failureUrl("/login?error=true");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
                return readerRepository.findOne(userName);
            }
        });
    }
}
