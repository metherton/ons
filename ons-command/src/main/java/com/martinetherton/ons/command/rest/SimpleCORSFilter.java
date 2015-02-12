package com.martinetherton.ons.command.rest;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by martin on 28/10/14.
 */
@Component
public class SimpleCORSFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        HttpServletRequest request = (HttpServletRequest) req;

        String origin = request.getHeader("Origin");
      //  response.addHeader("Access-Control-Allow-Origin", "MACBOOKPRO-F7A9");
        response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");

        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.addHeader("Access-Control-Allow-Headers", "Content-Type");
        response.addHeader("Access-Control-Allow-Headers", "Origin");
        response.addHeader("Access-Control-Allow-Headers", "Access-Control-Allow-Origin");
        response.addHeader("Access-Control-Allow-Headers", "Access-Control-Allow-Credentials");

        response.setHeader("Access-Control-Allow-Origin", origin);
        response.setHeader("Vary", "Origin");
   //     Vary: Accept-Encoding, Origin
        if (request.getMethod() != "OPTIONS" ) {
            chain.doFilter(req, res);
       } else {

       }


    }

    @Override
    public void destroy() {

    }
}
