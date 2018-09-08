//package com.tecsoluction.azar;
//
//import javax.servlet.ServletContext;
//import javax.servlet.ServletRegistration;
//
//import org.springframework.web.WebApplicationInitializer;
//import org.springframework.web.context.ContextLoaderListener;
//import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
//import org.springframework.web.servlet.DispatcherServlet;
//
//
//public class MyWebAppInitializer implements WebApplicationInitializer {
//    
//	
//	@Override
//    public void onStartup(ServletContext container) {
//        
//		
//		AnnotationConfigWebApplicationContext context= new AnnotationConfigWebApplicationContext();
//        
//		context.register(MyWebMvcConfigurerAdapter.class);
//		context.setConfigLocation("com.tecsoluction.azar");
//		container.setInitParameter("spring.profiles.default", "dev");
//        container.addListener(new ContextLoaderListener(context));
// 
//        ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", new DispatcherServlet(context));
//      
// 
//        
//        dispatcher.setLoadOnStartup(1);
//        dispatcher.addMapping("/");
//    }
//}
