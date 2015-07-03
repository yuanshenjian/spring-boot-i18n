package org.yood.springboot.i18n.web;


import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.yood.springboot.i18n.service.I18nService;

@RestController
public class I18nController {


    @Autowired
    private I18nService i18nService;


    @RequestMapping(value = "companies/{companyId}",method = RequestMethod.GET)
    public ResponseEntity showCompanyName(@PathVariable String companyId){
        String companyName = i18nService.getMessage("thoughtworks.name");
        JSONObject result = new JSONObject();
        result.put("companyName",companyName);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}

