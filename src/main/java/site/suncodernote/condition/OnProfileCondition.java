package site.suncodernote.condition;

import ch.qos.logback.core.joran.conditional.IfAction;
import org.springframework.boot.autoconfigure.condition.ConditionMessage;
import org.springframework.boot.autoconfigure.condition.ConditionOutcome;
import org.springframework.boot.autoconfigure.condition.ConditionalOnCloudPlatform;
import org.springframework.boot.autoconfigure.condition.SpringBootCondition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

/**
 * author: long.sun
 * date 2023/12/29 10:15
 */
@Order
public class OnProfileCondition extends SpringBootCondition {

    private static final String PROPERTY_NAME = "spring.profiles.active";

    @Override
    public ConditionOutcome getMatchOutcome(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Map<String, Object> attributes = metadata.getAnnotationAttributes(ConditionalOnProfile.class.getName());
        String value = (String) attributes.get("value");
        Environment environment = context.getEnvironment();
        String property = environment.getProperty(PROPERTY_NAME);

        ConditionMessage.Builder message = ConditionMessage.forCondition(ConditionalOnProfile.class);
        ConditionMessage conditionMessage = message.foundExactly(value);
        boolean match = value.equals(property);

        return new ConditionOutcome(match, conditionMessage);
    }
}
