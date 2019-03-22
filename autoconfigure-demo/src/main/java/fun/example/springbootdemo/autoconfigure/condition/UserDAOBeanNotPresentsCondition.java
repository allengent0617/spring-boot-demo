package fun.example.springbootdemo.autoconfigure.condition;

import fun.example.springbootdemo.autoconfigure.dao.UserDAO;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author zhoujian
 * @date 2019/3/20
 */

public class UserDAOBeanNotPresentsCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata metadata) {
        UserDAO userDAO = conditionContext.getBeanFactory().getBean(UserDAO.class);
        return (userDAO == null);
    }
}
