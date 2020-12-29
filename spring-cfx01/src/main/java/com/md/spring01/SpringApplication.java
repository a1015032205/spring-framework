package com.md.spring01;

import com.md.spring01.entity.Person;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: 秒度
 * @Email: fangxin.md@Gmail.com
 * @Date: 2020-12-29 21:00
 * @Description:
 */

public class SpringApplication {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
		Person person = context.getBean("person", Person.class);
		System.err.println(person.getName());
	}
}
