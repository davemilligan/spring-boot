package com.dave;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {
	
	private String text;
	
	public Message() {
	}
	
	public Message(String text) {
		this.text = text;
	}

	
	public String getText() {
		return text;
	}

	@XmlElement
	public void setText(String text) {
		this.text = text;
	}

}
