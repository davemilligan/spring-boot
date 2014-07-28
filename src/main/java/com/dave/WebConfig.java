package com.dave;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

  /**
    *  Total customization - Path Parameter Accept [PPA] strategy.. . first one wins!
    *  favorPathExtension - allows path.json/path.xm to define format
    *  favorParameter - overrides pathExtension if ?content-type=format
    *  ignoreAcceptHeader - causes the app to ignore any format defined in headers,
    *  the remainder should be straightforward.
    *  
    */
  @Override
  public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
    configurer.favorPathExtension(false).
            favorParameter(true).
            parameterName("content-type").
            ignoreAcceptHeader(true).
            useJaf(false).
            defaultContentType(MediaType.APPLICATION_JSON).
            mediaType("xml", MediaType.APPLICATION_XML).
            mediaType("json", MediaType.APPLICATION_JSON);
  }
}
