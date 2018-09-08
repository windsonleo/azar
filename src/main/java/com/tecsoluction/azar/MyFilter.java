//package com.tecsoluction.azar;
//
//import java.io.IOException;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//
//@Component
//@Order(1)
//public class MyFilter implements Filter {
//	 
//	  /**
//	   * Logging todo o request da aplicação para auditoria
//	   */
//	  private final static Logger LOGGER = LoggerFactory.getLogger(MyFilter.class);
//	  
//	  @Override
//	  public void destroy() {
//	    LOGGER.warn("Destruindo o filtro de logging");
//	  }
//
//	@Override
//	public void doFilter(ServletRequest arg0, ServletResponse arg1, final FilterChain arg2)
//			throws IOException, ServletException {
//		arg2.doFilter(arg0, arg1);
//		
//	}
//
//	@Override
//	public void init(FilterConfig arg0) throws ServletException {
//		  LOGGER.info("Iniciando filtro de logging");		
//	}
//}
