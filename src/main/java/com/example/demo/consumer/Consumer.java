package com.example.demo.consumer;


import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 〈〉
 *
 * @author ljx
 * @version 1.0.0
 * @create 2022/6/16 11:22
 */
@Component
//// bindings其实就是用来确定队列和交换机绑定关系  注解与配置类使用一个即可
//@RabbitListener(bindings = @QueueBinding(
//		// topic.queue 是队列名字，
//		value = @Queue(value = "topic.queue", autoDelete = "false"),
//		// topic_exchange 交换机的名字 必须和生产者保持一致
//		exchange = @Exchange(value = "topic_exchange",
//				// 这里是确定的rabbitmq模式是：topic   type 切换模式
//				type = ExchangeTypes.TOPIC),
//		key = "*.topic" //根据模式配置
//))
public class Consumer {

	@RabbitListener(queues = {"topic.queue"})  //配置类使用的注解
//	@RabbitHandler   //注解配置是使用的注解
	public void receiveMessages(String msg) {
		System.out.println("接收到的消息：" + msg);
	}
}