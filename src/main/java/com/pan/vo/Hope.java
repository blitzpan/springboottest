package com.pan.vo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by Administrator on 2017-3-16.
 */

@ConfigurationProperties(prefix = "hope.default")
@PropertySource("classpath:config.properties")
public class Hope {
    private String date;
    private String hope;

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Hope{" +
                "date='" + date + '\'' +
                ", hope='" + hope + '\'' +
                '}';
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHope() {
        return hope;
    }

    public void setHope(String hope) {
        this.hope = hope;
    }
}
