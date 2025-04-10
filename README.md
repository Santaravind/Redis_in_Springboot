🧠 Redis Integration with Spring Boot – Summary
This project integrates Redis with Spring Boot to enhance performance, scalability, and real-time capabilities. Redis is used in multiple ways:

🔧 Redis Setup
Dependencies (Maven)

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>
For session management:


<dependency>
    <groupId>org.springframework.session</groupId>
    <artifactId>spring-session-data-redis</artifactId>
</dependency>
Configuration (application.properties)

properties

spring.redis.host=localhost
spring.redis.port=6379
spring.cache.type=redis
spring.session.store-type=redis
✅ Use Cases Implemented
1. 🔁 Caching with Redis
Enables method-level caching to reduce DB load.

Annotations used:

@EnableCaching – Activates Spring caching.

@Cacheable – Caches method results.

@CachePut – Updates cache after method execution.

@CacheEvict – Removes entry from cache.

2. 💾 Redis as a Key-Value Store
Custom objects are stored/retrieved using RedisTemplate<String, Object>.

Operations:

opsForValue().set(key, value)

opsForValue().get(key)

delete(key)

3. 🔐 Session Management
User sessions are stored in Redis for scalability across distributed systems.

Set via: spring.session.store-type=redis

4. 📬 Pub/Sub Messaging
Real-time message broadcasting using Redis topics.

Components:

Publisher: redisTemplate.convertAndSend(topic, message)

Subscriber: Implements MessageListener interface.

Configuration: RedisMessageListenerContainer and MessageListenerAdapter.

💡 Other Potential Use Cases
Use Case	Redis Feature
Caching	Spring Cache + Redis
Session Store	spring-session-data-redis
Real-time Messaging	Pub/Sub
Rate Limiting	Redis INCR + EXPIRE
Distributed Locking	Redisson, SETNX
