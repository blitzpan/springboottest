package com.pan;

import com.pan.vo.Hope;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({Hope.class})
public class SpringboottestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringboottestApplication.class, args);
	}
}
