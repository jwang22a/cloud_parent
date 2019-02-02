package com.eurekaclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
//由于springcloud启动类默认扫描自己所在的包，如果不在同一包下需加注解扫描
@ComponentScan(basePackages = {"jwang.controller"})
public class EurakeClientApplication {
	public static void main(String[] args) {
		SpringApplication.run(EurakeClientApplication.class, args);
	}
}
