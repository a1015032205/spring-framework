package com.md.spring01.circulardependencies.constructorDemo;

/**
 * @Author: 秒度
 * @Email: fangxin.md@Gmail.com
 * @Date: 2020-12-29 22:01
 * @Description: 循环依赖
 */
//https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-dependencies
//构造器注入没有办法解决循环依赖， 你想让构造器注入支持循环依赖，是不存在的
public class ConDemo {
	public static void main(String[] args) {
		//new ServerA(new ServerB(new ServerA()));
	}
}
