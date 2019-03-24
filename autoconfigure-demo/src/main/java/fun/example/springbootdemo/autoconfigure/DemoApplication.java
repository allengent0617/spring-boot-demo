package fun.example.springbootdemo.autoconfigure;

import fun.example.springbootdemo.autoconfigure.annotation.DatabaseType;
import fun.example.springbootdemo.autoconfigure.dao.JdbcUserDAOImpl;
import fun.example.springbootdemo.autoconfigure.dao.MongoUserDAOImpl;
import fun.example.springbootdemo.autoconfigure.dao.UserDAO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLOutput;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        System.setProperty("dbType", "MYSQL");
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    @DatabaseType("MySQL")
    public UserDAO jdbcUserDAO() {
        return new JdbcUserDAOImpl();
    }

    @Bean
    @DatabaseType("Mongo")
    public UserDAO mongoUserDAO() {
        return new MongoUserDAOImpl();
    }
}
