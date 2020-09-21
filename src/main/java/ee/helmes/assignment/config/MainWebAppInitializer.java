package ee.helmes.assignment.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;

import javax.servlet.*;
import java.util.EnumSet;

@Configuration
public class MainWebAppInitializer implements WebApplicationInitializer {
	@Override
	public void onStartup(ServletContext sc) throws ServletException {
		sc.setSessionTrackingModes(EnumSet.of(SessionTrackingMode.COOKIE));
		sc.getSessionCookieConfig().setHttpOnly(false);
		sc.getSessionCookieConfig().setSecure(false);
	}
}