package org.yood.springboot.i18n.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.yood.springboot.i18n.service.I18nService;

import java.util.Locale;


@Service
public class I18nServiceImpl implements I18nService {


    private static final Logger LOGGER = LoggerFactory.getLogger(I18nServiceImpl.class);


    @Autowired
    private MessageSource messageSource;

    @Override
    public String getMessage(String id) {
        Locale locale = LocaleContextHolder.getLocale();
        LoggerFactory.getLogger("monitor").info(locale.toString());
        LOGGER.info("============locale:"+locale.getDisplayLanguage()+"==========");
        String result = messageSource.getMessage(id, null, "no valid message", locale);
        LOGGER.info("============result:"+result+"==========");

        return result;
    }
}
