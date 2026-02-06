# RabbitMQ 消息队列系统

## 项目概述

这是一个基于 Spring Boot 和 RabbitMQ 构建的消息队列系统项目。该项目演示了多种 RabbitMQ 高级特性，包括普通消息队列、死信队列和 TTL（Time To Live）队列的实现。

## 技术栈

- Spring Boot 2.5.0
- Spring AMQP
- RabbitMQ
- Java 8

## 核心功能

### 1. 基础消息队列
- 使用 Topic Exchange 实现主题路由模式
- 配置了普通队列 `topic.queue` 和交换机 `topic_exchange`
- 支持通配符匹配的消息路由规则 `*.topic`

### 2. 死信队列
- 配置了死信队列 `dead.queue` 和交换机 `dead_exchange`
- 用于处理无法正常消费的消息
- 提供消息可靠性的保障机制

### 3. TTL 队列（Time To Live）
- 配置了带过期时间的队列 `ttl.queue`，消息过期时间为 5 秒
- 过期消息自动转移到死信队列进行处理
- 防止消息积压和提高系统效率

## 项目结构

```
src/main/java/com/example/demo/
├── config/
│   ├── RabbitmqConfig.java     # 基础队列配置
│   ├── DeadQueueConfig.java    # 死信队列配置
│   └── TtlQueueConfig.java     # TTL队列配置
├── consumer/
│   ├── Consumer.java           # 消息消费者
│   └── ConsumerController.java # 消费者控制器
├── provider/
│   ├── Provider.java           # 消息生产者
│   └── ProviderController.java # 生产者控制器
└── RabbitmqApplication.java    # 应用启动类
```

## 配置说明

### RabbitMQ 连接配置
- Host: `192.168.152.128`
- Port: `5672`
- Username: `root`
- Password: `root`

### 消息确认机制
- 启用了发布确认机制 (`publisher-confirm-type: correlated`)
- 启用了手动 ACK 确认模式
- 配置了最大重试次数为 3 次，重试间隔为 2 秒

## 主要特性

1. **消息可靠性** - 通过确认机制确保消息不丢失
2. **灵活路由** - 支持 Topic Exchange 的通配符路由
3. **过期处理** - TTL 队列自动处理过期消息
4. **死信处理** - 死信队列处理异常消息
5. **重试机制** - 消费失败时自动重试

## 使用方法

1. 启动 RabbitMQ 服务
2. 修改 `application.yml` 中的连接参数
3. 启动 Spring Boot 应用
4. 通过相应的 Controller 接口发送和接收消息

## 注意事项

- 需要预先安装并启动 RabbitMQ 服务
- 确保网络可以访问 RabbitMQ 服务器
- 根据实际环境修改连接参数
