package io.hankki.auth.domain.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SimpleCORSFilter implements Filter {

       public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
    	   log.info("SimpleCORSFilter doFilter");
           HttpServletResponse response = (HttpServletResponse) res;
           response.setHeader("Access-Control-Allow-Origin", "*");
           response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
           response.setHeader("Access-Control-Max-Age", "3600");
           response.setHeader("Access-Control-Allow-Headers", "x-requested-with, content-type");
           
           chain.doFilter(req, res);
       }

       public void init(FilterConfig filterConfig) {
    	   log.info("SimpleCORSFilter init");
       }

       public void destroy() {}

   }
