package example.springtesting.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyService {

    private final String applicationName;

    public MyService( @Value("${application.name}") String applicationName) {
        this.applicationName = applicationName;
    }


    public String getApplicationName(){
        return applicationName;
    }
}
