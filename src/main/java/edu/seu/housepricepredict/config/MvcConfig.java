package edu.seu.housepricepredict.config;

import edu.seu.housepricepredict.interceptor.AdminHandlerInterceptor;
import edu.seu.housepricepredict.interceptor.UserHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
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
        registry.addViewController("/index").setViewName("index");

        //跳转至城市页面
        registry.addViewController("/info/city").setViewName("info/city");

        //后台登录页面
        registry.addViewController("/adminIndex").setViewName("user/adminIndex");
    }

    /**
     * 注册拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册管理员拦截器，并设置拦截地址
        registry.addInterceptor(new AdminHandlerInterceptor()).addPathPatterns("/adminIndex");
        //注册用户拦截器
        registry.addInterceptor(new UserHandlerInterceptor()).addPathPatterns("/user/**").
                excludePathPatterns("/user/login", "/user/register");
    }
}
