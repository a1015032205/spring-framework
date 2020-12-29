package com.md.spring01.circulardependencies.setDemo;

/**
 * @Author: 秒度
 * @Email: fangxin.md@Gmail.com
 * @Date: 2020-12-29 22:07
 * @Description: set注入
 */

public class SetText {
	public static void main(String[] args) {
		ServerA serverA = new ServerA();
		ServerB serverB = new ServerB();

		//A 里面设置了B
		serverA.setServerB(serverB);
		//B 里面设置了A
		serverB.setServerA(serverA);
	}
}
