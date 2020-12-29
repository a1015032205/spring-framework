package com.md.spring01.circulardependencies.setDemo;

import org.springframework.stereotype.Component;

/**
 * @Author: 秒度
 * @Email: fangxin.md@Gmail.com
 * @Date: 2020-12-29 21:56
 * @Description:
 */
@Component
public class ServerB {

	private ServerA serverA;

	public void setServerA(ServerA serverA) {
		this.serverA = serverA;
		System.out.println("B 里面设置了A");
	}


}
