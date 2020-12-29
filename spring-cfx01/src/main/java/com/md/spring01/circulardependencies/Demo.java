package com.md.spring01.circulardependencies;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: 秒度
 * @Email: fangxin.md@Gmail.com
 * @Date: 2020-12-29 22:21
 * @Description: 循环依赖
 */

/**
 * nested exception is org.springframework.beans.factory.BeanCurrentlyInCreationException:
 * Error creating bean with name 'a': 578624778
 * Requested bean is currently in creation: Is there an unresolvable circular reference?
 * <p>
 * <p>
 * 只有单例的bean会通过三级缓存提前暴露来解决循环依赖的问题，因为单例的时候只有一份，随时复用，那么就放到缓存里面
 * 而多例的bean，每次从容器中荻取都是—个新的对象，都会重B新创建，
 * 所以非单例的bean是没有缓存的，不会将其放到三级缓存中。
 */
public class Demo {
	public static void main(String[] args) {
		//默认的单例(singleton)的场景是支持循环依赖的，不报错
		//默认单例，修改为原型scope="prototype" 就导致了循环依赖错误
		/*	 {@code DefaultSingletonBeanRegistry }*/
		//TODO  只有单例的bean会通过三级缓存提前暴露来解决循环依赖问题，而非单例的bean，每次从容器中获取都是一个新的对象
		// 都会重新创建，所以非单例的bean是没有缓存的，不会将其放在三级缓存中
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("circulardependencies.xml");
		A a = context.getBean("a", A.class);
		B b = context.getBean("b", B.class);
		//Exception in thread "main" org.springframework.beans.factory.BeanCreationException:
		// Error creating bean with name 'a' defined in class path resource

		//实例化： 申请一块内存空间
		//初始化：属性赋值

		//4个方法 getSingleton->doCreateBean->populateBean->addSingleton

		//TODO 三级缓存+四大方法
		// 1.getSingleton：希望从容器里面获得单例的bean，没有的话
		// 2.doCreateBean: 没有就创建bean
		// 3.populateBean: 创建完了以后，要填充属性
		// 4.addSingleton: 填充完了以后，再添加到容器进行使用
		//TODO
		// 第一层singletonObjects存放的是已经初始化好了的Bean,
		// 第二层earlySingletonObjects存放的是实例化了，但是未初始化的Bean,
		// 第三层singletonFactories存放的是FactoryBean。假如A类实现了FactoryBean,那么依赖注入的时候不是A类，而是A类产生的Bean

		//todo
		// A/B 2对象在三级缓存中的迁移说明
		// 1 A创建过程中需要B，于是A将自己放到三级缓存里面，去实例化B
		// 2 B实例化的时候发现需要A，于是B先查一级缓存，没有，再查二级缓存，还是没有，再查三级缓存，找到了A
		// 然后把三级缓存里面的这个A放到二级缓存里面，并删除三级缓存里面的A
		// 3 B顺利初始化完毕，将自己放到一级缓存里面（此时B里面的A依然是创建中状态）
		// 然后回来接着创建A，此时B已经创建结束，直接从一级缓存里面拿到B，然后完成创建，并将A自己放到一级缓存里面。

	}
}
