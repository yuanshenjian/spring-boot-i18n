package org.yood.springboot.i18n;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.yood.springboot.i18n.util.EncodingUtils;

import java.util.Locale;


@SpringBootApplication
public class SpringBootI18nApplication {

    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver resolver = new SessionLocaleResolver();
        resolver.setDefaultLocale(Locale.US);
        return resolver;
    }


    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:locale/messages");
        messageSource.setDefaultEncoding(EncodingUtils.UTF_8);
        messageSource.setCacheSeconds(0);
        return messageSource;
    }


    public static void main(String[] args) {
        SpringApplication.run(SpringBootI18nApplication.class, args);
    }
}
