package com.md.spring01.circulardependencies.setDemo;

import org.springframework.stereotype.Component;

/**
 * @Author: 秒度
 * @Email: fangxin.md@Gmail.com
 * @Date: 2020-12-29 21:56
 * @Description:
 */
@Component
public class ServerA {

	private ServerB serverB;

	public void setServerB(ServerB serverB) {
		this.serverB = serverB;
		System.out.println("A 里面设置了B");
	}
}
