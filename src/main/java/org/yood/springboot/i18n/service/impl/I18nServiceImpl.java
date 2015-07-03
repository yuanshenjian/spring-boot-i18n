package org.yood.springboot.i18n.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.yood.springboot.i18n.service.I18nService;

import java.util.Locale;


@Service
public class I18nServiceImpl implements I18nService {


    @Autowired
    private MessageSource messageSource;

    @Override
    public String getMessage(String id) {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(id,null,locale);
    }
}
