package site.suncodernote;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import site.suncodernote.i18n.I18nService;
import site.suncodernote.i18n.context.DynamicMessageSource;
import site.sunlong.config.MovieSiteTemplate;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@SpringBootTest
class SpringbootPracticeApplicationTests {

    @Resource
    private MovieSiteTemplate movieSiteTemplate;
    @Resource
    private MessageSource messageSource;
    @Resource
    private I18nService i18nService;

    @Test
    void contextLoads() {
        movieSiteTemplate.openSite();
    }


    @Test
    void testMessageSource() {

        Locale china = Locale.CHINA;
        System.out.println("\n中文环境");
        //中文语言
        String hello_zh = messageSource.getMessage("hello", null, china);
        System.out.println(hello_zh);
        // 占位符替换
        String welcome_zh = messageSource.getMessage("welcome", new String[]{"索码理"}, china);
        System.out.println(welcome_zh);

        //英文语言
        Locale english = Locale.ENGLISH;
        System.out.println("\n英文环境");
        String hello_en = messageSource.getMessage("hello", null, english);
        System.out.println(hello_en);
        String welcome_en = messageSource.getMessage("welcome", new String[]{"suncodernote"}, english);
        System.out.println(welcome_en);

        System.out.println("\n没有对应语言的国际化属性，返回code");
        //没有对应语言的国际化属性，返回code
        String hello_test = messageSource.getMessage("hello-test", null, china);
        System.out.println(hello_test);

        System.out.println("\n没有对应语言的国际化区域时，返回默认语言");
        //没有对应语言的国际化区域时，返回默认
        String hello_fr = messageSource.getMessage("hello", null, Locale.FRANCE);
        System.out.println(hello_fr);

        System.out.println("\n指定语言所有属性");
        Map<String, String> allMessages = i18nService.getAllMessages(china);
        System.out.println(allMessages);
    }


    @Test
    public void testDynamicMessageSource(){
        String code = "dynamic.hello";
        Map<Locale, Map<String , String>> cachedNames = new ConcurrentHashMap<>();

        Locale locale = Locale.forLanguageTag("zh-CN");
        Map<String , String> zhMap = new HashMap<>();
        zhMap.put(code ,"你好!");
        cachedNames.put(locale, zhMap);

        DynamicMessageSource dynamicMessageSource = new DynamicMessageSource(cachedNames);
        String hello = dynamicMessageSource.getMessage(code , null, locale);
        System.out.println(hello);

    }


}
