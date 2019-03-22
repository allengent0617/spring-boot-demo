package fun.example.springbootdemo.autoconfigure.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author zhoujian
 * @date 2019/3/20
 */

public class MongoDbTypePropertyCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata metadata) {
        String dbType = conditionContext.getEnvironment().getProperty("app.dbType");
        return "MONGO".equalsIgnoreCase(dbType);
    }
}
