package fun.example.springbootdemo.autoconfigure.config;

import fun.example.springbootdemo.autoconfigure.annotation.DatabaseType;
import fun.example.springbootdemo.autoconfigure.dao.JdbcUserDAOImpl;
import fun.example.springbootdemo.autoconfigure.dao.MongoUserDAOImpl;
import fun.example.springbootdemo.autoconfigure.dao.UserDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhoujian
 * @date 2019/3/20
 */

@Configuration
@ComponentScan
public class AppConfig {
    @Bean
    @DatabaseType("MYSQL")
    public UserDAO jdbcUserDAO(){
        return new JdbcUserDAOImpl();
    }
    @Bean
    @DatabaseType("MONGO")
    public UserDAO mongoUserDAO(){
        return new MongoUserDAOImpl();
    }
}
