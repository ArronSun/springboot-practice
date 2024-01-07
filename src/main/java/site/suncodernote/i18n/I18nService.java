package site.suncodernote.i18n;

import java.util.Locale;
import java.util.Map;

/**
 * @author sunlong
 * @date 2024/1/6 22:03
 */
public interface I18nService {

    /**
     * 获取指定语言所有国际化信息
     * @param locale
     * @return
     */
    Map<String, String> getAllMessages(Locale locale);

}
