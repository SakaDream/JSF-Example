package com.sakadream.jsf.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Phan Ba Hai on 18/07/2017.
 */

@WebFilter(filterName = "AuthFilter", urlPatterns = {"*.xhtml"})
public class AuthorizationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            HttpServletRequest req = (HttpServletRequest) request;
            HttpServletResponse res = (HttpServletResponse) response;
            HttpSession session = req.getSession();

            String reqUri = req.getRequestURI();
            if(reqUri.indexOf("/login.xhtml") >= 0
                    || reqUri.indexOf("/home-guest.xhtml") >= 0
                    || (session != null && session.getAttribute("username") != null)
                    || reqUri.indexOf("/public/") >= 0
                    || reqUri.contains("javax.faces.resource"))
                chain.doFilter(request, response);
            else res.sendRedirect(req.getContextPath() + "/login.xhtml");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void destroy() {

    }
}
