package com.dave;

/**
 * Tomcat
 * curl -H "Accept: application/xml" -X GET http://localhost:8080/greeting/1
 * curl -X GET http://localhost:8080/greeting/list
 * curl -H "Accept: application/json" -H "Content-type: application/json" -X POST -d '{"id":"1","content":"this is daves content"}' http://localhost:8080/greeting/
 * curl -H "Accept: application/json" -H "Content-type: application/json" -X PUT -d '{"id":"1","content":"this is daves content"}' http://localhost:8080/greeting/
 * curl -H "Accept: application/xml" -X DELETE http://localhost:8080/greeting/1
 * curl -H "Accept: application/json" -X DELETE http://localhost:8080/greeting/
 */

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private static final String createTemplate = "Created, %s!";
    private static final String readTemplate = "Hello for %s time!";
    private static final String updateTemplate = "Updated, %s!";
    private static final String deleteTemplate = "Deleted, %s!";
    private final AtomicLong readCounter = new AtomicLong();
 
    
    @RequestMapping(value = "/", method = RequestMethod.POST, produces={"application/json", "application/xml"})
    public Message create(@RequestBody(required=true) Greeting greeting) {
    	return new Message(String.format(createTemplate, greeting.getId()));
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces={"application/json", "application/xml"})
    public Greeting read(@PathVariable long id) {
    	return new Greeting(id, String.format(readTemplate, readCounter.incrementAndGet()));
    }
    
    @RequestMapping(value = "/list", method = RequestMethod.GET, produces={"application/json", "application/xml"})
    public List<Greeting> read() {
        return new ArrayList<Greeting>();
    }
    
    @RequestMapping(value = "/", method = RequestMethod.PUT, produces={"application/json", "application/xml"})
    public Message update(@RequestBody(required=true) Greeting greeting) {
    	return new Message(String.format(updateTemplate, greeting.getId()));
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces={"application/json", "application/xml"})
    public Message delete(@PathVariable long id) {
    	return new Message(String.format(deleteTemplate, id));
    }
    
    @RequestMapping(value = "/", method = RequestMethod.DELETE, produces={"application/json", "application/xml"})
    public Message delete() {
    	return new Message("All deleted");
    }
}
