package com.dave;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Greeting {

    private long id;
    private String content;

    public Greeting() {
    }
    
    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    @XmlAttribute
    public long getId() {
        return id;
    }
    
    @XmlElement
    public String getContent() {
        return content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    
    public void setId(long id) {
    	this.id = id;
    }
}
