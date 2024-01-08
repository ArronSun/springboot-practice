package site.suncodernote.condition;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author: long.sun
 * date 2024/1/2 9:11
 */
@RestController
@RequestMapping("test")
public class TestController {

    @Resource
    private ConditionConfig conditionConfig;


    @GetMapping("1")
    public void test1(){

        System.out.println(conditionConfig);
        System.out.println("1");
    }

}
