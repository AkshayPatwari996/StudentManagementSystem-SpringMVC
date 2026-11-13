
package com.studentmanagement.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class RequestAuditInterceptor implements HandlerInterceptor {

    // Executes before controller execution
    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler
    ) throws Exception {

        System.out.println("========== PRE HANDLE ==========");

        System.out.println("HTTP Method : " + request.getMethod());
        System.out.println("Request URI : " + request.getRequestURI());

        if (handler instanceof HandlerMethod handlerMethod) {

            System.out.println("Controller : "
                    + handlerMethod.getBeanType().getSimpleName());

            System.out.println("Method : "
                    + handlerMethod.getMethod().getName());
        }

        // true allows the request to continue
        return true;
    }

    // Executes after controller execution, before view rendering
    @Override
    public void postHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler,
            ModelAndView modelAndView
    ) throws Exception {

        System.out.println("========== POST HANDLE ==========");
        System.out.println("Controller execution completed");
    }

    // Executes after request processing is completed
    @Override
    public void afterCompletion(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler,
            Exception ex
    ) throws Exception {

        System.out.println("========== AFTER COMPLETION ==========");

        if (ex != null) {
            System.out.println("Exception : " + ex.getMessage());
        } else {
            System.out.println("Request completed successfully");
        }
    }
}
