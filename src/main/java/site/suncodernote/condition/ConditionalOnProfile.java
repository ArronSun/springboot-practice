package site.suncodernote.condition;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * author: long.sun
 * date 2023/12/29 10:21
 */
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Conditional(site.sunlong.condition.OnProfileCondition.class)
public @interface ConditionalOnProfile {

    String value();

}
