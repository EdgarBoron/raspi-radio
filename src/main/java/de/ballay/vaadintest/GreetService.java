package de.ballay.vaadintest;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class GreetService implements Serializable {
	
	private final static Logger logger = LoggerFactory.getLogger(GreetService.class);

    public String greet(String name) {
    	logger.info("Saying hello to " + name);
        if (name == null || name.isEmpty()) {
            return "Hello anonymous user";
        } else {
            return "Hello " + name;
        }
    }

}
