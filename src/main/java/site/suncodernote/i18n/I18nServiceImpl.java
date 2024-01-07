package site.suncodernote.i18n;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author sunlong
 * @date 2024/1/6 22:04
 */
@Service
public class I18nServiceImpl implements I18nService{

    @Autowired
    private MessageSource messageSource;
    @Autowired
    private ReloadableResourceBundleMessageSource reloadableResourceBundleMessageSource;

    @Override
    public Map<String, String> getAllMessages(Locale locale) {
        if (locale == null) {
            locale = Locale.getDefault();
        }
        //存放所有message
        Map<String, String> messages = new HashMap<>();

        ResourceBundleMessageSource bundleMessageSource = (ResourceBundleMessageSource) messageSource;
        String[] basenames = bundleMessageSource.getBasenameSet().toArray(new String[0]);

        for (String basename : basenames) {
            //从缓存中获取资源文件
            ResourceBundle resourceBundle = ResourceBundle.getBundle(basename, locale);
            //获取资源文件的所有code
            Set<String> keys = resourceBundle.keySet();

            for (String key : keys) {
                //根据code获取对应的message
                String message = messageSource.getMessage(key, null, locale);
                messages.put(key, message);
            }
        }
        return messages;
    }


    

    public void addMessage(String code, String text, Locale locale) {
        // 获取已加载的属性文件集合
//        Properties properties = reloadableResourceBundleMessageSource.getMergedProperties(locale);
        // 向集合中添加新的属性和值
//        properties.setProperty(code, text);
        // 重新加载属性文件
//        reloadableResourceBundleMessageSource.refreshProperties();
    }
    
}
