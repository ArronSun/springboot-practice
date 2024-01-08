package site.suncodernote.condition;


import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * author: long.sun
 * date 2023/12/29 10:42
 */
@Component
public class ConditionConfig {


    @Bean
    @ConditionalOnProfile("dev")
    ProfileConditionBean devConditionBean(){
        System.out.println("----------");
        return new DevConditionBean();
    }


    @Bean
    @ConditionalOnProfile("prod")
    ProfileConditionBean prodConditionBean(){
        System.out.println("==========");
        return new ProdConditionBean();
    }



}
