package com.example.demo.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈〉
 *
 * @author ljx
 * @version 1.0.0
 * @create 2022/6/16 11:14
 */
@Configuration
public class TtlQueueConfig {

	@Bean
	public Queue ttlQueue() {
		//设置过去时间ms
		Map<String, Object> map = new HashMap<>(2);
		map.put("x-message-ttl", 5000);
		//配置死信队列
		map.put("x-dead-letter-exchange", "dead_exchange");
		return new Queue("ttl.queue", true, false, false, map);
	}

	//交换机
	@Bean
	public TopicExchange ttlExchange() {
		return new TopicExchange("ttl_exchange", true, false);
	}

	//绑定  将队列和交换机绑定
	@Bean
	public Binding ttlBindingDirect() {
		return BindingBuilder.bind(ttlQueue()).to(ttlExchange()).with("*.topic");
	}
}