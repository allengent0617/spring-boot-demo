package fun.example.springbootdemo.autoconfigure.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author zhoujian
 * @date 2019/3/20
 */
public class MongoDBDatabaseTypeCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext,
                           AnnotatedTypeMetadata annotatedTypeMetadata) {
        String enabledDBType = System.getProperty("dbType");
        return "MongoDB".equalsIgnoreCase(enabledDBType);
    }
}
