package lt.codeacademy.blog.service;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    private final MessageSource messageSource;

    public MessageService(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String getMessage(String messageKey){
        if(messageKey == null){
            return null;
        }
        return messageSource.getMessage(messageKey, null, LocaleContextHolder.getLocale());
    }
}
