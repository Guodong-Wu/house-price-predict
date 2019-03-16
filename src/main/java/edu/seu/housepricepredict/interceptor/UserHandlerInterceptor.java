package edu.seu.housepricepredict.interceptor;

import edu.seu.housepricepredict.domain.user.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author guodonwu@163.com
 * @date 21:46 2019/3/16
 */

public class UserHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //从session中获取登录的用户信息
        User user = (User) request.getSession().getAttribute("user");
        String requestURI = request.getRequestURI();
        String[] split = requestURI.split("/");
        //如果无用户登录，进行拦截
        if (user == null) {
            request.setAttribute("msg", "没有权限, 请先登录");
            request.getRequestDispatcher("/user/login").forward(request, response);
            return false;
        } else {
            //如果该用户是管理员，进行拦截 或者用的不是本人的账号，想修改别人的信息，拦截
            if (user.getIsAdmin() == 1 ||
                    Integer.parseInt(split[split.length-1]) != user.getUserId()) {
                request.setAttribute("msg", "没有权限");
                request.getRequestDispatcher("/user/login").forward(request, response);
                return false;
            }
        }
        //已用该用户账号登录，放行
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
