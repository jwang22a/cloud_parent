package com.eurekafeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;
//
@SpringBootApplication
//添加熔断降级注解
@EnableCircuitBreaker
//注解是为了注册中心能够发现该服务
@EnableDiscoveryClient
//添加@EnableFeignClients注解，使用Feign组件进行远程调用
@EnableFeignClients(basePackages = {"jwang.interfac"})
@ComponentScan(basePackages = {"jwang.controller,jwang.service,jwang.interfac"})
public class EurakeFeginApplication {
	public static void main(String[] args) {
		SpringApplication.run(EurakeFeginApplication.class, args);
	}
	//当添加@LoadBalanced注解，就代表启动Ribbon,进行负载均衡
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
