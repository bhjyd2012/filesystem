package com.hlsfilesystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hlsfilesystem.mapper")
public class HlsfilesystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(HlsfilesystemApplication.class, args);
	}

}
