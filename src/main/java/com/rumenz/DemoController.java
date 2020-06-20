package com.rumenz;


import com.sun.org.apache.xpath.internal.objects.XString;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;


@RestController
@CrossOrigin //类上加
public class DemoController {


    @Rumenz("入门小站")
    private String name="test";

    @GetMapping("/")
    public String index() {
        System.out.println("hello "+name);
        return "{\"code\":200,\"msg\":\"ok\",\"data\":[\"JSON.IM\",\"json格式化\"]}";
    }


}
