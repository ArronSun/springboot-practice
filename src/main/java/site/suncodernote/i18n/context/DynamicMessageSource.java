package site.suncodernote.i18n.context;

import org.springframework.context.support.AbstractMessageSource;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author sunlong
 * @date 2024/1/6 23:28
 */
public class DynamicMessageSource extends AbstractMessageSource {


    private Map<Locale, Map<String , String>> cachedNames = new ConcurrentHashMap<>();

    public DynamicMessageSource(Map<Locale, Map<String , String>> cachedNames) {
        this.cachedNames = cachedNames;
    }

    public DynamicMessageSource() {
    }



    @Override
    protected MessageFormat resolveCode(String code, Locale locale) {
        if (cachedNames.containsKey(locale)) {
            Map<String, String> map = cachedNames.get(locale);
            if (map.containsKey(code)) {
                String message = map.get(code);
                return createMessageFormat(message, locale);
            }
        }
        return null;
    }
}
