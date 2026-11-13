
package com.studentmanagement.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

public class RequestLoggingFilter implements Filter {

    // Called when the filter is initialized
    @Override
    public void init(jakarta.servlet.FilterConfig filterConfig)
            throws ServletException {

        System.out.println("RequestLoggingFilter initialized");
    }

    // Called for every matching HTTP request
    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain
    ) throws IOException, ServletException {

        HttpServletRequest httpRequest =
                (HttpServletRequest) request;

        String method = httpRequest.getMethod();
        String uri = httpRequest.getRequestURI();
        String clientIp = httpRequest.getRemoteAddr();

        long startTime = System.currentTimeMillis();

        System.out.println("========== REQUEST START ==========");
        System.out.println("HTTP Method : " + method);
        System.out.println("Request URI : " + uri);
        System.out.println("Client IP   : " + clientIp);

        try {
            // Pass request to the next filter or servlet
            chain.doFilter(request, response);

        } finally {
            long endTime = System.currentTimeMillis();
            long processingTime = endTime - startTime;

            System.out.println("Processing Time : "
                    + processingTime + " ms");

            System.out.println("========== REQUEST END ==========");
        }
    }

    // Called when the filter is destroyed
    @Override
    public void destroy() {

        System.out.println("RequestLoggingFilter destroyed");
    }
}
