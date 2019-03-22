package fun.example.springbootdemo.autoconfigure.condition;

import fun.example.springbootdemo.autoconfigure.annotation.DatabaseType;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

/**
 * @author zhoujian
 * @date 2019/3/20
 */
public class DatabaseTypeCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext,
                           AnnotatedTypeMetadata annotatedTypeMetadata) {
        Map<String, Object> annotationAttributes = annotatedTypeMetadata
                .getAnnotationAttributes(DatabaseType.class.getCanonicalName());
        if (annotationAttributes == null) {
            return false;
        }
        String type = (String) annotationAttributes.get("value");
        String enabledType = System.getProperty("dbType", "MySQL");
        return type != null && type.equalsIgnoreCase(enabledType);
    }
}
