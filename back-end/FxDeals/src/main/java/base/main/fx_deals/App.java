package base.main.fx_deals;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling
@SpringBootApplication
@ComponentScan(basePackages = "base.main.fx_deals")
public class App extends SpringBootServletInitializer{
	
    public App() {
		super();
	    setRegisterErrorPageFilter(false);
	}

	public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);
    }
}
