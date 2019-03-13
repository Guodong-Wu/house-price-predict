package edu.seu.housepricepredict.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author guodonwu@163.com
 * @date 14:53 2019/2/26
 * SpringMVC配置类
 */

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    /**
     * 设置欢迎页映射
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //浏览器发送 / 请求来到index(classpath:/template/index.html)
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/city").setViewName("city");
    }
}
