package com.example.demo.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 死信队列
 *
 * @author ljx
 * @version 1.0.0
 * @create 2022/6/16 15:42
 */
@Configuration
public class DeadQueueConfig {

	@Bean
	public Queue deadQueue() {
		return new Queue("dead.queue", true);
	}

	//交换机
	@Bean
	public TopicExchange deadExchange() {
		return new TopicExchange("dead_exchange", true, false);
	}

	//绑定  将队列和交换机绑定
	@Bean
	public Binding deadBindingDirect() {
		return BindingBuilder.bind(deadQueue()).to(deadExchange()).with("*.topic");
	}
}