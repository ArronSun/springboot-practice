package site.sunlong.springbootpractice;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import site.sunlong.config.MovieSiteTemplate;

@SpringBootTest
class SpringbootPracticeApplicationTests {

    @Resource
    private MovieSiteTemplate movieSiteTemplate;

    @Test
    void contextLoads() {
        movieSiteTemplate.openSite();
    }

}
