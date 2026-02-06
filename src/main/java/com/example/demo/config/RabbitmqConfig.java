package com.example.demo.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 〈〉
 *
 * @author ljx
 * @version 1.0.0
 * @create 2022/6/16 11:14
 */
@Configuration
public class RabbitmqConfig {

	@Value("${rabbitmq.queue.name}")
	private String queueName;

	//队列
	@Bean
	public Queue topicQueue() {
		// durable:是否持久化,默认是false,持久化队列：会被存储在磁盘上，当消息代理重启时仍然存在，暂存队列：当前连接有效
		// exclusive:默认也是false，只能被当前创建的连接使用，而且当连接关闭后队列即被删除。此参考优先级高于durable
		// autoDelete:是否自动删除，当没有生产者或者消费者使用此队列，该队列会自动删除。
		//   return new Queue("TestDirectQueue",true,true,false);
		//一般设置一下队列的持久化就好,其余两个就是默认false
		return new Queue("topic.queue", true);
	}

	//交换机   通过返回值切换模式
	@Bean
	public TopicExchange topicExchange() {
		return new TopicExchange("topic_exchange", true, false);
	}

	//绑定  将队列和交换机绑定, 并设置用于匹配
	@Bean
	public Binding bindingDirect() {
		return BindingBuilder.bind(topicQueue()).to(topicExchange()).with("*.topic");
	}
}