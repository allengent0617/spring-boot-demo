package fun.example.spring.boot.autoconfigure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import javax.annotation.PostConstruct;

/**
 * @author zhoujian
 * @date 2019/3/21
 */
@Configuration
@ConditionalOnClass({ JedisPool.class, Jedis.class, JedisPoolConfig.class})
@EnableConfigurationProperties({JedisProperties.class})
@AutoConfigureAfter({JedisProperties.class})
public class JedisAutoConfigure {
    @Autowired
    private JedisProperties jedisProperties;
    @PostConstruct
    public void checkConfigFileExists()
    {
    }
    @Bean
    @ConfigurationProperties(prefix = "spring.jedis")
    public JedisPoolConfig jedisPoolConfig(){
        return new JedisPoolConfig();
    }
    @Bean
    public JedisPool jedisPool(JedisPoolConfig jedisPoolConfig){
        return new JedisPool(jedisPoolConfig,
                jedisProperties.getHost(),
                jedisProperties.getPort(),
                jedisProperties.getTimeout());
    }
}
