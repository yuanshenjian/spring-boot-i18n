package org.yood.springboot.i18n.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.yood.springboot.i18n.SpringBootI18nApplication;

import static org.junit.Assert.assertEquals;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringBootI18nApplication.class)
public class I18nServiceTest {

    @Autowired
    private I18nService i18nService;

    @Test
    public void testGetMessage() throws Exception {
        String id = "thoughtwors.name";
        String message = i18nService.getMessage(id);
        assertEquals("ThoughtWorks,lnc.",message);
    }
}