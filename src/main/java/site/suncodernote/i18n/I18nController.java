package site.suncodernote.i18n;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;
import java.util.Map;

/**
 * @author sunlong
 * @date 2024/1/6 22:29
 */
@RequestMapping("/i18n")
@RestController
public class I18nController {

    @Resource
    private I18nService i18nService;

    @RequestMapping("/messages")
    public Map<String, String> getAllMessages(@RequestHeader(name = "Accept-Language" , required = false) Locale locale) {
        return i18nService.getAllMessages(locale);
    }



}
