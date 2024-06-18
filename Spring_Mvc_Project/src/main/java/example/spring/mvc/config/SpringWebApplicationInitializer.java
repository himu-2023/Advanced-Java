package example.spring.mvc.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;

public class SpringWebApplicationInitializer implements WebApplicationInitializer{
private WebApplicationContext getContext() {
AnnotationConfigWebApplicationContext webCtx = new AnnotationConfigWebApplicationContext();
webCtx.setConfigLocations("example");
//The above code is equivalent to:@componentScan(basePackages="controller")
return webCtx;
}
@Override
public void onStartup(ServletContext servletContextRef) throws ServletException {
// This method gets called when the application is getting loaded
System.out.println("Application  being loaded coming onstartup");
WebApplicationContext webCtxRef= getContext();
DispatcherServlet frontContrllerRef=new DispatcherServlet(webCtxRef);

ServletRegistration.Dynamic registration=
servletContextRef.addServlet("frontController", frontContrllerRef);
registration.addMapping("/");
}
}
