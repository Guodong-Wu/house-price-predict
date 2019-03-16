package edu.seu.housepricepredict.interceptor;


import edu.seu.housepricepredict.domain.user.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author guodonwu@163.com
 * @date 15:54 2019/3/13
 * 登录校验拦截器，对后台页面进行拦截
 */

public class AdminHandlerInterceptor implements HandlerInterceptor {

    /**
     * 目标方法执行前
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //从session中获取登录的用户信息
        User user = (User) request.getSession().getAttribute("user");
        //如果无用户登录，进行拦截
        if (user == null) {
            request.setAttribute("msg", "没有权限, 请先登录");
            request.getRequestDispatcher("/login").forward(request, response);
            return false;
        } else {
            //如果该用户不是管理员，进行拦截
            if (user.getIsAdmin() == 0) {
                request.setAttribute("msg", "没有权限");
                request.getRequestDispatcher("/login").forward(request, response);
                return false;
            }
        }

        //已用管理员账号登录，放行
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
