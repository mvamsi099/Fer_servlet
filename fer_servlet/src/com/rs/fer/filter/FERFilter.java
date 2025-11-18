package com.rs.fer.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class FERFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
       
		System.out.println("FERFilter::init()");
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("FERFilter::doFilter()");
		
		Enumeration<String> parameterNames = request.getParameterNames(); 
		
		String parameterName = null;
		String parameterValues = null;
		boolean isSpecialCharExists = false;
		
		while (parameterNames.hasMoreElements()) {

			parameterName = parameterNames.nextElement();
			parameterValues = request.getParameter(parameterName);
			
			if(parameterValues.contains("~")) {
				
				isSpecialCharExists = true;
				break;
			}
			
		}
		
		if(isSpecialCharExists) {
			
			request.getRequestDispatcher("Error.html").include(request,response);
			
		}else {
			
			chain.doFilter(request, response);
		}
	}
	
	@Override
	public void destroy() {
		System.out.println("FERFilter::destroy()");
		
	}

}
