package org.yood.springboot.i18n.web;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.yood.springboot.i18n.SpringBootI18nApplication;
import org.yood.springboot.i18n.service.I18nService;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringBootI18nApplication.class)
public class I18nControllerTest {

    @Mock
    private I18nService i18nService;


    @InjectMocks
    private I18nController i18nController;


    private MockMvc mockMvc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(i18nController).
                alwaysExpect(status().isOk()).
                build();
    }

    @Test
    public void testShowCompanyName() throws Exception {
        String id = "thoughtworks.name";
        String result = "ThoughtWorks,lnc.";
        when(i18nService.getMessage(id)).thenReturn(result);
        mockMvc.perform(get("/companies/1").accept(MediaType.APPLICATION_JSON)).
                andExpect(jsonPath("$.companyName", is(result)));
    }
}