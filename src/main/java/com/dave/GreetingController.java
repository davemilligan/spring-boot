package com.dave;

/**
 * Tomcat
 * curl -X GET http://localhost:8080/1
 * curl -H "Accept: application/json" -H "Content-type: application/json" -X POST -d '{"id":"1","content":"this is daves content"}' http://localhost:8080/greeting/
 * curl -H "Accept: application/json" -H "Content-type: application/json" -X PUT -d '{"id":"1","content":"this is daves content"}' http://localhost:8080/greeting/1
 * curl -X DELETE http://localhost:8080/greeting/1
 */

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private static final String createTemplate = "Hello, %s!";
    private static final String deleteTemplate = "Deleted, %s!";
    private final AtomicLong counter = new AtomicLong();
 
    
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Greeting create(@RequestBody(required=true) Greeting greeting) {
    	greeting.setContent("Greeting received!");
    	return greeting;
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Greeting read(@PathVariable long id) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(createTemplate, id));
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Greeting update(@PathVariable long id, @RequestBody(required=true) Greeting greeting) {
    	greeting.setContent("Greeting updated!");
    	return greeting;
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Greeting delete(@PathVariable long id) {
    	return new Greeting(counter.incrementAndGet(),
                String.format(deleteTemplate, id));
    }
}
