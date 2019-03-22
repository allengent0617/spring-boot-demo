package fun.example.springbootdemo.autoconfigure.dao;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhoujian
 * @date 2019/3/20
 */
public class JdbcUserDAOImpl implements UserDAO {
    @Override
    public List<String> getAllUserNames() {
        System.out.println("**** Getting usernames from RDBMS *****");
        return Arrays.asList("Siva","Prasad","Reddy");
    }
}
