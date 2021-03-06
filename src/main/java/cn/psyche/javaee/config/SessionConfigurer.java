package cn.psyche.javaee.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;


@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 3000)
public class SessionConfigurer {

}
