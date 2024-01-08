package site.suncodernote.condition;

import org.springframework.stereotype.Component;

/**
 * author: long.sun
 * date 2023/12/29 10:43
 */
public class DevConditionBean implements ProfileConditionBean {


    @Override
    public void printProfile() {
        System.out.println("dev condition");
    }
}
