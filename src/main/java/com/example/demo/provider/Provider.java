package com.example.demo.provider;


import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 〈〉
 *
 * @author ljx
 * @version 1.0.0
 * @create 2022/6/16 11:21
 */
@Component
public class Provider {

	@Resource
	private AmqpTemplate amqpTemplate;

	@Value("${rabbitmq.queue.name}")
	private String queueName;

	// 1: 定义交换机
	private String exchangeName = "ttl_exchange";
	// 2: 路由key
	private String routeKey = "demo.topic";

	public void send() {
		String msg = "hello world!";
//		amqpTemplate.convertAndSend(queueName, msg);
		//消息设置过期时间
//		MessagePostProcessor postProcessor = new MessagePostProcessor() {
//			@Override
//			public Message postProcessMessage(Message message) throws AmqpException {
//				message.getMessageProperties().setExpiration("5000");//ms
//				message.getMessageProperties().setContentEncoding("UTF-8");
//				return message;
//			}
//		};
//		amqpTemplate.convertAndSend(exchangeName, routeKey, msg, postProcessor);
		amqpTemplate.convertAndSend(exchangeName, routeKey, msg);
	}
}