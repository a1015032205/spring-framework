package com.md.spring01.circulardependencies;

import org.springframework.stereotype.Component;

/**
 * @Author: 秒度
 * @Email: fangxin.md@Gmail.com
 * @Date: 2020-12-29 21:56
 * @Description:
 */
@Component
public class A {

	private B serverB;

	public void setServerB(B serverB) {
		this.serverB = serverB;
		System.out.println("A 里面设置了B");
	}
}
