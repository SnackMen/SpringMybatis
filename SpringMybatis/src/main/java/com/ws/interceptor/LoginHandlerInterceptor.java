package com.ws.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//自定义拦截器，当用户访问需要登录之后才能查看的页面，页面可以自动跳转到登录页面
public class LoginHandlerInterceptor  extends HandlerInterceptorAdapter{

    //不针对一下路径进行页面拦截
    String NO_INTERCEPTOR_PATH = ".*/((login)|(reg)|(logout)|(code)|(app)|(weixin)|(static)|(main)|(websocket)).*";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        String path = request.getServletPath();
        if (path.matches(NO_INTERCEPTOR_PATH)) {    //匹配正则表达式的不拦截
            return true;
        } else {    //不匹配的进行处理
            try {
                if (request.getSession().getAttribute("userInfo") == null) { //session中是否存在用户信息，不存在则是未登录状态
                    response.sendRedirect(request.getContextPath() + "/userAction/login");
                    return false;
                }
            } catch (IOException e) {
                response.sendRedirect(request.getContextPath() + "/userAction/login");
                e.printStackTrace();
                return false;
            }
        }
        return true;    //默认是不拦截···当然具体的还看一些需求设计啊  之类的
    }
}
